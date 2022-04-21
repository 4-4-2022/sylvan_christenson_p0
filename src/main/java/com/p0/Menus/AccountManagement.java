package com.p0.Menus;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.p0.accountRepository.AccountRepositoryImpl;
import com.p0.ui.ScreenPrint;
import com.p0.util.Validation;

public class AccountManagement {
	private static final Logger logger = LoggerFactory.getLogger(AccountManagement.class);

	static AccountRepositoryImpl accountRepo = new AccountRepositoryImpl();
	ServiceSelection serviceSelection = new ServiceSelection();

	public void accountDetailsManagement(String usernameInput) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		Validation validation = new Validation();
		boolean isUserInterested = true;
		try {
			while (isUserInterested) {
				ScreenPrint.printAccountManagement(usernameInput);
				int userSelection = scanner.nextInt();
				switch (userSelection) {
				case 1:
					accountRepo.createAccount();
					break;
				case 2:
					accountRepo.withdrawFunds(usernameInput);
					break;
				case 3:
					accountRepo.depositFunds(usernameInput);
					break;
				case 4:
					accountRepo.transferFunds(usernameInput);
					break;
				case 5:
					System.out.println(accountRepo.getAccountBalance(usernameInput));
					break;
				case 6:
					Storefront.storeFront();
					break;
				case 7:
					accountRepo.secondaryUser(usernameInput);
					break;
				case 8:
					validation.exitProgram();
					break;
				case 9:
					serviceSelection.serviceSelction(usernameInput);
				default:
					System.out.println("Invalid Entry");
					break;
				}
				scanner.nextLine();
			}
		} catch (InputMismatchException e) {
			ScreenPrint.printInvalidEntry();
		}
	}
}
