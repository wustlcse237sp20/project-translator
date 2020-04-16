package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import destination.Destination;
import destination.Landmark;
import destination.User;

class DestinationTest {
	
	private Destination destination;
	
	@BeforeEach
	void setupTestingDestination() {
		destination = new Destination("Tokyo", "Japan");
	}

	@Test
	void testDestinationLists() {
		User karen = new User("Karen", "Ye");
		User ruby = new User("Ruby", "Rain");
		
		destination.addPeer(karen);
		destination.addPeer(ruby);
		
		Landmark l1 = new Landmark("Shinjuku");
		Landmark l2 = new Landmark("Harajuku");
		Landmark l3 = new Landmark("Senso-ji");
		Landmark l4 = new Landmark("Roppongi");
		Landmark l5 = new Landmark("Harajuku");
		
		destination.addLandmark(karen, l1.getName());
		destination.addLandmark(karen, l2.getName());
		destination.addLandmark(karen, l3.getName());
		destination.addLandmark(ruby, l4.getName());
		destination.addLandmark(ruby, l5.getName());
		
		assertEquals(2, destination.getTotalNumberOfPeers());
		assertEquals(3, destination.getTotalNumberOfLandmarks(karen));
		assertEquals(2, destination.getTotalNumberOfLandmarks(ruby));
		
		assertTrue(destination.getLandmarks().get(karen).contains(l1));
		assertTrue(destination.getLandmarks().get(karen).contains(l2));
		assertTrue(destination.getLandmarks().get(karen).contains(l3));
		assertTrue(destination.getLandmarks().get(ruby).contains(l4));
		assertTrue(destination.getLandmarks().get(ruby).contains(l5));
	}

}
