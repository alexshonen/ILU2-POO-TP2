 package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import controleur.ControlVerifierIdentite;
import personnages.Gaulois;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;
	private ControlVerifierIdentite controlVerifierIdentite;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit, ControlVerifierIdentite controlVerifierIdentite) {
		this.controlAcheterProduit = controlAcheterProduit;
		this.controlVerifierIdentite = controlVerifierIdentite;
		
	}

	public void acheterProduit(String nomAcheteur) {
		if(!controlVerifierIdentite.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis désolé " + nomAcheteur + " mais il faut être un habitant "
					+ "de notre village pour commercer ici");
		}
		else {
			System.out.println("Quel produit voulez-vous acheter ?");
			String nomProduit = scan.nextLine();
			Gaulois[] vendeurs = controlAcheterProduit.trouverProduit(nomProduit);
			if (vendeurs == null) {
				System.out.println("Désolé, personne ne vends ce produit au marché.");
			}
			else {
				StringBuilder choixVendeur = new StringBuilder();
				choixVendeur.append("Chez quel commerçant voulez-vous acheter des " + nomProduit + " ?\n");
				for (int i = 0; i < vendeurs.length; i++) {
					choixVendeur.append((i+1) + " - " + vendeurs[i].getNom() + "\n");
				}
				int numVendeur = Clavier.entrerEntier(choixVendeur.toString());
				Gaulois vendeur = vendeurs[numVendeur - 1];
				Etal etalVendeur = controlAcheterProduit.getEtal(vendeur);
				System.out.println(nomAcheteur + " se dirige jusqu'à l'étal du vendeur " + vendeur.getNom());
				StringBuilder choixQuantite = new StringBuilder();
				choixQuantite.append("Combien de " + nomProduit + " voulez-vous acheter ?");
				int quantiteAchat = Clavier.entrerEntier(choixQuantite.toString());
				int stockVendeur = etalVendeur.getQuantite();
				if (stockVendeur == 0) {
					System.out.println(nomAcheteur +" veut acheter "+ quantiteAchat + " " + nomProduit +" , malheureusement il n'y en a plus !");
				}
				else if (stockVendeur < quantiteAchat) {
					etalVendeur.acheterProduit(stockVendeur);
					System.out.println(nomAcheteur + " veut acheter " + quantiteAchat + " " + nomProduit + ", malheureusment "
							+ vendeur.getNom() + " n'en a plus que " + stockVendeur + ". " + nomAcheteur + " achète tout le stock de "
							+ vendeur.getNom());
				}
				else {
					etalVendeur.acheterProduit(quantiteAchat);
					System.out.println(nomAcheteur + " achète " + quantiteAchat + " " + nomProduit + " à " + vendeur.getNom());
				}
			}
		}
	}
}
