package com.p0.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.p0.ringRepository.RingsRepositoryImpl;
import com.p0.ui.ScreenPrint;

public class JewelerShop {
	public static ServiceSelection service = new ServiceSelection();
	public static RingsRepositoryImpl ringRepo = new RingsRepositoryImpl();

	public static Scanner scanner = new Scanner(System.in);

	public static void shopMainMenu(String username) throws SQLException {
		boolean isUserInterested= true;
		while(isUserInterested) {
		ScreenPrint.printShopMainMenu();
		int userSelection = scanner.nextInt();
		switch(userSelection) {
		case 1: ringRepo.printRingList();
		break;
		case 2: ringRepo.printRingList(ringRepo.searchByMaterial());
		break;
		case 3:ringRepo.printRingList(ringRepo.searchByGem());
		case 4:ringRepo.printRingList(ringRepo.searchByJeweler());
		case 5:ringRepo.saveRingToCustomRings(ringRepo.customRing());
		case 6:service.serviceSelction(username);
			default: ScreenPrint.printInvalidEntry();
			break;
		
		}
		}
	}
	}
