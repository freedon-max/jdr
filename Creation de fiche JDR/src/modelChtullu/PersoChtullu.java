package modelChtullu;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controleChtullu.GestionMetierCht;
import vueChtullu.DataChtullu;


public class PersoChtullu implements DataChtullu {
	GestionMetierCht gestion = new GestionMetierCht();

	private static final Logger logger = LogManager.getLogger(PersoChtullu.class.getName());
	private int force, dexterite, intelligence, idee, constitution, apparance, pouvoir, chance, taille, sante,
			education, connaissance, santeMentale, pm, pv = 0;
	private String nom, nationnalite, diplome, PsyOut;

	private int[] competenceInit = { 0, 0, 5, 0, 0, 5, 25, 0, 0, 10, 20, 0, 15, 10, 15, 5, 25, 10, 0, 0, 40, 20, 10, 25,
			0, 0, 5, 20, 5, 5, 0, 25, 10, 5, 15, 0, 10, 0, 0, 30, 0, 5, 25, 10, 0, 10, 25, 20, 25, 30, 15, 15, 25, 50,
			10, 25, 0, 0, 0, 0, 0, 0, 0 };

	private String sexe = "Homme";
	private int id = 0;
	private int age, pointCompMetier, pointCompPerso;
	private int mytheC = 99;
	private String bonusDegat = "aucun";
	private String proffession = "Aucun";
	private String prof = "Aucun";
	private String langueEtr = "Aucun";
	private String armeCc = " ";
	private String armeF = " ";
	private String desordrePsy = "Aucun";
	private String residence = "";
	private String famille = "";
	private String revenu = "";
	private String description = "";
	private int temp5, temp6, temp7, temp8;
	
	private int comp, comp2, comp3, comp4;

	private ArrayList<Boolean> competenceBool = new ArrayList<Boolean>();
	private ArrayList<Boolean> competenceBool2 = new ArrayList<Boolean>();
	private ArrayList compMetierPerso = new ArrayList();
	private ArrayList compPPerso = new ArrayList();
	private ArrayList compGPerso = new ArrayList();

	public PersoChtullu() {

		logger.debug("Perso ok ");
		nom = "test";
		comp = comp2 = comp3 = comp4 = 100;
		competenceBool = gestion.GestionMCht(this);
		Init();
		for (int i = 0; i < competence.length; i++) {
			compMetierPerso.add(competenceInit[i]);
			compPPerso.add(competenceInit[i]);
		}
		

	}
	
	public PersoChtullu(boolean arg) {
		
		logger.debug("Perso via BDD ok ");
		competenceBool = gestion.GestionMCht(this);	
		Init();
		for (int i = 0; i < competence.length; i++) {
			compMetierPerso.add(competenceInit[i]);
			compPPerso.add(competenceInit[i]);
		}


		
	}

	public void Calcul() {

		competenceBool2.clear();
		compMetierPerso.clear();
		compPPerso.clear();
		competenceInit = InitSpec();
		idee = intelligence * 5;
		sante = pouvoir * 5;
		chance = pouvoir * 5;
		connaissance = education * 5;
		pv = (constitution + taille) / 2;
		pm = pouvoir;
		santeMentale = sante;
		pointCompMetier = education * 20;
		pointCompPerso = intelligence * 10;
		BonusDegats();
		if (prof.equals(proffession)) {
		} else {
			competenceBool.clear();
			competenceBool = gestion.GestionMCht(this);
			for (int i = 0; i < competence.length; i++) {
				compMetierPerso.add(competenceInit[i]);
				compPPerso.add(competenceInit[i]);
			}
		}
		Init();
		prof = proffession;
	}

	private void Init() {
		// inverse la List competence bool
		for (int l = 0; l < competence.length; l++) {
			competenceBool2.add(false);
		}

		for (int n = 0; n < competence.length; n++) {
			if ((competenceBool.get(n)).equals(true)) {
				competenceBool2.remove(n);
				competenceBool2.add(n, false);
			} else if ((competenceBool.get(n)).equals(false)) {
				competenceBool2.remove(n);
				competenceBool2.add(n, true);
			}
		}

	}

	public void Random() {
		force = (int) (Math.random() * 15) + 3;
		constitution = (int) (Math.random() * 15) + 3;
		pouvoir = (int) (Math.random() * 15) + 3;
		dexterite = (int) (Math.random() * 15) + 3;
		apparance = (int) (Math.random() * 15) + 3;
		taille = (int) (Math.random() * 10) + 10;
		intelligence = (int) (Math.random() * 10) + 10;
		education = (int) (Math.random() * 15) + 6;
		age = (int) (Math.random() * 52) + 18;
		comp = comp2 = comp3 = comp4 = 100;

		int metierIn = (int) (Math.random() * choixMetier.length);
		proffession = choixMetier[metierIn];
		diplome = ChoixDiplome(education);
		int pays = (int) (Math.random() * nationnaliteP.length);
		nationnalite = nationnaliteP[pays];
	}

	private String ChoixDiplome(int arg) {
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
		if (arg <= 6)
			diplIN = 0;
		else if (arg >= 7 && arg <= 8)
			diplIN = 1;
		else if (arg >= 9 && arg <= 11)
			diplIN = 2;
		else if (arg >= 12 && arg <= 13)
			diplIN = 3;
		else if (arg >= 14 && arg <= 16)
			diplIN = 4;
		else if (arg >= 17 && arg <= 19)
			diplIN = 5;
		else if (arg >= 20 && arg <= 21)
			diplIN = 6;
		diplOut = diplomeP[diplIN];
		return diplOut;

	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResidence() {
		return residence;
	}

	public int[] getCompetenceInit() {
		return competenceInit;
	}

	public int getCompetenceInit(int arg) {
		return competenceInit[arg];
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getFamille() {
		return famille;
	}

	public void setFamille(String famille) {
		this.famille = famille;
	}

	public String getRevenu() {
		return revenu;
	}

	public void setRevenu(String revenu) {
		this.revenu = revenu;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPointCompMetier() {
		return pointCompMetier;
	}

	public void setPointCompMetier(int pointCompMetier) {
		this.pointCompMetier = pointCompMetier;
	}

	public int getPointCompPerso() {
		return pointCompPerso;
	}

	public void setPointCompPerso(int pointCompPerso) {
		this.pointCompPerso = pointCompPerso;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getDexterite() {
		return dexterite;
	}

	public void setDexterite(int dexterite) {
		this.dexterite = dexterite;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getIdee() {
		return idee;
	}

	public void setIdee(int idee) {
		this.idee = idee;
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public int getApparance() {
		return apparance;
	}

	public void setApparance(int apparance) {
		this.apparance = apparance;
	}

	public int getPouvoir() {
		return pouvoir;
	}

	public void setPouvoir(int pouvoir) {
		this.pouvoir = pouvoir;
	}

	public int getChance() {
		return chance;
	}

	public void setChance(int chance) {
		this.chance = chance;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int getSante() {
		return sante;
	}

	public void setSante(int sante) {
		this.sante = sante;
	}

	public int getEducation() {
		return education;
	}

	public void setEducation(int education) {
		this.education = education;
	}

	public int getConnaissance() {
		return connaissance;
	}

	public void setConnaissance(int connaissance) {
		this.connaissance = connaissance;
	}

	public int getSanteMentale() {
		return santeMentale;
	}

	public void setSanteMentale(int santeMentale) {
		this.santeMentale = santeMentale;
	}

	public int getPm() {
		return pm;
	}

	public void setPm(int pm) {
		this.pm = pm;
	}

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSexe() {
		return sexe;
	}

	public int getSexe2() {
		int out;
		if (sexe.equals("Homme"))
			out = 0;
		else
			out = 1;
		return out;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getNationnalite() {
		return nationnalite;
	}

	public void setNationnalite(String nationnalite) {
		this.nationnalite = nationnalite;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public String getPsyOut() {
		return PsyOut;
	}

	public void setPsyOut(String psyOut) {
		PsyOut = psyOut;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMytheC() {
		return mytheC;
	}

	public void setMytheC(int mytheC) {
		this.mytheC = mytheC;
	}

	public String getBonusDegat() {
		return bonusDegat;
	}

	public void setBonusDegat(String bonusDegat) {
		this.bonusDegat = bonusDegat;
	}

	public String getProffession() {
		return proffession;
	}

	public void setProffession(String proffession) {
		this.proffession = proffession;
	}

	public String getLangueEtr() {
		return langueEtr;
	}

	public void setLangueEtr(String langueEtr) {
		this.langueEtr = langueEtr;
	}

	public String getArmeCc() {
		return armeCc;
	}

	public void setArmeCc(String armeCc) {
		this.armeCc = armeCc;
	}

	public String getArmeF() {
		return armeF;
	}

	public void setArmeF(String armeF) {
		this.armeF = armeF;
	}

	public String getDesordrePsy() {
		return desordrePsy;
	}

	public void setDesordrePsy(String desordrePsy) {
		this.desordrePsy = desordrePsy;
	}

	public ArrayList<Boolean> getCompetenceBool() {
		return competenceBool;
	}

	public void setCompetenceBool(ArrayList<Boolean> competenceBool) {
		this.competenceBool = competenceBool;
	}

	public ArrayList<Boolean> getCompetenceBool2() {
		return competenceBool2;
	}

	public void setCompetenceBool2(ArrayList<Boolean> competenceBool2) {
		this.competenceBool2 = competenceBool2;
	}

	public ArrayList getCompMetierPerso() {
		return compMetierPerso;
	}

	public int getCompMetierPerso(int arg) {
		return (int) compMetierPerso.get(arg);
	}

	public void setCompMetierPerso(ArrayList compMetierPerso) {
		this.compMetierPerso = compMetierPerso;
	}

	public void addCompMetierPerso(int arg) {
		compMetierPerso.add(arg);
	}
	
	public void addCompMetierPerso(int arg, int arg2) {
		compMetierPerso.remove(arg);
		compMetierPerso.add(arg, arg2);
	}
	

	public ArrayList getCompPPerso() {
		return compPPerso;
	}

	public int getCompPPerso(int arg) {
		return (int) compPPerso.get(arg);
	}

	public void setCompPPerso(ArrayList compPPerso) {
		this.compPPerso = compPPerso;
	}

	public ArrayList getCompGPerso() {
		return compGPerso;
	}

	public Object getCompGPerso(int arg) {
		return compGPerso.get(arg);
	}

	public void addCompPPerso(int arg) {
		compPPerso.add(arg);
	}
	
	public void addCompPPerso(int arg, int arg2) {
		compPPerso.remove(arg);
		compPPerso.add(arg, arg2);
	}

	public void setCompGPerso(ArrayList compGPerso) {
		this.compGPerso = compGPerso;
	}

	public static Logger getLogger() {
		return logger;
	}

	public void BonusDegats() {
		// calcul du bonus de dégat

		int bonusD = getForce() + getTaille();

		if (bonusD >= 2 && bonusD <= 12) {
			bonusDegat = "-1D6";
		} else if (bonusD >= 13 && bonusD <= 16) {
			bonusDegat = "-1D4";
		} else if (bonusD >= 17 && bonusD <= 24) {
			bonusDegat = "aucun";
		} else if (bonusD >= 25 && bonusD <= 32) {
			bonusDegat = "+1D4";
		} else if (bonusD >= 33 && bonusD <= 40) {
			bonusDegat = "+1D6";
		} else if (bonusD >= 41 && bonusD <= 56) {
			bonusDegat = "+2D6";
		} else if (bonusD >= 57 && bonusD <= 72) {
			bonusDegat = "+3D6";
		} else if (bonusD >= 73 && bonusD <= 88) {
			bonusDegat = "+4D6";
		} else if (bonusD >= 89 && bonusD <= 104) {
			bonusDegat = "+5D4";
		} else if (bonusD >= 105 && bonusD <= 120) {
			bonusDegat = "+6D4";
		} else if (bonusD >= 121 && bonusD <= 136) {
			bonusDegat = "+7D4";
		} else if (bonusD >= 137 && bonusD <= 152) {
			bonusDegat = "+8D4";
		} else if (bonusD >= 153 && bonusD <= 168) {
			bonusDegat = "+9D4";
		} else if (bonusD >= 169 && bonusD <= 184) {
			bonusDegat = "+10D4";
		} else
			bonusDegat = "aucun";

	}

	public int GetMetier() {
		// actualise l'affichage du metier lors du reload
		int out = 1;
		for (int i = 0; i < choixMetier.length; i++) {
			if (getProffession().equals(choixMetier[i]))
				out = i;
		}
		return out;
	}

	public int GetLangueEtrangere() {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < langue.length; i++) {
			if (langueEtr.equals(langue[i]))
				out = i;
		}
		return out;
	}

	public int GetArmeCaC() {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < armeCC.length; i++) {
			if (armeCc.equals(armeCC[i]))
				out = i;
		}
		return out;
	}

	public int GetArmeAFeu() {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < armeFeu.length; i++) {
			if (armeF.equals(armeFeu[i]))
				out = i;
		}
		return out;
	}

	public int GetPsy() {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < Psy.length; i++) {
			if (desordrePsy.equals(Psy[i]))
				out = i;
		}
		return out;
	}

	private int[] InitSpec() {
		// initialise les valeurs initiale des compétence esquiver (dex*2) 18 et
		// langue natale(edu*5) 25
		int temp1 = dexterite * 2;
		int temp2 = education * 5;
		int[] competenceInit2 = { 0, 0, 5, 0, 0, 5, 25, 0, 0, 10, 20, 0, 15, 10, 15, 5, 25, 10, temp1, 0, 40, 20, 10,
				25, 0, temp2, 5, 20, 5, 5, 0, 25, 10, 5, 15, 0, 10, 0, 0, 30, 0, 5, 25, 10, 0, 10, 25, 20, 25, 30, 15,
				15, 25, 50, 10, 25, 0, 0, 0, 0, 0, 0, 0 };
		return competenceInit2;
	}

	public void InitSpec2() {
		
		if ((int) compMetierPerso.get(18) < competenceInit[18]) {
			compMetierPerso.remove(18);
			compMetierPerso.add(18, competenceInit[18]);
			System.out.println("ok");
		} else if (temp5 == (int) compMetierPerso.get(18)) {
		} else {
			int temp9 = (int) compMetierPerso.get(18);
			compMetierPerso.remove(18);
			compMetierPerso.add(18, temp9);
		}

		if ((int) compMetierPerso.get(25) < competenceInit[25]) {
			compMetierPerso.remove(25);
			compMetierPerso.add(25, competenceInit[25]);
			System.out.println("ok");
		} else if (temp6 == (int) compMetierPerso.get(25)) {
		} else {
			int temp9 = (int) compMetierPerso.get(25);
			compMetierPerso.remove(25);
			compMetierPerso.add(25, temp9);
		}
		temp5 = (int) compMetierPerso.get(18);
		temp6 = (int) compMetierPerso.get(25);

		if ((int) compPPerso.get(18) < competenceInit[18]) {
			compPPerso.remove(18);
			compPPerso.add(18, competenceInit[18]);
			System.out.println("ok");
		} else if (temp7 == (int) compPPerso.get(18)) {
		} else {
			int temp9 = (int) compPPerso.get(18);
			compPPerso.remove(18);
			compPPerso.add(18, temp9);
		}

		if ((int) compPPerso.get(25) < competenceInit[25]) {
			compPPerso.remove(25);
			compPPerso.add(25, competenceInit[25]);
			System.out.println("ok");
		} else if (temp8 == (int) compPPerso.get(25)) {
		} else {
			int temp9 = (int) compPPerso.get(25);
			compPPerso.remove(25);
			compPPerso.add(25, temp9);
		}

		temp7 = (int) compPPerso.get(18);
		temp8 = (int) compPPerso.get(25);
	}

	public void InitCompGeneral() {
		// initialise la List compétence générale
		final ArrayList<Boolean> competenceBoolIn = new ArrayList<Boolean>(competenceBool);
		final ArrayList<Boolean> competenceBoolOut = new ArrayList<Boolean>(competenceBool2);
		int w;
		for (w = 0; w < competence.length; w++) {
			if (competenceBoolOut.get(w).equals(true)) {
				compGPerso.add(compMetierPerso.get(w));
			} else if (competenceBoolIn.get(w).equals(true)) {
				compGPerso.add(compPPerso.get(w));
			}
		}
	}
	
	public void ClearComp() {
		
		compMetierPerso.clear();
		compPPerso.clear();
	}

	public int getComp() {
		return comp;
	}

	public void setComp(int comp) {
		this.comp = comp;
	}

	public int getComp2() {
		return comp2;
	}

	public void setComp2(int comp2) {
		this.comp2 = comp2;
	}

	public int getComp3() {
		return comp3;
	}

	public void setComp3(int comp3) {
		this.comp3 = comp3;
	}

	public int getComp4() {
		return comp4;
	}

	public void setComp4(int comp4) {
		this.comp4 = comp4;
	}

}
/*
 * for, con, pou, dex app = 3d6 = 18max tai, int = 2d6 + 8 = 20max edu = 3d6 + 3
 * = 21max san = pou * 5 = 25max
 * 
 * id�e = int * 5 chance = pou * 5 connaissance = edu*5
 * 
 * bonus degat = for + tai ==> voir tableau pages 19 du livre de regles
 * 
 * pv = con + tai / 2 pm = pou sante mentale = san
 * 
 * comp metier = edu * 20 comp personnel = int * 10
 */