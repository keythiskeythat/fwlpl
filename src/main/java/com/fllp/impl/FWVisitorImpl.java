package com.fllp.impl;

import com.fllp.FWBaseVisitor;
import com.fllp.FWParser;

import java.util.HashMap;
import java.util.Map;

public class FWVisitorImpl extends FWBaseVisitor<Object> {

    // 🔹 Bộ nhớ biến
    private Map<String, Object> memory = new HashMap<>();

    // ===== ROOT =====
    @Override
    public String visitRoot(FWParser.RootContext ctx) {
        return visit(ctx.mainFunction()).toString();
    }

    // ===== MAIN =====
    @Override
    public String visitMainFunction(FWParser.MainFunctionContext ctx) {
        return visit(ctx.block()).toString();
    }

    // ===== BLOCK =====
    @Override
    public String visitBlock(FWParser.BlockContext ctx) {
        StringBuilder result = new StringBuilder();

        for (FWParser.StatementContext stmt : ctx.statement()) {
            result.append(visit(stmt)).append("\n");
        }

        return result.toString();
    }

    // ===== STATEMENT =====
    @Override
    public String visitStatement(FWParser.StatementContext ctx) {
        if (ctx.variableDecl() != null) {
            return visit(ctx.variableDecl()).toString();
        } else if (ctx.printStatement() != null) {
            return visit(ctx.printStatement()).toString();
        } else {
            return visit(ctx.assignment()).toString();
        }
    }

    // ===== VARIABLE DECLARATION =====
    @Override
    public String visitVariableDecl(FWParser.VariableDeclContext ctx) {
        String varName = ctx.IDENTIFIER().getText();
        String type = ctx.type().getText();

        Object value = null;

        if (ctx.expression() != null) {
            value = visit(ctx.expression());
        }

        // 🔥 VALIDATION Tarot
        if (type.equals("Tarot")) {
            if (!(value instanceof Integer)) {
                return "Lỗi: Tarot phải là số";
            }

            int v = (Integer) value;

            if (v < 1 || v > 78) {
                return "Lỗi: Tarot chỉ nhận giá trị từ 1 đến 78";
            }
        }

        memory.put(varName, value);

        return "Khai báo " + type + " " + varName + " = " + value;
    }

    // ===== ASSIGNMENT =====
    @Override
    public String visitAssignment(FWParser.AssignmentContext ctx) {
        String varName = ctx.IDENTIFIER().getText();

        if (!memory.containsKey(varName)) {
            return "Lỗi: biến " + varName + " chưa được khai báo";
        }

        Object value = visit(ctx.expression());
        memory.put(varName, value);

        return "Gán " + varName + " = " + value;
    }

    // ===== EXPRESSION =====
    @Override
    public Object visitExpression(FWParser.ExpressionContext ctx) {
        if (ctx.literal() != null) {
            return visit(ctx.literal());
        } else {
            String varName = ctx.IDENTIFIER().getText();
            return memory.getOrDefault(varName, "undefined");
        }
    }

    // ===== LITERAL =====
    @Override
    public Object visitLiteral(FWParser.LiteralContext ctx) {
        if (ctx.INT() != null) {
            return Integer.parseInt(ctx.INT().getText());
        } else {
            // bỏ dấu "
            String text = ctx.STRING().getText();
            return text.substring(1, text.length() - 1);
        }
    }

    @Override
    public String visitPrintStatement(FWParser.PrintStatementContext ctx) {
        String name = ctx.expression().getText();

        if (!memory.containsKey(name)) {
            return "Biến \" + varName + \" chưa được khai báo"; // hoặc name
        }

        Object value = visit(ctx.expression());

        System.out.println("[SHOW] " + value);

        return "[SHOW] " + value;
    }
}