package com.mav.dao.impl;

import com.mav.dao.UserDAO;
import com.mav.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/context/componentScan.xml", "classpath:/context/persistance.xml"})
@Transactional
public class UserDAOTest {
    @Autowired
    private UserDAO dao;

    @Test
    public void findById(){
        User user = dao.getUser(1);
        Assert.assertEquals(1, user.getId());
        Assert.assertEquals("Antuan", user.getName());
        Assert.assertEquals("qwerty", user.getPass());
        Assert.assertEquals(true, user.isRole());
    }
}
