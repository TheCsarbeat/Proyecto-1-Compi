package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class SingleCaseLiterals extends CaseLiterals{
    
    public SingleCaseLiterals(CaseRange cR, SourcePosition thePosition) {
        super(thePosition);
        caseRange = cR;
        //TODO Auto-generated constructor stub
    }

    

    @Override
    public Object visit(Visitor v, Object o) {
       return v.visitSingleCaseLiterals(this, o);
    }

    public CaseRange caseRange;
}
