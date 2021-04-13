package dictionnaire;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DictionaryTest {
	Dictionary dico;
	
	@Before
	public void init() {
		this.dico = new Dictionary("francaisAnglais");
	}

	@Test
	public void initialisation(){
		assertEquals("francaisAnglais", dico.getName());
	}
}
