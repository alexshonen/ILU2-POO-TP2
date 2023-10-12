package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerVillageois(nomVisiteur);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder creationForce = new StringBuilder();
		StringBuilder creationPotionMin = new StringBuilder();
		StringBuilder creationPotionMax = new StringBuilder();
		
		creationForce.append("Bienvenue druide " + nomVisiteur + "\n");
		creationForce.append("Quelle est votre force ?");
		int force = Clavier.entrerEntier(creationForce.toString());
		
		creationPotionMin.append("Quelle est la force de potion la plus faible que vous produisez ?");
		creationPotionMax.append("Quelle est la force de potion la plus forte que vous produisez ?");
		int effetPotionMin = -1;
		int effetPotionMax = -1;
		do {
			effetPotionMin = Clavier.entrerEntier(creationPotionMin.toString());
			effetPotionMax = Clavier.entrerEntier(creationPotionMax.toString());
			if (effetPotionMax < effetPotionMin) {
				System.out.println("Attention Druide, vous vous êtes trompé entre le minimum et le maximum !");
			}
			
		} while (effetPotionMax < effetPotionMin);
		
		controlEmmenager.ajouterDruide(nomVisiteur, force, effetPotionMin, effetPotionMax);
	}
	
	private void emmenagerVillageois(String nomVisteur) {
		StringBuilder creationForce = new StringBuilder();
		
		creationForce.append("Bienvenue villageois " + nomVisteur + "\n");
		creationForce.append("Quelle est votre force ?");
		int force = Clavier.entrerEntier(creationForce.toString());
		
		controlEmmenager.ajouterGaulois(nomVisteur, force);
	}
}



















