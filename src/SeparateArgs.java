import java.util.ArrayList;
import java.util.Objects;

public class SeparateArgs {
    private final String[] args;
    private final String separatorName = "--Files";
    private final String separatorSymbol = "-F";

    public SeparateArgs(String[] args) {
        this.args = args;
    }

    public ArrayList<String> files() {
        ArrayList<String> separatedFiles = new ArrayList<>();
        boolean isFileArg = false;
        for (String arg : args) {
            if (isFileArg) {
                separatedFiles.add(arg);
            }
            if (Objects.equals(arg, separatorName) || Objects.equals(arg, separatorSymbol)) {
                isFileArg = true;
            }
        }
        return separatedFiles;
    }

    public ArrayList<String> additionalCommands() {
        ArrayList<String> separatedAdditionalCommands = new ArrayList<>();
        String arg = args[1];
        int counter = 1;
        while(!Objects.equals(arg, separatorName) && !Objects.equals(arg, separatorSymbol) && counter < args.length) {
            separatedAdditionalCommands.add(arg);
            counter++;
            arg = args[counter];
        }

        return separatedAdditionalCommands;
    }
}
