package controllers;

import models.people.Gender;
import models.people.User;
import repositories.UserRepository;
import validation.InvalidParameterException;

public class UserController {
    private static final String INVALID_USERNAME = "Username cannot be null or empty!";
    private final UserRepository userRepository = UserRepository.getInstance();

    public String createAccount(boolean isAgreeWithPersonalDataUsage, String firstName, String lastName,
                                String country, String city, String address, String email, Gender gender,
                                int age, String username, String password) {

        if (!isAgreeWithPersonalDataUsage) {
            return "We can't create account if you are not agree with the terms!";
        }

        checkForNull(username);
        if (userRepository.checkForEqualUsername(username)) {
            return "Username already exist";
        }

        User user = new User(firstName, lastName, country, city, address, email, gender, age, username, password);
        userRepository.addUser(username, user);
        return "Account has been created successfully!";
    }

    public boolean signIn(String username, String password) {
        checkForNull(username);
        checkForNull(password);
        return userRepository.verifyUser(username, password);
    }

    public void borrowBook(String username, String isbn) {
        userRepository.borrowBook(username, isbn);
    }

    private void checkForNull(String username) {
        if (username == null) {
            throw new InvalidParameterException(INVALID_USERNAME);
        }
    }

    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
}
