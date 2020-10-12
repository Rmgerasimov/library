package models.books;

import models.enums.Genre;
import models.people.Author;

import static exceptions.ExceptionMessages.INVALID_LINK;

public class ElectronicBook extends Book {

    private String readLink;
    private String downloadLink = "There is no link for downloading!";

    public ElectronicBook(String title, Genre genre, String summary, String isbn,
                          int pages, int yearOfPublication, String readLink, String downloadLink, Author... authors) {
        super(title, genre, summary, isbn, pages, yearOfPublication, authors);

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
