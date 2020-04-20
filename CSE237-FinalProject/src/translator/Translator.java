package translator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Translator {

	public static void getTranslatorScreen(Scanner mainScanner) throws IOException {
		
		System.out.println("Welcome to Translator!\n\nHow would you like to translate? Please select from the following:");
		System.out.println("1. Manually input statement");
		System.out.println("2. By image"); 
		OCRTranslate OCRTranslate = new OCRTranslate();
		
		boolean validChoice = false;

		while (!validChoice) {
			String selection = mainScanner.nextLine();
			System.out.println("You have chosen " + selection);
			
			if (selection.equals("1")) {
				validChoice = true;
				inputTranslation(mainScanner);
				
			} else if (selection.equals("2")) {
//				validChoice = true;
//				OCRTranslation(mainScanner);
				System.out.println("Sorry, this option is not valid yet. Please try again.");

			} else { 
				System.out.println("We did not understand your command");
				System.out.println("Type '1', or '2'");	
			}
		}
	}
	
	
	/*
	 * This method will first check if the user's input is valid. 
	 * 	However, the way to extract inputs from commandline is subject to change. 
	 * 	So, I won't finish isValidInput() logic until everything is finalized. 
	 */
	public static boolean isValidInput(String inputText) {
		// If inputText == ""
		// Else if Source language is not listed 
		// Else if Destination language is not listed. 
		// Else if Each section is not wrapped with brackets. 
		return true;
	}
	
	/*
	 * This method helps to serialize user's input into list of strings. 
	 * [0] will be source language, [1] will be destination language, [2[ will be texts.  
	 */	
	public static List<String> getInputs(String inputText) {
		List<String> res = new ArrayList<String>();
		res.add("en");
		res.add("es");
		res.add("This sentence is used to test our program's functionality. Your inputs are not executed. Sorry");
		return res; 
	}
	
	/*
	 * Google Translate API needs a language input like "en" for English.
	 * Since Google Translate API needs a language input like "en", this method is needed to change "English" to "en". 
	 * This method should be able to handle all languages we are trying to cover.
	 */
	public static String formattingLanguage(String targetLanguage) {
		String res = "";

		return res;
	}

	public static void inputTranslation(Scanner mainScanner) throws IOException {
		InputTranslate inputTranslate = new InputTranslate();
		
		System.out.println("Please type {Source language}, {Destination language}, {Texts of the source language}");
		System.out.println("I.E. {English} {Spanish} {Quarantine sucks.}");
		
		boolean validInput = false;

		while (!validInput) {
			String selectionInputTranslate = mainScanner.nextLine();
			if (isValidInput(selectionInputTranslate)) { // Then perform a translation job.
				validInput = true;
				List<String> serializedInput = getInputs(selectionInputTranslate);
				String srcLanguage = serializedInput.get(0);
				String destLanguage = serializedInput.get(1);
				String targetTexts = serializedInput.get(2);
				
				System.out.println(inputTranslate.translateInput(targetTexts, srcLanguage, destLanguage));
				System.out.println("\nThank you for using Translator! We will take you back to the main screen now.");
			} else {
				System.out.println("Please try again. Please type {Source language}, {Destination language}, {Texts of the source language}");	
				System.out.println("I.E. {English} {Spanish} {Quarantine sucks.}");
			}
		}
	}
	
	public static void OCRTranslation(Scanner mainScanner) {
		
	}

}
