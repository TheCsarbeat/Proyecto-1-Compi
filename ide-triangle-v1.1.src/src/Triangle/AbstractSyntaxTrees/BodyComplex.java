package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class BodyComplex extends BodyProgram{

    
    public BodyComplex(PackageDeclaration pacDecAST, Command cAST, SourcePosition thePosition) {
        super (thePosition);
        P = pacDecAST;
        C = cAST;
      }
    

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitBodyComplex(this, o);
    }

    public PackageDeclaration P;
    public Command C;

    
}
