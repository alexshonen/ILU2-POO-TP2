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
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolé " + nomVendeur
					+ " mais il faut être une habitant de notre village pour commercer ici");
		}
		else {
			System.out.println("Bonjour " + nomVendeur
					+ " je vais regarder si je peux vous trouver un étal");
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolé " + nomVendeur
						+ " , je n'ai plus d'étal qui ne soit pas déjà occupé");
			}
			else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous !\n");
		System.out.println("Il me faudrait quelques renseignements :\n");
		System.out.println("Quel produit souhaitez-vous vendre ?");
		String produit = scan.nextLine();
		StringBuilder nombreProduits = new StringBuilder();
		nombreProduits.append("Combien souhaitez-vous en vendre ?");
		int nbProduits = Clavier.entrerEntier(nombreProduits.toString());
		int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduits);
		if (numEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + (numEtal + 1));
		}
	}
}
