package models.people;

import models.enums.Gender;

public abstract class Person {

    private final String firstName;
    private final String lastName;
    private final Gender gender;
    private final String country;

    public Person(String firstName, String lastName, Gender gender, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.country = country;
    }
}
