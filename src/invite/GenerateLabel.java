package invite;

import filter.Check;
import filter.Filter;
import format.name.NameFormat;
import format.name.NameRepresentation;

public class GenerateLabel implements Check {

    private final Filter filter;
    private final GuestInfo guestInfo;

    public GenerateLabel(GuestInfo guestInfo, Filter filter) {
        this.guestInfo = guestInfo;
        this.filter = filter;
    }


    @Override
    public boolean isAgeAbove(String value) {
        try {
            return guestInfo.isAbove(Integer.parseInt(value));
        }catch(NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean isCountry(String value) {
        return guestInfo.isNationalityOf(value);
    }

    private String addAgeToLabel() {
        if(filter.age() != null && isAgeAbove(filter.age())){
            return ", "+guestInfo.getAge();
        }
        return "";
    }

    public String addressLabel() {
        return guestInfo.addressLabel();
    }

    private String addCountryToLabel() {
        String[] countries = filter.countries();
        for (String country : countries) {
            if(isCountry(country)){
                return ", "+country;
            }
        }
        return "";
    }

    private String illegalNameFormatMessage(String wrongNameFormat) {
        return "there is not format like "+wrongNameFormat+" to represent name";
    }

    private String labelWithAddition(String formattedName) {
        return String.format("%s %s%s%s",guestInfo.getGender(),formattedName,addCountryToLabel(),addAgeToLabel());
    }

    public String generate() {
        String nameFormatCommand = filter.nameFormat();
        NameFormat nameFormat = new NameFormat(nameFormatCommand);
        if(nameFormat.isCorrect()) {
            NameRepresentation nameRepresentation = nameFormat.getNameRepresentation();
            return labelWithAddition(guestInfo.nameRepresentationWith(nameRepresentation));
        }
        else {
            throw new IllegalArgumentException(illegalNameFormatMessage(nameFormatCommand));
        }
    }


}