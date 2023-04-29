package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class PackageIdentifier extends Identifier{

    public PackageIdentifier(String theSpelling, SourcePosition thePosition) {
        super (theSpelling, thePosition);
        type = null;
        decl = null;
    }
    
    public PackageIdentifier(Identifier iAST){
        super(iAST.spelling, iAST.position);
        type = null;
        decl = null;
    }
    

}
