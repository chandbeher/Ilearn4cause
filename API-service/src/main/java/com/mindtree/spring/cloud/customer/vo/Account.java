package com.mindtree.spring.cloud.customer.vo;

import java.io.Serializable;
import java.math.BigDecimal;


public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long accountId;
	private String accountType;
	private String name;
	private BigDecimal balance;


	public Account() {
	}
	public Account(Long accountId, String accountType, String name, BigDecimal balance) {
		this.accountId = accountId;
		this.accountType = accountType;
		this.name = name;
		this.balance = balance;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountType=" + accountType + ", name=" + name + ", balance="
				+ balance + "]";
	}
	
	
}

