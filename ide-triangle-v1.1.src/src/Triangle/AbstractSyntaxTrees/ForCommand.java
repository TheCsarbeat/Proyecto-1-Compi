package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;
import Triangle.AbstractSyntaxTrees.ForVarDeclaration;

public class ForCommand extends Command{
    public ForCommand (ForVarDeclaration d1AST, Expression e1AST, 
                  Command cAST, SourcePosition thePosition) {
    super (thePosition);
    D = d1AST;
    E1 = e1AST;
    C = cAST;
  }
  
  public Object visit(Visitor v, Object o) {
    return v.visitForCommand(this, o);
  }

  public Declaration D;
  public Expression E1;
  public Command C;
}
