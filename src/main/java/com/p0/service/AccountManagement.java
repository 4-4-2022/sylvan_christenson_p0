package com.p0.service;

import java.util.Scanner;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.p0.accountRepository.accountRepository;
import com.p0.model.Accounts;

public class AccountManagement {
	private static final Logger logger= LoggerFactory.getLogger(AccountManagement.class);
	static Scanner scanner = new Scanner(System.in);
	static accountRepository accountRepo = new accountRepository();
	
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

	public static void signIn() {
		System.out.println("Enter Username");

		System.out.println("Enter Password");

	


}}
