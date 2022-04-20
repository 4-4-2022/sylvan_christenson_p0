package com.p0.service;

import com.p0.accountRepository.AccountRepositoryImpl;
import com.p0.model.Accounts;

public class AccountService {
	
	
	AccountRepositoryImpl accountRepo = new AccountRepositoryImpl();
	
	public Accounts checkForAccount(String username) {
		for (Accounts accounts : accountRepo.findAllAccounts()) {
			if (accounts.getUsername().equals(username))

				return accounts;

		}
		return null;
		
	

	}
	
	public double adminDiscount(double incomingAmount) {
		
		
		return (incomingAmount * 0.85);
			
		}
	public double employeeDiscount(double incomingAmount) {
		
		
	return (incomingAmount * 0.90);
		
	}
	public double addTax(double incomingAmount) 
	{
		return (incomingAmount * 1.2);
		
		
	}
	
	public double serviceFee(double incomingAmount) {
	//Adds a service fee to certain transactions.
		
		
		return (incomingAmount + 5);
			
	}
	


		
	}
	
	


	
	

