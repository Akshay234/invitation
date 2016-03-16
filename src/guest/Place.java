package guest;

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

    public boolean isCountry(String otherCountry) {
        return country.equals(otherCountry);
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
