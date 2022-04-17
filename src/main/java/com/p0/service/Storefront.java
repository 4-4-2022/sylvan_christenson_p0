package com.p0.service;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.p0.accountRepository.AccountRepositoryImpl;
import com.p0.ui.ScreenPrint;

public class Storefront {

	private static final Logger logger = LoggerFactory.getLogger(Storefront.class);

	public static void storeFront() throws SQLException {

		AccountRepositoryImpl accountRepo = new AccountRepositoryImpl();
		Scanner scanner = new Scanner(System.in);

		boolean isUserInterested = true;
		do {
			try {
				ScreenPrint.printLogIn();
				int userSelection = scanner.nextInt();
				switch (userSelection) {
				case 1:
					// Users is prompted to sign in using a username and password.
					System.out.println("Enter Username");
					String username = scanner.next();
					System.out.println("Enter Password");
					String password = scanner.next();
					if (accountRepo.signIn(username, password)) {
						AccountManagement.accountDetailsManagement(username);
					} else {
						System.out.println("No account found.");
					}
					break;
				case 2:
					// Users are prompted to create a new account.
					accountRepo.save(accountRepo.getNewAccountInfo());
				
					break;
				case 3:
					isUserInterested = false;
					break;

				default:
					ScreenPrint.printInvalidEntry();
					break;
				}
				
			} catch (InputMismatchException invalidEntry) {
				System.out.println(
						"Invalid Entry: Please type only the number associated with your decision and then press enter.");

			} catch (NoSuchElementException invalidEntry) {
				System.err.println("Error");
				invalidEntry.printStackTrace();
				System.exit(0);

			}

		} while (isUserInterested);
	}
}
