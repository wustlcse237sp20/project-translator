package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import translator.InputTranslate;

class InputTest {
	
	private InputTranslate translate;
	
	@BeforeEach
	void setupTestingInput() {
		translate = new InputTranslate();
	}

	@Test
	void testInput() throws IOException {
		// run behavior
		translate.translateInput("hello world", "es", "en");
		// assert result :assertEquals(a, b)
		assertEquals(translate.translateInput("Hello world", "en", "es"), "hola mundo");
		assertEquals(translate.translateInput("Hello world", "en", "fr"), "bonjour le monde");
	}
}
