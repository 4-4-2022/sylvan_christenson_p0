package com.p0.accountCreationTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.p0.service.AccountManagement;
@TestInstance(Lifecycle.PER_CLASS)
public class AccountCreationTest {
	
	private AccountManagement accountManagement;
	
	@BeforeAll
	public void BeforeAll() {
		this.accountManagement = new AccountManagement();
	}
	
	@BeforeEach
	public void BeforeEach() {
			
	}
	
	
	@Test
	public void testCreateAccount() {
		
	}
	@AfterEach
	public void afterEach() {
		
	}
	@AfterAll
	public void afterAll() {
		
	}
	
}


