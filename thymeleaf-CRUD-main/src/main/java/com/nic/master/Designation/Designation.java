package com.nic.master.Designation;



import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="designation")
@CrossOrigin(origins =
{ "*" })
public class Designation {

	@NotBlank(message = "Please Give The  Designation")
    @NotNull(message = "Please Give The  Designation")
	private Long code;
	
	@NotBlank(message = "Please Give The  Designation")
    @NotNull(message = "Please Give The  Designation")
	private String field;
	
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}

}
