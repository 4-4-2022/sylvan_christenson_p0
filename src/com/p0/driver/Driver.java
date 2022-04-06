package com.p0.driver;

import java.util.List;
import java.util.Scanner;

import com.p0.model.Accounts;
import com.p0.model.Rings;
import com.p0.ringRepository.RingRepository;

public class Driver {
	public static void main(String[] args) {

		RingRepository ringRepository = new RingRepository();
		Rings[] rings = ringRepository.findAllRings();
		
	System.out.println(rings[0]);
	System.out.println(rings[1]);
	System.out.println(rings[2]);
	System.out.println(rings[3]);

		printStoreFront();

		// Entry Menu Selection
		Scanner scanner = new Scanner(System.in);

		boolean isUserInterested = true;
		while (isUserInterested) {
			int userSelection = scanner.nextInt();
			switch (userSelection) {
			case 1:
				signIn();
				break;
			case 2:
				createAccount();
				break;
			case 3:
				isUserInterested = false;
				break;
			default:
				System.out.println("Invalid Entry");
			}
		}
		
	}

	private static void printStoreFront() {
		
		System.out.println("Howdy. Welcome to Peppies' Rings and Things");
		System.out.println("--------------------------------------------- ");
		System.out.println("--------------------------------------------- ");
		System.out.println("--------------______________----------------- ");
		System.out.println("------------ /_____________/|---------------- ");
		System.out.println("-------------Peppies'      ||---------------- ");
		System.out.println("-------------Rings & Things||----------------");
		System.out.println("-------------| ___         ||----------------");
		System.out.println("_____________|_| |_________||________________");
		System.out.println("1) Sign In    2) Create Account    3) Exit    ");
	}

	private static void employmentStatus() {

	}

	private static void createAccount() {

		System.out.println("Enter Desired Username");

		System.out.println("Enter Desired Password");
	}

	private static void signIn() {
		System.out.println("Enter Username");

		System.out.println("Enter Password");

	}

}
