package destination;

public class User {
	String userName;
	Location userLocation;
	Destination userDestination;
	// Credential information is stored inside of credentials' package with their username. No need to make a new one here. 
	
	public User(String userName, String city, String country) {
		this.userName = userName;
		this.userLocation = new Location(city, country);
		this.userDestination = null; // Initialize to null. 
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
	
	// Add some modifyUser methods with different parameters. 
	public void modifyUser() {		
	}
	
}
