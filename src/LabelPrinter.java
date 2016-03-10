import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class LabelPrinter {

    //    ----------------------Read File--------------------------------
    private static String[] lineWiseData;

    private static void scan(String fileName) throws IOException {
//        --------------lineWise read-----------------------

//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        String lineData = bufferedReader.readLine();
//
//        String dataInFile = lineData;
//        if(file.exists()){
//            while (lineData != null) {
//                dataInFile += "\n"+bufferedReader.readLine();
//                lineData = bufferedReader.readLine();
//            }
//            lineWiseData = dataInFile.split("\n");
//        }

//        --------------char wise read-----------------------

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

    private static ArrayList<String> read(ArrayList<String> files) throws IOException {
        ArrayList<String> filesData = new ArrayList<>();
        for (String file : files) {
            scan(file);
            Collections.addAll(filesData, lineWiseData);
        }
        return filesData;
    }

//    ----------------------Main--------------------------------
    public static void main(String[] args) throws IOException {
        try {
            SeparateArgs separateArgs = new SeparateArgs(args);
            ArrayList<String> files = separateArgs.files();
            ArrayList<String> additionalCommands = separateArgs.additionalCommands();

            GenerateLabel labelGenerator = new GenerateLabel();
            Printer labelPrinter = new Printer();

            Format format = new Format(read(files));
            String[] labels = labelGenerator.generate(args[0], format.getData(),additionalCommands);
            labelPrinter.print(labels);

        }catch (Exception exp) {
            usage(exp.getMessage());
        }
    }

    private static void usage(String exceptionMessage) {
        System.out.println(exceptionMessage+"\nUsage\n     [inviteByFirstLast.sh/inviteByLastFirst.sh] Additional Info[age or country ...] fileCommand[-F/--Files] [fileNames]");
    }
}
