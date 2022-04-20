package com.p0.accountRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.ServiceConfigurationError;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.p0.Menus.AccountManagement;
import com.p0.Menus.EmployeeMenu;
import com.p0.Menus.ServiceSelection;
import com.p0.driver.Driver;
import com.p0.model.Accounts;
import com.p0.service.AccountDetailsManipulation;
import com.p0.ui.ScreenPrint;
import com.p0.util.Connector;
import com.p0.util.SQL;
import com.p0.util.Validation;

public class AccountRepositoryImpl {
	// private static AccountRepositoryImpl accountRepo;

	final static Logger logger = LoggerFactory.getLogger(Driver.class);
	SQL SQL = new SQL();
	Validation validation = new Validation();

	public Scanner scanner = new Scanner(System.in);
	public AccountManagement accountManagement = new AccountManagement();

	public void printAccountList() {

		for (Accounts account : findAllAccounts()) {
			System.out.println(account.toStringNoPass());
			System.out.println("-----------------------");

		}
		System.out.println("List complete.");

	}

	public double getAccountBalance(String username) {
		for (Accounts account : findAllAccounts()) {
			if (account.getUsername().equals(username)) {
				double currentBalance = account.getAccountBalance(username);
				return currentBalance;
			}
		}
		return 0;

	}

	public void transferFunds(String usernameInput) throws SQLException {

		System.out.println("Please enter the username of the account you wish to transfer funds to");
		String recveivingUser = scanner.next();
		if (validation.accountExists(recveivingUser)) {
			System.out.println("Please enter an amount you wish to transfer to the account:" + " " + recveivingUser);
			double transferAmount = scanner.nextDouble();
			if (transferAmount < 0) {
				logger.info(usernameInput + " " + "entered a negative value when attempting to transfer funds to" + " "
						+ recveivingUser);
				System.out.println("No negative values allowed.");
				return;
			}
			transfer(usernameInput, recveivingUser, transferAmount);

		} else {
			boolean isUserInterested = true;
			while (isUserInterested) {
				ScreenPrint.printNoTransferUserFound(recveivingUser);
				int userChoice = scanner.nextInt();
				switch (userChoice) {
				case 1:
					isUserInterested = false;
					break;
				case 2:
					createAccount();
					isUserInterested = false;
					break;
				case 3:
					ServiceSelection serviceSelection = new ServiceSelection();
					serviceSelection.serviceSelction(usernameInput);
					break;
				default:
					ScreenPrint.printInvalidEntry();
					break;
				}

			}
			System.out.println("Please enter an amount you wish to transfer to the account:" + " " + recveivingUser);
			double transferAmount = scanner.nextDouble();
			if (transferAmount < 0) {
				System.out.println("No negative values allowed.");
				return;
			}
			transfer(usernameInput, recveivingUser, transferAmount);
			logger.info(usernameInput + " " + "transfered" + transferAmount + " " + " to" + " " + recveivingUser);
			return;

		}
		return;
	}

	public void transfer(String username, String receivingUser, double withdrawAmount) throws SQLException {

		try {

			double previousBalance = SQL.executeQuerySQL(SQL.getAccountBalanceSQL(username)).getDouble(1);
			double newBalance = (previousBalance - withdrawAmount);
			if (newBalance < 0) {
				System.out.println("Insufficient funds");
				return;
			} else {

				SQL.updateAccountBalanceSQL(username, newBalance);
			}

			double previousBalanceReceivingUser = SQL.executeQuerySQL(SQL.getAccountBalanceSQL(receivingUser))
					.getDouble(1);
			double newBalanceReceivingUser = (previousBalanceReceivingUser + withdrawAmount);
			SQL.updateAccountBalanceSQL(receivingUser, newBalanceReceivingUser);
			ScreenPrint.printTransactionSuccessful();
			logger.info(username + " " + "transfered" + withdrawAmount + " " + " to" + " " + receivingUser);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void withdrawFunds(String usernameInput) throws SQLException {

		System.out.println("Please enter an amount you wish to withdraw.");
		double withdrawAmount = scanner.nextDouble();
		if (withdrawAmount < 0) {
			System.out.println("No negative values allowed.");
			return;
		}
		withdraw(usernameInput, withdrawAmount);
		accountManagement.accountDetailsManagement(usernameInput);

	}

	public void withdraw(String username, double withdrawAmount) throws SQLException {
		for (Accounts account : findAllAccounts()) {
			if (account.getUsername().equals(username)) {
				double previousBalance = account.getAccountBalance(username);
				double newBalance = (previousBalance - withdrawAmount);
				if (newBalance < 0) {
					System.out.println("Insufficient funds");
					break;
				} else {
					SQL.updateAccountBalanceSQL(username, newBalance);
					logger.info("A withdraw was made from the account" + " " + username + " " + " for the amount" + " "
							+ withdrawAmount + ".");
				}
			}
		}
	}

	public void depositFunds(String usernameInput) throws SQLException {

		System.out.println("Please enter an amount you wish to deposit.");
		double depositAmount = scanner.nextDouble();
		if (depositAmount < 0) {
			System.out.println("No negative values allowed.");
			return;
		}
		deposit(usernameInput, depositAmount);
		accountManagement.accountDetailsManagement(usernameInput);

	}

	public void deposit(String username, double depositAmount) throws SQLException {
		for (Accounts account : findAllAccounts()) {
			if (account.getUsername().equals(username)) {
				double previousBalance = account.getAccountBalance(username);
				double newBalance = (previousBalance + depositAmount);
				SQL.updateAccountBalanceSQL(username, newBalance);
				logger.info(username + " " + "deposited" + depositAmount + " " + " into their account");

			}

		}
	}

	public Accounts getAccountSQL(String username) {
		Accounts newAccount = new Accounts();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from accounts where accounts_username = ?;";

		try {

			conn = Connector.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, username);
			set = stmt.executeQuery();
			while (set.next()) {

				newAccount.setAccountBalance(set.getDouble(1));
				newAccount.setUsername(set.getString(2));
				newAccount.setPassword(set.getString(3));
				newAccount.setEmployee(set.getBoolean(4));
				newAccount.setAdministrator(set.getBoolean(5));
				newAccount.setSecondaryUser(set.getString(6));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return newAccount;

	}

	public Accounts checkForAccount(String username) {
		for (Accounts accounts : findAllAccounts()) {
			if (accounts.getUsername().equals(username))

				return accounts;

		}
		return null;

	}

	public void signIn() throws SQLException {

		System.out.println("Enter Username");
		String username = scanner.nextLine();
		if (validation.accountExists(username) == false) {
			System.out.println("No account found.");
			return;
		}

		System.out.println("Enter Password");
		String password = scanner.nextLine();
		if (authenticate(username, password)) {
			accountManagement.accountDetailsManagement(username);
		} else {
			System.out.println("No account found.");
		}
		return;

	}

	public boolean authenticate(String username, String password) throws SQLException {
		boolean validated = false;
		for (Accounts accounts : findAllAccounts()) {

			if (accounts.getUsername().equals(username) && accounts.getPassword().equals(password)) {
				validated = true;

				if (accounts.isAdministrator()) {
					logger.info(username + " " + "has logged in successfully as an administrator.");
					EmployeeMenu.administratorMenu(username);
				}

				else if (accounts.isEmployee()) {
					logger.info(username + " " + "has logged in successfully as an employee.");
					EmployeeMenu.employeeMenu(username);
				} else {
					return validated;
				
				}
			} else {
				validated = false;
			}
		}
		if (validated) {
			logger.info(username + " " + "has logged in successfully.");
		} else {
			logger.info(username + " " + "has failed a log in attempt.");
		}
		return validated;

	}

	public void deleteAccount(String accountToDelete, String username) throws SQLException {
		if (accountToDelete.equals(username)) {
			System.out.println("You cannot delete your own account");
			return;
		}
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "delete from accounts where accounts_username = ?;";

		try {

			conn = Connector.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, accountToDelete);
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		logger.info("The account:" + " " + accountToDelete + " " + " has been deleted by" + " " + username + ".");
	}

	public void secondaryUser(String usernameInput) {

		try {
			System.out.println("Please enter the username of the account you wish to add as a secondary user");
			String secondaryUser = scanner.next();
			if (checkForSecondaryUser(usernameInput) == null) {

				if (checkForAccount(secondaryUser) == null) {
					System.out.println("No account was found... creating a new account.");

					createAccount();
					setSecondaryUser(usernameInput, secondaryUser);
					logger.info(secondaryUser + " was added as a secondary user to" + " " + usernameInput);
				} else {
					setSecondaryUser(usernameInput, secondaryUser);

				}

			} else {
				System.out.println("Account already has a secondary user");

			}

		}

		catch (SQLException e) {

			e.printStackTrace();
		}
		return;

	}

	public String checkForSecondaryUser(String username) throws SQLException {
		String secondaryUser = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select accounts_secondaryaccount from accounts a where accounts_username = ?;";

		try {

			conn = Connector.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, username);
			set = stmt.executeQuery();
			set.next();
			secondaryUser = set.getString(1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return secondaryUser;

	}

	public void setSecondaryUser(String username, String secondaryUserAccount) throws SQLException {

		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "update accounts set accounts_secondaryaccount = ? where accounts_username = ?";

		try {

			conn = Connector.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, secondaryUserAccount);
			stmt.setString(2, username);
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		logger.info(secondaryUserAccount + " " + "is now a secondary user of the account:" + " " + username + ".");
	}

	public List<Accounts> findAllAccounts() {

		List<Accounts> accountList = new ArrayList<Accounts>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from accounts";

		try {
			conn = Connector.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			while (set.next()) {
				accountList.add(new Accounts(set.getDouble(1), set.getString(2), set.getString(3), set.getBoolean(4),
						set.getBoolean(5), set.getString(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return accountList;
	}

	public Accounts getNewAccountInfo(String newUsername, String newPassword, Double initialDeposit)
			throws SQLException {

		Accounts newAccount = new Accounts();
		newAccount.setAccountBalance(initialDeposit);
		newAccount.setPassword(newPassword);
		newAccount.setUsername(newUsername);
		return newAccount;

	}

	public void createAccount() throws SQLException {

		System.out.println("Enter Username");
		String newUsername = scanner.nextLine();
		if (validation.accountExists(newUsername)) {
			System.out.println("Account already exists. Account was not created");
			scanner.nextLine();
			return;
		}
		System.out.println("Enter Password");
		String newPassword = scanner.nextLine();
		System.out.println("Enter Intitial deposit");
		Double initialDeposit = scanner.nextDouble();
		if (initialDeposit < 0) {
			return;
		}
		logger.info("A new account called" + " " + newUsername + " " + "has been created.");
		save(getNewAccountInfo(newUsername, newPassword, initialDeposit));
	}

	public void save(Accounts newAccount) {

		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "insert into accounts values( ?, ?, ?, ?, ?)";

		try {
			conn = Connector.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setDouble(1, newAccount.getAccountBalance());
			stmt.setString(2, newAccount.getUsername());
			stmt.setString(3, newAccount.getPassword());
			stmt.setBoolean(4, false);
			stmt.setBoolean(5, false);
			stmt.execute();

		} catch (SQLException e) {

		} finally {
			try {
				conn.close();
				stmt.close();
				System.out.println("Account Created Successfully");
			} catch (SQLException e) {

			}
		}

	}

}
