package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	Village village;
	ControlAfficherVillage control;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("le village des irréductibles", 10, 5);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		control = new ControlAfficherVillage(village);
	}

	@Test
	void testControlAfficherVillage() {
		assertNotNull(control);
	}

	@Test
	void testDonnerNomsVillageois() {
		String[] villageois = {"Abraracourcix"};
		assertArrayEquals(control.donnerNomsVillageois(), villageois);
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals(control.donnerNomVillage(), "le village des irréductibles");
	}

	@Test
	void testDonnerNbEtals() {
		assertEquals(control.donnerNbEtals(), 5);
	}

}
