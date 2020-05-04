package userActivities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import destination.Destination;
import destination.Landmark;
import destination.User;

public class Persistence {
	
	static String userDirectory = Paths.get("")
            .toAbsolutePath()
            .toString();
	
	/*
	 * Use first commonPath if you are on command line. 
	 * User second commonPath if you are in eclipse. 
	 */
	
	static String commonPath = userDirectory + "/";  					// For commond line. 
//	 static String commonPath = "src/"; 										// For eclipse. 	
	
	
	/**
     * Restores a user's destinations
     * 
     * @param currUser The current user that's signed in
     */
	public static void restoreDestinations(User currUser) {	
		BufferedReader reader;
		try {			
			String userDirectory = Paths.get("")
		            .toAbsolutePath()
		            .toString();
			reader = new BufferedReader(new FileReader(commonPath +"credentials/" + currUser.getUser() + ".txt"));
			String line = reader.readLine();
			
			while (line != null) {
				if(line.contains(", ")) {
					// split string to get city and country
					String[] loc = line.split( "[\\s,]+" );
					Destination oldDest = new Destination(loc[0], loc[1]);
					restoreLandmarks(currUser, oldDest);

					File dir = new File(commonPath +"credentials/");
					File[] directoryListing = dir.listFiles();
					if (directoryListing != null) {
					    for (File child : directoryListing) {
					    	String username = child.getName().substring(0, child.getName().lastIndexOf('.'));
					    	
					    	// if it's a different user
					    	if(!username.equals(currUser.getUser())) {
					    		
					    		// if that same destination exists for that different user
					    		if(existsInFile(username, oldDest.getLocation())) {
					    			restorePeer(currUser, username, oldDest);
					    		}
					    	}
					    }
					}
					
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
     * Helper function to see if a term exists in a file or not
     * 
     * @param username Name of the peer you want to search
     * @param searchItem The destination being search for this peer
     */
	@SuppressWarnings("resource")
	private static boolean existsInFile(String username, String searchItem) {
		BufferedReader reader;
		try {
			
			reader = new BufferedReader(new FileReader(commonPath +"credentials/" + username + ".txt"));
			String line = reader.readLine();
			
			while (line != null) {
				
				if(line.equals(searchItem)) {
					return true;
				}
				
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
     * Restores a user's landmarks for their destinations
     * 
     * @param currUser The current user that's signed in
     * @param destination The destination that will have its landmarks restored for this user
     */
	private static void restoreLandmarks(User currUser, Destination destination) {	
		BufferedReader reader;
		try {
			
			String userDirectory = Paths.get("")
		            .toAbsolutePath()
		            .toString();	
			reader = new BufferedReader(new FileReader(commonPath +"places/" + destination.getLocation() + ".txt"));
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
	
	/**
     * Restores other users so the current user can see his/her peers
     * 
     * @param currUser The current user that's signed in
     * @param destination The destination that will have its landmarks restored for this user
     */
	private static void restorePeer(User currUser, String peer, Destination destination) {	
		BufferedReader reader;
		
		try {

			String userDirectory = Paths.get("")
		            .toAbsolutePath()
		            .toString();	
			reader = new BufferedReader(new FileReader(commonPath +"credentials/" + peer + ".txt"));
			String line = reader.readLine();
			
			int counter = 1;
			String[] userInfo = new String[2];
			while (line != null) {
				if(counter == 2) {
					userInfo[0] = line;
				} else if (counter == 3) {
					userInfo[1] = line;
				} else if(counter > 3) {
					break;
				}
				counter++;
				line = reader.readLine();
			}
			reader.close();
			
			destination.addPeer(new User(peer, userInfo[0], userInfo[1]));
			return;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
