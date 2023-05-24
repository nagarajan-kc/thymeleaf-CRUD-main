package com.nic.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nic.employee.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,String>{

}
