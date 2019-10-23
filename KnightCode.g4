/** KnightCode is an adaptation of two small languages. The JASON language designed by Robert Siegfried
 *  at St. Peter's College in New Jersey in the 1990s.  Cymbol was developed by Terrance Parr in his book
 * "Language Implementation Patterns".  
 */

grammar KnightCode;

file:   'PROGRAM' ID declare body	; 

declare: 'DECLARE' variable+  ;

variable: type ID  ;

type: 'INTEGER' | 'STRING' ; 

body: 'BEGIN' stat+ 'END' ;  //cannot have an empty body 
stat:	setvar															 
	| expr									
	| print							
	| read
	| decision
	| loop  
;							

setvar: 'SET' expr ASSIGN (expr | STRING) ;		

expr:   expr (MUL|DIV) expr		# MulDiv 
	| expr (ADD|SUB) expr		# AddSub
	| expr comp expr		# Compare
	| NUMBER			# Number
	| ID				# Id
	; 
comp: GT | LT | EQ | NEQ   ;

print: 'PRINT' (STRING | ID) ;

read: 'READ' ID ;

decision:	'IF' expr comp expr 'THEN' stat+ ('ELSE' stat+) 'ENDIF'  ;	
loop:		'WHILE' expr comp expr 'DO' stat+ 'ENDWHILE'  ;

//fragments can only be used in Lexer rules
fragment ESC : '\\"' | '\\\\' ; //2-char sequence

//Lexer Rules
ID  :   LETTER (LETTER | [0-9])* ;
STRING: '"' (ESC|.)*? '"' ;
ASSIGN: ':=' ;
LETTER : [a-zA-Z] ;
NUMBER: [0-9]+ ;

//arithmetic operators
MUL: '*' ;
DIV: '/' ;
ADD: '+' ;
SUB: '-' ;

//relational operators
GT: '>'	;
LT: '<'	;
EQ: '=' ;
NEQ: '<>' ;

WS : [ \t\n\r]+ -> skip ; //get rid of white space

SL_COMMENT
    :   '#' .*? '\n' -> skip ; //get rid of comments
