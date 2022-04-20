package com.p0.AccountRepositoryTest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.p0.accountRepository.AccountRepositoryImpl;
import com.p0.model.Accounts;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class FindAllAccountsTest {
	@Mock
	private AccountRepositoryImpl accountRepo;
	private List<Accounts> accountList;
	
	@BeforeAll
	public void setup() {
		MockitoAnnotations.openMocks(this);
		this.accountRepo = new AccountRepositoryImpl();
		this.accountList = new ArrayList<Accounts>();
		this.accountList.add(new Accounts(600, "Peppies", "password", true, true, "Tekkaman"));
		this.accountList.add(new Accounts(800, "Tekkaman", "password", true, true, "Pegas"));
		this.accountList.add(new Accounts(900, "Pegas", "password", true, false, null));
		this.accountList.add(new Accounts(600, "Gooby", "password", false, false, null));
	}

	@BeforeEach
	public void BeforeEach() {

	}
	@Test
	public void testFindAllAccounts() throws SQLException {
		
		Mockito.when(accountRepo.findAllAccounts()).thenReturn(accountList);
		Assertions.assertEquals(600, accountRepo.findAllAccounts().get(0).getAccountBalance());

	}
	@Test
	public void testFindAllAccountsUsername() throws SQLException {
		
		Mockito.when(accountRepo.findAllAccounts()).thenReturn(accountList);
		Assertions.assertEquals("Peppies", accountRepo.findAllAccounts().get(0).getUsername());

	}
	@Test
	public void testFindAllAccountsPassword() throws SQLException {
		
		Mockito.when(accountRepo.findAllAccounts()).thenReturn(accountList);
		Assertions.assertEquals("password", accountRepo.findAllAccounts().get(0).getPassword());

	}
	@Test
	public void testFindAllAccountsFail() throws SQLException {
		
		Mockito.when(accountRepo.findAllAccounts()).thenReturn(accountList);
		Assertions.assertNotEquals(3, accountRepo.findAllAccounts().size());
	}
	
	
	
	

	@AfterEach
	public void afterEach() {

	}

	@AfterAll
	public void afterAll() {

	}

}
