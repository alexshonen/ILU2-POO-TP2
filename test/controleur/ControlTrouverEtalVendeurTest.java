package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	Village village;
	ControlTrouverEtalVendeur control;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("le village des irréductibles", 10, 5);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		control = new ControlTrouverEtalVendeur(village);
	}

	@Test
	void testControlTrouverEtalVendeur() {
		assertNotNull(control);
	}

	@Test
	void testTrouverEtalVendeur() {
		ControlEmmenager controlEmm = new ControlEmmenager(village);
		ControlVerifierIdentite controlID = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPEtal = new ControlPrendreEtal(controlID, village);
		controlEmm.ajouterGaulois("Asterix", 5);
		Gaulois asterix = village.trouverHabitant("Asterix");
		controlPEtal.prendreEtal("Asterix", "patates", 12);
		Etal etalA = control.trouverEtalVendeur("Asterix");
		assertEquals(village.rechercherEtal(asterix), etalA);
		
	}

}
