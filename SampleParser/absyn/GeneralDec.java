package absyn;

public class GeneralDec extends Exp {
  public String name;

  public GeneralDec( int row, int col, String type, String name ) {
    this.row = row;
    this.col = col;
    this.type = type;
    this.name = name;
  }

  public void accept( AbsynVisitor visitor, int level ) {
    visitor.visit( this, level );
  }
}
