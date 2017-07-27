package com.mindtree.spring.boot.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Employee extends ResourceSupport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;
	private String empName;
	private String job;
	private String mgr;
	private BigDecimal salary;
	private BigDecimal comm;
	@ManyToOne(fetch=FetchType.EAGER, optional = false)
	private Department department;
	
	
	public Employee() {
		super();
	}
	public Employee(Integer empId, String empName, String job, String mgr, BigDecimal salary, BigDecimal comm,
			Department department) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.job = job;
		this.mgr = mgr;
		this.salary = salary;
		this.comm = comm;
		this.department = department;
	}
	@JsonCreator
	public Employee(@JsonProperty("empId")Integer empId) {
		this.empId = empId;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getMgr() {
		return mgr;
	}
	public void setMgr(String mgr) {
		this.mgr = mgr;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public BigDecimal getComm() {
		return comm;
	}
	public void setComm(BigDecimal comm) {
		this.comm = comm;
	}
	
}
