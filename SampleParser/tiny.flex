/*
  Created By: Fei Song
  File Name: tiny.flex
  To Build: jflex tiny.flex

  and then after the parser is created
    javac Lexer.java
*/

import absyn.*;
   
/* --------------------------Usercode Section------------------------ */
   
import java_cup.runtime.*;
      
%%
   
/* -----------------Options and Declarations Section----------------- */
   
/* 
   The name of the class JFlex will create will be Lexer.
   Will write the code to the file Lexer.java. 
*/
%class Lexer

%eofval{
  return null;
%eofval};


/*
  The current line number can be accessed with the variable yyline
  and the current column number with the variable yycolumn.
*/
%line
%column
    
/* 
   Will switch to a CUP compatibility mode to interface with a CUP
   generated parser.
*/
%cup
   
/*
  Declarations
   
  Code between %{ and %}, both of which must be at the beginning of a
  line, will be copied letter to letter into the lexer class source.
  Here you declare member variables and functions that are used inside
  scanner actions.  
*/
%{   
    /* To create a new java_cup.runtime.Symbol with information about
       the current token, the token will have no value in this
       case. */
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    
    /* Also creates a new java_cup.runtime.Symbol with information
       about the current token, but this object has a value. */
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}
   

/*
  Macro Declarations
  
  These declarations are regular expressions that will be used latter
  in the Lexical Rules Section.  
*/
   

   
/* White space is a line terminator, space, tab, or form feed. */
whitespace = [ \t\f\r\n]+
digit = [0-9]
number = {digit}+
letter     = [_a-zA-Z]
identifier = {letter}[_a-zA-Z0-9]*
   
%%
/* ------------------------Lexical Rules Section---------------------- */
   
/*
   This section contains regular expressions and actions, i.e. Java
   code, that will be executed when the scanner matches the associated
   regular expression. */
   

<YYINITIAL> {   
 "bool"      { return symbol(sym.BOOL); }
  "else"      { return symbol(sym.ELSE); }
  "if"        { return symbol(sym.IF); }
  "int"       { return symbol(sym.INT); }
  "return"    { return symbol(sym.RETURN); }
  "void"      { return symbol(sym.VOID); }
  "while"     { return symbol(sym.WHILE); }

  "false"     { return symbol(sym.TRUTH, yytext()); }
  "true"      { return symbol(sym.TRUTH, yytext()); }

  "<="        { return symbol(sym.LE); }
  ">="        { return symbol(sym.GE); }
  "=="        { return symbol(sym.EQ); }
  "!="        { return symbol(sym.NE); }
  "||"        { return symbol(sym.OR); }
  "&&"        { return symbol(sym.AND); }

  "+"         { return symbol(sym.PLUS); }
  "-"         { return symbol(sym.MINUS); }
  "*"         { return symbol(sym.TIMES); }
  "/"         { return symbol(sym.OVER); }
  "<"         { return symbol(sym.LT); }
  ">"         { return symbol(sym.GT); }
  "!"         { return symbol(sym.NOT); }
  "="         { return symbol(sym.ASSIGN); }
  ";"         { return symbol(sym.SEMI); }
  ","         { return symbol(sym.COMMA); }
  "("         { return symbol(sym.LPAREN); }
  ")"         { return symbol(sym.RPAREN); }
  "["         { return symbol(sym.LBRACK); }
  "]"         { return symbol(sym.RBRACK); }
  "{"         { return symbol(sym.LBRACE); }
  "}"         { return symbol(sym.RBRACE); }

  "/*"        { yybegin(COMMENT); }


  {number}    { return symbol(sym.NUM, yytext()); }
  {identifier}{ return symbol(sym.ID, yytext()); }

  {whitespace}        { /* skip whitespace */ }

  .           { return symbol(sym.ERROR, yytext()); }
}
<COMMENT> {
  "*/"        { yybegin(YYINITIAL); }
  [^*\n\r]+   { /* skip */ }
  "*"         { /* skip */ }
  \r|\n|\r\n  { /* skip */ }
  <<EOF>>     { return symbol(sym.ERROR, "unterminated comment"); }
}