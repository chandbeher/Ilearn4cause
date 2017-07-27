package com.mindtree.spring.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.mindtree.spring.cloud.customer.config.CustomerConfiguration;


/**
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 * <p>
 * Note that the configuration for this application is imported from
 * {@link AccountsConfiguration}. This is a deliberate separation of concerns.
 * 
 * @author Chandan Behera
 */

@EnableDiscoveryClient
@SpringBootApplication
@Import(CustomerConfiguration.class)
public class CustomerService {
	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
    public static void main(String[] args) {
    	// Tell server to look for account-server.properties or  accounts-server.yml
    	System.setProperty("spring.config.name","customer-server");
        SpringApplication.run(CustomerService.class, args);
    }
}

