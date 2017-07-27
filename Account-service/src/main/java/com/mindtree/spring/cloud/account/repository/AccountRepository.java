package com.mindtree.spring.cloud.account.repository;

import org.springframework.data.repository.Repository;
import com.mindtree.spring.cloud.account.entity.Account;
import java.lang.Long;
import java.math.BigDecimal;
import java.util.List;

/**
 * Repository for Account data implemented using Spring Data JPA.
 * 
 * @author Chandan Behera
 */

public interface AccountRepository extends Repository<Account, Long> {
	
	public Account findByAccountId(Long accountId);
	
	public List<Account> findByAccountType(String accountType);
	
	public List<Account> findByBalanceGreaterThan(BigDecimal range);
}
