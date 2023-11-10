package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	Village village;
	ControlAfficherMarche control;
	ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	ControlLibererEtal controlLibererEtal;
	ControlPrendreEtal controlPrendreEtal;
	ControlVerifierIdentite controlVerifID;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("le village des irréductibles", 10, 5);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		control = new ControlAfficherMarche(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur, village);
		controlVerifID = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifID, village);
	}

	@Test
	void testControlAfficherMarche() {
		assertNotNull(control);
	}

	@Test
	void testDonnerInfosMarche() {
		String[] buff = control.donnerInfosMarche();
		assertArrayEquals(buff, village.donnerEtatMarche());
		Gaulois bonemine = new Gaulois("bonemine", 2);
		village.ajouterHabitant(bonemine);
		controlPrendreEtal.prendreEtal("bonemine", "fleurs", 5);
		buff = control.donnerInfosMarche();
		assertArrayEquals(buff, village.donnerEtatMarche());
		
	}

}
