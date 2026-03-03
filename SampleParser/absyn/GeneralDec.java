package absyn;

public class GeneralDec extends Dec {
  public String name;
  public Type type;

  public GeneralDec( int row, int col, Type type, String name ) {
    this.row = row;
    this.col = col;
    this.type = type;
    this.name = name;
  }

  public void accept( AbsynVisitor visitor, int level ) {
    visitor.visit( this, level );
  }
}
