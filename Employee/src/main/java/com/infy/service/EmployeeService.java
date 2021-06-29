package com.infy.service;

import com.infy.DTO.EmployeeDTO;
import com.infy.entity.Employee;

public interface EmployeeService {
	
	public Employee getEmployee( Long employeeId);
	public void updateEmployee(EmployeeDTO employeeDTO);

}
