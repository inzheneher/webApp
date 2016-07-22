
package com.mav.service;
import com.mav.entity.Employee;

import java.util.List;

public interface EmployeeService {
	long createEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(long id);
    List<Employee> getAllEmployees();
    Employee getEmployee(long id);
	List<Employee> getAllEmployees(String employeeName);
}
