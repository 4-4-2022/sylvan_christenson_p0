package com.p0.Menus;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.p0.accountRepository.AccountRepositoryImpl;
import com.p0.ui.ScreenPrint;
import com.p0.util.Validation;

public class Storefront {



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
						accountRepo.signIn();
						break;
					case 2:
						accountRepo.createAccount();
						break;
					case 3:
						isUserInterested = false;
						break;

					default:
						ScreenPrint.printInvalidEntry();
						break;
					}
					
				} catch (InputMismatchException invalidEntry) {
					ScreenPrint.printInvalidEntry();
					Storefront.storeFront();
					scanner.next();

				} catch (NoSuchElementException invalidEntry) {
					invalidEntry.printStackTrace();
				}
				
				scanner.nextLine();

			} while (isUserInterested);
		}
	}