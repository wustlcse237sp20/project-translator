package translator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Translator {

//	public static void main(String[] args) throws IOException {
//
//		System.out.println("Welcome to Translator!\n\nHow would you like to translate? Please select from the following:");
//		System.out.println("1. Manually input statement");
//		System.out.println("2. By file");
//		System.out.println("3. By image");
//		FileTranslate fileTranslate = new FileTranslate(); 
//		OCRTranslate OCRTranslate = new OCRTranslate();
//
//		try(Scanner scanner = new Scanner(System.in)) {
//			String selection = scanner.nextLine();
//			System.out.println("You have chosen " + selection);
//			
//			if (selection.equals("1")) {
//				inputTranslation();
//				
//			} else if (selection.equals("2")) {
//				fileTranslation();
//
//			} else if (selection.equals("3")) {
//				OCRTranslation();
//		
//			} else { 
//				// Do the selection again. Or terminate the program. 				
//			
//			}
//			
//		}
//		System.out.println("Thank you for using Translator!");
//	}
//	
//	
//	/*
//	 * This method will first check if the user's input is valid. 
//	 * 	However, the way to extract inputs from commandline is subject to change. 
//	 * 	So, I won't finish isValidInput() logic until everything is finalized. 
//	 */
//	public static boolean isValidInput(String inputText) {
//		// If inputText == ""
//		// Else if Source language is not listed 
//		// Else if Destination language is not listed. 
//		// Else if Each section is not wrapped with brackets. 
//		return true;
//	}
//	
//	/*
//	 * This method helps to serialize user's input into list of strings. 
//	 * [0] will be source language, [1] will be destination language, [2[ will be texts.  
//	 */	
//	public static List<String> getInputs(String inputText) {
//		List<String> res = new ArrayList<String>();
//		res.add("en");
//		res.add("es");
//		res.add("This sentence is used to test our program's functionality. Your inputs are not executed. Sorry");
//		return res; 
//	}
//	
//	/*
//	 * Google Translate API needs a language input like "en" for English.
//	 * Since Google Translate API needs a language input like "en", this method is needed to change "English" to "en". 
//	 * This method should be able to handle all languages we are trying to cover.
//	 */
//	public static String formattingLanguage(String targetLanguage) {
//		String res = "";
//
//		return res;
//	}
//
//	public static void inputTranslation() throws IOException {
//		InputTranslate inputTranslate = new InputTranslate();
//		System.out.println("Please type {Source language}, {Destination language}, {Texts of the source language}");
//		System.out.println("I.E. {English} {Spanish} {Quarantine sucks.}");
//		String selectionInputTranslate = "";
//		try(Scanner scannerInputTranslate = new Scanner(System.in)) {
//			selectionInputTranslate = scannerInputTranslate.nextLine();
//		}
//		if (isValidInput(selectionInputTranslate)) { // Then perform a translation job. 
//			List<String> serializedInput = getInputs(selectionInputTranslate);
//			String srcLanguage = serializedInput.get(0);
//			String destLanguage = serializedInput.get(1);
//			String targetTexts = serializedInput.get(2);
//			System.out.println(inputTranslate.translateInput(targetTexts, srcLanguage, destLanguage));
//		} else {
//			// If no valid input is provided, then simply terminate the program or ask the user again. 
//		}
//	}
//
//	
//	public static void fileTranslation() {
//		
//	}
//	public static void OCRTranslation() {
//		
//	}

}
