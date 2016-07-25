package com.mav.dao;

import com.mav.entity.User;

import java.util.List;

public interface UserDAO {
    long saveUser(User user);

    void deleteUser(long id);

    List<User> getAllUsers();

    User getUser(long id);
}
