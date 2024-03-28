package compiler.frontend;

import java.util.ArrayList;
import java.util.Optional;

import org.antlr.v4.runtime.tree.ParseTree;

import antlr.SimpleCBaseVisitor;
import antlr.SimpleCParser.*;

import ir.core.IRBlock;
import ir.core.IRFunction;
import ir.core.IRTopLevel;
import ir.core.IRType;
import ir.core.IRValue;
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
import javax.xml.xpath.XPathExpressionException;

public class IRBuilder extends SimpleCBaseVisitor<BuilderResult> {
	IRTopLevel top;
	IRFunction currentFunction = null;
	IRBlock currentBlock = null;
	SymbolTable symbolTable;
	
	public static IRTopLevel buildTopLevel(ParseTree t) {
		IRBuilder builder = new IRBuilder();
		builder.visit(t);
		return builder.top;
	}
	
	public IRBuilder() {
		top = new IRTopLevel();
		symbolTable = new SymbolTable(Optional.empty());
	}
	
	IRType translateType(TypeContext t) {
 		if (t instanceof IntTypeContext) {
			return IRType.INT;
		}
		else if (t instanceof UintTypeContext) {
			return IRType.UINT;
		}
		return null;
	}

	
	@Override
	public BuilderResult visitFunDef(FunDefContext ctx) {
		//We build the list of arg types
		ArrayList<IRType> argTypes = new ArrayList<IRType>();
		for (FunArgContext a : ctx.args) {
			argTypes.add(translateType(a.argType));
		}
		
		//We instantiate a new function and add it in the toplevel
		IRFunction func = new IRFunction(ctx.name.getText(), translateType(ctx.returnType), argTypes);
		top.addFunction(func);
		
		//We mark the newly created function as currentFunction : blocks will be added inside
		currentFunction = func;
		IRBlock entryBlock = createBlock(func);
		
		//Recursive call to the body to get its IR
		BuilderResult body = visitBlock(ctx.body);
		
		//We connect the result with the entry block and seal the body
		entryBlock.addTerminator(new IRGoto(body.entry));
		
		//Don't care about the value returned
		return null;
	}
	
	// @Override
	// public BuilderResult visitStatement(StatementContext ctx) {
	//	return this.visit(ctx.children.get(0));
	// }
	
	@Override
	public BuilderResult visitBlock(BlockContext ctx) {
		
		//We create a new block, save it as in point and current point
		IRBlock in =  createBlock(currentFunction);
		IRBlock current = in;
		currentBlock = current;
		
		// ToDo Recursive call for each child

		for (ParseTree c : ctx.children) {
			BuilderResult res = this.visit(c);
			if (res != null) {
				current = res.entry;
			}
		}

//		for (StatementContext s : ctx.statements) {
//			BuilderResult r = visit(s);
//			if (r.hasBlock) {
//				//We have to insert blocks from recursive call
//				current.addTerminator(new IRGoto(r.entry));
//				current = r.exit;
//				currentBlock = current;
//			}
//		}
		
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
		ArrayList<IRValue> args = new ArrayList<IRValue>();

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
	 *  Non control flow statements
	 * 
	 ****************************************************************************/ 

	// TODO: varDecl / varDef / varAssign

	@Override
	public BuilderResult visitVarAssignExpr(VarAssignExprContext ctx) {
		// TODO
		
		//We get the value of the expression
		BuilderResult res = this.visit(ctx.body);
		//We get the symbol table entry
		//SymbolTableEntry entry = symbolTable.lookup(ctx.name.getText());
		//We create a new assign instruction
		//IRAssignInstruction instr = new IRAssignInstruction(entry, res.value);
		//We add the instruction to the current block
		//currentBlock.addOperation(instr);
		//We return the result
		return new BuilderResult(false, null, null, null);
	}
	@Override
	public BuilderResult visitVarDefExpr(VarDefExprContext ctx) {
		IRType type = translateType(ctx.t);
		IRValue val = null;
		if (ctx.body != null) {
			BuilderResult res = this.visit(ctx.body);
			val = res.value;
		}
		return new BuilderResult(false, null, null, val);
	}

	@Override
	public BuilderResult visitParenExpr(ParenExprContext ctx) {
		return this.visit(ctx.body);
	}
	
	@Override
	public BuilderResult visitAddExpr(AddExprContext ctx) {
		BuilderResult res1 = ctx.lhs.accept(this);
		BuilderResult res2 = ctx.rhs.accept(this);

		IRAddInstruction instr = new IRAddInstruction(res1.value, res2.value);
		currentBlock.addOperation(instr);

		return new BuilderResult(false, null, null, instr.getResult());
	}
	
	@Override
	public BuilderResult visitSubExpr(SubExprContext ctx) {
		
		BuilderResult res1 = ctx.lhs.accept(this);
		BuilderResult res2 = ctx.rhs.accept(this);

		IRSubInstruction instr = new IRSubInstruction(res1.value, res2.value);
		currentBlock.addOperation(instr);
		
		return new BuilderResult(false, null, null, instr.getResult());
	}
	
	@Override
	public BuilderResult visitMulExpr(MulExprContext ctx) {
		
		BuilderResult res1 = ctx.lhs.accept(this);
		BuilderResult res2 = ctx.rhs.accept(this);

		IRMulInstruction instr = new IRMulInstruction(res1.value, res2.value);
		currentBlock.addOperation(instr);
		
		return new BuilderResult(false, null, null, instr.getResult());
	}
	
	@Override
	public BuilderResult visitDivExpr(DivExprContext ctx) {
		
		BuilderResult res1 = ctx.lhs.accept(this);
		BuilderResult res2 = ctx.rhs.accept(this);

		IRDivInstruction instr = new IRDivInstruction(res1.value, res2.value);
		currentBlock.addOperation(instr);
		
		return new BuilderResult(false, null, null, instr.getResult());
	}
	
	@Override
	public BuilderResult visitGthExpr(GthExprContext ctx) {
		
		BuilderResult res1 = ctx.lhs.accept(this);
		BuilderResult res2 = ctx.rhs.accept(this);

		IRCompareGtInstruction instr = new IRCompareGtInstruction(res1.value, res2.value);
		currentBlock.addOperation(instr);
		
		return new BuilderResult(false, null, null, instr.getResult());
	}
	
	@Override
	public BuilderResult visitLthExpr(LthExprContext ctx) {
		
		BuilderResult res1 = ctx.lhs.accept(this);
		BuilderResult res2 = ctx.rhs.accept(this);

		IRCompareLtInstruction instr = new IRCompareLtInstruction(res1.value, res2.value);
		currentBlock.addOperation(instr);
		
		return new BuilderResult(false, null, null, instr.getResult());
	}
	
	@Override
	public BuilderResult visitNegExpr(NegExprContext ctx) {
		
		BuilderResult res1 = ctx.body.accept(this);

		IRConstantInstruction<Integer> zeroCst = new IRConstantInstruction<Integer>(IRType.INT, 0);
		IRSubInstruction instr = new IRSubInstruction(zeroCst.getResult(), res1.value);
		currentBlock.addOperation(zeroCst);
		currentBlock.addOperation(instr);
		
		return new BuilderResult(false, null, null, instr.getResult());
	}

	@Override
	public BuilderResult visitIntExpr(IntExprContext ctx) {
		Integer val = Integer.parseInt(ctx.children.get(0).getText());
		IRConstantInstruction<Integer> instr = new IRConstantInstruction<Integer>(IRType.INT, val);
		currentBlock.addOperation(instr);

		return new BuilderResult(false, null, null, instr.getResult());
	}

	@Override
	public BuilderResult visitIdExpr(IdExprContext ctx) {
		// Key function for having SSA working properly
		// SymbolTableEntry entry = symbolTable.lookup(ctx.name.getText());
		IRValue val = null; //TODO: find the correct value in SSA form

		return new BuilderResult(false, null, null, val);
	}

	private IRBlock createBlock(IRFunction f) {
		return f.addBlock();
	}
}

