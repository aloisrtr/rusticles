package compiler.frontend;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import ir.core.*;
import jdk.jfr.Unsigned;
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

public class IRBuilder extends SimpleCBaseVisitor<BuilderResult> {
	IRTopLevel top = null;
	IRFunction currentFunction = null;
	IRBlock currentBlock = null;
	SymbolTable symbolTable;

	public static IRTopLevel buildTopLevel(ParseTree t) {
		IRBuilder builder = new IRBuilder();
		builder.visit(t);
		return builder.top;
	}

	public IRBuilder() {
		symbolTable = new SymbolTable();
	}

	/// Translates a type context into the corresponding IRType variant.
	IRType translateType(TypeContext t) {
		if (t instanceof IntTypeContext) {
			return IRType.INT;
		} else if (t instanceof UintTypeContext) {
			return IRType.UINT;
		} else if (t instanceof VoidTypeContext) {
			return IRType.VOID;
		} else if (t instanceof BoolTypeContext) {
			return IRType.BOOL;
		}
		return null;
	}

	/// Visits all functions in the translation unit.
	@Override
	public BuilderResult visitTranslationUnit(TranslationUnitContext ctx) {
		top = new IRTopLevel();
		for (ParseTree function : ctx.children) {
			this.symbolTable = this.symbolTable.initializeScope();
			this.visit(function);
			this.symbolTable = this.symbolTable.finalizeScope().get();
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

		// We instantiate a new function and add it in the toplevel
		IRFunction func = new IRFunction(ctx.name.getText(), translateType(ctx.returnType), argTypes);

		List<IRValue> args_value = func.getArgs();
		for (int i = 0; i < args_value.size(); i++) {
			symbolTable.insert(argNames.get(i), args_value.get(i));
		}

		top.addFunction(func);

		// We mark the newly created function as currentFunction : blocks will be added inside
		currentFunction = func;

		// We just visit the body
		visitBlock(ctx.body);
		// Don't care about the value returned
		return null;
	}
	@Override
	public BuilderResult visitBlock(BlockContext ctx) {
		// We create a new block, save it as in point and current point
		IRBlock in =  currentFunction.addBlock();
		IRBlock current = in;
		currentBlock = current;

		// Create the symbol table for this.
		this.symbolTable = this.symbolTable.initializeScope();

		// Visit all children
		for (ParseTree c : ctx.statements) {
			BuilderResult res = this.visit(c);
			if (res != null) {
				current = res.entry;
			}
		}
		if (ctx.lastexpr != null) {
			BuilderResult res = this.visit(ctx.lastexpr);
			currentBlock.addTerminator(new IRReturn(res.value));
		} else {
			currentBlock.addTerminator(new IRReturn(null));
		}

		// Finalize the current symbol table level
		this.symbolTable = this.symbolTable.finalizeScope().get();

		return new BuilderResult(true, in, current, null);
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
		return new BuilderResult(false, null, null, null);
	}

	@Override
	public BuilderResult visitFunCallExpr(FunCallExprContext ctx) {
		// We gather arg values
		ArrayList<IRValue> args = new ArrayList<>();
		for (ParseTree c : ctx.args) {
			BuilderResult res = this.visit(c);
			args.add(res.value);
		}

		IRType returnType = IRType.UINT;
		IRFunction func = null;
		for (IRFunction f : top.getFunctions()) {
			if (f.getName().equals(ctx.name.getText())) {
				returnType = f.getReturnType();
				func = f;
			}
		}
		IRFunctionCallInstruction funcCall = new IRFunctionCallInstruction(func, returnType, args);
		currentBlock.addOperation(funcCall);

		return new BuilderResult(false, null, null, funcCall.getResult());
	}

	/****************************************************************************
	 *  Control flow statements
	 *
	 ****************************************************************************/
	@Override
	public BuilderResult visitIfExpr(IfExprContext ctx) {
		BuilderResult cond = this.visit(ctx.cond);
		cond.hasBlock = true;
		cond.entry = this.currentBlock;
		BuilderResult if_block = this.visit(ctx.ifBody);
		BuilderResult continuation_block = this.visit(ctx.elseBody);
		return new BuilderResult(true, cond.entry, null, null); // TODO: phi value
	}

	@Override
	public BuilderResult visitForExpr(ForExprContext ctx) {
		BuilderResult begin = this.visit(ctx.begin);
		BuilderResult end = this.visit(ctx.end);
		BuilderResult body = this.visit(ctx.body);
		this.symbolTable.insert(ctx.name.getText(), begin.value);
		return new BuilderResult(true, null, null, null);
	}

	@Override
	public BuilderResult visitWhileExpr(WhileExprContext ctx) {
		IRBlock in = this.currentBlock;
		IRBlock condBlock = currentFunction.addBlock();
		this.currentBlock = condBlock;
		BuilderResult cond = this.visit(ctx.condition);
		BuilderResult body = this.visit(ctx.body);
		return new BuilderResult(true, in, condBlock, null);
	}

	/****************************************************************************
	 *  Non-control flow statements
	 *
	 ****************************************************************************/
	@Override
	public BuilderResult visitVarDefExpr(VarDefExprContext ctx) {
		IRType type = translateType(ctx.t);

		BuilderResult res = this.visit(ctx.body);
		IRValue value = res.value;

		// Add to the current symbol table the new variable
		// Add of the IRValue in the current block
		this.symbolTable.insert(ctx.name.getText(), value);

		return new BuilderResult(false, null, null, null);
	}

	@Override
	public BuilderResult visitAssign(AssignContext ctx) {
		// We get the value of the body
		BuilderResult res = this.visit(ctx.body);
		// We change the symbol table such as the variable is updated
		// the value is res.value
		// we have to create a new variable to have the SSA form
		if (symbolTable.lookup(ctx.name.getText()).isEmpty()) {
			throw new RuntimeException("Variable " + ctx.name.getText() + " not found in symbol table");
		}

		symbolTable.insert(ctx.name.getText(), res.value);

		return new BuilderResult(false, null, null, null);
	}

	@Override
	public BuilderResult visitIntExpr(IntExprContext ctx) {
		Integer val = Integer.parseInt(ctx.children.getFirst().getText());

		IRConstantInstruction<Integer> instr = new IRConstantInstruction<>(IRType.INT, val);

		currentBlock.addOperation(instr);

		return new BuilderResult(false, null, null, instr.getResult());
	}

	@Override
	public BuilderResult visitUintExpr(UintExprContext ctx) {
		Integer val = Integer.parseUnsignedInt(ctx.children.getFirst().getText());
		IRConstantInstruction<Integer> instr = new IRConstantInstruction<>(IRType.UINT, val);
		currentBlock.addOperation(instr);
		return new BuilderResult(false, null, null, instr.getResult());
	}

	public BuilderResult visitBoolExpr(BoolExprContext ctx) {
		Integer val = Objects.equals(ctx.children.getFirst().getText(), "true") ? 1 : 0;
		IRConstantInstruction<Integer> instr = new IRConstantInstruction<>(IRType.BOOL, val);
		currentBlock.addOperation(instr);
		return new BuilderResult(false, null, null, instr.getResult());
	}

	@Override
	public BuilderResult visitIdExpr(IdExprContext ctx) {
		// Key function for having SSA working properly
		Optional<VariableInfo> entry = symbolTable.lookup(ctx.name.getText());
		if (entry.isPresent()) {

			IRValue val = entry.get().value;
			if (currentBlock.getPredecessors().size() > 1) {
				IRPhiOperation phi = new IRPhiOperation(val.getType());
				for (IRBlock pred : phi.getContainingBlock().getPredecessors()) {
					phi.addOperand(symbolTable.parent.lookup(ctx.name.getText()).get().value);
				}
				val = phi.getResult();
			}
			return new BuilderResult(false, null, null, val);


		} else {
			throw new RuntimeException("Variable " + ctx.name.getText() + " not found in symbol table");
		}
	}

	@Override
	public BuilderResult visitNegExpr(NegExprContext ctx) {
		BuilderResult res1 = ctx.body.accept(this);

		IRConstantInstruction<Integer> zeroCst = new IRConstantInstruction<>(IRType.INT, 0);
		IRSubInstruction instr = new IRSubInstruction(zeroCst.getResult(), res1.value);
		currentBlock.addOperation(zeroCst);
		currentBlock.addOperation(instr);

		return new BuilderResult(false, null, null, instr.getResult());
	}

	@Override
	public BuilderResult visitAddExpr(AddExprContext ctx) {
		BuilderResult res1 = this.visit(ctx.lhs);
		BuilderResult res2 = this.visit(ctx.rhs);

		IRAddInstruction instr = new IRAddInstruction(res1.value, res2.value);
		currentBlock.addOperation(instr);

		return new BuilderResult(false, null, null, instr.getResult());
	}

	@Override
	public BuilderResult visitSubExpr(SubExprContext ctx) {
		BuilderResult res1 = this.visit(ctx.lhs);
		BuilderResult res2 = this.visit(ctx.rhs);

		IRSubInstruction instr = new IRSubInstruction(res1.value, res2.value);
		currentBlock.addOperation(instr);

		return new BuilderResult(false, null, null, instr.getResult());
	}

	@Override
	public BuilderResult visitMulExpr(MulExprContext ctx) {
		BuilderResult res1 = this.visit(ctx.lhs);
		BuilderResult res2 = this.visit(ctx.rhs);

		IRMulInstruction instr = new IRMulInstruction(res1.value, res2.value);
		currentBlock.addOperation(instr);

		return new BuilderResult(false, null, null, instr.getResult());
	}

	@Override
	public BuilderResult visitDivExpr(DivExprContext ctx) {
		BuilderResult res1 = this.visit(ctx.lhs);
		BuilderResult res2 = this.visit(ctx.rhs);

		IRDivInstruction instr = new IRDivInstruction(res1.value, res2.value);
		currentBlock.addOperation(instr);

		return new BuilderResult(false, null, null, instr.getResult());
	}

	@Override
	public BuilderResult visitLthExpr(LthExprContext ctx) {
		BuilderResult res1 = this.visit(ctx.lhs);
		BuilderResult res2 = this.visit(ctx.rhs);

		IRCompareLtInstruction instr = new IRCompareLtInstruction(res1.value, res2.value);
		currentBlock.addOperation(instr);

		return new BuilderResult(false, null, null, instr.getResult());
	}

	@Override
	public BuilderResult visitGthExpr(GthExprContext ctx) {
		BuilderResult res1 = this.visit(ctx.lhs);
		BuilderResult res2 = this.visit(ctx.rhs);

		IRCompareGtInstruction instr = new IRCompareGtInstruction(res1.value, res2.value);
		currentBlock.addOperation(instr);

		return new BuilderResult(false, null, null, instr.getResult());
	}

	@Override
	public BuilderResult visitParenExpr(ParenExprContext ctx) {
		return this.visit(ctx.body);
	}
}