package models.people;

import common.Gender;

import static common.ExceptionMessages.*;
import static common.Validation.checkEnumForNull;
import static common.Validation.isValidString;

public abstract class Person {

    private final String firstName;
    private final String lastName;
    private final Gender gender;
    private final String country;

    public Person(String firstName, String lastName, Gender gender, String country) {
        validateParameters(firstName, lastName, gender, country);

        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.country = country;
    }

    private void validateParameters(String firstName, String lastName, Gender gender, String country) {
        isValidString(firstName, INVALID_FIRST_NAME);
        isValidString(lastName, INVALID_LAST_NAME);
        isValidString(country, INVALID_COUNTRY);
        checkEnumForNull(gender, INVALID_GENDER);
    }

}
