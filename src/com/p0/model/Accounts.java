package com.p0.model;

import java.util.Objects;

public class Accounts {
	private double accountBalance = 0;
	private String username;
	private String password;
	private AccountType accountType;
	
	
	
	
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
		this.accountType = AccountType.Manager;
	}
	
	

}
