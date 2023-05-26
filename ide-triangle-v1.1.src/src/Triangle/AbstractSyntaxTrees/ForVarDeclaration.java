package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ForVarDeclaration extends Declaration {
    public ForVarDeclaration (Identifier iAST, Expression eAST,
                             SourcePosition thePosition) {
     super (thePosition);
     I = iAST;
     E1 = eAST;
    }
    
    public Object visit(Visitor v, Object o) {
    return v.visitForVarDeclaration(this, o);
    }
    
    public Identifier I;
    public Expression E1;
}
