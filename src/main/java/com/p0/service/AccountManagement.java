package com.p0.service;

import java.util.Scanner;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.p0.accountRepository.accountRepository;
import com.p0.model.Accounts;

public class AccountManagement {
	private static final Logger logger = LoggerFactory.getLogger(AccountManagement.class);
	static Scanner scanner = new Scanner(System.in);
	static accountRepository accountRepo = new accountRepository();

	public static void accountDetails() {

		System.out.println("       What would you like to do?");
		System.out.println("--------------------------------------------- ");
		System.out.println("1)Create New Account");
		System.out.println("2)Withdraw ");
		System.out.println("3)Deposit ");
		System.out.println("4)Transfer");
		System.out.println("5)Check Balance");
		int userSelection = scanner.nextInt();
		switch (userSelection) {
		case 1:
			createAccount();
			accountDetails();
			break;
		case 2:
			withdraw();
			break;
		case 3:
			deposit();
			break;
		case 4:
			transfer();
			break;
		case 5:
			System.out.println("Enter Username");
			String username = scanner.next();
			System.out.println("Enter Password");
			String password = scanner.next();
			accountRepository.signIn(username, password);
			break;
		default:
			System.out.println("Invalid Entry");
		}
	}

	private static void transfer() {

	}

	private static void deposit() {

	}

	private static void withdraw() {

	}

	public static void createAccount() {
		Accounts newUser = new Accounts();
		System.out.println("Enter username");
		String userinput = scanner.next();
		newUser.setUsername(userinput);
		System.out.println("Enter password");
		String userinput2 = scanner.next();
		newUser.setPassword(userinput2);
		System.out.println("Enter amount to deposit");
		double userinput3 = scanner.nextDouble();
		newUser.setAccountBalance(userinput3);
		accountRepo.add(newUser);

		logger.info("Account Created" + newUser);

	}

}
