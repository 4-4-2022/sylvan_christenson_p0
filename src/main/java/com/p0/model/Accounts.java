package com.p0.model;

public class Accounts {
	private double accountBalance = 0;
	private String username;
	private String password;
	private boolean isEmployee;
	private boolean isAdministrator;
	private String secondaryUser;

	public Accounts() {
		super();
	}

	public Accounts(double accountBalance, String username, String password, boolean isEmployee,
			boolean isAdministrator) {
		super();
		this.accountBalance = accountBalance;
		this.username = username;
		this.password = password;
		this.isEmployee = isEmployee;
		this.isAdministrator = isAdministrator;

	}

	public Accounts(double accountBalance, String username, String password, boolean isEmployee,
			boolean isAdministrator, String secondaryUser) {
		super();
		this.accountBalance = accountBalance;
		this.username = username;
		this.password = password;
		this.isEmployee = isEmployee;
		this.isAdministrator = isAdministrator;
		this.secondaryUser = secondaryUser;
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

	public Accounts(double accountBalance, String username, String password, String secondaryUser) {
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
	
	public String toStringNoPass() {
		return "Account Balance:" + " " + accountBalance + "\n" +  "Username:" + " " + username + "\n" + "Is an Employee:" + " " + isEmployee
				+ "\n" + "Is an Administrator:" + " " + isAdministrator + ""
						+ "\n" + "Secondary User:" + " " + secondaryUser;
	}

	@Override
	public String toString() {
		return "Accounts [accountBalance=" + accountBalance + ", username=" + username + ", password=" + password
				+ ", isEmployee=" + isEmployee + ", isAdministrator=" + isAdministrator + ", secondaryUser="
				+ secondaryUser + "]";
	}

	public String getSecondaryUser() {
		return secondaryUser;
	}

	public void setSecondaryUser(String secondaryUser) {
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
