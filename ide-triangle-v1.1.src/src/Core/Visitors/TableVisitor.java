/*
 * IDE-Triangle v1.0
 * TableDetails.java
 */

package Core.Visitors;

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
import Triangle.CodeGenerator.Field;
import Triangle.CodeGenerator.KnownAddress;
import Triangle.CodeGenerator.KnownRoutine;
import Triangle.CodeGenerator.KnownValue;
import Triangle.CodeGenerator.TypeRepresentation;
import Triangle.CodeGenerator.UnknownAddress;
import Triangle.CodeGenerator.UnknownRoutine;
import Triangle.CodeGenerator.UnknownValue;
import javax.swing.table.DefaultTableModel;

/**
 * Implements the Triangle Visitor interface, which is used to
 * visit an entire AST.
 *
 * Generates a DefaultTableModel, used to draw a Jable.
 *
 * @author Luis Leopoldo P�rez <luiperpe@ns.isi.ulatina.ac.cr>
 */
public class TableVisitor implements Visitor {

    /** Creates a new instance of TableDetails */
    public TableVisitor() {
    }

    // <editor-fold defaultstate="collapsed" desc=" Commands ">
    // Commands
    public Object visitAssignCommand(AssignCommand ast, Object o) {
        ast.V.visit(this, null);
        ast.E.visit(this, null);

        return (null);
    }

    public Object visitCallCommand(CallCommand ast, Object o) {
        ast.I.visit(this, null);
        ast.APS.visit(this, null);

        return (null);
    }

    public Object visitEmptyCommand(EmptyCommand ast, Object o) {
        return (null);
    }

    public Object visitIfCommand(IfCommand ast, Object o) {
        ast.E.visit(this, null);
        ast.C1.visit(this, null);
        ast.C2.visit(this, null);

        return (null);
    }

    public Object visitLetCommand(LetCommand ast, Object o) {
        ast.D.visit(this, null);
        ast.C.visit(this, null);

        return (null);
    }

    public Object visitSequentialCommand(SequentialCommand ast, Object o) {
        ast.C1.visit(this, null);
        ast.C2.visit(this, null);

        return (null);
    }

    public Object visitWhileCommand(WhileCommand ast, Object o) {
        ast.E.visit(this, null);
        ast.C.visit(this, null);

        return (null);
    }

    public Object visitForCommand(ForCommand ast, Object o) {
        ast.D.visit(this, null);
        ast.E2.visit(this, null);
        ast.C.visit(this, null);

        return (null);
    }

    public Object visitWhileLoop(WhileLoop ast, Object o) {
        ast.E.visit(this, null);
        ast.C.visit(this, null);

        return (null);
    }

    @Override
    public Object visitUntilLoop(UntilLoop ast, Object o) {
        ast.E.visit(this, null);
        ast.C.visit(this, null);

        return (null);
    }

    @Override
    public Object visitRepeatTimes(RepeatTimes ast, Object o) {
        ast.E.visit(this, null);
        ast.C.visit(this, null);

        return (null);
    }

    @Override
    public Object visitDoWhileLoop(DoWhileLoop ast, Object o) {
        ast.E.visit(this, null);
        ast.C.visit(this, null);

        return (null);
    }

    @Override
    public Object visitDoUntilLoop(DoUntilLoop ast, Object o) {
        ast.E.visit(this, null);
        ast.C.visit(this, null);

        return (null);
    }

    @Override
    public Object visitForWhileCommand(ForWhileCommand ast, Object o) {
        ast.D.visit(this, null);
        ast.E2.visit(this, null);
        ast.E3.visit(this, null);
        ast.C.visit(this, null);

        return (null);
    }

    @Override
    public Object visitForUntilCommand(ForUntilCommand ast, Object o) {
        ast.D.visit(this, null);
        ast.E2.visit(this, null);
        ast.E3.visit(this, null);
        ast.C.visit(this, null);

        return (null);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Expressions ">
    // Expressions
    public Object visitArrayExpression(ArrayExpression ast, Object o) {
        ast.AA.visit(this, null);

        return (null);
    }

    public Object visitBinaryExpression(BinaryExpression ast, Object o) {
        ast.E1.visit(this, null);
        ast.E2.visit(this, null);
        ast.O.visit(this, null);

        return (null);
    }

    public Object visitCallExpression(CallExpression ast, Object o) {
        ast.I.visit(this, null);
        ast.APS.visit(this, null);

        return (null);
    }

    public Object visitCharacterExpression(CharacterExpression ast, Object o) {
        ast.CL.visit(this, null);

        return (null);
    }

    public Object visitEmptyExpression(EmptyExpression ast, Object o) {
        return (null);
    }

    public Object visitIfExpression(IfExpression ast, Object o) {
        ast.E1.visit(this, null);
        ast.E2.visit(this, null);
        ast.E3.visit(this, null);

        return (null);
    }

    public Object visitIntegerExpression(IntegerExpression ast, Object o) {
        return (null);
    }

    public Object visitLetExpression(LetExpression ast, Object o) {
        ast.D.visit(this, null);
        ast.E.visit(this, null);

        return (null);
    }

    public Object visitRecordExpression(RecordExpression ast, Object o) {
        ast.RA.visit(this, null);

        return (null);
    }

    public Object visitUnaryExpression(UnaryExpression ast, Object o) {
        ast.E.visit(this, null);
        ast.O.visit(this, null);

        return (null);
    }

    public Object visitVnameExpression(VnameExpression ast, Object o) {
        ast.V.visit(this, null);

        return (null);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Declarations ">
    // Declarations
    public Object visitBinaryOperatorDeclaration(BinaryOperatorDeclaration ast, Object o) {
        return (null);
    }

    public Object visitConstDeclaration(ConstDeclaration ast, Object o) {
        String name = ast.I.spelling;
        String type = "N/A";
        try {
            int size = (ast.entity != null ? ast.entity.size : 0);
            int level = -1;
            int displacement = -1;
            int value = -1;

            if (ast.entity instanceof KnownValue) {
                type = "KnownValue";
                value = ((KnownValue) ast.entity).value;
            } else if (ast.entity instanceof UnknownValue) {
                type = "UnknownValue";
                level = ((UnknownValue) ast.entity).address.level;
                displacement = ((UnknownValue) ast.entity).address.displacement;
            }
            addIdentifier(name, type, size, level, displacement, value);
        } catch (NullPointerException e) {
        }

        ast.E.visit(this, null);
        ast.I.visit(this, null);

        return (null);
    }

    public Object visitForVarDeclaration(ForVarDeclaration ast, Object o) {
        String name = ast.I.spelling;
        String type = "N/A";
        try {
            int size = (ast.entity != null ? ast.entity.size : 0);
            int level = -1;
            int displacement = -1;
            int value = -1;

            if (ast.entity instanceof KnownValue) {
                type = "KnownValue";
                value = ((KnownValue) ast.entity).value;
            } else if (ast.entity instanceof UnknownValue) {
                type = "UnknownValue";
                level = ((UnknownValue) ast.entity).address.level;
                displacement = ((UnknownValue) ast.entity).address.displacement;
            }
            addIdentifier(name, type, size, level, displacement, value);
        } catch (NullPointerException e) {
        }

        ast.E1.visit(this, null);
        ast.I.visit(this, null);

        return (null);
    }

    public Object visitFuncDeclaration(FuncDeclaration ast, Object o) {
        try {
            addIdentifier(ast.I.spelling,
                    "KnownRoutine",
                    (ast.entity != null ? ast.entity.size : 0),
                    ((KnownRoutine) ast.entity).address.level,
                    ((KnownRoutine) ast.entity).address.displacement,
                    -1);
        } catch (NullPointerException e) {
        }
        ast.T.visit(this, null);
        ast.FPS.visit(this, null);
        ast.E.visit(this, null);

        return (null);
    }

    public Object visitProcDeclaration(ProcDeclaration ast, Object o) {
        try {
            addIdentifier(ast.I.spelling, "KnownRoutine",
                    (ast.entity != null ? ast.entity.size : 0),
                    ((KnownRoutine) ast.entity).address.level,
                    ((KnownRoutine) ast.entity).address.displacement,
                    -1);
        } catch (NullPointerException e) {
        }

        ast.FPS.visit(this, null);
        ast.C.visit(this, null);

        return (null);
    }

    public Object visitSequentialDeclaration(SequentialDeclaration ast, Object o) {
        ast.D1.visit(this, null);
        ast.D2.visit(this, null);

        return (null);
    }

    public Object visitTypeDeclaration(TypeDeclaration ast, Object o) {
        ast.T.visit(this, null);

        return (null);
    }

    public Object visitUnaryOperatorDeclaration(UnaryOperatorDeclaration ast, Object o) {
        return (null);
    }

    public Object visitVarDeclaration(VarDeclaration ast, Object o) {
        try {
            addIdentifier(ast.I.spelling,
                    "KnownAddress",
                    (ast.entity != null ? ast.entity.size : 0),
                    ((KnownAddress) ast.entity).address.level,
                    ((KnownAddress) ast.entity).address.displacement,
                    -1);
        } catch (NullPointerException e) {
        }

        ast.T.visit(this, null);
        return (null);
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Aggregates ">
    // Array Aggregates
    public Object visitMultipleArrayAggregate(MultipleArrayAggregate ast, Object o) {
        ast.AA.visit(this, null);
        ast.E.visit(this, null);

        return (null);
    }

    public Object visitSingleArrayAggregate(SingleArrayAggregate ast, Object o) {
        ast.E.visit(this, null);

        return (null);
    }

    // Record Aggregates
    public Object visitMultipleRecordAggregate(MultipleRecordAggregate ast, Object o) {
        ast.E.visit(this, null);
        ast.I.visit(this, null);
        ast.RA.visit(this, null);

        return (null);
    }

    public Object visitSingleRecordAggregate(SingleRecordAggregate ast, Object o) {
        ast.E.visit(this, null);
        ast.I.visit(this, null);

        return (null);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Parameters ">
    // Formal Parameters
    public Object visitConstFormalParameter(ConstFormalParameter ast, Object o) {
        try {
            addIdentifier(ast.I.spelling,
                    "UnknownValue",
                    (ast.entity != null ? ast.entity.size : 0),
                    ((UnknownValue) ast.entity).address.level,
                    ((UnknownValue) ast.entity).address.displacement,
                    -1);
        } catch (NullPointerException e) {
        }

        ast.I.visit(this, null);
        ast.T.visit(this, null);

        return (null);
    }

    public Object visitFuncFormalParameter(FuncFormalParameter ast, Object o) {
        try {
            addIdentifier(ast.I.spelling,
                    "UnknownRoutine",
                    (ast.entity != null ? ast.entity.size : 0),
                    ((UnknownRoutine) ast.entity).address.level,
                    ((UnknownRoutine) ast.entity).address.displacement,
                    -1);
        } catch (NullPointerException e) {
        }
        ast.FPS.visit(this, null);
        ast.T.visit(this, null);

        return (null);
    }

    public Object visitProcFormalParameter(ProcFormalParameter ast, Object o) {
        try {
            addIdentifier(ast.I.spelling,
                    "UnknownRoutine",
                    (ast.entity != null ? ast.entity.size : 0),
                    ((UnknownRoutine) ast.entity).address.level,
                    ((UnknownRoutine) ast.entity).address.displacement,
                    -1);
        } catch (NullPointerException e) {
        }
        ast.FPS.visit(this, null);

        return (null);
    }

    public Object visitVarFormalParameter(VarFormalParameter ast, Object o) {
        try {
            addIdentifier(ast.I.spelling,
                    "UnknownAddress",
                    ast.T.entity.size,
                    ((UnknownAddress) ast.entity).address.level,
                    ((UnknownAddress) ast.entity).address.displacement,
                    -1);
        } catch (NullPointerException e) {
        }
        ast.T.visit(this, null);

        return (null);
    }

    public Object visitEmptyFormalParameterSequence(EmptyFormalParameterSequence ast, Object o) {
        return (null);
    }

    public Object visitMultipleFormalParameterSequence(MultipleFormalParameterSequence ast, Object o) {
        ast.FP.visit(this, null);
        ast.FPS.visit(this, null);

        return (null);
    }

    public Object visitSingleFormalParameterSequence(SingleFormalParameterSequence ast, Object o) {
        ast.FP.visit(this, null);

        return (null);
    }

    // Actual Parameters
    public Object visitConstActualParameter(ConstActualParameter ast, Object o) {
        ast.E.visit(this, null);

        return (null);
    }

    public Object visitFuncActualParameter(FuncActualParameter ast, Object o) {
        ast.I.visit(this, null);

        return (null);
    }

    public Object visitProcActualParameter(ProcActualParameter ast, Object o) {
        ast.I.visit(this, null);

        return (null);
    }

    public Object visitVarActualParameter(VarActualParameter ast, Object o) {
        ast.V.visit(this, null);

        return (null);
    }

    public Object visitEmptyActualParameterSequence(EmptyActualParameterSequence ast, Object o) {
        return (null);
    }

    public Object visitMultipleActualParameterSequence(MultipleActualParameterSequence ast, Object o) {
        ast.AP.visit(this, null);
        ast.APS.visit(this, null);

        return (null);
    }

    public Object visitSingleActualParameterSequence(SingleActualParameterSequence ast, Object o) {
        ast.AP.visit(this, null);

        return (null);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Type Denoters ">
    // Type Denoters
    public Object visitAnyTypeDenoter(AnyTypeDenoter ast, Object o) {
        return (null);
    }

    public Object visitArrayTypeDenoter(ArrayTypeDenoter ast, Object o) {
        ast.IL.visit(this, null);
        ast.T.visit(this, null);

        return (null);
    }

    public Object visitBoolTypeDenoter(BoolTypeDenoter ast, Object o) {
        return (null);
    }

    public Object visitCharTypeDenoter(CharTypeDenoter ast, Object o) {
        return (null);
    }

    public Object visitErrorTypeDenoter(ErrorTypeDenoter ast, Object o) {
        return (null);
    }

    public Object visitSimpleTypeDenoter(SimpleTypeDenoter ast, Object o) {
        ast.I.visit(this, null);

        return (null);
    }

    public Object visitIntTypeDenoter(IntTypeDenoter ast, Object o) {
        return (null);
    }

    public Object visitRecordTypeDenoter(RecordTypeDenoter ast, Object o) {
        ast.FT.visit(this, null);
        return (null);
    }

    public Object visitMultipleFieldTypeDenoter(MultipleFieldTypeDenoter ast, Object o) {
        try {
            addIdentifier(ast.I.spelling,
                    "Field",
                    (ast.entity != null ? ast.entity.size : 0),
                    -1, ((Field) ast.entity).fieldOffset, -1);
        } catch (NullPointerException e) {
        }
        ast.FT.visit(this, null);
        ast.I.visit(this, null);
        ast.T.visit(this, null);

        return (null);
    }

    public Object visitSingleFieldTypeDenoter(SingleFieldTypeDenoter ast, Object o) {
        try {
            addIdentifier(ast.I.spelling,
                    "Field",
                    (ast.entity != null ? ast.entity.size : 0),
                    -1, ((Field) ast.entity).fieldOffset, -1);
        } catch (NullPointerException e) {
        }
        ast.I.visit(this, null);
        ast.T.visit(this, null);

        return (null);
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Literals, Identifiers and
    // Operators ">
    // Literals, Identifiers and Operators
    public Object visitCharacterLiteral(CharacterLiteral ast, Object o) {
        return (null);
    }

    public Object visitIdentifier(Identifier ast, Object o) {
        return (null);
    }

    public Object visitIntegerLiteral(IntegerLiteral ast, Object o) {
        return (null);
    }

    public Object visitOperator(Operator ast, Object o) {
        ast.decl.visit(this, null);

        return (null);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Values or Variable Names ">
    // Value-or-variable names
    public Object visitDotVname(DotVname ast, Object o) {
        ast.I.visit(this, null);
        ast.V.visit(this, null);

        return (null);
    }

    public Object visitSimpleVname(SimpleVname ast, Object o) {
        ast.I.visit(this, null);

        return (null);
    }

    public Object visitSubscriptVname(SubscriptVname ast, Object o) {
        ast.E.visit(this, null);
        ast.V.visit(this, null);

        return (null);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Table Creation Methods ">
    // Programs
    public Object visitProgram(Program ast, Object o) {
        ast.B.visit(this, null);

        return (null);
    }

    /**
     * Adds an identifier to the table.
     */
    private void addIdentifier(String name, String type, int size, int level, int displacement, int value) {
        boolean exists = false;

        for (int i = 0; (i < model.getRowCount() && !exists); i++)
            if (((String) model.getValueAt(i, 0)).compareTo(name) == 0)
                exists = true;

        if (!exists) {
            model.addRow(new String[] { name,
                    type,
                    String.valueOf(size),
                    (level < 0 ? " " : String.valueOf(level)),
                    (displacement < 0 ? " " : String.valueOf(displacement)),
                    (value < 0 ? " " : String.valueOf(value)) });
        }
    }

    /**
     * Returns the filled table model.
     */
    public DefaultTableModel getTable(Program ast) {
        model = new DefaultTableModel((new String[] { "Name", "Type", "Size", "Level", "Displacement", "Value" }), 0);
        visitProgram(ast, null);

        return (model);
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Attributes ">
    private DefaultTableModel model;
    // </editor-fold>

    /*
     * @Override
     * public Object visitPackageDeclaration(PackageDeclaration aThis, Object o) {
     * throw new UnsupportedOperationException("Not supported yet."); //To change
     * body of generated methods, choose Tools | Templates.
     * }
     */

    @Override
    public Object visitPackageIdentifier(PackageIdentifier packageIdentifier, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public Object visitRecDeclaration(RECDeclaration ast, Object o) {
        ast.PFS.visit(this, 0);
        return null;
    }

    @Override
    public Object visitPrivateDeclaration(PrivateDeclaration ast, Object o) {
        ast.D1.visit(this, o);
        ast.D2.visit(this, o);
        return null;
    }

    @Override
    public Object visitInitializedVariableDeclaration(VariableInitializedDeclaration ast, Object o) {
        ast.I.visit(this, o);
        ast.E.visit(this, o);
        ast.T.visit(this, o);
        return null;
    }

    @Override
    public Object visitForInCommand(ForInCommand ast, Object o) {

        ast.IEI.visit(this, null);
        ast.C.visit(this, null);
        return (null);

    }

    @Override
    public Object visitLongIdentifierSimple(LongIdentifierSimple ast, Object o) {
        return ast.I.visit(this, o);
    }

    @Override
    public Object visitLongIdentifierComplex(LongIdentifierComplex ast, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public Object visitSequentialCase(SequentialCase aThis, Object o) {
        aThis.Case1.visit(this, null);
        aThis.Case2.visit(this, null);
        return null;
    }

    @Override
    public Object visitSingleCase(SingleCase aThis, Object o) {
        aThis.caseLiterals.visit(this, null);
        aThis.commandAST.visit(this, null);       
        return null;
    }

    @Override
    public Object visitSinglePackageDeclaration(SinglePackage aThis, Object o) {
        aThis.D.visit(this, null);
        aThis.I.visit(this, null);
        return null;

    }

    @Override
    public Object visitSequentialPackageDeclaration(SequentialPackage aThis, Object o) {
        aThis.package1.visit(this, null);
        aThis.package2.visit(this, null);
        return null;
    }

    @Override
    public Object visitBodySingle(BodySingle aThis, Object o) {

        return aThis.C.visit(this, null);
    }

    @Override
    public Object visitBodyComplex(BodyComplex aThis, Object o) {
        aThis.P.visit(this, null);
        aThis.P.visit(null, null);
        return null;
    }

    @Override
    public Object visitSelectCommandComplex(SelectCommandComplex aThis, Object o) {
        aThis.E.visit(this, null);
        aThis.C.visit(this, null);
        aThis.elseCommand.visit(this, null);
        return null;
    }

    @Override
    public Object visitSelectCommandSimple(SelectCommandSimple aThis, Object o) {
        aThis.E.visit(this, null);
        aThis.C.visit(this, null);
        return null;
    }

    @Override
    public Object visitSequentialCaseLiterals(SequentialCaseLiterals aThis, Object o) {
        aThis.caseLiteral1.visit(this, null);
        aThis.caseLiteral2.visit(this, null);
        return null;
    }

    @Override
    public Object visitSingleCaseLiterals(SingleCaseLiterals aThis, Object o) {
        aThis.caseRange.visit(this, null);        
        return null;
    }

    @Override
    public Object visitCaseRangeSimple(CaseRangeSimple aThis, Object o) {
        aThis.caseLiteral1.visit(this, null);       
        return null;
    }

    @Override
    public Object visitCaseRangeComplex(CaseRangeComplex aThis, Object o) {
        aThis.caseLiteral1.visit(this, null);
        aThis.caseLiteral2.visit(this, null);
        return null;
    }

    @Override
    public Object visitCaseLiteralInteger(CaseLiteralInteger aThis, Object o) {
        aThis.literal.visit(this, null);
        return null;
    }

    @Override
    public Object visitCaseLiteralChar(CaseLiteralChar aThis, Object o) {
        aThis.literal.visit(this, null);
        return null;
    }

    @Override
    public Object visitForControl(ForControl v, Object o) {

        try {
            if (v.entity instanceof KnownValue) {

                addIdentifier(v.I.spelling,
                        "KnownAddress",
                        (v.entity != null ? v.entity.size : 0),
                        ((KnownAddress) v.entity).address.level,
                        ((KnownAddress) v.entity).address.displacement,
                        -1);
            } else {
                addIdentifier(v.I.spelling,
                        "UnknownVale",
                        (v.entity != null ? v.entity.size : 0),
                        ((UnknownValue) v.entity).address.level,
                        ((UnknownValue) v.entity).address.displacement,
                        -1);
            }
        } catch (NullPointerException e) {
        }

        v.E.visit(this, null);
        return (null);
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
    }

}
