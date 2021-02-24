package com.vastika.um.repository;

import com.vastika.um.model.User;

import java.util.List;

public interface UserRepository {

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    User getUserById(int id);

    List<User> getAllUser();

    User getUserByUsername(String username);
}
