package models.people;

import models.enums.Gender;

import java.time.LocalDate;

public class Author extends Person {

    private LocalDate birthday;
    private LocalDate deathDay;

    public Author(String firstName, String lastName, Gender gender, String country,
                  int year, int month, int day,
                  int deathYear, int deathMonth, int deathDay) {
        super(firstName, lastName, gender, country);
        birthday = LocalDate.of(year, month, day);
    }
}
