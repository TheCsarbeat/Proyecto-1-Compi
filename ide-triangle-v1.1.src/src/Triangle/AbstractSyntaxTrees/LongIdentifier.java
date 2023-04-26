package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public abstract class LongIdentifier extends AST{
    
    public LongIdentifier (SourcePosition position) {
        super (position);
    }
    
    public Identifier getSimpleIdentifier(){

        Identifier iAST = null;    

        //This if is to check if the longIdentifier is a longIdentifierComplex or a longIdentifierSimple and save the simpleIdentifier in iAST
        if (this.getClass() == LongIdentifierComplex.class) {
          iAST = ((LongIdentifierComplex) this).I;
        } else {
          iAST = ((LongIdentifierSimple) this).I;
        }

        return iAST;
    }
    
}
