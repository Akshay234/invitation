import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ReadFile {
    private ArrayList filesList;
    private String[] lineWiseData;

    public ReadFile(ArrayList files) {
        this.filesList = files;
    }

    private void scan(String fileName) throws IOException {
        File file = new File(fileName);
        if(file.exists()){
            FileReader fileReader = new FileReader(file);
            char[] fileData = new char[(int) file.length()];
            fileReader.read(fileData);
            lineWiseData = new String(fileData).split("\n");
        }
        else {
            throw new IOException(fileName+" Not Found");
        }
    }

    public ArrayList read() throws IOException {
        ArrayList data = new ArrayList();
        for (Object file : filesList) {
            this.scan((String) file);
            Collections.addAll(data, lineWiseData);
        }
        return data;
    }

}
