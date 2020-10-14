package models.people;

import enums.Gender;

public class User extends Person {

    private String city;
    private String address;
    private String email;
    private Gender gender;
    private int age;

    public User(String firstName, String lastName, String country, String city,
                String address, String email, Gender gender, int age) {

        super(firstName, lastName, country);
        this.city = city;
        this.address = address;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }
}
