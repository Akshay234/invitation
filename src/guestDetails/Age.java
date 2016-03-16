package guestDetails;

public class Age {
    private int age;

    public Age(int age) {
        this.age = age;
    }

    public boolean isGreaterThanOrEqualTo(int limit) {
        return age >= limit;
    }

    public int getAge() {
        return age;
    }
}
