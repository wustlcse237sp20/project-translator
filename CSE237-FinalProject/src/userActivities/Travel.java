package userActivities;

import java.io.IOException;
import java.util.Scanner;

import translator.FileTranslate;
import translator.OCRTranslate;

public class Travel {

	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to Travel app! \n Did you already sing up to our app? If not you should sign up to explore our app.");
		System.out.println("If you want to login with your existing information, please type 'sign in'. ");
		System.out.println("If you want to sign up, please type 'sign up'.");
		
		try(Scanner scannerInMain = new Scanner(System.in)) {
			String selection = scannerInMain.nextLine();
			System.out.println("Okay, you want to " + selection);			
			if (selection.equals("sign in")) {
				signIn();

			} else if (selection.equals("sign up")) {
				signUp();
			}
			else { 
				// Do the selection again. Or terminate the program. 							
			}
			
		}
		System.out.println("Thank you for using Travel app!");
	}
	
	
	public static void signUp() {	
		// Get user credentials, their name, location, destinaiton via command line. 
		// And call "signUp" method from somewhere using the input user information. 
		// And direct the user into the "Dashboard Acvitiy"
		try(Scanner scannerInSignUp = new Scanner(System.in)) {						
		}		
	}
	
	public static void signIn() {
		
		// Get user credentials via command line. 
		// And call "signIn" method from somewhere using the input credentials. 
		// And direct the user into the "Dashboard Activity"
		try(Scanner scannerInSignIn = new Scanner(System.in)) {						
		}	
	}
	
	public static void dashboard() {
		// This is the method where a user plays around with our app. 
		// We might make it as a class if we want. 		
	}
}
