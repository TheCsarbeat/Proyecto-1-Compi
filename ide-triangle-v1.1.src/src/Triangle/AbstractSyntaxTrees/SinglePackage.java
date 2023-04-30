package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class SinglePackage extends PackageDeclaration{

    public SinglePackage(Identifier iAST, Declaration dAST, SourcePosition thePosition) {
        super( thePosition);
        I = iAST;
        D = dAST;
        //TODO Auto-generated constructor stub
    }
    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitSinglePackageDeclaration(this, o);
    }
    

    public Identifier I;
    public Declaration D;
    
}
