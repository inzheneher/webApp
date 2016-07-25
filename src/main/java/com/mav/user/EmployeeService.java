package com.mav.user;

import com.mav.entity.Employee;

import java.util.List;

public interface EmployeeService {
    long createEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(long id);

    List<Employee> getAllEmployees();

    List<Employee> getAllEmployees(String employeeName);

    Employee getEmployee(long id);
}
