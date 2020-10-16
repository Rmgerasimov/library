package repositories;

import controllers.UserController;
import models.books.Book;
import models.books.PaperBook;
import models.people.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static models.books.BookGenre.ROMAN;
import static models.people.Gender.MALE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BookRepositoryTest {

    private static final BookRepository bookRepository = BookRepository.getInstance();
    private static final UserController userController = new UserController();
    private static Book book;
    private static Author danBrown;

    @BeforeEach
    public void initAccountAndBook() {
        userController.createAccount(true, "Rado", "Gerasimov",
                "Bulgaria", "Vidin", "Vida", "Rmgerasimov@abv.bg", MALE, 23,
                "Pardop", "12345");

        danBrown = new Author("Dan", "Brown", "USA", LocalDate.of(1964, 6, 22));
        book = new PaperBook("Origin", ROMAN,
                "Whoever You Are. Whatever You Believe. Everything Is About To Change.",
                "0739319264", 560, 2017, 2, new ArrayList<>(Collections.singletonList(danBrown)));

        bookRepository.addBook(book);
    }

    @Test
    public void testAddBook() {
        // GIVEN
        // WHEN
        // THEN
        assertEquals(1, bookRepository.getBooksSize());
    }

//    @Test
//    public void testBorrowBook() {
//        // GIVEN
//        // WHEN
//        userController.borrowBook("Pardop", "0739319264");
//
//        // THEN
//        Optional<Book> origin = bookRepository.findPaperBookByTitle("Origin");
//
//        if (origin.isPresent()) {
//            PaperBook book = (PaperBook) origin.get();
//            assertEquals(2, book.getAvailableCopies());
//        }
//
//        //assertEquals(1, bookRepository.getBorrowedBooksSize());
//    }

    @Test
    public void testBorrowBookWhenIsbnIsWrong() {
        // GIVEN
        // WHEN
        userController.borrowBook("Pardop", "665615113");

        // THEN
        Optional<Book> origin = bookRepository.findPaperBookByTitle("Origin");

        if (origin.isPresent()) {
            PaperBook book = (PaperBook) origin.get();
            assertEquals(2, book.getAvailableCopies());
        }
    }

//    @Test
//    public void testBorrowBookWhenAvailableCopiesIsZero() {
//        // GIVEN
//        userController.createAccount(true, "Mitko", "oppop",
//                "Bulgaria", "Vidin", "Vida", "Rmgerasimov@abv.bg", MALE, 23,
//                "Mitko", "12345");
//
//        Book testBook = new PaperBook("Origin", ROMAN,
//                "Whoever You Are. Whatever You Believe. Everything Is About To Change.",
//                "55555", 560, 2017, 2,
//                new ArrayList<>(Collections.singletonList(danBrown)));
//        // WHEN
//        bookRepository.addBook(testBook);
//        assertEquals(1, bookRepository.getBooksSize());
//        userController.borrowBook("Mitko", "55555");
//        userController.borrowBook("Pardop", "55555");
//
//        // THEN
//        assertEquals(2, bookRepository.getBorrowedBooksSize());
//        assertEquals(1, bookRepository.getWaitingUsersSize());
//    }

}
