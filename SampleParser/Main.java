import java.io.*;
import absyn.*;

class Main {
  static public void main(String argv[]) {
    boolean showTree = false;
    String filename = null;

    for (String arg : argv) {
      if (arg.equals("-a")) {
        showTree = true;
      } else {
        filename = arg;
      }
    }

    if (filename == null) {
      System.err.println("Usage: CM [-a] <filename>");
      System.exit(1);
    }

    try {
      parser p = new parser(new Lexer(new FileReader(filename)));
      Absyn result = (Absyn)(p.parse().value);

      if (showTree && result != null) {
        System.out.println("The abstract syntax tree is:");
        AbsynVisitor visitor = new ShowTreeVisitor();
        result.accept(visitor, 0);
      }

      if (!parser.valid) {
        System.err.println("Parsing completed with errors.");
      }
    } catch (Exception e) {
      System.err.println("Unexpected error: " + e.getMessage());
    }
  }
}
