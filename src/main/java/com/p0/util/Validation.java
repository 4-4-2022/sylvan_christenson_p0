package com.p0.util;

import java.sql.SQLException;
import java.util.Scanner;

import org.postgresql.util.PSQLException;

import com.p0.ui.ScreenPrint;

public class Validation {
	SQL SQL = new SQL();
	public static Scanner scanner = new Scanner(System.in);
	
	
	
	
	public String takeUserInput() {
		String input = scanner.nextLine();
		return input;
	}
	
	
	
	
	
	
	public int getConfirmation() {
		System.out.println("1) Yes               2)No");
		boolean userInterested = true;
		while (userInterested) {
			int userSelction = scanner.nextInt();
			switch (userSelction) {

			case 1:
				userInterested = false;
				return 1;

			case 2:
				userInterested = false;
				return 2;
			default:
				ScreenPrint.printInvalidEntry();
				break;
			}

		}
		return 0;
		
	}
	
	public boolean confirmation(int getConfirmation) {
		
		if(getConfirmation == 1) 
		{
		return true;
		}
		else {
			return false;
		}
	}
	
	
	
	public boolean accountExists(String username) throws SQLException {
	
		try {
			return (username.equals(SQL.executeQuerySQL(SQL.getAccountNameSQL(username)).getString(1)));
		} catch (PSQLException e) {
			return false;
		}
		
		}
	
		
		
	
	public void exitProgram() {
		
		System.out
		.println("You are attempting to exit the program completely. Would you like to continue?");
if (confirmation(getConfirmation())) {
	System.out.println("Farewell. Program Exited");
	System.exit(0);
} else {
	return;
}
		
	}
	

}
