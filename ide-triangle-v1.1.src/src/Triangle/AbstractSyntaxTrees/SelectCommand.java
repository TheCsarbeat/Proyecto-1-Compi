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
public class SelectCommand extends Command{

    public SelectCommand(Expression eAST, Case casesAST, Command cAST, SourcePosition thePosition) {
        super(thePosition);
        E = eAST;
        C = casesAST;
        elseCommand = cAST;
    }

    public SelectCommand(Expression eAST, Case casesAST,  SourcePosition thePosition) {
        super(thePosition);
        E = eAST;
        C = casesAST;
    }

    public Object visit(Visitor v, Object o) {
        return v.visitSelectCommand(this, o);
    }

    
    public Expression E;
    public Case C;
    public Command elseCommand;
    

}
