package com.p0.model;

public class Accounts {
	private double accountBalance = 0;
	private String username;
	private String password;
	private boolean isEmployee;
	private boolean isAdministrator;
	private SecondaryUser secondaryUser;

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
	public Accounts(double accountBalance, String username, String password, SecondaryUser secondaryUser) {
		super();
		this.accountBalance = accountBalance;
		this.username = username;
		this.password = password;
		this.secondaryUser = secondaryUser;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public double getAccountBalance(Accounts newAccounts) {
		return accountBalance;
	}

	public double getAccountBalance(String username2) {
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

	@Override
	public String toString() {
		return "Accounts [accountBalance=" + accountBalance + ", username=" + username + ", password=" + password;
	}

	public SecondaryUser getSecondaryUser() {
		return secondaryUser;
	}

	public void setSecondaryUser(SecondaryUser secondaryUser) {
		this.secondaryUser = secondaryUser;
	}

	public boolean isAdministrator() {
		return isAdministrator;
	}

	public void setAdministrator(boolean isAdministrator) {
		this.isAdministrator = isAdministrator;
	}

	public boolean isEmployee() {
		return isEmployee;
	}

	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

}
