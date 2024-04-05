grammar SimpleC;
@header { package antlr; }

IDENTIFIER : [a-zA-Z]+ [0-9a-zA-Z]*;
UNSIGNED_INTEGER : [0-9]+;
INTEGER : '-'? UNSIGNED_INTEGER;
BOOL : 'true' | 'false';
WS  :   ( ' ' | '\t' | '\r' '\n' | '\n' ) -> skip;

translationUnit : funDef+;

funDef : 'fn' name=IDENTIFIER '(' (args += funArg ',')* args += funArg? ')' ':' returnType = type body = block ;

funArg : name=IDENTIFIER ':' argType=type;

type : 'void'  	#VoidType
	 | 'int' 	#IntType
	 | 'uint'  	#UintType
	 | 'bool'   #BoolType
	 | '[' elemType=type ';' size=UNSIGNED_INTEGER ']' #ArrayType;

block : '{' (statements+=expr ';')* lastexpr = expr? '}' ;

expr :
// Return/call
'return' body=expr                                                #ReturnExpr
| name=IDENTIFIER '(' (args += expr ',')* args += expr? ')'       #FunCallExpr
// Control flow
| ifExpr                                                          #IfstatementExpr
| 'for' name=IDENTIFIER 'in' begin=expr '..' end=expr body=block  #ForExpr
| 'while' '(' condition=expr ')' body=block                       #WhileExpr
// Non-control flow expressions
| 'let ' name=IDENTIFIER ':' t=type '=' body=expr                 #VarDefExpr
| name=IDENTIFIER '=' body=expr                                   #VarAssignExpr
| INTEGER 					                                      #IntExpr
| UNSIGNED_INTEGER                                                #UintExpr
| BOOL                                                            #BoolExpr
| name=IDENTIFIER 				                                  #IdExpr
| '-' body=expr					                                  #NegExpr
| lhs=expr '+' rhs=expr                                           #AddExpr
| lhs=expr '-' rhs=expr                                           #SubExpr
| lhs=expr '*' rhs=expr 	                                      #MulExpr
| lhs=expr '/' rhs=expr 	                                      #DivExpr
| lhs=expr '<' rhs=expr 	                                      #LthExpr
| lhs=expr '>' rhs=expr 	                                      #GthExpr
| '(' body=expr ')'                                               #ParenExpr;

ifExpr : 'if' '(' cond=expr ')' ifBody=block ('else' (elseBody=ifFollowUp))? ;

ifFollowUp : block | ifExpr;