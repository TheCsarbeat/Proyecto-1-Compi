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
public class SingleCase extends Case{

    public SingleCase(CaseRange caseL, Command cAST, SourcePosition thePosition) {
        super(thePosition);
        caseLiteralsAST = caseL;
        commandAST = cAST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitSingleCase(this, o);
    }
    
    public CaseRange caseLiteralsAST;
    public Command commandAST; 
}
