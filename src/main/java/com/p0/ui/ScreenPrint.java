package com.p0.ui;

import java.sql.SQLException;

import com.p0.accountRepository.AccountRepositoryImpl;

public class ScreenPrint {
	public static void printInvalidEntry() {
		System.out.println(
				"Invalid Entry: Please type only the number associated with your decision and then press enter.");
	}

	public static void printNoTransferUserFound(String receivingUser) {

		System.out.println("No Account was found by that username. What would you like to do?");
		System.out.println("1) Try a different username 2) Create a new account named" + " " + receivingUser
				+ "and transfer funds to 3)Return to the main menu");

	}

	public static void printLogIn() {

		System.out.println("Howdy. Welcome to Peppies' Rings and Things   ");
		System.out.println("--------------------------------------------- ");
		System.out.println("--------------------------------------------- ");
		System.out.println("--------------______________----------------- ");
		System.out.println("------------ /_____________/|---------------- ");
		System.out.println("-------------Peppies'      ||---------------- ");
		System.out.println("-------------Rings & Things||---------------- ");
		System.out.println("-------------| ___         ||---------------- ");
		System.out.println("_____________|_| |_________||________________ ");
		System.out.println("1) Sign In    2) Create Account    3) Exit    ");
	}

	public static void printAccountManagement(String username) throws SQLException {
		AccountRepositoryImpl accountRepo = new AccountRepositoryImpl();

		System.out.println("        What would you like to do?");
		System.out.println("You are signed in as:" + " " + username);
		if (accountRepo.checkForSecondaryUser(username) != null) {
			System.out.println(
					accountRepo.checkForSecondaryUser(username).toString() + " is a secondary user to this account.");
		}
		System.out.println("--------------------------------------------- ");
		System.out.println("1)Create a New Account");
		System.out.println("2)Withdraw");
		System.out.println("3)Deposit");
		System.out.println("4)Transfer");
		System.out.println("5)Check Balance");
		System.out.println("6)Return to Log In menu to sign in with a different account.");
		System.out.println("7)Add an account as a secondary user.");
		System.out.println("8)Exit Program");

	}

	public static void printAccountManagement() {

		System.out.println("       What would you like to do?");
		System.out.println("--------------------------------------------- ");
		System.out.println("1)Create a New Account");
		System.out.println("2)Withdraw");
		System.out.println("3)Deposit");
		System.out.println("4)Transfer");
		System.out.println("5)Check Balance");
		System.out.println("6)Return to Log In menu to sign in with a different account.");
		System.out.println("7)Add an account as a secondary user.");
		System.out.println("8)Exit Program");

	}

}
