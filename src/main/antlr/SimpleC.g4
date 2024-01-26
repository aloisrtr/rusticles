grammar SimpleC;

@header {
    package antlr;
}

IDENTIFIER : [a-zA-Z]+ [0-9a-zA-Z]*;
INTEGER : '-'? [0-9]+;

WS  :   ( ' ' | '\t' | '\r' '\n' | '\n' ) -> skip;



translationUnit : functionDefinition+;

functionDefinition : returnType=type name=IDENTIFIER '(' (args+=functionArgument ',')* args+=functionArgument? ')' body=blockStatement ;

functionArgument : argType=type name=IDENTIFIER ('[' size=INTEGER ']')?;

type : 'void'  	#VoidType
	| 'int' 	#IntType
	| 'unsigned int'  	#UintType;

statement : blockStatement | expressionStatement | returnStatement;

blockStatement : '{' statements+=statement* '}';

defineVar : 'let' name=IDENTIFIER ':' t=type '=' statement ';';
assignVar : name=IDENTIFIER '=' statement ';';

if : 'if' cond=expression inner=statement;
//TODO: add statements for var def/var decl/var assign/if/for/while

returnStatement : 'return' expr=expression?';';

expressionStatement : expr=expression ';';

expression : lhs=expression '+' rhs=expression  #AddExpr
		| lhs=expression '-' rhs=expression 	#SubExpr
		| lhs=expression '*' rhs=expression 	#MulExpr
		| lhs=expression '/' rhs=expression 	#DivExpr
		| lhs=expression '<' rhs=expression 	#CmpLtExpr
		| lhs=expression '>' rhs=expression 	#CmpGtExpr
		|'-' expr=expression					#OppExpr
	    | '(' expr=expression ')' 		    #ExprNode
		| name=IDENTIFIER 					#IdNode
		| functionCall                  #functionCallExpr
		| INTEGER 						#IntNode;
		
           
functionCall : name=IDENTIFIER '(' (args+=expression ',')* args+=expression? ')';
