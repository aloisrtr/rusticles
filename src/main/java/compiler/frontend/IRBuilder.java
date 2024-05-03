package compiler.frontend;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import ir.core.*;
import ir.terminator.IRCondBr;
import org.antlr.v4.runtime.tree.ParseTree;
import antlr.SimpleCBaseVisitor;
import antlr.SimpleCParser.*;
import ir.instruction.IRAddInstruction;
import ir.instruction.IRCompareGtInstruction;
import ir.instruction.IRCompareLtInstruction;
import ir.instruction.IRConstantInstruction;
import ir.instruction.IRDivInstruction;
import ir.instruction.IRFunctionCallInstruction;
import ir.instruction.IRMulInstruction;
import ir.instruction.IRSubInstruction;
import ir.terminator.IRGoto;
import ir.terminator.IRReturn;
import ir.terminator.IRTerminator;

public class IRBuilder extends SimpleCBaseVisitor<BuilderResult> {
	IRTopLevel top = null;
	IRFunction currentFunction = null;
	IRBlock currentBlock = null;
	SymbolTable symbolTable = new SymbolTable();
	boolean inFunctionBlock = true;

	public static IRTopLevel buildTopLevel(ParseTree t) {
		IRBuilder builder = new IRBuilder();
		builder.visit(t);
		return builder.top;
	}

	public IRBuilder() {}

	/// Translates a type context into the corresponding IRType variant.
	IRType translateType(TypeContext t) {
		if (t instanceof IntTypeContext) {
			return IRType.INT;
		} else if (t instanceof VoidTypeContext) {
			return IRType.VOID;
		} else if (t instanceof BoolTypeContext) {
			return IRType.BOOL;
		} else if (t == null) {
			return IRType.ANY;
		}
		return null;
	}

	/// Visits all functions in the translation unit.
	@Override
	public BuilderResult visitTranslationUnit(TranslationUnitContext ctx) {
		top = new IRTopLevel();
		for (ParseTree function : ctx.children) {
			this.visit(function);
		}
		// Useless -> we return null
		return null;
	}

	@Override
	public BuilderResult visitFunDef(FunDefContext ctx) {
		// We build the list of arg types
		List<IRType> argTypes = new ArrayList<>();
		List<String> argNames = new ArrayList<>();
		for (FunArgContext a : ctx.args) {
			argTypes.add(translateType(a.argType));
			argNames.add(a.name.getText());
		}

		// We instantiate a new function and add it in the toplevel with its own block.
		IRFunction func = new IRFunction(ctx.name.getText(), translateType(ctx.returnType), argTypes);
		top.addFunction(func);
		currentFunction = func;
		this.currentBlock = currentFunction.addBlock();

		List<IRValue> args_value = func.getArgs();
		for (int i = 0; i < args_value.size(); i++) {
			symbolTable.insert(argNames.get(i), this.currentBlock, args_value.get(i));
		}
		this.currentBlock.seal(this.symbolTable);

		// We just visit the body
		this.inFunctionBlock = true;
		BuilderResult res = this.visit(ctx.body);

		// Check the return type
		if (res != null && res.value.type != IRType.RETURN) {
			this.typeInference(currentFunction.getReturnType(), res.value);

			if (res.value != null) {
				if (res.value.getType() == IRType.VOID) {
					res.exit.addTerminator(new IRReturn(null));
				} else if (res.value.getType() != IRType.RETURN) {
					res.exit.addTerminator(new IRReturn(res.value));
				}
			} else if (res.exit.getTerminator() == null) {
				res.exit.addTerminator(new IRReturn(null));
			}
		}

		// Don't care about the value returned
		return null;
	}

	@Override
	public BuilderResult visitBlock(BlockContext ctx) {
		// We create a new block, save it as entry point and current point (since it is the sole block for now)
		IRBlock entry = this.currentBlock;
		if (!this.inFunctionBlock) {
			entry = this.currentFunction.addBlock();
		} else {
			this.inFunctionBlock = false;
		}
		this.currentBlock = entry;

		// Visit all children
		for (ParseTree statement : ctx.statements) {
			BuilderResult statement_build = this.visit(statement);
			if (statement_build.hasBlock) {
				// Connect our current block with the new ones
				this.currentBlock.addTerminator(new IRGoto(statement_build.entry));
				// Create a new block
				this.currentBlock = currentFunction.addBlock();
				// And connect the exit point of our statement to our new current block.
				statement_build.exit.addTerminator(new IRGoto(this.currentBlock));
				// Nothing new is going to be added, so we can safely seal the exit block
				// and entry block.
				statement_build.entry.seal(this.symbolTable);
				statement_build.exit.seal(this.symbolTable);
			}
		}

		// Handle the return value of the block.
		IRValue returned;
		if (ctx.lastexpr != null) {
			BuilderResult res = this.visit(ctx.lastexpr);
			returned = res.value;
		} else {
			returned = new IRValue(IRType.VOID, null);
		}

		// We do have at least one block, our entry and current block, and a possible value.
		return new BuilderResult(true, entry, this.currentBlock, returned);
	}


	/****************************************************************************
	 *  Return/call statements
	 *
	 ****************************************************************************/

	@Override
	public BuilderResult visitReturnExpr(ReturnExprContext ctx) {
		BuilderResult res = this.visit(ctx.body);

		IRReturn newInstr = new IRReturn(res.value);
		currentBlock.addOperation(newInstr);

		this.typeInference(currentFunction.getReturnType(), res.value);
		
		return new BuilderResult(res.hasBlock, res.entry, res.exit, new IRValue(IRType.RETURN, null));
	}

	@Override
	public BuilderResult visitFunCallExpr(FunCallExprContext ctx) {
		// We gather arg values
		ArrayList<IRValue> args = new ArrayList<>();
		for (ParseTree c : ctx.args) {
			BuilderResult res = this.visit(c);
			args.add(res.value);
		}

		IRType returnType = null;
		IRFunction func = null;
		for (IRFunction f : top.getFunctions()) {
			if (f.getName().equals(ctx.name.getText())) {
				returnType = f.getReturnType();
				func = f;
			}
		}
		IRFunctionCallInstruction funcCall = new IRFunctionCallInstruction(func, returnType, args);
		currentBlock.addOperation(funcCall);

		return new BuilderResult(true, null, null, funcCall.getResult());
	}

	/****************************************************************************
	 *  Control flow statements
	 *
	 ****************************************************************************/
	@Override
	public BuilderResult visitIfExpr(IfExprContext ctx) {
		// We get the beginning block
		IRBlock begin = currentBlock;
		begin.seal(this.symbolTable);

		// Visit of the condition, if and else blocks
		BuilderResult cond = this.visit(ctx.cond);
		BuilderResult if_block = this.visit(ctx.ifBody);

		if (ctx.elseBody == null) {
			// Creation End block
			IRBlock end = currentFunction.addBlock();
			IRGoto gotoEnd = new IRGoto(end);

			// Cond false we connect directly to the end block
			IRCondBr condBr = new IRCondBr(cond.value, if_block.entry, end);
			currentBlock = begin;
			currentBlock.addTerminator(condBr);

			// Link if and else blocks to the End block
			if_block.entry.seal(this.symbolTable);
			if_block.exit.seal(this.symbolTable);
			if_block.exit.addTerminator(gotoEnd);
			end.seal(this.symbolTable);

			// Check that if and else blocks have the same type
			if (if_block.value.getType() != IRType.VOID && if_block.value.getType() != IRType.RETURN) {
				throw new RuntimeException("Else block is empty If block must have type Void here");
			}
			currentBlock = end;

			return new BuilderResult(true, begin, end, new IRValue(IRType.VOID, null));
		}

		IRBlock entry_else_block = currentFunction.addBlock();
		currentBlock = entry_else_block;
		BuilderResult else_block = this.visit(ctx.elseBody);

		if (else_block.entry == null) {
			throw new RuntimeException("Else block is not empty but the entry block is null");
		}

		IRCondBr condBr = new IRCondBr(cond.value, if_block.entry, else_block.entry);

		begin.addTerminator(condBr);
		if_block.entry.seal(this.symbolTable);
		if_block.exit.seal(this.symbolTable);
		else_block.entry.seal(this.symbolTable);
		else_block.exit.seal(this.symbolTable);

		currentBlock = begin;

		// Creation End block
		IRBlock end = currentFunction.addBlock();
		IRGoto gotoEnd = new IRGoto(end);

		// Link if to the End block
		if_block.exit.addTerminator(gotoEnd);

		// Link else to the End block
		else_block.exit.addTerminator(gotoEnd);
		end.seal(this.symbolTable);

		// Check that if and else blocks have the same type
		if (if_block.value.getType() != else_block.value.getType()) {
			throw new RuntimeException("If and else blocks must have the same type");
		}
		// Recuperation of the phi value out of the if and else blocks
		IRPhiOperation phiIfElse = new IRPhiOperation(if_block.value.getType());
		phiIfElse.addOperand(if_block.value);

		phiIfElse.addOperand(else_block.value);

		// Add Phi Operation of then and else value to the end block
		end.addOperation(phiIfElse);
		currentBlock = end;

		return new BuilderResult(false, begin, end, phiIfElse.getResult());
	}

	@Override
	public BuilderResult visitForExpr(ForExprContext ctx) {
		BuilderResult begin = this.visit(ctx.begin);
		// BuilderResult end = this.visit(ctx.end);
		// BuilderResult body = this.visit(ctx.body);
		// this.symbolTable.insert(ctx.name.getText(), begin.value);
		return new BuilderResult(true, null, null, new IRValue(IRType.VOID, null));
	}

	@Override
	public BuilderResult visitWhileExpr(WhileExprContext ctx) {
		// Create the entry block, where our initial values will be created.
		IRBlock entry = this.currentBlock;
		this.currentBlock.seal(this.symbolTable);

		// Our header is the one going to check if the loop should continue or not.
		IRBlock header = this.currentFunction.addBlock();
		entry.addTerminator(new IRGoto(header));
		this.currentBlock = header;
		BuilderResult header_build = this.visit(ctx.condition);

		// Visiting the body then creates its entry and exit nodes.
		BuilderResult body_build = this.visit(ctx.body);

		// We link everything nice and tidy then.
		IRBlock exit = this.currentFunction.addBlock();
		body_build.exit.addTerminator(new IRGoto(header));
		header.seal(this.symbolTable);
		header.addTerminator(new IRCondBr(header_build.value, body_build.entry, exit));
		body_build.entry.seal(this.symbolTable);
		body_build.exit.seal(this.symbolTable);
		exit.seal(this.symbolTable);
		this.currentBlock = exit;

		return new BuilderResult(true, entry, exit, new IRValue(IRType.VOID, null));
	}

	/****************************************************************************
	 *  Non-control flow statements
	 *
	 ****************************************************************************/
	@Override
	public BuilderResult visitVarDefExpr(VarDefExprContext ctx) {
		IRType expected_type = this.translateType(ctx.t);
		BuilderResult res = this.visit(ctx.body);
		IRValue value = res.value;

		this.typeInference(expected_type, value);

		// Add to the current symbol table the new variable
		// Add of the IRValue in the current block
		this.symbolTable.insert(ctx.name.getText(), this.currentBlock, value);

		return new BuilderResult(res.hasBlock, null, null, new IRValue(IRType.VOID, null));
	}

	@Override
	public BuilderResult visitAssign(AssignContext ctx) {
		// We get the value of the body
		BuilderResult res = this.visit(ctx.body);
		// We change the symbol table such as the variable is updated
		// the value is res.value
		symbolTable.insert(ctx.name.getText(), this.currentBlock, res.value);

		return new BuilderResult(res.hasBlock, null, null, new IRValue(IRType.VOID, null));
	}

	@Override
	public BuilderResult visitIntExpr(IntExprContext ctx) {
		Integer val = Integer.parseInt(ctx.children.getFirst().getText());

		IRConstantInstruction<Integer> instr = new IRConstantInstruction<>(IRType.INT, val);

		currentBlock.addOperation(instr);

		return new BuilderResult(false, null, null, instr.getResult());
	}

	public BuilderResult visitBoolExpr(BoolExprContext ctx) {
		Integer val = ctx.getText().equals("true") ? 1 : 0;
		IRConstantInstruction<Integer> instr = new IRConstantInstruction<>(IRType.BOOL, val);
		currentBlock.addOperation(instr);
		return new BuilderResult(false, null, null, instr.getResult());
	}

	@Override
	public BuilderResult visitIdExpr(IdExprContext ctx) {
		// Key function for having SSA working properly
		return new BuilderResult(false, null, null, this.symbolTable.lookup(ctx.getText(), this.currentBlock));
	}

	@Override
	public BuilderResult visitNegExpr(NegExprContext ctx) {
		BuilderResult res = this.visit(ctx.body);

		IRConstantInstruction<Integer> zeroCst = new IRConstantInstruction<>(IRType.INT, 0);
		IRSubInstruction instr = new IRSubInstruction(zeroCst.getResult(), res.value);
		currentBlock.addOperation(zeroCst);
		currentBlock.addOperation(instr);

		return new BuilderResult(res.hasBlock, null, null, instr.getResult());
	}

	@Override
	public BuilderResult visitAddExpr(AddExprContext ctx) {
		BuilderResult lhs = this.visit(ctx.lhs);
		BuilderResult rhs = this.visit(ctx.rhs);

		this.typeInference(lhs.value, rhs.value);

		IRAddInstruction instr = new IRAddInstruction(lhs.value, rhs.value);
		currentBlock.addOperation(instr);

		return new BuilderResult(lhs.hasBlock || rhs.hasBlock, null, null, instr.getResult());
	}

	@Override
	public BuilderResult visitSubExpr(SubExprContext ctx) {
		BuilderResult lhs = this.visit(ctx.lhs);
		BuilderResult rhs = this.visit(ctx.rhs);
		
		this.typeInference(lhs.value, rhs.value);

		IRSubInstruction instr = new IRSubInstruction(lhs.value, rhs.value);
		currentBlock.addOperation(instr);

		return new BuilderResult(lhs.hasBlock || rhs.hasBlock, null, null, instr.getResult());
	}

	@Override
	public BuilderResult visitMulExpr(MulExprContext ctx) {
		BuilderResult lhs = this.visit(ctx.lhs);
		BuilderResult rhs = this.visit(ctx.rhs);

		this.typeInference(lhs.value, rhs.value);

		IRMulInstruction instr = new IRMulInstruction(lhs.value, rhs.value);
		currentBlock.addOperation(instr);

		return new BuilderResult(lhs.hasBlock || rhs.hasBlock, null, null, instr.getResult());
	}

	@Override
	public BuilderResult visitDivExpr(DivExprContext ctx) {
		BuilderResult lhs = this.visit(ctx.lhs);
		BuilderResult rhs = this.visit(ctx.rhs);

		this.typeInference(lhs.value, rhs.value);

		IRDivInstruction instr = new IRDivInstruction(lhs.value, rhs.value);
		currentBlock.addOperation(instr);

		return new BuilderResult(lhs.hasBlock || rhs.hasBlock, null, null, instr.getResult());
	}

	@Override
	public BuilderResult visitLthExpr(LthExprContext ctx) {
		BuilderResult lhs = this.visit(ctx.lhs);
		BuilderResult rhs = this.visit(ctx.rhs);

		this.typeInference(lhs.value, rhs.value);

		IRCompareLtInstruction instr = new IRCompareLtInstruction(lhs.value, rhs.value);
		currentBlock.addOperation(instr);

		return new BuilderResult(lhs.hasBlock || rhs.hasBlock, null, null, instr.getResult());
	}

	@Override
	public BuilderResult visitGthExpr(GthExprContext ctx) {
		BuilderResult lhs = this.visit(ctx.lhs);
		BuilderResult rhs = this.visit(ctx.rhs);

		this.typeInference(lhs.value, rhs.value);

		IRCompareGtInstruction instr = new IRCompareGtInstruction(lhs.value, rhs.value);
		currentBlock.addOperation(instr);

		return new BuilderResult(lhs.hasBlock || rhs.hasBlock, null, null, instr.getResult());
	}

	@Override
	public BuilderResult visitParenExpr(ParenExprContext ctx) {
		return this.visit(ctx.body);
	}

	private void typeInference(IRValue a, IRValue b) {
		if (a == null && b != null) {
			throw new RuntimeException("Type inference failed: " + a + " is of type " + IRType.VOID + " while " + b + " is of type" + b.type);
		} else if (a != null && b == null) {
			throw new RuntimeException("Type inference failed: " + a + " is of type " + a.type + " while " + b + " is of type" + IRType.VOID);
		}
		
		if (a.type == IRType.ANY) {
			a.type = b.type;
		} else if (b.type == IRType.ANY) {
			b.type = a.type;
		} else if (a.type != b.type) {
			throw new RuntimeException("Type inference failed: " + a + " is of type " + a.type + " while " + b + " is of type" + b.type);
		}
	}
	private void typeInference(IRType expected, IRValue actual) {
		if (actual == null && expected != IRType.VOID) {
			throw new RuntimeException("Type inference failed: " + actual + " is of type " + IRType.VOID + " but expected " + expected);
		}
		
		if (actual.type == IRType.ANY) {
			actual.type = expected;
		} else if (expected != IRType.ANY && actual.type != expected) {
			throw new RuntimeException("Type inference failed: " + actual + " is of type " + actual.type + " but expected " + expected);
		}
	}
}
