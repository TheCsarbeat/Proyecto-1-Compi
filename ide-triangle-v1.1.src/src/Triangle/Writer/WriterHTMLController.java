package Triangle.Writer;

import Triangle.SyntacticAnalyzer.Scanner;
import Triangle.SyntacticAnalyzer.Token;

public class WriterHTMLController {
    private Scanner scanner;
    private Token currentToken;
    private WriterHTML writerHTML;

    public WriterHTMLController(Scanner scanner, WriterHTML writerHTML) {
        this.scanner = scanner;
        this.writerHTML = writerHTML;
    }

    public void writeHTML(){
        currentToken = scanner.scan();
        while (currentToken.kind != Token.EOT) {
            switch (currentToken.kind) {
                case Token.IDENTIFIER:
                    writerHTML.writeNormal(currentToken.spelling);
                    break;
                case Token.INTLITERAL:
                    writerHTML.writeBlue(currentToken.spelling);
                    break;
                case Token.CHARLITERAL:
                    writerHTML.writeBlue(currentToken.spelling);
                    break;
                case Token.COMMENT:
                    writerHTML.writeComment(currentToken.spelling);
                    break;
                case Token.EOL:
                    writerHTML.writeEndOfLine();
                    break;
                case Token.TAB:
                    writerHTML.writeTab();
                    break;                
                default:
                    //array of reserved words
                    String[] reservedWords = {"array", "const", "do", "else", "end", "for", "from", "func", "if", "in",
                    "let", "of", "package", "private", "proc", "rec","record", "repeat", "select", "skip", "then",
                    "times", "type", "until", "var", "when", "while"};
                    //check if the current token is a reserved word
                    boolean isReservedWord = false;
                    for (String reservedWord : reservedWords) {
                        if (currentToken.spelling.equals(reservedWord)) {
                            isReservedWord = true;
                            break;
                        }
                    }
                    if (isReservedWord) {
                        writerHTML.writeReservedWord(currentToken.spelling);
                    } else {
                        writerHTML.writeNormal(currentToken.spelling);
                    }
                    break;
            }
            currentToken = scanner.scan();
        }
        writerHTML.finishHTML();
    }
}
