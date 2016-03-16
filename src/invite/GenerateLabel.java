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

    public String getAddressLabel() {
        return guestInfo.getCity() +" "+ guestInfo.getState() +"\n"+ guestInfo.getCountry();
    }

    @Override
    public boolean isAge(String value) {
        try {
            return guestInfo.isEligibleForDrink(Integer.parseInt(value));
        }catch(NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean isCountry(String value) {
        return guestInfo.isNationalityOf(value);
    }

//    private String labelByLastNameFirst() {
//        return guestInfo.getLastNameFirst()+ addCountryToLabel()+ addAgeToLabel();
//    }
//
//    private String labelByFirstNameFirst() {
//        return guestInfo.getFirstNameFirst()+ addCountryToLabel()+ addAgeToLabel();
//    }

    private String addAgeToLabel() {
        if(filter.getAge() != null && isAge(filter.getAge())){
            return ", "+guestInfo.getAge();
        }
        return "";
    }

    private String addCountryToLabel() {
        String[] countries = filter.getCountries();
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
        return String.format("%s%s%s",formattedName,addCountryToLabel(),addAgeToLabel());
    }

    public String generate() {
        String nameFormatCommand = filter.nameFormat();
        NameFormat nameFormat = new NameFormat(nameFormatCommand);
        if(nameFormat.isCorrect()) {
            NameRepresentation nameRepresentation = nameFormat.getFormattedName();
            return labelWithAddition(nameRepresentation.formatName(guestInfo.getFirstName(),guestInfo.getLastName(),guestInfo.getGender()));
        }
        else {
            throw new IllegalArgumentException(illegalNameFormatMessage(nameFormatCommand));
        }
    }


}