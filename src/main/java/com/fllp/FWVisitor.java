// Generated from FW.g4 by ANTLR 4.13.2
package com.fllp;
import com.fllp.impl.BreakException;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FWParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FWVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FWParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(FWParser.RootContext ctx);
	/**
	 * Visit a parse tree produced by {@link FWParser#mainFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainFunction(FWParser.MainFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FWParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(FWParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link FWParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(FWParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FWParser#variableDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDecl(FWParser.VariableDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link FWParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(FWParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link FWParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(FWParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FWParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(FWParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FWParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(FWParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link FWParser#addition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(FWParser.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FWParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(FWParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link FWParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(FWParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link FWParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(FWParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FWParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(FWParser.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FWParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(FWParser.BreakStatementContext ctx) throws BreakException;
}