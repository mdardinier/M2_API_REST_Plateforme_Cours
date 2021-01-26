package fr.ul.miage.m2.sid.plateformecours;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarteBancaireTests {

	@Test
	void numeroCarteValide() {
		assertTrue(VerificationCarteBancaire.formatNumeroCarteValide("123456781234"));
	}
	
	@Test
	void numeroCarteInvalide1() {
		assertFalse(VerificationCarteBancaire.formatNumeroCarteValide("123456789"));
	}

	@Test
	void numeroCarteInvalide2() {
		assertFalse(VerificationCarteBancaire.formatNumeroCarteValide("123456789123A"));
	}
	
	@Test
	void dateExpirationValide() {
		assertTrue(VerificationCarteBancaire.datExpirationValide("12/2022"));
	}
	
	@Test
	void dateExpirationInvalide() {
		assertFalse(VerificationCarteBancaire.datExpirationValide("12/2020"));
	}
	
	@Test
	void codeCarteValide() {
		assertTrue(VerificationCarteBancaire.codeCarteValide("123456781234", "1234"));
	}
	
	@Test
	void codeCarteInvalide1() {
		assertFalse(VerificationCarteBancaire.codeCarteValide("123456781234", "3456"));
	}
	
	@Test
	void codeCarteInvalide2() {
		assertFalse(VerificationCarteBancaire.codeCarteValide("56781234", "1234"));
	}
	
	@Test
	void transactionBancaireValide() {
		assertTrue(VerificationCarteBancaire.transactionBancaireValide("123456781234", "12/2022", "1234"));
	}
	
	@Test
	void transactionBancaireInvalide1() {
		assertFalse(VerificationCarteBancaire.transactionBancaireValide("56781234", "12/2022", "1234"));
	}
	
	@Test
	void transactionBancaireInvalide2() {
		assertFalse(VerificationCarteBancaire.transactionBancaireValide("123456781234", "12/2020", "1234"));
	}
	
	@Test
	void transactionBancaireInvalide3() {
		assertFalse(VerificationCarteBancaire.transactionBancaireValide("123456781234", "12/2022", "1235"));
	}
}
