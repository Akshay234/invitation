package format.name;

public class FirstNameFirst implements NameRepresentation {

    @Override
    public String formatName(String firstName, String lastName, String gender){
        return String.format("%s %s %s",gender,firstName,lastName);
    }
}
