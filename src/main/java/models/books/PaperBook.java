package models.books;

import models.people.Author;

import java.util.List;

import static validation.GeneralValidation.isValidInteger;

public class PaperBook extends Book {
    private static final String INVALID_TOTAL_COPIES = "Copies cannot be zero or lower!";

    private int totalCopies;
    private int availableCopies;

    public PaperBook(String title, BookGenre bookGenre, String summary, String isbn,
                     int pages, int yearOfPublication, int totalCopies, List<Author> authors) {

        super(title, bookGenre, summary, isbn, pages, yearOfPublication, authors);

        isValidInteger(totalCopies, INVALID_TOTAL_COPIES);
        this.totalCopies = totalCopies;
        availableCopies = totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void decreaseAvailableCopies() {
        availableCopies = availableCopies - 1;
    }

    public void increaseAvailableCopies() {
        availableCopies = availableCopies + 1;
    }
}
