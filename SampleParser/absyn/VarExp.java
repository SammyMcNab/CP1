package absyn;

public class VarExp extends Exp {
  public String name;
  public Exp index;

  public VarExp( int row, int col, String name ) {
    this.row = row;
    this.col = col;
    this.name = name;
    this.index = null;
  }

  public VarExp( int row, int col, String name, Exp index ) {
    this.row = row;
    this.col = col;
    this.name = name;
    this.index = index;
  }

  public void accept( AbsynVisitor visitor, int level ) {
    visitor.visit( this, level );
  }
}
