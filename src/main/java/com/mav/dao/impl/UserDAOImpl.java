package com.mav.dao.impl;

import com.mav.dao.UserDAO;
import com.mav.entity.User;
import com.mav.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
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
    private HibernateTemplate hibernateTemplate;

    @Override
    public long saveUser(User user) {
        return (Long) hibernateTemplate.save(user);
    }

    @Override
    public void updateUser(User user) {
        hibernateTemplate.update(user);
    }

    @Override
    public void deleteUser(long id) {
        User user = new User();
        user.setId(id);
        hibernateTemplate.delete(user);
    }

    @Override
    public List<User> getAllUsers() {
        return hibernateTemplate.loadAll(User.class);
    }

    @Override
    public User getUser(long id) {
        return hibernateTemplate.get(User.class, id);
    }
}
