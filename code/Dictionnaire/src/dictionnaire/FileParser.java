package dictionnaire;

import java.io.BufferedReader;
import java.io.IOException;

public class FileParser {
	
	public Dictionary readFile(BufferedReader bufferedReader) throws IOException {
		String input = bufferedReader.readLine();
		if(input == null) {
			throw new IOException("Le fichier en paramètre est vide ou non lisible.");
		}
		Dictionary dictionary = new Dictionary(input);
		input = bufferedReader.readLine();
		while(input != null) {
			String[] words = input.split(";",2);
			if(words.length != 2) {
				throw new IOException("Erreur : Mauvais parsing.");
			}
			dictionary.addTranslation(input.split(";")[0], input.split(";")[1]);
			input = bufferedReader.readLine();
		}
		return dictionary;
	}
}
