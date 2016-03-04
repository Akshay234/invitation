/**
 * Created by akshayks on 03/03/16.
 */

public enum Gender {
    FEMALE("Ms"),
    MALE("Mr");

    private String honorific;

    Gender(String honorific) {
        this.honorific = honorific;
    }

    public String getHonorific(){
        return honorific;
    }

}
