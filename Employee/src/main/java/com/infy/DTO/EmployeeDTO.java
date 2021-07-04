package com.infy.DTO;

import javax.validation.constraints.NotNull;

public class EmployeeDTO {
	
	
	private Integer employeeId;
	@NotNull(message="{employee.name.absent}")
	private String name;
	@NotNull(message="{employee.level.absent}")
	private Integer level;
	
	public EmployeeDTO() {
		
	}
	public EmployeeDTO(Integer employeeId, String name, Integer level) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.level = level;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [employeeId=" + employeeId + ", name=" + name + ", level=" + level + "]";
	}
	
	
}
