package compiler.frontend;

import org.antlr.v4.runtime.tree.ParseTree;

import antlr.SimpleCBaseVisitor;
import antlr.SimpleCParser;

public class SimpleCPrinter extends SimpleCBaseVisitor<String> {

	public String visitTranslationUnit(SimpleCParser.TranslationUnitContext ctx) {
		StringBuilder result = new StringBuilder();
		for (ParseTree c : ctx.children)
			result.append("\n").append(this.visit(c));
		return result.toString();
	}

	public String visitFunctionDefinition(SimpleCParser.FunctionDefinitionContext ctx) {
		StringBuilder result = new StringBuilder("fun " + ctx.name.getText() + "(");

		if (!ctx.args.isEmpty()) {
			int num_args = ctx.args.size();
			for (ParseTree c : ctx.args.subList(0, num_args - 1))
				result.append(this.visit(c)).append(", ");
			result.append(this.visit(ctx.args.get(num_args - 1)));
		}
		result.append("): ");
		result.append(this.visit(ctx.returnType));
		return result + "\n" + this.visit(ctx.body) + "\n";

	}

	public String visitFunctionArgument(SimpleCParser.FunctionArgumentContext ctx) {
		return ctx.name.getText() + ": " + this.visit(ctx.argType);
	}

	public String visitVoidType(SimpleCParser.VoidTypeContext ctx) {
		return "void";
	}

	public String visitIntType(SimpleCParser.IntTypeContext ctx) {
		return "int";
	}

	public String visitUintType(SimpleCParser.UintTypeContext ctx) {
		return "unsigned int";
	}

	public String visitBoolType(SimpleCParser.BoolTypeContext ctx) {
		return "bool";
	}

	public String visitCharType(SimpleCParser.CharTypeContext ctx) {
		return "char";
	}

	public String visitArrayType(SimpleCParser.ArrayTypeContext ctx) {
		return "[" + this.visit(ctx.elemType) + "; " + ctx.size.getText() + "]";
	}

	@Override
	public String visitBlock(SimpleCParser.BlockContext ctx) {
		StringBuilder result = new StringBuilder("{\n");
		for (ParseTree child : ctx.statements) {
			result.append(visit(child));
			result.append(";\n");
		}
		if (ctx.lastExpression != null) {
			result.append(visit(ctx.lastExpression));
			result.append("\n");
		}
		return result + "}";
	}

	@Override
	public String visitFunctionCall(SimpleCParser.FunctionCallContext ctx) {
		StringBuilder result = new StringBuilder(ctx.name.getText() + " (");
		for (ParseTree arg : ctx.args) {
			result.append(visit(arg));
			result.append(", ");
		}
		return result.toString();
	}

	@Override
	public String visitReturn(SimpleCParser.ReturnContext ctx) {
		return "return " + visit(ctx.expr);
	}

	@Override
	public String visitVariableDefinition(SimpleCParser.VariableDefinitionContext ctx) {
		StringBuilder result = new StringBuilder("var " + ctx.name.getText());
		if (ctx.t != null) {
			result.append(": ");
			result.append(visit(ctx.t));
		}
		result.append(" = ");
		return result + visit(ctx.expr);
	}

	@Override
	public String visitVariableAssignation(SimpleCParser.VariableAssignationContext ctx) {
		return ctx.name.getText() + " = " + visit(ctx.expr);
	}

	@Override
	public String visitIfStatement(SimpleCParser.IfStatementContext ctx) {
		StringBuilder result = new StringBuilder("if " + visit(ctx.cond) + " " + visit(ctx.inner));
		if (ctx.followStatement!= null) {
			result.append(" else ");
			result.append(visit(ctx.followStatement));
		}
		return result.toString();
	}

	@Override
	public String visitForLoop(SimpleCParser.ForLoopContext ctx) {
		StringBuilder result = new StringBuilder("for ");
		for (ParseTree declaration : ctx.declarations) {
			result.append(visit(declaration));
			result.append(", ");
		}
		result.append(" until ");
		result.append(visit(ctx.stopCondition));
		result.append(" with ");
		for (ParseTree expression : ctx.continueExpressions) {
			result.append(visit(expression));
			result.append(", ");
		}
		result.append(visit(ctx.inner));
		return result.toString();
	}

	@Override
	public String visitWhileLoop(SimpleCParser.WhileLoopContext ctx) {
		return "while " + visit(ctx.condition) + " " + visit(ctx.inner);
	}

	@Override
	public String visitAddExpr(SimpleCParser.AddExprContext ctx) {
		return visit(ctx.lhs) + " + " + visit(ctx.rhs);
	}

	@Override
	public String visitSubExpr(SimpleCParser.SubExprContext ctx) {
		return visit(ctx.lhs) + " - " + visit(ctx.rhs);
	}

	@Override
	public String visitMulExpr(SimpleCParser.MulExprContext ctx) {
		return visit(ctx.lhs) + " * " + visit(ctx.rhs);
	}

	@Override
	public String visitDivExpr(SimpleCParser.DivExprContext ctx) {
		return visit(ctx.lhs) + " / " + visit(ctx.rhs);
	}

	@Override
	public String visitLthExpr(SimpleCParser.LthExprContext ctx) {
		return visit(ctx.lhs) + " < " + visit(ctx.rhs);
	}

	@Override
	public String visitGthExpr(SimpleCParser.GthExprContext ctx) {
		return visit(ctx.lhs) + " > " + visit(ctx.rhs);
	}

	@Override
	public String visitNegExpr(SimpleCParser.NegExprContext ctx) {
		return "-" +visit(ctx.expr);
	}

	@Override
	public String visitExprNode(SimpleCParser.ExprNodeContext ctx) {
		return "(" + visit(ctx.expr) + ")";
	}

	@Override
	public String visitIdNode(SimpleCParser.IdNodeContext ctx) {
		return ctx.name.getText();
	}

	@Override
	public String visitIntNode(SimpleCParser.IntNodeContext ctx) {
		return ctx.getText();
	}

	@Override
	public String visitUintNode(SimpleCParser.UintNodeContext ctx) {
		return ctx.getText();
	}
}