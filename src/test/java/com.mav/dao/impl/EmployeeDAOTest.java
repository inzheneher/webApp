package com.mav.dao.impl;

import com.mav.dao.EmployeeDAO;
import com.mav.entity.Employee;
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
public class EmployeeDAOTest {
    @Autowired
    private EmployeeDAO dao;

    @Test
    public void findById(){
        Employee employee = dao.getEmployee(1);
        Assert.assertEquals(1, employee.getId());
        Assert.assertEquals(42, employee.getAge());
        Assert.assertEquals(250.0, employee.getSalary(), 0.001);
        Assert.assertEquals("Jerusalem", employee.getName());
    }
}