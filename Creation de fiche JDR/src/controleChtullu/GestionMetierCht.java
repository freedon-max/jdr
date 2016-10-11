package controleChtullu;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelChtullu.PersoChtullu;
import vueChtullu.DataChtullu;

public class GestionMetierCht implements DataChtullu {

	PersoChtullu persoCht = null;
	
	String metier, nom;

	ArrayList<Boolean> competenceBool = new ArrayList<Boolean>();
	int comp, comp2, comp3, comp4;

	public GestionMetierCht() {
	};

	public ArrayList<Boolean> GestionMCht(PersoChtullu obj) {
		this.persoCht = obj;	
	
		metier = persoCht.getProffession();
		
		comp = persoCht.getComp(); 
		comp2 = persoCht.getComp2(); 
		comp3 = persoCht.getComp3();
		comp4 = persoCht.getComp4();
		
		for (int l = 0; l < competence.length; l++) {
			competenceBool.add(false);
		}

		if (metier.equals("Aucun")) {
		}

		else if (metier.equals("Antiquaire")) {
			// metier est antiquaire : Art, Droit, Bibliotheque, Histoire,
			// Langue Etrang�re, Marchandage, Trouver Objet Cach�, + 1
			// comp�tence au choix
			competenceBool.remove(2);
			competenceBool.add(2, true);
			competenceBool.remove(15);
			competenceBool.add(15, true);
			competenceBool.remove(6);
			competenceBool.add(6, true);
			competenceBool.remove(21);
			competenceBool.add(21, true);

			competenceBool.remove(24);
			competenceBool.add(24, true);
			competenceBool.remove(26);
			competenceBool.add(26, true);
			competenceBool.remove(46);
			competenceBool.add(46, true);
			comp = CompPerso("1er", comp);
			competenceBool.remove(comp);
			competenceBool.add(comp, true);
		}

		else if (metier.equals("Artiste")) {
			// metier est Artiste : Art, Baratin, Histoire, Photographie,
			// Psychologie, Trouver Objet Cach�, + 2 comp�tence au choix.
			competenceBool.remove(2);
			competenceBool.add(2, true);
			competenceBool.remove(5);
			competenceBool.add(5, true);
			competenceBool.remove(21);
			competenceBool.add(21, true);
			competenceBool.remove(36);
			competenceBool.add(36, true);
			competenceBool.remove(41);
			competenceBool.add(41, true);
			competenceBool.remove(46);
			competenceBool.add(46, true);
			comp = CompPerso("1er", comp);
			competenceBool.remove(comp);
			competenceBool.add(comp, true);
			comp2 = CompPerso("2eme", comp2);
			competenceBool.remove(comp2);
			competenceBool.add(comp2, true);
		}

		else if (metier.equals("Artiste de cabaret")) {
			// metier est Artiste de cabaret :Art, Baratin, Cr�dit, Ecouter,
			// Esquiver, Langue Etrang�re, Psychologie + 1 autre com�tence au
			// choix.
			competenceBool.remove(2);
			competenceBool.add(2, true);
			competenceBool.remove(5);
			competenceBool.add(5, true);
			competenceBool.remove(12);
			competenceBool.add(12, true);
			competenceBool.remove(16);
			competenceBool.add(16, true);
			competenceBool.remove(18);
			competenceBool.add(18, true);
			competenceBool.remove(24);
			competenceBool.add(24, true);
			competenceBool.remove(41);
			competenceBool.add(41, true);
			comp = CompPerso("1er", comp);
			competenceBool.remove(comp);
			competenceBool.add(comp, true);

		}

		else if (metier.equals("Athlete")) {
			// esquiver, grimper, lancer, monter a cheval, sauter + 2 comp perso
			competenceBool.remove(18);
			competenceBool.add(18, true);
			competenceBool.remove(20);
			competenceBool.add(20, true);
			competenceBool.remove(23);
			competenceBool.add(23, true);
			competenceBool.remove(29);
			competenceBool.add(29, true);
			competenceBool.remove(42);
			competenceBool.add(42, true);
			comp = CompPerso("1er", comp);
			competenceBool.remove(comp);
			competenceBool.add(comp, true);
			comp2 = CompPerso("2eme", comp2);
			competenceBool.remove(comp2);
			competenceBool.add(comp2, true);
		}

		else if (metier.equals("Avocat")) {
			// baratin, bibliotheque, credit, droit, marchandage, persuasion,
			// psychologie + 1 comp perso
			competenceBool.remove(5);
			competenceBool.add(5, true);
			competenceBool.remove(6);
			competenceBool.add(6, true);
			competenceBool.remove(12);
			competenceBool.add(12, true);
			competenceBool.remove(15);
			competenceBool.add(15, true);
			competenceBool.remove(26);
			competenceBool.add(26, true);
			competenceBool.remove(34);
			competenceBool.add(34, true);
			competenceBool.remove(41);
			competenceBool.add(41, true);
			comp = CompPerso("1er", comp);
			competenceBool.remove(comp);
			competenceBool.add(comp, true);
		}

		else if (metier.equals("Criminel")) {
			// arme de poing, baratin, discretion, marchandage, serrurerie,
			// touver ob cache + 2 comp perso
			competenceBool.remove(47);
			competenceBool.add(47, true);
			competenceBool.remove(5);
			competenceBool.add(5, true);
			competenceBool.remove(13);
			competenceBool.add(13, true);
			competenceBool.remove(26);
			competenceBool.add(26, true);
			competenceBool.remove(44);
			competenceBool.add(44, true);
			competenceBool.remove(46);
			competenceBool.add(46, true);
			comp = CompPerso("1er", comp);
			competenceBool.remove(comp);
			competenceBool.add(comp, true);
			comp2 = CompPerso("2eme", comp2);
			competenceBool.remove(comp2);
			competenceBool.add(comp2, true);
		}

		else if (metier.equals("Detective prive")) {
			// arme de poing, baratin, droit, marchandage, photo, psychologie,
			// serrurerie, suivre une piste + 1 comp perso
			competenceBool.remove(47);
			competenceBool.add(47, true);
			competenceBool.remove(5);
			competenceBool.add(5, true);
			competenceBool.remove(15);
			competenceBool.add(15, true);
			competenceBool.remove(36);
			competenceBool.add(36, true);
			competenceBool.remove(41);
			competenceBool.add(41, true);
			competenceBool.remove(44);
			competenceBool.add(44, true);
			competenceBool.remove(45);
			competenceBool.add(45, true);
			comp = CompPerso("1er", comp);
			competenceBool.remove(comp);
			competenceBool.add(comp, true);
		}

		else if (metier.equals("Dilettante")) {
			// credi, monter a cheval, + 4 competance perso
			competenceBool.remove(12);
			competenceBool.add(12, true);
			competenceBool.remove(29);
			competenceBool.add(29, true);
			comp = CompPerso("1er", comp);
			competenceBool.remove(comp);
			competenceBool.add(comp, true);
			comp2 = CompPerso("2eme", comp2);
			competenceBool.remove(comp2);
			competenceBool.add(comp2, true);
			comp3 = CompPerso("3eme", comp3);
			competenceBool.remove(comp3);
			competenceBool.add(comp3, true);
			comp4 = CompPerso("4eme", comp4);
			competenceBool.remove(comp4);
			competenceBool.add(comp4, true);
		}

		else if (metier.equals("Ecrivain")) {
			// bibliotheque, histoire, langue etrangere, langue natale,
			// persuasion, psychologie, 2 comp perso
			competenceBool.remove(6);
			competenceBool.add(6, true);
			competenceBool.remove(21);
			competenceBool.add(21, true);
			competenceBool.remove(24);
			competenceBool.add(24, true);
			competenceBool.remove(25);
			competenceBool.add(25, true);
			competenceBool.remove(34);
			competenceBool.add(34, true);
			competenceBool.remove(41);
			competenceBool.add(41, true);
			comp = CompPerso("1er", comp);
			competenceBool.remove(comp);
			competenceBool.add(comp, true);
			comp2 = CompPerso("2eme", comp2);
			competenceBool.remove(comp2);
			competenceBool.add(comp2, true);
		}

		else if (metier.equals("Fantassin")) {
			// discretion, dissimulation, ecouter, fusil, grimper, mitrailleuse,
			// premier soin, se cacher
			competenceBool.remove(13);
			competenceBool.add(13, true);
			competenceBool.remove(14);
			competenceBool.add(14, true);
			competenceBool.remove(16);
			competenceBool.add(16, true);
			competenceBool.remove(48);
			competenceBool.add(48, true);
			competenceBool.remove(20);
			competenceBool.add(20, true);
			competenceBool.remove(51);
			competenceBool.add(51, true);
			competenceBool.remove(39);
			competenceBool.add(39, true);
			competenceBool.remove(43);
			competenceBool.add(43, true);
		}

		else if (metier.equals("Fermier")) {
			// conduire engin lourd, electricit�, fusil, histoire naturelle,
			// mecanique, premier soin, suivre une psite + 1 comp perso
			competenceBool.remove(11);
			competenceBool.add(11, true);
			competenceBool.remove(17);
			competenceBool.add(17, true);
			competenceBool.remove(48);
			competenceBool.add(48, true);
			competenceBool.remove(22);
			competenceBool.add(22, true);
			competenceBool.remove(27);
			competenceBool.add(27, true);
			competenceBool.remove(39);
			competenceBool.add(39, true);
			competenceBool.remove(45);
			competenceBool.add(45, true);
			comp = CompPerso("1er", comp);
			competenceBool.remove(comp);
			competenceBool.add(comp, true);
		}

		else if (metier.equals("Guerrier tribal")) {
			// lutte, coup de poing, Histoire naturelle, occultisme, persuasion,
			// suivre une piste, trouver ob cach� + 2 comp perso
			competenceBool.remove(55);
			competenceBool.add(55, true);
			competenceBool.remove(47);
			competenceBool.add(47, true);
			competenceBool.remove(22);
			competenceBool.add(22, true);
			competenceBool.remove(33);
			competenceBool.add(33, true);
			competenceBool.remove(34);
			competenceBool.add(34, true);
			competenceBool.remove(45);
			competenceBool.add(45, true);
			competenceBool.remove(46);
			competenceBool.add(46, true);
			comp = CompPerso("1er", comp);
			competenceBool.remove(comp);
			competenceBool.add(comp, true);
			comp2 = CompPerso("2eme", comp2);
			competenceBool.remove(comp2);
			competenceBool.add(comp2, true);
		}

		else if (metier.equals("Ingenieur")) {
			// bibliotheque, chimie, electricit�, geologie, mecanique, physique
			// + 2 comp perso
			competenceBool.remove(6);
			competenceBool.add(6, true);
			competenceBool.remove(8);
			competenceBool.add(8, true);
			competenceBool.remove(17);
			competenceBool.add(17, true);
			competenceBool.remove(19);
			competenceBool.add(19, true);
			competenceBool.remove(27);
			competenceBool.add(27, true);
			competenceBool.remove(37);
			competenceBool.add(37, true);
			comp = CompPerso("1er", comp);
			competenceBool.remove(comp);
			competenceBool.add(comp, true);
			comp2 = CompPerso("2eme", comp2);
			competenceBool.remove(comp2);
			competenceBool.add(comp2, true);
		}

		else if (metier.equals("Inspecteur de police")) {
			// arme de poing, baratin, droit, marchandage, persuasion,
			// psychologie, trouver ob cach� + 1 comp perso
			competenceBool.remove(47);
			competenceBool.add(47, true);
			competenceBool.remove(5);
			competenceBool.add(5, true);
			competenceBool.remove(15);
			competenceBool.add(15, true);
			competenceBool.remove(26);
			competenceBool.add(26, true);
			competenceBool.remove(34);
			competenceBool.add(34, true);
			competenceBool.remove(41);
			competenceBool.add(41, true);
			competenceBool.remove(46);
			competenceBool.add(46, true);
			comp = CompPerso("1er", comp);
			competenceBool.remove(comp);
			competenceBool.add(comp, true);
		}

		else if (metier.equals("Journaliste")) {
			// baratin, langue etrangere, langue natale, persuasion, photo,
			// psychologie, + 2 comp perso
			competenceBool.remove(5);
			competenceBool.add(5, true);
			competenceBool.remove(24);
			competenceBool.add(24, true);
			competenceBool.remove(25);
			competenceBool.add(25, true);
			competenceBool.remove(34);
			competenceBool.add(34, true);
			competenceBool.remove(36);
			competenceBool.add(36, true);
			competenceBool.remove(41);
			competenceBool.add(41, true);
			comp = CompPerso("1er", comp);
			competenceBool.remove(comp);
			competenceBool.add(comp, true);
			comp2 = CompPerso("2eme", comp2);
			competenceBool.remove(comp2);
			competenceBool.add(comp2, true);
		}

		else if (metier.equals("Medecin")) {
			// biologie, credit, latin, soigner maladie, soigner empoisenement,
			// pharmacologie, premier soins, psychanalyse, psychologie
			competenceBool.remove(7);
			competenceBool.add(7, true);
			competenceBool.remove(12);
			competenceBool.add(12, true);
			competenceBool.remove(24);
			competenceBool.add(24, true);
			competenceBool.remove(28);
			competenceBool.add(28, true);
			competenceBool.remove(35);
			competenceBool.add(35, true);
			competenceBool.remove(39);
			competenceBool.add(39, true);
			competenceBool.remove(40);
			competenceBool.add(40, true);
			competenceBool.remove(41);
			competenceBool.add(41, true);
			competenceBool.remove(61);
			competenceBool.add(61, true);
			competenceBool.remove(62);
			competenceBool.add(62, true);

		}

		else if (metier.equals("Missionnaire")) {
			// art, histoire naturelle, langue etrangere, mecanique, persuasion,
			// premier soin + 2 comp perso
			competenceBool.remove(2);
			competenceBool.add(2, true);
			competenceBool.remove(22);
			competenceBool.add(22, true);
			competenceBool.remove(24);
			competenceBool.add(24, true);
			competenceBool.remove(27);
			competenceBool.add(27, true);
			competenceBool.remove(34);
			competenceBool.add(34, true);
			competenceBool.remove(39);
			competenceBool.add(39, true);
			comp = CompPerso("1er", comp);
			competenceBool.remove(comp);
			competenceBool.add(comp, true);
		}

		else if (metier.equals("Musicien")) {
			// art, baratin, ecouter, marchandage, persuasion, psychologie,
			// chanter, + 2 comp perso
			competenceBool.remove(2);
			competenceBool.add(2, true);
			competenceBool.remove(5);
			competenceBool.add(5, true);
			competenceBool.remove(16);
			competenceBool.add(16, true);
			competenceBool.remove(26);
			competenceBool.add(26, true);
			competenceBool.remove(34);
			competenceBool.add(34, true);
			competenceBool.remove(41);
			competenceBool.add(41, true);
			comp = CompPerso("1er", comp);
			competenceBool.remove(comp);
			competenceBool.add(comp, true);
			comp2 = CompPerso("2eme", comp2);
			competenceBool.remove(comp2);
			competenceBool.add(comp2, true);
			competenceBool.remove(58);
			competenceBool.add(58, true);
		}

		else if (metier.equals("Officier")) {
			// arme de poing, comptabilit�, credit, suivre une piste, histoire,
			// marchandage, persuasion, psychologie
			competenceBool.remove(47);
			competenceBool.add(47, true);
			competenceBool.remove(9);
			competenceBool.add(9, true);
			competenceBool.remove(12);
			competenceBool.add(12, true);
			competenceBool.remove(45);
			competenceBool.add(45, true);
			competenceBool.remove(21);
			competenceBool.add(21, true);
			competenceBool.remove(26);
			competenceBool.add(26, true);
			competenceBool.remove(34);
			competenceBool.add(34, true);
			competenceBool.remove(41);
			competenceBool.add(41, true);
		}

		else if (metier.equals("Parapsychologue")) {
			// anthropologie, bibliotheque, histoire, langue etrangere,
			// occultisme, photo, psychologie, + 1 comp perso
			competenceBool.remove(0);
			competenceBool.add(0, true);
			competenceBool.remove(6);
			competenceBool.add(6, true);
			competenceBool.remove(21);
			competenceBool.add(21, true);
			competenceBool.remove(24);
			competenceBool.add(24, true);
			competenceBool.remove(33);
			competenceBool.add(33, true);
			competenceBool.remove(36);
			competenceBool.add(36, true);
			competenceBool.remove(41);
			competenceBool.add(41, true);
			comp = CompPerso("1er", comp);
			competenceBool.remove(comp);
			competenceBool.add(comp, true);
		}

		else if (metier.equals("Pecheur")) {
			// ecouter, histoire naturelle, lancer, mecanique, nager,
			// occultisme, piloter ,Navigation, trouve ob cach�
			competenceBool.remove(16);
			competenceBool.add(16, true);
			competenceBool.remove(22);
			competenceBool.add(22, true);
			competenceBool.remove(23);
			competenceBool.add(23, true);
			competenceBool.remove(27);
			competenceBool.add(27, true);
			competenceBool.remove(31);
			competenceBool.add(31, true);
			competenceBool.remove(33);
			competenceBool.add(33, true);
			competenceBool.remove(38);
			competenceBool.add(38, true);
			competenceBool.remove(32);
			competenceBool.add(32, true);
			competenceBool.remove(46);
			competenceBool.add(46, true);

		}

		else if (metier.equals("Policier")) {
			// arme de poing, baratin, droit, ecouter, lutte, premier soins, + 2
			// comp perso
			competenceBool.remove(47);
			competenceBool.add(47, true);
			competenceBool.remove(5);
			competenceBool.add(5, true);
			competenceBool.remove(15);
			competenceBool.add(15, true);
			competenceBool.remove(16);
			competenceBool.add(16, true);
			competenceBool.remove(55);
			competenceBool.add(55, true);
			competenceBool.remove(39);
			competenceBool.add(39, true);
			comp = CompPerso("1er", comp);
			competenceBool.remove(comp);
			competenceBool.add(comp, true);
			comp2 = CompPerso("2eme", comp2);
			competenceBool.remove(comp2);
			competenceBool.add(comp2, true);
		}

		else if (metier.equals("Pretre")) {
			// bibliotheque, comptabilit�, ecouter, histoire, langue etrangere,
			// persuasion, premier soins, psychologie
			competenceBool.remove(6);
			competenceBool.add(6, true);
			competenceBool.remove(9);
			competenceBool.add(9, true);
			competenceBool.remove(16);
			competenceBool.add(16, true);
			competenceBool.remove(21);
			competenceBool.add(21, true);
			competenceBool.remove(24);
			competenceBool.add(24, true);
			competenceBool.remove(34);
			competenceBool.add(34, true);
			competenceBool.remove(39);
			competenceBool.add(39, true);
			competenceBool.remove(41);
			competenceBool.add(41, true);
			comp = CompPerso("1er", comp);
			competenceBool.remove(comp);
			competenceBool.add(comp, true);
		}

		else if (metier.equals("Proffesseur")) {
			// bibliotheque, credit, langue etrangere, persuasion, psychologie,
			// 1 comp perso
			competenceBool.remove(6);
			competenceBool.add(6, true);
			competenceBool.remove(12);
			competenceBool.add(12, true);
			competenceBool.remove(24);
			competenceBool.add(24, true);
			competenceBool.remove(34);
			competenceBool.add(34, true);
			competenceBool.remove(41);
			competenceBool.add(41, true);
			comp = CompPerso("1er", comp);
			competenceBool.remove(comp);
			competenceBool.add(comp, true);
		}

		else if (metier.equals("Revolutionnaire")) {
			// arme de poing, art martiaux, dissimulation, fusil, persuasion, se
			// cacher, trouver ob cach� + 1 comp perso
			competenceBool.remove(47);
			competenceBool.add(47, true);
			competenceBool.remove(3);
			competenceBool.add(3, true);
			competenceBool.remove(14);
			competenceBool.add(14, true);
			competenceBool.remove(48);
			competenceBool.add(48, true);
			competenceBool.remove(34);
			competenceBool.add(34, true);
			competenceBool.remove(43);
			competenceBool.add(43, true);
			competenceBool.remove(46);
			competenceBool.add(46, true);
			comp = CompPerso("1er", comp);
			competenceBool.remove(comp);
			competenceBool.add(comp, true);
		}

		else if (metier.equals("Vagabond")) {
			// baratin, discretion, ecouter, histoire naturelle, marchandage, se
			// cacher, trouve rob cach� + 1 comp perso
			competenceBool.remove(5);
			competenceBool.add(5, true);
			competenceBool.remove(13);
			competenceBool.add(13, true);
			competenceBool.remove(16);
			competenceBool.add(16, true);
			competenceBool.remove(22);
			competenceBool.add(22, true);
			competenceBool.remove(26);
			competenceBool.add(26, true);
			competenceBool.remove(43);
			competenceBool.add(43, true);
			competenceBool.remove(46);
			competenceBool.add(46, true);
			comp = CompPerso("1er", comp);
			competenceBool.remove(comp);
			competenceBool.add(comp, true);
		}

		else {
			for (int l = 0; l < competence.length; l++) {
				competenceBool.add(true);
			}
		}
		
		persoCht.setComp(comp); 
		persoCht.setComp2(comp2); 
		persoCht.setComp3(comp3);
		persoCht.setComp4(comp4);

		return competenceBool;
	}

	private int CompPerso(String arg, int arg2) {
		int compOut = 0;
		if(arg2 == 100){
		
		JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
		

		nom = (String) jop.showInputDialog(null, "Veuillez Choisir votre " + arg + " competence personnelle!",
				"Compétence personnel du metier : " + metier, JOptionPane.QUESTION_MESSAGE, null, competence,
				competence[0]);

		for (int f = 0; f < competence.length; f++) {
			if (competence[f].equals(nom)) {
				compOut = f;
			}
		}
		}
		else {
			compOut = arg2;
			}
		return compOut;

	}

	private String ChoixLangueEtr() {
		JOptionPane etr = new JOptionPane(), etr2 = new JOptionPane();

		String langueEtr = etr.showInputDialog(null, "Veuillez choisir votre langue étrangère : ", "Attention",
				JOptionPane.QUESTION_MESSAGE);

		etr2.showMessageDialog(null, "Votre langue etr est " + nom, "Identité", JOptionPane.INFORMATION_MESSAGE);

		return langueEtr;

	}

}

/*
 * "Anthropologie" 0 "Arch�ologie" 1 "Art" 2 "Art Martiaux" 3 "Astronomie" 4
 * " Baratin" 5 "Biblioth�que" 6 "Biologie" 7 "Chimie" 8 "Comptabilit�" 9
 * "Conduire Auto" 10 "Conduire ELourd" 11 "Cr�dit" 12 "Discr�tion" 13
 * "Dissimulation" 14 "Droit" 15 "Ecouter" 16 "Electricit�" 17
 * "Esquiver (DEX*2%)"18 "G�ologie" 19 "Grimper" 20 "Histoire" 21
 * "Histoire Naturel" 22 "Lancer" 23 "Langues Etr" 24 "Langue Natale EDU*5 " 25
 * "Marchandage" 26 "Mecanique" 27 "M�decine" 28 "Monter � Cheval" 29
 * "Mythe de Chtullu" 30 "Nager" 31 "Navigation" 32 "Occultisme" 33 "Persuasion"
 * 34 "Pharmacoogie" 35 "Photographie" 36 "Physique" 37 "Piloter" 38
 * "Permiers Soins" 39 "Psychanalyse" 40 "Psychologie" 41 "Sauter" 42
 * "Se Cacher" 43 "Serrurerie" 44 "Suivre une Piste" 45 "Trouver Objet Ca" 46
 * "Arme de Poing" 47 "Fusil" 48 "Fusil de Chasse" 49 "Mitrailette" 50
 * "Mitrailleuse" 51 "Coup de Pied" 52 "Coup de Poing" 53 "Coup de T�te" 54
 * "Lutte" 55 "eloquence" 56 dessinerCarte 57 "chanter" 58 "botanique" 59
 * "pickpocket" 60 soignerEmpoisonne 61 soignerMaladie 62
 * 
 * 
 * 
 * 
 */