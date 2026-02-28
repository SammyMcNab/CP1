package absyn;

public class Type extends Absyn {
  public String type;


  public Type( int row, int col, String type ) {
    this.row = row;
    this.col = col;
    this.type = type;
  }

  public void accept( AbsynVisitor visitor, int level ) {
    visitor.visit( this, level );
  }
}