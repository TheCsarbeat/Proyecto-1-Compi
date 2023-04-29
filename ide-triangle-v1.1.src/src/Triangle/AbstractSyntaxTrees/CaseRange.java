/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author erks
 */
public class CaseRange extends AST{

    public CaseRange(CaseLiteral caseL1, CaseLiteral caseL2, SourcePosition thePosition) {
        super(thePosition);
        //TODO Auto-generated constructor stub
        caseLiteral1 = caseL1;
        caseLiteral2 = caseL2;
    }

    public CaseRange(CaseRange caseR, CaseRange caseR2, SourcePosition thePosition) {
        super(thePosition);
        //TODO Auto-generated constructor stub
        caseRange = caseR;
        caseRange2 = caseR2;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }
    public CaseRange caseRange, caseRange2;
    public CaseLiteral caseLiteral1, caseLiteral2;

    
}
