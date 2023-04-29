package Triangle.Writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriterHTML {
    private FileWriter fileWriter;

    public WriterHTML(String fileName){
        try {
            //create folder if not exists
            File dir = new File("output" + File.separator);
            dir.mkdirs();
            
            File htmlFile = new File(dir,fileName.concat(".html"));
            //create html file
            fileWriter = new FileWriter(htmlFile);
            
            //write html start
            writeHTML("<!DOCTYPE html>");
            writeHTML("\n");
            writeHTML("<html>");
            writeHTML("\n");
            
            writeHTML("<p style=\"font-family: monospace; font-size:160%;\">");
        } catch (IOException ex) {
            Logger.getLogger(WriterHTML.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public void writeHTML(String html) throws IOException {
        fileWriter.write(html);
        fileWriter.flush();
    }

    //finish html file
    public void finishHTML(){
        try {
            writeHTML("</p>");
            writeHTML("\n");
            writeHTML("</html>");
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(WriterHTML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Write a reserved word bold
    public void writeReservedWord(String word){
        try {
            writeHTML("<b> " + word + " </b>");
        } catch (IOException ex) {
            Logger.getLogger(WriterHTML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Write identifiers, operators and separators black normal
    public void writeNormal(String word){
        try {
            writeHTML("<span style=\"color:black\">" + word + "</span>");
        } catch (IOException ex) {
            Logger.getLogger(WriterHTML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Write a comment green
    public void writeComment(String word){
        try {
            writeHTML("<span style=\"color:green\">" + word + "</span><br>");
        } catch (IOException ex) {
            Logger.getLogger(WriterHTML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Write literals and numbers blue normal
    public void writeBlue(String word){
        try {
            writeHTML("<span style=\"color:blue\">" + word + "</span>");
        } catch (IOException ex) {
            Logger.getLogger(WriterHTML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Write a end of line
    public void writeEndOfLine(){
        try {
            writeHTML("<br>");
        } catch (IOException ex) {
            Logger.getLogger(WriterHTML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Write a tab
    public void writeTab(){
        try {
            writeHTML("&nbsp;&nbsp;&nbsp;&nbsp;");
        } catch (IOException ex) {
            Logger.getLogger(WriterHTML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
