package com.p0.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.p0.ui.ScreenPrint;
import com.p0.util.Connector;
import com.p0.util.Validation;

public class EditAccount {
	private static final Logger logger = LoggerFactory.getLogger(AccountManagement.class);
	public static Scanner scanner = new Scanner(System.in);
	public static Validation val = new Validation();

	public void accountEditMenu(String userToView, String username) throws SQLException {

		boolean isUserInterested = true;
		while (isUserInterested) {
			ScreenPrint.printSingleAccountEdit(userToView);
			int userChoice = scanner.nextInt();
			switch (userChoice) {
			case 1:System.out.println("Enter the new username for this account");
			updateUsername(userToView, scanner.next());
			break;
			case 2:System.out.println("Enter the new password for this account");
			updatePassword(userToView, scanner.next());
			break;
			case 3:System.out.println("Enter the new balance for this account");
			updateBalance(userToView, scanner.nextDouble());
			break;
			case 4:System.out.println("Is this account an employee account?");
			updateEmployment(userToView, val.confirmation());
			break;
			case 5:
				if(username.equals(userToView)) {
					System.out.println("You cannot alter your own admin status.");
					break;
				}
				System.out.println("Is this account an Administrator account?");
			updateAdmin(userToView, val.confirmation());
			break;
			case 6:System.out.println("Which account would you like to add as a secondary user");
			updateSecondaryUser(userToView, scanner.next());
			break;
			case 7: 
				isUserInterested = false;
				break;
				
			default:
				ScreenPrint.printInvalidEntry();
				break;
			}

		}
	}

	public void updateUsername(String username, String newUsername) throws SQLException {
		String SQL = "update accounts set accounts_username = ? where accounts_username = ?";
		Connection conn = Connector.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SQL);
		conn = Connector.getConnection();
		stmt = conn.prepareStatement(SQL);
		stmt.setString(1, newUsername);
		stmt.setString(2, username);
		stmt.execute();
		logger.info("Account with the username:" + " " + username + " " + "was changed to" + " " + newUsername); 
	}

	public void updatePassword(String username, String newPassword) throws SQLException {
		String SQL = "update accounts set accounts_password = ? where accounts_username = ?";
		Connection conn = Connector.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SQL);
		conn = Connector.getConnection();
		stmt = conn.prepareStatement(SQL);
		stmt.setString(1, newPassword);
		stmt.setString(2, username);
		stmt.execute();
		logger.info("Account with the username:" + " " + username + "had its password changed.");
	}

	public void updateBalance(String username, Double newAmount) throws SQLException {
		if(val.isNegative(newAmount)) {
			ScreenPrint.printNoNegatives(username);
		return;
		}
		String SQL = "update accounts set accounts_accountbalance = ? where accounts_username = ?";
		Connection conn = Connector.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SQL);
		conn = Connector.getConnection();
		stmt = conn.prepareStatement(SQL);
		stmt.setDouble(1, newAmount);
		stmt.setString(2, username);
		stmt.execute();
		logger.info("Account with the username:" + " " + username + " " + " had it's account balance changed to" + " " + newAmount);
	}

	public void updateEmployment(String username, Boolean newBool) throws SQLException {
		String SQL = "update accounts set accounts_employee = ? where accounts_username = ?";
		Connection conn = Connector.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SQL);
		conn = Connector.getConnection();
		stmt = conn.prepareStatement(SQL);
		stmt.setBoolean(1, newBool);
		stmt.setString(2, username);
		stmt.execute();
		logger.info("Account with the username:" + " " + username + " " + "had its employment status changed to" + " " + newBool);
	}

	public void updateAdmin(String username, Boolean newBool) throws SQLException {
		String SQL = "update accounts set accounts_administrator = ? where accounts_username = ?";
		Connection conn = Connector.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SQL);
		conn = Connector.getConnection();
		stmt = conn.prepareStatement(SQL);
		stmt.setBoolean(1, newBool);
		stmt.setString(2, username);
		stmt.execute();
		logger.warn("Account with the username:" + " " + username + " " + "had its admin status changed to" + " " + newBool);
	}
	public void updateSecondaryUser(String username, String newSecondaryAccount) throws SQLException {
		String SQL = "update accounts set accounts_secondaryaccount = ? where accounts_username = ?";
		Connection conn = Connector.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SQL);
		conn = Connector.getConnection();
		stmt = conn.prepareStatement(SQL);
		stmt.setString(1, newSecondaryAccount);
		stmt.setString(2, username);
		stmt.execute();
		logger.info("Account with the username:" + " " + username + " " + "had its secondary user changed to" + " " + newSecondaryAccount);

	}
}
