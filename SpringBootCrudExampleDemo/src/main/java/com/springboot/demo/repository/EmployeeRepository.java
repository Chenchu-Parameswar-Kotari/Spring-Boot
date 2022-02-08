package com.springboot.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.demo.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
