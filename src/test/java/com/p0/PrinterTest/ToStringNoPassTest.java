package com.p0.PrinterTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.p0.model.Accounts;

public class ToStringNoPassTest {
	@Mock
	Accounts account;

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@BeforeEach
	public void setUpStreams() {
		this.account = new Accounts();
		System.setOut(new PrintStream(outContent));

	}

	@AfterEach
	public void restoreStreams() {

		System.setOut(originalOut);

	}

	@Test
	public void printStringNoPassTest() {
		Accounts account = new Accounts();
		account.setAccountBalance(200);
		account.setUsername("test");
		account.setPassword("password");
		System.out.println(account.toStringNoPass());
		assertEquals("Username: test\n" + "Account Balance: 200.0\n" + "Is an Employee: false\n"
				+ "Is an Administrator: false\n" + "Secondary User: null\r\n" + "", outContent.toString());
	}
	@Test
	public void printStringNoPassFail() {
		Accounts account = new Accounts();
		account.setAccountBalance(100);
		account.setUsername("test");
		account.setPassword("password");
		System.out.println(account.toStringNoPass());
		assertNotEquals("Username: test\n" + "Account Balance: 200.0\n" + "Is an Employee: false\n"
				+ "Is an Administrator: false\n" + "Secondary User: null\r\n" + "", outContent.toString());
	}

}
