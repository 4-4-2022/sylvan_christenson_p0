package com.p0.Menus;

import java.sql.SQLException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.p0.accountRepository.AccountRepositoryImpl;
import com.p0.ringRepository.RingsRepositoryImpl;
import com.p0.ui.ScreenPrint;
import com.p0.util.SQL;
import com.p0.util.Validation;

public class JewelerShop {
	public static SQL sql = new SQL();
	public static ServiceSelection service = new ServiceSelection();
	public static RingsRepositoryImpl ringRepo = new RingsRepositoryImpl();
	public static Validation validation = new Validation();
	public static Scanner scanner = new Scanner(System.in);
	public static AccountRepositoryImpl accountRepo = new AccountRepositoryImpl();
	private static final Logger logger = LoggerFactory.getLogger(AccountManagement.class);

	public static void shopMainMenu(String username) throws SQLException {
		boolean isUserInterested = true;
		while (isUserInterested) {

			ScreenPrint.printShopMainMenu();
			int userSelection = scanner.nextInt();
			switch (userSelection) {
			case 1:
				ringRepo.printRingList();
				break;
			case 2:
				ringRepo.printRingList(ringRepo.searchByMaterial());
				break;
			case 3:
				ringRepo.printRingList(ringRepo.searchByGem());
				break;
			case 4:
				ringRepo.printRingList(ringRepo.searchByJeweler());
				break;
			case 5:
				ringRepo.saveRingToCustomRings(ringRepo.customRing());
				break;
			case 6:
				service.serviceSelction(username);
				break;
			case 7:
				ringRepo.purchaseRing(username);
				break;
			case 8:
				System.out.println(accountRepo.getAccountBalance(username));
				break;

			default:
				ScreenPrint.printInvalidEntry();
				break;

			}
		}
	}
}
