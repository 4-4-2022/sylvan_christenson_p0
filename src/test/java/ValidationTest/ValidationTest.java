package ValidationTest;


import java.sql.SQLException;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.p0.util.Validation;

import uk.org.webcompere.systemstubs.jupiter.SystemStub;
import uk.org.webcompere.systemstubs.stream.SystemIn;
import uk.org.webcompere.systemstubs.stream.input.LinesAltStream;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)

public class ValidationTest {
	@SystemStub
	private SystemIn systemIn = new SystemIn("1");
	
	private Validation validation;

	@BeforeAll
	public void setup() {
		MockitoAnnotations.openMocks(this);
		this.validation = new Validation();
		
	}


	@BeforeEach
	public void BeforeEach() {

	}
	@Test
	public void testConfirmation1() throws SQLException {
	
		Assertions.assertTrue(validation.confirmation(1));
		
	}
	@Test
	public void testConfirmationFails2() throws SQLException {
	
		Assertions.assertFalse(validation.confirmation(2));
		}

	@Test
	public void tesConfirmationFails3() throws SQLException {
	
		Assertions.assertFalse(validation.confirmation(3));
		
	}
	
	
	

	}
	
	


	
	