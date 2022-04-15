package com.p0.service;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.p0.accountRepository.AccountRepositoryImpl;
import com.p0.ui.ScreenPrint;
import com.p0.ui.Storefront;

public class AccountManagement {
	private static final Logger logger = LoggerFactory.getLogger(AccountManagement.class);

	static AccountRepositoryImpl accountRepo = new AccountRepositoryImpl();

	public static void accountDetailsManagement(String usernameInput) {
		Scanner scanner = new Scanner(System.in);
		String username = usernameInput;
		ScreenPrint.printAccountManagement(username);
		boolean isUserInterested = true;

		try {

			while (isUserInterested) {
				int userSelection = scanner.nextInt();

				switch (userSelection) {

				case 1:
					accountRepo.save(accountRepo.getNewAccountInfo());
					ScreenPrint.printAccountManagement(username);
					break;
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
					ScreenPrint.printAccountManagement(username);
					accountRepo.getAccountBalance(username);
					break;
				case 6:
					Storefront.storeFront();
				case 7:
					try {
						System.out.println(
								"Please enter the username of the account you wish to add as a secondary user");
						String secondaryUser = scanner.next();
						if (accountRepo.checkForSecondaryUser(username) == null) {
							
							
							if (accountRepo.checkForAccount(secondaryUser) == null) {
								System.out.println("No account was found... creating a new account.");
								accountRepo.save(accountRepo.getNewAccountInfo(secondaryUser));
								accountRepo.setSecondaryUser(username, secondaryUser);
								ScreenPrint.printAccountManagement(username);
								logger.info(secondaryUser + " was added as a secondary user to"+ " " + username);
							} else {
								accountRepo.setSecondaryUser(username, secondaryUser);

							}

							
						
						} else {
							System.out.println("Account already has a secondary user");
							ScreenPrint.printAccountManagement(username);

						}
						

					}

					catch (SQLException e) {

						e.printStackTrace();
					}
					break;
				case 8:
					isUserInterested = false;
					scanner.close();
					break;

				default:
					System.out.println("Invalid Entry");
					break;
				}
			}
		} catch (InputMismatchException e) {
			System.out.println(
					"Invalid Entry: Please type only the number associated with your decision and then press enter.");
		}

	}
}
