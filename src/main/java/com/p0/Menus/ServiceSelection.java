package com.p0.Menus;

import java.sql.SQLException;
import java.util.Scanner;

import com.p0.ui.ScreenPrint;

public class ServiceSelection {
	
	
public void serviceSelction(String username) throws SQLException {
	
		Scanner scanner = new Scanner(System.in);
		ScreenPrint.printSeriveSelction();
		AccountManagement accountManagement = new AccountManagement();
		
		boolean userInterested = true;
		while (userInterested) {
			int userSelction = scanner.nextInt();
			switch (userSelction) {

			case 1: 
				
				JewelerShop.shopMainMenu(username );
				break;
				
			case 2:
				accountManagement.accountDetailsManagement(username);
				break;
			default:
				ScreenPrint.printInvalidEntry();
				break;
			}

			

		}
		
	}
		
		
	}
	


