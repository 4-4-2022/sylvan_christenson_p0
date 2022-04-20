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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.p0.accountRepository.AccountRepositoryImpl;
import com.p0.model.Accounts;
import com.p0.service.AccountService;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class CheckForAccountTest {

	@Mock
	private AccountRepositoryImpl accountRepo;
	@InjectMocks
	private AccountService accountService;
	private List<Accounts> accountList;

	@BeforeAll
	public void setup() {
		MockitoAnnotations.openMocks(this);
		this.accountRepo = new AccountRepositoryImpl();
		this.accountService = new AccountService();
		this.accountList = new ArrayList<Accounts>();
		this.accountList.add(new Accounts(600, "Peppies", "passwordpeppies", true, true, "Tekkaman"));
		this.accountList.add(new Accounts(800, "Tekkaman", "password", true, true, "Pegas"));
		this.accountList.add(new Accounts(900, "Pegas", "password", true, false, null));
		this.accountList.add(new Accounts(600, "Gooby", "password", false, false, null));
	}

	@BeforeEach
	public void BeforeEach() {

	}

	@Test
	public void testCheckForAccount() throws SQLException {
		
		Mockito.when(accountRepo.findAllAccounts()).thenReturn(accountList);

		Assertions.assertEquals("Peppies", accountService.checkForAccount("Peppies").getUsername());
	}

	@Test
	public void testCheckForAccountPassword() throws SQLException {
		
		Mockito.when(accountRepo.findAllAccounts()).thenReturn(accountList);

		Assertions.assertEquals("passwordpeppies", accountService.checkForAccount("Peppies").getPassword());

	}

	@Test
	public void testCheckForAccountBalance() throws SQLException {
		Mockito.when(accountRepo.findAllAccounts()).thenReturn(accountList);
		Assertions.assertEquals(600, accountService.checkForAccount("Peppies").getAccountBalance());

	}

	@Test
	public void testCheckForAccountEmploymentStatus() throws SQLException {
		Mockito.when(accountRepo.findAllAccounts()).thenReturn(accountList);
		Assertions.assertEquals(true, accountService.checkForAccount("Peppies").isEmployee());

	}

	@Test
	public void testCheckForAccountAdminStatus() throws SQLException {
		Mockito.when(accountRepo.findAllAccounts()).thenReturn(accountList);
		Assertions.assertEquals(true, accountService.checkForAccount("Peppies").isAdministrator());

	}

	@Test
	public void testCheckForAccountFail() throws SQLException {
		Mockito.when(accountRepo.findAllAccounts()).thenReturn(accountList);
		Assertions.assertNotEquals("Gooby", accountService.checkForAccount("Peppies").getUsername());

	}
	

	@AfterEach
	public void afterEach() {

	}

	@AfterAll
	public void afterAll() {

	}

}