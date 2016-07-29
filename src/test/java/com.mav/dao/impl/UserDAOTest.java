package com.mav.dao.impl;

import com.mav.dao.UserDAO;
import com.mav.entity.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/context/componentScan.xml", "classpath:/context/persistance.xml"})
@Transactional
public class UserDAOTest {
    @Autowired
    private UserDAO dao;

    @Test
    public void findById() {
        User user = dao.getUser(1L);
        Assert.assertEquals(1L, (long) user.getId());
        Assert.assertEquals("Antuan", user.getName());
        Assert.assertEquals("qwerty", user.getPass());
        Assert.assertEquals(true, user.isAdmin());
    }

    @Test
    public void getAll() {
        Assert.assertEquals(1, dao.getAllUsers().size());
    }

    @Test
    public void delete() {
        dao.deleteUser(1L);
        Assert.assertEquals(0, dao.getAllUsers().size());
    }

    @Test
    public void saveUser() {
        User newUser = new User();
        newUser.setName("new user");
        newUser.setPass("slkjdhflsdk");
        newUser.setAdmin(true);

        Long newUserId = dao.saveUser(newUser);

        User userFromDb = dao.getUser(newUserId);

        assertTrue(EqualsBuilder.reflectionEquals(newUser, userFromDb));
    }

    @Test
    public void findByCredentials() {

        User userFromDb = dao.findByCredentials("Antuan", "qwerty");

        Assert.assertEquals(1L, (long) userFromDb.getId());
        Assert.assertEquals("Antuan", userFromDb.getName());
        Assert.assertEquals("qwerty", userFromDb.getPass());
        Assert.assertEquals(true, userFromDb.isAdmin());
    }
}
