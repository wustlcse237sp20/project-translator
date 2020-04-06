package translator;

import java.io.IOException;

import translator.TranslateAPI;

public class InputTranslate {

	public String translateInput(String input, String inLanguage, String outLanguage) throws IOException {
		// TODO Auto-generated method stub
		return TranslateAPI.Translate(input, inLanguage, outLanguage);
	}
}
