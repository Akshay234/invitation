package guest;

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

    public String getCountry(){
        return place.getCountry();
    }

    public boolean isEligibleForDrink(int limit) {
        return age.isAdult(limit);
    }

    public boolean isNativeOf(String otherCountry) {
        return place.isCountry(otherCountry);
    }

    public int getAge() {
        return age.getAge();
    }

    public String getCity() {
        return place.getCity();
    }

    public String getState() {
        return place.getState();
    }

    public String getFirstName() {
        return name.getFirstName();
    }

    public String getLastName() {
        return name.getLastName();
    }

    public String getGender() {
        return gender.getHonorific();
    }
}
