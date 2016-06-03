/*
 * @Author Vincenzo Mastandrea
 * Grammar definition for ASP
 */

grammar gASP;

@header{
import models.*;
import java.util.HashMap;
import java.util.LinkedList;
}

@members{
	public HashMap<String, ClassDecl> classTable;
	public ClassDecl currentClass;
	public Method currentMethod;
	public Environment environment;
}

// A program is made up of class definitions and main function
program returns [Program prog]
				@init{classTable =  new HashMap<>(); }
				:   (classDec {classTable.put($classDec.classDecl.getClassName(),$classDec.classDecl);})* main=body
				    {$prog = new Program(classTable, $main.stb);};


classDec returns [ClassDecl classDecl]
				@init{HashMap<String, LinkedList<Method>> methods = new HashMap<>();
					  LinkedList<Method> methodList = null;
					  $classObj = new ClassDecl();
					  currentClass = $classObj;
					  }
				: 	cs = classSignature {$classObj = $cs.classObj;}
				    LCBRACK fields=varDeclaration {$classObj.setFields($fields.vars);}
				    		(m=methodDef {if (methods.containsKey($m.method.getMethodName()))
				    	                	   { LinkedList<Method> list = methods.get($m.method.getMethodName());
				    	                         if ($m.method.isIn(list))
				    	                         { System.out.println("The method "+ $m.method.getMethodName() +
				    	                                              " has been defined more than once! Rename it");
				    	                           System.exit(0); }
				    	                         else
				    	                         { $m.method.setID(methods.get($m.method.getMethodName()).size());
												   methods.get($m.method.getMethodName()).add($m.method);
											     }
 					    					   }
					    					   else
					    					   {  methodList = new LinkedList<>();
					    						  $m.method.setID(0);
					    						  methodList.add($m.method);
					    	                      methods.put($m.method.getMethodName(),methodList);
					    	                   }
				    	    })*
				     RCBRACK
				    { $classObj.setMethods(methods);};



//TOKENS
AND      : '&&' 	    ;
ASSIGN	 : '='	        ;
CLASS	 : 'class'      ;
COLON    : ':'	        ;
COMMA    : ','	        ;
DISTINCT : '!='	        ;
DIV      : '/' 	        ;
DOT      : '.'	        ;
ELSE	 : 'else'       ;
EQUALS   : '=='	        ;
GEG      : '>='	        ;
GT       : '>' 	        ;
IF		 : 'if'	        ;
INT		 : 'int'	    ;
LCBRACK  : '{'	        ;
LEG      : '<=' 	    ;
LPAR  	 : '('	        ;
LSBRACK  : '['	        ;
LT       : '<' 	        ;
MINUS    : '-' 	        ;
MULT     : '*' 	        ;
NEW		 : 'new'	    ;
NULL     : 'null'       ;
OR       : '||'         ;
PLUS     : '+' 	        ;
RCBRACK  : '}'	        ;
RETURN	 : 'return'     ;
RPAR  	 : ')'	        ;
RSBRACK  : ']'	        ;
SEMI     : ';'	        ;
SKIP     : 'skip'       ;
THIS	 : 'this'       ;

fragment CHAR 	: 'a'..'z' |'A'..'Z' ;
fragment CHAR_C  : 'a'..'z' |'A'..'Z' | '_';
fragment CHAR_U : 'A'..'Z';
fragment CHAR_L : 'a'..'z';



IDUC            : CHARUC (CHARU | DIGIT)* ;
IDLC            : CHARLC (CHARU | DIGIT)* ;


//ID              : (CHARLC | CHARUC | DIGIT | UNDER)* ;
//IDLC            : CHARLC ID ;
//IDUC            : CHARUC ID ;

fragment DIGIT	: '0'..'9';
NUMBER          : DIGIT+;

//SCAPED SEQUENCES
WS              : (' '|'\t'|'\n'|'\r')-> skip;
LINECOMENTS 	: '//' (~('\n'|'\r'))* -> skip;
BLOCKCOMENTS    : '/*'( ~('/'|'*')|'/'~'*'|'*'~'/'|BLOCKCOMENTS)* '*/' -> skip;