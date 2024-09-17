package interpreter.lexer;

import interpreter.token.Token;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static interpreter.token.Token.TokenType;

public class LexerTest {

    @Test
    public void testNextToken() {
        String input = """
            let five = 5;
            let ten = 10;
            
            let add = fn(x, y) {
                x + y;
            };
            
            let result = add(five, ten);
            """;

        // Expected token types and literals
        Object[][] tests = {
            {TokenType.LET, "let"},
            {TokenType.IDENT, "five"},
            {TokenType.ASSIGN, "="},
            {TokenType.INT, "5"},
            {TokenType.SEMICOLON, ";"},
            {TokenType.LET, "let"},
            {TokenType.IDENT, "ten"},
            {TokenType.ASSIGN, "="},
            {TokenType.INT, "10"},
            {TokenType.SEMICOLON, ";"},
            {TokenType.LET, "let"},
            {TokenType.IDENT, "add"},
            {TokenType.ASSIGN, "="},
            {TokenType.FUNCTION, "fn"},
            {TokenType.LPARAN, "("},
            {TokenType.IDENT, "x"},
            {TokenType.COMMA, ","},
            {TokenType.IDENT, "y"},
            {TokenType.RPARAN, ")"},
            {TokenType.LBRACE, "{"},
            {TokenType.IDENT, "x"},
            {TokenType.PLUS, "+"},
            {TokenType.IDENT, "y"},
            {TokenType.SEMICOLON, ";"},
            {TokenType.RBRACE, "}"},
            {TokenType.SEMICOLON, ";"},
            {TokenType.LET, "let"},
            {TokenType.IDENT, "result"},
            {TokenType.ASSIGN, "="},
            {TokenType.IDENT, "add"},
            {TokenType.LPARAN, "("},
            {TokenType.IDENT, "five"},
            {TokenType.COMMA, ","},
            {TokenType.IDENT, "ten"},
            {TokenType.RPARAN, ")"}
        };

        Lexer lexer = new Lexer(input);
        for (int i = 0; i < tests.length; i++) {
            Token expected = new Token((TokenType) tests[i][0], tests[i][1].toString());
            Token actual = lexer.nextToken();
            assertTokenEquals(expected, actual, i);
        }
    }

    private void assertTokenEquals(Token expected, Token actual, int index) {
        Assertions.assertEquals(expected.getType(), actual.getType(),
            String.format("tests[%d] - TokenType wrong. Expected ==> %s, Got ==> %s", index, expected, actual));
    }
}







