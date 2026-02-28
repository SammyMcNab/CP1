package absyn;

public class CompoundExp extends Exp {
  public VarDecList decs;
  public ExpList stmts;

  public CompoundExp( int row, int col, VarDecList decs, ExpList stmts ) {
    this.row = row;
    this.col = col;
    this.decs = decs;
    this.stmts = stmts;
  }

  public void accept( AbsynVisitor visitor, int level ) {
    visitor.visit( this, level );
  }
}
