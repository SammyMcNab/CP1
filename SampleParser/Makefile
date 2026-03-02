JAVA=java
JAVAC=javac
JFLEX=/usr/bin/jflex
CLASSPATH=-cp /usr/share/java/java-cup-0.11b.jar:.
CUP=$(JAVA) $(CLASSPATH) java_cup.Main

all: Main.class

Main.class: absyn/*.java parser.java sym.java Lexer.java ShowTreeVisitor.java Scanner.java Main.java
	$(JAVAC) $(CLASSPATH) absyn/*.java parser.java sym.java Lexer.java ShowTreeVisitor.java Scanner.java Main.java

Lexer.java: cm.flex
	$(JFLEX) cm.flex

parser.java: cm.cup
	$(CUP) -expect 3 cm.cup

clean:
	rm -f parser.java Lexer.java sym.java *.class absyn/*.class *~
