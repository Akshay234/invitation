import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class GenerateLabel {

    private Guest createGuest(HashMap<String, String> guestInfo) {
        Name name = new Name(guestInfo.get("firstName"), guestInfo.get("lastName"));
        Gender gender = Objects.equals(guestInfo.get("gender"), "Male") ? Gender.MALE : Gender.FEMALE;
        Place place = new Place(guestInfo.get("city"), guestInfo.get("state"), guestInfo.get("country"));
        Age guestAge = new Age(Integer.parseInt(String.valueOf(guestInfo.get("age"))));
        return new Guest(name, place, gender, guestAge);
    }

    public String[] generate(String format, ArrayList<HashMap<String, String>> guestsRecord, ArrayList<String> additionalCommands) throws IOException {
        String[] labels = new String[guestsRecord.size()];
        for (int i = 0; i < guestsRecord.size(); i++) {
            HashMap<String, String> guestInfo = guestsRecord.get(i);
            Guest guest = createGuest(guestInfo);
            Invitation invite = new Invitation(guest, additionalCommands);
            labels[i] = invite.getNameRepresentationBy(format);
        }
        return labels;
    }
}
