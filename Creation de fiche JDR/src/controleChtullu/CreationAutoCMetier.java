package controleChtullu;

import java.util.ArrayList;

import vueChtullu.DataChtullu;

public class CreationAutoCMetier implements DataChtullu{
	// permet de calculer automatique les competence metier du perso
	private ArrayList<String> caractPerso = new ArrayList<String>();
	private int[] competenceInit = { 0, 0, 5, 0, 0, 5, 25, 0, 0, 10, 20, 0, 15, 10, 15, 5, 25, 10, 0, 0, 40, 20, 10, 25,
			0, 0, 5, 20, 5, 5, 0, 25, 10, 5, 15, 0, 10, 0, 0, 30, 0, 5, 25, 10, 0, 10, 25, 20, 25, 30, 15, 15, 25, 50,
			10, 25, 0, 0, 0, 0, 0, 0, 0 };
	private ArrayList compMetierPerso = new ArrayList();
	private ArrayList<Boolean> competenceBool = new ArrayList<Boolean>();
	private int compInit, compTemp;
	private int ran = 0;

	public CreationAutoCMetier(ArrayList<String> caractPerso, ArrayList<Boolean> competenceBool) {
		this.caractPerso = caractPerso;
		this.competenceBool = competenceBool;
		compInit = (Integer.parseInt(caractPerso.get(16).toString())) * 20;
		for (int j = 0; j < competence.length; j++) {
			compMetierPerso.add(competenceInit[j]);
		}
		compTemp = 0;
		for (int i = 0; i < competence.length; i++) {
			if (competenceBool.get(i) == true) {
				compTemp++;
			}
		}
		for (int k = 0; k < competence.length; k++) {
			if (competenceBool.get(k) == true) {
				int temp, temp2 = 0;
				temp = (int) compMetierPerso.get(k);
				temp2 = temp + (compInit / compTemp);
				compMetierPerso.remove(k);
				compMetierPerso.add(k, temp2);
			}

		}
	}

	public void randomComp(int arg, int pos) {
		int temp, temp2 = 0;
		ran = (int) ((Math.random() * arg) + 1);
		temp = (int) compMetierPerso.get(pos);
		temp2 = temp + ran;
		compMetierPerso.remove(pos);
		compMetierPerso.add(pos, temp2);
	}

	public ArrayList getMetierPerso() {
		return compMetierPerso;
	}

}
