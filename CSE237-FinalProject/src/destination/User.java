package destination;

public class User {
	String firstName;
	String lastName;
	Location userLocation;
	Destination userDestination;  
	// Another member variable: Credentials object
	
	
	public User(String firstName, String lastName, String city, String country) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userLocation = new Location(city, country);
		this.userDestination = null; // Initialize to null. 
	}
	
	public void setDestination(Destination passedDestination) {
		this.userDestination = passedDestination;
	}
	
	public String getUser() {
		return (this.firstName + " " + this.lastName);
	}
	
	// Add some modifyUser methods with different parameters. 
	public void modifyUser() {		
	}
	
}
