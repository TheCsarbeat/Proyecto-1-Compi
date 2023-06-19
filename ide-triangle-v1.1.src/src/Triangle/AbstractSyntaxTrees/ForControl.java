/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

/**
 *
 * @author Sebastian
 */
import Triangle.SyntacticAnalyzer.SourcePosition;
public class ForControl extends Declaration{

    public ForControl(Identifier iAST, Expression eAST, SourcePosition thePosition) {
        super(thePosition);
        I = iAST;
        E = eAST;
        
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitForControl(this, o);
    }
    
    
    public Identifier I;
    public Expression E;
    public TypeDenoter T;
    public int ArraySize;
}
