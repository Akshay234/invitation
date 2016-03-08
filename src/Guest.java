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

    public String getFirstNameFirst(){
        return String.format("%s %s", gender.getHonorific(), name.firstNameFirst());
    }

    public String getLastNameFirst(){
        return String.format("%s %s", gender.getHonorific(), name.lastNameFirst());
    }

    public String getCountry(){
        return place.getCountry();
    }

    public boolean isEligibleForDrink(int limit) {
        return age.isAdult(limit);
    }

    public boolean isNationalityOf(String otherCountry) {
        return place.isCountry(otherCountry);
    }
}
