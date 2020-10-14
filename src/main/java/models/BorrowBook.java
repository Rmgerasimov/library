package models;

import models.books.PaperBook;

import java.time.LocalDate;

public class BorrowBook {

    private PaperBook paperBook;
    private LocalDate borrowedDate = LocalDate.now();
    private LocalDate returnDate = borrowedDate.plusDays(7);
    private int postponementCount = 0;

    public BorrowBook(PaperBook paperBook) {
        this.paperBook = paperBook;
    }

    // todo postponementRequest()
    // returnDate.plusDays(postponementCount( <= 14 ))

    // todo sendMessage() when the user has not returned the book
}
