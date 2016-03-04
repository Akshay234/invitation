import java.util.Objects;

/**
 * Created by akshayks on 03/03/16.
 */
public class Invitation {
    private Guest guest;
    private String specificCountry = "";

    public Invitation(Guest guest) {
        this.guest = guest;
    }

    public Invitation(Guest guest, String country) {
        this.guest = guest;
        this.specificCountry = country;
    }


    public String inviteByFirstNameFirst() {
        return Objects.equals(guest.getCountry(), specificCountry) ? guest.getFirstNameFirst() +", "+ specificCountry : guest.getFirstNameFirst();
    }

    public String inviteByLastNameFirst() {
        return Objects.equals(guest.getCountry(), specificCountry) ? guest.getLastNameFirst() +", "+ specificCountry : guest.getLastNameFirst();
    }
}
