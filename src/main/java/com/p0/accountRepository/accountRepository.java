package com.p0.accountRepository;

import java.util.List;

import com.p0.model.Accounts;

public interface AccountRepository {
	
	
	public List<Accounts> findAllAccounts();
	public void save(Accounts account);
	public void update(Accounts account);
	public void delete(Accounts account);
	

}
