grammar FW;

root: command+;

command: 'hello' NAME
       | 'bye' NAME;

NAME: [a-zA-Z]+;
WS: [ \t\r\n]+ -> skip;