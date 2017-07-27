package com.mindtree.spring.cloud.cusomer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.spring.cloud.customer.entity.Customer;
import com.mindtree.spring.cloud.customer.repository.CustomerRepository;


@RestController
public class CustomerController {

	@Autowired(required=true)
	private CustomerRepository customerRepository;
	
	@RequestMapping(value="/customer/{id}", method=RequestMethod.GET)
	public ResponseEntity<Customer> findById(@PathVariable("id") Long id){
		
		Customer Customer = customerRepository.findById(id);
		
		return new ResponseEntity<Customer>(Customer, HttpStatus.OK);
	}
	
	@RequestMapping(value="/customer/{name}", method=RequestMethod.GET)
	public ResponseEntity<List<Customer>> findByBalanceRange(@PathVariable("name") String name){
		
		List<Customer> Customers = customerRepository.findByName(name);
		
		return new ResponseEntity<List<Customer>>(Customers, HttpStatus.OK);
	}

	public CustomerRepository getCustomerRepository() {
		return customerRepository;
	}
	
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}


	
}
