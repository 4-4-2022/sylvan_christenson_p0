package com.p0.ui;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.p0.accountRepository.AccountRepository;
import com.p0.model.Rings;
import com.p0.ringRepository.RingRepository;
import com.p0.service.AccountManagement;

public class Storefront {

	private static final Logger logger = LoggerFactory.getLogger(Storefront.class);

	public static void storeFront() {

		ScreenPrint.printLogIn();
		AccountRepository accountRepo = new AccountRepository();
		RingRepository ringRepository = new RingRepository();
		Rings[] rings = ringRepository.findAllRings();
		Scanner scanner = new Scanner(System.in);

		boolean isUserInterested = true;
		while (isUserInterested) {
			int userSelection = scanner.nextInt();
			switch (userSelection) {
			case 1:
				System.out.println("Enter Username");
				String username = scanner.next();
				System.out.println("Enter Password");
				String password = scanner.next();
				if (AccountRepository.signIn(username, password)) {

					System.out.println("Welcome" + " " + username + "!  Your current available balance is" + " "
							+ accountRepo.getAccountBalance(username));
					AccountManagement.accountDetailsManagement(username);
					
				} else
					System.out.println("No account found.");
				break;
			case 2:
				accountRepo.createAccount();
				
			case 3:
				isUserInterested = false;
				break;
			case 4:
				System.out.println("Enter a ring material to view");
				String userMaterial = scanner.next();
				Rings retrievedRing = ringRepository.findRingByMaterial(userMaterial);
				System.out.println(retrievedRing);
				logger.info("The retrieved rings are: " + retrievedRing);
				break;
			case 5: 
				String usernameTest = "Peppies";
				System.out.println(
				accountRepo.getAccountBalance(usernameTest));
				
				break;
			default:
				System.out.println("Invalid Entry");
			}
		scanner.close();
		}
		
	}
}
