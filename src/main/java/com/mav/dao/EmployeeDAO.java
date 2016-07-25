package com.mav.dao;

import com.mav.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    long createEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(long id);

    List<Employee> getAllEmployees();

    Employee getEmployee(long id);
}
