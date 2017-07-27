package com.mindtree.spring.boot.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
	/*@Autowired
	DataSource dataSource;

	@Autowired
	public initialize(AuthenticationManagerBuilder builder, DataSource dataSource) {
	    builder.jdbcAuthentication().dataSource(dataSource).withUser("dave")
	      .password("secret").roles("USER");
	  }


	 @Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		 builder.jdbcAuthentication().dataSource(dataSource).withUser("dave")
	      .password("secret").roles("USER");
	}*/
}
