package core;

import enums.Gender;
import models.people.User;
import repositories.AuthorRepository;
import repositories.BookRepository;
import repositories.UserRepository;

import java.util.Scanner;

import static common.ExceptionMessages.*;
import static common.Validation.*;

public class Controller {

    private UserRepository userRepository = new UserRepository();
    private BookRepository bookRepository = new BookRepository();
    private AuthorRepository authorRepository = new AuthorRepository();
    private Scanner scanner = new Scanner(System.in);


    public void signIn(String username, String password) {


    }

    public void createAccount(String firstName, String lastName, String country, String city, String address,
                              String email, String gender, String age, String username, String password) {
        isValidString(firstName, INVALID_FIRST_NAME);
        isValidString(lastName, INVALID_LAST_NAME);
        isValidString(country, INVALID_COUNTRY);
        isValidString(city, INVALID_CITY);
        isValidString(address, INVALID_ADDRESS);
        isValidString(email, INVALID_EMAIL);
        checkEnumForNull(Gender.valueOf(gender.toUpperCase()), INVALID_GENDER);
        isValidInteger(Integer.parseInt(age), INVALID_AGE);
        isValidString(username, INVALID_USERNAME);
        isValidString(password, INVALID_PASSWORD);

        User user = new User(firstName, lastName, country, city, address, email,
                Gender.valueOf(gender.toUpperCase()), Integer.parseInt(age));
        userRepository.add(username, password, user);
    }
}
