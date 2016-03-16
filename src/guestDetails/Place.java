package guestDetails;

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

    public boolean isCountry(String otherCountry) {
        return country.equals(otherCountry);
    }

    @Override
    public String addressFormat() {
        return String.format("%s %s\n%s",city,state,country);
    }
}
