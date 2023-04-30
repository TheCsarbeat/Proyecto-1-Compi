package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author erks
 */

public class SequentialCase extends Case{

    public SequentialCase(Case c1, Case c2, SourcePosition thePosition) {
        super(thePosition);
        //TODO Auto-generated constructor stub
        Case1 = c1;
        Case2 = c2;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitSequentialCase(this, o);
    }

    public Case Case1, Case2;
    
}
