package userActivities;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import destination.User;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// Uncomment this if you want to try out translator
//import translator.Translator;


public class Travel {

	public static void main(String[] args) throws IOException {
		try(Scanner mainScanner = new Scanner(System.in)) {
			startScreen(mainScanner);
		}
		
	}
	
	
	public static void startScreen(Scanner mainScanner) {
		
		
		System.out.println("###########################################################");
		System.out.println("#                 Welcome to Travel App!                  #");
		System.out.println("###########################################################\n");
		
		
		System.out.println("To login, type 'sign in'");
		System.out.println("To sign up, type 'sign up'");
		System.out.println("To quit, type 'quit'");
		
		boolean validCommand = false;
	
		while (!validCommand) {
			String selection = mainScanner.nextLine();
			if (selection.equals("sign in")) {
				validCommand = true;
				Credentials.signIn(mainScanner);

			} else if (selection.equals("sign up")) {
				validCommand = true;
				Credentials.signUp(mainScanner);
			} else if (selection.equals("quit")) {
				System.out.println("Application closed");	
				return;
			} else {
				System.out.println("We did not understand your command");
				System.out.println("Type 'sign in', 'sign up', or 'quit'");
			}
		}
	}
	
	public static void goBackToMainScreen(String input, Scanner thisScanner) {
		if (input.contentEquals("main screen")) {
			startScreen(thisScanner);
		}
	}
	
	
	// Main functionalities of our app will all happen here. 	
	public static void dashboard(Scanner mainScanner, User currUser) throws IOException {
		
		System.out.println("###########################################################");
		System.out.println("                   WELCOME " + currUser.getUser().toUpperCase() +  "!");
		System.out.println("###########################################################\n");
		
		System.out.println("What would you like to do today? Please select from the following: ");
		System.out.println("1. Translate (type '1') -> this will only work in Eclipse because terminal doesn't have Google Cloud support. Follow instructions in README if you still want to try this out!");
		System.out.println("2. Add destination (type '2') ");
		System.out.println("3. Add landmark (type '3') ");
		System.out.println("4. See destinations (type '4') ");
		System.out.println("5. See landmarks (type '5') ");
		System.out.println("6. See peers (type '6') ");
		System.out.println("\nTo sign out, type 'sign out' ");
		System.out.println("To quit, type 'quit'");
		
		
		boolean validChoice = false;
		
		while (!validChoice) {
			String selection = mainScanner.nextLine();
			
			if (selection.equals("1")) {
				validChoice = true;
//				Translator.getTranslatorScreen(mainScanner);  uncomment this to use translator. 
				dashboard(mainScanner, currUser);
			} else if(selection.equals("2")) {
				validChoice = true;
				Dest.getDestinationScreen(mainScanner, currUser);
				dashboard(mainScanner, currUser);
			} else if(selection.equals("3")) {
				validChoice = true;
				Dest.getLandmarkScreen(mainScanner, currUser);
				dashboard(mainScanner, currUser);
			} else if(selection.equals("4")) {
				validChoice = true;
				if(currUser.getDestinations().isEmpty()) {
					System.out.println("You currently don't have any saved destinations. Let's add some!");
				} else {
					currUser.seeDestinations();
				}
				dashboard(mainScanner, currUser);
			} else if(selection.equals("5")) {
				validChoice = true;
				Dest.seeLandmarkScreen(mainScanner, currUser);
				dashboard(mainScanner, currUser);
			} else if(selection.equals("6")) {
				validChoice = true;
				Dest.seePeersScreen(mainScanner, currUser);
				dashboard(mainScanner, currUser);
			}
			else if (selection.equals("sign out")) {
				validChoice = true;
				Credentials.signOut(mainScanner);
			} else if (selection.equals("quit")) {
				validChoice = true;
				System.out.println("Application closed");	
				return;
			} else {
				System.out.println("Sorry, other options are not valid yet. Please try again.");
			}
		}
	}
}
