package absyn;

public class FunDec extends Dec {
  public String name;
  public Type type;
  public String stmt;
  public VarDecList params;

  public FunDec( int row, int col, Type type, String name, VarDecList params, String stmt ) {
    this.row = row;
    this.col = col;
    this.type = type;
    this.name = name;
    this.stmt = stmt;
    this.params = params;

  }

  public void accept( AbsynVisitor visitor, int level ) {
    visitor.visit( this, level );
  }
}
