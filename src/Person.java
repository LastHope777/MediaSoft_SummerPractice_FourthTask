public class Person {

    @JsonField(name = "first_name")
    private String firstName;

    @JsonField(name = "age")
    private int age;

    public Person(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }
}
