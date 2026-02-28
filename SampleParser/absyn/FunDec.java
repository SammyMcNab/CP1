package absyn;

public class FunDec extends Dec {
  public String name;
  public Type type;
  public Exp body;
  public VarDecList params;

  public FunDec( int row, int col, Type type, String name, VarDecList params, String body ) {
    this.row = row;
    this.col = col;
    this.type = type;
    this.name = name;
    this.body = body;
    this.params = params;

  }

  public void accept( AbsynVisitor visitor, int level ) {
    visitor.visit( this, level );
  }
}
