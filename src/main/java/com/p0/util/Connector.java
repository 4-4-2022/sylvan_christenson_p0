package com.p0.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

	public static Connection getConnection() throws SQLException {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(System.getenv("db_url"), System.getenv("db_username"),
					System.getenv("db_password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}

}
