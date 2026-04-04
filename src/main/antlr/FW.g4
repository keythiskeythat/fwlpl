grammar FW;

// ===== ROOT =====
root: mainFunction EOF;

// ===== MAIN =====
mainFunction
    : 'shit' block
    ;

// ===== BLOCK =====
block
    : '{' statement* '}'
    ;

// ===== STATEMENT =====
statement
    : variableDecl ';'
    | assignment ';'
    ;

// ===== VARIABLE =====
variableDecl
    : type IDENTIFIER ('=' expression)?
    ;

assignment
    : IDENTIFIER '=' expression
    ;

// ===== TYPE =====
type
    : 'num'
    | 'Chổi'
    ;

// ===== EXPRESSION =====
expression
    : literal
    | IDENTIFIER
    ;

// ===== LITERAL =====
literal
    : INT
    | STRING
    ;

// ===== LEXER =====
IDENTIFIER: [a-zA-Z_][a-zA-Z_0-9]*;
INT: [0-9]+;
STRING: '"' (~["\\] | '\\' .)* '"';

WS: [ \t\r\n]+ -> skip;