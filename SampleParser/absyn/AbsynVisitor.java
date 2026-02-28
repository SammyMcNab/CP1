package absyn;

public interface AbsynVisitor {

  public void visit( DecList node, int level );

  public void visit( VarDecList node, int level );

  public void visit( ExpList node, int level );

  public void visit( GeneralDec node, int level );

  public void visit( ArrDec node, int level );

  public void visit( FunDec node, int level );

  public void visit( FunPro node, int level );

  public void visit( Type node, int level );

  public void visit( NilExp node, int level );

  public void visit( IntExp node, int level );

  public void visit( BoolExp node, int level );

  public void visit( VarExp node, int level );

  public void visit( OpExp node, int level );

  public void visit( AssignExp node, int level );

  public void visit( IfExp node, int level );

  public void visit( WhileExp node, int level );

  public void visit( ReturnExp node, int level );

  public void visit( CompoundExp node, int level );

  public void visit( CallExp node, int level );

}
