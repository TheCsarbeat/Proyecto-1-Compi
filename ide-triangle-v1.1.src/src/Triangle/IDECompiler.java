/*
 * IDE-Triangle v1.0
 * Compiler.java 
 */

package Triangle;

import Triangle.CodeGenerator.Frame;
import java.awt.event.ActionListener;
import Triangle.SyntacticAnalyzer.SourceFile;
import Triangle.Writer.WriterHTML;
import Triangle.Writer.WriterHTMLController;
import Triangle.SyntacticAnalyzer.Scanner;
import Triangle.AbstractSyntaxTrees.Program;
import Triangle.SyntacticAnalyzer.Parser;
import Triangle.ContextualAnalyzer.Checker;
import Triangle.CodeGenerator.Encoder;
import java.io.File;
import Triangle.Writer.Writer;



/** 
 * This is merely a reimplementation of the Triangle.Compiler class. We need
 * to get to the ASTs in order to draw them in the IDE without modifying the
 * original Triangle code.
 *
 * @author Luis Leopoldo P�rez <luiperpe@ns.isi.ulatina.ac.cr>
 */
public class IDECompiler {

    // <editor-fold defaultstate="collapsed" desc=" Methods ">
    /**
     * Creates a new instance of IDECompiler.
     *
     */
    public IDECompiler() {
    }
    
    /**
     * Particularly the same compileProgram method from the Triangle.Compiler
     * class.
     * @param sourceName Path to the source file.
     * @return True if compilation was succesful.
     */
    public boolean compileProgram(String sourceName) {
        System.out.println("********** " +
                           "Triangle Compiler (IDE-Triangle 1.0)" +
                           " **********");
        
        System.out.println("Syntactic Analysis ...");
        SourceFile source = new SourceFile(sourceName);
        Scanner scanner = new Scanner(source);
        report = new IDEReporter();
        Parser parser = new Parser(scanner, report);
        //html writer
        WriterHTML writer = new WriterHTML(sourceName.substring(sourceName.lastIndexOf(File.separatorChar)).replace(".tri", ""));
        source = new SourceFile(sourceName);
        Scanner scanner2 = new Scanner(source);
        scanner2.setWritingHTML(true);
        WriterHTMLController writerController;
        writerController = new WriterHTMLController(scanner2, writer);
        writerController.writeHTML();
        scanner2.setWritingHTML(false);
        
        boolean success = false;
        
        rootAST = parser.parseProgram();
        if (report.numErrors == 0) {
            /*
            System.out.println("Contextual Analysis ...");
            Checker checker = new Checker(report);
            checker.check(rootAST);
            */
            writeXML(rootAST, sourceName.substring(sourceName.lastIndexOf(File.separatorChar)).replace(".tri", ""));
            if (report.numErrors == 0) {
                /*
                System.out.println("Code Generation ...");
                Encoder encoder = new Encoder(report);
                encoder.encodeRun(rootAST, false);
                */
                if (report.numErrors == 0) {
                    //encoder.saveObjectProgram(sourceName.replace(".tri", ".tam"));
                    success = true;
                }
            }
        }

        if (success)
            System.out.println("Compilation was successful.");
        else
            System.out.println("Compilation was unsuccessful.");
        
        return(success);
    }
      
    /**
     * Returns the line number where the first error is.
     * @return Line number.
     */
    public int getErrorPosition() {
        return(report.getFirstErrorPosition());
    }
        
    /**
     * Returns the root Abstract Syntax Tree.
     * @return Program AST (root).
     */
    public Program getAST() {
        return(rootAST);
    }

    private void writeXML(Program programAST, String sourceName){
        Writer writerXML = new Writer(sourceName);
        
        writerXML.write(programAST);
        
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Attributes ">
    private Program rootAST;        // The Root Abstract Syntax Tree.    
    private IDEReporter report;     // Our ErrorReporter class.
    // </editor-fold>
}
