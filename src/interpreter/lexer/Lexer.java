package interpreter.lexer;

import interpreter.token.Token;
import lombok.Getter;

import static interpreter.token.Token.TokenType;

@Getter
public class Lexer {

    private final String input;
    private int position;
    private int readPosition;
    private char ch;

    public Lexer(String input) {
        this.input = input;
        readChar(input);
    }

    public void readChar(String input) {
        if (this.readPosition >= input.length()) {
            this.ch = 0;
        } else {
            this.ch = input.charAt(readPosition);
        }
        this.position = this.readPosition;
        this.readPosition += 1;
    }

    public Token nextToken() {

        Token token = new Token();
        spaceEater();

        final String character = string(this.ch);
        switch (character) {
            case "=":
                token = new Token(TokenType.ASSIGN, character);
                break;
            case ";":
                token = new Token(TokenType.SEMICOLON, character);
                break;
            case "(":
                token = new Token(TokenType.LPARAN, character);
                break;
            case ",":
                token = new Token(TokenType.COMMA, character);
                break;
            case "+":
                token = new Token(TokenType.PLUS, character);
                break;
            case ")":
                token = new Token(TokenType.RPARAN, character);
                break;
            case "{":
                token = new Token(TokenType.LBRACE, character);
                break;
            case "}":
                token = new Token(TokenType.RBRACE, character);
                break;
            case "0":
                token.setLiteral("");
                token.setType(TokenType.EOF);
            default:
                if (isLetter(this.ch)) {
                    token.setLiteral(readIdentifier());
                    token.setType(token.lookupIdentifier(token.getLiteral()));
                    return token;
                } else if (isDigit(this.ch)) {
                    token.setType(TokenType.INT);
                    token.setLiteral(readNumber());
                    return token;
                } else {
                    token = new Token(TokenType.ILLEGAL, character);
                }
        }
        readChar(this.input);
        return token;
    }

    private void spaceEater() {
        while (this.ch == ' ' || this.ch == '\n' || this.ch == '\t'
            || this.ch == '\r') {
            readChar(this.input);
        }
    }

    private String readIdentifier() {
        int position = this.position;
        while (isLetter(this.ch)) {
            readChar(this.input);
        }
        return input.substring(position, this.position);
    }

    private String readNumber() {
        int position = this.position;
        while (isDigit(this.ch)) {
            readChar(this.input);
        }
        return input.substring(position, this.position);
    }

    private boolean isLetter(char ch) {
        return 'a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z' || ch == '_';
    }

    private boolean isDigit(char ch) {
        return '0' <= ch && ch <= '9';
    }

    private String string(char input) {
        return Character.toString(input);
    }
}








