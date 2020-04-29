package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import destination.Destination;
import destination.Landmark;
import destination.User;


public class UserTest {
	
	private User testUser; 

	
	@BeforeEach
	void setupTestingDestination() {
		this.testUser = new User("testUser", "St. Louis", "United States");		
	}

	@Test
	void testUser() {
		Destination tempDest = new Destination("Seattle", "United States"); 
		
		assertEquals(null, this.testUser.getDestination());
		this.testUser.setDestination(tempDest);		
		assertEquals(this.testUser.getDestination().getLocation(), tempDest.getLocation());
		assertEquals("testUser", this.testUser.getUser());
		
		Destination tempDest2 = new Destination("Dallas", "United States"); 
		this.testUser.setDestination(tempDest2);
		assertEquals(this.testUser.getDestination().getLocation(), tempDest2.getLocation());
		
	}

}
