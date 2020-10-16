package models.books;

import controllers.UserController;
import models.people.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import static models.books.BookGenre.ROMAN;
import static models.people.Gender.MALE;
import static org.junit.jupiter.api.Assertions.*;

class BorrowedBookTest {

    private static BorrowedBook borrowedBook;
    private static final UserController userController = new UserController();

    @BeforeEach
    public void initBorrowBook() {
        userController.createAccount(true, "Rado", "Gerasimov",
                "Bulgaria", "Vidin", "Vida", "Rmgerasimov@abv.bg", MALE, 23,
                "Pardop", "12345");

        Author danBrown = new Author("Dan", "Brown", "USA", LocalDate.of(1964, 6, 22));
        PaperBook book = new PaperBook("Origin", ROMAN,
                "Whoever You Are. Whatever You Believe. Everything Is About To Change.",
                "0739319264", 560, 2017, 2, new ArrayList<>(Collections.singletonList(danBrown)));

        borrowedBook = new BorrowedBook(book, userController.getUserByUsername("Pardop"));
    }

    @Test
    public void testSendPostponementInBounds() {
        boolean postponementRequest = borrowedBook.sentPostponementRequest(5);
        assertTrue(postponementRequest);

        String daysLeft = borrowedBook.daysLeft();
        assertEquals("19 days left in which you must return the Origin", daysLeft);

    }

    @Test
    public void testSendPostponementOutOfBounds() {
        boolean postponementRequest = borrowedBook.sentPostponementRequest(15);
        assertFalse(postponementRequest);
    }

}