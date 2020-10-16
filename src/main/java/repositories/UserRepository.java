package repositories;

import models.people.User;
import validation.InvalidParameterException;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private static UserRepository userRepository;
    private final BookRepository bookRepository = BookRepository.getInstance();
    private Map<String, User> usersByUsername = new HashMap<>();

    private UserRepository() {
    }

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    public boolean checkForEqualUsername(String username) {
        return usersByUsername.containsKey(username);
    }

    public void addUser(String username, User user) {
        usersByUsername.put(username, user);
    }

    public boolean verifyUser(String username, String password) {
        if (checkForEqualUsername(username)) {
            User user = usersByUsername.get(username);
            return user.getPassword().equals(password);
        }
        return false;
    }

    public void borrowBook(String username, String isbn) {
        User user = usersByUsername.get(username);
        bookRepository.borrowBook(user, isbn);
    }

    public User getUserByUsername(String username) {
        if (username == null) {
            throw new InvalidParameterException("Invalid username");
        }
        return usersByUsername.get(username);
    }
}
