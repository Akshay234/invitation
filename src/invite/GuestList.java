package invite;

import guest.*;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;


public class GuestList {
    private List<Guest> guestList = new ArrayList<>();

    private Guest createGuest(HashMap<String, String> guestInfo) {
        Name name = new Name(guestInfo.get("firstName"), guestInfo.get("lastName"));
        Gender gender = Objects.equals(guestInfo.get("gender"), "Male") ? Gender.MALE : Gender.FEMALE;
        Place place = new Place(guestInfo.get("city"), guestInfo.get("state"), guestInfo.get("country"));
        Age guestAge = new Age(Integer.parseInt(String.valueOf(guestInfo.get("age"))));
        return new Guest(name, place, gender, guestAge);
    }

    public void addAll(ArrayList<HashMap<String, String>> guestsRecord) {
        for (HashMap<String, String> guestInfo : guestsRecord) {
            guestList.add(createGuest(guestInfo));
        }
    }

    public GuestInfo getDetailsOf(int listNo) {
        return new GuestInfo(guestList.get(listNo));
    }

    public int size() {
        return guestList.size();
    }
}
