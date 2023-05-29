/*
 * @(#)Visitor.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public interface Visitor {

  // Commands
  public abstract Object visitAssignCommand(AssignCommand ast, Object o);
  public abstract Object visitCallCommand(CallCommand ast, Object o);
  public abstract Object visitEmptyCommand(EmptyCommand ast, Object o);
  public abstract Object visitIfCommand(IfCommand ast, Object o);
  public abstract Object visitLetCommand(LetCommand ast, Object o);
  public abstract Object visitSequentialCommand(SequentialCommand ast, Object o);
  public abstract Object visitWhileCommand(WhileCommand ast, Object o);

  //Loops
  public abstract Object visitForCommand(ForCommand ast, Object o);
  public abstract Object visitForWhileCommand(ForWhileCommand ast, Object o);
  public abstract Object visitForUntilCommand(ForUntilCommand ast, Object o);
  public abstract Object visitForInCommand(ForInCommand ast, Object o);
  public abstract Object visitForControl(ForControl v, Object o);
  // Expressions
  public abstract Object visitArrayExpression(ArrayExpression ast, Object o);
  public abstract Object visitBinaryExpression(BinaryExpression ast, Object o);
  public abstract Object visitCallExpression(CallExpression ast, Object o);
  public abstract Object visitCharacterExpression(CharacterExpression ast, Object o);
  public abstract Object visitEmptyExpression(EmptyExpression ast, Object o);
  public abstract Object visitIfExpression(IfExpression ast, Object o);
  public abstract Object visitIntegerExpression(IntegerExpression ast, Object o);
  public abstract Object visitLetExpression(LetExpression ast, Object o);
  public abstract Object visitRecordExpression(RecordExpression ast, Object o);
  public abstract Object visitUnaryExpression(UnaryExpression ast, Object o);
  public abstract Object visitVnameExpression(VnameExpression ast, Object o);

  // Declarations
  public abstract Object visitBinaryOperatorDeclaration(BinaryOperatorDeclaration ast, Object o);
  public abstract Object visitConstDeclaration(ConstDeclaration ast, Object o);
  public abstract Object visitFuncDeclaration(FuncDeclaration ast, Object o);
  public abstract Object visitProcDeclaration(ProcDeclaration ast, Object o);
  public abstract Object visitSequentialDeclaration(SequentialDeclaration ast, Object o);
  public abstract Object visitTypeDeclaration(TypeDeclaration ast, Object o);
  public abstract Object visitUnaryOperatorDeclaration(UnaryOperatorDeclaration ast, Object o);
  public abstract Object visitVarDeclaration(VarDeclaration ast, Object o);
  public abstract Object visitRecDeclaration(RECDeclaration ast, Object o); // se agreg�
  public abstract Object visitPrivateDeclaration(PrivateDeclaration ast, Object o); // se agreg�
  public abstract Object visitInitializedVariableDeclaration(VariableInitializedDeclaration ast, Object o); // se agreg�
  public Object visitForVarDeclaration(ForVarDeclaration aThis, Object o);

  // Array Aggregates
  public abstract Object visitMultipleArrayAggregate(MultipleArrayAggregate ast, Object o);
  public abstract Object visitSingleArrayAggregate(SingleArrayAggregate ast, Object o);

  // Record Aggregates
  public abstract Object visitMultipleRecordAggregate(MultipleRecordAggregate ast, Object o);
  public abstract Object visitSingleRecordAggregate(SingleRecordAggregate ast, Object o);

  // Formal Parameters
  public abstract Object visitConstFormalParameter(ConstFormalParameter ast, Object o);
  public abstract Object visitFuncFormalParameter(FuncFormalParameter ast, Object o);
  public abstract Object visitProcFormalParameter(ProcFormalParameter ast, Object o);
  public abstract Object visitVarFormalParameter(VarFormalParameter ast, Object o);

  public abstract Object visitEmptyFormalParameterSequence(EmptyFormalParameterSequence ast, Object o);
  public abstract Object visitMultipleFormalParameterSequence(MultipleFormalParameterSequence ast, Object o);
  public abstract Object visitSingleFormalParameterSequence(SingleFormalParameterSequence ast, Object o);

  // Actual Parameters
  public abstract Object visitConstActualParameter(ConstActualParameter ast, Object o);
  public abstract Object visitFuncActualParameter(FuncActualParameter ast, Object o);
  public abstract Object visitProcActualParameter(ProcActualParameter ast, Object o);
  public abstract Object visitVarActualParameter(VarActualParameter ast, Object o);

  public abstract Object visitEmptyActualParameterSequence(EmptyActualParameterSequence ast, Object o);
  public abstract Object visitMultipleActualParameterSequence(MultipleActualParameterSequence ast, Object o);
  public abstract Object visitSingleActualParameterSequence(SingleActualParameterSequence ast, Object o);

  // Type Denoters
  public abstract Object visitAnyTypeDenoter(AnyTypeDenoter ast, Object o);
  public abstract Object visitArrayTypeDenoter(ArrayTypeDenoter ast, Object o);
  public abstract Object visitBoolTypeDenoter(BoolTypeDenoter ast, Object o);
  public abstract Object visitCharTypeDenoter(CharTypeDenoter ast, Object o);
  public abstract Object visitErrorTypeDenoter(ErrorTypeDenoter ast, Object o);
  public abstract Object visitSimpleTypeDenoter(SimpleTypeDenoter ast, Object o);
  public abstract Object visitIntTypeDenoter(IntTypeDenoter ast, Object o);
  public abstract Object visitRecordTypeDenoter(RecordTypeDenoter ast, Object o);

  public abstract Object visitMultipleFieldTypeDenoter(MultipleFieldTypeDenoter ast, Object o);
  public abstract Object visitSingleFieldTypeDenoter(SingleFieldTypeDenoter ast, Object o);

  // Literals, Identifiers and Operators
  public abstract Object visitCharacterLiteral(CharacterLiteral ast, Object o);
  public abstract Object visitIdentifier(Identifier ast, Object o);
  public abstract Object visitIntegerLiteral(IntegerLiteral ast, Object o);
  public abstract Object visitOperator(Operator ast, Object o);

  // Value-or-variable names
  public abstract Object visitDotVname(DotVname ast, Object o);
  public abstract Object visitSimpleVname(SimpleVname ast, Object o);
  public abstract Object visitSubscriptVname(SubscriptVname ast, Object o);

  // Programs
  public abstract Object visitProgram(Program ast, Object o);
  

  // Package-Declaration
  public abstract Object visitSinglePackageDeclaration(SinglePackage aThis, Object o);

  public abstract Object visitSequentialPackageDeclaration(SequentialPackage aThis, Object o);

  public abstract Object visitPackageIdentifier(PackageIdentifier packageIdentifier, Object o);

  //Long-Identifier
  /*public abstract Object visitLongIdentifier(LongIdentifier ast, Object o);*/

  public abstract Object visitLongIdentifierSimple(LongIdentifierSimple ast, Object o);

  public abstract Object visitLongIdentifierComplex (LongIdentifierComplex ast, Object o);


    public Object visitWhileLoop(WhileLoop aThis, Object o);

    public Object visitUntilLoop(UntilLoop aThis, Object o);

    public Object visitRepeatTimes(RepeatTimes aThis, Object o);

    public Object visitDoWhileLoop(DoWhileLoop aThis, Object o);

    public Object visitDoUntilLoop(DoUntilLoop aThis, Object o);


  //SelectCommand visitor
  public Object visitSelectCommandComplex(SelectCommandComplex aThis, Object o);

  public Object visitSelectCommandSimple(SelectCommandSimple aThis, Object o);
  //public Object visitCase(Case c, Object o);

  //SequentialCase visitor
  public Object visitSequentialCase(SequentialCase aThis, Object o);

  //SingleCase visitor
  public Object visitSingleCase(SingleCase aThis, Object o);

  //bodySingle
  public Object visitBodySingle(BodySingle aThis, Object o);

  //BodyComplex
  public Object visitBodyComplex(BodyComplex aThis, Object o);

  //sequentialcaseliterals
  public Object visitSequentialCaseLiterals(SequentialCaseLiterals aThis, Object o);

  //singlecaseliterals
  public Object visitSingleCaseLiterals(SingleCaseLiterals aThis, Object o);


  //caseRangeSimple
  public Object visitCaseRangeSimple(CaseRangeSimple aThis, Object o);

  //caseRangeComplex
  public Object visitCaseRangeComplex(CaseRangeComplex aThis, Object o);

  //caseLietralInteger
  public Object visitCaseLiteralInteger(CaseLiteralInteger aThis, Object o);

  //caseLiteralChar
  public Object visitCaseLiteralChar(CaseLiteralChar aThis, Object o);
  

}
