package com.p0.accountRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.p0.driver.Driver;
import com.p0.model.Accounts;
import com.p0.service.AccountManagement;

public class AccountRepository {
	private static List<Accounts> accounts = new ArrayList<Accounts>();
	final static Logger logger = LoggerFactory.getLogger(Driver.class);
	
	
	
public void createAccount() {
		
		Scanner scanner = new Scanner(System.in);
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
		accounts.add(newUser);
		logger.info("Account Created" + newUser);
		AccountManagement.accountDetailsManagement(userinput);
		}

	public double getAccountBalance(String username) {

		for (Accounts account : accounts) {
			if (account.getUsername().equalsIgnoreCase(username)) {

				return account.getAccountBalance(username);

			}

		}
		return 0;

	}

	public void withdraw(String username, double withdrawAmount) {
		for (Accounts account : accounts) {
			if (account.getUsername().equalsIgnoreCase(username)) {
				double previousBalance = account.getAccountBalance(username);
				account.setAccountBalance(previousBalance - withdrawAmount);
				System.out.println("Your new account balance is " + account.getAccountBalance(username));
				}
			else {
				break;
			}
		}

	}

	public void deposit(String username, double depositAmount) {
		for (Accounts account : accounts) {
			if (account.getUsername().equalsIgnoreCase(username)) {
				double previousBalance = account.getAccountBalance(username);
				account.setAccountBalance(depositAmount + previousBalance);
				System.out.println(" Your new account balance is " + account.getAccountBalance(username));
			}
			else break;
		}

	}

	public static boolean signIn(String username, String password) {
		for (Accounts accounts : accounts) {
			if (accounts.getUsername().equalsIgnoreCase(username) && accounts.getPassword().equalsIgnoreCase(password))

				return true;

		}
		return false;

	}

	public String findAllAccounts() {

		return accounts.toString();
	}

	public AccountRepository() {
		super();
		Accounts peppies = new Accounts(500, "Peppies", "password", null);
		Accounts dolan = new Accounts(0, "Dolan", "password", null);
		Accounts gooby = new Accounts(0, "Gooby", "password", null);
		Accounts pegas = new Accounts(0, "Pegas", "password", null);
		accounts.add(peppies);
		accounts.add(dolan);
		accounts.add(gooby);
		accounts.add(pegas);

	}

	@Override
	public String toString() {
		return "accountRepository [accounts=" + accounts + "]";
	}

	public void add(Accounts newUser) {
		accounts.add(newUser);

	}
}
