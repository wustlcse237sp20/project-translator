package destination;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class User {
	String userName;
	Location userLocation;
	Destination userDestination;
	Set<Destination> Destinations;
	// Credential information is stored inside of credentials' package with their username. No need to make a new one here. 
	
	public User(String userName, String city, String country) {
		this.userName = userName;
		this.userLocation = new Location(city, country);
		this.userDestination = null; // Initialize to null. 
		this.Destinations = new HashSet<>();
	}
	
	public void setDestination(Destination passedDestination) {
		this.userDestination = passedDestination;
	}
	
	public Destination getDestination() {
		return this.userDestination;
	}
	
	public String getUser() {
		return (this.userName);
	}
	
	public Location getLocation() {
		return this.userLocation;
	}
	
	public boolean addDestination(Destination destination) {
		return this.Destinations.add(destination);
	}
	
	public Set<Destination> getDestinations() {
		return this.Destinations;
	}
	
	public void seeDestinations() {
		for(Destination destination : this.Destinations) {
			System.out.println(destination.getLocation());
		}
	}
	
	// Add some modifyUser methods with different parameters. 
	public void modifyUser() {		
	}
	
}
