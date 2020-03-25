package com.ajay.springboot.thymeleafDemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajay.springboot.thymeleafDemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// thats it due to data JPA we get all the crud methods for free...
	
	// add method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
}
