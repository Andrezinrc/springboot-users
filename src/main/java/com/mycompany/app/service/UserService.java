package com.mycompany.app.service;

import com.mycompany.app.model.User;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();
    private int nextId = 1;

    public User createUser(String nome, String email) {
        User user = new User(nextId++, nome, email);
        users.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(int id) {
        return users.stream()
            .filter(user -> user.getId() == id)
            .findFirst()
            .orElse(null);
    }

    public boolean updateUser(int id, String nome, String email) {
        User user = getUserById(id);
        if (user != null) {
            user.setName(nome);
            user.setEmail(email);
            return true;
        }
        return false;
    }
    
    public boolean deleteUser(int id) {
        return users.removeIf(user -> user.getId() == id);
    }
}