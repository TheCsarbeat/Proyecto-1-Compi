package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class LongIdentifierComplex extends LongIdentifier {

    public LongIdentifierComplex(PackageIdentifier pAST, Identifier iAST,  SourcePosition position) {
        super(position);
        Pac = pAST;
        I = iAST;
        
        
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitLongIdentifierComplex(this, o);
    }

    public Identifier I;
    public PackageIdentifier Pac;
    
}
