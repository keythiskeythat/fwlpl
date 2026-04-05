// Generated from FW.g4 by ANTLR 4.13.2
package com.fllp;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FWParser}.
 */
public interface FWListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FWParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(FWParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link FWParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(FWParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link FWParser#mainFunction}.
	 * @param ctx the parse tree
	 */
	void enterMainFunction(FWParser.MainFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FWParser#mainFunction}.
	 * @param ctx the parse tree
	 */
	void exitMainFunction(FWParser.MainFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FWParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(FWParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link FWParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(FWParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link FWParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(FWParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FWParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(FWParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FWParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void enterVariableDecl(FWParser.VariableDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link FWParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void exitVariableDecl(FWParser.VariableDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link FWParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(FWParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FWParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(FWParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FWParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(FWParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FWParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(FWParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link FWParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(FWParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FWParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(FWParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FWParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(FWParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link FWParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(FWParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link FWParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(FWParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FWParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(FWParser.PrintStatementContext ctx);
}