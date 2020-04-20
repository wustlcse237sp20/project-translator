package userActivities;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import destination.User;
import translator.Translator;

import java.io.FileWriter; 
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import encryption.BCrypt;

public class Travel {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Welcome to Travel app!");
		
		try(Scanner mainScanner = new Scanner(System.in)) {
			startScreen(mainScanner);
		}
	}
	
	
	public static void startScreen(Scanner mainScanner) {
		
		System.out.println("If you want to login with your existing information, type 'sign in'. ");
		System.out.println("If you want to sign up, type 'sign up'.");
		System.out.println("To quit, type 'quit'");
		System.out.println("At anytime, you can type 'main screen' to come back to this screen");
		
		boolean validCommand = false;
	
		while (!validCommand) {
			String selection = mainScanner.nextLine();
			if (selection.equals("sign in")) {
				validCommand = true;
				signIn(mainScanner);

			} else if (selection.equals("sign up")) {
				validCommand = true;
				signUp(mainScanner);
			} else if (selection.equals("quit")) {
				System.out.println("Application closed");	
				return;
			} else {
				System.out.println("we did not understand your command");
				System.out.println("Type 'sign in', 'sign up', or 'quit'");
			}
		}
	}
	
	
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
				goBackToMainScreen(newUsername, mainScanner);
				
				if (pattern.matcher(newUsername).matches()) {
				
					pathToFile = "src/credentials/"+newUsername+".txt";
					File accountInfoFile = new File(pathToFile);
					
					if (accountInfoFile.exists()) {
		
						System.out.println("Username already exists");
						
					} else {
						try {
							accountInfoFile.createNewFile();
							validUsername = true;
						} catch (IOException e) {
							System.out.println("Error occured in craeting accountInfo file");
							e.printStackTrace();
						}
					}
				}
			}
			
			while (!validPassword) {
				System.out.println("Type in your desired password");
				
				String newPassword = mainScanner.nextLine();
				goBackToMainScreen(newPassword, mainScanner);
				
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
				goBackToMainScreen(userCity, mainScanner);				
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
				goBackToMainScreen(userCountry, mainScanner);
				
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
			
		startScreen(mainScanner);
	}
	
	public static void signIn(Scanner mainScanner) {
		
		boolean validUsername = false;
		boolean validPassword = false;
		
		while (!validUsername) {
			
			System.out.println("Log In");
			System.out.println("Please type in your ID");
			
			String username = mainScanner.nextLine();
			
			goBackToMainScreen(username, mainScanner);
			
			String pathToFile = "src/credentials/"+username+".txt";
			File accountInfoFile = new File(pathToFile);
			
			if (!accountInfoFile.exists()) {
				System.out.println("Username does not exist");
			} else {
				
				validUsername = true;
				Path filePath = Paths.get(pathToFile);
				
				while (!validPassword) {

					System.out.println("Please type in your Password");
					String inputPassword = mainScanner.nextLine();
					goBackToMainScreen(inputPassword, mainScanner);
					
					try {
						String password = Files.lines(filePath).findFirst().get();
						if (BCrypt.checkpw(inputPassword, password)) {
							validPassword = true;
							System.out.println("Successfully logged in!");
							dashboard(mainScanner, username);
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
	
	public static void goBackToMainScreen(String input, Scanner thisScanner) {
		if (input.contentEquals("main screen")) {
			startScreen(thisScanner);
		}
	}
	
	
	// Main functionalities of our app will all happen here. 	
	public static void dashboard(Scanner mainScanner, String userName) throws IOException {
		System.out.println("Welcome " +userName+"!");
		System.out.println("What would you like to do today? Please select from the following: ");
		System.out.println("1. Translate (type '1') ");
		
		boolean validChoice = false;
		
		while (!validChoice) {
			String selection = mainScanner.nextLine();
			
			if (selection.equals("1")) {
				validChoice = true;
				Translator.getTranslatorScreen(mainScanner);
				
				dashboard(mainScanner, userName);
			} else {
				System.out.println("Sorry, other options are not valid yet. Please try again.");
			}
		}

		String pathToFile = "src/credentials/"+userName+".txt";
		File accountInfoFile = new File(pathToFile);		
		Path filePath = Paths.get(pathToFile);
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
		
		User currUser;
		if (userCity != null && userCountry != null) {
			currUser = new User(userName, userCity, userCountry);
		}
	}
}
