package controleChtullu;

import java.util.ArrayList;

public class CreationAuto {
	
	private int forc, dex, sx, inte, con, app, pou, tai ,ide, san, chanc, connais, pv, pm, sm, edu, age= 0;
	private String bd, sexe, metier, dipl, nat, nom;
	ArrayList<String> caractPerso = new ArrayList<String>();
	//String[] choixMetier = {"metier 1", "metier 2", "metier 3", "metier 4", "metier 5", "metier 6", "metier 7", "metier 8"};
	String[] choixMetier = {"Aucun", "Antiquaire", "Artiste", "Artiste de cabaret", "Athlete", "Avocat", "Criminel", "Detective prive", "Dilettante", "Ecrivain", "Fantassin", "Fermier", "Guerrier tribal", "Ingenieur", "Inspecteur de police", "Journaliste", "Medecin", "Missionnaire", "Musicien", "Officier", "Parapsychologue", "Pecheur", "Policier", "Pretre", "Proffesseur", "Revolutionnaire", "Vagabond"};
	String[] diplome = {"Aucun" ,"Certificat d'étude", "Brevet", "Bac", "Ingenieur", "Master", "maitre de conf"};
	String[] nationnalite = {"Français", "Allemand", "Anglais", "Irelandais", "italien", "Espagnole", "Hollandais", "Belge", "Portugais", "Suisse", "Autrichien", "Polonais", "Russe", "Suédois", "Finlandais", "Norvegiens", "Hongrois", "Roumain", "Techquoslovaque", "Egyptien", "Ethiopien", "Congolain", "Sud affricain", "Sénégalain", "Arabe", "Syrien", "Turque", "Iraquien", "Iranien", "Afgan", "Grecque", "Indonésien", "Chinois", "Cor�en", "Japonais", "Indou", "Mongolien","Tibetien", "Americain", "Canadien", "Mexicain", "Colombien", "Argentien", "Brezilien", "Vénézuelien", "Australien", "Neozélandais", "Haïtien", "Iselandais", "Cubain", "Arménien", "Bolivien", "Bulgare", "Chilien", "Danois", "Georgien", "Luxembourgeois", "Panamien", "Péruvien", "Ukrainien", "Yemenien", "Tripolitien", "Palatien", "Koubanais", "Rhonan"};
	
	public CreationAuto(String nom, String sexe) {
		// calcul automatique des caracteristiques du perso
		this.nom = nom;
		this.sexe = sexe;
		
		forc = (int)(Math.random()*15) + 3;
		con = (int)(Math.random()*15) + 3;
		pou = (int)(Math.random()*15) + 3;
		dex = (int)(Math.random()*15) + 3;
		app = (int)(Math.random()*15) + 3;
		tai = (int)(Math.random()*10) + 10;
		inte = (int)(Math.random()*10) + 10;
		edu = (int)(Math.random()*15) + 6;
		age = (int)(Math.random()*52) + 18;
		ide = inte*5;
		san = pou*5;
		chanc = pou*5;
		connais = edu*5;
		pv = (con + tai)/2;
		pm = pou;
		sm = san;
		int bd2 = forc + tai;
		bd = bonusDegats(bd2); 
		
		int metierIn = (int)(Math.random()*choixMetier.length);
		metier = choixMetier[metierIn];
		dipl = choixDiplome(edu);
		int pays = (int) (Math.random()*nationnalite.length);
		nat = nationnalite[pays];
		
		caractPerso.clear();
		caractPerso.add(nom);		// 0
		caractPerso.add(sexe);						// 1
		caractPerso.add(Integer.toString(age));		// 2
		caractPerso.add(nat);		// 3
		caractPerso.add(metier);						// 4
		caractPerso.add(dipl);			// 5
		caractPerso.add(Integer.toString(forc));			// 6
		caractPerso.add(Integer.toString(dex));		// 7
		caractPerso.add(Integer.toString(inte));	// 8
		caractPerso.add(Integer.toString(ide));			// 9
		caractPerso.add(Integer.toString(con));	// 10
		caractPerso.add(Integer.toString(app));		// 11
		caractPerso.add(Integer.toString(pou));		// 12
		caractPerso.add(Integer.toString(chanc));				// 13
		caractPerso.add(Integer.toString(tai));				// 14
		caractPerso.add(Integer.toString(san));				// 15
		caractPerso.add(Integer.toString(edu));			// 16
		caractPerso.add(Integer.toString(connais));			// 17
		caractPerso.add("99");			// 18
		caractPerso.add(bd);				// 19
		caractPerso.add(Integer.toString(sm));			// 20
		caractPerso.add(Integer.toString(pm));			// 21
		caractPerso.add(Integer.toString(pv));				// 22
		
	}
	
	public ArrayList<String> getRandom(){
		System.out.println("auto : " + caractPerso.toString());
		return caractPerso;
	}
	
	private String bonusDegats(int bonusD){
		String BonusOut = null;
		if(bonusD >= 2 && bonusD <= 12){
			BonusOut = "-1D6";
		}
		else if(bonusD >= 13 && bonusD <= 16){
			BonusOut = "-1D4";
		}
		else if(bonusD >= 17 && bonusD <= 24){
			BonusOut = "aucun";
		}
		else if(bonusD >= 25 && bonusD <= 32){
			BonusOut = "+1D4";
		}
		else if(bonusD >= 33 && bonusD <= 40){
			BonusOut = "+1D6";
		}
		else if(bonusD >= 41 && bonusD <= 56){
			BonusOut = "+2D6";
		}
		else if(bonusD >= 57 && bonusD <= 72){
			BonusOut = "+3D6";
		}
		else if(bonusD >= 73 && bonusD <= 88){
			BonusOut = "+4D6";
		}
		else if(bonusD >= 89 && bonusD <= 104){
			BonusOut = "+5D4";
		}
		else if(bonusD >= 105 && bonusD <= 120){
			BonusOut = "+6D4";
		}
		else if(bonusD >= 121 && bonusD <= 136){
			BonusOut = "+7D4";
		}
		else if(bonusD >= 137 && bonusD <= 152){
			BonusOut = "+8D4";
		}
		else if(bonusD >= 153 && bonusD <= 168){
			BonusOut = "+9D4";
		}
		else if(bonusD >= 169 && bonusD <= 184){
			BonusOut = "+10D4";
		}
		return BonusOut;
	}
	
	private String choixDiplome(int arg){
		// 7 choix de metier, education 6 min, 21 max ==> 
		// 6 = 0
		// 7-8 = 1
		// 9-11 = 2
		// 12-13 = 3
		// 14-16 = 4
		// 17-19 = 5
		// 20-21 = 6
		
		int diplIN = 0;
		String diplOut;
		if(arg <=6) diplIN = 0;
		else if (arg >= 7 && arg <= 8) diplIN = 1;
		else if (arg >= 9 && arg <= 11) diplIN = 2;
		else if (arg >= 12 && arg <= 13) diplIN = 3;
		else if (arg >= 14 && arg <= 16) diplIN = 4;
		else if (arg >= 17 && arg <= 19) diplIN = 5;
		else if (arg >= 20 && arg <= 21) diplIN = 6;
		diplOut = diplome[diplIN];
		return diplOut;
		
	}
}

/*
 * for, con, pou, dex app = 3d6 = 3min, 18max
tai, int = 2d6 + 8 = 10min, 20max
edu = 3d6 + 3 = 6min, 21max
san = pou * 5 = 25max
*/


//int choix = (int)(Math.random()*336529);