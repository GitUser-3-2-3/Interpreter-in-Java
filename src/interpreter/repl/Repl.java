package interpreter.repl;

import interpreter.lexer.Lexer;
import interpreter.token.Token;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Repl {
    private static final String PROMPT = ">>";

    public static void start(InputStream input, OutputStream output) {
        Scanner scanner = new Scanner(input);
        PrintStream printStream = new PrintStream(output);

        while (true) {
            printStream.print(PROMPT);
            if (!scanner.hasNextLine()) {
                return;
            }
            String line = scanner.nextLine();
            Lexer lexer = new Lexer(line);

            Token tok;
            while ((tok = lexer.nextToken()).getType() != Token.TokenType.EOF) {
                printStream.println(tok);
            }
        }
    }
}
