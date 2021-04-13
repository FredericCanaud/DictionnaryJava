package dictionnaire;

import java.util.HashMap;

public class Dictionary {
	private String name;
	private HashMap<String, String> traductions;
	
	public Dictionary(String name) {
		this.name = name;
		this.traductions = new HashMap<String, String>();
	}

	public String getName() {
		return name;
	}
	
	
}
