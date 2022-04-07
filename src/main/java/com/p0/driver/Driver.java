package com.p0.driver;

import com.p0.ui.Storefront;
import com.p0.accountRepository.*;

public class Driver {
	public static void main(String[] args) {
		
		accountRepository accountRepo = new accountRepository();
		Storefront.printStoreFront();
		System.out.println(accountRepo.findAllAccounts());
		System.out.println("Farewell.");

			
				
			}
		
		
	}



	


