package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class CaseRangeSimple extends CaseRange {

    public CaseRangeSimple(CaseLiteral caseL1, SourcePosition thePosition) {
        super(thePosition);
        caseLiteral1 = caseL1 ;
        //TODO Auto-generated constructor stub
    }
    
    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitCaseRangeSimple(this, o);
    }

    public CaseLiteral caseLiteral1;
}
