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
	
	public void updateCity(String toCity) {
		this.city = toCity; 	
	}
	public void updateCountry(String toCountry) {
		this.country = toCountry; 
	}
	
	public void updateLocation(String toCity, String toCountry) {
		this.city = toCity; 
		this.country = toCountry; 
	}
	
	public boolean equals(Location anotherLocation) {
		return (this.city.equals(anotherLocation.city) && this.country.equals(anotherLocation.country));
	}
}
