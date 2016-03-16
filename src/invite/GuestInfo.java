package invite;

import format.name.NameRepresentation;
import guestDetails.Guest;

public class GuestInfo {
    private Guest guest;

    public GuestInfo(Guest guest) {
        this.guest = guest;
    }

    public boolean isAbove(int limit) {
        return guest.isAboveTheAgeOf(limit);
    }

    public boolean isNationalityOf(String otherCountry) {
        return guest.isNativeOf(otherCountry);
    }

    public String nameRepresentationWith(NameRepresentation nameRepresentation) {
        return guest.nameFormattedName(nameRepresentation);
    }

    public String getFirstName() {
        return guest.getFirstName();
    }

    public String getLastName() {
        return guest.getLastName();
    }

    public String getGender() {
        return guest.getGender();
    }

    public String addressLabel() {
        return guest.addressLabel();
    }

    public int getAge() {
        return guest.getAge();
    }
}
