package format.name;

public class LastNameFirst implements NameRepresentation {

    @Override
    public String formatName(String firstName, String lastName, String gender){
        return String.format("%s %s, %s",gender,lastName,firstName);
    }
}
