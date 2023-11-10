package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	Village village;
	ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	ControlVerifierIdentite controlVerifierIdentite;
	ControlAcheterProduit control;
	ControlLibererEtal controlLibererEtal;
	ControlPrendreEtal controlPrendreEtal;
	

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("le village des irréductibles", 10, 5);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		control = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur, village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
	}

	@Test
	void testControlAcheterProduit() {
		assertNotNull(control);
	}

	@Test
	void testTrouverProduit() {
		Gaulois bonemine = new Gaulois("bonemine", 2);
		village.ajouterHabitant(bonemine);
		controlPrendreEtal.prendreEtal("bonemine", "fleurs", 5);
		Gaulois[] buff = control.trouverProduit("fleurs");
		assertEquals(buff[0], bonemine);
	}

	@Test
	void testGetEtal() {
		Gaulois bonemine = new Gaulois("bonemine", 2);
		village.ajouterHabitant(bonemine);
		controlPrendreEtal.prendreEtal("bonemine", "fleurs", 5);
		Etal etal = control.getEtal(bonemine);
		Gaulois vendeur = etal.getVendeur();
		String[] donneesEtal = etal.etatEtal();
		assertEquals(vendeur.getNom(), donneesEtal[1]);
		
	}

}
