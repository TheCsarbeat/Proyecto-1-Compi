package Triangle.Writer;

import Triangle.AbstractSyntaxTrees.AnyTypeDenoter;
import Triangle.AbstractSyntaxTrees.ArrayExpression;
import Triangle.AbstractSyntaxTrees.ArrayTypeDenoter;
import Triangle.AbstractSyntaxTrees.AssignCommand;
import Triangle.AbstractSyntaxTrees.BinaryExpression;
import Triangle.AbstractSyntaxTrees.BinaryOperatorDeclaration;
import Triangle.AbstractSyntaxTrees.BodyComplex;
import Triangle.AbstractSyntaxTrees.BodySingle;
import Triangle.AbstractSyntaxTrees.BoolTypeDenoter;
import Triangle.AbstractSyntaxTrees.CallCommand;
import Triangle.AbstractSyntaxTrees.CallExpression;
import Triangle.AbstractSyntaxTrees.CaseLiteral;
import Triangle.AbstractSyntaxTrees.CaseLiteralChar;
import Triangle.AbstractSyntaxTrees.CaseLiteralInteger;
import Triangle.AbstractSyntaxTrees.CaseRange;
import Triangle.AbstractSyntaxTrees.CaseRangeComplex;
import Triangle.AbstractSyntaxTrees.CaseRangeSimple;
import Triangle.AbstractSyntaxTrees.CharTypeDenoter;
import Triangle.AbstractSyntaxTrees.CharacterExpression;
import Triangle.AbstractSyntaxTrees.CharacterLiteral;
import Triangle.AbstractSyntaxTrees.ConstActualParameter;
import Triangle.AbstractSyntaxTrees.ConstDeclaration;
import Triangle.AbstractSyntaxTrees.ConstFormalParameter;
import Triangle.AbstractSyntaxTrees.DoUntilLoop;
import Triangle.AbstractSyntaxTrees.DoWhileLoop;
import Triangle.AbstractSyntaxTrees.DotVname;
import Triangle.AbstractSyntaxTrees.EmptyActualParameterSequence;
import Triangle.AbstractSyntaxTrees.EmptyCommand;
import Triangle.AbstractSyntaxTrees.EmptyExpression;
import Triangle.AbstractSyntaxTrees.EmptyFormalParameterSequence;
import Triangle.AbstractSyntaxTrees.ErrorTypeDenoter;
import Triangle.AbstractSyntaxTrees.ForCommand;
import Triangle.AbstractSyntaxTrees.ForInCommand;
import Triangle.AbstractSyntaxTrees.ForUntilCommand;
import Triangle.AbstractSyntaxTrees.ForVarDeclaration;
import Triangle.AbstractSyntaxTrees.ForWhileCommand;
import Triangle.AbstractSyntaxTrees.FuncActualParameter;
import Triangle.AbstractSyntaxTrees.FuncDeclaration;
import Triangle.AbstractSyntaxTrees.FuncFormalParameter;
import Triangle.AbstractSyntaxTrees.Identifier;
import Triangle.AbstractSyntaxTrees.IfCommand;
import Triangle.AbstractSyntaxTrees.IfExpression;
import Triangle.AbstractSyntaxTrees.IntTypeDenoter;
import Triangle.AbstractSyntaxTrees.IntegerExpression;
import Triangle.AbstractSyntaxTrees.IntegerLiteral;
import Triangle.AbstractSyntaxTrees.LetCommand;
import Triangle.AbstractSyntaxTrees.LetExpression;
import Triangle.AbstractSyntaxTrees.LongIdentifier;
import Triangle.AbstractSyntaxTrees.LongIdentifierComplex;
import Triangle.AbstractSyntaxTrees.LongIdentifierSimple;
import Triangle.AbstractSyntaxTrees.MultipleActualParameterSequence;
import Triangle.AbstractSyntaxTrees.MultipleArrayAggregate;
import Triangle.AbstractSyntaxTrees.MultipleFieldTypeDenoter;
import Triangle.AbstractSyntaxTrees.MultipleFormalParameterSequence;
import Triangle.AbstractSyntaxTrees.MultipleRecordAggregate;
import Triangle.AbstractSyntaxTrees.Operator;
import Triangle.AbstractSyntaxTrees.PackageDeclaration;
import Triangle.AbstractSyntaxTrees.PackageIdentifier;
import Triangle.AbstractSyntaxTrees.PrivateDeclaration;
import Triangle.AbstractSyntaxTrees.ProcActualParameter;
import Triangle.AbstractSyntaxTrees.ProcDeclaration;
import Triangle.AbstractSyntaxTrees.ProcFormalParameter;
import Triangle.AbstractSyntaxTrees.Program;
import Triangle.AbstractSyntaxTrees.RECDeclaration;
import Triangle.AbstractSyntaxTrees.RecordExpression;
import Triangle.AbstractSyntaxTrees.RecordTypeDenoter;
import Triangle.AbstractSyntaxTrees.RepeatTimes;
import Triangle.AbstractSyntaxTrees.SelectCommandComplex;
import Triangle.AbstractSyntaxTrees.SelectCommandSimple;
import Triangle.AbstractSyntaxTrees.SequentialCase;
import Triangle.AbstractSyntaxTrees.SequentialCaseLiterals;
import Triangle.AbstractSyntaxTrees.SequentialCommand;
import Triangle.AbstractSyntaxTrees.SequentialDeclaration;
import Triangle.AbstractSyntaxTrees.SequentialPackage;
import Triangle.AbstractSyntaxTrees.SimpleTypeDenoter;
import Triangle.AbstractSyntaxTrees.SimpleVname;
import Triangle.AbstractSyntaxTrees.SingleActualParameterSequence;
import Triangle.AbstractSyntaxTrees.SingleArrayAggregate;
import Triangle.AbstractSyntaxTrees.SingleCase;
import Triangle.AbstractSyntaxTrees.SingleCaseLiterals;
import Triangle.AbstractSyntaxTrees.SingleFieldTypeDenoter;
import Triangle.AbstractSyntaxTrees.SingleFormalParameterSequence;
import Triangle.AbstractSyntaxTrees.SinglePackage;
import Triangle.AbstractSyntaxTrees.SingleRecordAggregate;
import Triangle.AbstractSyntaxTrees.SubscriptVname;
import Triangle.AbstractSyntaxTrees.TypeDeclaration;
import Triangle.AbstractSyntaxTrees.UnaryExpression;
import Triangle.AbstractSyntaxTrees.UnaryOperatorDeclaration;
import Triangle.AbstractSyntaxTrees.UntilLoop;
import Triangle.AbstractSyntaxTrees.VarActualParameter;
import Triangle.AbstractSyntaxTrees.VarDeclaration;
import Triangle.AbstractSyntaxTrees.VarFormalParameter;
import Triangle.AbstractSyntaxTrees.VariableInitializedDeclaration;
import Triangle.AbstractSyntaxTrees.Visitor;
import Triangle.AbstractSyntaxTrees.VnameExpression;
import Triangle.AbstractSyntaxTrees.WhileCommand;
import Triangle.AbstractSyntaxTrees.WhileLoop;

import java.io.FileWriter;
import java.io.IOException;

public class WriterVisitor implements Visitor {

    private FileWriter fileWriter;

    WriterVisitor(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    // Commands
    
         @Override
     public Object visitAssignCommand(AssignCommand ast, Object obj) {
        writeLineHTML("<AssignCommand>");
        ast.V.visit(this, null);
        ast.E.visit(this, null);
        writeLineHTML("</AssignCommand>");
        return null;
    }
    
         @Override
     public Object visitCallCommand(CallCommand ast, Object obj) {
        writeLineHTML("<CallCommand>");
        ast.I.visit(this, null);
        ast.APS.visit(this, null);
        writeLineHTML("</CallCommand>");
        return null;
    }
    
         @Override
     public Object visitEmptyCommand(EmptyCommand ast, Object obj) {
        writeLineHTML("<EmptyCommand/>");
        return null;
    }

         @Override
     public Object visitIfCommand(IfCommand ast, Object obj) {
        writeLineHTML("<IfCommand>");
        ast.E.visit(this, null);
        ast.C1.visit(this, null);
        ast.C2.visit(this, null);
        writeLineHTML("</IfCommand>");
        return null;
    }

         @Override
     public Object visitLetCommand(LetCommand ast, Object obj) {
        writeLineHTML("<LetCommand>");
        ast.D.visit(this, null);
        ast.C.visit(this, null);
        writeLineHTML("</LetCommand>");
        return null;
    }

         @Override
     public Object visitSequentialCommand(SequentialCommand ast, Object obj) {
        writeLineHTML("<SequentialCommand>");
        ast.C1.visit(this, null);
        ast.C2.visit(this, null);
        writeLineHTML("</SequentialCommand>");
        return null;
    }

         @Override
     public Object visitWhileCommand(WhileCommand ast, Object obj) {
        writeLineHTML("<WhileCommand>");
        ast.E.visit(this, null);
        ast.C.visit(this, null);
        writeLineHTML("</WhileCommand>");
        return null;
    }


    // Expressions
         @Override
     public Object visitArrayExpression(ArrayExpression ast, Object obj) {
        writeLineHTML("<ArrayExpression>");
        ast.AA.visit(this, null);
        writeLineHTML("</ArrayExpression>");
        return null;
    }

         @Override
     public Object visitBinaryExpression(BinaryExpression ast, Object obj) {
        writeLineHTML("<BinaryExpression>");
        ast.E1.visit(this, null);
        ast.O.visit(this, null);
        ast.E2.visit(this, null);
        writeLineHTML("</BinaryExpression>");
        return null;
    }

         @Override
     public Object visitCallExpression(CallExpression ast, Object obj) {
        writeLineHTML("<CallExpression>");
        ast.I.visit(this, null);
        ast.APS.visit(this, null);
        writeLineHTML("</CallExpression>");
        return null;
    }

         @Override
     public Object visitCharacterExpression(CharacterExpression ast, Object obj) {
        writeLineHTML("<CharacterExpression>");
        ast.CL.visit(this, null);
        writeLineHTML("</CharacterExpression>");
        return null;
    }

         @Override
     public Object visitEmptyExpression(EmptyExpression ast, Object obj) {
        writeLineHTML("<EmptyExpression/>");
        return null;
    }

         @Override
     public Object visitIfExpression(IfExpression ast, Object obj) {
        writeLineHTML("<IfExpression>");
        ast.E1.visit(this, null);
        ast.E2.visit(this, null);
        ast.E3.visit(this, null);
        writeLineHTML("</IfExpression>");
        return null;
    }

         @Override
     public Object visitIntegerExpression(IntegerExpression ast, Object obj) {
        writeLineHTML("<IntegerExpression>");
        ast.IL.visit(this, null);
        writeLineHTML("</IntegerExpression>");
        return null;
    }

         @Override
     public Object visitLetExpression(LetExpression ast, Object obj) {
        writeLineHTML("<LetExpression>");
        ast.D.visit(this, null);
        ast.E.visit(this, null);
        writeLineHTML("</LetExpression>");
        return null;
    }

         @Override
     public Object visitRecordExpression(RecordExpression ast, Object obj) {
        writeLineHTML("<RecordExpression>");
        ast.RA.visit(this, null);
        writeLineHTML("</RecordExpression>");
        return null;
    }

         @Override
     public Object visitUnaryExpression(UnaryExpression ast, Object obj) {
        writeLineHTML("<UnaryExpression>");
        ast.O.visit(this, null);
        ast.E.visit(this, null);
        writeLineHTML("</UnaryExpression>");
        return null;
    }

         @Override
     public Object visitVnameExpression(VnameExpression ast, Object obj) {
        writeLineHTML("<VnameExpression>");
        ast.V.visit(this, null);
        writeLineHTML("</VnameExpression>");
        return null;
    }


    // Declarations
         @Override
     public Object visitBinaryOperatorDeclaration(BinaryOperatorDeclaration ast, Object obj) {
        writeLineHTML("<BinaryOperatorDeclaration>");
        ast.O.visit(this, null);
        ast.ARG1.visit(this, null);
        ast.ARG2.visit(this, null);
        ast.RES.visit(this, null);
        writeLineHTML("</BinaryOperatorDeclaration>");
        return null;
    }

         @Override
     public Object visitConstDeclaration(ConstDeclaration ast, Object obj) {
        writeLineHTML("<ConstDeclaration>");
        ast.I.visit(this, null);
        ast.E.visit(this, null);
        writeLineHTML("</ConstDeclaration>");
        return null;
    }

         @Override
     public Object visitFuncDeclaration(FuncDeclaration ast, Object obj) {
        writeLineHTML("<FuncDeclaration>");
        ast.I.visit(this, null);
        ast.FPS.visit(this, null);
        ast.T.visit(this, null);
        ast.E.visit(this, null);
        writeLineHTML("</FuncDeclaration>");
        return null;
    }

         @Override
     public Object visitProcDeclaration(ProcDeclaration ast, Object obj) {
        writeLineHTML("<ProcDeclaration>");
        ast.I.visit(this, null);
        ast.FPS.visit(this, null);
        ast.C.visit(this, null);
        writeLineHTML("</ProcDeclaration>");
        return null;
    }

         @Override
     public Object visitSequentialDeclaration(SequentialDeclaration ast, Object obj) {
        writeLineHTML("<SequentialDeclaration>");
        ast.D1.visit(this, null);
        ast.D2.visit(this, null);
        writeLineHTML("</SequentialDeclaration>");
        return null;
    }

         @Override
     public Object visitTypeDeclaration(TypeDeclaration ast, Object obj) {
        writeLineHTML("<TypeDeclaration>");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
        writeLineHTML("</TypeDeclaration>");
        return null;
    }

         @Override
     public Object visitUnaryOperatorDeclaration(UnaryOperatorDeclaration ast, Object obj) {
        writeLineHTML("<UnaryOperatorDeclaration>");
        ast.O.visit(this, null);
        ast.ARG.visit(this, null);
        ast.RES.visit(this, null);
        writeLineHTML("</UnaryOperatorDeclaration>");
        return null;
    }

         @Override
     public Object visitVarDeclaration(VarDeclaration ast, Object obj) {
        writeLineHTML("<VarDeclaration>");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
        writeLineHTML("</VarDeclaration>");
        return null;
    }


    // Array Aggregates
         @Override
     public Object visitMultipleArrayAggregate(MultipleArrayAggregate ast, Object obj) {
        writeLineHTML("<MultipleArrayAggregate>");
        ast.E.visit(this, null);
        ast.AA.visit(this, null);
        writeLineHTML("</MultipleArrayAggregate>");
        return null;
    }

         @Override
     public Object visitSingleArrayAggregate(SingleArrayAggregate ast, Object obj) {
        writeLineHTML("<SingleArrayAggregate>");
        ast.E.visit(this, null);
        writeLineHTML("</SingleArrayAggregate>");
        return null;
    }


    // Record Aggregates
         @Override
     public Object visitMultipleRecordAggregate(MultipleRecordAggregate ast, Object obj) {
        writeLineHTML("<MultipleRecordAggregate>");
        ast.I.visit(this, null);
        ast.E.visit(this, null);
        ast.RA.visit(this, null);
        writeLineHTML("</MultipleRecordAggregate>");
        return null;
    }

         @Override
     public Object visitSingleRecordAggregate(SingleRecordAggregate ast, Object obj) {
        writeLineHTML("<SingleRecordAggregate>");
        ast.I.visit(this, null);
        ast.E.visit(this, null);
        writeLineHTML("</SingleRecordAggregate>");
        return null;
    }


    // Formal Parameters
         @Override
     public Object visitConstFormalParameter(ConstFormalParameter ast, Object obj) {
        writeLineHTML("<ConstFormalParameter>");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
        writeLineHTML("</ConstFormalParameter>");
        return null;
    }

         @Override
     public Object visitFuncFormalParameter(FuncFormalParameter ast, Object obj) {
        writeLineHTML("<FuncFormalParameter>");
        ast.I.visit(this, null);
        ast.FPS.visit(this, null);
        ast.T.visit(this, null);
        writeLineHTML("<FuncFormalParameter>");
        return null;
    }

         @Override
     public Object visitProcFormalParameter(ProcFormalParameter ast, Object obj) {
        writeLineHTML("<ProcFormalParameter>");
        ast.I.visit(this, null);
        ast.FPS.visit(this, null);
        writeLineHTML("</ProcFormalParameter>");
        return null;
    }

         @Override
     public Object visitVarFormalParameter(VarFormalParameter ast, Object obj) {
        writeLineHTML("<VarFormalParameter>");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
        writeLineHTML("</VarFormalParameter>");
        return null;
    }


         @Override
     public Object visitEmptyFormalParameterSequence(EmptyFormalParameterSequence ast, Object obj) {
        writeLineHTML("<EmptyFormalParameterSequence/>");
        return null;
    }

         @Override
     public Object visitMultipleFormalParameterSequence(MultipleFormalParameterSequence ast, Object obj) {
        writeLineHTML("<MultipleFormalParameterSequence>");
        ast.FP.visit(this, null);
        ast.FPS.visit(this, null);
        writeLineHTML("</MultipleFormalParameterSequence>");
        return null;
    }

         @Override
     public Object visitSingleFormalParameterSequence(SingleFormalParameterSequence ast, Object obj) {
        writeLineHTML("<SingleFormalParameterSequence>");
        ast.FP.visit(this, null);
        writeLineHTML("</SingleFormalParameterSequence>");
        return null;
    }


    // Actual Parameters
         @Override
     public Object visitConstActualParameter(ConstActualParameter ast, Object obj) {
        writeLineHTML("<ConstActualParameter>");
        ast.E.visit(this, null);
        writeLineHTML("</ConstActualParameter>");
        return null;
    }

         @Override
     public Object visitFuncActualParameter(FuncActualParameter ast, Object obj) {
        writeLineHTML("<FuncActualParameter>");
        ast.I.visit(this, null);
        writeLineHTML("</FuncActualParameter>");
        return null;
    }

         @Override
     public Object visitProcActualParameter(ProcActualParameter ast, Object obj) {
        writeLineHTML("<ProcActualParameter>");
        ast.I.visit(this, null);
        writeLineHTML("</ProcActualParameter>");
        return null;
    }

         @Override
     public Object visitVarActualParameter(VarActualParameter ast, Object obj) {
        writeLineHTML("<VarActualParameter>");
        ast.V.visit(this, null);
        writeLineHTML("</VarActualParameter>");
        return null;
    }


         @Override
     public Object visitEmptyActualParameterSequence(EmptyActualParameterSequence ast, Object obj) {
        writeLineHTML("<EmptyActualParameterSequence/>");
        return null;
    }

         @Override
     public Object visitMultipleActualParameterSequence(MultipleActualParameterSequence ast, Object obj) {
        writeLineHTML("<MultipleActualParameterSequence>");
        ast.AP.visit(this, null);
        ast.APS.visit(this, null);
        writeLineHTML("</MultipleActualParameterSequence>");
        return null;
    }

         @Override
     public Object visitSingleActualParameterSequence(SingleActualParameterSequence ast, Object obj) {
        writeLineHTML("<SingleActualParameterSequence>");
        ast.AP.visit(this, null);
        writeLineHTML("</SingleActualParameterSequence>");
        return null;
    }


    // Type Denoters
         @Override
     public Object visitAnyTypeDenoter(AnyTypeDenoter ast, Object obj) {
        writeLineHTML("<AnyTypeDenoter/>");
        return null;
    }

         @Override
     public Object visitArrayTypeDenoter(ArrayTypeDenoter ast, Object obj) {
        writeLineHTML("<ArrayTypeDenoter>");
        ast.IL.visit(this, null);
        ast.T.visit(this, null);
        writeLineHTML("</ArrayTypeDenoter>");
        return null;
    }

         @Override
     public Object visitBoolTypeDenoter(BoolTypeDenoter ast, Object obj) {
        writeLineHTML("<BoolTypeDenoter/>");
        return null;
    }

         @Override
     public Object visitCharTypeDenoter(CharTypeDenoter ast, Object obj) {
        writeLineHTML("<CharTypeDenoter/>");
        return null;
    }

         @Override
     public Object visitErrorTypeDenoter(ErrorTypeDenoter ast, Object obj) {
        writeLineHTML("<ErrorTypeDenoter/>");
        return null;
    }

         @Override
     public Object visitSimpleTypeDenoter(SimpleTypeDenoter ast, Object obj) {
        writeLineHTML("<SimpleTypeDenoter>");
        ast.I.visit(this, null);
        writeLineHTML("</SimpleTypeDenoter>");
        return null;
    }

         @Override
     public Object visitIntTypeDenoter(IntTypeDenoter ast, Object obj) {
        writeLineHTML("<IntTypeDenoter/>");
        return null;
    }

         @Override
     public Object visitRecordTypeDenoter(RecordTypeDenoter ast, Object obj) {
        writeLineHTML("<RecordTypeDenoter>");
        ast.FT.visit(this, null);
        writeLineHTML("</RecordTypeDenoter>");
        return null;
    }


         @Override
     public Object visitMultipleFieldTypeDenoter(MultipleFieldTypeDenoter ast, Object obj) {
        writeLineHTML("<MultipleFieldTypeDenoter>");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
        ast.FT.visit(this, null);
        writeLineHTML("</MultipleFieldTypeDenoter>");
        return null;
    }

         @Override
     public Object visitSingleFieldTypeDenoter(SingleFieldTypeDenoter ast, Object obj) {
        writeLineHTML("<SingleFieldTypeDenoter>");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
        writeLineHTML("</SingleFieldTypeDenoter>");
        return null;
    }


    // Literals, Identifiers and Operators
         @Override
     public Object visitCharacterLiteral(CharacterLiteral ast, Object obj) {
        writeLineHTML("<CharacterLiteral value=\"" + transformOperator(ast.spelling) + "\"/>");
        return null;
    }

         @Override
     public Object visitIdentifier(Identifier ast, Object obj) {
        writeLineHTML("<Identifier value=\"" + ast.spelling + "\"/>");
        return null;
    }

         @Override
     public Object visitIntegerLiteral(IntegerLiteral ast, Object obj) {
        writeLineHTML("<IntegerLiteral value=\"" + ast.spelling + "\"/>");
        return null;
    }

         @Override
     public Object visitOperator(Operator ast, Object obj) {
        writeLineHTML("<Operator value=\"" + transformOperator(ast.spelling) + "\"/>");
        return null;
    }


    // Value-or-variable names
         @Override
     public Object visitDotVname(DotVname ast, Object obj) {
        writeLineHTML("<DotVname>");
        ast.V.visit(this, null);
        ast.I.visit(this, null);
        writeLineHTML("</DotVname>");
        return null;
    }

         @Override
     public Object visitSimpleVname(SimpleVname ast, Object obj) {
        writeLineHTML("<SimpleVname>");
        ast.I.visit(this, null);
        writeLineHTML("</SimpleVname>");
        return null;
    }

         @Override
     public Object visitSubscriptVname(SubscriptVname ast, Object obj) {
        writeLineHTML("<SubscriptVname>");
        ast.V.visit(this, null);
        ast.E.visit(this, null);
        writeLineHTML("</SubscriptVname>");
        return null;
    }


    // Programs
         @Override
     public Object visitProgram(Program ast, Object obj) {
        writeLineHTML("<Program>");
        //compere p is null
       
        ast.B.visit(this, null);
        writeLineHTML("</Program>");
        return null;
    }

    private void writeLineHTML(String line) {
        try {
            fileWriter.write(line);
            fileWriter.write('\n');
        } catch (IOException e) {
            System.err.println("Error while writing file for print the AST");
            e.printStackTrace();
        }
    }

    /*
     * Convert the characters "<" & "<=" to their equivalents in html
     */
    private String transformOperator(String operator) {
        if (operator.compareTo("<") == 0)
            return "&lt;";
        else if (operator.compareTo("<=") == 0)
            return "&lt;=";
        else if (operator.compareTo("&") == 0)
            return "&amp;amp;";
        else
            return operator;
    }

    
         @Override
     public Object visitForCommand(ForCommand ast, Object o) {
        // writeLineHTML("<ForCommand>");
        // ast.D.visit(this, null);
        // ast.E1.visit(this, null);
        // ast.C.visit(this, null);
        // writeLineHTML("</ForCommand>");
        // return null;
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
         @Override
     public Object visitForWhileCommand(ForWhileCommand ast, Object o) {
        writeLineHTML("<ForWhileCommand>");
        ast.I.visit(this, null);
        ast.E1.visit(this, null);
        ast.E2.visit(this, null);
        ast.E3.visit(this, null);
        ast.C.visit(this, null);
        writeLineHTML("</ForWhileCommand>");
        return null;
    }

    
         @Override
     public Object visitForUntilCommand(ForUntilCommand ast, Object o) {
        writeLineHTML("<ForUntilCommand>");
        ast.I.visit(this, null);
        ast.E1.visit(this, null);
        ast.E2.visit(this, null);
        ast.E3.visit(this, null);
        ast.C.visit(this, null);
        writeLineHTML("</ForUntilCommand>");
        return null;
    }

    
         @Override
     public Object visitForInCommand(ForInCommand ast, Object o) {
        writeLineHTML("<ForInCommand>");
        ast.I.visit(this, null);
        ast.E1.visit(this, null);
        ast.C.visit(this, null);
        writeLineHTML("</ForInCommand>");
        return null;
    }

    
         @Override
     public Object visitRecDeclaration(RECDeclaration ast, Object o) {
        writeLineHTML("<RECDeclaration>");
        ast.PFS.visit(this, null);
        writeLineHTML("</RECDeclaration>");
        return null;
    }

    
         @Override
     public Object visitPrivateDeclaration(PrivateDeclaration ast, Object o) {
        writeLineHTML("<PrivateDeclaration>");
        ast.D1.visit(this, null);
        ast.D2.visit(this, null);
        writeLineHTML("</PrivateDeclaration>");
        return null;
    }

    
         @Override
     public Object visitInitializedVariableDeclaration(VariableInitializedDeclaration ast, Object o) {
        writeLineHTML("<InitializedVariableDeclaration>");
        ast.I.visit(this, null);
        ast.E.visit(this, null);
        writeLineHTML("</InitializedVariableDeclaration>");
        return null;
    }

    @Override
    public Object visitBodySingle(BodySingle aThis, Object o) {
        writeLineHTML("<BodySingle>");        
        aThis.C.visit(this, null);
        writeLineHTML("</BodySingle>");
        return null;
    }

    @Override
    public Object visitBodyComplex(BodyComplex aThis, Object o) {
        writeLineHTML("<BodyComplex>");      
        aThis.P.visit(this, null);  
        aThis.C.visit(this, null);        
        writeLineHTML("</BodyComplex>");
        return null;
    }

    @Override
    public Object visitSinglePackageDeclaration(SinglePackage aThis, Object o) {
        writeLineHTML("<PackageDeclaration>");
        aThis.I.visit(this, null);
        aThis.D.visit(this, null);
        writeLineHTML("</PackageDeclaration>");
        return null;
    }

    @Override
    public Object visitSequentialPackageDeclaration(SequentialPackage aThis, Object o) {
        writeLineHTML("<SequentialPackage>");
        aThis.package1.visit(this, null);
        if (aThis.package2 != null){
            aThis.package2.visit(this, null);
        }        
        writeLineHTML("</SequentialPackage>");
        return null;
    }

    
         @Override
     public Object visitPackageIdentifier(PackageIdentifier packageIdentifier, Object o) {
        writeLineHTML("<PackageIdentifier value=\"" + packageIdentifier.spelling + "\"/>");
        return null;
    }

    
         @Override
     public Object visitLongIdentifierSimple(LongIdentifierSimple ast, Object o) {
        writeLineHTML("<LongIdentifierSimple>");
        ast.I.visit(this, null);
        writeLineHTML("</LongIdentifierSimple>");
        return null;
    }

         @Override
     public Object visitLongIdentifierComplex(LongIdentifierComplex ast, Object o) {
        writeLineHTML("<LongIdentifierComplex>");
        writeLineHTML("<PackageIdentifier>");
        ast.Pac.visit(this, null);
        writeLineHTML("</PackageIdentifier>");
        ast.I.visit(this, null);        
        writeLineHTML("</LongIdentifierComplex>");
        return null;
    }

    
          @Override
     public Object visitWhileLoop(WhileLoop aThis, Object o) {
        writeLineHTML("<WhileLoop>");
        aThis.E.visit(this, null);
        aThis.C.visit(this, null);
        writeLineHTML("</WhileLoop>");
        return null;
    }

    
    
     @Override
     public Object visitUntilLoop(UntilLoop aThis, Object o) {
        writeLineHTML("<UntilLoop>");
        aThis.E.visit(this, null);
        aThis.C.visit(this, null);
        writeLineHTML("</UntilLoop>");
        return null;
    }

    
         @Override
     public Object visitRepeatTimes(RepeatTimes aThis, Object o) {
        writeLineHTML("<RepeatTimes>");
        aThis.E.visit(this, null);
        aThis.C.visit(this, null);
        writeLineHTML("</RepeatTimes>");
        return null;
    }

    
         @Override
     public Object visitDoWhileLoop(DoWhileLoop aThis, Object o) {
        writeLineHTML("<DoWhileLoop>");
        aThis.E.visit(this, null);
        aThis.C.visit(this, null);
        writeLineHTML("</DoWhileLoop>");
        return null;
    }

    
         @Override
     public Object visitDoUntilLoop(DoUntilLoop aThis, Object o) {
        writeLineHTML("<DoUntilLoop>");
        aThis.E.visit(this, null);
        aThis.C.visit(this, null);
        writeLineHTML("</DoUntilLoop>");
        return null;
    }

    
         @Override
     public Object visitSelectCommandSimple(SelectCommandSimple aThis, Object o) {
        writeLineHTML("<SelectCommand>");
        aThis.E.visit(this, null);
        aThis.C.visit(this, null);
        writeLineHTML("</SelectCommand>");
        return null;
    }

    @Override
    public Object visitSelectCommandComplex(SelectCommandComplex aThis, Object o) {
        writeLineHTML("<SelectCommand>");
        aThis.E.visit(this, null);
        aThis.C.visit(this, null);
        aThis.elseCommand.visit(this, null);            
        writeLineHTML("</SelectCommand>");
        return null;
   }

    @Override
    public Object visitSequentialCase(SequentialCase aThis, Object o) {
        writeLineHTML("<SequentialCase>");
        aThis.Case1.visit(this, null);
        aThis.Case2.visit(this, null);
        writeLineHTML("</SequentialCase>");
        return null;
    }

    @Override
    public Object visitSingleCase(SingleCase aThis, Object o) {
        writeLineHTML("<Case>");
        aThis.caseLiterals.visit(this, null);
        aThis.commandAST.visit(this, null);
        writeLineHTML("</Case>");
        return null;
    }


    @Override
    public Object visitSequentialCaseLiterals(SequentialCaseLiterals aThis, Object o) {
        writeLineHTML("<SequentialCaseLiterals>");
        aThis.caseLiteral1.visit(this, null);
        aThis.caseLiteral2.visit(this, null);
        writeLineHTML("</SequentialCaseLiterals>");
        return null;
    }

    @Override
    public Object visitSingleCaseLiterals(SingleCaseLiterals aThis, Object o) {
        writeLineHTML("<SingleCaseLiterals>");
        aThis.caseRange.visit(this, null);
        writeLineHTML("</SingleCaseLiterals>");
        return null;

    }

    @Override
    public Object visitCaseRangeSimple(CaseRangeSimple aThis, Object o) {
        writeLineHTML("<CaseRangeSimple>");
        aThis.caseLiteral1.visit(this, null);
        writeLineHTML("</CaseRangeSimple>");
        return null;
    }

    @Override
    public Object visitCaseRangeComplex(CaseRangeComplex aThis, Object o) {
        writeLineHTML("<CaseRangeComplex>");
        aThis.caseLiteral1.visit(this, null);
        aThis.caseLiteral2.visit(this, null);
        writeLineHTML("</CaseRangeComplex>");
        return null;
    }

    @Override
    public Object visitCaseLiteralInteger(CaseLiteralInteger aThis, Object o) {
        writeLineHTML("<CaseLiteralInteger>");
        aThis.literal.visit(this, null);
        writeLineHTML("</CaseLiteralInteger>");
        return null;
    }

    @Override
    public Object visitCaseLiteralChar(CaseLiteralChar aThis, Object o) {
        writeLineHTML("<CaseLiteralChar>");
        aThis.literal.visit(this, null);
        writeLineHTML("</CaseLiteralChar>");
        return null;
    }

    @Override
    public Object visitForVarDeclaration(ForVarDeclaration aThis, Object o) {
        writeLineHTML("<ForVarDeclaration>");
        aThis.I.visit(this, null);
        aThis.E1.visit(this, null);
        writeLineHTML("</ForVarDeclaration>");
        return null;
    }

 



   

}