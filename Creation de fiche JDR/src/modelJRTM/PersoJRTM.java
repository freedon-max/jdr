package modelJRTM;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelDM.PersoDM;

public class PersoJRTM implements DataJRTM {

	private static final Logger logger = LogManager.getLogger(PersoJRTM.class.getName());

	private String nom = "";
	private String sexe = "Homme";
	private String race = "";
	private String cheveux = "";
	private String yeux = "";
	private String attitude = "";
	private String signeParticulier = "";
	private String profession = "";
	private String royaume = "";
	private int niveau = 1;
	private String prof2;

	private int age, taille, poids, pointPouvoir, pointExp, penaliteEncombrement, force, agilite, constitution,
			intelligence, intuition, presence, apparence = 0;
	private int bnforce, bnagilite, bnconstitution, bnintelligence, bnintuition, bnpresence, bnapparence, rforce,
			ragilite, rconstitution, rintelligence, rintuition, rpresence, tforce, tagilite, tconstitution,
			tintelligence, tintuition, tpresence, tapparence;
	private int[] bonusRace = { 5, 0, 0, 0, 0, 0 };

	private static ArrayList<Boolean> initchkL = new ArrayList<Boolean>();
	private static ArrayList degres5 = new ArrayList();
	private static ArrayList degres2 = new ArrayList();


	public PersoJRTM() {

		logger.debug("Perso ok ");
		
		for(int i = 0; i < choixCompetence.length; i++){
			degres5.add(0);
			degres2.add(0);					
		}
		for(int i = 0; i < choixLangues.length; i++){
			initchkL.add(false);						
		}
	}
	
	
	public void calcul() {
	
		CalculBonusRace calcul = new CalculBonusRace(race, this);	
				
		bnforce = calculBonus(force);
		bnagilite = calculBonus(agilite);
		bnconstitution = calculBonus(constitution);
		bnintelligence = calculBonus(intelligence);
		bnintuition = calculBonus(intuition);
		bnpresence = calculBonus(presence);
		bnapparence = calculBonus(apparence);
		
		rforce = calcul.getRforce();
		ragilite = calcul.getRagilite();
		rconstitution = calcul.getRconstitution();
		rintelligence = calcul.getRintelligence();
		rintuition = calcul.getRintuition();
		rpresence = calcul.getRpresence();	
		
		tforce = bnforce + rforce;
		tagilite = bnagilite + ragilite;
		tconstitution = bnconstitution + rconstitution;
		tintelligence = bnintelligence + rintelligence;
		tintuition = bnintuition + rintuition;
		tpresence = bnpresence + rpresence;
		tapparence = bnapparence;		
		
		initchkL = calcul.getInitchkL();
				
		degres5 = met();		
		
	}
	
	
	private int calculBonus(int arg) {
		int out = 0;
		if (arg == 1)
			out = -25;
		else if (arg == 2)
			out = -20;
		else if (arg > 2 & arg < 5)
			out = -15;
		else if (arg >= 5 & arg <= 9)
			out = -10;
		else if (arg >= 10 & arg <= 24)
			out = -5;
		else if (arg >= 25 & arg <= 74)
			out = 0;
		else if (arg >= 75 & arg <= 89)
			out = 5;
		else if (arg >= 90 & arg <= 94)
			out = 10;
		else if (arg >= 95 & arg <= 97)
			out = 15;
		else if (arg >= 98 || arg <= 99)
			out = 20;
		else if (arg == 100)
			out = 25;
		else if (arg == 101)
			out = 30;
		else if (arg >= 102)
			out = 35;

		return out;

	}
	public void clearList() {
		degres5.clear();
		degres2.clear();
		
		for(int i = 0; i < choixCompetence.length; i++){
			degres5.add(0);
			degres2.add(0);					
		}
		
	}
	
	private ArrayList  met() {
		CalculMetier cal = new CalculMetier(profession, this);
		prof2 = profession;
		return cal.getD();
		
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

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getCheveux() {
		return cheveux;
	}

	public void setCheveux(String cheveux) {
		this.cheveux = cheveux;
	}

	public String getYeux() {
		return yeux;
	}

	public void setYeux(String yeux) {
		this.yeux = yeux;
	}

	public String getAttitude() {
		return attitude;
	}

	public void setAttitude(String attitude) {
		this.attitude = attitude;
	}

	public String getSigneParticulier() {
		return signeParticulier;
	}

	public void setSigneParticulier(String signeParticulier) {
		this.signeParticulier = signeParticulier;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getRoyaume() {
		return royaume;
	}

	public void setRoyaume(String royaume) {
		this.royaume = royaume;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public int getPointPouvoir() {
		return pointPouvoir;
	}

	public void setPointPouvoir(int pointPouvoir) {
		this.pointPouvoir = pointPouvoir;
	}

	public int getPointExp() {
		return pointExp;
	}

	public void setPointExp(int pointExp) {
		this.pointExp = pointExp;
	}

	public int getPenaliteEncombrement() {
		return penaliteEncombrement;
	}

	public void setPenaliteEncombrement(int penaliteEncombrement) {
		this.penaliteEncombrement = penaliteEncombrement;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getAgilite() {
		return agilite;
	}

	public void setAgilite(int agilite) {
		this.agilite = agilite;
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getIntuition() {
		return intuition;
	}

	public void setIntuition(int intuition) {
		this.intuition = intuition;
	}

	public int getPresence() {
		return presence;
	}

	public void setPresence(int presence) {
		this.presence = presence;
	}

	public int getApparence() {
		return apparence;
	}

	public int getBnforce() {
		return bnforce;
	}

	public int getBnagilite() {
		return bnagilite;
	}

	public int getBnconstitution() {
		return bnconstitution;
	}

	public int getBnintelligence() {
		return bnintelligence;
	}

	public int getBnintuition() {
		return bnintuition;
	}

	public int getBnpresence() {
		return bnpresence;
	}

	public int getBnapparence() {
		return bnapparence;
	}

	public int getRforce() {
		return rforce;
	}

	public int getRagilite() {
		return ragilite;
	}

	public int getRconstitution() {
		return rconstitution;
	}

	public int getRintelligence() {
		return rintelligence;
	}

	public int getRintuition() {
		return rintuition;
	}

	public int getRpresence() {
		return rpresence;
	}

	public int getTforce() {
		return tforce;
	}

	public int getTagilite() {
		return tagilite;
	}

	public int getTconstitution() {
		return tconstitution;
	}

	public int getTintelligence() {
		return tintelligence;
	}

	public int getTintuition() {
		return tintuition;
	}

	public int getTpresence() {
		return tpresence;
	}

	public int getTapparence() {
		return tapparence;
	}

	public void setApparence(int apparence) {
		this.apparence = apparence;
	}

	public static ArrayList<Boolean> getInitchkL() {
		return initchkL;
	}
	public static  Boolean get2InitchkL(int arg) {
		return initchkL.get(arg);
	}
	
	public static void setInitchkL(ArrayList<Boolean> initchkL) {
		PersoJRTM.initchkL = initchkL;
	}
	
	public static ArrayList getDegres5() {
		return degres5;
	}
	public static int get2Degres5(int arg) {
		return (int) degres5.get(arg);
	}

	public static void setDegres5(ArrayList degres5) {
		PersoJRTM.degres5 = degres5;
	}
	public static void addDegres5(int arg, int arg2) {
		degres5.remove(arg);
		degres5.add(arg, arg2);
	}
	

	public static ArrayList getDegres2() {
		return degres2;
	}
	public static int get2Degres2(int arg) {
		return (int) degres2.get(arg);
	}

	public static void setDegres2(ArrayList degres2) {
		PersoJRTM.degres2 = degres2;
	}
	public static void addDegres2(int arg, int arg2) {
		degres2.remove(arg);
		degres2.add(arg, arg2);
	}

	public int getSexe2() {
		int out;
		if (getSexe() == "Homme")
			out = 0;
		else
			out = 1;
		return out;
	}

	public int getRoy() {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < choixRoyaume.length; i++) {
			if (royaume.equals(choixRoyaume[i]))
				out = i;
		}
		return out;
	}

	public int getProffs() {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < choixProfession.length; i++) {
			if (profession.equals(choixProfession[i]))
				out = i;
		}
		return out;
	}

	public int getRac() {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < choixRace.length; i++) {
			if (race.equals(choixRace[i]))
				out = i;
		}
		return out;
	}

	public int getChev() {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < choixCheveux.length; i++) {
			if (cheveux.equals(choixCheveux[i]))
				out = i;
		}
		return out;
	}

	public int getOeil() {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < choixYeux.length; i++) {
			if (yeux.equals(choixYeux[i]))
				out = i;
		}
		return out;
	}

	public int getAttit() {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < choixAttitude.length; i++) {
			if (attitude.equals(choixAttitude[i]))
				out = i;
		}
		return out;
	}

	public int getSig() {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < choixSigne.length; i++) {
			if (signeParticulier.equals(choixSigne[i]))
				out = i;
		}
		return out;
	}

}
