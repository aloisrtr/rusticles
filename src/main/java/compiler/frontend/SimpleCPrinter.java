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

	public String visitFunDef(SimpleCParser.FunDefContext ctx) {
		StringBuilder result = new StringBuilder("fn " + ctx.name.getText() + " (");

		if (!ctx.args.isEmpty()) {
			int num_args = ctx.args.size();
			for (ParseTree c : ctx.args.subList(0, num_args - 1))
				result.append(this.visit(c)).append(", ");
			result.append(this.visit(ctx.args.get(num_args - 1)));
		}
		result.append("): ");
		result.append(this.visit(ctx.returnType));
		return result + this.visit(ctx.body);
	}

	public String visitFunArg(SimpleCParser.FunArgContext ctx) {
		return ctx.name.getText() + ": " + this.visit(ctx.argType);
	}

	public String visitVoidType(SimpleCParser.VoidTypeContext ctx) {
		return "void";
	}

	public String visitIntType(SimpleCParser.IntTypeContext ctx) {
		return "int";
	}

	public String visitUintType(SimpleCParser.UintTypeContext ctx) {
		return "uint";
	}

	public String visitBoolType(SimpleCParser.BoolTypeContext ctx) {
		return "bool";
	}

	public String visitArrayType(SimpleCParser.ArrayTypeContext ctx) {
		return "[" + this.visit(ctx.elemType) + "; " + ctx.size.getText() + "]";
	}

	@Override
	public String visitBlock(SimpleCParser.BlockContext ctx) {
		StringBuilder body = new StringBuilder();
		for (ParseTree child : ctx.statements) {
			body.append(visit(child));
			body.append(";");
		}
		if (ctx.lastexpr != null) {
			if (!ctx.statements.isEmpty()) {
				body.append("\n");
			}
			body.append(visit(ctx.lastexpr));
		}
		return "{\n" + body.toString().replaceAll("(?m)^", "\t") + "\n}";
	}
	@Override
	public String visitIfExpr(SimpleCParser.IfExprContext ctx) {
		StringBuilder result = new StringBuilder("if (" + visit(ctx.cond) + ") " + visit(ctx.ifBody));
		if (ctx.elseBody!= null) {
			result.append(" else ");
			result.append(visit(ctx.elseBody));
		}
		return result.toString();
	}

	@Override
	public String visitForExpr(SimpleCParser.ForExprContext ctx) {
        return "for " +
				ctx.name.getText() +
                " in " +
				visit(ctx.begin) +
                ".." +
                visit(ctx.end) +
                visit(ctx.body);
	}

	@Override
	public String visitWhileExpr(SimpleCParser.WhileExprContext ctx) {
		return "while (" + visit(ctx.condition) + ") " + visit(ctx.body);
	}
	@Override
	public String visitFunCallExpr(SimpleCParser.FunCallExprContext ctx) {
		StringBuilder result = new StringBuilder(ctx.name.getText() + "(");
		int num_args = ctx.args.size();
		for (ParseTree c : ctx.args.subList(0, num_args - 1))
			result.append(this.visit(c)).append(", ");
		result.append(this.visit(ctx.args.get(num_args - 1)));

		return result + ")";
	}

	@Override
	public String visitVarDefExpr(SimpleCParser.VarDefExprContext ctx) {
		StringBuilder result = new StringBuilder("let " + ctx.name.getText());
		if (ctx.t != null) {
			result.append(": ");
			result.append(visit(ctx.t));
		}
		result.append(" = ");
		return result + visit(ctx.body);
	}

	@Override
	public String visitVarAssignExpr(SimpleCParser.VarAssignExprContext ctx) {
		return ctx.name.getText() + " = " + visit(ctx.body);
	}

	@Override
	public String visitReturnExpr(SimpleCParser.ReturnExprContext ctx) {
		return "return " + visit(ctx.body);
	}

	@Override
	public String visitNegExpr(SimpleCParser.NegExprContext ctx) {
		return "-" + visit(ctx.body);
	}

	@Override
	public String visitIdExpr(SimpleCParser.IdExprContext ctx) {
		return ctx.name.getText();
	}
	@Override
	public String visitIntExpr(SimpleCParser.IntExprContext ctx) {
		return ctx.getText();
	}

	@Override
	public String visitUintExpr(SimpleCParser.UintExprContext ctx) {
		return ctx.getText();
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
}