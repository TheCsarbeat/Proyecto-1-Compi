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

public abstract class PackageDeclaration extends AST{
    
    public PackageDeclaration (SourcePosition thePosition) {
        super (thePosition);
        
    }

}
