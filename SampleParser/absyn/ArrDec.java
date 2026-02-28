package absyn;

public class ArrDec extends GeneralDec {
    public int size;

  public ArrDec( int row, int col, String type, String name, int size ) {
    super(row, col, type, name)
    this.size = size;
  }

  public void accept( AbsynVisitor visitor, int level ) {
    visitor.visit( this, level );
  }
}