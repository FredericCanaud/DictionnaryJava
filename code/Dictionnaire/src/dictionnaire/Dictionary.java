package dictionnaire;

import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
	private String name;
	private HashMap<String, ArrayList<String>> translations;
	private HashMap<String, ArrayList<String>> reverseTranslations;
	
	public Dictionary(String name) {
		this.name = name;
		this.translations = new HashMap<String, ArrayList<String>>();
		this.reverseTranslations = new HashMap<String, ArrayList<String>>();
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
		this.addReverseTranslation(word, translation);
	}
	
	public void addReverseTranslation(String word, String translation) {
		if (null == this.reverseTranslations.get(translation)) {
			this.reverseTranslations.put(translation, new ArrayList<String>());
		}
		this.reverseTranslations.get(translation).add(word);
	}
	
	public String getTranslation(String word) throws TranslationNotFoundException {
		if (null == this.translations.get(word)) {
			throw new TranslationNotFoundException();
		}
		return this.translations.get(word).get(0);
	}

	public ArrayList<String> getMultipleTranslations(String word) throws TranslationNotFoundException {
		if (null == this.translations.get(word)) {
			throw new TranslationNotFoundException();
		}
		return this.translations.get(word);
	}
	
	
	
	public String getReverseTranslation(String word) throws TranslationNotFoundException {
		if (null == this.reverseTranslations.get(word)) {
			throw new TranslationNotFoundException();
		}
		return this.reverseTranslations.get(word).get(0);
	}

	public ArrayList<String> getMultipleReverseTranslations(String word) throws TranslationNotFoundException {
		if (null == this.reverseTranslations.get(word)) {
			throw new TranslationNotFoundException();
		}
		return this.reverseTranslations.get(word);
	}
}
