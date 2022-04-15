package com.p0.accountRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.p0.driver.Driver;
import com.p0.model.Accounts;
import com.p0.service.AccountManagement;
import com.p0.util.Connector;

public class AccountRepositoryImpl implements AccountRepository {
	private static AccountRepositoryImpl accountRepo;

	final static Logger logger = LoggerFactory.getLogger(Driver.class);

	private static final ResultSet String = null;

	public void getAccountBalance(String username) {
		for (Accounts account : findAllAccounts()) {
			if (account.getUsername().equalsIgnoreCase(username)) {
				double currentBalance = account.getAccountBalance(username);
				System.out.println("Your current balance is:" + " " + currentBalance);
			} 
		}

	}

	public void withdraw(String username, double withdrawAmount) {
		for (Accounts account : findAllAccounts()) {
			if (account.getUsername().equalsIgnoreCase(username)) {
				double previousBalance = account.getAccountBalance(username);
				double newBalance = (previousBalance - withdrawAmount);
				Connection conn = null;
				PreparedStatement stmt = null;
				final String SQL = "update accounts set accounts_accountbalance = ? where accounts_username = ?";

				try {

					conn = Connector.getConnection();
					stmt = conn.prepareStatement(SQL);
					stmt.setDouble(1, newBalance);
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

			}
		}
	}

	public void deposit(String username, double depositAmount) {
		for (Accounts account : findAllAccounts()) {
			if (account.getUsername().equalsIgnoreCase(username)) {
				double previousBalance = account.getAccountBalance(username);

			} else
				break;
		}

	}

	public Accounts checkForAccount(String username) {
		for (Accounts accounts : findAllAccounts()) {
			if (accounts.getUsername().equalsIgnoreCase(username))

				return accounts;

		}
		return null;

	}

	public boolean signIn(String username, String password) {
		for (Accounts accounts : findAllAccounts()) {
			if (accounts.getUsername().equals(username) && accounts.getPassword().equals(password))

				return true;

		}
		return false;

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
				accountList.add(new Accounts(set.getDouble(1), set.getString(2), set.getString(3)));
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

	public Accounts getNewAccountInfo(String usernameProvided) {
		Scanner scanner = new Scanner(System.in);
		Accounts newAccount = new Accounts();
		System.out.println("Enter an amount you wish to deposit initially to this new account account.");
		newAccount.setAccountBalance(scanner.nextDouble());
		System.out.println("New account username = " + usernameProvided);
		newAccount.setUsername(usernameProvided);
		System.out.println("Enter desired password");
		newAccount.setPassword(scanner.next());
		System.out.println("Your new account details are " + newAccount);
		return newAccount;
	}

	public Accounts getNewAccountInfo() {
		Scanner scanner = new Scanner(System.in);
		Accounts newAccount = new Accounts();
		System.out.println("Enter an amount you wish to deposit initially to this new account account.");
		newAccount.setAccountBalance(scanner.nextDouble());
		System.out.println("Enter new account username");
		newAccount.setUsername(scanner.next());
		System.out.println("Enter desired password");
		newAccount.setPassword(scanner.next());
		System.out.println("Your new account details are " + newAccount);
		return newAccount;
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
			} catch (SQLException e) {

			}
		}

	}

	public AccountRepositoryImpl() {
		super();

	}

	@Override
	public void update(Accounts account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Accounts account) {
		// TODO Auto-generated method stub

	}

}
