package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class PackageIdentifier extends Identifier{

    public PackageIdentifier(String theSpelling, SourcePosition thePosition) {
        super (theSpelling, thePosition);
        type = null;
        decl = null;
    }
    


}
