package core;

import enums.BookGenre;
import enums.Gender;
import models.books.PaperBook;
import models.people.User;
import repositories.AuthorRepository;
import repositories.BookRepository;
import repositories.UserRepository;

import java.util.Scanner;

import static common.ExceptionMessages.*;
import static common.Validation.*;

public class Controller {

    private Scanner scanner = new Scanner(System.in);
    private BookRepository bookRepository = new BookRepository();
    private UserRepository userRepository = new UserRepository();
    private AuthorRepository authorRepository = new AuthorRepository();


    public User signIn(String username, String password) {
        return userRepository.getUser(username, password);
    }

    public void createAccount(String firstName, String lastName, String country, String city, String address,
                              String email, String gender, String age, String username, String password) {
        isValidString(firstName, INVALID_FIRST_NAME);
        isValidString(lastName, INVALID_LAST_NAME);
        isValidString(country, INVALID_COUNTRY);
        isValidString(city, INVALID_CITY);
        isValidString(address, INVALID_ADDRESS);
        isValidString(email, INVALID_EMAIL);
        isValidString(gender, INVALID_GENDER);
        isValidString(age, INVALID_AGE);
        isValidInteger(Integer.parseInt(age), INVALID_AGE);
        isValidString(username, INVALID_USERNAME);
        isValidString(password, INVALID_PASSWORD);

        User user = new User(firstName, lastName, country, city, address, email,
                Gender.valueOf(gender.toUpperCase()), Integer.parseInt(age));
        userRepository.add(username, password, user);
    }

    public void addPaperBook(String title, String bookGenre, String summary, String isbn,
                             String pages, String yearOfPublication, String totalCopies, String[] separatedAuthors) {

        isValidString(title, INVALID_BOOK_TITLE);
        isValidString(bookGenre, INVALID_GENRE);
        isValidString(summary, INVALID_BOOK_SUMMARY);
        isValidString(isbn, INVALID_BOOK_ISBN);
        isValidString(pages, INVALID_PAGES);
        isValidInteger(Integer.parseInt(pages), INVALID_PAGES);
        isValidString(yearOfPublication, INVALID_BOOK_YEAR);
        checkForValidYear(Integer.parseInt(yearOfPublication), INVALID_BOOK_YEAR);
        isValidString(totalCopies, INVALID_TOTAL_COPIES);
        isValidInteger(Integer.parseInt(totalCopies), INVALID_TOTAL_COPIES);

        String firstName;
        String lastName;
        for (String author : separatedAuthors) {
            isValidString(author, INVALID_AUTHOR);
            String[] authorNames = author.split(" ");
            firstName = authorNames[0];
            lastName = authorNames[1];

            if (authorRepository.getAuthor(firstName, lastName) {
                // todo
            }
        }

        PaperBook paperBook = new PaperBook(title, BookGenre.valueOf(bookGenre), summary, isbn,
                Integer.parseInt(pages), Integer.parseInt(yearOfPublication), Integer.parseInt(totalCopies), );


    }

    public void addElectronicBook() {

    }
}
