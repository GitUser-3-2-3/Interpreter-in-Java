package interpreter.lexer;

import interpreter.token.Token;
import lombok.Getter;

import static interpreter.token.Token.TokenType;

@Getter
public class Lexer {

    private final String input;
    private int position;

    private String character;
    private int readPosition;

    public Lexer(final String input) {
        this.input = input;
        readChar(input);
    }

    public String peekChar(final String input) {
        if (this.readPosition >= input.length()) {
            return "0";
        } else {
            return input.substring(this.readPosition, this.readPosition + 1);
        }
    }

    public void readChar(final String input) {
        if (this.readPosition >= input.length()) {
            this.character = "0";
        } else {
            this.character = input.substring(this.readPosition, this.readPosition + 1);
        }
        this.position = this.readPosition;
        this.readPosition += 1;
    }

    public Token nextToken() {
        Token token;

        spaceEater();
        switch (this.character) {
            case "=":
                token = readTwoChar(this.character, TokenType.EQ, TokenType.ASSIGN);
                break;
            case "+":
                token = new Token(TokenType.PLUS, this.character);
                break;
            case "-":
                token = new Token(TokenType.MINUS, this.character);
                break;
            case "!":
                token = readTwoChar(this.character, TokenType.NOT_EQ, TokenType.BANG);
                break;
            case "/":
                token = new Token(TokenType.SLASH, this.character);
                break;
            case "*":
                token = new Token(TokenType.ASTERISK, this.character);
                break;
            case "<":
                token = new Token(TokenType.LT, this.character);
                break;
            case ">":
                token = new Token(TokenType.GT, this.character);
                break;
            case ",":
                token = new Token(TokenType.COMMA, this.character);
                break;
            case ";":
                token = new Token(TokenType.SEMICOLON, this.character);
                break;
            case "(":
                token = new Token(TokenType.LPARAN, this.character);
                break;
            case ")":
                token = new Token(TokenType.RPARAN, this.character);
                break;
            case "{":
                token = new Token(TokenType.LBRACE, this.character);
                break;
            case "}":
                token = new Token(TokenType.RBRACE, this.character);
                break;
            case "0":
                token = new Token();

                token.setLiteral("");
                token.setType(TokenType.EOF);
                break;
            default:
                token = readDefaultToken();
                return token;
        }
        readChar(this.input);
        return token;
    }

    private void spaceEater() {
        while (this.character.equals(" ") || this.character.equals("\n") || this.character.equals("\t")
            || this.character.equals("\r")) {
            readChar(this.input);
        }
    }

    private Token readTwoChar(String character, TokenType twoCharType, TokenType oneCharType) {
        if (peekChar(this.input).equals("=")) {
            readChar(this.input);
            return new Token(twoCharType, character + this.character);
        }
        return new Token(oneCharType, character);
    }

    private Token readDefaultToken() {
        Token token = new Token();

        if (isLetter(this.character)) {
            token.setLiteral(readIdentifier());
            token.setType(token.lookupIdentifier(token.getLiteral()));
            return token;
        }
        if (isDigit(this.character)) {
            token.setType(TokenType.INT);
            token.setLiteral(readNumber());
            return token;
        }
        token.setType(TokenType.ILLEGAL);
        token.setLiteral(this.character);

        readChar(this.input);
        return token;
    }

    private String readIdentifier() {
        int position = this.position;

        while (isLetter(this.character)) {
            readChar(this.input);
        }
        return input.substring(position, this.position);
    }

    private String readNumber() {
        int position = this.position;

        while (isDigit(this.character)) {
            readChar(this.input);
        }
        return input.substring(position, this.position);
    }

    private boolean isLetter(String ch) {
        char c = ch.charAt(0);
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || c == '_';
    }

    private boolean isDigit(String ch) {
        char c = ch.charAt(0);
        return '0' <= c && c <= '9';
    }
}








