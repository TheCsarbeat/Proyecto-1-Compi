/*
 * IDE-Triangle v1.0
 * TreeVisitor.java
 */

package Core.Visitors;

import Triangle.AbstractSyntaxTrees.AST;
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
import Triangle.AbstractSyntaxTrees.ForControl;
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
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Implements the Triangle Visitor interface, which is used to
 * visit an entire AST.
 *
 * Generates DefaultMutableTreeNodes, used to draw a JTree.
 *
 * @author Luis Leopoldo P�rez <luiperpe@ns.isi.ulatina.ac.cr>
 */
public class TreeVisitor implements Visitor {

    /**
     * Creates a new instance of TreeVisitor.
     */
    public TreeVisitor() {
    }

    // <editor-fold defaultstate="collapsed" desc=" Commands ">
    // Commands
    public Object visitAssignCommand(AssignCommand ast, Object o) {
        return (createBinary("Assign Command", ast.V, ast.E));
    }

    public Object visitCallCommand(CallCommand ast, Object o) {
        return (createBinary("Call Command", ast.I, ast.APS));
    }

    public Object visitEmptyCommand(EmptyCommand ast, Object o) {
        return (createNullary("Empty Command"));
    }

    public Object visitIfCommand(IfCommand ast, Object obj) {
        return (createTernary("If Command", ast.E, ast.C1, ast.C2));
    }

    public Object visitLetCommand(LetCommand ast, Object obj) {
        return (createBinary("Let Command", ast.D, ast.C));
    }

    public Object visitSequentialCommand(SequentialCommand ast, Object obj) {
        return (createBinary("Sequential Command", ast.C1, ast.C2));
    }

    public Object visitWhileCommand(WhileCommand ast, Object obj) {
        return (createBinary("While Command", ast.E, ast.C));
    }
    // Comando por los for
    public Object visitForCommand(ForCommand ast, Object o) {
        return (createTernary("For Command", ast.D, ast.E2, ast.C));
    }

    public Object visitForWhileCommand(ForWhileCommand ast, Object o) {
        return (createQuaternary("For While Command", ast.D, ast.E2, ast.E3, ast.C));
    }

    public Object visitForUntilCommand(ForUntilCommand ast, Object o) {
        return (createQuaternary("For Until Command", ast.D, ast.E2, ast.E3, ast.C));
    }

    public Object visitForInCommand(ForInCommand ast, Object o) {
        return (createBinary("For In Command", ast.IEI, ast.C));
    }

    public Object visitWhileLoop(WhileLoop aThis, Object o) {
        return (createBinary("While Loop", aThis.E, aThis.C));
    }

    public Object visitUntilLoop(UntilLoop aThis, Object o) {
        return (createBinary("Until Loop", aThis.E, aThis.C));
    }

    public Object visitRepeatTimes(RepeatTimes aThis, Object o) {
        return (createBinary("Repeat Times", aThis.E, aThis.C));
    }

    public Object visitDoWhileLoop(DoWhileLoop aThis, Object o) {
        return (createBinary("Do While Loop", aThis.C, aThis.E));
    }

    public Object visitDoUntilLoop(DoUntilLoop aThis, Object o) {
        return (createBinary("Do Until Loop", aThis.C, aThis.E));
    }

   
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Expressions ">
    // Expressions
    public Object visitArrayExpression(ArrayExpression ast, Object obj) {
        return (createUnary("Array Expression", ast.AA));
    }

    public Object visitBinaryExpression(BinaryExpression ast, Object obj) {
        return (createTernary("Binary Expression", ast.E1, ast.O, ast.E2));
    }

    public Object visitCallExpression(CallExpression ast, Object obj) {
        return (createBinary("Call Expression", ast.I, ast.APS));
    }

    public Object visitCharacterExpression(CharacterExpression ast, Object obj) {
        return (createUnary("Character Expression", ast.CL));
    }

    public Object visitEmptyExpression(EmptyExpression ast, Object obj) {
        return (createNullary("Empty Expression"));
    }

    public Object visitIfExpression(IfExpression ast, Object obj) {
        return (createTernary("If Expression", ast.E1, ast.E2, ast.E3));
    }

    public Object visitIntegerExpression(IntegerExpression ast, Object obj) {
        return (createUnary("Integer Expression", ast.IL));
    }

    public Object visitLetExpression(LetExpression ast, Object obj) {
        return (createBinary("Let Expression", ast.D, ast.E));
    }

    public Object visitRecordExpression(RecordExpression ast, Object obj) {
        return (createUnary("Record Expression", ast.RA));
    }

    public Object visitUnaryExpression(UnaryExpression ast, Object obj) {
        return (createBinary("Unary Expression", ast.O, ast.E));
    }

    public Object visitVnameExpression(VnameExpression ast, Object obj) {
        return (createUnary("Vname Expression", ast.V));
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Declarations ">
    // Declarations
    public Object visitBinaryOperatorDeclaration(BinaryOperatorDeclaration ast, Object obj) {
        return (createQuaternary("Binary Operator Declaration", ast.O, ast.ARG1, ast.ARG2, ast.RES));
    }

    public Object visitConstDeclaration(ConstDeclaration ast, Object obj) {
        return (createBinary("Constant Declaration", ast.I, ast.E));
    }

    public Object visitFuncDeclaration(FuncDeclaration ast, Object obj) {
        return (createQuaternary("Function Declaration", ast.I, ast.FPS, ast.T, ast.E));
    }

    public Object visitProcDeclaration(ProcDeclaration ast, Object obj) {
        return (createTernary("Procedure Declaration", ast.I, ast.FPS, ast.C));
    }

    public Object visitSequentialDeclaration(SequentialDeclaration ast, Object obj) {
        return (createBinary("Sequential Declaration", ast.D1, ast.D2));
    }

    public Object visitTypeDeclaration(TypeDeclaration ast, Object obj) {
        return (createBinary("Type Declaration", ast.I, ast.T));
    }

    public Object visitUnaryOperatorDeclaration(UnaryOperatorDeclaration ast, Object obj) {
        return (createTernary("Unary Operator Declaration", ast.O, ast.ARG, ast.RES));
    }

    public Object visitVarDeclaration(VarDeclaration ast, Object obj) {
        return (createBinary("Variable Declaration", ast.I, ast.T));
    }

    //visit of rec and procfunc

    public Object visitRecDeclaration(RECDeclaration ast, Object o) {
        return (createUnary("Recursive Declaration", ast.PFS));
    }

    public Object visitPrivateDeclaration(PrivateDeclaration ast, Object o) {
        return (createBinary("Private Declaration", ast.D1, ast.D2));
    }

    public Object visitInitializedVariableDeclaration(VariableInitializedDeclaration ast, Object o) {
        return (createBinary("Initialized Variable Declaration", ast.I, ast.E));
    }

    public Object visitForVarDeclaration(ForVarDeclaration aThis, Object o) {
        return (createBinary("For Variable Declaration", aThis.I, aThis.E1));
    }

    public Object visitForControl(ForControl v, Object o) {
        return (createBinary("For Control", v.I, v.E));
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Aggregates ">
    // Array Aggregates
    public Object visitMultipleArrayAggregate(MultipleArrayAggregate ast, Object obj) {
        return (createBinary("Multiple Array Aggregate", ast.E, ast.AA));
    }

    public Object visitSingleArrayAggregate(SingleArrayAggregate ast, Object obj) {
        return (createUnary("Single Array Aggregate", ast.E));
    }

    // Record Aggregates
    public Object visitMultipleRecordAggregate(MultipleRecordAggregate ast, Object obj) {
        return (createTernary("Multiple Record Aggregate", ast.I, ast.E, ast.RA));
    }

    public Object visitSingleRecordAggregate(SingleRecordAggregate ast, Object obj) {
        return (createBinary("Single Record Aggregate", ast.I, ast.E));
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Parameters ">
    // Formal Parameters
    public Object visitConstFormalParameter(ConstFormalParameter ast, Object obj) {
        return (createBinary("Constant Formal Parameter", ast.I, ast.T));
    }

    public Object visitFuncFormalParameter(FuncFormalParameter ast, Object obj) {
        return (createTernary("Function Formal Parameter", ast.I, ast.FPS, ast.T));
    }

    public Object visitProcFormalParameter(ProcFormalParameter ast, Object obj) {
        return (createBinary("Procedure Formal Parameter", ast.I, ast.FPS));
    }

    public Object visitVarFormalParameter(VarFormalParameter ast, Object obj) {
        return (createBinary("Variable Formal Parameter", ast.I, ast.T));
    }

    public Object visitEmptyFormalParameterSequence(EmptyFormalParameterSequence ast, Object obj) {
        return (createNullary("Empty Formal Parameter Sequence"));
    }

    public Object visitMultipleFormalParameterSequence(MultipleFormalParameterSequence ast, Object obj) {
        return (createBinary("Multiple Formal Parameter Sequence", ast.FP, ast.FPS));
    }

    public Object visitSingleFormalParameterSequence(SingleFormalParameterSequence ast, Object obj) {
        return (createUnary("Single Formal Parameter Sequence", ast.FP));
    }

    // Actual Parameters
    public Object visitConstActualParameter(ConstActualParameter ast, Object obj) {
        return (createUnary("Constant Actual Parameter", ast.E));
    }

    public Object visitFuncActualParameter(FuncActualParameter ast, Object obj) {
        return (createUnary("Function Actual Parameter", ast.I));
    }

    public Object visitProcActualParameter(ProcActualParameter ast, Object obj) {
        return (createUnary("Procedure Actual Parameter", ast.I));
    }

    public Object visitVarActualParameter(VarActualParameter ast, Object obj) {
        return (createUnary("Variable Actual Parameter", ast.V));
    }

    public Object visitEmptyActualParameterSequence(EmptyActualParameterSequence ast, Object obj) {
        return (createNullary("Empty Actual Parameter Sequence"));
    }

    public Object visitMultipleActualParameterSequence(MultipleActualParameterSequence ast, Object obj) {
        return (createBinary("Multiple Actual Parameter Sequence", ast.AP, ast.APS));
    }

    public Object visitSingleActualParameterSequence(SingleActualParameterSequence ast, Object obj) {
        return (createUnary("Single Actual Parameter Sequence", ast.AP));
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Type Denoters ">
    // Type Denoters
    public Object visitAnyTypeDenoter(AnyTypeDenoter ast, Object obj) {
        return (createNullary("any"));
    }

    public Object visitArrayTypeDenoter(ArrayTypeDenoter ast, Object obj) {
        return (createBinary("Array Type Denoter", ast.IL, ast.T));
    }

    public Object visitBoolTypeDenoter(BoolTypeDenoter ast, Object obj) {
        return (createNullary("bool"));
    }

    public Object visitCharTypeDenoter(CharTypeDenoter ast, Object obj) {
        return (createNullary("char"));
    }

    public Object visitErrorTypeDenoter(ErrorTypeDenoter ast, Object obj) {
        return (createNullary("error"));
    }

    public Object visitSimpleTypeDenoter(SimpleTypeDenoter ast, Object obj) {
        return (createUnary("Simple Type Denoter", ast.I));
    }

    public Object visitIntTypeDenoter(IntTypeDenoter ast, Object obj) {
        return (createNullary("int"));
    }

    public Object visitRecordTypeDenoter(RecordTypeDenoter ast, Object obj) {
        return (createUnary("Record Type Denoter", ast.FT));
    }

    public Object visitMultipleFieldTypeDenoter(MultipleFieldTypeDenoter ast, Object obj) {
        return (createTernary("Multiple Field Type Denoter", ast.I, ast.T, ast.FT));
    }

    public Object visitSingleFieldTypeDenoter(SingleFieldTypeDenoter ast, Object obj) {
        return (createBinary("Single Field Type Denoter", ast.I, ast.T));
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Literals, Identifiers and
    // Operators ">
    // Literals, Identifiers and Operators
    public Object visitCharacterLiteral(CharacterLiteral ast, Object obj) {
        return (createNullary(ast.spelling));
    }

    public Object visitIdentifier(Identifier ast, Object obj) {
        return (createNullary(ast.spelling));
    }

    public Object visitIntegerLiteral(IntegerLiteral ast, Object obj) {
        return (createNullary(ast.spelling));
    }

    public Object visitOperator(Operator ast, Object obj) {
        return (createNullary(ast.spelling));
    }

    public Object visitPackageIdentifier(PackageIdentifier packageIdentifier, Object o) {
        return createNullary(packageIdentifier.spelling);
    }

    public Object visitLongIdentifierSimple(LongIdentifierSimple ast, Object o) {
        return createUnary("Long Identifier Simple", ast.I);
    }

    public Object visitLongIdentifierComplex(LongIdentifierComplex ast, Object o) {
        return createBinary("Long Identifier Complex", ast.Pac, ast.I);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Values or Variable Names ">
    // Values or Variable Names
    public Object visitDotVname(DotVname ast, Object obj) {
        return (createBinary("Dot Vname", ast.I, ast.V));
    }

    public Object visitSimpleVname(SimpleVname ast, Object obj) {
        return (createUnary("Simple Vname", ast.I));
    }

    public Object visitSubscriptVname(SubscriptVname ast, Object obj) {
        return (createBinary("Subscript Vname", ast.V, ast.E));
    }

    public Object visitProgram(Program ast, Object obj) {
        //DefaultMutableTreeNode ach = createUnary("Program", ast.C);
        return (createUnary("Program",ast.B));
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Tree Creation Methods ">

    /**
     * Creates a nullary tree node (doesn't have any children).
     * 
     * @param caption The tree's caption (text to be shown when the tree is drawn).
     * @return The tree node.
     */
    public DefaultMutableTreeNode createNullary(String caption) {
        DefaultMutableTreeNode t = new DefaultMutableTreeNode(caption);

        return (t);
    }

    /**
     * Creates an unary tree node.
     * 
     * @param caption The tree's caption (text to be shown when the tree is drawn).
     * @param child1  The first children node.
     * @return The tree node.
     */
    public DefaultMutableTreeNode createUnary(String caption, AST child1) {
        DefaultMutableTreeNode t = new DefaultMutableTreeNode(caption);
        //DefaultMutableTreeNode fdsdf = (DefaultMutableTreeNode) child1.visit(this, null);
        t.add((DefaultMutableTreeNode) child1.visit(this, null));

        return (t);
    }

    /**
     * Creates a binary tree node.
     * 
     * @param caption The tree's caption (text to be shown when the tree is drawn).
     * @param child1  The first children node.
     * @param child2  The second children node.
     * @return The tree node.
     */
    public DefaultMutableTreeNode createBinary(String caption, AST child1, AST child2) {
        DefaultMutableTreeNode t = new DefaultMutableTreeNode(caption);
        t.add((DefaultMutableTreeNode) child1.visit(this, null));
        t.add((DefaultMutableTreeNode) child2.visit(this, null));

        return (t);
    }

    /**
     * Creates a ternary tree node.
     * 
     * @param caption The tree's caption (text to be shown when the tree is drawn).
     * @param child1  The first children node.
     * @param child2  The second children node.
     * @param child3  The third children node.
     * @return The tree node.
     */
    public DefaultMutableTreeNode createTernary(String caption, AST child1, AST child2, AST child3) {
        DefaultMutableTreeNode t = new DefaultMutableTreeNode(caption);
        t.add((DefaultMutableTreeNode) child1.visit(this, null));
        t.add((DefaultMutableTreeNode) child2.visit(this, null));
        t.add((DefaultMutableTreeNode) child3.visit(this, null));

        return (t);
    }

    /**
     * Creates a quaternary tree node.
     * 
     * @param caption The tree's caption (text to be shown when the tree is drawn).
     * @param child1  The first children node.
     * @param child2  The second children node.
     * @param child3  The third children node.
     * @param child4  The fourth children node.
     * @return The tree node.
     */
    public DefaultMutableTreeNode createQuaternary(String caption, AST child1, AST child2, AST child3, AST child4) {
        DefaultMutableTreeNode t = new DefaultMutableTreeNode(caption);
        t.add((DefaultMutableTreeNode) child1.visit(this, null));
        t.add((DefaultMutableTreeNode) child2.visit(this, null));
        t.add((DefaultMutableTreeNode) child3.visit(this, null));
        t.add((DefaultMutableTreeNode) child4.visit(this, null));

        return (t);
    }

    /**
     * Creates a quinary tree node.
     * 
     * @param caption The tree's caption (text to be shown when the tree is drawn).
     * @param child1  The first children node.
     * @param child2  The second children node.
     * @param child3  The third children node.
     * @param child4  The fourth children node.
     * @param child5  The fifth children node.
     * @return The tree node.
     */
    public DefaultMutableTreeNode createQuinary(String caption, AST child1, AST child2, AST child3, AST child4,
            AST child5) {
        DefaultMutableTreeNode t = new DefaultMutableTreeNode(caption);
        t.add((DefaultMutableTreeNode) child1.visit(this, null));
        t.add((DefaultMutableTreeNode) child2.visit(this, null));
        t.add((DefaultMutableTreeNode) child3.visit(this, null));
        t.add((DefaultMutableTreeNode) child4.visit(this, null));
        t.add((DefaultMutableTreeNode) child5.visit(this, null));

        return (t);
    }

    // </editor-fold>

    public Object visitPackageDeclaration(PackageDeclaration aThis, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change
        //body of generated methods, choose Tools | Templates.
    }

   
    //Visit of Package Declaration
    public Object visitSinglePackageDeclaration(SinglePackage ast, Object o) {
        return (createBinary("Package Declaration", ast.I, ast.D));
    }

    public Object visitSequentialPackageDeclaration(SequentialPackage ast, Object o) {
        return (createBinary("Sequential Package", ast.package1, ast.package2));
    }
    //Visit of Boddy Program
    public Object visitBodySingle(BodySingle aThis, Object o) {
        return (createUnary("Body Single", aThis.C));
    }

    public Object visitBodyComplex(BodyComplex aThis, Object o) {
        return (createBinary("Body Complex", aThis.P, aThis.C));
    }    

     //Visitors of selectCommand
    public Object visitSelectCommandComplex(SelectCommandComplex aThis, Object o) {
        return (createTernary("Select Command", aThis.E, aThis.C, aThis.elseCommand)); // fix
    }

    public Object visitSelectCommandSimple(SelectCommandSimple aThis, Object o) {
        return (createBinary("Select Command", aThis.E, aThis.C)); // fix
    }
    
    public Object visitSequentialCase(SequentialCase aThis, Object o) {
        return (createBinary("Sequential Case", aThis.Case1, aThis.Case2));
    }

    public Object visitSingleCase(SingleCase aThis, Object o) {
        return (createBinary("Single Case", aThis.caseLiterals, aThis.commandAST));
    }

    public Object visitSequentialCaseLiterals(SequentialCaseLiterals aThis, Object o) {
        return (createBinary("Sequential Case Literals", aThis.caseLiteral1, aThis.caseLiteral2));
    }

    public Object visitSingleCaseLiterals(SingleCaseLiterals aThis, Object o) {
        return (createUnary("Single Case Literals", aThis.caseRange));
    }

    public Object visitCaseRangeSimple(CaseRangeSimple aThis, Object o) {
        return (createUnary("Case Range Simple", aThis.caseLiteral1));
    }

    public Object visitCaseRangeComplex(CaseRangeComplex aThis, Object o) {
        return (createBinary("Case Range Complex", aThis.caseLiteral1, aThis.caseLiteral2));
    }

    public Object visitCaseLiteralInteger(CaseLiteralInteger aThis, Object o) {
        return (createUnary("Case Literal Integer", aThis.literal));
    }

    public Object visitCaseLiteralChar(CaseLiteralChar aThis, Object o) {
        return (createUnary("Case Literal Char", aThis.literal));
    }

}
