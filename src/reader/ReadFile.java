package reader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadFile {

    private String[] lineWiseData;
    private List<String> filesList;

    public ReadFile(List<String> files) {
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

    public List<String> read() throws IOException {
        ArrayList<String> filesData = new ArrayList<>();
        for (String file : filesList) {
            scan(file);
            Collections.addAll(filesData, lineWiseData);
        }
        return filesData;
    }
}
