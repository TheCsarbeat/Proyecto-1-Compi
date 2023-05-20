package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class BodySingle extends BodyProgram {

    public BodySingle(Command cAST, SourcePosition thePosition) {
        super(thePosition);
        C = cAST;
        //TODO Auto-generated constructor stub
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitBodySingle(this, o);
    }
    public Command C;
}
