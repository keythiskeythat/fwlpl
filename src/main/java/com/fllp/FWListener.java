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
	 * Enter a parse tree produced by {@link FWParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(FWParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link FWParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(FWParser.CommandContext ctx);
}