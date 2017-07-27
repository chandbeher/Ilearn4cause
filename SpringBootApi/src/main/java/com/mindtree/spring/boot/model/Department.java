package com.mindtree.spring.boot.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer deptId;
	private String deptName;
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval = false, optional = false)
	private Address address;
	@OneToMany(mappedBy="department", orphanRemoval = false, fetch=FetchType.LAZY)
	@JsonIgnore
	private Set<Employee> employees = new HashSet<>();
	
	public Department() {
	}
	public Department(Integer deptId, String deptName, Address address) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.address = address;
	}
	
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
