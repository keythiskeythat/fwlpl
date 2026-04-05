package com;

import com.fllp.FWBaseVisitor;
import com.fllp.FWLexer;
import com.fllp.FWParser;
import com.fllp.impl.FWVisitorImpl;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {

        InputStream is = Main.class.getClassLoader().getResourceAsStream("fw_Code.bored");

        CharStream input = CharStreams.fromStream(is);

        FWLexer lexer = new FWLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FWParser parser = new FWParser(tokens);

        ParseTree tree = parser.root();

        FWBaseVisitor<Object> visitor = new FWVisitorImpl();
        visitor.visit(tree);
    }
}