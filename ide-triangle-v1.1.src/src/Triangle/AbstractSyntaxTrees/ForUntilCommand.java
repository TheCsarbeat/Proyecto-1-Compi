package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ForUntilCommand extends Command{
    public ForUntilCommand (Identifier iAST,  Expression e1AST, Expression e2AST, Expression e3AST, Command cAST, SourcePosition thePosition) {
        super (thePosition);
        I = iAST;
        E1 = e1AST;
        E2 = e2AST;
        E3 = e3AST;
        C = cAST;
    }
      public Object visit(Visitor v, Object o) {
        return v.visitForUntilCommand(this, o);
      }
    
      public Identifier I;
      public Expression E1;
      public Expression E2;
      public Expression E3;
      public Command C;
}
