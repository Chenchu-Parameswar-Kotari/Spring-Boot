package com.springboot.demo.EmployeeService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.demo.model.Employee;
import com.springboot.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	public void createEmployee(Employee emp)
	{
		employeeRepository.save(emp);
	}
//	public Optional<Employee> getAllEmployees() 
//	{
//		return employeeRepository.findAll();
//	}

	public Optional<Employee> findById(Long id) 
	{
		return employeeRepository.findById(id);
	}
	public void deletebyId(long id)
	{
		 employeeRepository.deleteById(id);
	}
	public void updateEmployee(Employee emp)
	{
		Boolean present=employeeRepository.existsById(emp.getId());
		if(present)
		{
			employeeRepository.save(emp);
		}
	}
}
