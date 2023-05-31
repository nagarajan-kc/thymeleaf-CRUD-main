package com.nic.employee.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nic.employee.Designation.Designation;
@Repository
public interface DesignationRepo extends JpaRepository<Designation,String> {

	@Query("select d from Designation d where d.code=:code")
	List<Designation> findAllByCode(@Param("code") String code);
	
}
