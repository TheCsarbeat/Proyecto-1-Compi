package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class DoWhileLoop extends Command {
    public DoWhileLoop(Command cAST, Expression eAST, SourcePosition thePosition) {
        super(thePosition);
        C = cAST;
        E = eAST;
    }

    public Object visit(Visitor v, Object o) {
        return v.visitDoWhileLoop(this, o);
    }

    public Expression E;
    public Command C;
}