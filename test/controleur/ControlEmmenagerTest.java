package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	Village village;
	ControlEmmenager control;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("le village des irréductibles", 10, 5);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		control = new ControlEmmenager(village);
	}
	
	@Test
	void testControlEmmenager() {
		assertNotNull(control);
	}

	@Test
	void testIsHabitant() {
		control.ajouterGaulois("Asterix", 5);
		assertTrue(control.isHabitant("Asterix"));
		assertFalse(control.isHabitant("Obelix"));
	}

	@Test
	void testAjouterDruide() {
		control.ajouterDruide("Panoramix", 2, 1, 9);
		assertTrue(control.isHabitant("Panoramix"));
		assertFalse(control.isHabitant("Obelix"));
	}

	@Test
	void testAjouterGaulois() {
		control.ajouterGaulois("Asterix", 5);
		assertTrue(control.isHabitant("Asterix"));
		assertFalse(control.isHabitant("Obelix"));
	}

}
