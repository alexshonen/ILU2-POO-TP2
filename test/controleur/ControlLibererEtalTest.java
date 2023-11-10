package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	Village village;
	ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	ControlLibererEtal control;
	ControlPrendreEtal controlPrendreEtal;
	ControlVerifierIdentite controlVerifID;
	Gaulois bonemine;
	Gaulois asterix;
	
	@BeforeEach
	void setUp() throws Exception {
		village = new Village("le village des irréductibles", 10, 5);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		control = new ControlLibererEtal(controlTrouverEtalVendeur, village);
		controlVerifID = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifID, village);
		Gaulois bonemine = new Gaulois("bonemine", 2);
		village.ajouterHabitant(bonemine);
		Gaulois asterix = new Gaulois ("asterix", 7);
		village.ajouterHabitant(asterix);
		controlPrendreEtal.prendreEtal("bonemine", "fleurs", 5);
	}

	@Test
	void testControlLibererEtal() {
		assertNotNull(control);
	}

	@Test
	void testIsVendeur() {
		assertTrue(control.isVendeur("bonemine"));
		assertFalse(control.isVendeur("asterix"));
	}

	@Test
	void testLibererEtal() {
		String[] buff = control.libererEtal("bonemine");
		assertEquals("bonemine", buff[1]);
	}
}
