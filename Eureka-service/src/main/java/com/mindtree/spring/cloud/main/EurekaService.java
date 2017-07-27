package com.mindtree.spring.cloud.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * All you need to run a Eureka registration server.
 * @author Chandan Behera
 *
 */

@EnableEurekaServer
@SpringBootApplication
public class EurekaService {

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
    public static void main(String[] args) {
    	
    	// Tell server to look for registration.properties or registration.yml
    	System.setProperty("spring.config.name", "registration-server");
    			
        SpringApplication.run(EurekaService.class, args);
    }
}

