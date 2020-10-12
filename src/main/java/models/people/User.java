package models.people;

import models.enums.Gender;

public class User extends Person {

    private int age;
    private String phoneNumber;

    public User(String firstName, String lastName, Gender gender, String country, int age, String phoneNumber) {
        super(firstName, lastName, gender, country);
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

}
