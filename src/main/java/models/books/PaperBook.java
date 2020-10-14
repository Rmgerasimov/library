package models.books;

import enums.BookGenre;
import models.people.Author;

public class PaperBook extends Book {

    private int totalCopies;
    private int availableCopies;

    public PaperBook(String title, BookGenre bookGenre, String summary, String isbn,
                     int pages, int yearOfPublication, int totalCopies, Author... authors) {

        super(title, bookGenre, summary, isbn, pages, yearOfPublication, authors);

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
