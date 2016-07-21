package com.mav.dao;

import java.util.List;

import com.mav.entity.User;

public interface UserDAO {
    long saveUser(User user);
    User updateUser(User user);
    void deleteUser(long id);
    List<User> getAllUsers();
    User getUser(long id);
    List<User> getAllUsers(String userName);
}
