/**
 * Created by akshayks on 04/03/16.
 */
public class Place {
    private final String city;
    private final String country;
    private final String state;

    public Place(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getAddress() {
        return "city - "+city+", state - "+state+", country - "+country;
    }

    public String getCountry() {
        return country;
    }
}
