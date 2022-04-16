package com.p0.service;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.p0.accountRepository.AccountRepositoryImpl;
import com.p0.ringRepository.RingRepository;
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
					accountRepo.save(accountRepo.getNewAccountInfo());
					System.out.println("Account Created Successfully");
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
				Storefront.storeFront();
			}

		}
		while (isUserInterested);
	}
}
