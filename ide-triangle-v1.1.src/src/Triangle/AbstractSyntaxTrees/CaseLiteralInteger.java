package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class CaseLiteralInteger extends CaseLiteral{

    public CaseLiteralInteger(IntegerLiteral iAST, SourcePosition thePosition) {
        super(thePosition);
        literal = iAST;
        //TODO Auto-generated constructor stub
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitCaseLiteralInteger(this, o);
    }

    public IntegerLiteral literal;
    
}
