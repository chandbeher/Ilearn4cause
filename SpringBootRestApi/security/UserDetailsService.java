package com.mindtree.spring.rest.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {
	
	public UserDetails loadUserByUsername(String s)throws UsernameNotFoundException;

}
