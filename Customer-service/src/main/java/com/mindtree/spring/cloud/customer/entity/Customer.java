package com.mindtree.spring.cloud.customer.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="customer")
@Table(name="CUSTOMER")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	private Long id;
	@Column(name="NAME")
	private String name;
	@Column(name="AGE")
	private String age;
	public Customer(Long id, String name, String age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public Customer() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}

