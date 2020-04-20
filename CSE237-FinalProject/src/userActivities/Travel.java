package userActivities;

import java.io.File;
import java.io.IOException; 
import java.util.Scanner;
import java.util.regex.Pattern;
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
				} else {
					System.out.println("we did not understand your command");
					System.out.println("Type 'sign in', 'sign up', or 'quit'");			
				}
			}
	}
	
	
	public static void signUp(Scanner mainScanner) {
		
		boolean validUsername = false;
		boolean validPassword = false;
		String newUsername = "";
		String pathToFile = "";
		
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
						System.out.println("Account created!");
					} catch (IOException e) {
						System.out.println("Error occured while creating new ID");
						e.printStackTrace();
					}
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
							dashboard(username);
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
	
	public static void dashboard(String username) {
		System.out.println("Welcome " +username+"!");
	}
}
