
	
	
	package com.p0.AccountRepositoryTest;

	import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.p0.accountRepository.AccountRepositoryImpl;
import com.p0.model.Accounts;
import com.p0.service.AccountService;
import com.p0.util.SQL;

	@TestInstance(Lifecycle.PER_CLASS)
	@ExtendWith(MockitoExtension.class)
	public class AccountServiceTest {
		@Mock
		SQL sql;
		@Mock
		private AccountRepositoryImpl accountRepo;
		
		private AccountService accountService;
		private List<Accounts> accountList;

		@BeforeAll
		public void setup() {
			MockitoAnnotations.openMocks(this);
			this.sql = new SQL();
			this.accountRepo = new AccountRepositoryImpl();
			this.accountService = new AccountService();
			this.accountList = new ArrayList<Accounts>();
			this.accountList.add(new Accounts(600, "Peppies", "passwordpeppies", true, true, "Tekkaman"));
			this.accountList.add(new Accounts(800, "Tekkaman", "password", true, true, "Pegas"));
			this.accountList.add(new Accounts(900, "Pegas", "password", true, false, null));
			this.accountList.add(new Accounts(600, "Gooby", "password", false, false, null));
		}

		@Test
		public void testServiceFee() {
			
			Assertions.assertEquals(10, accountService.serviceFee(5));
		}
		public void testServiceFeeFails() {
			
			
			Assertions.assertNotEquals(2, accountService.serviceFee(5));
		}
		
		@Test
		public void testAddTax() {
			Assertions.assertEquals(1.2, accountService.addTax(1));	
		}
		@Test
		public void testAddTaxFails() {
			
			Assertions.assertNotEquals(8, accountService.addTax(1));
		}
		@Test
		public void testEmployeeDiscount() {
			
			Assertions.assertEquals(9, accountService.employeeDiscount(10));
		}
		@Test
		public void testAdminDiscount() {
			
			Assertions.assertEquals(8.5, accountService.adminDiscount(10));
		}
		@Test
		public void testAdminDiscountFails() {
			
			Assertions.assertNotEquals(8, accountService.adminDiscount(1));
		}
		@Test
		public void testEmployeeDiscountFails() {
			
			Assertions.assertNotEquals(8, accountService.employeeDiscount(1));
		}
}
