package com.mav.service.impl;
import com.mav.dao.EmployeeDAO;
import com.mav.entity.Employee;
import com.mav.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	public EmployeeServiceImpl() {
		System.out.println("EmployeeServiceImpl()");
	}
	
    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public long createEmployee(Employee employee) {
        return employeeDAO.createEmployee(employee);
    }
    @Override
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }
    @Override
    public void deleteEmployee(long id) {
        employeeDAO.deleteEmployee(id);
    }
    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
    @Override
    public Employee getEmployee(long id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    public List<Employee> getAllEmployees(String employeeName) {
        return null;
    }
}
