package com.mindtree.spring.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.spring.rest.entity.Account;

public interface AccountRepository  extends JpaRepository<Account, Long>{
	
	public Optional<Account> findByUsername(String username);

}
