package dictionnaire;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
	private String name; // nom du dictionnaire
	private HashMap<String, ArrayList<String>> translations; // HashMap des traductions
	private HashMap<String, ArrayList<String>> reverseTranslations; // HashMap des traductions inversées

	//////////////////////
	//// constructeur ////
	//////////////////////

	// constructeur de base
	public Dictionary(String name) {
		this.name = name;
		this.translations = new HashMap<String, ArrayList<String>>();
		this.reverseTranslations = new HashMap<String, ArrayList<String>>();
	}

	// constructeur avec le fichier de traduction
	public Dictionary(BufferedReader bufferedReader) throws IOException {
		FileParser fileParser = new FileParser();
		Dictionary result = fileParser.readFile(bufferedReader);
		this.name = result.name;
		this.translations = result.translations;
		this.reverseTranslations = result.reverseTranslations;
	}

	
	//////////////////////////////
	//// AJOUT DE TRADUCTIONS ////
	//////////////////////////////

	// ajout de traduction
	public void addTranslation(String word, String translation) {
		if (null == this.translations.get(word)) {
			this.translations.put(word, new ArrayList<String>());
		}
		this.translations.get(word).add(translation);
		this.addReverseTranslation(word, translation);
	}

	// ajout de traduction inversée
	private void addReverseTranslation(String word, String translation) {
		if (null == this.reverseTranslations.get(translation)) {
			this.reverseTranslations.put(translation, new ArrayList<String>());
		}
		this.reverseTranslations.get(translation).add(word);
	}

	
	///////////////////
	///// GETTERS /////
	///////////////////

	public String getName() {
		return name;
	}

	public HashMap<String, ArrayList<String>> getTranslations() {
		return this.translations;
	}

	// traduction simple
	public String getTranslation(String word) throws TranslationNotFoundException {
		if (null == this.translations.get(word)) {
			throw new TranslationNotFoundException();
		}
		return this.translations.get(word).get(0);
	}

	// traductions multiples
	public ArrayList<String> getMultipleTranslations(String word) throws TranslationNotFoundException {
		if (null == this.translations.get(word)) {
			throw new TranslationNotFoundException();
		}
		return this.translations.get(word);
	}

	// traduction inversée
	public String getReverseTranslation(String word) throws TranslationNotFoundException {
		if (null == this.reverseTranslations.get(word)) {
			throw new TranslationNotFoundException();
		}
		return this.reverseTranslations.get(word).get(0);
	}

	// traductions inversées multiples
	public ArrayList<String> getMultipleReverseTranslations(String word) throws TranslationNotFoundException {
		if (null == this.reverseTranslations.get(word)) {
			throw new TranslationNotFoundException();
		}
		return this.reverseTranslations.get(word);
	}
}
