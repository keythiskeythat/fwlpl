package com.fllp.impl;

import com.fllp.FWBaseVisitor;
import com.fllp.FWParser;

public class FWVisitorImpl extends FWBaseVisitor<String> {
    @Override
    public String visitCommand(FWParser.CommandContext ctx) {

        String name = ctx.NAME().getText();

        if (ctx.getText().startsWith("hello")) {
            System.out.println("Chào " + name);
        } else if (ctx.getText().startsWith("bye")) {
            System.out.println("Tạm biệt " + name);
        }

        return null;
    }

}
