package com.p0.Menus;

import java.sql.SQLException;
import java.util.Scanner;

import com.p0.service.AccountDetailsManipulation;
import com.p0.ui.ScreenPrint;
import com.p0.util.Validation;

public class EditAccount {
	public static AccountDetailsManipulation accountDetails = new AccountDetailsManipulation();
	public static Scanner scanner = new Scanner(System.in);
	public static Validation val = new Validation();

	public void accountEditMenu(String userToView, String username) throws SQLException {

		boolean isUserInterested = true;
		while (isUserInterested) {
			ScreenPrint.printSingleAccountEdit(userToView);
			int userChoice = scanner.nextInt();
			switch (userChoice) {
			case 1:
				System.out.println("Enter the new username for this account");
				accountDetails.updateUsername(userToView, scanner.next());
				break;
			case 2:
				System.out.println("Enter the new password for this account");
				accountDetails.updatePassword(userToView, scanner.next());
				break;
			case 3:
				System.out.println("Enter the new balance for this account");
				accountDetails.updateBalance(userToView, scanner.nextDouble());
				break;
			case 4:
				System.out.println("Is this account an employee account?");
				accountDetails.updateEmployment(userToView, val.confirmation(val.getConfirmation()));
				break;
			case 5:
				if (username.equals(userToView)) {
					System.out.println("You cannot alter your own admin status.");
					break;
				}
				System.out.println("Is this account an Administrator account?");
				accountDetails.updateAdmin(userToView, val.confirmation(val.getConfirmation()));
				break;
			case 6:
				System.out.println("Which account would you like to add as a secondary user");
				accountDetails.updateSecondaryUser(userToView, scanner.next());
				break;
			case 7:
				isUserInterested = false;
				break;

			default:
				ScreenPrint.printInvalidEntry();
				break;
			}

		}
	}
}
