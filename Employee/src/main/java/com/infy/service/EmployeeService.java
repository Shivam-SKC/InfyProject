package com.infy.service;

import com.infy.DTO.EmployeeDTO;
//import com.infy.entity.Employee;
import com.infy.exception.EmployeeException;

public interface EmployeeService {
//	
	public EmployeeDTO getEmployee( Integer employeeId) throws EmployeeException;
	public void updateEmployee(Integer empId,EmployeeDTO employeeDTO) throws EmployeeException;
	public Integer addEmployee(EmployeeDTO employeeDTO);
	public Integer deleteEmployee(Integer employeeId) throws EmployeeException;

}
