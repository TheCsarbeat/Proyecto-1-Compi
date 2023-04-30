package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

// Authot: Maynor Martínez
public class SequentialPackage extends PackageDeclaration{

    public SequentialPackage(PackageDeclaration p1, PackageDeclaration p2, SourcePosition thePosition) {
        super(thePosition);
        package1 = p1;
        package2 = p2;
        //TODO Auto-generated constructor stub
    }
    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitSequentialPackageDeclaration(this, o);
    }

    public PackageDeclaration package1, package2;
}
