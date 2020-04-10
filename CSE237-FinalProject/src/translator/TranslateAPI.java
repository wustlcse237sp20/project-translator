package translator;
import java.io.IOException;
 
import com.google.cloud.translate.*;

public class TranslateAPI {
	public static String Translate(String input, String inLanguage, String outLanguage) throws IOException {
		
		// limited to $20/1M characters for $300 balance free trial, please translate with reasonable siz
		System.setProperty("GOOGLE_API_KEY", "AIzaSyAi3rM_vZBOaLSwXPU6PGyJA3O-geVqWdA");
		
		Translate translate = TranslateOptions.getDefaultInstance().getService();
		Translation translation = translate.translate(
				input,
				Translate.TranslateOption.sourceLanguage(inLanguage),
				Translate.TranslateOption.targetLanguage(outLanguage));
		return translation.getTranslatedText().toLowerCase();
	}
}
