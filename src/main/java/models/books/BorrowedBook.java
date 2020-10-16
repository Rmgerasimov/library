package models.books;

import models.people.User;

import java.time.LocalDate;

public class BorrowedBook {

    private final PaperBook paperBook;
    private final User user;
    private final LocalDate borrowedDate = LocalDate.now();
    private LocalDate returnDate = borrowedDate.plusDays(14);
    private int postponementCount = 0;

    public BorrowedBook(PaperBook paperBook, User user) {
        this.paperBook = paperBook;
        this.user = user;
    }

    public boolean sentPostponementRequest(int days) {
        if ((postponementCount += days) > 14) {
            return false;
        }
        returnDate = returnDate.plusDays(days);
        postponementCount = postponementCount + days;
        return true;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public String daysLeft() {
        if (LocalDate.now().isAfter(returnDate)) {
            return "You have to return the " + paperBook.getTitle();
        }
        int daysLeft = LocalDate.now().until(returnDate).getDays();
        return daysLeft + " days left in which you must return the " + paperBook.getTitle();
    }

    public User getUser() {
        return user;
    }

    public PaperBook getPaperBook() {
        return paperBook;
    }
}
