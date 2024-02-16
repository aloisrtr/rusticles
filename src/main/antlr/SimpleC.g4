grammar SimpleC;

@header {
    package antlr;
}

IDENTIFIER : [a-zA-Z]+ [0-9a-zA-Z]*;
UNSIGNED_INTEGER : [0-9]+;
INTEGER : '-'? UNSIGNED_INTEGER;

WS  :   ( ' ' | '\t' | '\r' '\n' | '\n' ) -> skip;



translationUnit : functionDefinition+;

functionArgument : name=IDENTIFIER ':' argType=type;
functionDefinition : 'fun' name=IDENTIFIER '(' (args += functionArgument ',')* args += functionArgument? ')' ':' returnType = type body = block ;

type : 'void'  	#VoidType
	 | 'int' 	#IntType
	 | 'uint'  	#UintType
	 | 'bool'   #BoolType
	 | 'char'   #CharType
	 | '[' elemType=type ';' size=UNSIGNED_INTEGER ']' #ArrayType;

statement : block | variableDefinition | variableAssignation | ifStatement | forLoop | whileLoop | return | functionCall;
block : '{' (statements+=statement ';')* lastExpression = expression? '}';

functionCall : name=IDENTIFIER '(' (args += expression ',')* args += expression? ')';
return : 'return' expr=expression?;
variableDefinition : 'var' name=IDENTIFIER (':' t=type)? '=' expr=expression;
variableAssignation : name=IDENTIFIER '=' expr=expression;

ifStatement : 'if' cond=expression inner=block ('else' followStatement=ifFollowUp)?;
ifFollowUp : block | ifStatement;

forLoop : 'for' declarations+=expression* 'until' stopCondition=expression 'with' continueExpressions+=expression* inner=block;

whileLoop : 'while' condition=expression inner=block ;

expression : lhs=expression '+' rhs=expression  #AddExpr
		| lhs=expression '-' rhs=expression 	#SubExpr
		| lhs=expression '*' rhs=expression 	#MulExpr
		| lhs=expression '/' rhs=expression 	#DivExpr
		| lhs=expression '<' rhs=expression 	#LthExpr
		| lhs=expression '>' rhs=expression 	#GthExpr
		| '-' expr=expression					#NegExpr
	    | '(' expr=expression ')' 		        #ExprNode
	    | return                                #ReturnNode
	    | functionCall                          #FunctionCallNode
		| name=IDENTIFIER 					    #IdNode
		| INTEGER 						        #IntNode
		| UNSIGNED_INTEGER                      #UintNode;


