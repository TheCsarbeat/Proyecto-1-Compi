/*
 * @(#)Token.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.SyntacticAnalyzer;


final class Token extends Object {

  protected int kind;
  protected String spelling;
  protected SourcePosition position;

  public Token(int kind, String spelling, SourcePosition position) {

    if (kind == Token.IDENTIFIER) {
      int currentKind = firstReservedWord;
      boolean searching = true;

      while (searching) {
        int comparison = tokenTable[currentKind].compareTo(spelling);
        if (comparison == 0) {
          this.kind = currentKind;
          searching = false;
        } else if (comparison > 0 || currentKind == lastReservedWord) {
          this.kind = Token.IDENTIFIER;
          searching = false;
        } else {
          currentKind ++;
        }
      }
    } else
      this.kind = kind;

    this.spelling = spelling;
    this.position = position;

  }

  public static String spell (int kind) {
    return tokenTable[kind];
  }

  public String toString() {
    return "Kind=" + kind + ", spelling=" + spelling +
      ", position=" + position;
  }

  // Token classes...

  public static final int

    // literals, identifiers, operators...
    INTLITERAL	= 0,
    CHARLITERAL	= 1,
    IDENTIFIER	= 2,
    OPERATOR	= 3,

    // reserved words - must be in alphabetical order...
    ARRAY		= 4,
    BEGIN		= 5,
    CONST		= 6,
    DO			= 7,
    ELSE		= 8,
    END			= 9,
    FUNC		= 10,
    IF			= 11,
    IN			= 12,
    LET			= 13,
    OF			= 14,
    PIPELINE            = 15, // token agregado
    PRIVATE             = 16, // token agregado
    PROC		= 17,
    REC                 = 18, // token agregado
    RECORD		= 19,
    THEN		= 20,
    TYPE		= 21,
    VAR			= 22,
    WHILE		= 23,

    // punctuation...
    DOT			= 24,
    COLON		= 25,
    SEMICOLON	        = 26,
    COMMA		= 27,
    BECOMES		= 28,
    IS			= 29,

    // brackets...
    LPAREN		= 30,
    RPAREN		= 31,
    LBRACKET            = 32,
    RBRACKET            = 33,
    LCURLY		= 34,
    RCURLY		= 35,

    // special tokens...
    EOT			= 36,
    ERROR		= 37;
    
    // agregados
    
    

  private static String[] tokenTable = new String[] {
    "<int>",
    "<char>",
    "<identifier>",
    "<operator>",
    "array",
    "begin",
    "const",
    "do",
    "else",
    "end",
    "func",
    "if",
    "in",
    "let",
    "of",
    "proc",
    "record",
    "then",
    "type",
    "var",
    "while",
    ".",
    ":",
    ";",
    ",",
    ":=",
    "~",
    "(",
    ")",
    "[",
    "]",
    "{",
    "}",
    "",
    "<error>",
    "|" // se agregó este token 
  };

  private final static int	firstReservedWord = Token.ARRAY,
  				lastReservedWord  = Token.WHILE;

}
