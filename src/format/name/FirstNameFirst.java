package format.name;

public class FirstNameFirst implements NameRepresentation {

    @Override
    public String formatName(String firstName, String lastName){
        return String.format("%s %s",firstName,lastName);
    }
}
