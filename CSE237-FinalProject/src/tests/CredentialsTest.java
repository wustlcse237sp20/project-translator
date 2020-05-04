package tests;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import destination.Destination;
import destination.Landmark;
import destination.User;

public class CredentialsTest {


	private User testUser; 

	
	@BeforeEach
	void testCredentialsFiles() {
		String userDirectory = Paths.get("")
	            .toAbsolutePath()
	            .toString();
		String pathToHong = userDirectory+"/src/credentials/hong.txt";	
		File HongInfoFile = new File(pathToHong);
		assertTrue(HongInfoFile.exists());		
		
		String pathToMike = userDirectory+"/src/credentials/mike.txt";	
		File MikeInfoFile = new File(pathToHong);
		assertTrue(HongInfoFile.exists());		
	
		String pathToKaren = userDirectory+"/src/credentials/mike.txt";	
		File KarenInfoFile = new File(pathToHong);
		assertTrue(HongInfoFile.exists());		
	}

	@Test
	void testUserLocation() {
		
		String pathToHong = "src/credentials/hong.txt";	
		Path hongFilePath = Paths.get(pathToHong);
		String hongCity = "";
		String hongCountry = "";
		try {
			Iterator iter = Files.lines(hongFilePath).iterator();
			iter.next();
			hongCity = iter.next().toString();
			hongCountry = iter.next().toString();
			assertEquals(hongCity, "Seoul");
			assertEquals(hongCountry, "Korea");
		} catch (IOException e) {
			System.out.println("Error occured while checking Hong's location");
			e.printStackTrace();
		}	
		

		String pathToKaren = "src/credentials/karen.txt";	
		Path karenFilePath = Paths.get(pathToKaren);
		String karenCity = "";
		String karenCountry = "";
		try {
			Iterator iter = Files.lines(karenFilePath).iterator();
			iter.next();
			karenCity = iter.next().toString();
			karenCountry = iter.next().toString();
			assertEquals(karenCity, "St. Louis");
			assertEquals(karenCountry, "USA");
		} catch (IOException e) {
			System.out.println("Error occured while checking Hong's location");
			e.printStackTrace();
		}			
	}

}



