We used the provided Tiny parser as our starting point and adapted it for the C- language. The scanner (`cm.flex`), grammar (`cm.cup`), abstract syntax tree classes (`absyn/`), and visitor (`ShowTreeVisitor.java`) were all extended or rewritten to support C- syntax.

ArrDec could be VarDec based on the grammar but we named it ArrDec to avoid confusion when viewing the output.

## Building

From the `SampleParser/` directory:

1. type "make" to make all dependencies 

## Testing / Exec

Run the parser on a C- source file with the `-a` flag to print the abstract syntax tree:

```
java -cp /usr/share/java/cup.jar:. Main filename.cm -a
```

Without `-a`, the parser will only report errors (if any) without printing the tree.

Note: Use "make clean" to remove compiled files 
