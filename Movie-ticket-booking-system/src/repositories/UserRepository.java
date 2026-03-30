package repositories;

import models.User;

import java.util.*;

public class UserRepository {
    private final Map<String, User> usersByEmail = new HashMap<>();

    public void save(User user) {
        usersByEmail.put(user.getEmail(), user);
    }

    public User findByEmail(String email) {
        return usersByEmail.get(email);
    }

    public List<User> findAll() {
        return new ArrayList<>(usersByEmail.values());
    }
}