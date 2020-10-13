package models.people;

import common.Gender;

import static common.ExceptionMessages.INVALID_AGE;
import static common.ExceptionMessages.INVALID_PHONE_NUMBER;
import static common.Validation.isValidInteger;
import static common.Validation.isValidString;

public class User extends Person {

    private int age;
    private String phoneNumber;

    public User(String firstName, String lastName, Gender gender, String country, int age, String phoneNumber) {
        super(firstName, lastName, gender, country);

        isValidInteger(age, INVALID_AGE);
        isValidString(phoneNumber, INVALID_PHONE_NUMBER);
        this.age = age;
        this.phoneNumber = phoneNumber;
    }
}
