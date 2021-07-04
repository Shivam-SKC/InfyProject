package com.infy.API;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.DTO.EmployeeDTO;
import com.infy.entity.Employee;
import com.infy.exception.EmployeeException;
import com.infy.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Validated
@RequestMapping(value="/Employee")
public class EmployeeAPI {
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private Environment environment;

	
	@PostMapping("/")
	public ResponseEntity<String> addEmployee( @Valid @RequestBody EmployeeDTO employeeDTO) throws EmployeeException{
		Integer empid=service.addEmployee(employeeDTO);
		String Successmessage=environment.getProperty("API.INSERT_SUCCESS")+empid;
		return new ResponseEntity<>(Successmessage,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Integer employeeId)throws EmployeeException{
		return new ResponseEntity<>(service.getEmployee(employeeId),HttpStatus.OK);
	}
	
	@PutMapping("/{employeeId}")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer employeeId,@Valid @RequestBody EmployeeDTO employeeDTO)throws EmployeeException{
		service.updateEmployee(employeeId,employeeDTO);
		String SuccessMessage=environment.getProperty("API.UPDATE_SUCCESS")+employeeId;
		return new ResponseEntity<String>(SuccessMessage,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/{employeeId}")
	@ApiOperation(value = "Deleting employee details", notes = "Give a employee id to delete the details of an employee", response = Employee.class)
	public ResponseEntity<String> deleteEmployee( @PathVariable Integer employeeId)throws EmployeeException{
		Integer empId=service.deleteEmployee(employeeId);
		String SuccessMessage=environment.getProperty("API.DELETE_SUCCESS")+empId;
		return new ResponseEntity<String>(SuccessMessage,HttpStatus.OK);
	}
	

}
