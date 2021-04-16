package dictionnaire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
	
	@Test
	public void videAuDebut() {
		assertEquals(0, dico.getTranslations().size());
	}
	
	@Test
	public void ajoutDeTraductionDonneTraduction() {
		this.dico.addTranslation("oui", "yes");
		assertEquals("yes", this.dico.getTranslation("oui"));
	}
	
	@Test
	public void pasDeTraductionDonneNull() {
		assertEquals(null, this.dico.getTranslation("oui"));
	}
	
	@Test
	public void multipleTraduction() {
		this.dico.addTranslation("oui", "yes");
		this.dico.addTranslation("oui", "yeah");
		this.dico.addTranslation("oui", "yop");
		
		assertTrue(this.dico.getMultipleTranslations("oui").contains("yeah"));
		assertTrue(this.dico.getMultipleTranslations("oui").contains("yes"));
		assertTrue(this.dico.getMultipleTranslations("oui").contains("yop"));
	}
} 
