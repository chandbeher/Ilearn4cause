package com.mindtree.spring.cloud.service;


import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.mindtree.spring.cloud.customer.vo.Account;



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
public class APIUtilService {

	public static final String ACCOUNTS_SERVICE_URL = "http://ACCOUNT-SERVICE";
	public static final String CUSTOMER_SERVICE_URL = "http://CUSTOMER-SERVICE";
	
	@Autowired
	private RestTemplate restTemplate;
	protected Logger logger = Logger.getLogger(APIUtilService.class.getName());
	
	public Account findByNumber(String accountNumber) {

		logger.info("findByNumber() invoked: for " + accountNumber);
		Account account =  restTemplate.getForObject(ACCOUNTS_SERVICE_URL + "/account/{number}",
																		Account.class, accountNumber);
		logger.info(" Account details : " + account);
		return account;
	} 
	
	public List<Account> byOwnerContains(String name) {
		logger.info("byOwnerContains() invoked:  for " + name);
		Account[] accounts = null;

		try {
			accounts = restTemplate.getForObject(ACCOUNTS_SERVICE_URL
									+ "/accounts/owner/{name}", Account[].class, name);
		} catch (HttpClientErrorException e) { // 404
			// Nothing found
		}

		if (accounts == null || accounts.length == 0)
			return null;
		else
			return Arrays.asList(accounts);
	}

	
}

