package com.ajay.springboot.thymeleafDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ajay.springboot.thymeleafDemo.entity.Employee;
import com.ajay.springboot.thymeleafDemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired
	 public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	
	// add mapping for /list
	@GetMapping("/list")
	public String getEmployees(Model model) {
		
		//get employees from db
		List<Employee> theEmployees = employeeService.findAll();
		
		// add to the spring model
		
		model.addAttribute("employees", theEmployees);
		
		return "/employees/list-employees";
	}
	
	@GetMapping("/showFormforAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute  to bind the form data
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "/employees/employee-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel) {
		// get the employee
		
		Employee theEmployee = employeeService.findById(theId);
		
		// set employee as model attribute to pre-populate the form
		theModel.addAttribute("employee", theEmployee);
		
		// send over to our form
		
		return "/employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		// save employee
		employeeService.save(theEmployee);
		
		//use redirect to prevent multiple submissions
		return "redirect:/employees/list";
		
		
	}
	
	@GetMapping("/delete")
	public String DeleteEmployee(@RequestParam("employeeId") int theId) {
		
		// delete the employee based on the id
		
		employeeService.deleteById(theId);
		
		return "redirect:/employees/list";
	}

}