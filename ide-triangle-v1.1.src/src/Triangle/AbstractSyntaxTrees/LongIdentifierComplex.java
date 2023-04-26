package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class LongIdentifierComplex extends LongIdentifier {

    public LongIdentifierComplex(Identifier pAST, Identifier iAST,  SourcePosition position) {
        super(position);
        Pac = pAST;
        I = iAST;
        
        
    }

    @Override
    public Object visit(Visitor v, Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    public Identifier I;
    public Identifier Pac;
    
}
