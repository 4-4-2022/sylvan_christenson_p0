package com.p0.accountRepository;

import java.util.ArrayList;
import java.util.List;

import com.p0.model.Accounts;

public class accountRepository {
	private List<Accounts> accounts = new ArrayList<Accounts>();

	public Accounts findAccountByUsername(String username) {
		for (Accounts accounts : accounts) {
			if (accounts.getUsername().equalsIgnoreCase(username))
				return accounts;
		}
		return null;
		
	

}

	public List<Accounts> findAllAccounts() {

		return accounts;
	}

	public accountRepository() {
		super();
		Accounts peppies = new Accounts(0, "Peppies", "password", null);
		Accounts dolan = new Accounts(0, "Dolan", "password", null);
		Accounts gooby = new Accounts(0, "Gooby", "password", null);
		Accounts pegas = new Accounts(0, "Pegas", "password", null);
		accounts.add(peppies);
		accounts.add(dolan);
		accounts.add(gooby);
		accounts.add(pegas);

	}

	@Override
	public String toString() {
		return "accountRepository [accounts=" + accounts + "]";
	}

	public void add(Accounts newUser) {
		accounts.add(newUser);
	}

}
