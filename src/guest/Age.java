package guest;

public class Age {
    private int age;

    public Age(int age) {
        this.age = age;
    }

    public boolean isAdult(int limit) {
        return age >= limit;
    }

    public int getAge() {
        return age;
    }
}
