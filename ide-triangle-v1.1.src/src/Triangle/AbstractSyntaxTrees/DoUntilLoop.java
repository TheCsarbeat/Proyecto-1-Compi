package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class DoUntilLoop extends Command {
    public DoUntilLoop(Command cAST, Expression eAST, SourcePosition thePosition) {
        super(thePosition);
        C = cAST;
        E = eAST;
    }

    public Object visit(Visitor v, Object o) {
        return v.visitDoUntilLoop(this, o);
    }

    public Expression E;
    public Command C;
}
