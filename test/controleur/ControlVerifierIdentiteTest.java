package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	Village village;
	ControlVerifierIdentite control;

	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("le village des irréductibles", 10, 5);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		control = new ControlVerifierIdentite(village);

	}

	@Test
	void testControlVerifierIdentite() {
		assertNotNull(control);
	}

	@Test
	void testVerifierIdentite() {
		assertTrue(control.verifierIdentite("Abraracourcix"));
		assertFalse(control.verifierIdentite("Obelix"));
	}

}
