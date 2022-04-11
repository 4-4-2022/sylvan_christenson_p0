package com.p0.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.p0.accountRepository.AccountRepository;
import com.p0.model.Accounts;
import com.p0.ui.ScreenPrint;
import com.p0.ui.Storefront;
import com.p0.accountRepository;
public class AccountManagement {
	private static final Logger logger = LoggerFactory.getLogger(AccountManagement.class);
	
	static AccountRepository accountRepo = new AccountRepository();

	public static void accountDetailsManagement(String usernameInput) {
		Scanner scanner = new Scanner(System.in);
		String username = usernameInput;
		ScreenPrint.printAccountManagement();
		int userSelection = scanner.nextInt();
		switch (userSelection) {
		case 1:
			accountRepo.createAccount();
		case 2:
			System.out.println("Please enter an amount you wish to withdraw.");
			double withdrawAmount = scanner.nextDouble();
			accountRepo.withdraw(username, withdrawAmount);
			accountDetailsManagement(usernameInput);
		case 3:
			System.out.println("Please enter an amount you wish to deposit.");
			double depositAmount = scanner.nextDouble();
			accountRepo.deposit(username, depositAmount);
			accountDetailsManagement(usernameInput);
		case 4:
			
			break;
		case 5:
			System.out.println(accountRepo.getAccountBalance(username));
			accountDetailsManagement(usernameInput);
		case 6: 
			ScreenPrint.printLogIn();
			Storefront.storeFront();
		default:
			System.out.println("Invalid Entry");
			break;
		}
		scanner.close();
		
	}


	
		
	
		

	}


