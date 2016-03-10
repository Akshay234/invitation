import java.util.ArrayList;
import java.util.Objects;

public class Invitation implements Check {
    private Guest guest;
    private ArrayList<String> specialInfo;

    public Invitation(Guest guest, ArrayList<String> specialInfo) {
        this.guest = guest;
        this.specialInfo = specialInfo;
    }

    @Override
    public boolean isAge(String value) {
        try {
            return guest.isEligibleForDrink(Integer.parseInt(value));
        }catch(NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean isCountry(String value) {
        return guest.isNationalityOf(value);
    }

    private String filteredSpecialInfo(String value) {
        if(isAge(value)){
            return ""+guest.getAge();
        }
        else if(isCountry(value)) {
            return guest.getCountry();
        }
        return "";
    }

    private String extraAttachments() {
        String invitationLabel = "";
        int counter = 0;
        while(counter < specialInfo.size()) {
            if(filteredSpecialInfo(specialInfo.get(counter)).length() > 0){
                invitationLabel = String.format("%s, %s", invitationLabel, filteredSpecialInfo(specialInfo.get(counter)));
            }
            counter++;
        }
        return invitationLabel;
    }

    private String illegalFormatCommandMessage(String format) {
        return "there is not format like "+format+" to represent name";

    }

    public String getNameRepresentationBy(String format) {
        if(Objects.equals(format, "-fl") || Objects.equals(format, "--firstLast")){
            return guest.getFirstNameFirst() + extraAttachments();
        }
        if(Objects.equals(format, "-lf") || Objects.equals(format, "--lastFirst")){
            return guest.getLastNameFirst() + extraAttachments();
        }
        else {
            throw new IllegalArgumentException(illegalFormatCommandMessage(format));
        }
    }
}