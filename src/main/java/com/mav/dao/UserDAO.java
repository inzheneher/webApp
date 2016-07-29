package com.mav.dao;

import com.mav.entity.User;

import java.util.List;

public interface UserDAO {
    Long saveUser(User user);

    void deleteUser(Long id);

    List<User> getAllUsers();

    User getUser(Long id);

    User findByCredentials(String username, String password);
}
