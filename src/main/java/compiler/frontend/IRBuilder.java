package compiler.frontend;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import ir.core.*;
import ir.terminator.IRCondBr;
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
		BuilderResult res = visitBlock(ctx.body);
		if (res != null) {
			if (res.value != null) {
				if (res.value.type != currentFunction.getReturnType()) {
					throw new RuntimeException("Function " + currentFunction.getName() + " expects a return type of " + currentFunction.getReturnType() + ", but returned type " + res.value.type);
				}
				currentFunction.getBlocks().getLast().addTerminator(new IRReturn(res.value));
			} else if (currentFunction.getReturnType() != null && res.value != null) {
				throw new RuntimeException("Function " + currentFunction.getName() + " expects a return type of VOID, but returned type " + res.value.type);
			}
		}

		// Don't care about the value returned
		return null;
	}
	@Override
	public BuilderResult visitBlock(BlockContext ctx) {
		// We create a new block, save it as in point and current point
		IRBlock entry =  currentFunction.addBlock();
		IRBlock exit = entry;
		this.currentBlock = exit;

		// Create the symbol table for this.
		this.symbolTable = this.symbolTable.initializeScope();

		// Visit all children
		for (ParseTree statement : ctx.statements) {
			BuilderResult statement_ir = this.visit(statement);
			if (statement_ir.hasBlock) {
				exit.getSuccessors().add(statement_ir.entry);
				exit = currentFunction.addBlock();
				statement_ir.exit.getSuccessors().add(exit);
			}
		}

		// Handle the return value of the block.
		IRValue returned = null;
		if (ctx.lastexpr != null) {
			BuilderResult res = this.visit(ctx.lastexpr);
			returned = res.value;
		}

		// Finalize the current symbol table level
		this.symbolTable = this.symbolTable.finalizeScope().get();

		return new BuilderResult(true, entry, exit, returned);
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

		if (currentFunction.getReturnType() != res.value.type) {
			throw new RuntimeException("Function " + currentFunction.getName() + " returns a value of type " + currentFunction.getReturnType() + ", but tried to return " + res.value.type);
		}
		
		return new BuilderResult(res.hasBlock, null, null, null);
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

		return new BuilderResult(true, null, null, funcCall.getResult());
	}

	/****************************************************************************
	 *  Control flow statements
	 *
	 ****************************************************************************/
	@Override
	public BuilderResult visitIfExpr(IfExprContext ctx) {
		// Creation Begin Block
		IRBlock begin = currentFunction.addBlock();
		currentBlock = begin;

		// Visit of the condition, if and else blocks
		BuilderResult cond = this.visit(ctx.cond);
		BuilderResult if_block = this.visit(ctx.ifBody);
		BuilderResult else_block = this.visit(ctx.elseBody);

		IRCondBr condBr = new IRCondBr(cond.value, if_block.entry, else_block.entry);
		currentBlock.addTerminator(condBr);

		// Creation End block
		IRBlock end = currentFunction.addBlock();
		IRGoto gotoEnd = new IRGoto(end);

		// Link if and else blocks to the End block
		if_block.exit.addTerminator(gotoEnd);
		else_block.exit.addTerminator(gotoEnd);

		// Check that if and else blocks have the same type
		if (if_block.value.getType() != else_block.value.getType()) {
			throw new RuntimeException("If and else blocks must have the same type");
		}
		// Recuperation of the phi value out of the if and else blocks
		IRPhiOperation phiIfElse = new IRPhiOperation(if_block.value.getType());
		phiIfElse.addOperand(if_block.value);
		phiIfElse.addOperand(else_block.value);
		IRValue phiIfElseValue = phiIfElse.getResult();

		return new BuilderResult(true, cond.entry, end, phiIfElseValue);
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
		IRType expected_type = this.translateType(ctx.t);
		BuilderResult res = this.visit(ctx.body);
		IRValue value = res.value;

		if (value.type != expected_type) {
			throw new RuntimeException("Variable " + ctx.name.getText() + " is of type " + expected_type + " but was assigned a value of type " + value.type);
		}

		// Add to the current symbol table the new variable
		// Add of the IRValue in the current block
		this.symbolTable.insert(ctx.name.getText(), value);

		return new BuilderResult(res.hasBlock, null, null, null);
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
		if (symbolTable.lookup(ctx.name.getText()).get().value.type != res.value.type) {
			throw new RuntimeException("Variable " + ctx.name.getText() + " is of type " + symbolTable.lookup(ctx.name.getText()).get().value.type + " but was assigned a value of type " + res.value.type);
		}

		symbolTable.insert(ctx.name.getText(), res.value);

		return new BuilderResult(res.hasBlock, null, null, null);
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
		Optional<VariableInfo> entry = symbolTable.lookup(ctx.name.getText());
		if (entry.isPresent()) {
			IRValue val = entry.get().value;
			if (currentBlock.getPredecessors().size() == 1) {
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

		if (lhs.value.type != rhs.value.type) {
			throw new RuntimeException("Tried adding two values of different types: " + lhs.value + " + " + rhs.value);
		}

		IRAddInstruction instr = new IRAddInstruction(lhs.value, rhs.value);
		currentBlock.addOperation(instr);

		return new BuilderResult(lhs.hasBlock || rhs.hasBlock, null, null, instr.getResult());
	}

	@Override
	public BuilderResult visitSubExpr(SubExprContext ctx) {
		BuilderResult lhs = this.visit(ctx.lhs);
		BuilderResult rhs = this.visit(ctx.rhs);
		
		if (lhs.value.type != rhs.value.type) {
			throw new RuntimeException("Tried subtracting two values of different types: " + lhs.value + " - " + rhs.value);
		}

		IRSubInstruction instr = new IRSubInstruction(lhs.value, rhs.value);
		currentBlock.addOperation(instr);

		return new BuilderResult(lhs.hasBlock || rhs.hasBlock, null, null, instr.getResult());
	}

	@Override
	public BuilderResult visitMulExpr(MulExprContext ctx) {
		BuilderResult lhs = this.visit(ctx.lhs);
		BuilderResult rhs = this.visit(ctx.rhs);

		if (lhs.value.type != rhs.value.type) {
			throw new RuntimeException("Tried multiplicating two values of different types: " + lhs.value + " * " + rhs.value);
		}

		IRMulInstruction instr = new IRMulInstruction(lhs.value, rhs.value);
		currentBlock.addOperation(instr);

		return new BuilderResult(lhs.hasBlock || rhs.hasBlock, null, null, instr.getResult());
	}

	@Override
	public BuilderResult visitDivExpr(DivExprContext ctx) {
		BuilderResult lhs = this.visit(ctx.lhs);
		BuilderResult rhs = this.visit(ctx.rhs);

		if (lhs.value.type != rhs.value.type) {
			throw new RuntimeException("Tried dividing two values of different types: " + lhs.value + " / " + rhs.value);
		}

		IRDivInstruction instr = new IRDivInstruction(lhs.value, rhs.value);
		currentBlock.addOperation(instr);

		return new BuilderResult(lhs.hasBlock || rhs.hasBlock, null, null, instr.getResult());
	}

	@Override
	public BuilderResult visitLthExpr(LthExprContext ctx) {
		BuilderResult lhs = this.visit(ctx.lhs);
		BuilderResult rhs = this.visit(ctx.rhs);

		if (lhs.value.type != rhs.value.type) {
			throw new RuntimeException("Tried comparing two values of different types: " + lhs.value + " < " + rhs.value);
		}

		IRCompareLtInstruction instr = new IRCompareLtInstruction(lhs.value, rhs.value);
		currentBlock.addOperation(instr);

		return new BuilderResult(lhs.hasBlock || rhs.hasBlock, null, null, instr.getResult());
	}

	@Override
	public BuilderResult visitGthExpr(GthExprContext ctx) {
		BuilderResult lhs = this.visit(ctx.lhs);
		BuilderResult rhs = this.visit(ctx.rhs);

		if (lhs.value.type != rhs.value.type) {
			throw new RuntimeException("Tried comparing two values of different types: " + lhs.value + " > " + rhs.value);
		}

		IRCompareGtInstruction instr = new IRCompareGtInstruction(lhs.value, rhs.value);
		currentBlock.addOperation(instr);

		return new BuilderResult(lhs.hasBlock || rhs.hasBlock, null, null, instr.getResult());
	}

	@Override
	public BuilderResult visitParenExpr(ParenExprContext ctx) {
		return this.visit(ctx.body);
	}
}
