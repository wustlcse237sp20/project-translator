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
	
	public Set<User> getTravelPeers() {
		return this.travelPeers;
	}
	
	public Map<User, Set<Landmark>> getLandmarks() {
		return this.landMarks;
	}
	
	public void addPeer(User user) {
		this.travelPeers.add(user);
	}
	
	public void removePeer(User user) {
		this.travelPeers.remove(user);
	}
	
	public int getTotalNumberOfPeers() {
		return travelPeers.size();
	}
	
	public void seeAllPeers() {
		for(User user : travelPeers) {
			System.out.println(user.getUser());
		}
	}
	
	
	public void addLandmark(User user, String name) {
		landMarks.get(user).add(new Landmark(name));
	}
	
	public void removeLandmark(User user, String name) {
		landMarks.get(user).remove(new Landmark(name));
	}
	
	public int getTotalNumberOfLandmarks(User user) {
		return landMarks.get(user).size();
	}
	
	public void seeAllLandmarks(User user) {
		for(Landmark landmark : landMarks.get(user)) {
			System.out.println(landmark.getName());
		}
	}
}