/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;
import Triangle.SyntacticAnalyzer.SourcePosition;
/**
 *
 * @author muril
 */
public class RECDeclaration extends Declaration{

    public RECDeclaration(Declaration pfsAST,SourcePosition thePosition) {
        super(thePosition);
        
        PFS = pfsAST;
  }
  
  public Object visit (Visitor v, Object o) {
    return v.visitRecDeclaration(this, o);
  }
  
  public Declaration PFS;
    }
   
    

