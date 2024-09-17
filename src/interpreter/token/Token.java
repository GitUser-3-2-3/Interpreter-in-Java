package interpreter.token;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ClassCanBeRecord")
public class Token {
    private final TokenType type;
    private final String literal;

    public Token(TokenType type, String literal) {
        this.type = type;
        this.literal = literal;
    }

    public TokenType getType() {
        return type;
    }

    public String getLiteral() {
        return literal;
    }

    public enum TokenType {
        ILLEGAL("ILLEGAL"), EOF("EOF"),

        // Identifiers and Literals
        IDENT("IDENT"), INT("INT"),

        // Operators
        ASSIGN("ASSIGN"), PLUS("PLUS"),

        // Delimiters
        COMMA("COMMA"), SEMICOLON("SEMICOLON"),
        LPARAN("("), RPARAN(")"), LBRACE("{"), RBRACE("}"),

        // Keywords
        FUNCTION("FUNCTION"), LET("LET");

        private final String Literal;

        TokenType(String literal) {
            this.Literal = literal;
        }

        public String getLiteral() {
            return Literal;
        }
    }

    private static final Map<String, TokenType> keywords = new HashMap<>();

    static {
        keywords.put("fn", TokenType.FUNCTION);
        keywords.put("let", TokenType.LET);
    }

    public TokenType lookupIdentifier(final String ident) {
        return keywords.getOrDefault(ident, TokenType.IDENT);
    }
}







