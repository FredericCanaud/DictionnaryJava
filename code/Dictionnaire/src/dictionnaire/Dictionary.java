package dictionnaire;

import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
	private String name;
	private HashMap<String, ArrayList<String>> translations;
	
	public Dictionary(String name) {
		this.name = name;
		this.translations = new HashMap<String, ArrayList<String>>();
	}

	public String getName() {
		return name;
	}
	
	public HashMap<String, ArrayList<String>> getTranslations(){
		return this.translations;
	}
	
	public void addTranslation(String word, String translation) {
		if (null == this.translations.get(word)) {
			this.translations.put(word, new ArrayList<String>());
		}
		this.translations.get(word).add(translation);
	}
	
	public String getTranslation(String word) {
		if (null == this.translations.get(word)) {
			return null;
		}
		return this.translations.get(word).get(0);
	}

	public ArrayList<String> getMultipleTranslations(String word) {
		return this.translations.get(word);
	}
}
