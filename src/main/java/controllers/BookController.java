package controllers;

import models.books.Book;
import models.books.BookGenre;
import models.books.ElectronicBook;
import models.books.PaperBook;
import models.people.Author;
import repositories.BookRepository;

import java.util.List;

public class BookController {

    private final BookRepository bookRepository = BookRepository.getInstance();

    public void addPaperBook(String title, BookGenre bookGenre, String summary, String isbn,
                             int pages, int yearOfPublication, int totalCopies, List<Author> authors) {

        Book book = new PaperBook(title, bookGenre, summary, isbn, pages,
                yearOfPublication, totalCopies, authors);
        bookRepository.addBook(book);
    }

    public void addElectronicBook(String title, BookGenre bookGenre, String summary, String isbn,
                                  int pages, int yearOfPublication, String readLink, List<Author> authors) {

        Book book = new ElectronicBook(title, bookGenre, summary, isbn, pages,
                yearOfPublication, readLink, authors);
        bookRepository.addBook(book);
    }
}
