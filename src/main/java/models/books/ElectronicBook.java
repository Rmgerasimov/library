package models.books;

import enums.BookGenre;
import models.people.Author;

import static common.ExceptionMessages.INVALID_LINK;
import static common.Validation.isValidString;

public class ElectronicBook extends Book {

    private String readLink;
    private String downloadLink = "There is no link for downloading!";

    public ElectronicBook(String title, BookGenre bookGenre, String summary, String isbn,
                          int pages, int yearOfPublication, String readLink, String downloadLink, Author... authors) {
        super(title, bookGenre, summary, isbn, pages, yearOfPublication, authors);

        isValidString(readLink, INVALID_LINK);
        this.readLink = readLink;

        if (downloadLink != null && !downloadLink.trim().isEmpty()) {
            this.downloadLink = downloadLink;
        }
    }

    public String getDownloadLink() {
        return downloadLink;
    }
}
