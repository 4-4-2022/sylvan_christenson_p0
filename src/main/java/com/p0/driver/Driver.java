package com.p0.driver;

import java.sql.SQLException;

import com.p0.accountRepository.AccountRepositoryImpl;
import com.p0.service.EmployeeMenu;
import com.p0.service.Storefront;

public class Driver {
	public static void main(String[] args) throws SQLException {
		//AccountRepositoryImpl accountRepo = new AccountRepositoryImpl();
		//System.out.println(accountRepo.checkForAccount("Peppies").toStringNoPass());
		//Start of sourcecode
		Storefront.storeFront();
		System.out.println("Farewell.");
		
			
				
			}
		
		
	}



	


