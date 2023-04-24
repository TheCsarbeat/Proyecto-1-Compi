/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

/**
 *
 * @author chacalerks
 */

import Triangle.SyntacticAnalyzer.SourcePosition;

public class PackageDeclaration extends AST{
    
    public PackageDeclaration (Identifier iAST, Declaration dAST, SourcePosition thePosition) {
        super (thePosition);
        I = iAST;
        D = dAST;
    }
    
    public Object visit(Visitor v, Object o) {
        return v.visitPackageDeclaration(this, o);
    }

  public Identifier I;
  public Declaration D;
}
