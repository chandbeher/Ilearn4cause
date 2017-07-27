package com.mindtree.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.spring.rest.entity.Account;
import com.mindtree.spring.rest.repository.AccountRepository;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public Account readAccount(@PathVariable String username){
		Account account =  accountRepository.findByUsername(username).get();
		if(account == null)
			throw new UsernameNotFoundException("Uname not found " + username);
		return account;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody Account account){
		Account ac =  accountRepository.save(account);
		
		return new ResponseEntity<Account>(ac, HttpStatus.CREATED);
	}
	
	public AccountRepository getAccountRepository() {
		return accountRepository;
	}
	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	
}
