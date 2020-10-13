package models.books;

import common.Genre;
import models.people.Author;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static common.ExceptionMessages.*;
import static common.Validation.*;

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
        checkEnumForNull(genre, INVALID_GENRE);
        checkForValidYear(year, INVALID_BOOK_YEAR);
    }
}
