package invite;

import guest.Guest;

public class GuestInfo {
    private Guest guest;

    public GuestInfo(Guest guest) {
        this.guest = guest;
    }

    public boolean isEligibleForDrink(int limit) {
        return guest.isEligibleForDrink(limit);
    }

    public boolean isNationalityOf(String otherCountry) {
        return guest.isNativeOf(otherCountry);
    }

    public int getAge() {
        return guest.getAge();
    }

    public String getCity() {
        return guest.getCity();
    }

    public String getState() {
        return guest.getState();
    }

    public String getCountry() {
        return guest.getCountry();
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
}
