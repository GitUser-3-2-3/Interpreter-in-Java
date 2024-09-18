package interpreter.token;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Token {
    private TokenType type;
    private String literal;

    public Token() {
    }

    public Token(TokenType type, String literal) {
        this.type = type;
        this.literal = literal;
    }

    @Getter
    public enum TokenType {
        ILLEGAL("ILLEGAL"), EOF("EOF"),

        // Identifiers and Literals
        IDENT("IDENT"), INT("INT"),

        // Operators
        ASSIGN("ASSIGN"), PLUS("PLUS"), MINUS("MINUS"),
        BANG("BANG"), ASTERISK("ASTERISK"), SLASH("SLASH"),
        LT("LT"), GT("GT"), EQ("EQ"), NOT_EQ("NOT_EQ"),

        // Delimiters
        COMMA("COMMA"), SEMICOLON("SEMICOLON"),
        LPARAN("("), RPARAN(")"), LBRACE("{"), RBRACE("}"),

        // Keywords
        FUNCTION("FUNCTION"), LET("LET"), TRUE("TRUE"), FALSE("FALSE"),
        IF("IF"), ELSE("ELSE"), RETURN("RETURN");

        private final String Literal;

        TokenType(String literal) {
            this.Literal = literal;
        }
    }

    private static final Map<String, TokenType> keywords = new HashMap<>();

    static {
        keywords.put("fn", TokenType.FUNCTION);
        keywords.put("let", TokenType.LET);
        keywords.put("true", TokenType.TRUE);
        keywords.put("false", TokenType.FALSE);
        keywords.put("if", TokenType.IF);
        keywords.put("else", TokenType.ELSE);
        keywords.put("return", TokenType.RETURN);
    }

    public TokenType lookupIdentifier(final String ident) {
        return keywords.getOrDefault(ident, TokenType.IDENT);
    }
}







