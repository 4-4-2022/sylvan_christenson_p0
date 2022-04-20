package com.p0.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.p0.Menus.AccountManagement;
import com.p0.ui.ScreenPrint;
import com.p0.util.Connector;
import com.p0.util.Validation;

public class AccountDetailsManipulation {
	
	
	private static final Logger logger = LoggerFactory.getLogger(AccountManagement.class);
	Validation val = new Validation();
	
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
		if(newAmount < 0) {
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


