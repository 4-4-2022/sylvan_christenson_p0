package com.p0.driver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.p0.accountRepository.AccountRepository;
import com.p0.ui.ScreenPrint;
import com.p0.ui.Storefront;

public class Driver {
	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(Driver.class);
		AccountRepository accountRepo = new AccountRepository();
		Storefront.storeFront();
		System.out.println("Farewell.");

			
				
			}
		
		
	}



	


