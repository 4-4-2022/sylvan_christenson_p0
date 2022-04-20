package com.p0.PrinterTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.p0.ui.ScreenPrint;

public class PrintLogInTest {

	
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
public void printLogIn() { 
    ScreenPrint.printLogIn();
    assertEquals("--------------------------------------------- \r\n"
    		+ "--------------------------------------------- \r\n"
    		+ "--------------______________----------------- \r\n"
    		+ "------------ /_____________/|---------------- \r\n"
    		+ "-------------Peppies'      ||---------------- \r\n"
    		+ "-------------Rings & Things||---------------- \r\n"
    		+ "-------------| ___         ||---------------- \r\n"
    		+ "_____________|_| |_________||________________ \r\n"
    		+ "1) Sign In    2) Create Account    3) Exit    \r\n"
    		, outContent.toString());
}
}
