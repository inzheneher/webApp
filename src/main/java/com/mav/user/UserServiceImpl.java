package com.mav.user;

import com.mav.dao.UserDAO;
import com.mav.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User findByCredentials(String username, String password) {
        return userDAO.findByCredentials(username, password);
    }
}
