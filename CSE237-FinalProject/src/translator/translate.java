package translator;

import java.util.Scanner;

public class translate {

	public static void main(String[] args) {

		System.out.println("Welcome to Translator!\n\nHow would you like to translate? Please select from the following:");
		System.out.println("1. Manually input statement");
		System.out.println("2. By file");
		System.out.println("3. By image");
		
		try(Scanner scanner = new Scanner(System.in)) {
			String selection = scanner.nextLine();
			System.out.println("You have chosen " + selection);
		}
		
		System.out.println("Thank you for using Translator!");
	}

}
