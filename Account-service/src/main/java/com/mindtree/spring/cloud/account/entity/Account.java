package com.mindtree.spring.cloud.account.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="account")
@Table(name="ACCOUNT")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ACCOUNTID")
	private Long accountId;
	@Column(name="ACCOUNTTYPE")
	private String accountType;
	@Column(name="NAME")
	private String name;
	@Column(name="BALANCE")
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
	
	
}

