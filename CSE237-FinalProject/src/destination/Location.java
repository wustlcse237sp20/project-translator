package destination;

public class Location {
	String city;
	String country;
	
	public Location(String city, String country) {
		this.city = city;
		this.country = country;
	}
	
	public String getLocation() {
		return (this.city + ", " + this.country);
	}
}
