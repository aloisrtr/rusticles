// Generated from java-escape by ANTLR 4.11.1

    package antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IRTXTParser}.
 */
public interface IRTXTListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code IRVOID}
	 * labeled alternative in {@link IRTXTParser#irType}.
	 * @param ctx the parse tree
	 */
	void enterIRVOID(IRTXTParser.IRVOIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IRVOID}
	 * labeled alternative in {@link IRTXTParser#irType}.
	 * @param ctx the parse tree
	 */
	void exitIRVOID(IRTXTParser.IRVOIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IRINT}
	 * labeled alternative in {@link IRTXTParser#irType}.
	 * @param ctx the parse tree
	 */
	void enterIRINT(IRTXTParser.IRINTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IRINT}
	 * labeled alternative in {@link IRTXTParser#irType}.
	 * @param ctx the parse tree
	 */
	void exitIRINT(IRTXTParser.IRINTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IRUINT}
	 * labeled alternative in {@link IRTXTParser#irType}.
	 * @param ctx the parse tree
	 */
	void enterIRUINT(IRTXTParser.IRUINTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IRUINT}
	 * labeled alternative in {@link IRTXTParser#irType}.
	 * @param ctx the parse tree
	 */
	void exitIRUINT(IRTXTParser.IRUINTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IRBOOL}
	 * labeled alternative in {@link IRTXTParser#irType}.
	 * @param ctx the parse tree
	 */
	void enterIRBOOL(IRTXTParser.IRBOOLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IRBOOL}
	 * labeled alternative in {@link IRTXTParser#irType}.
	 * @param ctx the parse tree
	 */
	void exitIRBOOL(IRTXTParser.IRBOOLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IRADDR}
	 * labeled alternative in {@link IRTXTParser#irType}.
	 * @param ctx the parse tree
	 */
	void enterIRADDR(IRTXTParser.IRADDRContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IRADDR}
	 * labeled alternative in {@link IRTXTParser#irType}.
	 * @param ctx the parse tree
	 */
	void exitIRADDR(IRTXTParser.IRADDRContext ctx);
	/**
	 * Enter a parse tree produced by {@link IRTXTParser#irTop}.
	 * @param ctx the parse tree
	 */
	void enterIrTop(IRTXTParser.IrTopContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRTXTParser#irTop}.
	 * @param ctx the parse tree
	 */
	void exitIrTop(IRTXTParser.IrTopContext ctx);
	/**
	 * Enter a parse tree produced by {@link IRTXTParser#irFunction}.
	 * @param ctx the parse tree
	 */
	void enterIrFunction(IRTXTParser.IrFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRTXTParser#irFunction}.
	 * @param ctx the parse tree
	 */
	void exitIrFunction(IRTXTParser.IrFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link IRTXTParser#functionArgument}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArgument(IRTXTParser.FunctionArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRTXTParser#functionArgument}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArgument(IRTXTParser.FunctionArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link IRTXTParser#irBlock}.
	 * @param ctx the parse tree
	 */
	void enterIrBlock(IRTXTParser.IrBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRTXTParser#irBlock}.
	 * @param ctx the parse tree
	 */
	void exitIrBlock(IRTXTParser.IrBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IRCommonOperation}
	 * labeled alternative in {@link IRTXTParser#irOperation}.
	 * @param ctx the parse tree
	 */
	void enterIRCommonOperation(IRTXTParser.IRCommonOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IRCommonOperation}
	 * labeled alternative in {@link IRTXTParser#irOperation}.
	 * @param ctx the parse tree
	 */
	void exitIRCommonOperation(IRTXTParser.IRCommonOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IRConstantOperation}
	 * labeled alternative in {@link IRTXTParser#irOperation}.
	 * @param ctx the parse tree
	 */
	void enterIRConstantOperation(IRTXTParser.IRConstantOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IRConstantOperation}
	 * labeled alternative in {@link IRTXTParser#irOperation}.
	 * @param ctx the parse tree
	 */
	void exitIRConstantOperation(IRTXTParser.IRConstantOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IRCallOperation}
	 * labeled alternative in {@link IRTXTParser#irOperation}.
	 * @param ctx the parse tree
	 */
	void enterIRCallOperation(IRTXTParser.IRCallOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IRCallOperation}
	 * labeled alternative in {@link IRTXTParser#irOperation}.
	 * @param ctx the parse tree
	 */
	void exitIRCallOperation(IRTXTParser.IRCallOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IRStoreOperation}
	 * labeled alternative in {@link IRTXTParser#irOperation}.
	 * @param ctx the parse tree
	 */
	void enterIRStoreOperation(IRTXTParser.IRStoreOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IRStoreOperation}
	 * labeled alternative in {@link IRTXTParser#irOperation}.
	 * @param ctx the parse tree
	 */
	void exitIRStoreOperation(IRTXTParser.IRStoreOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IRCondBr}
	 * labeled alternative in {@link IRTXTParser#irTerminator}.
	 * @param ctx the parse tree
	 */
	void enterIRCondBr(IRTXTParser.IRCondBrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IRCondBr}
	 * labeled alternative in {@link IRTXTParser#irTerminator}.
	 * @param ctx the parse tree
	 */
	void exitIRCondBr(IRTXTParser.IRCondBrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IRGoto}
	 * labeled alternative in {@link IRTXTParser#irTerminator}.
	 * @param ctx the parse tree
	 */
	void enterIRGoto(IRTXTParser.IRGotoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IRGoto}
	 * labeled alternative in {@link IRTXTParser#irTerminator}.
	 * @param ctx the parse tree
	 */
	void exitIRGoto(IRTXTParser.IRGotoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IRReturn}
	 * labeled alternative in {@link IRTXTParser#irTerminator}.
	 * @param ctx the parse tree
	 */
	void enterIRReturn(IRTXTParser.IRReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IRReturn}
	 * labeled alternative in {@link IRTXTParser#irTerminator}.
	 * @param ctx the parse tree
	 */
	void exitIRReturn(IRTXTParser.IRReturnContext ctx);
}