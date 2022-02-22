package com.springboot.demo.controller;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.EmployeeService.EmployeeService;
import com.springboot.demo.custom.beans.CustomErrorMessage;
import com.springboot.demo.custom.beans.CustomSucessMessage;
import com.springboot.demo.exception.ResourceNotFoundException;
import com.springboot.demo.model.Employee;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	//private static final Logger logger = LogManager.getLogger(EmployeeController.class);
	
	@PostMapping("/employee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee emp)
	{	
			log.debug("--In add Employee Method--");
			employeeService.createEmployee(emp);
			log.debug("--Exiting add Employee Method--");
			return new ResponseEntity<>(new CustomSucessMessage("Employee created sucessfully", HttpStatus.CREATED.toString()),HttpStatus.CREATED);	
	}
//	@GetMapping("/employee")
//	public ResponseEntity<?> getAllEmployee()
//	{
//		Optional<Employee> employee=employeeService.;
//		if(employee.isEmpty())
//			throw new ResourceNotFoundException("No employee exists with seach ID");	
//		return new ResponseEntity<>(employee.get(),HttpStatus.FOUND);
//	}
	@GetMapping("/employee/{id}")
	public ResponseEntity<?> findEmployeeById(@PathVariable Long id)
	{
		Optional<Employee> employee=employeeService.findById(id);
		if(employee.isEmpty())
			throw new ResourceNotFoundException("No employee exists with seach ID");	
		return new ResponseEntity<>(employee.get(),HttpStatus.FOUND);
	}
	@DeleteMapping("/employee/{id}")
	public void deleteEmployeeById(@PathVariable Long id)
	{
		employeeService.deletebyId(id);
	}
	@PutMapping("/employee")
	public void updateEmployee(@RequestBody Employee emp)
	{
		employeeService.updateEmployee(emp);
	}

}
