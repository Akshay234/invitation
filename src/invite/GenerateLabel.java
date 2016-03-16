package invite;

import filter.Check;
import filter.Filter;

import java.util.Objects;

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

    private String labelByLastNameFirst() {
        return guestInfo.getLastNameFirst()+ addCountryToLabel()+ addAgeToLabel();
    }

    private String labelByFirstNameFirst() {
        return guestInfo.getFirstNameFirst()+ addCountryToLabel()+ addAgeToLabel();
    }

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

    public String generate() {
        String nameFormat = filter.nameFormat();
        if(Objects.equals(nameFormat, "-fl")){
            return labelByFirstNameFirst();
        }
        if(Objects.equals(nameFormat, "-lf")){
            return labelByLastNameFirst();
        }
        else {
            throw new IllegalArgumentException(illegalNameFormatMessage(nameFormat));
        }
    }
}