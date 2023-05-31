package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ForInCommand extends Command{
    public ForInCommand (Identifier iAST,  Expression e1AST, Command cAST, SourcePosition thePosition) {
        super (thePosition);
        I = iAST;
        E1 = e1AST;
        C = cAST;
    }
      public Object visit(Visitor v, Object o) {
        return v.visitForInCommand(this, o);
      }
    
      public Identifier I;
      public Expression E1;
      public Command C;
}
