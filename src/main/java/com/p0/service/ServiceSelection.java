package com.p0.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.p0.accountRepository.AccountRepository;
import com.p0.accountRepository.AccountRepositoryImpl;
import com.p0.ui.ScreenPrint;

public class ServiceSelection {
	
	
public void serviceSelction(String username) throws SQLException {
	
		
		ScreenPrint.printSeriveSelction();
		Scanner scanner = new Scanner(System.in);
		
		boolean userInterested = true;
		while (userInterested) {
			int userSelction = scanner.nextInt();
			switch (userSelction) {

			case 1: 
				
				JewelerShop.shopMainMenu(username);
				break;
				
			case 2:
				AccountManagement.accountDetailsManagement(username);
				break;
			default:
				ScreenPrint.printInvalidEntry();
				break;
			}

			

		}
		
	}
		
		
	}
	


