package models.people;

import static validation.GeneralValidation.isValidString;

public abstract class Person {
    private static final String INVALID_FIRST_NAME = "First name cannot be null or empty!";
    private static final String INVALID_LAST_NAME = "Last name cannot be null or empty!";
    private static final String INVALID_COUNTRY = "Country cannot be null ot empty!";

    private final String firstName;
    private final String lastName;
    private final String country;

    public Person(String firstName, String lastName, String country) {
        validateParameters(firstName, lastName, country);
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void validateParameters(String firstName, String lastName, String country) {
        isValidString(firstName, INVALID_FIRST_NAME);
        isValidString(lastName, INVALID_LAST_NAME);
        isValidString(country, INVALID_COUNTRY);
    }
}
