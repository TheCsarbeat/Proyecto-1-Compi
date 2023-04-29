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
public class CaseLiteral extends AST{
    public CaseLiteral (IntegerLiteral iAST, SourcePosition thePosition) {
        super (thePosition);
        integerLiteralAST = iAST;
    }

    public CaseLiteral (CharacterLiteral cAST, SourcePosition thePosition) {
        super (thePosition);
        characterLiteralAST = cAST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }
    
    public IntegerLiteral integerLiteralAST;
    public CharacterLiteral characterLiteralAST;
     
    
}
