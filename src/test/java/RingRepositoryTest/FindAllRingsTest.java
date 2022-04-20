package RingRepositoryTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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

import com.p0.model.Rings;
import com.p0.ringRepository.RingsRepositoryImpl;
import com.p0.service.RingService;
@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class FindAllRingsTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	
	
		@Mock
		private RingsRepositoryImpl ringRepo;
		@InjectMocks
		private RingService ringService;
		private List<Rings> ringList;
		
		@BeforeAll
		public void setup() {
			MockitoAnnotations.openMocks(this);
			this.ringRepo = new RingsRepositoryImpl();
			this.ringList = new ArrayList<Rings>();
			this.ringList.add(new Rings("Business Time", "Metal", "Ruby", "Peppies", "Profit", null, null, 200));
			this.ringList.add(new Rings("Gold Time", "Gold", "Ruby", "Peppies", "Profit", null, null, 200));
			this.ringList.add(new Rings("Silver Time", "Silver", "Ruby", "Peppies", "Profit", null, null, 200));
			this.ringList.add(new Rings("Platinum Time", "Platinum", "Ruby", "Peppies", "Profit", null, null, 200));
		}

		@BeforeEach
		public void BeforeEach() {
			System.setOut(new PrintStream(outContent));
		}
		@Test
		public void testFindAllRingsAccounts() throws SQLException {
			
			Mockito.when(ringRepo.findAllRings()).thenReturn(ringList);
			Assertions.assertEquals(200, ringRepo.findAllRings().get(0).getPrice());
			}
		@Test
		public void testFindAllRingsFail() throws SQLException {
			
			Mockito.when(ringRepo.findAllRings()).thenReturn(ringList);
			Assertions.assertNotEquals(100, ringRepo.findAllRings().get(0).getPrice());
			}
		@Test
		public void testFindAllRingsMaterial() throws SQLException {
			
			Mockito.when(ringRepo.findAllRings()).thenReturn(ringList);
			Assertions.assertNotEquals("Gold", ringRepo.findAllRings().get(2).getMaterial());
			}
		
		
			
		
		
		
		
		
		

		@AfterEach
		public void afterEach() {
			System.setOut(originalOut);
		}

		@AfterAll
		public void afterAll() {

		}

	}


