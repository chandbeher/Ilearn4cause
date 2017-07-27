package com.mindtree.spring.cloud.cusomer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mindtree.spring.cloud.customer.vo.Account;
import com.mindtree.spring.cloud.service.APIUtilService;


@RestController
public class APIController {

	@Autowired
	private APIUtilService utilService;
	
	@RequestMapping(value="/account/{id}", method=RequestMethod.GET)
	public ResponseEntity<Account> findById(@PathVariable("id") String id){
		
		Account account = utilService.findByNumber(id);
		
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	
	@RequestMapping(value="/account/name/{name}", method=RequestMethod.GET)
	public ResponseEntity<List<Account>> findByName(@PathVariable("name") String name){
		
		List<Account> account = utilService.byOwnerContains(name);
		
		return new ResponseEntity<List<Account>>(account, HttpStatus.OK);
	}
}
