package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class CaseLiteralChar extends CaseLiteral{

    public CaseLiteralChar(CharacterLiteral cAST, SourcePosition thePosition) {
        super(thePosition);
        literal = cAST;
        //TODO Auto-generated constructor stub
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitCaseLiteralChar(this, o);
    }
    
    public CharacterLiteral literal;
}
