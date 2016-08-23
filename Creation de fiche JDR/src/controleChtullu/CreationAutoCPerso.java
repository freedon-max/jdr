package controleChtullu;

import java.util.ArrayList;

import vueChtullu.DataChtullu;

public class CreationAutoCPerso implements DataChtullu{
	// permet de calculer automatiquement les competence personnelle du perso
	private ArrayList<String> caractPerso = new ArrayList<String>();
	
	private ArrayList compMetierPerso = new ArrayList();
	private ArrayList<Boolean> competenceBool = new ArrayList<Boolean>();
	private ArrayList competenceInit = new ArrayList();
	private ArrayList position = new ArrayList();
	private ArrayList compPPerso = new ArrayList();
	private ArrayList compGPerso = new ArrayList();

	private int compInit, compTemp;

	private int ran;

	public CreationAutoCPerso(ArrayList<String> caractPerso, ArrayList<Boolean> competenceBool,
			ArrayList compMetierPerso) {
		this.competenceBool = competenceBool;
		this.competenceInit = compMetierPerso;
		this.caractPerso = caractPerso;
		compInit = (Integer.parseInt(caractPerso.get(8).toString())) * 10;
		this.compPPerso = compMetierPerso;
		for (int i = 0; i < competence.length; i++) {
			if (competenceBool.get(i) == true) {
				compTemp++;
				position.add(i);
			}
		}
		for (int k = 0; k < 20; k++) {
			int temp, temp2 = 0;
			ran = (int) (Math.random() * compTemp);
			temp = (int) compPPerso.get((int) position.get(ran));
			temp2 = temp + (compInit / 10);
			compPPerso.remove((int) position.get(ran));
			compPPerso.add((int) position.get(ran), temp2);
		}
		initCompGeneral();

	}

	public ArrayList getPPerso() {
		return compGPerso;
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

	private void initCompGeneral() {
		final ArrayList<Boolean> competenceBoolIn = new ArrayList<Boolean>(competenceBool);
		final ArrayList<Boolean> competenceBoolOut = new ArrayList<Boolean>(initBool(competenceBool));

		int w;
		for (w = 0; w < competence.length; w++) {
			if (competenceBoolOut.get(w).equals(true)) {
				compGPerso.add(competenceInit.get(w));
			} else if (competenceBoolIn.get(w).equals(true)) {
				compGPerso.add(compPPerso.get(w));
			}
		}

	}

}
