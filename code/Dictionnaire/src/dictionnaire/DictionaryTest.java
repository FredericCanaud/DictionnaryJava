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

	// EXERCICE 1
	
	@Test
	public void initialisation(){
		assertEquals("francaisAnglais", dico.getName());
	}
	
	@Test
	public void traductionsVideAuDebut() {
		assertEquals(0, dico.getTranslations().size());
	}
	
	
	// EXERCICE 2
	
	@Test
	public void ajoutDeTraductionDonneTraduction() {
		this.dico.addTranslation("oui", "yes");
		assertEquals("yes", this.dico.getTranslation("oui"));
	}
	
	@Test
	public void pasDeTraductionDonneNull() {
		assertEquals(null, this.dico.getTranslation("oui"));
	}
	
	
	// EXERCICE 3
	
	@Test
	public void multipleTraductionDonneTraductions() {
		this.dico.addTranslation("oui", "yes");
		this.dico.addTranslation("oui", "yeah");
		this.dico.addTranslation("oui", "yop");
		
		assertTrue(this.dico.getMultipleTranslations("oui").contains("yeah"));
		assertTrue(this.dico.getMultipleTranslations("oui").contains("yes"));
		assertTrue(this.dico.getMultipleTranslations("oui").contains("yop"));
	}
	
	@Test
	public void pasMultipleTraductionDonneNull() {
		assertEquals(null, this.dico.getMultipleTranslations("oui"));
	}
	
	
	// EXERCICE 4
	
	@Test
	public void reverseTraductionsVideAuDebut() {
		assertEquals(0, dico.getTranslations().size());
	}
	
	@Test
	public void ajoutDeTraductionDonneTraductionInverse() {
		this.dico.addTranslation("oui", "yes");
		assertEquals("oui", this.dico.getReverseTranslation("yes"));
	}
	
	@Test
	public void pasDeReverseTraductionDonneNull() {
		assertEquals(null, this.dico.getReverseTranslation("yes"));
	}
	
	@Test
	public void multipleReverseTraductionDonneTraductions() {
		this.dico.addTranslation("justice", "law");
		this.dico.addTranslation("loi", "law");
		this.dico.addTranslation("droit", "law");
		
		assertTrue(this.dico.getMultipleReverseTranslations("law").contains("justice"));
		assertTrue(this.dico.getMultipleReverseTranslations("law").contains("loi"));
		assertTrue(this.dico.getMultipleReverseTranslations("law").contains("droit"));
	}
	
	@Test
	public void pasMultipleReverseTraductionDonneNull() {
		assertEquals(null, this.dico.getMultipleReverseTranslations("yes"));
	}
	
} 
