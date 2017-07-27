package com.mindtree.spring.boot.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mindtree.spring.boot.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	@Query(nativeQuery=true)
	public List<Employee> findByDepartmentDeptId(@Param("deptId") Integer deptId);
}
