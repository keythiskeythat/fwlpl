grammar FW;

// ===== ROOT =====
root: mainFunction EOF;

// ===== MAIN =====
mainFunction
    : 'shit' block
    ;

// ===== BLOCK =====
block
    : '{' NEWLINE* statement* '}'
    ;

// ===== STATEMENT =====
statement
    : variableDecl NEWLINE+
    | assignment NEWLINE+
    | printStatement NEWLINE+
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
    : TAROT
    | BROOM
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

printStatement
    : 'show' '(' expression ')'
    ;

// ===== LEXER =====
TAROT: 'Tarot';
BROOM: 'Broom';

IDENTIFIER: [a-zA-Z_][a-zA-Z_0-9]*;
INT: [0-9]+;
STRING: '"' (~["\\] | '\\' .)* '"';

// 🔥 QUAN TRỌNG
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;