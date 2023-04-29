package Triangle.Writer;

import Triangle.AbstractSyntaxTrees.Program;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    private String fileName;

    public Writer(String fileName) {
        this.fileName = fileName;
    }

    // Draw the AST representing a complete program.
    public void write(Program ast) {
        // Prepare the file to write
        try {
            File dir = new File("output" + File.separator);
            dir.mkdirs();

            File xmlFile = new File(dir, fileName.concat(".xml"));

            FileWriter fileWriter = new FileWriter(xmlFile);

            //HTML header
            fileWriter.write("<?xml version=\"1.0\" standalone=\"yes\"?>\n");

            WriterVisitor layout = new WriterVisitor(fileWriter);
            ast.visit(layout, null);

            fileWriter.close();

        } catch (IOException e) {
            System.err.println("Error while creating file for print the AST");
            e.printStackTrace();
        }
    }

}
