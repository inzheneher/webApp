package com.mav.user;

import com.mav.entity.User;

public interface UserService {
    User findByCredentials(String username, String password);
}
