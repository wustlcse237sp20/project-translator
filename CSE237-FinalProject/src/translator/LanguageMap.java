package translator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LanguageMap {
	private static final Map<String, String> languageMap;
	
    static {
        Map<String, String> myMap = new HashMap<>();
        myMap.put("Afrikaans", "af");
        myMap.put("Albanian", "sq");
        myMap.put("Amharic", "am");
        myMap.put("Arabic", "ar");
        myMap.put("Armenian", "hy");
        myMap.put("Azerbaijani","az");
        myMap.put("Basque", "eu");
        myMap.put("Belarusian", "be");
        myMap.put("Bengali", "bn");
        myMap.put("Bosnian", "bs");
        myMap.put("Bulgarian", "bg");
        myMap.put("Catalan", "ca");
        myMap.put("Cebuano", "ceb");
        myMap.put("Chinese", "zh-CN");
        myMap.put("Corsican", "co");
        myMap.put("Croatian", "hr");
        myMap.put("Czech", "cs");
        myMap.put("Danish", "da");
        myMap.put("Dutch", "nl");
        myMap.put("English", "en");
        myMap.put("Esperanto", "eo");
        myMap.put("Estonian", "et");
        myMap.put("Finnish", "fi");
        myMap.put("French", "fr");
        myMap.put("Frisian", "fy");
        myMap.put("Galician", "gl");
        myMap.put("Georgian", "ka");
        myMap.put("German", "de");
        myMap.put("Greek", "el");
        myMap.put("Gujarati", "gu");
        myMap.put("Haitian Creole", "ht");
        myMap.put("Hausa", "ha");
        myMap.put("Hawaiian", "haw");
        myMap.put("Hebrew", "he");
        myMap.put("Hindi", "hi");
        myMap.put("Hmong", "hmn");
        myMap.put("Hungarian", "hu");
        myMap.put("Icelandic", "is");
        myMap.put("Igbo", "ig");
        myMap.put("Indonesian", "id");
        myMap.put("Irish", "ga");
        myMap.put("Italian", "it");
        myMap.put("Japanese", "ja");
        myMap.put("Javanese", "jv");
        myMap.put("Kannada", "kn");
        myMap.put("Kazakh", "kk");
        myMap.put("Khmer", "km");
        myMap.put("Korean", "ko");
        myMap.put("Kurdish", "ku");
        myMap.put("Kyrgyz", "ky");
        myMap.put("Lao", "lo");
        myMap.put("Latin", "la");
        myMap.put("Latvian", "lv");
        myMap.put("Lithuanian", "lt");
        myMap.put("Luxembourgish", "lb");
        myMap.put("Macedonian", "mk");
        myMap.put("Malagasy", "mg");
        myMap.put("Malay", "ms");
        myMap.put("Malayalam", "ml");
        myMap.put("Maltese", "mt");
        myMap.put("Maori", "mi");
        myMap.put("Marathi", "mr");
        myMap.put("Mongolian", "mn");
        myMap.put("Myanmar", "my");
        myMap.put("Nepali", "ne");
        myMap.put("Norwegian", "no");
        myMap.put("Nyanja", "ny");
        myMap.put("Pashto", "ps");
        myMap.put("Persian", "fa");
        myMap.put("Polish", "pl");
        myMap.put("Portuguese", "pt");
        myMap.put("Punjabi", "pa");
        myMap.put("Romanian", "ro");
        myMap.put("Russian", "ru");
        myMap.put("Samoan", "sm");
        myMap.put("Scots Gaelic", "gd");
        myMap.put("Serbian", "sr");
        myMap.put("Sesotho", "st");
        myMap.put("Shona", "sn");
        myMap.put("Sindhi", "sd");
        myMap.put("Sinhala", "si");
        myMap.put("Slovak", "sk");
        myMap.put("Slovenian", "sl");
        myMap.put("Somali", "so");
        myMap.put("Spanish", "es");
        myMap.put("Sundanese", "su");
        myMap.put("Swahili", "sw");
        myMap.put("Swedish", "sv");
        myMap.put("Tagalog", "tl");
        myMap.put("Tajik", "tg");
        myMap.put("Tamil", "ta");
        myMap.put("Telugu", "te");
        myMap.put("Thai", "th");
        myMap.put("Turkish", "tr");
        myMap.put("Ukrainian", "uk");
        myMap.put("Urdu", "ur");
        myMap.put("Uzbek", "uz");
        myMap.put("Vietnamese", "vi");
        myMap.put("Welsh", "cy");
        myMap.put("Xhosa", "xh");
        myMap.put("Yiddish", "yi");
        myMap.put("Yoruba", "yo");
        myMap.put("Zulu", "zu");
        languageMap = Collections.unmodifiableMap(myMap);
    }
    
    public static boolean languageExists(String language) {
    	return languageMap.containsKey(language);
    }
    
    public static String getAbbr(String language) {
    	return languageMap.get(language);
    }
}
