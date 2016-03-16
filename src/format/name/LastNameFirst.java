package format.name;

public class LastNameFirst implements NameRepresentation {

    @Override
    public String formatName(String firstName, String lastName){
        return String.format("%s, %s",lastName,firstName);
    }
}
