/**
 * Created by akshayks on 04/03/16.
 */
public class Guest {
    private Name name;
    private Place place;
    private Gender gender;
    private int age;

    public Guest(Name name, Place place, Gender gender, int age) {
        this.name = name;
        this.place = place;
        this.gender = gender;
        this.age = age;
    }

    public String getFirstNameFirst(){
        return gender.getHonorific()+" "+name.firstNameFirst();
    }

    public String getLastNameFirst(){
        return gender.getHonorific()+" "+name.lastNameFirst();
    }

    public String getCountry(){
        return place.getCountry();
    }
}
