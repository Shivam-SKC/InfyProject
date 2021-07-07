package com.infy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.DTO.EmployeeDTO;
import com.infy.entity.Employee;
import com.infy.exception.EmployeeException;
import com.infy.repository.EmployeeRepository;

@Service(value = "employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	// adding new employee
	@Override
	public Integer addEmployee(EmployeeDTO employeeDTO) throws EmployeeException {
		Employee e = new Employee();
		e.setName(employeeDTO.getName());
		e.setLevel(employeeDTO.getLevel());
		repo.save(e);
		return e.getEmployeeId();
	}

	@Override
	public EmployeeDTO getEmployee(Integer empid) throws EmployeeException {
		Optional<Employee> op = repo.findById(empid);
		Employee e = op.orElseThrow(() -> new EmployeeException("Service.EMPLOYEE_NOT_FOUND"));
		EmployeeDTO eDTO = new EmployeeDTO();
		eDTO.setEmployeeId(e.getEmployeeId());
		eDTO.setName(e.getName());
		eDTO.setLevel(e.getLevel());
		return eDTO;

	}

	@Override
	public void updateEmployee(Integer empId, EmployeeDTO employeeDTO) throws EmployeeException {
		Optional<Employee> op = repo.findById(empId);
		Employee e = op.orElseThrow(() -> new EmployeeException("Service.EMPLOYEE_NOT_FOUND"));
		e.setName(employeeDTO.getName());
		e.setEmployeeId(employeeDTO.getEmployeeId());
		e.setLevel(employeeDTO.getLevel());
		repo.save(e);
	}

	@Override
	public Integer deleteEmployee(Integer empid) throws EmployeeException {
		Optional<Employee> op = repo.findById(empid);
		Employee e = op.orElseThrow(() -> new EmployeeException("Service.EMPLOYEE_NOT_FOUND"));
		repo.deleteById(e.getEmployeeId());
		return e.getEmployeeId();
	}

}
