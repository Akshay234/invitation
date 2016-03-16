package filter;

import java.util.*;

public class Filter {
    private final String[] args;
    private final String fileSeparatorCommand = "-F";
    private final String borderCommand = "-b";
    private final String countrySeparatorCommand = "-c";
    private final String ageSeparatorCommand = "-a";
    private final List<String> argsList;

    public Filter(String[] args) {
        this.argsList = Arrays.asList(args);
        this.args = args;
    }

    public List<String> files() {
        ArrayList<String> separatedFiles = new ArrayList<>();

        if(argsList.contains(fileSeparatorCommand)){
            Collections.addAll(separatedFiles,Arrays.copyOfRange(args, argsList.indexOf(fileSeparatorCommand) + 1, argsList.size()));
            return separatedFiles;
        }
        else{
            throw new IllegalArgumentException("No file separator command detected");
        }
    }

    private int nextCommandIndex(int previousCommandIndex) {
        for (int i = previousCommandIndex+1; i < argsList.size(); i++) {
            if(argsList.get(i).startsWith("-")){
                return i;
            }
        }
        return -1;
    }

    public String[] countries() {
        if(argsList.contains(countrySeparatorCommand)){
            int countriesStartingIndex = argsList.indexOf(countrySeparatorCommand)+1;
            int countriesEndingIndex = nextCommandIndex(argsList.indexOf(countrySeparatorCommand));
            return Arrays.copyOfRange(args, countriesStartingIndex, countriesEndingIndex);
        }
        return new String[0];
    }

    public String age() {
        if(argsList.contains(ageSeparatorCommand)){
            if(!argsList.get(argsList.indexOf(ageSeparatorCommand) + 1).startsWith("-")){
                return argsList.get(argsList.indexOf(ageSeparatorCommand) + 1);
            }
        }
        return "";
    }

    public String nameFormat() {
        if(args.length > 0)
            return args[0];
        return "";
    }

    private boolean isBorderRequired() {
        return argsList.contains(borderCommand) && argsList.indexOf(fileSeparatorCommand) > argsList.indexOf(borderCommand);
    }

    public String getLabelDesignCommand() {
        if(isBorderRequired())
            return borderCommand;
        return "-nb";
    }

    public Filter getNewFilter() {
        return new Filter(args);
    }
}
