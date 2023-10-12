package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;
import controleur.ControlVerifierIdentite;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private ControlVerifierIdentite controlVerifierIdentite;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlVerifierIdentite.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolé " + nomVendeur
					+ " mais il faut être une habitant de notre village pour commercer ici");
		}
		else {
			System.out.println("Bonjour " + nomVendeur
					+ " je vais regarder si je peux vous trouver un étal");
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
