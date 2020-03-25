package com.ajay.springboot.thymeleafDemo.service;

import java.util.List;

import com.ajay.springboot.thymeleafDemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);

}
