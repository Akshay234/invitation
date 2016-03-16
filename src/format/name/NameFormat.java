package format.name;

import java.util.HashMap;

public class NameFormat {

    private final HashMap<String, NameRepresentation> nameFormats;
    private final String format;

    public NameFormat(String format) {
        this.format = format;
        nameFormats = new HashMap<>();
        nameFormats.put("-fl",new FirstNameFirst());
        nameFormats.put("-lf",new LastNameFirst());
    }

    public NameRepresentation getNameRepresentation() {
        return nameFormats.get(format);
    }

    public boolean isCorrect() {
        return nameFormats.containsKey(format);
    }
}
