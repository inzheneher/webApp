package com.mav.dao.impl;

import com.mav.dao.UserDAO;
import com.mav.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public UserDAOImpl() {
        System.out.println("UserDAOImpl");
    }

    @Override
    public Long saveUser(User user) {
        hibernateTemplate.saveOrUpdate(user);
        return user.getId();
    }

    @Override
    public void deleteUser(Long id) {
        User user = new User();
        user.setId(id);
        hibernateTemplate.delete(user);
    }

    @Override
    public List<User> getAllUsers() {
        return hibernateTemplate.loadAll(User.class);
    }

    @Override
    public User getUser(Long id) {
        return hibernateTemplate.get(User.class, id);
    }

    @Override
    public User findByCredentials(String username, String password) {
        User user = new User();
        user.setName(username);
        user.setPass(password);
        List <User> userFromDB = hibernateTemplate.findByExample(user);
        if (userFromDB.isEmpty()) {
            return null;
        } else {
            return userFromDB.get(0);
        }
    }
}
