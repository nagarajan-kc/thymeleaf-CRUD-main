package com.nic.employee.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.nic.employee.Entity.Employee;
import com.nic.employee.Repository.EmployeeRepository;
import com.nic.master.Designation.Designation;



@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List < Employee > getAllEmployees() {
        return employeeRepository.findAll();
    }
//
    @Override
    public void saveEmployee(Employee employee) {
       this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(String id) {
       Optional < Employee > optional = employeeRepository.findById(id);
       Employee employee = null;
       if (optional.isPresent()) {
           employee = optional.get();
            } else {
       throw new RuntimeException(" Employee not found for id :: " + id);
       }
            return employee;
}

    @Override
    public void deleteEmployeeById(String id) {
       this.employeeRepository.deleteById(id);
}

	@Override
	public List<Designation> getAllDesignation() {
		String query = "SELECT * FROM designation";
        List<Designation> designation = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Designation.class));
        return designation;
	}

//	@Override
//	public void saveEmployee(Employee employee, Designation designation) {
//		// TODO Auto-generated method stub
//		  this.employeeRepository.save(employee);
//	}


}
