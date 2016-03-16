package guest;

public class Name {
    private final String firstName;
    private final String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName; 
    }

    public String firstNameFirst() {
        return String.format("%s %s", firstName,lastName);
//        return firstName +" "+ lastName;
    }

    public String lastNameFirst() {
        return String.format("%s, %s", lastName, firstName);
//        return lastName + ", "+ firstName;
    }
}
