package com.p0.driver;

import java.sql.SQLException;

import com.p0.accountRepository.AccountRepositoryImpl;
import com.p0.service.JewelerShop;
import com.p0.service.Storefront;
import com.p0.ui.ScreenPrint;
import com.p0.util.SQL;
import com.p0.util.Validation;

public class Driver {
	public static void main(String[] args) throws SQLException {
		AccountRepositoryImpl accountRepo = new AccountRepositoryImpl();
		Validation validation = new Validation();
		SQL SQL = new SQL();
		ScreenPrint screenPrint = new ScreenPrint();
		JewelerShop.shopMainMenu("Peppies");
		//Storefront.storeFront();
		// System.out.println("Farewell.");

	}

}
