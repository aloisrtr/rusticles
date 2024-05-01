// Generated from java-escape by ANTLR 4.11.1
 package antlr; 
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleCParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleCVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#translationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTranslationUnit(SimpleCParser.TranslationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#funDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDef(SimpleCParser.FunDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#funArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunArg(SimpleCParser.FunArgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VoidType}
	 * labeled alternative in {@link SimpleCParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidType(SimpleCParser.VoidTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link SimpleCParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(SimpleCParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link SimpleCParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(SimpleCParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SimpleCParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(SimpleCParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfstatementExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstatementExpr(SimpleCParser.IfstatementExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileExpr(SimpleCParser.WhileExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExpr(SimpleCParser.MulExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(SimpleCParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(SimpleCParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SubExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpr(SimpleCParser.SubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegExpr(SimpleCParser.NegExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(SimpleCParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarDefExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefExpr(SimpleCParser.VarDefExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DivExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivExpr(SimpleCParser.DivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LthExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLthExpr(SimpleCParser.LthExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GthExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGthExpr(SimpleCParser.GthExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunCallExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunCallExpr(SimpleCParser.FunCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnExpr(SimpleCParser.ReturnExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForExpr(SimpleCParser.ForExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpr(SimpleCParser.IntExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(SimpleCParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarAssignExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAssignExpr(SimpleCParser.VarAssignExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#ifExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpr(SimpleCParser.IfExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#ifFollowUp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfFollowUp(SimpleCParser.IfFollowUpContext ctx);
}