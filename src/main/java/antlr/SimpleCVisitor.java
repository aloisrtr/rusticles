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
	 * Visit a parse tree produced by {@link SimpleCParser#functionArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArgument(SimpleCParser.FunctionArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(SimpleCParser.FunctionDefinitionContext ctx);
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
	 * Visit a parse tree produced by the {@code UintType}
	 * labeled alternative in {@link SimpleCParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUintType(SimpleCParser.UintTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link SimpleCParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(SimpleCParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CharType}
	 * labeled alternative in {@link SimpleCParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharType(SimpleCParser.CharTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link SimpleCParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(SimpleCParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SimpleCParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SimpleCParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(SimpleCParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(SimpleCParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#variableDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDefinition(SimpleCParser.VariableDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#variableAssignation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAssignation(SimpleCParser.VariableAssignationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(SimpleCParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#ifFollowUp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfFollowUp(SimpleCParser.IfFollowUpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#forLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(SimpleCParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(SimpleCParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulExpr}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExpr(SimpleCParser.MulExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCallNode}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallNode(SimpleCParser.FunctionCallNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdNode}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdNode(SimpleCParser.IdNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SubExpr}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpr(SimpleCParser.SubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegExpr}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegExpr(SimpleCParser.NegExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(SimpleCParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprNode}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNode(SimpleCParser.ExprNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnNode}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnNode(SimpleCParser.ReturnNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntNode}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntNode(SimpleCParser.IntNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DivExpr}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivExpr(SimpleCParser.DivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UintNode}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUintNode(SimpleCParser.UintNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LthExpr}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLthExpr(SimpleCParser.LthExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GthExpr}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGthExpr(SimpleCParser.GthExprContext ctx);
}