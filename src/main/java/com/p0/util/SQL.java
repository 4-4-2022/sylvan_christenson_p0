package com.p0.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQL {
	

	public ResultSet executeQuerySQL(PreparedStatement stmt) {
		Connection conn = null;
		ResultSet set = null;
		try {
			conn = Connector.getConnection();
			set = stmt.executeQuery();
			set.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			conn.close();}
			catch(SQLException d) {}
		}
		return set;

	}

	public void updateAccountBalanceSQL(String username, double newAmount) throws SQLException {
		String SQL = "update accounts set accounts_accountbalance = ? where accounts_username = ?";
		Connection conn = Connector.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SQL);
		conn = Connector.getConnection();
		stmt = conn.prepareStatement(SQL);
		stmt.setDouble(1, newAmount);
		stmt.setString(2, username);
		stmt.execute();
	}

	public PreparedStatement getAccountBalanceSQL(String username) throws SQLException {
		String SQL = "select accounts_accountbalance from accounts where accounts_username = ?";
		Connection conn = Connector.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SQL);
		stmt.setString(1, username);

		return stmt;

	}
	public PreparedStatement getAccountStatusSQL(String username) throws SQLException {
		String SQL = "select * from accounts where accounts_username = ?";
		Connection conn = Connector.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SQL);
		stmt.setString(1, username);
		return stmt;

	}
	
	public PreparedStatement getAccountNameSQL(String username) throws SQLException {
		String SQL = "select accounts_username from accounts where accounts_username = ?";
		Connection conn = Connector.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SQL);
		stmt.setString(1, username);

		return stmt;

	}
	}





