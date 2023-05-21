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

    public SingleCase(CaseLiterals caseL, Command command1, SourcePosition thePosition) {
        super(thePosition);
        caseLiterals = caseL;
        commandAST = command1;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitSingleCase(this, o);
    }
    public CaseLiterals caseLiterals;
    public Command commandAST; 
}
