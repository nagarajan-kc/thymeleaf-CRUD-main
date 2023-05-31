package com.nic.employee.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.nic.employee.Designation.Designation;
import com.nic.employee.Entity.Employee;
import com.nic.employee.Entity.EmployeeData;
import com.nic.employee.Repository.DesignationRepo;
import com.nic.employee.Repository.EmployeeRepository;
import java.util.ArrayList;



@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private DesignationRepo designationRepo;
  
	@Override
    public List < EmployeeData > getAllEmployees() {
    	
    	 List <EmployeeData> empList=new ArrayList<EmployeeData>();
        String query = "Select * From employee";
//    	String query = "select id,field,dob,gender,name,salary from  employee emp join designation des on emp.designation = des.code";
        List<Employee> employee = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Employee.class));
        for(Employee a:employee) {
        	EmployeeData emp=new EmployeeData();
//        	System.out.println("valuess==>"+a.getDesignation());
//        	System.out.println("valuess==>"+a.getDesignationdesc());
        	String empCode=a.getId();
        	emp.setEmpCode(empCode);
        	
        	String empName=a.getName();
        	emp.setEmpName(empName);
        	
        	String empGender=a.getGender();
        	emp.setEmpGender(empGender);
        	
        	String designationCode=a.getDesignation();
        	emp.setDesignationCode(designationCode);
        	
        	Long salary=a.getSalary();
        	emp.setSalary(salary);
        			
        	LocalDate dob=a.getDob();
        	emp.setEmpDob(String.valueOf(dob));
        	
        	List<Designation> desig=designationRepo.findAllByCode(designationCode);
        	
        	for(Designation s:desig) {
        		
        		String desigDesc=s.getField();
        		emp.setDesignationDesc(desigDesc);
        	}
        	empList.add(emp);
        }
        return empList;
        //    	 return employeeRepository.findAll();

    }

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
    public int deleteEmployeeById(String id) {
    	return jdbcTemplate.update("DELETE FROM Employee WHERE id=?", id);
}

	@Override
	public List<Designation> getAllDesignation() {
		String query = "SELECT code ,field FROM designation";
        List<Designation> designation = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Designation.class));
        return designation;
	}
	
	
	@Override
	public List<Designation> findAll() {
		String query ="SELECT * FROM designation";
        List<Designation> designation = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Designation.class));
        return designation;
	}

//	@Override
//	public void saveEmployee(Employee employee, Designation designation) {
//		// TODO Auto-generated method stub
//		  this.employeeRepository.save(employee);
//	}


}
