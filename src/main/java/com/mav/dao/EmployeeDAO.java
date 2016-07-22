package com.mav.dao;

import java.util.List;

import com.mav.entity.Employee;

public interface EmployeeDAO {
	long createEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(long id);
    List<Employee> getAllEmployees();
    Employee getEmployee(long id);
}
