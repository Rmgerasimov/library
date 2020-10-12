package models.books;

import models.enums.Genre;
import models.people.Author;

import static exceptions.ExceptionMessages.INVALID_TOTAL_COPIES;

public class PaperBook extends Book {

    private int totalCopies;
    private int availableCopies;

    public PaperBook(String title, Genre genre, String summary, String isbn,
                     int pages, int yearOfPublication, int totalCopies, Author... authors) {

        super(title, genre, summary, isbn, pages, yearOfPublication, authors);

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
