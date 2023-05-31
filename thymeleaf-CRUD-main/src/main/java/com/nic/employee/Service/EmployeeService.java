package com.nic.employee.Service;

import java.util.List;

import com.nic.employee.Designation.Designation;
import com.nic.employee.Entity.Employee;
import com.nic.employee.Entity.EmployeeData;


public interface EmployeeService {
    List<EmployeeData> getAllEmployees();
    
    void saveEmployee(Employee employee );

    Employee getEmployeeById(String id);

    int deleteEmployeeById(String id);
    
    List<Designation> getAllDesignation() ;

	List<Designation> findAll();

}