package repositories;

import models.people.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private Map<String, String> usernamePassword = new HashMap<>();
    private Map<String, User> usernameUsers = new HashMap<>();

    public void add(String username, String password, User user) {
        usernamePassword.put(username, password);
        usernameUsers.put(username, user);
    }

    public User getUser(String username, String password) {
        if (usernamePassword.get(username).equals(password)) {
            return usernameUsers.get(username);
        }
        return null;
    }
}
