package com.infy.service;

import com.infy.DTO.EmployeeDTO;
import com.infy.entity.Employee;
import com.infy.exception.EmployeeException;

public interface EmployeeService {
//	
	public Employee getEmployee( Integer employeeId) throws EmployeeException;
	public void updateEmployee(Integer empId,EmployeeDTO employeeDTO) throws EmployeeException;
	public Integer addEmployee(EmployeeDTO employeeDTO) throws EmployeeException;
	public Integer deleteEmployee(Integer employeeId) throws EmployeeException;

}
