package userActivities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

import destination.User;
import encryption.BCrypt;

public class Credentials {

	static String userDirectory = Paths.get("")
            .toAbsolutePath()
            .toString();
	
	/*
	 * Use first commonPath if you are on command line. 
	 * User second commonPath if you are in eclipse. 
	 */
	
	static String commonPath = userDirectory + "/credentials/";  // For command line. 
//	 static String commonPath = "src/credentials/"; 							// For eclipse. 

	
	/**
     * Adds a new user info and writes it to file
     * 
     * @param mainScanner to get the user input from command line
     */
	public static void signUp(Scanner mainScanner) {
		
		boolean validUsername = false;
		boolean validPassword = false;
		boolean validCity = false; 
		boolean validCountry = false; 
		String newUsername = "";
		String pathToFile = "";
		String userCity = "";
		String userCountry = "";
	    
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
			
			while (!validUsername) {

				System.out.println("Type in your desired username");
				System.out.println("Your username must be alphaneumerical (no spaces)");
				
				newUsername = mainScanner.nextLine();
				Travel.goBackToMainScreen(newUsername, mainScanner);
				
				if (pattern.matcher(newUsername).matches()) {
					pathToFile = commonPath + newUsername+".txt";
					File accountInfoFile = new File(pathToFile);
					
					if (accountInfoFile.exists()) {
		
						System.out.println("Username already exists");
						
					} else {
						try {
							accountInfoFile.createNewFile();
							validUsername = true;
						} catch (IOException e) {
							System.out.println("Error occured in creating accountInfo file");
							e.printStackTrace();
						}
					}
				}
			}
			
			while (!validPassword) {
				System.out.println("Type in your desired password");
				
				String newPassword = mainScanner.nextLine();
				Travel.goBackToMainScreen(newPassword, mainScanner);
				
				System.out.println("Type in your desired password again");
				
				if (newPassword.equals(mainScanner.nextLine())) {
					String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
					try {
						FileWriter myWriter = new FileWriter(pathToFile, true);
						myWriter.write(hashedPassword+"\n");
						myWriter.close();
						validPassword = true;
					} catch (IOException e) {
						System.out.println("Error occured while creating new ID");
						e.printStackTrace();
					}
				}
			}
			while (!validCity) {
				System.out.println("Type in the city you are from");
				userCity = mainScanner.nextLine();
				Travel.goBackToMainScreen(userCity, mainScanner);				
				try {
					FileWriter myWriter = new FileWriter(pathToFile, true);
					myWriter.write(userCity+"\n");
					myWriter.close();
					validCity = true;
				} catch (IOException e) {
					System.out.println("Error occured while typing location information");
					e.printStackTrace();
				}				
			}			
			while (!validCountry) {
				System.out.println("Type in the country you are from");
				userCountry = mainScanner.nextLine();
				Travel.goBackToMainScreen(userCountry, mainScanner);
				
				try {
					FileWriter myWriter = new FileWriter(pathToFile, true);
					myWriter.write(userCountry+"\n");
					myWriter.close();
					validCountry = true;
					System.out.println("Account created!");					
				} catch (IOException e) {
					System.out.println("Error occured while typing location information");
					e.printStackTrace();
				}				
				
			}			
			
		Travel.startScreen(mainScanner);
	}
	
	/**
     * Logs in an existing user and their info
     * 
     * @param mainScanner to get the user input from command line
     */
	public static void signIn(Scanner mainScanner) {
		
		boolean validUsername = false;
		boolean validPassword = false;
		
		while (!validUsername) {
			
			System.out.println("Please type in your ID");
			
			String username = mainScanner.nextLine();
			
			Travel.goBackToMainScreen(username, mainScanner);
			
			String pathToFile = commonPath +username+".txt";
			File accountInfoFile = new File(pathToFile);
			
			if (!accountInfoFile.exists()) {
				System.out.println("Username does not exist");
			} else {
				
				validUsername = true;
				Path filePath = Paths.get(pathToFile);
				
				while (!validPassword) {

					System.out.println("Please type in your Password");
					String inputPassword = mainScanner.nextLine();
					Travel.goBackToMainScreen(inputPassword, mainScanner);
					
					try {
						String password = Files.lines(filePath).findFirst().get();
						if (BCrypt.checkpw(inputPassword, password)) {
							validPassword = true;
							System.out.println("Successfully logged in!\n");
							
							
							String userCity = "";
							String userCountry = "";
							try {
								Iterator iter = Files.lines(filePath).iterator();
								iter.next();
								userCity = iter.next().toString();
								userCountry = iter.next().toString();
							} catch (IOException e) {
								System.out.println("Error occured while checking for password");
								e.printStackTrace();
							}	
							
							User currUser = null;
							if (userCity != null && userCountry != null) {
								currUser = new User(username, userCity, userCountry);
							}
							
							// restore currUser's old info
							Persistence.restoreDestinations(currUser);
							
							Travel.dashboard(mainScanner, currUser);
						} else {
							System.out.println("Incorrect Password");
						}
					} catch (IOException e) {
						System.out.println("Error occured while checking for password");
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	/**
     * Logs out the current signed in user
     * 
     * @param mainScanner to get the user input from command line
     */
	public static void signOut(Scanner mainScanner) {
		System.out.println("You have successfully signed out.\n\n");
		Travel.startScreen(mainScanner);
	}
}
