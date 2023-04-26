package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class LongIdentifierSimple extends LongIdentifier{

    public LongIdentifierSimple(Identifier iAST,SourcePosition position) {
        super(position);
        I = iAST;
        
    }

    @Override
    public Object visit(Visitor v, Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    public Identifier I;
    
}
