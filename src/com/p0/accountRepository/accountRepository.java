package com.p0.accountRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.p0.model.Accounts;
import com.p0.model.Rings;

public class accountRepository {
private List <Accounts> accounts = new ArrayList<Accounts>();

public List<Accounts> findAllAccounts() {

	return this.accounts;
}



public accountRepository() {
	super();
	Accounts peppies = new Accounts(0, "Peppies", "Money");
	Accounts dolan = new Accounts(0, "Dolan", "Money");
	Accounts gooby = new Accounts(0, "Gooby", "Money");
	Accounts pegas = new Accounts(0, "Pegas", "Money");
	accounts.add(peppies);
	accounts.add(dolan);
	accounts.add(gooby);
	accounts.add(pegas);
}

}
