package absyn;

public class FunPro extends Dec {
  public String name;
  public Type type;
  public VarDecList params;

  public FunPro( int row, int col, Type type, String name, VarDecList params ) {
    this.row = row;
    this.col = col;
    this.type = type;
    this.name = name;
    this.params = params;

  }

  public void accept( AbsynVisitor visitor, int level ) {
    visitor.visit( this, level );
  }
}
