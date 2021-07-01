package com.infy.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping(value="/Employee")
public class EmployeeAPI {
	@Autowired
	private EmployeeService service;

	
	@PostMapping("/addEmployee")
	public ResponseEntity<String> addEmployee( @RequestBody EmployeeDTO employeeDTO) throws EmployeeException{
		Integer empid=service.addEmployee(employeeDTO);
		String Successmessage="The new employee added with "+empid;
		return new ResponseEntity<>(Successmessage,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getEmployee/{employeeId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer employeeId)throws EmployeeException{
		return new ResponseEntity<>(service.getEmployee(employeeId),HttpStatus.OK);
	}
	
	@PutMapping("/updateEmployee/{employeeId}")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer employeeId,@RequestBody EmployeeDTO employeeDTO)throws EmployeeException{
		service.updateEmployee(employeeId,employeeDTO);
		String SuccessMessage="Employee details is updated for empId"+employeeId;
		return new ResponseEntity<String>(SuccessMessage,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/deleteEmployee/{employeeId}")
	public ResponseEntity<String> deleteEmployee( @PathVariable Integer employeeId)throws EmployeeException{
		Integer empId=service.deleteEmployee(employeeId);
		String SuccessMessage="The Employee is deleted with "+empId;
		return new ResponseEntity<String>(SuccessMessage,HttpStatus.OK);
	}
	

}
