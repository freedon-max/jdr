package controleChtullu;

import java.util.ArrayList;

import vueChtullu.DataChtullu;
import vueChtullu.FenetreChtullu2;
import vueChtullu.FenetreChtullu4;

public class TousAuto implements DataChtullu{
	// permet de creer le personnage automatique jusqu'a l'etape 4

	private int age;
	private String nom, sexe, nat, dipl, bd;
	private String prof = "Aucun";
	private int[] competenceInit = { 0, 0, 5, 0, 0, 5, 25, 0, 0, 10, 20, 0, 15, 10, 15, 5, 25, 10, 0, 0, 40, 20, 10, 25,
			0, 0, 5, 20, 5, 5, 0, 25, 10, 5, 15, 0, 10, 0, 0, 30, 0, 5, 25, 10, 0, 10, 25, 20, 25, 30, 15, 15, 25, 50,
			10, 25, 0, 0, 0, 0, 0, 0, 0 };
	
	private ArrayList<String> caractPerso = new ArrayList<String>();
	private ArrayList compGPerso = new ArrayList();
	private ArrayList compMetierPerso = new ArrayList();
	private ArrayList<Boolean> competenceBool = new ArrayList<Boolean>();

	public void TousAuto(String nom, String sexe) {
		this.nom = nom;
		this.sexe = sexe;

		CreationAuto auto = new CreationAuto(nom, sexe);
		caractPerso = auto.getRandom();
		this.competenceInit = initSpec();
		GestionMetierCht gestionM = new GestionMetierCht();
		competenceBool = gestionM.GestionMCht(caractPerso.get(4).toString());
		CreationAutoCMetier autoComp = new CreationAutoCMetier(caractPerso, competenceBool);
		compMetierPerso = autoComp.getMetierPerso();
		this.competenceBool = initBool(competenceBool);
		CreationAutoCPerso autoP = new CreationAutoCPerso(caractPerso, competenceBool, compMetierPerso);
		compGPerso = autoP.getPPerso();
		FenetreChtullu4 suiv = new FenetreChtullu4(caractPerso, compGPerso);

	}

	private int[] initSpec() {
		int temp1 = (Integer.parseInt(caractPerso.get(7).toString())) * 2;
		int temp2 = (Integer.parseInt(caractPerso.get(16).toString())) * 5;
		int[] competenceInit2 = { 0, 0, 5, 0, 0, 5, 25, 0, 0, 10, 20, 0, 15, 10, 15, 5, 25, 10, temp1, 0, 40, 20, 10,
				25, 0, temp2, 5, 20, 5, 5, 0, 25, 10, 5, 15, 0, 10, 0, 0, 30, 0, 5, 25, 10, 0, 10, 25, 20, 25, 30, 15,
				15, 25, 50, 10, 25, 0, 0, 0, 0, 0, 0, 0 };
		return competenceInit2;
	}

	private ArrayList<Boolean> initBool(ArrayList<Boolean> competenceBool) {
		int n;

		for (n = 0; n < competence.length; n++) {
			if ((competenceBool.get(n)).equals(true)) {
				competenceBool.remove(n);
				competenceBool.add(n, false);
			} else if ((competenceBool.get(n)).equals(false)) {
				competenceBool.remove(n);
				competenceBool.add(n, true);
			}
		}

		return competenceBool;
	}

}
