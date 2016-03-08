import java.util.ArrayList;
import java.util.Objects;

public class Invitation implements Check {
    private Guest guest;
    private ArrayList specialInfo;

    public Invitation(Guest guest) {
        this.guest = guest;
    }

    public Invitation(Guest guest, ArrayList specialInfo) {
        this.guest = guest;
        this.specialInfo = specialInfo;
    }

    @Override
    public boolean isAge(String value) {
        try {
            guest.isEligibleForDrink(Integer.parseInt(value));
            return true;
        }catch (Error e){
        }
        return false;
    }

    @Override
    public boolean isCountry(String value) {
        return guest.isNationalityOf(value);
    }

    private String filteredSpecialInfo(String value) {
        if(isAge(value) || isCountry(value)){
            return value;
        }
        return "";
    }

    public String inviteByFirstNameFirst() {
        String invitationLabel = guest.getFirstNameFirst();
        int counter = specialInfo.size();
        while(counter > 0) {
            invitationLabel = String.format("%s, %s", invitationLabel, filteredSpecialInfo((String) specialInfo.get(counter)));
        }
        return invitationLabel;
    }

    public String inviteByLastNameFirst() {
        String invitationLabel = guest.getLastNameFirst();
        int counter = specialInfo.size();
        while(counter > 0) {
            invitationLabel = String.format("%s, %s", invitationLabel, filteredSpecialInfo((String) specialInfo.get(counter)));
        }
        return invitationLabel;

    }

    public String getName(String format) {
        if(Objects.equals(format, "-f")){
            return inviteByFirstNameFirst();
        }
        if(Objects.equals(format, "-l")){
            return inviteByLastNameFirst();
        }
        else {
            return "wrong Command";
        }
    }

}