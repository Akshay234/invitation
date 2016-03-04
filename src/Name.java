/**
 * Created by akshayks on 04/03/16.
 */
public class Name {
    private final String firstName;
    private final String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName; 
    }

    public String firstNameFirst() {
        return firstName +" "+ lastName;
    }

    public String lastNameFirst() {
        return lastName + ", "+ firstName;
    }
}
