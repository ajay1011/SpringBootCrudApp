package com.ajay.springboot.thymeleafDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.springboot.thymeleafDemo.dao.EmployeeRepository;
import com.ajay.springboot.thymeleafDemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	// set up constructor injection
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	

	@Override
	public List<Employee> findAll() {
		
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int id) {
		
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			throw new RuntimeException("Did not find employee with id "+ id);
		}
		return theEmployee;
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override
	public void deleteById(int id) {
		
		employeeRepository.deleteById(id);

	}

}
