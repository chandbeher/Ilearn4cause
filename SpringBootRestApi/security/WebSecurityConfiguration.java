package com.mindtree.spring.rest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mindtree.spring.rest.repository.AccountRepository;

public class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}
	@Bean
	public UserDetailsService userDetailsService() {
		
			return (username) -> 
							accountRepository.findByUsername(username)
							.map(a -> new User(a.username, a.password, true, true, true, true, AuthorityUtils.createAuthorityList("USER", "write")))
							.orElseThrow(
									() -> {throw new UsernameNotFoundException("User name not found : " + username);}
									);
				
								
	}
}
