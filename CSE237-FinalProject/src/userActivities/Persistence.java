package userActivities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import destination.Destination;
import destination.Landmark;
import destination.User;

public class Persistence {
	
	/**
     * Restores a user's destinations
     * 
     * @param currUser The current user that's signed in
     */
	public static void restoreDestinations(User currUser) {	
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("src/credentials/" + currUser.getUser() + ".txt"));
			String line = reader.readLine();
			
			while (line != null) {
				if(line.contains(", ")) {
					// split string to get city and country
					String[] loc = line.split( "[\\s,]+" );
					Destination oldDest = new Destination(loc[0], loc[1]);
					restoreLandmarks(currUser, oldDest);
					
					currUser.addDestination(oldDest);
				}
				// read next line
				line = reader.readLine();
			}
			
			reader.close();
			return;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * Restores a user's landmarks for their destinations, called only by restoreDestinations
     * 
     * @param currUser The current user that's signed in
     * @param destination The destination that will have its landmarks restored for this user
     */
	private static void restoreLandmarks(User currUser, Destination destination) {	
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("src/places/" + destination.getLocation() + ".txt"));
			String line = reader.readLine();
			
			while (line != null) {
				String[] values = line.split(",");
						
				// check to see if this entry is by the current user
				if(values[0].equals(currUser.getUser())) {
					destination.addLandmark(currUser, new Landmark(values[1]));
				}
				// read next line
				line = reader.readLine();
			}
			
			reader.close();
			return;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
