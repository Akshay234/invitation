import java.util.ArrayList;
import java.util.Objects;

public class SeparateArgs {
    private final String[] args;

    public SeparateArgs(String[] args) {
        this.args = args;
    }

    private boolean isSeparator(String arg){
        return Objects.equals(arg, "-F") || Objects.equals(arg, "--Files");
    }

    public ArrayList<String> files() {
        ArrayList<String> separatedFiles = new ArrayList<>();
        boolean isFileArg = false;
        for (String arg : args) {
            if (isFileArg) {
                separatedFiles.add(arg);
            }
            if (isSeparator(arg)) {
                isFileArg = true;
            }
        }
        if(separatedFiles.size() == 0){
            throw new IllegalArgumentException("No file separator command detected");
        }
        return separatedFiles;
    }

    public ArrayList<String> additionalCommands() {
        ArrayList<String> separatedAdditionalCommands = new ArrayList<>();
        String arg = args[1];
        int argsFiltered = 0;
        while(!isSeparator(arg) && argsFiltered < args.length) {
            separatedAdditionalCommands.add(arg);
            ++argsFiltered;
            arg = args[argsFiltered+1];
        }
        return separatedAdditionalCommands;
    }
}
