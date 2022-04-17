package com.p0.ui;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.p0.accountRepository.AccountRepositoryImpl;
import com.p0.driver.Driver;

public class ScreenPrint {
	final static Logger logger = LoggerFactory.getLogger(Driver.class);
	public static AccountRepositoryImpl accountRepo = new AccountRepositoryImpl();
	public static void printInvalidEntry() {
		System.out.println(
				"Invalid Entry: Please type only the number associated with your decision and then press enter.");
	}

	public static void printNoTransferUserFound(String receivingUser) {

		System.out.println("No Account was found by that username. What would you like to do?");
		System.out.println("1) Try a different username ");
		System.out.println("2) Create a new account named:" + " " + receivingUser + " " + "and then transfer to that account.");
		System.out.println("3) Return to the main menu");
			

	}

	public static void printLogIn() {

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
		System.out.println("1) Create a New Account");
		System.out.println("2) Withdraw");
		System.out.println("3) Deposit");
		System.out.println("4) Transfer");
		System.out.println("5) Check Balance");
		System.out.println("6) Return to Log In menu to sign in with a different account.");
		System.out.println("7) Add an account as a secondary user.");
		System.out.println("8) Exit Program");

	}

	public static void printAccountManagement() {

		System.out.println("       What would you like to do?");
		System.out.println("--------------------------------------------- ");
		System.out.println("1) Create a New Account");
		System.out.println("2) Withdraw");
		System.out.println("3) Deposit");
		System.out.println("4) Transfer");
		System.out.println("5) Check Balance");
		System.out.println("6) Return to Log In menu to sign in with a different account.");
		System.out.println("7) Add an account as a secondary user.");
		System.out.println("8) Exit Program");

	}

	public static void printSeriveSelction() {
		System.out.println("       What would you like to do?");
		System.out.println("--------------------------------------------- ");
		System.out.println("1) Take a look around the shop.");
		System.out.println("2) Account Management (Withdraw, Deposit, Create/Add accounts)");

	}

	public static void printAdministratorMenu(String username) {
		System.out.println(" You are signed in as an Administrator:" + " " + username);
		System.out.println(
				" You have the authority to view and edit all accounts as well as promote accounts to Employee and Administrator status.");
		System.out.println("       What would you like to do?");
		System.out.println("--------------------------------------------- ");
		System.out.println("1) Select a single account.");
		System.out.println("2) View a list of all accounts.");
		System.out.println("3) Return to Sign In menu");
		System.out.println("4) Enter the shop.");
	}

	public static void printEmployeeMenu(String username) {
		System.out.println(" You are signed in as an Employee:" + " " + username);
		System.out.println(" You have the authority to view and cancel accounts.");
		System.out.println("       What would you like to do?");
		System.out.println("--------------------------------------------- ");
		System.out.println("1) Select a single account.");
		System.out.println("2) View a list of all accounts.");
		System.out.println("3) Return to Sign In menu.");
		System.out.println("4) Enter the shop.");
	}

	public static void printAdministratorMenuSingleAccount(String username, String userToView) {
		AccountRepositoryImpl accountRepo = new AccountRepositoryImpl();
		System.out.println(" You are signed in as an Administrator:" + " " + username);
		System.out.println(" You have the authority to view and edit all accounts as well as promote accounts to Employee and Administrator status.");
		System.out.println(" You are currently viewing the account:" + " " + userToView );
		System.out.println(accountRepo.checkForAccount(userToView).toStringNoPass());
		System.out.println("       What would you like to do?");
		System.out.println("--------------------------------------------- ");
		System.out.println("1) Edit Account this account.");	
		System.out.println("2) Delete this account.");
		System.out.println("3) Go back to Administrator menu.");
		}

	public static void printEmployeeMenuSingleAccount(String username, String userToView) {
		AccountRepositoryImpl accountRepo = new AccountRepositoryImpl();
		System.out.println(" You are signed in as an Employee:" + " " + username);
		System.out.println(" You have the authority to view account details as well as cancel accounts.");
		System.out.println(" You are currently viewing the account:");
		System.out.println(accountRepo.checkForAccount(userToView).toStringNoPass());
		System.out.println("       What would you like to do?");
		System.out.println("--------------------------------------------- ");
		System.out.println("1) Delete Account");
		System.out.println("2) Go back to Employee menu.");

	}

	public static void printContinueAsAdmin(String username) {
		System.out.println("Administrator Account:" + " " + username);
		System.out.println("1) Enter the shop.");
		System.out.println("2) Administration Menu");
		System.out.println("3) Employee Menu");
	}

	public static void printContinueAsEmployee(String username) {
		System.out.println(" Employee Account:" + " " + username);
		System.out.println("1) Enter the shop.");
		System.out.println("2) Employee Menu");

	}
	
	public static void printSingleAccountEdit(String userToView) {

		System.out.println(" You are currently editting this account");
		System.out.println(accountRepo.getAccountSQL(userToView).toStringNoPass());
		System.out.println("-----------------------------");
		System.out.println("1) Change account username.");
		System.out.println("2) Change account password.");
		System.out.println("3) Change account balance.");
		System.out.println("4) Change employment status.");
		System.out.println("5) Change admin status.");
		System.out.println("6) Change secondary user.");
		System.out.println("7) Return to Administration Menu.");

	}

	public static void printShopMainMenu() {

		System.out.println("Welcome to Peppies' Rings and Things");
		System.out.println("What would you like to do in the Jeweler's Shop");
		System.out.println("1) Browse all currently available wares");
		System.out.println("2) Search for rings by material.");
		System.out.println("3) Search for rings by gem");
		System.out.println("4) Search for rings by jeweler");
		System.out.println("5) Place an order for a custom ring");
		System.out.println("6) Return to service selection menu.");
	

	}

	public static void printTransactionSuccessful() {
		System.out.println("Transaction successful!");
	}

	public static void printNoNegatives(String username) {
		 System.out.println("Negative values are not allowed.");
		 logger.info(username +" attempted to enter a negative value while depositing, withdrawing, transfering, or altering an account balance.");
		
	}

}
