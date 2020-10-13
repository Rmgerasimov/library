package models.people;

import common.Gender;

import java.time.LocalDate;

import static common.ExceptionMessages.INVALID_BIRTHDAY_DATE;
import static common.Validation.checkForCorrectDate;

public class Author extends Person {

    private final LocalDate birthday;
    private LocalDate deathDay;

    public Author(String firstName, String lastName, Gender gender, String country,
                  int birthYear, int birthMonth, int birthDay, int deathYear, int deathMonth, int deathDay) {
        super(firstName, lastName, gender, country);

        checkForCorrectDate(birthYear, birthMonth, birthDay, INVALID_BIRTHDAY_DATE);
        birthday = LocalDate.of(birthYear, birthMonth, birthDay);

        // todo do something with death...
    }
}
