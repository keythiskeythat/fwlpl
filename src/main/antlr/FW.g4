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
    | loopStatement NEWLINE+
    | breakStatement NEWLINE+
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
    : DANM
    | HELL
    ;

// ===== EXPRESSION =====
expression
    : comparison
    ;

comparison
    : addition (('<' | '>' | '==') addition)*
    ;

addition
    : primary (('+' | '-') primary)*
    ;

primary
    : literal
    | IDENTIFIER
    | '(' expression ')'
    ;

// ===== LITERAL =====
literal
    : INT
    | STRING
    ;

printStatement
    : 'show' '(' expression ')'
    ;

loopStatement
    : 'loop' '(' expression ')' block 'bug'
    ;

breakStatement
    : FREAKING
    ;

// ===== LEXER =====
DANM: 'Danm';
HELL: 'Hell';
FREAKING: 'Freaking';

IDENTIFIER: [a-zA-Z_][a-zA-Z_0-9]*;
INT: [0-9]+;
STRING: '"' (~["\\] | '\\' .)* '"';

// 🔥 QUAN TRỌNG
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;