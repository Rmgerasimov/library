package models.books;

import enums.BookGenre;
import models.people.Author;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Book {

    private String title;
    private String summary;
    private String isbn;
    private BookGenre bookGenre;
    private List<Author> authors;
    private int pages;
    private int yearOfPublication;

    public Book(String title, BookGenre bookGenre, String summary, String isbn,
                int pages, int yearOfPublication, Author... authors) {

        this.title = title;
        this.bookGenre = bookGenre;
        this.summary = summary;
        this.isbn = isbn;
        this.pages = pages;
        this.yearOfPublication = yearOfPublication;
        this.authors = new ArrayList<>(Arrays.asList(authors)); //todo
    }
}
