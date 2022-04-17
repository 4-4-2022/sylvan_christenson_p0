package com.p0.service;

import java.sql.SQLException;
import java.util.Scanner;

import javax.security.auth.callback.ConfirmationCallback;

import com.p0.accountRepository.AccountRepositoryImpl;
import com.p0.model.Accounts;
import com.p0.ui.ScreenPrint;

public class EmployeeMenu {

	public static boolean confirmation() {
		System.out.println("1) Yes               2)No");
		Scanner scanner = new Scanner(System.in);
		boolean confirmation = false;
		boolean userInterested = true;
		while (userInterested) {
			int userSelction = scanner.nextInt();
			switch (userSelction) {

			case 1: 
				userInterested = false;
				confirmation = true;
				break;
				
			case 2:
				userInterested = false;
				confirmation = false;
				break;
			default:
				ScreenPrint.printInvalidEntry();
				break;
			}

			

		}
		return confirmation;
	}

	public static void singleAccountEditEmployee(String username, String userToView) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		AccountRepositoryImpl accountRepo = new AccountRepositoryImpl();
		ScreenPrint.printEmployeeMenuSingleAccount(username, userToView);
		boolean userInterested = true;
		while (userInterested) {
			int userSelection = scanner.nextInt();
			switch (userSelection) {
			case 1: accountRepo.checkForAccount(userToView).toStringNoPass();
			
			case 2:System.out.println("This will permanently delete this account. Are you sure?"); 
				if (EmployeeMenu.confirmation()) {
					accountRepo.deleteAccount(userToView);
				
			}
			
			case 3: userInterested = false;
			break;
				default: ScreenPrint.printInvalidEntry();
				break;
				}
			}
			
		

		

		

	}
	public static void singleAccountEdit(String username, String userToView) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		AccountRepositoryImpl accountRepo = new AccountRepositoryImpl();
		ScreenPrint.printAdministratorMenuSingleAccount(username, userToView);
		boolean userInterested = true;
		while (userInterested) {
			int userSelection = scanner.nextInt();
			switch (userSelection) {
			case 1: ScreenPrint.printSingleAccountEdit(userToView);
			
			case 2:System.out.println("This will permanently delete this account. Are you sure?"); 
				if (EmployeeMenu.confirmation()) {
					accountRepo.deleteAccount(userToView);
				
			}
			
			case 3: userInterested = false;
			break;
				default: ScreenPrint.printInvalidEntry();
				break;
				}
			}
			
		

		

		

	}
	
	public static void employeeMenu(String username) throws SQLException {
		ServiceSelection serviceSelection = new ServiceSelection();
		AccountRepositoryImpl accountRepo = new AccountRepositoryImpl();
		Scanner scanner = new Scanner(System.in);
		ScreenPrint.printContinueAsEmployee(username);
		boolean hasNotChosen = true;
		while (hasNotChosen) {
			int userSelection = scanner.nextInt();
			switch (userSelection) {
			case 1:
				serviceSelection.serviceSelction(username);
				hasNotChosen = false;
				break;
			case 2:
				ScreenPrint.printEmployeeMenu(username);
				while (hasNotChosen) {
					int adminSelction = scanner.nextInt();
					switch (adminSelction) {
					case 1:
						System.out.println("Please enter an account you wish to view");
						String userToView = scanner.next();
						singleAccountEdit(username, userToView);

					case 2:
						System.out.println(accountRepo.findAllAccounts());
						break;

					case 3:

					default:
						ScreenPrint.printInvalidEntry();
						break;
					}
				}

			default:
				ScreenPrint.printInvalidEntry();
				break;
			}
		}

	}

	public static void administratorMenu(String username) throws SQLException {
		ServiceSelection serviceSelection = new ServiceSelection();
		AccountRepositoryImpl accountRepo = new AccountRepositoryImpl();
		Scanner scanner = new Scanner(System.in);
		ScreenPrint.printContinueAsAdmin(username);
		boolean hasNotChosen = true;
		while (hasNotChosen) {
			int userSelection = scanner.nextInt();
			switch (userSelection) {
			case 1:
				serviceSelection.serviceSelction(username);
				hasNotChosen = false;
				break;
			case 2:
				ScreenPrint.printAdministratorMenu(username);
				while (hasNotChosen) {
					int adminSelction = scanner.nextInt();
					switch (adminSelction) {
					case 1:
						System.out.println("Please enter an account you wish to view");
						String userToView = scanner.next();
						singleAccountEdit(username, userToView);

					case 2:
						for(Accounts account : accountRepo.findAllAccounts()) {
							System.out.println(account.toStringNoPass());
							
						}
						break;

					case 3: Storefront.storeFront();
					

					default:
						ScreenPrint.printInvalidEntry();
						break;
					}
				}

			default:
				ScreenPrint.printInvalidEntry();
				break;
			}
		}

	}

}
