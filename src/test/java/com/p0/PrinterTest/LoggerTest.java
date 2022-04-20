package com.p0.PrinterTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.p0.ui.ScreenPrint;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;


public class LoggerTest{
	
	
	

    @Test
    void printNoNegativesLoggingTest() throws Exception {
        // get Logback Logger 
    	Logger logger = (Logger) LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);

        // create and start a ListAppender
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        listAppender.start();

        // add the appender to the logger
        // addAppender is outdated now
        (( ch.qos.logback.classic.Logger) logger).addAppender(listAppender);

        // call method under test
        ScreenPrint.printNoNegatives("Peppies");

        // JUnit assertions
        List<ILoggingEvent> logsList = listAppender.list;
        assertEquals(Level.INFO, logsList.get(0)
                                         .getLevel());

    }
}