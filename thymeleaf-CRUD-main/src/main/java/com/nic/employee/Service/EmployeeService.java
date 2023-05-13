package com.nic.employee.Service;

import java.util.List;

import com.nic.employee.Entity.Employee;



public interface EmployeeService {
    List<Employee> getAllEmployees();
    
    void saveEmployee(Employee employee);

    Employee getEmployeeById(String id);

    void deleteEmployeeById(String id);

}