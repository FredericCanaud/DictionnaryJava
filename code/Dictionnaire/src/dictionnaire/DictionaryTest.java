package dictionnaire;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DictionaryTest {
	Dictionary dico;
	
	@BeforeEach
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
	public void ajoutDeTraductionDonneTraduction() throws TranslationNotFoundException {
		this.dico.addTranslation("oui", "yes");
		this.dico.getTranslation("oui");
	}
	
	@Test
	public void pasDeTraductionDonneException() {
		assertThrows(TranslationNotFoundException.class, () -> {
			this.dico.getTranslation("oui");
		});
	}
	
	
	// EXERCICE 3
	
	@Test
	public void multipleTraductionDonneTraductions() throws TranslationNotFoundException {
		this.dico.addTranslation("oui", "yes");
		this.dico.addTranslation("oui", "yeah");
		this.dico.addTranslation("oui", "yop");
		
		assertTrue(this.dico.getMultipleTranslations("oui").contains("yeah"));
		assertTrue(this.dico.getMultipleTranslations("oui").contains("yes"));
		assertTrue(this.dico.getMultipleTranslations("oui").contains("yop"));
	}
	
	@Test
	public void pasMultipleTraductionDonneException() {
		assertThrows(TranslationNotFoundException.class, () -> {
			this.dico.getMultipleTranslations("oui");
		});
	}
	
	
	// EXERCICE 4
	
	@Test
	public void reverseTraductionsVideAuDebut() {
		assertEquals(0, dico.getTranslations().size());
	}
	
	@Test
	public void ajoutDeTraductionDonneTraductionInverse() throws TranslationNotFoundException {
		this.dico.addTranslation("oui", "yes");
		assertEquals("oui", this.dico.getReverseTranslation("yes"));
	}
	
	@Test
	public void pasDeReverseTraductionDonneException() {
		assertThrows(TranslationNotFoundException.class, () -> {
			this.dico.getReverseTranslation("yes");
		});
	}
	
	@Test 
	public void multipleReverseTraductionDonneTraductions() throws TranslationNotFoundException {
		this.dico.addTranslation("justice", "law");
		this.dico.addTranslation("loi", "law");
		this.dico.addTranslation("droit", "law");
		
		assertTrue(this.dico.getMultipleReverseTranslations("law").contains("justice"));
		assertTrue(this.dico.getMultipleReverseTranslations("law").contains("loi"));
		assertTrue(this.dico.getMultipleReverseTranslations("law").contains("droit"));
	}
	
	@Test
	public void pasMultipleReverseTraductionDonneException() {
		assertThrows(TranslationNotFoundException.class, () -> {
			this.dico.getMultipleReverseTranslations("yes");
		});
	}
	
} 
