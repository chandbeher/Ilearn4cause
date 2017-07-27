package com.mindtree.spring.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

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
public class APIService {
	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
    public static void main(String[] args) {
    	// Tell server to look for account-server.properties or  accounts-server.yml
    	System.setProperty("spring.config.name","api-server");
        SpringApplication.run(APIService.class, args);
    }
    /**
	 * A customized RestTemplate that has the ribbon load balancer build in.
	 * Note that prior to the "Brixton" 
	 * 
	 * @return
	 */
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

