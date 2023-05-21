package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author erks
 */
public class SelectCommandSimple extends Command {

    public SelectCommandSimple(Expression eAST, Case casesAST, SourcePosition thePosition) {
        super(thePosition);
        E = eAST;
        C = casesAST;
    }

    public Object visit(Visitor v, Object o) {
        return v.visitSelectCommandSimple(this, o);
    }

    
    public Expression E;
    public Case C;
}


