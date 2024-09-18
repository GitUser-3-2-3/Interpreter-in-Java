package interpreter;

import interpreter.repl.Repl;

public class Main {
    public static void main(String[] args) {

        String username = System.getProperty("user.name");
        System.out.printf("Hello %s! This is the monkey programming language!\n", username);
        System.out.print("Feel free to type in commands\n");

        Repl.start(System.in, System.out);
    }
}
