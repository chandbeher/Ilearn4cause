package com.mindtree.spring.cloud.customer.vo;

import java.io.Serializable;

public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
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
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}

