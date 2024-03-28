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
	 * Enter a parse tree produced by {@link SimpleCParser#funDef}.
	 * @param ctx the parse tree
	 */
	void enterFunDef(SimpleCParser.FunDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#funDef}.
	 * @param ctx the parse tree
	 */
	void exitFunDef(SimpleCParser.FunDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#funArg}.
	 * @param ctx the parse tree
	 */
	void enterFunArg(SimpleCParser.FunArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#funArg}.
	 * @param ctx the parse tree
	 */
	void exitFunArg(SimpleCParser.FunArgContext ctx);
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
	 * Enter a parse tree produced by the {@code IfstatementExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIfstatementExpr(SimpleCParser.IfstatementExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfstatementExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIfstatementExpr(SimpleCParser.IfstatementExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterWhileExpr(SimpleCParser.WhileExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitWhileExpr(SimpleCParser.WhileExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulExpr(SimpleCParser.MulExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulExpr(SimpleCParser.MulExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(SimpleCParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(SimpleCParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UintExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUintExpr(SimpleCParser.UintExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UintExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUintExpr(SimpleCParser.UintExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SubExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSubExpr(SimpleCParser.SubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SubExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSubExpr(SimpleCParser.SubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNegExpr(SimpleCParser.NegExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNegExpr(SimpleCParser.NegExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(SimpleCParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(SimpleCParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarDefExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVarDefExpr(SimpleCParser.VarDefExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarDefExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVarDefExpr(SimpleCParser.VarDefExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DivExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDivExpr(SimpleCParser.DivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DivExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDivExpr(SimpleCParser.DivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LthExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLthExpr(SimpleCParser.LthExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LthExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLthExpr(SimpleCParser.LthExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GthExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGthExpr(SimpleCParser.GthExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GthExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGthExpr(SimpleCParser.GthExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunCallExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunCallExpr(SimpleCParser.FunCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunCallExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunCallExpr(SimpleCParser.FunCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterReturnExpr(SimpleCParser.ReturnExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitReturnExpr(SimpleCParser.ReturnExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterForExpr(SimpleCParser.ForExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitForExpr(SimpleCParser.ForExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(SimpleCParser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(SimpleCParser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(SimpleCParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(SimpleCParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarAssignExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVarAssignExpr(SimpleCParser.VarAssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarAssignExpr}
	 * labeled alternative in {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVarAssignExpr(SimpleCParser.VarAssignExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#ifExpr}.
	 * @param ctx the parse tree
	 */
	void enterIfExpr(SimpleCParser.IfExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#ifExpr}.
	 * @param ctx the parse tree
	 */
	void exitIfExpr(SimpleCParser.IfExprContext ctx);
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
}