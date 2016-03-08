public class Age {
    int age;

    public Age(int age) {
        this.age = age;
    }

    public boolean isAdult(int limit) {
        return age >= limit;
    }
}
