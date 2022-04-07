package com.p0.ui;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.p0.accountRepository.accountRepository;
import com.p0.model.Rings;
import com.p0.ringRepository.RingRepository;
import com.p0.service.AccountManagement;

public class Storefront {
	
	private static final Logger logger = LoggerFactory.getLogger(Storefront.class);

	public static void printStoreFront() {

		System.out.println("Howdy. Welcome to Peppies' Rings and Things");
		System.out.println("--------------------------------------------- ");
		System.out.println("--------------------------------------------- ");
		System.out.println("--------------______________----------------- ");
		System.out.println("------------ /_____________/|---------------- ");
		System.out.println("-------------Peppies'      ||---------------- ");
		System.out.println("-------------Rings & Things||----------------");
		System.out.println("-------------| ___         ||----------------");
		System.out.println("_____________|_| |_________||________________");
		System.out.println("1) Sign In    2) Create Account    3) Exit   ");

		// Entry Menu Selection
		RingRepository ringRepository = new RingRepository();

		Rings[] rings = ringRepository.findAllRings();
		Scanner scanner = new Scanner(System.in);

		boolean isUserInterested = true;
		while (isUserInterested) {
			int userSelection = scanner.nextInt();
			switch (userSelection) {
			case 1:
				AccountManagement.signIn();
				break;
			case 2:
				AccountManagement.createAccount();
				break;
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
			default:
				System.out.println("Invalid Entry");
			}
		}
	}
}
