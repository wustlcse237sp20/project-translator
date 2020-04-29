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
		User karen = new User("Karen", "St. Louis", "USA");
		User ruby = new User("Ruby", "Paris", "France");
		
		destination.addPeer(karen);
		destination.addPeer(ruby);
		
		Landmark l1 = new Landmark("Shinjuku");
		Landmark l2 = new Landmark("Harajuku");
		Landmark l3 = new Landmark("Senso-ji");
		Landmark l4 = new Landmark("Roppongi");
		Landmark l5 = new Landmark("Harajuku");
		
		destination.addLandmark(karen, l1);
		destination.addLandmark(karen, l2);
		destination.addLandmark(karen, l3);
		destination.addLandmark(ruby, l4);
		destination.addLandmark(ruby, l5);
		
		assertEquals(2, destination.getTotalNumberOfPeers());
		assertEquals(3, destination.getTotalNumberOfLandmarks(karen));
		assertEquals(2, destination.getTotalNumberOfLandmarks(ruby));
		
		assertTrue(destination.getLandmarks().get(karen).contains(l1));
		assertTrue(destination.getLandmarks().get(karen).contains(l2));
		assertTrue(destination.getLandmarks().get(karen).contains(l3));
		assertTrue(destination.getLandmarks().get(ruby).contains(l4));
		assertTrue(destination.getLandmarks().get(ruby).contains(l5));
		
		destination.removeLandmark(karen, l3);
		assertEquals(2, destination.getTotalNumberOfLandmarks(karen));
		
		destination.removePeer(karen);
		assertFalse(destination.getTravelPeers().contains(karen));
		assertFalse(destination.getLandmarks().containsKey(karen));
	}
}
