/*
 * @(#)Checker.java                        2.1 2003/10/07
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

package Triangle.ContextualAnalyzer;

import Triangle.ErrorReporter;
import Triangle.StdEnvironment;
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
import Triangle.AbstractSyntaxTrees.Declaration;
import Triangle.AbstractSyntaxTrees.DoUntilLoop;
import Triangle.AbstractSyntaxTrees.DoWhileLoop;
import Triangle.AbstractSyntaxTrees.DotVname;
import Triangle.AbstractSyntaxTrees.EmptyActualParameterSequence;
import Triangle.AbstractSyntaxTrees.EmptyCommand;
import Triangle.AbstractSyntaxTrees.EmptyExpression;
import Triangle.AbstractSyntaxTrees.EmptyFormalParameterSequence;
import Triangle.AbstractSyntaxTrees.ErrorTypeDenoter;
import Triangle.AbstractSyntaxTrees.FieldTypeDenoter;
import Triangle.AbstractSyntaxTrees.ForCommand;
import Triangle.AbstractSyntaxTrees.ForInCommand;
import Triangle.AbstractSyntaxTrees.ForControl;
import Triangle.AbstractSyntaxTrees.ForUntilCommand;
import Triangle.AbstractSyntaxTrees.ForVarDeclaration;
import Triangle.AbstractSyntaxTrees.ForWhileCommand;
import Triangle.AbstractSyntaxTrees.FormalParameter;
import Triangle.AbstractSyntaxTrees.FormalParameterSequence;
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
import Triangle.AbstractSyntaxTrees.Terminal;
import Triangle.AbstractSyntaxTrees.TypeDeclaration;
import Triangle.AbstractSyntaxTrees.TypeDenoter;
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
import Triangle.SyntacticAnalyzer.SourcePosition;
import java.util.*;

public final class Checker implements Visitor {

  // Commands

  // Always returns null. Does not use the given object.

  public Object visitAssignCommand(AssignCommand ast, Object o) {
    TypeDenoter vType = (TypeDenoter) ast.V.visit(this, null);
    TypeDenoter eType = (TypeDenoter) ast.E.visit(this, null);
    if (!ast.V.variable)
      reporter.reportError("LHS of assignment is not a variable", "", ast.V.position);
    if (!eType.equals(vType))
      reporter.reportError("assignment incompatibilty", "", ast.position);
    return null;
  }

  public Object visitCallCommand(CallCommand ast, Object o) {

    /*
     * ast.I.visit(this, null);
     * ast.APS.visit(this, null);
     */
    Declaration binding = (Declaration) ast.I.visit(this, null);
    if (binding == null)
      reportUndeclared(ast.I.getSimpleIdentifier());
    else if (binding instanceof ProcDeclaration) {
      ast.APS.visit(this, ((ProcDeclaration) binding).FPS);
    } else if (binding instanceof ProcFormalParameter) {
      ast.APS.visit(this, ((ProcFormalParameter) binding).FPS);
    } else
      reporter.reportError("\"%\" is not a procedure identifier",
          ast.I.getSimpleIdentifier().spelling, ast.I.position);
    return null;
  }

  public Object visitEmptyCommand(EmptyCommand ast, Object o) {
    return null;
  }

  public Object visitIfCommand(IfCommand ast, Object o) {
    TypeDenoter eType = (TypeDenoter) ast.E.visit(this, null);
    if (!eType.equals(StdEnvironment.booleanType))
      reporter.reportError("Boolean expression expected here", "", ast.E.position);
    ast.C1.visit(this, null);
    ast.C2.visit(this, null);
    return null;
  }

  public Object visitLetCommand(LetCommand ast, Object o) {
    idTable.openScope();
    ast.D.visit(this, null);
    ast.C.visit(this, null);
    idTable.closeScope();
    return null;
  }

  public Object visitSequentialCommand(SequentialCommand ast, Object o) {
    ast.C1.visit(this, null);
    ast.C2.visit(this, null);
    return null;
  }

  public Object visitWhileCommand(WhileCommand ast, Object o) {
    TypeDenoter eType = (TypeDenoter) ast.E.visit(this, null);
    if (!eType.equals(StdEnvironment.booleanType))
      reporter.reportError("Boolean expression expected here", "", ast.E.position);
    ast.C.visit(this, null);
    return null;
  }

  // for Identifier := Expression .. Expression do Command end
  public Object visitForCommand(ForCommand ast, Object o) {
    // cast ast.D to ForDeclaration
    ForVarDeclaration forDecl = (ForVarDeclaration) ast.D;
    TypeDenoter e1Type = (TypeDenoter) forDecl.E1.visit(this, null);
    TypeDenoter e2Type = (TypeDenoter) ast.E2.visit(this, null);
    if (!e1Type.equals(StdEnvironment.integerType))
      reporter.reportError("Integer expression expected here", "", forDecl.E1.position);
    if (!e2Type.equals(StdEnvironment.integerType))
      reporter.reportError("Integer expression expected here", "", ast.E2.position);
    idTable.openScope();
    ast.D.visit(this, null);
    ast.C.visit(this, null);
    idTable.closeScope();
    return null;
  }

  // for Identifier := Expression .. Expression while Expression do Command end
  public Object visitForWhileCommand(ForWhileCommand ast, Object o) {
    ForVarDeclaration forDecl = (ForVarDeclaration) ast.D;
    TypeDenoter e1Type = (TypeDenoter) forDecl.E1.visit(this, null);
    TypeDenoter e2Type = (TypeDenoter) ast.E2.visit(this, null);
    idTable.openScope();
    ast.D.visit(this, null);
    TypeDenoter e3Type = (TypeDenoter) ast.E3.visit(this, null);
    ast.C.visit(this, null);
    idTable.closeScope();
    if (!e1Type.equals(StdEnvironment.integerType))
      reporter.reportError("Integer expression expected here", "", forDecl.E1.position);
    if (!e2Type.equals(StdEnvironment.integerType))
      reporter.reportError("Integer expression expected here", "", ast.E2.position);
    if (!e3Type.equals(StdEnvironment.booleanType))
      reporter.reportError("Boolean expression expected here", "", ast.E3.position);
    return null;
  }

  // for Identifier := Expression .. Expression until Expression do Command end
  public Object visitForUntilCommand(ForUntilCommand ast, Object o) {
    ForVarDeclaration forDecl = (ForVarDeclaration) ast.D;
    TypeDenoter e1Type = (TypeDenoter) forDecl.E1.visit(this, null);
    TypeDenoter e2Type = (TypeDenoter) ast.E2.visit(this, null);
    idTable.openScope();
    ast.D.visit(this, null);
    TypeDenoter e3Type = (TypeDenoter) ast.E3.visit(this, null);
    ast.C.visit(this, null);
    idTable.closeScope();
    if (!e1Type.equals(StdEnvironment.integerType))
      reporter.reportError("Integer expression expected here", "", forDecl.E1.position);
    if (!e2Type.equals(StdEnvironment.integerType))
      reporter.reportError("Integer expression expected here", "", ast.E2.position);
    if (!e3Type.equals(StdEnvironment.booleanType))
      reporter.reportError("Boolean expression expected here", "", ast.E3.position);
    return null;
  }

  public Object visitForControl(ForControl ast, Object o) {
    ast.T = (TypeDenoter) ast.E.visit(this, null);
    return ast.T;
  }

  // for Identifier in Expression do Command end
  /*
   * Sebastian Chaves
   */
  public Object visitForInCommand(ForInCommand ast, Object o) {
    TypeDenoter eType = (TypeDenoter) ast.IEI.visit(this, null); // Se obtiene el tipo de la Expression
    ForControl controlForIn = (ForControl) ast.IEI;
    if (eType != StdEnvironment.errorType) {
      if (!(eType instanceof ArrayTypeDenoter)) // Se valida que la Expression sea un arreglo
        reporter.reportError("array expected here", "", ast.IEI.position);
      else
        controlForIn.T = ((ArrayTypeDenoter) eType).T;
      idTable.openScope();
      idTable.enter(controlForIn.I.spelling, controlForIn);
      if (controlForIn.duplicated) {
        reporter.reportError("Identifier already exists", "", controlForIn.position);
      }
      ast.C.visit(this, null);
      idTable.closeScope();
    } else {
      reporter.reportError("array expected here", "", ast.IEI.position);
    }
    return null;
  }

  // repeat while Expression do Command end
  public Object visitWhileLoop(WhileLoop ast, Object o) {
    TypeDenoter eType = (TypeDenoter) ast.E.visit(this, null);
    if (!eType.equals(StdEnvironment.booleanType))
      reporter.reportError("Boolean expression expected here", "", ast.E.position);
    ast.C.visit(this, null);
    return null;
  }

  // repeat until Expression do Command end
  public Object visitUntilLoop(UntilLoop ast, Object o) {
    TypeDenoter eType = (TypeDenoter) ast.E.visit(this, null);
    if (!eType.equals(StdEnvironment.booleanType))
      reporter.reportError("Boolean expression expected here", "", ast.E.position);
    ast.C.visit(this, null);
    return null;
  }

  // repeat do Command while Expression end
  public Object visitDoWhileLoop(DoWhileLoop ast, Object o) {
    TypeDenoter eType = (TypeDenoter) ast.E.visit(this, null);
    if (!eType.equals(StdEnvironment.booleanType))
      reporter.reportError("Boolean expression expected here", "", ast.E.position);
    ast.C.visit(this, null);
    return null;
  }

  // repeat do Command until Expression end
  public Object visitDoUntilLoop(DoUntilLoop ast, Object o) {
    TypeDenoter eType = (TypeDenoter) ast.E.visit(this, null);
    if (!eType.equals(StdEnvironment.booleanType))
      reporter.reportError("Boolean expression expected here", "", ast.E.position);
    ast.C.visit(this, null);
    return null;
  }

  // repeat Expression times do Command endhis, null);
  public Object visitRepeatTimes(RepeatTimes ast, Object o) {
    TypeDenoter eType = (TypeDenoter) ast.E.visit(this, null);
    if (!eType.equals(StdEnvironment.integerType))
      reporter.reportError("Integer expression expected here", "", ast.E.position);
    ast.C.visit(this, null);
    return null;
  }

  // Expressions

  // Returns the TypeDenoter denoting the type of the expression. Does
  // not use the given object.

  public Object visitArrayExpression(ArrayExpression ast, Object o) {
    TypeDenoter elemType = (TypeDenoter) ast.AA.visit(this, null);
    IntegerLiteral il = new IntegerLiteral(new Integer(ast.AA.elemCount).toString(),
        ast.position);
    ast.type = new ArrayTypeDenoter(il, elemType, ast.position);
    return ast.type;
  }

  public Object visitBinaryExpression(BinaryExpression ast, Object o) {
    TypeDenoter e1Type = (TypeDenoter) ast.E1.visit(this, null);
    TypeDenoter e2Type = (TypeDenoter) ast.E2.visit(this, null);
    Declaration binding = (Declaration) ast.O.visit(this, null);

    if (binding == null)
      reportUndeclared(ast.O);
    else {
      if (!(binding instanceof BinaryOperatorDeclaration))
        reporter.reportError("\"%\" is not a binary operator",
            ast.O.spelling, ast.O.position);
      BinaryOperatorDeclaration bbinding = (BinaryOperatorDeclaration) binding;
      if (bbinding.ARG1 == StdEnvironment.anyType) {
        // this operator must be "=" or "\="
        if (!e1Type.equals(e2Type))
          reporter.reportError("incompatible argument types for \"%\"",
              ast.O.spelling, ast.position);
      } else if (!e1Type.equals(bbinding.ARG1))
        reporter.reportError("wrong argument type for \"%\"",
            ast.O.spelling, ast.E1.position);
      else if (!e2Type.equals(bbinding.ARG2))
        reporter.reportError("wrong argument type for \"%\"",
            ast.O.spelling, ast.E2.position);
      ast.type = bbinding.RES;
    }
    return ast.type;

  }

  public Object visitCallExpression(CallExpression ast, Object o) {
    Declaration binding = (Declaration) ast.I.visit(this, null);
    if (binding == null) {
      reportUndeclared(ast.I.getSimpleIdentifier());
      ast.type = StdEnvironment.errorType;
    } else if (binding instanceof FuncDeclaration) {
      ast.APS.visit(this, ((FuncDeclaration) binding).FPS);
      ast.type = ((FuncDeclaration) binding).T;
    } else if (binding instanceof FuncFormalParameter) {
      ast.APS.visit(this, ((FuncFormalParameter) binding).FPS);
      ast.type = ((FuncFormalParameter) binding).T;
    } else
      reporter.reportError("\"%\" is not a function identifier",
          ast.I.getSimpleIdentifier().spelling, ast.I.position);
    return ast.type;
  }

  public Object visitCharacterExpression(CharacterExpression ast, Object o) {
    ast.type = StdEnvironment.charType;
    return ast.type;
  }

  public Object visitEmptyExpression(EmptyExpression ast, Object o) {
    ast.type = null;
    return ast.type;
  }

  public Object visitIfExpression(IfExpression ast, Object o) {
    TypeDenoter e1Type = (TypeDenoter) ast.E1.visit(this, null);
    if (!e1Type.equals(StdEnvironment.booleanType))
      reporter.reportError("Boolean expression expected here", "",
          ast.E1.position);
    TypeDenoter e2Type = (TypeDenoter) ast.E2.visit(this, null);
    TypeDenoter e3Type = (TypeDenoter) ast.E3.visit(this, null);
    if (!e2Type.equals(e3Type))
      reporter.reportError("incompatible limbs in if-expression", "", ast.position);
    ast.type = e2Type;
    return ast.type;
  }

  public Object visitIntegerExpression(IntegerExpression ast, Object o) {
    ast.type = StdEnvironment.integerType;
    return ast.type;
  }

  public Object visitLetExpression(LetExpression ast, Object o) {
    idTable.openScope();
    ast.D.visit(this, null);
    ast.type = (TypeDenoter) ast.E.visit(this, null);
    idTable.closeScope();
    return ast.type;
  }

  public Object visitRecordExpression(RecordExpression ast, Object o) {
    FieldTypeDenoter rType = (FieldTypeDenoter) ast.RA.visit(this, null);
    ast.type = new RecordTypeDenoter(rType, ast.position);
    return ast.type;
  }

  public Object visitUnaryExpression(UnaryExpression ast, Object o) {

    TypeDenoter eType = (TypeDenoter) ast.E.visit(this, null);
    Declaration binding = (Declaration) ast.O.visit(this, null);
    if (binding == null) {
      reportUndeclared(ast.O);
      ast.type = StdEnvironment.errorType;
    } else if (!(binding instanceof UnaryOperatorDeclaration))
      reporter.reportError("\"%\" is not a unary operator",
          ast.O.spelling, ast.O.position);
    else {
      UnaryOperatorDeclaration ubinding = (UnaryOperatorDeclaration) binding;
      if (!eType.equals(ubinding.ARG))
        reporter.reportError("wrong argument type for \"%\"",
            ast.O.spelling, ast.O.position);
      ast.type = ubinding.RES;
    }
    return ast.type;
  }

  public Object visitVnameExpression(VnameExpression ast, Object o) {
    ast.type = (TypeDenoter) ast.V.visit(this, null);
    return ast.type;
  }

  // Declarations

  // Always returns null. Does not use the given object.
  public Object visitBinaryOperatorDeclaration(BinaryOperatorDeclaration ast, Object o) {
    return null;
  }

  public Object visitConstDeclaration(ConstDeclaration ast, Object o) {
    TypeDenoter eType = (TypeDenoter) ast.E.visit(this, null);
    idTable.enter(ast.I.spelling, ast);
    if (ast.duplicated)
      reporter.reportError("identifier \"%\" already declared",
          ast.I.spelling, ast.position);
    return null;
  }

  public Object visitFuncDeclaration(FuncDeclaration ast, Object o) {
    ast.T = (TypeDenoter) ast.T.visit(this, null);
    idTable.enter(ast.I.spelling, ast); // permits recursion
    if (ast.duplicated)
      reporter.reportError("identifier \"%\" already declared",
          ast.I.spelling, ast.position);
    idTable.openScope();
    ast.FPS.visit(this, null);
    TypeDenoter eType = (TypeDenoter) ast.E.visit(this, null);
    idTable.closeScope();
    if (!ast.T.equals(eType))
      reporter.reportError("body of function \"%\" has wrong type",
          ast.I.spelling, ast.E.position);
    return null;
  }

  public Object visitProcDeclaration(ProcDeclaration ast, Object o) {
    idTable.enter(ast.I.spelling, ast); // permits recursion
    if (ast.duplicated)
      reporter.reportError("identifier \"%\" already declared",
          ast.I.spelling, ast.position);
    idTable.openScope();
    ast.FPS.visit(this, null);
    ast.C.visit(this, null);
    idTable.closeScope();
    return null;
  }


  /*Agregar declaracion RecDeclaration
   * Fernanda Murillo
  */
  
  public Object visitRecDeclaration(RECDeclaration ast, Object o) {
    SequentialDeclaration seqAST = (SequentialDeclaration) ast.PFS;
    
    visitRecDeclarationAux(seqAST); // Inserta todos los identificadores en idTable con el uso de los metodos explicados abajo
    
    idTable.openScope(); // segunda mini pasada, procesa los cuerpos y PFS
    ast.PFS.visit(this, null); // se visitan los cuerpos
    idTable.closeScope();
    
    return null;
  }
  
  private void visitRecDeclarationAux(SequentialDeclaration seqDeclAST){ // revisa si d1 y d2 son proc o func y los inserta en idTable de utilizando entreProc y entreFunc (recorrido a proc func)
    if(seqDeclAST.D1 instanceof ProcDeclaration){ // si d1 es proc
      ProcDeclaration procAST = (ProcDeclaration) seqDeclAST.D1;
      enterProc(procAST); // lo inserta a la tabla
    }
    else if (seqDeclAST.D1 instanceof FuncDeclaration){ // si d1 es func 
      FuncDeclaration funcAST = (FuncDeclaration) seqDeclAST.D1;
      enterFunc(funcAST); // lo inserta a la tabla
    }
    else{
      visitRecDeclarationAux((SequentialDeclaration) seqDeclAST.D1); // si no cumple ninguna se hace  llamada recursiva pasando d1 como SequentialDeclaration
    }
    
    if(seqDeclAST.D2 instanceof ProcDeclaration){ // si d2 es proc
      ProcDeclaration procAST = (ProcDeclaration) seqDeclAST.D2;
      enterProc(procAST); // lo inserta a la tabla
    }
    else{
      FuncDeclaration funcAST = (FuncDeclaration) seqDeclAST.D2;  // si d2 es func 
      enterFunc(funcAST); // lo inserta a la tabla
    }
  }
  
  private void enterProc(ProcDeclaration procAST){ //recibe proc y lo guarda en idTable es la primer mini pasada (cuando se hace enter al ast completo)
    idTable.enter (procAST.I.spelling, procAST);
    if (procAST.duplicated)
      reporter.reportError ("identifier \"%\" already declared",
                            procAST.I.spelling, procAST.position);
    idTable.openScope();
    procAST.FPS.visit(this, null);
    idTable.closeScope();
  }
  
  private void enterFunc(FuncDeclaration funcAST){ // recibe func y lo guarda en idTable es la primer mini pasada (cuando se hace enter al ast completo)
    funcAST.T = (TypeDenoter)funcAST.T.visit(this, null);
    idTable.enter (funcAST.I.spelling, funcAST);
    if (funcAST.duplicated)
      reporter.reportError ("identifier \"%\" already declared",
                            funcAST.I.spelling, funcAST.position);
    idTable.openScope();
    funcAST.FPS.visit(this, null);
    idTable.closeScope();
  }

  
  
  /* Agregar declaracion private Dec1 in Dec2 end
   * Fernanda Murillo
  */

  public Object visitPrivateDeclaration(PrivateDeclaration ast, Object o) {

    IdEntry beforeD1 = idTable.latestEntry(); /* el Ref1 indicado abajo */
    ast.D1.visit(this, null);

    IdEntry beforeD2 = idTable.latestEntry(); /* el Ref2 indicado abajo */
    ast.D2.visit(this, null);

    /* Ref3 corresponde a idTable.latestEntry() en este punto */

    idTable.discardLocal(beforeD1, beforeD2);

    return null;
  }
  

  public Object visitSequentialDeclaration(SequentialDeclaration ast, Object o) {
    ast.D1.visit(this, null);
    ast.D2.visit(this, null);
    return null;
  }

  public Object visitTypeDeclaration(TypeDeclaration ast, Object o) {
    ast.T = (TypeDenoter) ast.T.visit(this, null);
    idTable.enter(ast.I.spelling, ast);
    if (ast.duplicated)
      reporter.reportError("identifier \"%\" already declared",
          ast.I.spelling, ast.position);
    return null;
  }

  public Object visitUnaryOperatorDeclaration(UnaryOperatorDeclaration ast, Object o) {
    return null;
  }

  public Object visitVarDeclaration(VarDeclaration ast, Object o) {
    ast.T = (TypeDenoter) ast.T.visit(this, null);
    idTable.enter(ast.I.spelling, ast);
    if (ast.duplicated)
      reporter.reportError("identifier \"%\" already declared",
          ast.I.spelling, ast.position);

    return null;
  }

  public Object visitInitializedVariableDeclaration(VariableInitializedDeclaration ast, Object o) {
    ast.T = (TypeDenoter) ast.E.visit(this, null);
    idTable.enter(ast.I.spelling, ast);
    if (ast.duplicated)
      reporter.reportError("identifier \"%\" already declared",
          ast.I.spelling, ast.position);

    return null;
  }

  public Object visitForVarDeclaration(ForVarDeclaration aThis, Object o) {
    TypeDenoter eType = (TypeDenoter) aThis.E1.visit(this, null);
    idTable.enter(aThis.I.spelling, aThis);
    if (aThis.duplicated)
      reporter.reportError("identifier \"%\" already declared",
          aThis.I.spelling, aThis.position);
    return null;
  }

  // Array Aggregates

  // Returns the TypeDenoter for the Array Aggregate. Does not use the
  // given object.

  public Object visitMultipleArrayAggregate(MultipleArrayAggregate ast, Object o) {
    TypeDenoter eType = (TypeDenoter) ast.E.visit(this, null);
    TypeDenoter elemType = (TypeDenoter) ast.AA.visit(this, null);
    ast.elemCount = ast.AA.elemCount + 1;
    if (!eType.equals(elemType))
      reporter.reportError("incompatible array-aggregate element", "", ast.E.position);
    return elemType;
  }

  public Object visitSingleArrayAggregate(SingleArrayAggregate ast, Object o) {
    TypeDenoter elemType = (TypeDenoter) ast.E.visit(this, null);
    ast.elemCount = 1;
    return elemType;
  }

  // Record Aggregates

  // Returns the TypeDenoter for the Record Aggregate. Does not use the
  // given object.

  public Object visitMultipleRecordAggregate(MultipleRecordAggregate ast, Object o) {
    TypeDenoter eType = (TypeDenoter) ast.E.visit(this, null);
    FieldTypeDenoter rType = (FieldTypeDenoter) ast.RA.visit(this, null);
    TypeDenoter fType = checkFieldIdentifier(rType, ast.I);
    if (fType != StdEnvironment.errorType)
      reporter.reportError("duplicate field \"%\" in record",
          ast.I.spelling, ast.I.position);
    ast.type = new MultipleFieldTypeDenoter(ast.I, eType, rType, ast.position);
    return ast.type;
  }

  public Object visitSingleRecordAggregate(SingleRecordAggregate ast, Object o) {
    TypeDenoter eType = (TypeDenoter) ast.E.visit(this, null);
    ast.type = new SingleFieldTypeDenoter(ast.I, eType, ast.position);
    return ast.type;
  }

  // Formal Parameters

  // Always returns null. Does not use the given object.

  public Object visitConstFormalParameter(ConstFormalParameter ast, Object o) {
    ast.T = (TypeDenoter) ast.T.visit(this, null);
    idTable.enter(ast.I.spelling, ast);
    if (ast.duplicated)
      reporter.reportError("duplicated formal parameter \"%\"",
          ast.I.spelling, ast.position);
    return null;
  }

  public Object visitFuncFormalParameter(FuncFormalParameter ast, Object o) {
    idTable.openScope();
    ast.FPS.visit(this, null);
    idTable.closeScope();
    ast.T = (TypeDenoter) ast.T.visit(this, null);
    idTable.enter(ast.I.spelling, ast);
    if (ast.duplicated)
      reporter.reportError("duplicated formal parameter \"%\"",
          ast.I.spelling, ast.position);
    return null;
  }

  public Object visitProcFormalParameter(ProcFormalParameter ast, Object o) {
    idTable.openScope();
    ast.FPS.visit(this, null);
    idTable.closeScope();
    idTable.enter(ast.I.spelling, ast);
    if (ast.duplicated)
      reporter.reportError("duplicated formal parameter \"%\"",
          ast.I.spelling, ast.position);
    return null;
  }

  public Object visitVarFormalParameter(VarFormalParameter ast, Object o) {
    ast.T = (TypeDenoter) ast.T.visit(this, null);
    idTable.enter(ast.I.spelling, ast);
    if (ast.duplicated)
      reporter.reportError("duplicated formal parameter \"%\"",
          ast.I.spelling, ast.position);
    return null;
  }

  public Object visitEmptyFormalParameterSequence(EmptyFormalParameterSequence ast, Object o) {
    return null;
  }

  public Object visitMultipleFormalParameterSequence(MultipleFormalParameterSequence ast, Object o) {
    ast.FP.visit(this, null);
    ast.FPS.visit(this, null);
    return null;
  }

  public Object visitSingleFormalParameterSequence(SingleFormalParameterSequence ast, Object o) {
    ast.FP.visit(this, null);
    return null;
  }

  // Actual Parameters

  // Always returns null. Uses the given FormalParameter.

  public Object visitConstActualParameter(ConstActualParameter ast, Object o) {
    FormalParameter fp = (FormalParameter) o;
    TypeDenoter eType = (TypeDenoter) ast.E.visit(this, null);

    if (!(fp instanceof ConstFormalParameter))
      reporter.reportError("const actual parameter not expected here", "",
          ast.position);
    else if (!eType.equals(((ConstFormalParameter) fp).T))
      reporter.reportError("wrong type for const actual parameter", "",
          ast.E.position);
    return null;
  }

  public Object visitFuncActualParameter(FuncActualParameter ast, Object o) {
    FormalParameter fp = (FormalParameter) o;

    Declaration binding = (Declaration) ast.I.visit(this, null);
    if (binding == null)
      reportUndeclared(ast.I);
    else if (!(binding instanceof FuncDeclaration ||
        binding instanceof FuncFormalParameter))
      reporter.reportError("\"%\" is not a function identifier",
          ast.I.spelling, ast.I.position);
    else if (!(fp instanceof FuncFormalParameter))
      reporter.reportError("func actual parameter not expected here", "",
          ast.position);
    else {
      FormalParameterSequence FPS = null;
      TypeDenoter T = null;
      if (binding instanceof FuncDeclaration) {
        FPS = ((FuncDeclaration) binding).FPS;
        T = ((FuncDeclaration) binding).T;
      } else {
        FPS = ((FuncFormalParameter) binding).FPS;
        T = ((FuncFormalParameter) binding).T;
      }
      if (!FPS.equals(((FuncFormalParameter) fp).FPS))
        reporter.reportError("wrong signature for function \"%\"",
            ast.I.spelling, ast.I.position);
      else if (!T.equals(((FuncFormalParameter) fp).T))
        reporter.reportError("wrong type for function \"%\"",
            ast.I.spelling, ast.I.position);
    }
    return null;
  }

  public Object visitProcActualParameter(ProcActualParameter ast, Object o) {
    FormalParameter fp = (FormalParameter) o;

    Declaration binding = (Declaration) ast.I.visit(this, null);
    if (binding == null)
      reportUndeclared(ast.I);
    else if (!(binding instanceof ProcDeclaration ||
        binding instanceof ProcFormalParameter))
      reporter.reportError("\"%\" is not a procedure identifier",
          ast.I.spelling, ast.I.position);
    else if (!(fp instanceof ProcFormalParameter))
      reporter.reportError("proc actual parameter not expected here", "",
          ast.position);
    else {
      FormalParameterSequence FPS = null;
      if (binding instanceof ProcDeclaration)
        FPS = ((ProcDeclaration) binding).FPS;
      else
        FPS = ((ProcFormalParameter) binding).FPS;
      if (!FPS.equals(((ProcFormalParameter) fp).FPS))
        reporter.reportError("wrong signature for procedure \"%\"",
            ast.I.spelling, ast.I.position);
    }
    return null;
  }

  public Object visitVarActualParameter(VarActualParameter ast, Object o) {
    FormalParameter fp = (FormalParameter) o;

    TypeDenoter vType = (TypeDenoter) ast.V.visit(this, null);
    if (!ast.V.variable)
      reporter.reportError("actual parameter is not a variable", "",
          ast.V.position);
    else if (!(fp instanceof VarFormalParameter))
      reporter.reportError("var actual parameter not expected here", "",
          ast.V.position);
    else if (!vType.equals(((VarFormalParameter) fp).T))
      reporter.reportError("wrong type for var actual parameter", "",
          ast.V.position);
    return null;
  }

  public Object visitEmptyActualParameterSequence(EmptyActualParameterSequence ast, Object o) {
    FormalParameterSequence fps = (FormalParameterSequence) o;
    if (!(fps instanceof EmptyFormalParameterSequence))
      reporter.reportError("too few actual parameters", "", ast.position);
    return null;
  }

  public Object visitMultipleActualParameterSequence(MultipleActualParameterSequence ast, Object o) {
    FormalParameterSequence fps = (FormalParameterSequence) o;
    if (!(fps instanceof MultipleFormalParameterSequence))
      reporter.reportError("too many actual parameters", "", ast.position);
    else {
      ast.AP.visit(this, ((MultipleFormalParameterSequence) fps).FP);
      ast.APS.visit(this, ((MultipleFormalParameterSequence) fps).FPS);
    }
    return null;
  }

  public Object visitSingleActualParameterSequence(SingleActualParameterSequence ast, Object o) {
    FormalParameterSequence fps = (FormalParameterSequence) o;
    if (!(fps instanceof SingleFormalParameterSequence))
      reporter.reportError("incorrect number of actual parameters", "", ast.position);
    else {
      ast.AP.visit(this, ((SingleFormalParameterSequence) fps).FP);
    }
    return null;
  }

  // Type Denoters

  // Returns the expanded version of the TypeDenoter. Does not
  // use the given object.

  public Object visitAnyTypeDenoter(AnyTypeDenoter ast, Object o) {
    return StdEnvironment.anyType;
  }

  public Object visitArrayTypeDenoter(ArrayTypeDenoter ast, Object o) {
    ast.T = (TypeDenoter) ast.T.visit(this, null);
    if ((Integer.valueOf(ast.IL.spelling).intValue()) == 0)
      reporter.reportError("arrays must not be empty", "", ast.IL.position);
    return ast;
  }

  public Object visitBoolTypeDenoter(BoolTypeDenoter ast, Object o) {
    return StdEnvironment.booleanType;
  }

  public Object visitCharTypeDenoter(CharTypeDenoter ast, Object o) {
    return StdEnvironment.charType;
  }

  public Object visitErrorTypeDenoter(ErrorTypeDenoter ast, Object o) {
    return StdEnvironment.errorType;
  }

  public Object visitSimpleTypeDenoter(SimpleTypeDenoter ast, Object o) {
    Declaration binding = (Declaration) ast.I.visit(this, null);
    if (binding == null) {
      reportUndeclared(ast.I.getSimpleIdentifier());
      return StdEnvironment.errorType;
    } else if (!(binding instanceof TypeDeclaration)) {
      reporter.reportError("\"%\" is not a type identifier",
          ast.I.getSimpleIdentifier().spelling, ast.I.position);
      return StdEnvironment.errorType;
    }
    return ((TypeDeclaration) binding).T;
  }

  public Object visitIntTypeDenoter(IntTypeDenoter ast, Object o) {
    return StdEnvironment.integerType;
  }

  public Object visitRecordTypeDenoter(RecordTypeDenoter ast, Object o) {
    ast.FT = (FieldTypeDenoter) ast.FT.visit(this, null);
    return ast;
  }

  public Object visitMultipleFieldTypeDenoter(MultipleFieldTypeDenoter ast, Object o) {
    ast.T = (TypeDenoter) ast.T.visit(this, null);
    ast.FT.visit(this, null);
    return ast;
  }

  public Object visitSingleFieldTypeDenoter(SingleFieldTypeDenoter ast, Object o) {
    ast.T = (TypeDenoter) ast.T.visit(this, null);
    return ast;
  }

  // Literals, Identifiers and Operators
  public Object visitCharacterLiteral(CharacterLiteral CL, Object o) {
    return StdEnvironment.charType;
  }

  public Object visitIdentifier(Identifier I, Object o) {
    Declaration binding = idTable.retrieve(I.spelling);
    if (binding != null)
      I.decl = binding;
    return binding;
  }

  public Object visitIntegerLiteral(IntegerLiteral IL, Object o) {
    return StdEnvironment.integerType;
  }

  public Object visitOperator(Operator O, Object o) {
    Declaration binding = idTable.retrieve(O.spelling);
    if (binding != null)
      O.decl = binding;
    return binding;
  }

  public Object visitLongIdentifierSimple(LongIdentifierSimple ast, Object o) {

    return ast.I.visit(this, null);
  }

  // Value-or-variable names

  // Determines the address of a named object (constant or variable).
  // This consists of a base object, to which 0 or more field-selection
  // or array-indexing operations may be applied (if it is a record or
  // array). As much as possible of the address computation is done at
  // compile-time. Code is generated only when necessary to evaluate
  // index expressions at run-time.
  // currentLevel is the routine level where the v-name occurs.
  // frameSize is the anticipated size of the local stack frame when
  // the object is addressed at run-time.
  // It returns the description of the base object.
  // offset is set to the total of any field offsets (plus any offsets
  // due to index expressions that happen to be literals).
  // indexed is set to true iff there are any index expressions (other
  // than literals). In that case code is generated to compute the
  // offset due to these indexing operations at run-time.

  // Returns the TypeDenoter of the Vname. Does not use the
  // given object.

  public Object visitDotVname(DotVname ast, Object o) {
    ast.type = null;
    TypeDenoter vType = (TypeDenoter) ast.V.visit(this, null);
    ast.variable = ast.V.variable;
    if (!(vType instanceof RecordTypeDenoter))
      reporter.reportError("record expected here", "", ast.V.position);
    else {
      ast.type = checkFieldIdentifier(((RecordTypeDenoter) vType).FT, ast.I);
      if (ast.type == StdEnvironment.errorType)
        reporter.reportError("no field \"%\" in this record type",
            ast.I.spelling, ast.I.position);
    }
    return ast.type;
  }

  public Object visitSimpleVname(SimpleVname ast, Object o) {
    ast.variable = false;
    ast.type = StdEnvironment.errorType;
    Declaration binding = (Declaration) ast.I.visit(this, null);
    if (binding == null)
      reportUndeclared(ast.I.getSimpleIdentifier());
    else if (binding instanceof ConstDeclaration) {
      ast.type = ((ConstDeclaration) binding).E.type;
      ast.variable = false;
    } else if (binding instanceof ForVarDeclaration) {
      ast.type = ((ForVarDeclaration) binding).E1.type;
      ast.variable = false;
    } else if (binding instanceof VarDeclaration) {
      ast.type = ((VarDeclaration) binding).T;
      ast.variable = true;
    } else if (binding instanceof ConstFormalParameter) {
      ast.type = ((ConstFormalParameter) binding).T;
      ast.variable = false;
    } else if (binding instanceof VarFormalParameter) {
      ast.type = ((VarFormalParameter) binding).T;
      ast.variable = true;
    } else if (binding instanceof ForControl) {
      ast.type = ((ForControl) binding).T;
      ast.variable = false;
    } else if (binding instanceof VariableInitializedDeclaration) {
      ast.type = ((VariableInitializedDeclaration) binding).E.type;
      ast.variable = true;
    } else
      reporter.reportError("\"%\" is not a const or var identifier",
          ast.I.getSimpleIdentifier().spelling, ast.I.position);
    return ast.type;
  }

  public Object visitSubscriptVname(SubscriptVname ast, Object o) {
    TypeDenoter vType = (TypeDenoter) ast.V.visit(this, null);
    ast.variable = ast.V.variable;
    TypeDenoter eType = (TypeDenoter) ast.E.visit(this, null);
    if (vType != StdEnvironment.errorType) {
      if (!(vType instanceof ArrayTypeDenoter))
        reporter.reportError("array expected here", "", ast.V.position);
      else {
        if (!eType.equals(StdEnvironment.integerType))
          reporter.reportError("Integer expression expected here", "",
              ast.E.position);
        ast.type = ((ArrayTypeDenoter) vType).T;
      }
    }
    return ast.type;
  }

  // Programs

  public Object visitProgram(Program ast, Object o) {
    return ast.B.visit(this, null);
  }

  public Object visitBodySingle(BodySingle ast, Object o) {
    return ast.C.visit(this, null);
  }
  // Checks whether the source program, represented by its AST, satisfies the
  // language's scope rules and type rules.
  // Also decorates the AST as follows:
  // (a) Each applied occurrence of an identifier or operator is linked to
  // the corresponding declaration of that identifier or operator.
  // (b) Each expression and value-or-variable-name is decorated by its type.
  // (c) Each type identifier is replaced by the type it denotes.
  // Types are represented by small ASTs.

  public void check(Program ast) {
    ast.visit(this, null);
  }

  /////////////////////////////////////////////////////////////////////////////

  public Checker(ErrorReporter reporter) {
    this.reporter = reporter;
    this.idTable = new IdentificationTable();
    establishStdEnvironment();
  }

  private IdentificationTable idTable;
  private static SourcePosition dummyPos = new SourcePosition();
  private ErrorReporter reporter;

  // Reports that the identifier or operator used at a leaf of the AST
  // has not been declared.

  private void reportUndeclared(Terminal leaf) {
    reporter.reportError("\"%\" is not declared", leaf.spelling, leaf.position);
  }

  private static TypeDenoter checkFieldIdentifier(FieldTypeDenoter ast, Identifier I) {
    if (ast instanceof MultipleFieldTypeDenoter) {
      MultipleFieldTypeDenoter ft = (MultipleFieldTypeDenoter) ast;
      if (ft.I.spelling.compareTo(I.spelling) == 0) {
        I.decl = ast;
        return ft.T;
      } else {
        return checkFieldIdentifier(ft.FT, I);
      }
    } else if (ast instanceof SingleFieldTypeDenoter) {
      SingleFieldTypeDenoter ft = (SingleFieldTypeDenoter) ast;
      if (ft.I.spelling.compareTo(I.spelling) == 0) {
        I.decl = ast;
        return ft.T;
      }
    }
    return StdEnvironment.errorType;
  }

  // Creates a small AST to represent the "declaration" of a standard
  // type, and enters it in the identification table.

  private TypeDeclaration declareStdType(String id, TypeDenoter typedenoter) {

    TypeDeclaration binding;

    binding = new TypeDeclaration(new Identifier(id, dummyPos), typedenoter, dummyPos);
    idTable.enter(id, binding);
    return binding;
  }

  // Creates a small AST to represent the "declaration" of a standard
  // type, and enters it in the identification table.

  private ConstDeclaration declareStdConst(String id, TypeDenoter constType) {

    IntegerExpression constExpr;
    ConstDeclaration binding;

    // constExpr used only as a placeholder for constType
    constExpr = new IntegerExpression(null, dummyPos);
    constExpr.type = constType;
    binding = new ConstDeclaration(new Identifier(id, dummyPos), constExpr, dummyPos);
    idTable.enter(id, binding);
    return binding;
  }

  // Creates a small AST to represent the "declaration" of a standard
  // type, and enters it in the identification table.

  private ProcDeclaration declareStdProc(String id, FormalParameterSequence fps) {

    ProcDeclaration binding;

    binding = new ProcDeclaration(new Identifier(id, dummyPos), fps,
        new EmptyCommand(dummyPos), dummyPos);
    idTable.enter(id, binding);
    return binding;
  }

  // Creates a small AST to represent the "declaration" of a standard
  // type, and enters it in the identification table.

  private FuncDeclaration declareStdFunc(String id, FormalParameterSequence fps,
      TypeDenoter resultType) {

    FuncDeclaration binding;

    binding = new FuncDeclaration(new Identifier(id, dummyPos), fps, resultType,
        new EmptyExpression(dummyPos), dummyPos);
    idTable.enter(id, binding);
    return binding;
  }

  // Creates a small AST to represent the "declaration" of a
  // unary operator, and enters it in the identification table.
  // This "declaration" summarises the operator's type info.

  private UnaryOperatorDeclaration declareStdUnaryOp(String op, TypeDenoter argType, TypeDenoter resultType) {

    UnaryOperatorDeclaration binding;

    binding = new UnaryOperatorDeclaration(new Operator(op, dummyPos),
        argType, resultType, dummyPos);
    idTable.enter(op, binding);
    return binding;
  }

  // Creates a small AST to represent the "declaration" of a
  // binary operator, and enters it in the identification table.
  // This "declaration" summarises the operator's type info.

  private BinaryOperatorDeclaration declareStdBinaryOp(String op, TypeDenoter arg1Type, TypeDenoter arg2type,
      TypeDenoter resultType) {

    BinaryOperatorDeclaration binding;

    binding = new BinaryOperatorDeclaration(new Operator(op, dummyPos),
        arg1Type, arg2type, resultType, dummyPos);
    idTable.enter(op, binding);
    return binding;
  }

  // Creates small ASTs to represent the standard types.
  // Creates small ASTs to represent "declarations" of standard types,
  // constants, procedures, functions, and operators.
  // Enters these "declarations" in the identification table.

  private final static Identifier dummyI = new Identifier("", dummyPos);

  private void establishStdEnvironment() {

    // idTable.startIdentification();
    StdEnvironment.booleanType = new BoolTypeDenoter(dummyPos);
    StdEnvironment.integerType = new IntTypeDenoter(dummyPos);
    StdEnvironment.charType = new CharTypeDenoter(dummyPos);
    StdEnvironment.anyType = new AnyTypeDenoter(dummyPos);
    StdEnvironment.errorType = new ErrorTypeDenoter(dummyPos);

    StdEnvironment.booleanDecl = declareStdType("Boolean", StdEnvironment.booleanType);
    StdEnvironment.falseDecl = declareStdConst("false", StdEnvironment.booleanType);
    StdEnvironment.trueDecl = declareStdConst("true", StdEnvironment.booleanType);
    StdEnvironment.notDecl = declareStdUnaryOp("\\", StdEnvironment.booleanType, StdEnvironment.booleanType);
    StdEnvironment.andDecl = declareStdBinaryOp("/\\", StdEnvironment.booleanType, StdEnvironment.booleanType,
        StdEnvironment.booleanType);
    StdEnvironment.orDecl = declareStdBinaryOp("\\/", StdEnvironment.booleanType, StdEnvironment.booleanType,
        StdEnvironment.booleanType);

    StdEnvironment.integerDecl = declareStdType("Integer", StdEnvironment.integerType);
    StdEnvironment.maxintDecl = declareStdConst("maxint", StdEnvironment.integerType);
    StdEnvironment.addDecl = declareStdBinaryOp("+", StdEnvironment.integerType, StdEnvironment.integerType,
        StdEnvironment.integerType);
    StdEnvironment.subtractDecl = declareStdBinaryOp("-", StdEnvironment.integerType, StdEnvironment.integerType,
        StdEnvironment.integerType);
    StdEnvironment.multiplyDecl = declareStdBinaryOp("*", StdEnvironment.integerType, StdEnvironment.integerType,
        StdEnvironment.integerType);
    StdEnvironment.divideDecl = declareStdBinaryOp("/", StdEnvironment.integerType, StdEnvironment.integerType,
        StdEnvironment.integerType);
    StdEnvironment.moduloDecl = declareStdBinaryOp("//", StdEnvironment.integerType, StdEnvironment.integerType,
        StdEnvironment.integerType);
    StdEnvironment.lessDecl = declareStdBinaryOp("<", StdEnvironment.integerType, StdEnvironment.integerType,
        StdEnvironment.booleanType);
    StdEnvironment.notgreaterDecl = declareStdBinaryOp("<=", StdEnvironment.integerType, StdEnvironment.integerType,
        StdEnvironment.booleanType);
    StdEnvironment.greaterDecl = declareStdBinaryOp(">", StdEnvironment.integerType, StdEnvironment.integerType,
        StdEnvironment.booleanType);
    StdEnvironment.notlessDecl = declareStdBinaryOp(">=", StdEnvironment.integerType, StdEnvironment.integerType,
        StdEnvironment.booleanType);

    StdEnvironment.charDecl = declareStdType("Char", StdEnvironment.charType);
    StdEnvironment.chrDecl = declareStdFunc("chr", new SingleFormalParameterSequence(
        new ConstFormalParameter(dummyI, StdEnvironment.integerType, dummyPos), dummyPos), StdEnvironment.charType);
    StdEnvironment.ordDecl = declareStdFunc("ord", new SingleFormalParameterSequence(
        new ConstFormalParameter(dummyI, StdEnvironment.charType, dummyPos), dummyPos), StdEnvironment.integerType);
    StdEnvironment.eofDecl = declareStdFunc("eof", new EmptyFormalParameterSequence(dummyPos),
        StdEnvironment.booleanType);
    StdEnvironment.eolDecl = declareStdFunc("eol", new EmptyFormalParameterSequence(dummyPos),
        StdEnvironment.booleanType);
    StdEnvironment.getDecl = declareStdProc("get", new SingleFormalParameterSequence(
        new VarFormalParameter(dummyI, StdEnvironment.charType, dummyPos), dummyPos));
    StdEnvironment.putDecl = declareStdProc("put", new SingleFormalParameterSequence(
        new ConstFormalParameter(dummyI, StdEnvironment.charType, dummyPos), dummyPos));
    StdEnvironment.getintDecl = declareStdProc("getint", new SingleFormalParameterSequence(
        new VarFormalParameter(dummyI, StdEnvironment.integerType, dummyPos), dummyPos));
    StdEnvironment.putintDecl = declareStdProc("putint", new SingleFormalParameterSequence(
        new ConstFormalParameter(dummyI, StdEnvironment.integerType, dummyPos), dummyPos));
    StdEnvironment.geteolDecl = declareStdProc("geteol", new EmptyFormalParameterSequence(dummyPos));
    StdEnvironment.puteolDecl = declareStdProc("puteol", new EmptyFormalParameterSequence(dummyPos));
    StdEnvironment.equalDecl = declareStdBinaryOp("=", StdEnvironment.anyType, StdEnvironment.anyType,
        StdEnvironment.booleanType);
    StdEnvironment.unequalDecl = declareStdBinaryOp("\\=", StdEnvironment.anyType, StdEnvironment.anyType,
        StdEnvironment.booleanType);

  }

  // Commands to be implemented

  public Object visitPackageDeclaration(PackageDeclaration ast, Object o) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visitPackageDeclaration'");
  }

  public Object visitPackageIdentifier(PackageIdentifier packageIdentifier, Object o) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visitPackageIdentifier'");
  }



  @Override
  public Object visitLongIdentifierComplex(LongIdentifierComplex ast, Object o) {
    throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools
                                                                   // | Templates.
  }

  @Override
  public Object visitSinglePackageDeclaration(SinglePackage ast, Object o) {
    throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools
                                                                   // | Templates.
  }

  @Override
  public Object visitSequentialPackageDeclaration(SequentialPackage ast, Object o) {
    throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools
                                                                   // | Templates.
  }

  @Override
  public Object visitBodyComplex(BodyComplex ast, Object o) {
    throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools
                                                                   // | Templates.
  }

  @Override
  public Object visitSelectCommandComplex(SelectCommandComplex ast, Object o) {
    // Verify the type of the expression
    TypeDenoter eType = (TypeDenoter) ast.E.visit(this, null);
    if (!((eType.equals(StdEnvironment.integerType)) || (eType.equals(StdEnvironment.charType))))
      reporter.reportError("Integer or Char expression expected here", "", ast.E.position);
    SelectContextual selectInstace = new SelectContextual(eType);
    Set literalsRagne = new HashSet();
    ast.C.visit(this, selectInstace);
    
    idTable.openScope();
    ast.elseCommand.visit(this, null);
    idTable.closeScope();

    return null;
  }

  @Override
  public Object visitSelectCommandSimple(SelectCommandSimple ast, Object o) {

    // Verify the type of the expression
    TypeDenoter eType = (TypeDenoter) ast.E.visit(this, null);
    if (!((eType.equals(StdEnvironment.integerType)) || (eType.equals(StdEnvironment.charType))))
      reporter.reportError("Integer or Char expression expected here", "", ast.E.position);

    SelectContextual selectInstace = new SelectContextual(eType);
    ast.C.visit(this, selectInstace);

    return null;
  }

  @Override
  public Object visitSequentialCase(SequentialCase ast, Object o) {
    // casting of the selectContextualInstace
    SelectContextual selectInstace = (SelectContextual) o;
    // visit the first case
    ast.Case1.visit(this, selectInstace);
    // visit the second case
    ast.Case2.visit(this, selectInstace);
    return null;
  }

  @Override
  public Object visitSingleCase(SingleCase ast, Object o) {
    // casting of the selectContextualInstace
    SelectContextual selectInstace = (SelectContextual) o;
    // get the range of the case
    ast.caseLiterals.visit(this, selectInstace);
    // visit the command
    idTable.openScope();
    ast.commandAST.visit(this, null);
    idTable.closeScope();
    return null;
  }

  @Override
  public Object visitSequentialCaseLiterals(SequentialCaseLiterals ast, Object o) {
    // casting of the selectContextualInstace
    SelectContextual selectInstace = (SelectContextual) o;
    // visit the first case
    ast.caseLiteral1.visit(this, selectInstace);
    // visit the second case
    ast.caseLiteral2.visit(this, selectInstace);
    return null;
  }

  @Override
  public Object visitSingleCaseLiterals(SingleCaseLiterals ast, Object o) {
    // casting of the selectContextualInstace
    SelectContextual selectInstace = (SelectContextual) o;
    // get the range of the case
    ast.caseRange.visit(this, selectInstace);
    return null;

  }

  @Override
  public Object visitCaseRangeSimple(CaseRangeSimple ast, Object o) {

    // casting of the selectContextualInstace
    SelectContextual selectInstace = (SelectContextual) o;

    // if caseLitera is instace of Integer
    if (ast.caseLiteral1 instanceof CaseLiteralInteger) {
      int literal = Integer.parseInt((String) ast.caseLiteral1.visit(this, selectInstace));

      // verify literal is not in the set
      if (selectInstace.set.contains(literal))
        reporter.reportError("The literal " + literal + " is overlapping with other literal case", "", ast.position);

      // add the literal to the set
      selectInstace.set.add(literal);

    } else {
      // if caseLitera is instace of Char
      char literal = ((String) ast.caseLiteral1.visit(this, selectInstace)).charAt(1);
      // verify literal is not in the set
      if (selectInstace.set.contains(literal))
        reporter.reportError("The literal " + literal + " is overlapping with other literal case", "", ast.position);

      // add the literal to the set
      selectInstace.set.add(literal);
    }

    return null;

  }

  @Override
  public Object visitCaseRangeComplex(CaseRangeComplex ast, Object o) {
    // casting of the selectContextualInstace
    SelectContextual selectInstace = (SelectContextual) o;

    // if caseLitera is instace of Integer
    if (ast.caseLiteral1 instanceof CaseLiteralInteger) {
      int literal1 = Integer.parseInt((String) ast.caseLiteral1.visit(this, selectInstace));
      int literal2 = Integer.parseInt((String) ast.caseLiteral2.visit(this, selectInstace));

      // verify if the range is valid
      if (literal1 > literal2) {
        reporter.reportError("The range is not valid", "", ast.position);
      }
      // add the range to the set
      for (int i = literal1; i <= literal2; i++) {
        // verify if literal is not in the set
        if (selectInstace.set.contains(i))
          reporter.reportError("The literal " + i + " is overlapping with other literal case", "", ast.position);
        selectInstace.set.add(i);
      }
    } else {
      // if caseLitera is instace of Char
      char literal1 = ((String)ast.caseLiteral1.visit(this, selectInstace)).charAt(1);
      char literal2 = ((String) ast.caseLiteral2.visit(this, selectInstace)).charAt(1);
      // verify if the range is valid
      if (literal1 > literal2) {
        reporter.reportError("The range is not valid", "", ast.position);
      }
      // add the range to the set
      for (char i = literal1; i <= literal2; i++) {
        // verify if literal is not in the set
        if (selectInstace.set.contains(i))
          reporter.reportError("The literal " + i + " is overlapping with other literal case", "", ast.position);

        selectInstace.set.add(i);
      }
    }

    return null;

  }

  @Override
  public Object visitCaseLiteralInteger(CaseLiteralInteger ast, Object o) {
    // casting of the selectContextualInstace
    SelectContextual selectInstace = (SelectContextual) o;
    ast.type = StdEnvironment.integerType;
    // verify the type of the literal
    if (!ast.type.equals(selectInstace.type)) 
      reporter.reportError("The type of the literal is not the same as the type of the expression", "", ast.literal.position);
    
    return ast.literal.spelling;
  }

  @Override
  public Object visitCaseLiteralChar(CaseLiteralChar ast, Object o) {
    // casting of the selectContextualInstace
    SelectContextual selectInstace = (SelectContextual) o;
    ast.type = StdEnvironment.charType;
    // verify the type of the literal
    if (!ast.type.equals(selectInstace.type)) 
      reporter.reportError("The type of the literal is not the same as the type of the expression", "", ast.literal.position);    
    return ast.literal.spelling;
  }

}
