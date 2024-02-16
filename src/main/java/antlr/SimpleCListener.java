// Generated from java-escape by ANTLR 4.11.1

    package antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleCParser}.
 */
public interface SimpleCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#translationUnit}.
	 * @param ctx the parse tree
	 */
	void enterTranslationUnit(SimpleCParser.TranslationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#translationUnit}.
	 * @param ctx the parse tree
	 */
	void exitTranslationUnit(SimpleCParser.TranslationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#functionArgument}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArgument(SimpleCParser.FunctionArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#functionArgument}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArgument(SimpleCParser.FunctionArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(SimpleCParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(SimpleCParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VoidType}
	 * labeled alternative in {@link SimpleCParser#type}.
	 * @param ctx the parse tree
	 */
	void enterVoidType(SimpleCParser.VoidTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VoidType}
	 * labeled alternative in {@link SimpleCParser#type}.
	 * @param ctx the parse tree
	 */
	void exitVoidType(SimpleCParser.VoidTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link SimpleCParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntType(SimpleCParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link SimpleCParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntType(SimpleCParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UintType}
	 * labeled alternative in {@link SimpleCParser#type}.
	 * @param ctx the parse tree
	 */
	void enterUintType(SimpleCParser.UintTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UintType}
	 * labeled alternative in {@link SimpleCParser#type}.
	 * @param ctx the parse tree
	 */
	void exitUintType(SimpleCParser.UintTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link SimpleCParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(SimpleCParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link SimpleCParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(SimpleCParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CharType}
	 * labeled alternative in {@link SimpleCParser#type}.
	 * @param ctx the parse tree
	 */
	void enterCharType(SimpleCParser.CharTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CharType}
	 * labeled alternative in {@link SimpleCParser#type}.
	 * @param ctx the parse tree
	 */
	void exitCharType(SimpleCParser.CharTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link SimpleCParser#type}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(SimpleCParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link SimpleCParser#type}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(SimpleCParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SimpleCParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SimpleCParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SimpleCParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SimpleCParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(SimpleCParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(SimpleCParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#return}.
	 * @param ctx the parse tree
	 */
	void enterReturn(SimpleCParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#return}.
	 * @param ctx the parse tree
	 */
	void exitReturn(SimpleCParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefinition(SimpleCParser.VariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefinition(SimpleCParser.VariableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#variableAssignation}.
	 * @param ctx the parse tree
	 */
	void enterVariableAssignation(SimpleCParser.VariableAssignationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#variableAssignation}.
	 * @param ctx the parse tree
	 */
	void exitVariableAssignation(SimpleCParser.VariableAssignationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(SimpleCParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(SimpleCParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#ifFollowUp}.
	 * @param ctx the parse tree
	 */
	void enterIfFollowUp(SimpleCParser.IfFollowUpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#ifFollowUp}.
	 * @param ctx the parse tree
	 */
	void exitIfFollowUp(SimpleCParser.IfFollowUpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(SimpleCParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(SimpleCParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(SimpleCParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(SimpleCParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulExpr}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulExpr(SimpleCParser.MulExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulExpr}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulExpr(SimpleCParser.MulExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCallNode}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallNode(SimpleCParser.FunctionCallNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCallNode}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallNode(SimpleCParser.FunctionCallNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdNode}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdNode(SimpleCParser.IdNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdNode}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdNode(SimpleCParser.IdNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SubExpr}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubExpr(SimpleCParser.SubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SubExpr}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubExpr(SimpleCParser.SubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegExpr}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegExpr(SimpleCParser.NegExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegExpr}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegExpr(SimpleCParser.NegExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(SimpleCParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(SimpleCParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNode}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprNode(SimpleCParser.ExprNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNode}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprNode(SimpleCParser.ExprNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnNode}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterReturnNode(SimpleCParser.ReturnNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnNode}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitReturnNode(SimpleCParser.ReturnNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntNode}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIntNode(SimpleCParser.IntNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntNode}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIntNode(SimpleCParser.IntNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DivExpr}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivExpr(SimpleCParser.DivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DivExpr}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivExpr(SimpleCParser.DivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UintNode}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUintNode(SimpleCParser.UintNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UintNode}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUintNode(SimpleCParser.UintNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LthExpr}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLthExpr(SimpleCParser.LthExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LthExpr}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLthExpr(SimpleCParser.LthExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GthExpr}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGthExpr(SimpleCParser.GthExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GthExpr}
	 * labeled alternative in {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGthExpr(SimpleCParser.GthExprContext ctx);
}