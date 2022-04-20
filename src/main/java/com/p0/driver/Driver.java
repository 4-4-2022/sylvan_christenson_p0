package com.p0.driver;

import java.sql.SQLException;
import java.util.Scanner;

import com.p0.Menus.Storefront;
import com.p0.service.AccountService;
import com.p0.util.Validation;

public class Driver {
	
	public static void main(String[] args) throws SQLException {
		
		//AccountService accountService = new AccountService();
		
		//System.out.println(accountService.checkForAccount("Peppies").getUsername());
		//Validation val = new Validation();
		
		//System.out.println(confirmation2(1));
		//JewelerShop.shopMainMenu("Peppies");
		Storefront.storeFront();
		// System.out.println("Farewell.");

	}

}
