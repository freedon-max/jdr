package modelJRTM;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelDM.PersoDM;

public class PersoJRTM implements DataJRTM {

	private static final Logger logger = LogManager.getLogger(PersoJRTM.class.getName());

	private String nom = "";
	private String sexe = "Masculin";
	private String race = "";
	private String cheveux = "";
	private String yeux = "";
	private String attitude = "";
	private String alignement = "";
	private String profession = "";
	private String royaume = "";
	private int niveau = 1;

	private int age, poids, pointPouvoir, pointExp, penaliteEncombrement, force, agilite, constitution, intelligence,
			intuition, presence, apparence = 0;

	private double taille;
	private int bnforce, bnagilite, bnconstitution, bnintelligence, bnintuition, bnpresence, bnapparence, rforce,
			ragilite, rconstitution, rintelligence, rintuition, rpresence, tforce, tagilite, tconstitution,
			tintelligence, tintuition, tpresence, tapparence;
	private int resistanceEss, resistanceThe, resistancePoi, resistanceMal;
	private int pointHit, histT;

	private String raceTemp = race;

	private static ArrayList<Boolean> initchkL = new ArrayList<Boolean>();
	private static ArrayList degLangue = new ArrayList();

	private static ArrayList degres5 = new ArrayList();
	private static ArrayList degres2 = new ArrayList();
	private static ArrayList bonusComp = new ArrayList();
	private static ArrayList bonusAff = new ArrayList();
	private static ArrayList bonusCaract = new ArrayList();
	Object[] temph;

	public PersoJRTM() {

		logger.debug("Perso ok ");

		InitVar();

	}

	public PersoJRTM(boolean arg) {

		logger.debug("Perso ok ");

		for (int i = 0; i < choixCompetence.length; i++) {

		}

	}

	private void InitVar() {
		for (int i = 0; i < choixCompetence.length; i++) {
			degres5.add(0);
			degres2.add(0);
			bonusComp.add(0);
			bonusAff.add(0);
			bonusCaract.add(0);
		}
		for (int i = 0; i < choixLangues.length; i++) {
			initchkL.add(false);
			degLangue.add(0);
		}
		temph = degres5.toArray();
	}

	public void Calcul() {

		CalculBonusRace calcul = new CalculBonusRace(race, this);

		bonusAff.clear();
		for (int i = 0; i < choixCompetence.length; i++) {
			bonusAff.add(0);
		}

		bnforce = CalculBonus(force);
		bnagilite = CalculBonus(agilite);
		bnconstitution = CalculBonus(constitution);
		bnintelligence = CalculBonus(intelligence);
		bnintuition = CalculBonus(intuition);
		bnpresence = CalculBonus(presence);
		bnapparence = CalculBonus(apparence);

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
		degres5 = calcul.getDegres5();
		degLangue = calcul.getDegL();
		Met();
		CalculDevCorp((int) degres5.get(22));
		CaractAff();

	}

	public void Random() {

		degres5.clear();
		degres2.clear();
		bonusComp.clear();
		bonusAff.clear();
		bonusCaract.clear();
		initchkL.clear();
		degLangue.clear();
		InitVar();

		force = (int) (Math.random() * 80) + 20;
		agilite = (int) (Math.random() * 80) + 20;
		constitution = (int) (Math.random() * 80) + 20;
		intelligence = (int) (Math.random() * 80) + 20;
		intuition = (int) (Math.random() * 80) + 20;
		presence = (int) (Math.random() * 80) + 20;
		apparence = (int) (Math.random() * 80) + 20;
		profession = choixProfession[(int) (Math.random() * choixProfession.length)];
		race = choixRace[(int) (Math.random() * choixRace.length)];
		cheveux = choixCheveux[(int) (Math.random() * choixCheveux.length)];
		yeux = choixYeux[(int) (Math.random() * choixYeux.length)];
		attitude = choixAttitude[(int) (Math.random() * choixAttitude.length)];
		alignement = choixAlignement[(int) (Math.random() * choixAlignement.length)];
		sexe = sex[(int) (Math.random() * sex.length)];

		if (profession == "Guerrier (FO)" || profession == "Scout (AG)") {
			royaume = choixRoyaume[(int) (Math.random() * choixRoyaume.length)];
		}

	}

	private void CalculDevCorp(int arg) {
		int devCorp = (int) (Math.random() * ((arg * 10) - arg)) + arg;
		bonusComp.remove(22);
		bonusComp.add(22, devCorp);
	}

	private void Met() {
		CalculMetier cal = new CalculMetier(profession, this);
	}

	private int CalculBonus(int arg) {
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

	public void ClearList() {
		degres5.clear();
		degres2.clear();
		initchkL.clear();
		degLangue.clear();
		for (int i = 0; i < choixCompetence.length; i++) {
			degres5.add(0);
			degres2.add(0);
		}
		for (int i = 0; i < choixLangues.length; i++) {
			initchkL.add(false);
			degLangue.add(0);
		}

	}

	public void CalHist() {

		int tempoH = 0;
		if (race != raceTemp) {

		}

		else {
			for (int i = 0; i < choixCompetence.length; i++) {
				if ((int) temph[i] < (int) degres5.get(i)) {
					tempoH = ((int) degres5.get(i) - (int) temph[i]) + tempoH;
					System.out.print(tempoH + ", ");
				}
				if ((int) temph[i] >= (int) degres5.get(i)) {
					System.out.print(tempoH + ", ");
				}
			}
			pointHit = pointHit - tempoH;

		}

	}

	private void CaractAff() {

		addBonusCaract(0, tagilite);
		addBonusCaract(1, tagilite);
		addBonusCaract(2, tagilite);
		addBonusCaract(3, tforce);
		addBonusCaract(4, tforce);
		addBonusCaract(5, tforce);
		addBonusCaract(6, tforce);
		addBonusCaract(7, tforce);
		addBonusCaract(8, tagilite);
		addBonusCaract(9, tagilite);
		addBonusCaract(10, tforce);
		addBonusCaract(11, tagilite);
		addBonusCaract(12, tintuition);
		addBonusCaract(13, tagilite);
		addBonusCaract(14, tintelligence);
		addBonusCaract(15, 00);
		addBonusCaract(16, tpresence);
		addBonusCaract(17, tintelligence);
		addBonusCaract(18, tintuition);
		addBonusCaract(19, tintelligence);
		addBonusCaract(20, tintuition);
		addBonusCaract(21, tagilite);
		addBonusCaract(22, tintuition);
		addBonusCaract(23, tconstitution);

	}

	public Object[] getTemph() {
		return temph;
	}

	public void setTemph(Object[] temph) {
		this.temph = temph;
	}

	public int getHistT() {
		return histT;
	}

	public void setHistT(int histT) {
		this.histT = histT;
	}

	public String getRaceTemp() {
		return raceTemp;
	}

	public void setRaceTemp(String arg) {
		this.raceTemp = arg;
	}

	public int getPointHit() {
		return pointHit;
	}

	public void setPointHit(int pointHit) {
		this.pointHit = pointHit;
	}

	public int getResistanceEss() {
		return resistanceEss;
	}

	public void setResistanceEss(int resistanceEss) {
		this.resistanceEss = resistanceEss;
	}

	public int getResistanceThe() {
		return resistanceThe;
	}

	public void setResistanceThe(int resistanceThe) {
		this.resistanceThe = resistanceThe;
	}

	public int getResistancePoi() {
		return resistancePoi;
	}

	public void setResistancePoi(int resistancePoi) {
		this.resistancePoi = resistancePoi;
	}

	public int getResistanceMal() {
		return resistanceMal;
	}

	public void setResistanceMal(int resistanceMal) {
		this.resistanceMal = resistanceMal;
	}

	public static ArrayList getBonusComp() {
		return bonusComp;
	}

	public static int get2BonusComp(int arg) {
		return (int) bonusComp.get(arg);
	}

	public static void setBonusComp(ArrayList bonusComp) {
		PersoJRTM.bonusComp = bonusComp;
	}

	public static ArrayList getBonusAff() {
		return bonusAff;
	}

	public static int get2BonusAff(int arg) {
		return (int) bonusAff.get(arg);
	}

	public static void addBonusAff(int arg, int arg2) {
		bonusAff.remove(arg);
		bonusAff.add(arg, arg2);
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

	public String getAlignement() {
		return alignement;
	}

	public void setAlignement(String alignement) {
		this.alignement = alignement;
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

	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
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

	public static Boolean get2InitchkL(int arg) {
		return initchkL.get(arg);
	}

	public static void setInitchkL(ArrayList<Boolean> initchkL) {
		PersoJRTM.initchkL = initchkL;
	}

	public static void clearInitchkL() {
		initchkL.clear();
	}

	public static void addInitchkL(int arg, boolean arg2) {
		initchkL.remove(arg);
		initchkL.add(arg, arg2);
	}

	public static ArrayList getDegLangue() {
		return degLangue;
	}

	public static Object get2DegLangue(int arg) {
		return degLangue.get(arg);
	}

	public static void setDegLangue(ArrayList degLangue) {
		PersoJRTM.degLangue = degLangue;
	}

	public static void clearDegLangueL() {
		degLangue.clear();
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

	public static void addBonusCaract(int arg, int arg2) {
		bonusCaract.remove(arg);
		bonusCaract.add(arg, arg2);
	}

	public static int get2BonusCaract(int arg) {
		return (int) bonusCaract.get(arg);
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

	public int GetSexe2() {
		int out;
		if (getSexe() == "Masculin")
			out = 0;
		else
			out = 1;
		return out;
	}

	public int GetRoy() {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < choixRoyaume.length; i++) {
			if (royaume.equals(choixRoyaume[i]))
				out = i;
		}
		return out;
	}

	public int GetProffs() {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < choixProfession.length; i++) {
			if (profession.equals(choixProfession[i]))
				out = i;
		}
		return out;
	}

	public int GetRac() {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < choixRace.length; i++) {
			if (race.equals(choixRace[i]))
				out = i;
		}
		return out;
	}

	public int GetChev() {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < choixCheveux.length; i++) {
			if (cheveux.equals(choixCheveux[i]))
				out = i;
		}
		return out;
	}

	public int GetOeil() {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < choixYeux.length; i++) {
			if (yeux.equals(choixYeux[i]))
				out = i;
		}
		return out;
	}

	public int GetAttit() {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < choixAttitude.length; i++) {
			if (attitude.equals(choixAttitude[i]))
				out = i;
		}
		return out;
	}

	public int GetAl() {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < choixAlignement.length; i++) {
			if (alignement.equals(choixAlignement[i]))
				out = i;
		}
		return out;
	}

}
