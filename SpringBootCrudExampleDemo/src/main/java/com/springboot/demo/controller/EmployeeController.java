package com.springboot.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.EmployeeService.EmployeeService;
import com.springboot.demo.model.Employee;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employee")
	public void addEmployee(@RequestBody Employee emp)
	{
		employeeService.createEmployee(emp);
	}
	@GetMapping("/employee/{id}")
	public Optional<Employee> findEmployeeById(@PathVariable Long id)
	{
		return employeeService.findById(id);
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
