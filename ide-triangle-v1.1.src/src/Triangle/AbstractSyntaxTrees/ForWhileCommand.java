package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;
import Triangle.AbstractSyntaxTrees.ForVarDeclaration;

public class ForWhileCommand extends Command{
    public ForWhileCommand (ForVarDeclaration d1AST, Expression e2AST, Expression e3AST, Command cAST, SourcePosition thePosition) {
    super (thePosition);
    D = d1AST;
    E2 = e2AST;
    E3 = e3AST;
    C = cAST;
  }
  
  public Object visit(Visitor v, Object o) {
    return v.visitForWhileCommand(this, o);
  }

  public Declaration D;
  public Expression E2;
  public Expression E3;
  public Command C;
}
