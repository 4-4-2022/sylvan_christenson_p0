package com.p0.PrinterTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.p0.ui.ScreenPrint;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class PrintInvalidEntryTest {


	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	private final PrintStream originalOut = System.out;
	

	@BeforeEach
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    
	}

	@AfterEach
	public void restoreStreams() {
		
	    System.setOut(originalOut);
	    
	}

	@Test
	public void printInvalidEntryTest() {
		
	    ScreenPrint.printInvalidEntry();
	    assertEquals("Invalid Entry: Please type only the number associated with your decision and then press enter.\r\n"
	    		+ "", outContent.toString());
	}
	
	}

