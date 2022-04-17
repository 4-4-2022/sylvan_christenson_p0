package com.p0.util;

import java.sql.SQLException;
import java.util.Scanner;

import org.postgresql.util.PSQLException;

import com.p0.ui.ScreenPrint;

public class Validation {
	SQL SQL = new SQL();
	
	public boolean confirmation() {
		System.out.println("1) Yes               2)No");
		Scanner scanner = new Scanner(System.in);
		boolean confirmation = false;
		boolean userInterested = true;
		while (userInterested) {
			int userSelction = scanner.nextInt();
			switch (userSelction) {

			case 1:
				userInterested = false;
				confirmation = true;
				break;

			case 2:
				userInterested = false;
				confirmation = false;
				break;
			default:
				ScreenPrint.printInvalidEntry();
				break;
			}

		}
		return confirmation;
	}
	
	
	
	public boolean accountExists(String username) throws SQLException {
	
		try {
			return (username.equals(SQL.executeQuerySQL(SQL.getAccountNameSQL(username)).getString(1)));
		} catch (PSQLException e) {
			return false;
		}
		
		}
	
		
		
	
	public boolean isNegative(double withdrawAmount) {
		return (withdrawAmount < 0);
	}

}
