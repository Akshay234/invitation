package guest;

import format.address.AddressRepresentation;

public class Place implements AddressRepresentation {
    private final String city;
    private final String country;
    private final String state;

    public Place(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
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

    @Override
    public String addressFormat() {
        return "city - "+city+", state - "+state+", country - "+country;
    }
}
