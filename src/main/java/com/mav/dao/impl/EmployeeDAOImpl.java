package com.mav.dao.impl;

import com.mav.dao.EmployeeDAO;
import com.mav.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    
	public EmployeeDAOImpl() {
    	System.out.println("EmployeeDAOImpl");
    }
	
	@Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public long createEmployee(Employee employee) {        
        return (Long) hibernateTemplate.save(employee);
    }
    
    @Override
    public void updateEmployee(Employee employee) {
        hibernateTemplate.update(employee);
    }
    
    @Override
    public void deleteEmployee(long id) {
        Employee employee = new Employee();
        employee.setId(id);
        hibernateTemplate.delete(employee);
    }
    
    @Override
    public List<Employee> getAllEmployees() {        
        return hibernateTemplate.loadAll(Employee.class);
    }
    
    @Override
    public Employee getEmployee(long id) {
        return hibernateTemplate.get(Employee.class, id);
    }
}