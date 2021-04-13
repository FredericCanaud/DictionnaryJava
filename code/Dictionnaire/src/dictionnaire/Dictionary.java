package dictionnaire;

import java.util.HashMap;

public class Dictionary {
	private String name;
	private HashMap<String, String> translations;
	
	public Dictionary(String name) {
		this.name = name;
		this.translations = new HashMap<String, String>();
	}

	public String getName() {
		return name;
	}
	
	public HashMap<String, String> getTranslations(){
		return this.translations;
	}
	
	public void addTranslation(String word, String translation) {
		this.translations.put(word, translation);
	}
	
	public String getTranslation(String word) {
		return this.translations.get(word);
	}
}
