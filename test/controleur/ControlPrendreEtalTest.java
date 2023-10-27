package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	Village village;
	ControlPrendreEtal control;
	ControlVerifierIdentite controlID;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("le village des irr√©ductibles", 10, 5);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlID = new ControlVerifierIdentite(village);
		control = new ControlPrendreEtal(controlID, village);
	}

	@Test
	void testControlPrendreEtal() {
		assertNotNull(control);
	}

	@Test
	void testResteEtals() {
		ControlEmmenager controlEmm = new ControlEmmenager(village);
		controlEmm.ajouterGaulois("Asterix", 6);
		control.prendreEtal("Asterix", "patates", 12);
		assertTrue(control.resteEtals());
		Village villageSansEtals = new Village("le village sans Ètals", 10, 0);
		ControlVerifierIdentite IDSansEtals = new ControlVerifierIdentite(villageSansEtals);
		ControlPrendreEtal controlSansEtals = new ControlPrendreEtal(IDSansEtals, villageSansEtals);
		assertFalse(controlSansEtals.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		ControlEmmenager controlEmm = new ControlEmmenager(village);
		controlEmm.ajouterGaulois("Asterix", 6);
		control.prendreEtal("Asterix", "patates", 12);
		assertEquals(1, control.prendreEtal("Asterix", "patates", 12));
	}

	@Test
	void testVerifierIdentite() {
		assertTrue(control.verifierIdentite("Abraracourcix"));
		assertFalse(control.verifierIdentite("Obelix"));
	}

}
