package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RepeatTimes extends Command {
    public RepeatTimes(Expression eAST,Command cAST , SourcePosition thePosition) {
        super(thePosition);
        C = cAST;
        E = eAST;
    }

    public Object visit(Visitor v, Object o) {
        return v.visitRepeatTimes(this, o);
    }

    public Expression E;
    public Command C;
}
