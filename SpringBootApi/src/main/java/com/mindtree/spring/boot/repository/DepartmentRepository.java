package com.mindtree.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.spring.boot.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	

}
