package com.nic.employee.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Entity
@Table(name= "employee")
public class Employee {

	@Id
	@Column(name="id")
	private String id;
	

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    @NotEmpty(message = "Employee name cannot be empty.")
	@Size(min = 3, max = 50,message = "{Size.Person.FullName}")
	private String name;
	
	@Column 
	private String gender;
	
	@Column 
	private Date dob;
	
	@Column
	private String designation;
	
	@Column 
	private long salary;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getEmployeeName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmployeeId() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	
}

