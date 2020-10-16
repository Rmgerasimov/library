package models.books;

import models.people.Author;
import validation.InvalidParameterException;

import java.util.ArrayList;
import java.util.List;

import static validation.GeneralValidation.isValidInteger;
import static validation.GeneralValidation.isValidString;

public abstract class Book {
    private static final String INVALID_BOOK_TITLE = "Title cannot be null or empty!";
    private static final String INVALID_BOOK_SUMMARY = "Summary cannot be null or empty!";
    private static final String INVALID_BOOK_ISBN = "ISBN number cannot be null or empty!";
    private static final String INVALID_PAGES = "Pages cannot be zero or lower!";
    private static final String INVALID_BOOK_YEAR = "The year of publication cannot be zero or lower!";
    private static final String INVALID_AUTHOR = "The book must have at least one author!";

    private final String title;
    private final String summary;
    private final String isbn;
    private final BookGenre bookGenre;
    private final List<Author> authors;
    private final int pages;
    private final int yearOfPublication;

    public Book(String title, BookGenre bookGenre, String summary, String isbn,
                int pages, int yearOfPublication, List<Author> authors) {

        validateParameters(title, summary, isbn, pages, yearOfPublication, authors);
        this.title = title;
        this.bookGenre = bookGenre;
        this.summary = summary;
        this.isbn = isbn;
        this.pages = pages;
        this.yearOfPublication = yearOfPublication;
        this.authors = new ArrayList<>(authors);
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public String getIsbn() {
        return isbn;
    }

    private void validateParameters(String title, String summary, String isbn, int pages,
                                    int yearOfPublication, List<Author> authors) {
        isValidString(title, INVALID_BOOK_TITLE);
        isValidString(summary, INVALID_BOOK_SUMMARY);
        isValidString(isbn, INVALID_BOOK_ISBN);
        isValidInteger(pages, INVALID_PAGES);
        isValidInteger(yearOfPublication, INVALID_BOOK_YEAR);
        if (authors.isEmpty()) {
            throw new InvalidParameterException(INVALID_AUTHOR);
        }
    }
}
