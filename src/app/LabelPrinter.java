package app;

import filter.Filter;
import invite.Invitation;
import reader.ReadFile;

import java.io.IOException;

public class LabelPrinter {

    public static void main(String[] args) throws IOException {
        try {
            Filter commandFilter = new Filter(args);
            ReadFile readFile = new ReadFile(commandFilter.files());
            Invitation invitation = new Invitation(commandFilter, readFile.read());
            invitation.printLabel();
        }catch (IllegalArgumentException IAExp) {
            wrongArgumentUsage(IAExp.getMessage());
        }catch (IndexOutOfBoundsException IOExp){
            shortDataLengthUsage(IOExp.getMessage());
        }
    }

    private static void shortDataLengthUsage(String shortIndexLengthMessage) {
        System.out.println(shortIndexLengthMessage);
    }

    private static void wrongArgumentUsage(String illegalArgMessage) {
        System.out.println(illegalArgMessage+"\nUsage\n     [inviteByFirstLast.sh/inviteByLastFirst.sh] Additional Info[age or country ...] fileCommand[-F/--Files] [fileNames]");
    }
}
