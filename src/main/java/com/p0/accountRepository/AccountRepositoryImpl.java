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
import com.p0.service.EmployeeMenu;
import com.p0.ui.ScreenPrint;
import com.p0.util.Connector;
import com.p0.util.SQL;

public class AccountRepositoryImpl implements AccountRepository {
	// private static AccountRepositoryImpl accountRepo;

	final static Logger logger = LoggerFactory.getLogger(Driver.class);
	SQL SQL = new SQL();

	private static final ResultSet String = null;

	public void getAccountBalance(String username) {
		for (Accounts account : findAllAccounts()) {
			if (account.getUsername().equalsIgnoreCase(username)) {
				double currentBalance = account.getAccountBalance(username);
				System.out.println("Your current balance is:" + " " + currentBalance);
			}
		}

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

			double previousBalanceReceivingUser = SQL.executeQuerySQL(SQL.getAccountBalanceSQL(receivingUser)).getDouble(1);
			double newBalanceReceivingUser = (previousBalanceReceivingUser + withdrawAmount);
			SQL.updateAccountBalanceSQL(receivingUser, newBalanceReceivingUser);
			logger.info("A successful transfer was completed from" + " " + username + " " + "to" + " " + receivingUser + " " + "for" + " " + withdrawAmount);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

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
				}
			}
		}
	}

	public void deposit(String username, double depositAmount) throws SQLException {
		for (Accounts account : findAllAccounts()) {
			if (account.getUsername().equalsIgnoreCase(username)) {
				double previousBalance = account.getAccountBalance(username);
				double newBalance = (previousBalance + depositAmount);
				if(newBalance < 0) {
					System.out.println("Insufficient funds");
					break;
				}
				else {
					SQL.updateAccountBalanceSQL(username, depositAmount);
					
				}

				
					}
				}

			}
	

	public Accounts checkForAccountSQL(String username) {
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

	public boolean signIn(String username, String password) throws SQLException {
		boolean validated = false;
		for (Accounts accounts : findAllAccounts()) {

			if (accounts.getUsername().equals(username) && accounts.getPassword().equals(password)) {

				if (accounts.isAdministrator()) {
					EmployeeMenu.administratorMenu(username);
				}

				else if (accounts.isEmployee()) {
					ScreenPrint.printContinueAsEmployee(username);
				} else {
					validated = true;
				}
			} else {
				validated = false;
			}
		}
		return validated;

	}

	public void deleteAccount(String accountToDelete) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "delete from accounts where accounts_username = ?;";

		try {

			conn = Connector.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, accountToDelete);
			set = stmt.executeQuery();
			set.next();

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
