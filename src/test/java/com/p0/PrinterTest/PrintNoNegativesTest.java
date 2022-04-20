package com.p0.PrinterTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.p0.ui.ScreenPrint;

public class PrintNoNegativesTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
		private final PrintStream originalOut = System.out;
		private final PrintStream originalErr = System.err;
	
		@BeforeEach
		public void setUpStreams() {
		    System.setOut(new PrintStream(outContent));
		    System.setErr(new PrintStream(errContent));
		}
	
		@AfterEach
		public void restoreStreams() {
			System.out.flush();
		    System.setOut(originalOut);
		    System.setErr(originalErr);
		}
	
		@Test
		public void printNoNegatives() {
			
		    ScreenPrint.printNoNegatives(null);
		    assertEquals("Negative values are not allowed.\r\n"
		    		+ "", outContent.toString());
		}
		
		

		}
		
	


