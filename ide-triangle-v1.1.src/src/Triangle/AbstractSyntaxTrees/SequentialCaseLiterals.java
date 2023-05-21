package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class SequentialCaseLiterals extends CaseLiterals{

    public SequentialCaseLiterals(CaseLiterals c1, CaseLiterals c2, SourcePosition thePosition) {
        super(thePosition);
        //TODO Auto-generated constructor stub
        caseLiteral1 = c1;
        caseLiteral2 = c2;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitSequentialCaseLiterals(this, o);
    }

    public CaseLiterals caseLiteral1;
    public CaseLiterals caseLiteral2;
    
}
