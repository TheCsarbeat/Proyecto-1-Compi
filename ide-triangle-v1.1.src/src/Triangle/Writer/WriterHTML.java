package Triangle.Writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterHTML {
    private FileWriter fileWriter;

    public WriterHTML(String fileName) throws IOException {
        //create folder if not exists
        File dir = new File("output" + File.separator);
        dir.mkdirs();

        //create html file
        fileWriter = new FileWriter("output" + File.separator + fileName + ".html");

    }

    public void writeHTML(String html) throws IOException {
        fileWriter.write(html);
        fileWriter.flush();
    }
}
