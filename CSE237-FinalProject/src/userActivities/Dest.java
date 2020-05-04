package userActivities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import destination.Destination;
//import destination.Keyword; 		uncomment to test keyword features
import destination.Landmark;
import destination.User;

public class Dest {
	
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
					
					String pathToFile =  commonPath + "credentials/" + currUser.getUser() + ".txt";
					FileWriter myWriter = new FileWriter(pathToFile, true);
					myWriter.write(destination.getLocation() + "\n");
					myWriter.close();
					
					System.out.println("Destination added!\n");
					/*
					 * 
					 * This feature of retrieving the keywords on the net has not been successfully integrated due to some difficulties adding external jar in command line.
					System.out.println("Here are some keywords for your travel plans!");
					
					Keyword k = new Keyword(destination.getLocation(), 20);
					List<String> listOfKeywords = k.getKeywords();
					System.out.println(listOfKeywords.toString());
					
					*/
					String newDestinationPath = commonPath + "places/" + destination.getLocation() + ".txt";
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
			if (!isNumeric(selection)) {
				System.out.println("Please type numeric value.");
				continue; 
			}
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
				
				String pathToFile = commonPath + "places/" + destination.getLocation() + ".txt";
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
	
	public static void seeLandmarkScreen(Scanner mainScanner, User currUser) throws IOException {
		if(currUser.getDestinations().size() == 0) {
			System.out.println("You don't have any saved destinations yet. You need to add one before you can see landmarks!\n");
			return;
		}
		
		System.out.println("For which of your destinations would you like to see your saved landmarks? (type '#')");
		
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
			if (!isNumeric(selection)) {
				System.out.println("Please type numeric value.");
				continue; 
			}
			int num = Integer.parseInt(selection);
			
			if(num > 0 && num <= destinationList.size()) {
				validCommand = true;
				
				if(!destinationList.get(num-1).getLandmarks().isEmpty()) {
					destinationList.get(num-1).seeAllLandmarks(currUser);
				} else {
					System.out.println("You don't have any landmarks added yet for this destination. Let's add some!");
				}
				return;
				
			} else {
				System.out.println("Please input a valid option.");
			}
		}
	}
	
	public static void seePeersScreen(Scanner mainScanner, User currUser) throws IOException {
		if(currUser.getDestinations().size() == 0) {
			System.out.println("You don't have any saved destinations yet. You need to add one before you can see peers!\n");
			return;
		}
		
		System.out.println("For which of your destinations would you like to see peers who also want to visit this place? (type '#')");
		
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
			if (!isNumeric(selection)) {
				System.out.println("Please type numeric value.");
				continue; 
			}
			int num = Integer.parseInt(selection);
			
			if(num > 0 && num <= destinationList.size()) {
				validCommand = true;
				destinationList.get(num-1).seeAllPeers();
				
				if(destinationList.get(num-1).getTotalNumberOfPeers() == 0) {
					System.out.println("There are no peers who want to visit this place yet.");
				}
				return;
			} else {
				System.out.println("Please input a valid option.");
			}
		}
	}
	
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}

}
