import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class LabelPrinter {

    private static ArrayList<HashMap<String, String>> reader(ArrayList<String> files) throws IOException {
        ReadFile readFile = new ReadFile(files);
        Format format = new Format(readFile.read());
        return format.getData();
    }

    private static Guest createGuest(HashMap<String, String> guestInfo) {
        Name name = new Name(guestInfo.get("firstName"), guestInfo.get("lastName"));
        Gender gender = Objects.equals(guestInfo.get("gender"), "Male") ? Gender.MALE : Gender.FEMALE;
        Place place = new Place(guestInfo.get("city"), guestInfo.get("state"), guestInfo.get("country"));
        Age guestAge = new Age(Integer.parseInt(String.valueOf(guestInfo.get("age"))));
        return new Guest(name, place, gender, guestAge);
    }

    public static void main(String[] args) throws IOException {
        SeparateArgs separateArgs = new SeparateArgs(args);
        ArrayList<String> files = separateArgs.files();
        ArrayList<HashMap<String, String>> guestsRecord = reader(files);
        ArrayList<String> additionalCommands = separateArgs.additionalCommands();
        try {
            for (HashMap<String, String> guestInfo : guestsRecord) {
                Guest guest = createGuest(guestInfo);
                Invitation invite = new Invitation(guest, additionalCommands);
                System.out.println(invite.getNameRepresentationBy(args[0]));
            }
        }catch (IllegalArgumentException e) {
            usage();
        }


    }
    private static void usage() {
        System.out.println("PrintLabel.sh FormatCommand[-fl/--firstLast/-lf/--lastFirst] [Additional Info] fileCommand[-F/--Files] [fileNames]");
    }


}
