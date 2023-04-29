package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class SequentialCase extends Case{

    public SequentialCase(Case c1, Case c2, SourcePosition thePosition) {
        super(thePosition);
        //TODO Auto-generated constructor stub
        Case1 = c1;
        Case2 = c2;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Case Case1, Case2;
    
}
