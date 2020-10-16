package models.books;

import models.people.Author;

import java.util.List;

import static validation.GeneralValidation.isValidString;

public class ElectronicBook extends Book {
    protected static final String INVALID_LINK = "The link cannot be null or empty!";

    private String readLink;

    public ElectronicBook(String title, BookGenre bookGenre, String summary, String isbn,
                          int pages, int yearOfPublication, String readLink, List<Author> authors) {
        super(title, bookGenre, summary, isbn, pages, yearOfPublication, authors);

        isValidString(readLink, INVALID_LINK);
        this.readLink = readLink;
    }
}
