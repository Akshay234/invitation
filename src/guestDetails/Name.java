package guestDetails;

import format.name.NameRepresentation;

public class Name {
    private final String firstName;
    private final String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String representNameUsing(NameRepresentation nameRepresentation) {
        return nameRepresentation.formatName(firstName,lastName);
    }
}
