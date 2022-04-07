package com.p0.model;

public class Accounts {
	private double accountBalance = 0;
	private String username;
	private String password;
	private AccountType accountType;
	
	
	public Accounts() {
		super();
	}
	public Accounts(String username) {
		super();
	}
	
	
	
	public Accounts(double accountBalance, String username, String password) {
		super();
		this.accountBalance = accountBalance;
		this.username = username;
		this.password = password;
	}



	public Accounts(double accountBalance, String username, String password, AccountType accountType) {
		super();
		this.accountBalance = accountBalance;
		this.username = username;
		this.password = password;
		this.accountType = accountType;
	}

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

	@Override
	public String toString() {
		return "Accounts [accountBalance=" + accountBalance + ", username=" + username + ", password=" + password
				+ ", accountType=" + accountType + "]";
	}

}
