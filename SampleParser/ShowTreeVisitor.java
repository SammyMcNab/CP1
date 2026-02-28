import absyn.*;

public class ShowTreeVisitor implements AbsynVisitor {

  final static int SPACES = 4;

  private void indent( int level ) {
    for( int i = 0; i < level * SPACES; i++ ) System.out.print( " " );
  }

  public void visit( DecList decList, int level ) {
    while( decList != null ) {
      decList.head.accept( this, level );
      decList = decList.tail;
    }
  }

  public void visit( VarDecList varDecList, int level ) {
    while( varDecList != null ) {
      varDecList.head.accept( this, level );
      varDecList = varDecList.tail;
    }
  }

  public void visit( ExpList expList, int level ) {
    while( expList != null ) {
      expList.head.accept( this, level );
      expList = expList.tail;
    }
  }

  public void visit( GeneralDec dec, int level ) {
    indent( level );
    System.out.println( "GeneralDec: " + dec.name );
    level++;
    dec.type.accept( this, level );
  }

  public void visit( ArrDec dec, int level ) {
    indent( level );
    System.out.println( "ArrDec: " + dec.name + "[" + dec.size + "]" );
    level++;
    dec.type.accept( this, level );
  }

  public void visit( FunDec dec, int level ) {
    indent( level );
    System.out.println( "FunDec: " + dec.name );
    level++;
    dec.type.accept( this, level );
    if( dec.params != null )
      dec.params.accept( this, level );
    if( dec.body != null )
      dec.body.accept( this, level );
  }

  public void visit( FunPro dec, int level ) {
    indent( level );
    System.out.println( "FunPro: " + dec.name );
    level++;
    dec.type.accept( this, level );
    if( dec.params != null )
      dec.params.accept( this, level );
  }

  public void visit( Type type, int level ) {
    indent( level );
    System.out.println( "Type: " + type.type );
  }

  public void visit( NilExp exp, int level ) {
  }

  public void visit( IntExp exp, int level ) {
    indent( level );
    System.out.println( "IntExp: " + exp.value );
  }

  public void visit( BoolExp exp, int level ) {
    indent( level );
    System.out.println( "BoolExp: " + exp.value );
  }

  public void visit( VarExp exp, int level ) {
    indent( level );
    if( exp.index != null ) {
      System.out.println( "VarExp: " + exp.name + "[]" );
      exp.index.accept( this, level + 1 );
    } else {
      System.out.println( "VarExp: " + exp.name );
    }
  }

  public void visit( OpExp exp, int level ) {
    indent( level );
    System.out.print( "OpExp:" );
    switch( exp.op ) {
      case OpExp.PLUS:
        System.out.println( " + " );
        break;
      case OpExp.MINUS:
        System.out.println( " - " );
        break;
      case OpExp.UMINUS:
        System.out.println( " -u " );
        break;
      case OpExp.MUL:
        System.out.println( " * " );
        break;
      case OpExp.DIV:
        System.out.println( " / " );
        break;
      case OpExp.LT:
        System.out.println( " < " );
        break;
      case OpExp.LE:
        System.out.println( " <= " );
        break;
      case OpExp.GT:
        System.out.println( " > " );
        break;
      case OpExp.GE:
        System.out.println( " >= " );
        break;
      case OpExp.EQ:
        System.out.println( " == " );
        break;
      case OpExp.NE:
        System.out.println( " != " );
        break;
      case OpExp.NOT:
        System.out.println( " ! " );
        break;
      case OpExp.AND:
        System.out.println( " && " );
        break;
      case OpExp.OR:
        System.out.println( " || " );
        break;
      default:
        System.out.println( "Unrecognized operator at line " + exp.row + " and column " + exp.col );
    }
    level++;
    if( exp.left != null )
      exp.left.accept( this, level );
    if( exp.right != null )
      exp.right.accept( this, level );
  }

  public void visit( AssignExp exp, int level ) {
    indent( level );
    System.out.println( "AssignExp:" );
    level++;
    exp.lhs.accept( this, level );
    exp.rhs.accept( this, level );
  }

  public void visit( IfExp exp, int level ) {
    indent( level );
    System.out.println( "IfExp:" );
    level++;
    exp.test.accept( this, level );
    exp.thenpart.accept( this, level );
    if( exp.elsepart != null && !(exp.elsepart instanceof NilExp) )
      exp.elsepart.accept( this, level );
  }

  public void visit( WhileExp exp, int level ) {
    indent( level );
    System.out.println( "WhileExp:" );
    level++;
    exp.test.accept( this, level );
    exp.body.accept( this, level );
  }

  public void visit( ReturnExp exp, int level ) {
    indent( level );
    System.out.println( "ReturnExp:" );
    level++;
    if( exp.exp != null && !(exp.exp instanceof NilExp) )
      exp.exp.accept( this, level );
  }

  public void visit( CompoundExp exp, int level ) {
    indent( level );
    System.out.println( "CompoundExp:" );
    level++;
    if( exp.decs != null )
      exp.decs.accept( this, level );
    if( exp.stmts != null )
      exp.stmts.accept( this, level );
  }

  public void visit( CallExp exp, int level ) {
    indent( level );
    System.out.println( "CallExp: " + exp.func );
    level++;
    if( exp.args != null )
      exp.args.accept( this, level );
  }

}
