package com.mindtree.spring.cloud.customer.repository;

import org.springframework.data.repository.Repository;

import com.mindtree.spring.cloud.customer.entity.Customer;

import java.lang.Long;
import java.util.List;

/**
 * Repository for Account data implemented using Spring Data JPA.
 * 
 * @author Chandan Behera
 */

public interface CustomerRepository extends Repository<Customer, Long> {
	
	public Customer findById(Long accountId);
	
	public List<Customer> findByName(String name);
	
}
