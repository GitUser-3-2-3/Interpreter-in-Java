# Interpreter in Java

* #### The Interpreter is in Progress.

This project is an attempt of making an Interpreter written in Java. It's inspired by and references the concepts from 
[Interpreter in Go](https://github.com/GitUser-3-2-3/Interpreter-in-Go).

## Overview

This project is an interpreter for the Nova programming language. The implementation consists of several key components.

* **Lexical Analysis (Lexer)** : Breaks the input source code into tokens.
* **Parsing** : Converts the tokens into an Abstract Syntax Tree(AST).
* **Evaluation** : Interprets and executes the AST.

## Directory Structure
*subject to change*
```
├── ast/        # Abstract Syntax Tree implementation
├── evaluator/  # Code for evaluating the AST
├── lexer/      # Lexer to tokenize the source code
├── object/     # Definitions of Nova language objects
├── parser/     # Parser to generate AST from tokens
├── repl/       # Read-Eval-Print Loop for interacting with the interpreter
├── token/      # Definitions of tokens
├── main.java   # Entry point for running the interpreter
└── README.md   # Project information and documentation
```

### Prerequisites

- Java (version 8 or higher)

## How to Run the Interpreter

Ensure you have Java installed on your system. Then clone the repository and run the interpreter as follows:

```bash
git clone https://github.com/GitUser-3-2-3/Interpreter-in-Java.git
cd Interpreter-in-Java
javac -d out src/main/java/**/*.java (Compiles the project)
java -cp out main.java
```

This will start the REPL (Read-Eval-Print Loop), where you can enter Nova code and see the interpreter's response.

## Resources

* Book: *Writing an Interpreter in Go* by Thorsten Ball
* [Interpreter in Go](https://github.com/GitUser-3-2-3/Interpreter-in-Go) for providing inspiration and reference

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.