package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
	private String accountNumber;
	private String name;
	
	@Id
	@GeneratedValue
	private int id;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Account(String accountNumber, int id, String name) {
		super();
		this.accountNumber = accountNumber;
		this.id = id;
		this.name = name;
	}
	public Account() {
		super();
	}
	
	
	
	
	
}	
	

	
	