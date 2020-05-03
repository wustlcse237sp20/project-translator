package translator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Translator {

	public static void getTranslatorScreen(Scanner mainScanner) throws IOException {
		
		System.out.println("###########################################################");
		System.out.println("#                 Welcome to Translator!                  #");
		System.out.println("###########################################################\n");
		
		inputTranslation(mainScanner);
		return;
	}
	
	
	/**
     * Checks to see if both input and output languages are valid
     * 
     * @param inputText the input that the user provided
     */
	public static boolean isValidInput(String inputText) {
		String[] sp = inputText.split(" ");
		String src = sp[0].substring(0,1).toUpperCase() + sp[0].substring(1).toLowerCase();
		String dst = sp[1].substring(0,1).toUpperCase() + sp[1].substring(1).toLowerCase();
		return LanguageMap.languageExists(src) && LanguageMap.languageExists(dst);
	}
	
	/**
     * Gets the language abbreviation needed for Google API
     * 
     * @param targetLanguage the language that needs to be turned into its abbreviated form
     */
	public static String languageAbbr(String targetLanguage) {
		return LanguageMap.getAbbr(targetLanguage);
	}
	
	/**
     * Translates the user's input to the desired language
     * 
     * @param mainScanner to get the user input from command line
     */
	public static void inputTranslation(Scanner mainScanner) throws IOException {
		InputTranslate inputTranslate = new InputTranslate();
		
		System.out.println("Please type {Source language}, {Destination language}, {Texts of the source language}");
		System.out.println("I.E. {English} {Spanish} {Quarantine sucks.}");
		
		boolean validInput = false;

		while (!validInput) {
			String selectionInputTranslate = mainScanner.nextLine();
			if (isValidInput(selectionInputTranslate)) { // Then perform a translation job.
				validInput = true;
				
				String[] sp = selectionInputTranslate.split(" ");
				String src = sp[0].substring(0,1).toUpperCase() + sp[0].substring(1).toLowerCase();
				String dst = sp[1].substring(0,1).toUpperCase() + sp[1].substring(1).toLowerCase();
				
				String [] arr = selectionInputTranslate.split(" ", 2)[1].split(" ", 2);
				String targetTexts = arr[1];
				
				System.out.println(inputTranslate.translateInput(targetTexts, languageAbbr(src), languageAbbr(dst)));
				System.out.println("\nThank you for using Translator! We will take you back to the main screen now.\n");
			} else {
				System.out.println("Please try again. Please type {Source language}, {Destination language}, {Texts of the source language}");	
				System.out.println("I.E. {English} {Spanish} {Quarantine sucks.}");
			}
		}
	}
}
