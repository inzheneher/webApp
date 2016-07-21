package com.mav.dao.impl;

import com.mav.dao.UserDAO;
import com.mav.entity.User;
import com.mav.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    public UserDAOImpl() {
        System.out.println("UserDAOImpl");
    }

    @Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public long saveUser(User user) {
        return (long) hibernateUtil.save(user);
    }

    @Override
    public User updateUser(User user) {
        return hibernateUtil.update(user);
    }

    @Override
    public void deleteUser(long id) {
        User user = new User();
        user.setId(id);
        hibernateUtil.delete(user);
    }

    @Override
    public List<User> getAllUsers() {
        return hibernateUtil.fetchAll(User.class);
    }

    @Override
    public User getUser(long id) {
        return hibernateUtil.fetchById(id, User.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUsers(String userName) {
        String query = "SELECT e.* FROM user e WHERE e.name like '%"+ userName +"%'";
        List<Object[]> userObjects = hibernateUtil.fetchAll(query);
        List<User> users = new ArrayList<>();
        for(Object[] userObject: userObjects) {
            User user = new User();
            long id = ((BigInteger) userObject[0]).longValue();
            String name = (String) userObject[1];
            String pass = (String) userObject[2];
            boolean role = (boolean) userObject[3];
            user.setId(id);
            user.setName(name);
            user.setPass(pass);
            user.setRole(role);
            users.add(user);
        }
        System.out.println(users);
        return users;
    }
}
