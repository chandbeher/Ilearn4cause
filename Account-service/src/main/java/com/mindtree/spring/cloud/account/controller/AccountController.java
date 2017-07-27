package com.mindtree.spring.cloud.account.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mindtree.spring.cloud.account.entity.Account;
import com.mindtree.spring.cloud.account.repository.AccountRepository;


@RestController
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;
	
	@RequestMapping(value="/account/{accountNumber}", method=RequestMethod.GET)
	public ResponseEntity<Account> findById(@PathVariable("accountNumber") Long accountNumber){
		
		Account account = accountRepository.findByAccountId(accountNumber);
		
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	
	@RequestMapping(value="/account/range/{balanceRange}", method=RequestMethod.GET)
	public ResponseEntity<List<Account>> findByBalanceRange(@PathVariable("balanceRange") BigDecimal balanceRange){
		
		List<Account> accounts = accountRepository.findByBalanceGreaterThan(balanceRange);
		
		return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
	}
	
	@RequestMapping(value="/account/type/{type}", method=RequestMethod.GET)
	public ResponseEntity<List<Account>> findByAccountType(@PathVariable("type") String type){
		
		List<Account> accounts = accountRepository.findByAccountType(type);
		
		return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
	}

	public AccountRepository getAccountRepository() {
		return accountRepository;
	}
	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
}
