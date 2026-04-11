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
        } else if (ctx.assignment() != null) {
            return visit(ctx.assignment()).toString();
        } else if (ctx.loopStatement() != null) {
            return visit(ctx.loopStatement()).toString();
        } else {
            return "Unknown statement";
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
        return visit(ctx.comparison());
    }

    // ===== COMPARISON =====
    @Override
    public Object visitComparison(FWParser.ComparisonContext ctx) {
        Object left = visit(ctx.addition(0));
        for (int i = 1; i < ctx.addition().size(); i++) {
            String op = ctx.getChild(2 * i - 1).getText();
            Object right = visit(ctx.addition(i));
            if (op.equals("<")) {
                if (left instanceof Integer && right instanceof Integer) {
                    left = (Integer) left < (Integer) right;
                } else {
                    throw new RuntimeException("Invalid comparison: < requires integers");
                }
            } else if (op.equals(">")) {
                if (left instanceof Integer && right instanceof Integer) {
                    left = (Integer) left > (Integer) right;
                } else {
                    throw new RuntimeException("Invalid comparison: > requires integers");
                }
            } else if (op.equals("==")) {
                left = left.equals(right);
            }
        }
        return left;
    }

    // ===== ADDITION =====
    @Override
    public Object visitAddition(FWParser.AdditionContext ctx) {
        Object left = visit(ctx.primary(0));
        for (int i = 1; i < ctx.primary().size(); i++) {
            String op = ctx.getChild(2 * i - 1).getText();
            Object right = visit(ctx.primary(i));
            if (op.equals("+")) {
                if (left instanceof Integer && right instanceof Integer) {
                    left = (Integer) left + (Integer) right;
                } else {
                    left = left.toString() + right.toString();
                }
            } else if (op.equals("-")) {
                if (left instanceof Integer && right instanceof Integer) {
                    left = (Integer) left - (Integer) right;
                } else {
                    throw new RuntimeException("Invalid subtraction: - requires integers");
                }
            }
        }
        return left;
    }

    // ===== PRIMARY =====
    @Override
    public Object visitPrimary(FWParser.PrimaryContext ctx) {
        if (ctx.literal() != null) {
            return visit(ctx.literal());
        } else if (ctx.IDENTIFIER() != null) {
            String varName = ctx.IDENTIFIER().getText();
            if (!memory.containsKey(varName)) {
                throw new RuntimeException("Variable " + varName + " not declared");
            }
            return memory.get(varName);
        } else if (ctx.expression() != null) {
            return visit(ctx.expression());
        }
        return null;
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

    @Override
    public Object visitLoopStatement(FWParser.LoopStatementContext ctx) {
        StringBuilder result = new StringBuilder();
        int iterations = 0;
        final int MAX_ITERATIONS = 1000; // Prevent infinite loops

        while (iterations < MAX_ITERATIONS) {
            Object condition = visit(ctx.expression());
            if (!isTruthy(condition)) {
                break;
            }
            result.append(visit(ctx.block())).append("\n");
            iterations++;
        }

        if (iterations >= MAX_ITERATIONS) {
            result.append("Lỗi: Vòng lặp vượt quá số lần lặp tối đa\n");
        }

        return result.toString();
    }

    // Helper method to check if an object is truthy
    private boolean isTruthy(Object obj) {
        if (obj == null) return false;
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof Integer) {
            return (Integer) obj != 0;
        }
        if (obj instanceof String) {
            return !((String) obj).isEmpty();
        }
        return true; // Other types are considered true
    }
}