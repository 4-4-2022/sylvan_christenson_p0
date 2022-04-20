package com.p0.Menus;

import java.sql.SQLException;
import java.util.Scanner;

import com.p0.accountRepository.AccountRepositoryImpl;
import com.p0.ringRepository.RingsRepositoryImpl;
import com.p0.ui.ScreenPrint;
import com.p0.util.Validation;

public class EmployeeMenu {
	public static Validation validation = new Validation();
	public static EditAccount edit = new EditAccount();
	Scanner scanner = new Scanner(System.in);

	public static void singleAccountEditEmployee(String username, String userToView) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		AccountRepositoryImpl accountRepo = new AccountRepositoryImpl();
		boolean userInterested = true;
		while (userInterested) {
			ScreenPrint.printEmployeeMenuSingleAccount(username, userToView);
			int userSelection = scanner.nextInt();
			switch (userSelection) {

			case 1:
				System.out.println("This will permanently delete this account. Are you sure?");
				if(accountRepo.checkForAccount(userToView).isAdministrator()) {
					System.out.println("You cannot delete an administrator account.");
					break;
				}
				if (validation.confirmation(validation.getConfirmation())) {
					accountRepo.deleteAccount(userToView, username);
				} else {
					break;
				}

			case 2:
				userInterested = false;
				break;
			default:
				ScreenPrint.printInvalidEntry();
				break;
			}
		}

	}

	public static void singleAccountEditAdmin(String username, String userToView) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		AccountRepositoryImpl accountRepo = new AccountRepositoryImpl();
		boolean userInterested = true;
		while (userInterested) {
			ScreenPrint.printAdministratorMenuSingleAccount(username, userToView);
			int userSelection = scanner.nextInt();
			switch (userSelection) {
			case 1:
				edit.accountEditMenu(userToView, username);
				
				break;
			case 2:
				System.out.println("This will permanently delete this account. Are you sure?");
				if (validation.confirmation(validation.getConfirmation())) {
					accountRepo.deleteAccount(userToView, username);
					break;

				}
				else {
				break;}

			case 3:
				userInterested = false;
				break;
			default:
				ScreenPrint.printInvalidEntry();
				break;
			}
		}

	}

	public static void employeeMenu(String username) throws SQLException {
		Validation val = new Validation();
		ServiceSelection serviceSelection = new ServiceSelection();
		AccountRepositoryImpl accountRepo = new AccountRepositoryImpl();
		ScreenPrint.printContinueAsEmployee(username);
		Scanner scanner = new Scanner(System.in);
		boolean hasNotChosen = true;
		while (hasNotChosen) {
			int userSelection = scanner.nextInt();
			switch (userSelection) {
			case 1:
				serviceSelection.serviceSelction(username);
				hasNotChosen = false;
				break;
			case 2:
				while (hasNotChosen) {
					ScreenPrint.printEmployeeMenu(username);
					int adminSelction = scanner.nextInt();
					switch (adminSelction) {
					case 1:
						System.out.println("Please enter an account you wish to view");
						String userToView = scanner.next();
						if (val.accountExists(userToView)) {
							singleAccountEditEmployee(username, userToView);
							break;
						} else {
							System.out.println("No account found");
							break;
						}
					case 2:
						accountRepo.printAccountList();
						break;
					case 3:
						Storefront.storeFront();
					case 4:
						serviceSelection.serviceSelction(username);

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
		Validation val = new Validation();
		ServiceSelection serviceSelection = new ServiceSelection();
		AccountRepositoryImpl accountRepo = new AccountRepositoryImpl();
		RingsRepositoryImpl ringRepo = new RingsRepositoryImpl();
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
				while (hasNotChosen) {
					ScreenPrint.printAdministratorMenu(username);
					int adminSelction = scanner.nextInt();
					switch (adminSelction) {
					case 1:
						System.out.println("Please enter an account you wish to view");
						String userToView = scanner.next();
						if (val.accountExists(userToView)) {
							singleAccountEditAdmin(username, userToView);
						} else {
							System.out.println("No account found");
							break;
						}
					case 2:
						accountRepo.printAccountList();
						break;

					case 3:
						Storefront.storeFront();
						break;
					case 4:
						serviceSelection.serviceSelction(username);
						break;
					case 5:
						ringRepo.saveRingToRings(ringRepo.newRing());
						break;
					
						


					default:
						ScreenPrint.printInvalidEntry();
						break;
					}
				}

			case 3:
				employeeMenu(username);

			default:
				ScreenPrint.printInvalidEntry();
				break;
			}
		}

	}

}
