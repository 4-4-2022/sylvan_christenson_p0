package com.p0.driver;

import com.p0.ui.Storefront;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.p0.accountRepository.*;

public class Driver {
	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(Driver.class);
		accountRepository accountRepo = new accountRepository();
		Storefront.printStoreFront();
		logger.info("All Accounts at termination" + accountRepo.findAllAccounts());
		System.out.println("Farewell.");

			
				
			}
		
		
	}



	


