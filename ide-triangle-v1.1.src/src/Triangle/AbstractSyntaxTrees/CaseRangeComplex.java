package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class CaseRangeComplex extends CaseRange{

    public CaseRangeComplex(CaseLiteral caseL1, CaseLiteral caseL2, SourcePosition thePosition) {
        super(thePosition);
        caseLiteral1 = caseL1;
        caseLiteral2 = caseL2;
        //TODO Auto-generated constructor stub
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitCaseRangeComplex(this, o);
    }

    public CaseLiteral caseLiteral1;
    public CaseLiteral caseLiteral2;
    
}
