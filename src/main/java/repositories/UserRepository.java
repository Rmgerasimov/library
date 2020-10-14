package repositories;

import models.people.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private Map<String, String> usernamePassword = new HashMap<>();
    private Collection<User> users = new ArrayList<>();

    public void add(String username, String password, User user) {
        usernamePassword.put(username, password);
        users.add(user);
    }
}
