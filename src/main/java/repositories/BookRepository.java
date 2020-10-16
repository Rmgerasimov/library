package repositories;

import models.books.Book;
import models.books.BorrowedBook;
import models.books.PaperBook;
import models.people.Author;
import models.people.User;
import validation.InvalidParameterException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepository {

    private static BookRepository bookRepository;

    private final List<Book> books = new ArrayList<>();
    private final List<BorrowedBook> borrowedBooks = new ArrayList<>();
    private final List<User> waitingUsers = new ArrayList<>();

    private BookRepository() {
    }

    public static BookRepository getInstance() {
        if (bookRepository == null) {
            return new BookRepository();
        }
        return bookRepository;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    private Optional<Book> getBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (book instanceof PaperBook) {
                    return Optional.of(book);
                }
            }
        }
        return Optional.empty();
    }

    public void borrowBook(User user, String isbn) {
        Optional<Book> bookByIsbn = getBookByIsbn(isbn);
        if (!bookByIsbn.isPresent()) {
            return;
        }

        PaperBook book = (PaperBook) bookByIsbn.get();
        if (book.getAvailableCopies() <= 0) {
            user.setWantedBook(book);
            waitingUsers.add(user);
        }

        book.decreaseAvailableCopies();
        BorrowedBook borrowedBook = new BorrowedBook(book, user);
        borrowedBooks.add(borrowedBook);
        user.getHistory().addBorrowedBook(borrowedBook);
    }

    public void returnBook(User user) {
        for (BorrowedBook borrowedBook : borrowedBooks) {
            if (borrowedBook.getUser().equals(user)) {
                borrowedBook.getPaperBook().increaseAvailableCopies();
                borrowedBooks.remove(borrowedBook);
                checkForWaitingUser(borrowedBook.getPaperBook());
            }
        }
    }

    private void checkForWaitingUser(PaperBook book) {
        for (User waitingUser : waitingUsers) {
            if (waitingUser.getWantedBook().equals(book)) {
                borrowBook(waitingUser, book.getIsbn());
                break;
            }
        }
    }

    public List<Book> findBooksByAuthorsName(String firstName, String lastName) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : books) {
            for (Author author : book.getAuthors()) {
                if (author.getFirstName().equals(firstName) && author.getLastName().equals(lastName)) {
                    booksByAuthor.add(book);
                }
            }
        }
        return booksByAuthor;
    }

    public Optional<Book> findPaperBookByTitle(String title) {
        if (title == null) {
            throw new InvalidParameterException("Opravete si zaglaviqta we");
        }
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                if (book instanceof PaperBook) {
                    return Optional.of(book);
                }
            }
        }
        return Optional.empty();
    }

    public int getBorrowedBooksSize() {
        return borrowedBooks.size();
    }

    public int getBooksSize() {
        return books.size();
    }

    public int getWaitingUsersSize() {
        return waitingUsers.size();
    }
}
