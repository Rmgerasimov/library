package models.books;

import enums.BookGenre;
import models.people.Author;

import static common.ExceptionMessages.INVALID_TOTAL_COPIES;
import static common.Validation.isValidInteger;

public class PaperBook extends Book {

    private int totalCopies;
    private int availableCopies;

    public PaperBook(String title, BookGenre bookGenre, String summary, String isbn,
                     int pages, int yearOfPublication, int totalCopies, Author... authors) {

        super(title, bookGenre, summary, isbn, pages, yearOfPublication, authors);

        isValidInteger(totalCopies, INVALID_TOTAL_COPIES);
        this.totalCopies = totalCopies;
        availableCopies = totalCopies;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }
}
