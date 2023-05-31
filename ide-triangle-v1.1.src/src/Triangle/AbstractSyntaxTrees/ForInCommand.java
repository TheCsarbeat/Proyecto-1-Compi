package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ForInCommand extends Command{
    public ForInCommand (ForControl ieiAST, Command cAST, SourcePosition thePosition) {
        super (thePosition);
        IEI = ieiAST;
        C = cAST;
    }
      public Object visit(Visitor v, Object o) {
        return v.visitForInCommand(this, o);
      }
    
      public ForControl IEI;
      public Command C;
}
