package models.books;

import models.people.Author;

import java.util.List;

import static validation.GeneralValidation.isValidString;

public class DownloadableElectronicBook extends ElectronicBook {
    private String downloadLink;

    public DownloadableElectronicBook(String title, BookGenre bookGenre, String summary, String isbn,
                                      int pages, int yearOfPublication, String readLink,
                                      String downloadLink, List<Author> authors) {
        super(title, bookGenre, summary, isbn, pages, yearOfPublication, readLink, authors);

        isValidString(downloadLink, INVALID_LINK);
        this.downloadLink = downloadLink;
    }
}
