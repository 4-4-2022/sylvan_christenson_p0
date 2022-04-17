package com.p0.driver;

import java.sql.SQLException;

import com.p0.accountRepository.AccountRepositoryImpl;
import com.p0.service.Storefront;
import com.p0.util.SQL;

public class Driver {
	public static void main(String[] args) throws SQLException {
		AccountRepositoryImpl accountRepo = new AccountRepositoryImpl();
		SQL SQL = new SQL();
		// System.out.println(accountRepo.checkForAccount("Peppies").toStringNoPass());
		// Start of sourcecode
		// System.out.println(accountRepo.checkForAccountSQL("Peppies").toStringNoPass());
		//System.out.println(SQL.executeSQL(SQL.getAccountBalanceSQL("Peppies")).getDouble(1));
		//SQL.updateAccountBalanceSQL("Peppies", 500);

		Storefront.storeFront();
		// System.out.println("Farewell.");

	}

}
