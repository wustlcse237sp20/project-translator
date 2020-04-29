package userActivities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import destination.Destination;
import destination.User;

public class Persistence {
	public static void restoreDestinations(User currUser) {	
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("src/credentials/" + currUser.getUser() + ".txt"));
			String line = reader.readLine();
			
			while (line != null) {
				if(line.contains(", ")) {
					// split string to get city and country
					String[] loc = line.split( "[\\s,]+" );
					currUser.addDestination(new Destination(loc[0], loc[1]));
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
