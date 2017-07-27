package com.mindtree.spring.boot.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.spring.boot.model.Employee;
import com.mindtree.spring.boot.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@RequestMapping(value="/employee/{empId}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable("empId") Integer empId){
		Employee employee = employeeRepository.findOne(empId);
		//employee.add(linkTo(methodOn(EmployeeController.class).getEmployee(empId)).withSelfRel());
		return employee;
	}
	
	@RequestMapping(value="/employee", method = RequestMethod.GET)
	public HttpEntity<List<Employee>> getEmployees(){
		List<Employee> employees = employeeRepository.findAll();
		/*for (Employee employee : employees) {
			Resource<Employee> resource = new Resource<>(employee);	
			  resource.add(linkTo(methodOn(EmployeeController.class).getEmployees(employee.getEmpId())).withSelfRel());
		      // Link to Artist
		     // resource.add(linkTo(methodOn(EmployeeController.class).getEmployees(album.getArtist().getId())).withRel("artist"));
		  
		}
		
		//add(linkTo(methodOn(EmployeeController.class).greeting("")).withSelfRel());*/
		
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public Employee registerEmployee(@RequestBody Employee employee){
		return employeeRepository.save(employee);
	}
	
	@RequestMapping(value = "/employee/{empId}", method = RequestMethod.DELETE)
	public void removeEmployee(@PathVariable("empId") Integer empId){
		employeeRepository.delete(empId);
	}
	
	
	
	
	
	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	
}
