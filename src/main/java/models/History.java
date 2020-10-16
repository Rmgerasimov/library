package models;

import models.books.BorrowedBook;
import models.books.ElectronicBook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class History {

    private final List<BorrowedBook> borrowedBooks = new ArrayList<>();
    private final List<ElectronicBook> electronicBooks = new ArrayList<>();

    public List<BorrowedBook> getBorrowedBooks() {
        return Collections.unmodifiableList(borrowedBooks);
    }

    public List<ElectronicBook> getReadBooks() {
        return Collections.unmodifiableList(electronicBooks);
    }

    public void addBorrowedBook(BorrowedBook borrowedBook) {
        borrowedBooks.add(borrowedBook);
    }

    public void addElectronicBook(ElectronicBook electronicBook) {
        electronicBooks.add(electronicBook);
    }

}
