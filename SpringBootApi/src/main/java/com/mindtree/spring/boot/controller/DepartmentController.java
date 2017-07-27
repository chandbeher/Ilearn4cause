package com.mindtree.spring.boot.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.spring.boot.model.Department;
import com.mindtree.spring.boot.model.Employee;
import com.mindtree.spring.boot.repository.DepartmentRepository;
import com.mindtree.spring.boot.repository.EmployeeRepository;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	@RequestMapping(value="/department", method = RequestMethod.GET)
	public List<Department> getAllDepartment(){
		return departmentRepository.findAll();
	}
	
	@RequestMapping(value = "/department/{deptId}", method  = RequestMethod.GET)
	public Department getDepartmentById(@PathVariable("deptId") Integer deptId){
		return departmentRepository.findOne(deptId);
	}
	@RequestMapping(value="/department/{deptId}/employee", method = RequestMethod.GET)
	public List<Employee> getAllEmployeeOfDepartment(@PathVariable("deptId") Integer deptId){
		
		
		List<Employee> employee = employeeRepository.findByDepartmentDeptId(deptId);
		
		return employee;
	}
	
	@RequestMapping(value="/department", method = RequestMethod.POST)
	public Department registerDepartment(@RequestBody Department department){
		
		return departmentRepository.save(department);
	}
	
	@RequestMapping(value = "/department/{deptId}", method = RequestMethod.DELETE)
	public void removeDepartment(@PathVariable("deptId") Integer deptId){
		departmentRepository.delete(deptId);
	}
	
	public DepartmentRepository getDepartmentRepository() {
		return departmentRepository;
	}
	public void setDepartmentRepository(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	
	
}
