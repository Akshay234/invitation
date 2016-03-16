package guestDetails;

import format.name.NameRepresentation;

public class Guest {
    private Name name;
    private Place place;
    private Gender gender;
    private Age age;

    public Guest(Name name, Place place, Gender gender, Age age) {
        this.name = name;
        this.place = place;
        this.gender = gender;
        this.age = age;
    }

    public boolean isAboveTheAgeOf(int limit) {
        return age.isGreaterThanOrEqualTo(limit);
    }

    public boolean isNativeOf(String otherCountry) {
        return place.isCountry(otherCountry);
    }

    public String nameFormattedName(NameRepresentation nameRepresentation) {
        return name.representNameUsing(nameRepresentation);
    }

    public String getGender() {
        return gender.getHonorific();
    }

    public String addressLabel() {
        return place.addressFormat();
    }

    public int getAge() {
        return age.getAge();
    }
}
