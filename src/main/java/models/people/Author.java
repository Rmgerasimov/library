package models.people;

import models.books.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static common.ExceptionMessages.INVALID_BIRTHDAY_DATE;
import static common.Validation.checkForCorrectDate;

public class Author extends Person {

    private List<Book> books = new ArrayList<>();
    private final LocalDate birthday;
    private LocalDate deathDay;

    public Author(String firstName, String lastName, String country, int birthYear, int birthMonth,
                  int birthDay, int deathYear, int deathMonth, int deathDay) {
        super(firstName, lastName, country);

        checkForCorrectDate(birthYear, birthMonth, birthDay, INVALID_BIRTHDAY_DATE);
        birthday = LocalDate.of(birthYear, birthMonth, birthDay);

        // todo -> do something with death...
    }
}
