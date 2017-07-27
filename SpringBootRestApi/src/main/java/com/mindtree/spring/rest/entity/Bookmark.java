package com.mindtree.spring.rest.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bookmark {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String uri;
	private String description;
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	private Account account;
	
	

	public Bookmark() {
	}

	public Bookmark(String uri, Account account) {
		this.uri = uri;
		this.account = account;
	}
	

	public Bookmark(Account account, String uri, String description) {
		this.uri = uri;
		this.description = description;
		this.account = account;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	
	
}
