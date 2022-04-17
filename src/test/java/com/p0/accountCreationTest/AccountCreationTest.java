package com.p0.accountCreationTest;

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
public class AccountCreationTest {

	@Mock
	private AccountRepositoryImpl accountRepo;
	private List<Accounts> accountList;

	@BeforeAll
	public void setup() {
		MockitoAnnotations.openMocks(this);
		this.accountRepo = new AccountRepositoryImpl();
		this.accountList = new ArrayList<Accounts>();
		this.accountList.add(new Accounts(600, "Pegas", "password"));
		this.accountList.add(new Accounts(800, "Tekkaman", "password"));
		this.accountList.add(new Accounts(900, "Peppies", "password"));
		this.accountList.add(new Accounts(600, "Gooby", "password"));
	}

	@BeforeEach
	public void BeforeEach() {

	}

	@Test
	public void testFindAllAccounts() {

		Mockito.when(accountRepo.findAllAccounts()).thenReturn(accountList);
		Assertions.assertEquals(4, accountRepo.findAllAccounts().size());

	}

	@Test
	public void testSave() throws SQLException {

		Accounts newAccount = new Accounts();
		newAccount.setAccountBalance(500);
		newAccount.setUsername("newAccount");
		newAccount.setPassword("password");
		Mockito.when(accountRepo.getNewAccountInfo()).thenReturn(newAccount);
		Mockito.when(accountRepo.findAllAccounts()).thenReturn(accountList);
		accountList.add(newAccount);

		Assertions.assertEquals(5, accountRepo.findAllAccounts().size());

	}

	@AfterEach
	public void afterEach() {
		

	}

	@AfterAll
	public void afterAll() {

	}

}
