package models.people;

public abstract class Person {

    private final String firstName;
    private final String lastName;
    private final String country;

    public Person(String firstName, String lastName, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
    }
}
