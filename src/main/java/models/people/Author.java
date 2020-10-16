package models.people;

import models.books.Book;
import validation.InvalidParameterException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Author extends Person {
    private static final String INVALID_BIRTHDAY_DATE = "The date cannot be null!";

    private final List<Book> books = new ArrayList<>();
    private final LocalDate birthday;
    private LocalDate deathDay;

    public Author(String firstName, String lastName, String country, LocalDate birthDay) {
        super(firstName, lastName, country);
        validateDate(birthDay);
        this.birthday = birthDay;
    }

    public Author(String firstName, String lastName, String country, LocalDate birthDay, LocalDate deathDay) {
        this(firstName, lastName, country, birthDay);
        validateDate(deathDay);
        this.deathDay = deathDay;
    }

    private void validateDate(LocalDate date) {
        if (date == null) {
            throw new InvalidParameterException(INVALID_BIRTHDAY_DATE);
        }
    }
}
