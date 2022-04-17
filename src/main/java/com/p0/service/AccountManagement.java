package com.p0.service;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.p0.accountRepository.AccountRepositoryImpl;
import com.p0.ui.ScreenPrint;
import com.p0.util.SQL;
import com.p0.util.Validation;

public class AccountManagement {
	private static final Logger logger = LoggerFactory.getLogger(AccountManagement.class);

	static AccountRepositoryImpl accountRepo = new AccountRepositoryImpl();
	ServiceSelection serviceSelection = new ServiceSelection();

	public static void accountDetailsManagement(String usernameInput) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		String username = usernameInput;
		Validation validation = new Validation();

		boolean isUserInterested = true;

		try {

			while (isUserInterested) {
				SQL SQL = new SQL();
				ScreenPrint.printAccountManagement(username);
				int userSelection = scanner.nextInt();
				switch (userSelection) {

				case 1:
					accountRepo.save(accountRepo.getNewAccountInfo());
					break;
				case 2:
					System.out.println("Please enter an amount you wish to withdraw.");
					double withdrawAmount = scanner.nextDouble();
					if (validation.isNegative(withdrawAmount)) {
						System.out.println("No negative values allowed.");
						break;
					}
					accountRepo.withdraw(username, withdrawAmount);
					accountDetailsManagement(usernameInput);
				case 3:
					System.out.println("Please enter an amount you wish to deposit.");
					double depositAmount = scanner.nextDouble();
					if (validation.isNegative(depositAmount)) {
						System.out.println("No negative values allowed.");
						break;
					}
					accountRepo.deposit(username, depositAmount);
					accountDetailsManagement(usernameInput);
				case 4:
					System.out.println("Please enter the username of the account you wish to transfer funds to");
					String recveivingUser = scanner.next();
					
					if (SQL.executeQuerySQL(SQL.getAccountStatusSQL(recveivingUser)).getString(1) == null) {

						while (isUserInterested) {
							ScreenPrint.printNoTransferUserFound(recveivingUser);
							int userChoice = scanner.nextInt();
							switch (userChoice) {
							case 1:
								break;
							case 2:
								accountRepo.save(accountRepo.getNewAccountInfo());

								isUserInterested = false;
								break;
							case 3:
								ServiceSelection serviceSelection = new ServiceSelection();
								serviceSelection.serviceSelction(username);
								break;
							default:
								ScreenPrint.printInvalidEntry();
								break;

							}

						}
						System.out.println(
								"Please enter an amount you wish to transfer to the account:" + " " + recveivingUser);
						double transferAmount = scanner.nextDouble();
						if (validation.isNegative(transferAmount)) {
							System.out.println("No negative values allowed.");
							break;
						}
						accountRepo.transfer(username, recveivingUser, transferAmount);
						break;

					} else {
						System.out.println(
								"Please enter an amount you wish to transfer to the account:" + " " + recveivingUser);
						double transferAmount = scanner.nextDouble();
						if (validation.isNegative(transferAmount)) {
							System.out.println("No negative values allowed.");
							break;
						}
						accountRepo.transfer(username, recveivingUser, transferAmount);
						

					}
					
					ScreenPrint.printTransactionSuccessful();
					break;
				case 5:
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
								logger.info(secondaryUser + " was added as a secondary user to" + " " + username);
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
					ScreenPrint.printTransactionSuccessful();
					break;
				case 8:
					System.out
							.println("You are attempting to exit the program completely. Would you like to continue?");
					if (EmployeeMenu.confirmation()) {
						System.out.println("Farewell. Program Exited");
						System.exit(0);
					} else {
						break;
					}

				default:
					System.out.println("Invalid Entry");
					break;
				}
			}
		} catch (InputMismatchException e) {
			ScreenPrint.printInvalidEntry();
		}

	}
}
