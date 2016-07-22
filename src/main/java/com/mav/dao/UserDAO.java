package com.mav.dao;

import java.util.List;

import com.mav.entity.User;

public interface UserDAO {
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(long id);
    List<User> getAllUsers();
    User getUser(long id);
}
