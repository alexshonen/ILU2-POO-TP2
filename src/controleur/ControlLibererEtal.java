package controleur;


import personnages.Gaulois;
import villagegaulois.*;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private Village village;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
		this.village = village;
	}

	public boolean isVendeur(String nomVendeur) {
		return (controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur) != null);
	}

	/**
	 * 
	 * @param produit
	 * @return donneesVente est un tableau de chaine contenant [0] : un boolean
	 *         indiquant si l'étal est occupé [1] : nom du vendeur [2] : produit
	 *         vendu [3] : quantité de produit à vendre au début du marché [4] :
	 *         quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		Gaulois vendeur = village.trouverHabitant(nomVendeur);
		Etal etal = village.rechercherEtal(vendeur);
		String[] donneesEtal = etal.etatEtal();
		etal.libererEtal();
		return donneesEtal;
	}

}
