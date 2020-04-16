package destination;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Destination {
	Location location;
	Set<User> travelPeers;
	Map<User, Set<Landmark>> landMarks;
	
	public Destination(String city, String county) {
		this.location = new Location(city, county);
		this.travelPeers = new HashSet<>();
		this.landMarks = new HashMap<>();
	}
	
	public String getLocation() {
		return this.location.getLocation();
	}
}
