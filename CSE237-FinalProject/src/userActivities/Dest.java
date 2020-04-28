package userActivities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import destination.Destination;
import destination.Landmark;
import destination.User;

public class Dest {
	
	/**
     * Asks a user to input a destination they want to visit
     * 
     * @param mainScanner to get the user input from command line
     * @param currUser the current user logged in
     */
	public static void getDestinationScreen(Scanner mainScanner, User currUser) throws IOException {
		System.out.println("Where would you like to visit? (type 'city, country')");
		
		boolean validCommand = false;
		
		while (!validCommand) {
			String selection = mainScanner.nextLine();
			
			String[] words = selection.split("\\s+");
			
			for (int i = 0; i < words.length; i++) { // parsing
			    words[i] = words[i].replaceAll("[^\\w]", "");
			}
			
			if (words.length == 2) {
				validCommand = true;
				Destination destination = new Destination(words[0], words[1]);
				
				if (currUser.addDestination(destination)) {

					destination.addPeer(currUser);
					
					String pathToFile = "src/credentials/" + currUser.getUser() + ".txt";
					FileWriter myWriter = new FileWriter(pathToFile, true);
					myWriter.write(destination.getLocation() + "\n");
					myWriter.close();
					
					System.out.println("Destination added!\n");
					
					String newDestinationPath = "src/places/" + destination.getLocation() + ".txt";
					File destinationInfoFile = new File(newDestinationPath);
					
					if (!destinationInfoFile.exists()) {
						try {
							destinationInfoFile.createNewFile();
						} catch (IOException e) {
							System.out.println("Error occured in creating destinationInfo file");
							e.printStackTrace();
						}
					}	
				} else {
					System.out.println("This destination already exists on your list!");
					return;
				}
			} else {
				System.out.println("Please enter a valid destination.");
			}
		}
	}
	
	/**
     * Asks a user to add a tourist attraction, or landmark, to one of their destinations
     * 
     * @param mainScanner to get the user input from command line
     * @param currUser the current user logged in
     */
	public static void getLandmarkScreen(Scanner mainScanner, User currUser) throws IOException {
		if(currUser.getDestinations().size() == 0) {
			System.out.println("You don't have any saved destinations yet. You need to add one before you can add landmarks!\n");
			return;
		}
		
		System.out.println("For which of your destinations would you like to add a landmark? (type '#')");
		
		ArrayList<Destination> destinationList = new ArrayList<>();
		
		int i = 1;
		for(Destination destination : currUser.getDestinations()) {
			System.out.println(i+". " + destination.getLocation());
			destinationList.add(destination);
			i++;
		}
		
		boolean validCommand = false;
		
		while (!validCommand) {
			String selection = mainScanner.nextLine();
			int result = Integer.parseInt(selection);
			
			if(result > 0 && result <= currUser.getDestinations().size()) {
				validCommand = true;
				addLandmarkScreen(mainScanner, currUser, destinationList.get(result-1));
			} else {
				System.out.println("Please input valid option.");
			}
			
		}
	}
	
	/**
     * Officially adds the landmark to a destination and writes it to file
     * 
     * @param mainScanner to get the user input from command line
     * @param currUser the current user logged in
     * @param destination the destination of which the landmark is being added
     */
	public static void addLandmarkScreen(Scanner mainScanner, User currUser, Destination destination) throws IOException {
		System.out.println("What's the name of the landmark?");
		
		boolean validCommand = false;
		
		while (!validCommand) {
			String selection = mainScanner.nextLine();
			
			if(!selection.isEmpty()) {
				validCommand = true;
				Landmark landmark = new Landmark(selection);
				destination.addLandmark(currUser, landmark);
				
				String pathToFile = "src/places/" + destination.getLocation() + ".txt";
				FileWriter myWriter = new FileWriter(pathToFile, true);
				myWriter.write(currUser.getUser() + "," + landmark.getName() + "\n");
				myWriter.close();
				
				System.out.println("Landmark added!\n");
				
				return;
				
			} else {
				System.out.println("Please input a valid landmark name.");
			}
			
		}
	}
}