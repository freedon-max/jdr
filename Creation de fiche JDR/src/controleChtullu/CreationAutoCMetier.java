package controleChtullu;

import java.util.ArrayList;

public class CreationAutoCMetier {
	// permet de calculer automatique les competence metier du perso
	private ArrayList<String> caractPerso = new ArrayList<String>();
	private String[] competence = {"Anthropologie", "Archéologie", "Art", "Art Martiaux", "Astronomie", " Baratin", "Bibliothèque", "Camouflage", "Chimie", "Comptabilité", "Conduire Auto", "Conduire Engin Lourd", "Crédit", "Discrétion", "Dissimulation", "Droit", "Ecouter", "Electricité", "Esquiver (DEX*2%)", "Géologie", "Grimper", "Histoire", "Histoire Naturel", "Lancer", "Langues Etrangères", "Langue Natale (EDU*5%)", "Marchandage", "Mecanique", "Médecine", "Monter à Cheval", "Mythe de Chtullu", "Nager", "Navigation", "Occultisme", "Persuasion", "Pharmacoogie", "Photographie", "Physique", "Piloter", "Permiers Soins", "Psychanalyse", "Psychologie", "Sauter", "Se Cacher", "Serrurerie", "Suivre une Piste", "Trouver Objet Caché", "Arme de Poing", "Fusil", "Fusil de Chasse", "Mitrailette", "Mitrailleuse", "Coup de Pied", "Coup de Poing", "Coup de Tête", "Lutte", "eloquence", "dessinerCarte", "Chanter", "Botanique", "pickpocket", "soignerEmpoisonnement", "soignerMaladie"};
	private int[] competenceInit = {0, 0, 5, 0 ,0 ,5 ,25, 0 ,0 ,10, 20, 0, 15, 10, 15, 5, 25, 10, 0, 0, 40, 20, 10, 25, 0, 0, 5, 20, 5, 5, 0, 25, 10, 5, 15, 0, 10, 0, 0, 30, 0, 5, 25, 10, 0, 10, 25, 20, 25, 30, 15, 15, 25, 50, 10, 25, 0, 0, 0, 0, 0, 0, 0};
	private ArrayList compMetierPerso = new ArrayList();
	private ArrayList<Boolean> competenceBool = new ArrayList<Boolean>();
	private int compInit, comp2, compTemp;
private int ran = 0;
	
	public CreationAutoCMetier(ArrayList<String> caractPerso, ArrayList<Boolean> competenceBool) {
		this.caractPerso = caractPerso;
		this.competenceBool = competenceBool;
		compInit = comp2 = (Integer.parseInt(caractPerso.get(16).toString()))*20;
		for(int j = 0; j < competence.length; j++){
			compMetierPerso.add(competenceInit[j]);
		}
		compTemp = 0;
		for(int i = 0; i < competence.length; i++){
			if(competenceBool.get(i) == true){
				compTemp++; 
			}
		}
		for(int k = 0; k < competence.length; k++){
			if(competenceBool.get(k) == true){
				int temp, temp2 = 0;
				temp = (int) compMetierPerso.get(k);
				temp2 = temp + (compInit/compTemp);
				compMetierPerso.remove(k);
				compMetierPerso.add(k, temp2);
				}
			
		}
	}
	
	public void randomComp(int arg, int pos){
		int temp, temp2 = 0;
		ran = (int)((Math.random()*arg) + 1);
		temp = (int) compMetierPerso.get(pos); 
		temp2 = temp + ran;
		System.out.println("Pos random : " + pos + "  random : " + ran + "  temps : " + temp + "  total : " + temp2);
		compMetierPerso.remove(pos);
		compMetierPerso.add(pos, temp2);
	}
	
	public ArrayList getMetierPerso() {
		return compMetierPerso;
	}
	
}

/*
  
  
			else if(comp2 == 0) i = competence.length-1;
		}
			if(comp2 >= compInit/2){
				compTemp = 25;
				System.out.println("Comptemp : " + compTemp);
				for(int m = 0; m < competence.length; m++){
					
					if(competenceBool.get(m) == true){
						randomComp(compTemp ,m);
						comp2 = comp2 - ran;
					}
					else if(comp2 == 0) m = competence.length-1;
					
				}
			}
			else if(comp2 < compInit/2 && comp2 >= compInit/6){
				compTemp = 10;
				System.out.println("Comptemp : " + compTemp);
				for(int n = 0; n < competence.length; n++){
					
					if(competenceBool.get(n) == true){
						randomComp(compTemp ,n);
						comp2 = comp2 - ran;
					}
					else if(comp2 == 0) n = competence.length-1;
				}
			}
			else if(comp2 < compInit/6){
				System.out.println("reste : " + comp2);
					for(int o = 0; o < competence.length; o++){
					
					if(competenceBool.get(o) == true){
						compMetierPerso.remove(o);
						compMetierPerso.add(comp2, o);
						o = competence.length-1;
					}
			}
			}
			else if(comp2 == 0){};
  
 */
