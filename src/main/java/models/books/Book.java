package models.books;

import exceptions.InvalidParameterException;
import models.enums.Genre;
import models.people.Author;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static exceptions.ExceptionMessages.*;

public abstract class Book {

    private String title;
    private String summary;
    private String isbn;
    private Genre genre;
    private List<Author> authors;
    private int pages;
    private int yearOfPublication;

    public Book(String title, Genre genre, String summary, String isbn,
                int pages, int yearOfPublication, Author... authors) {

        validateParameters(title, genre, summary, isbn, pages, yearOfPublication);
        this.title = title;
        this.genre = genre;
        this.summary = summary;
        this.isbn = isbn;
        this.pages = pages;
        this.yearOfPublication = yearOfPublication;
        this.authors = new ArrayList<>(Arrays.asList(authors)); //todo
    }

    private void validateParameters(String title, Genre genre, String summary, String isbn, int pages, int year) {
        isValidString(title, INVALID_BOOK_TITLE);
        isValidString(summary, INVALID_BOOK_SUMMARY);
        isValidString(isbn, INVALID_BOOK_ISBN);
        isValidInteger(pages, INVALID_PAGES);

        if (genre == null) {
            throw new InvalidParameterException(INVALID_GENRE);
        }

        if (year <= 0 || year > 2020) {
            throw new InvalidParameterException(INVALID_BOOK_YEAR);
        }
    }

    protected void isValidString(String check, String message) {
        if (check == null || check.trim().isEmpty()) {
            throw new InvalidParameterException(message);
        }
    }

    protected void isValidInteger(int check, String message) {
        if (check <= 0) {
            throw new InvalidParameterException(message);
        }
    }
}
