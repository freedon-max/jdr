package modelDM;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controleDM.ControleFenDM;
import vueDM.DataDM;
import vueDM.FenDM;


public class PersoDM implements DataDM {

	private static final Logger logger = LogManager.getLogger(PersoDM.class.getName());

	ControleFenDM controle = null;
	FenDM fenetre = null;

	private String nom = "";
	private String sexe = "Homme";
	private String proffession = "Aucun";
	private String nationalite = "Morporkien";
	private String race = "Humain";
	private String pt = "50 pts : moyen(gens normaux)";
	private String apparence = "00 : Moyen";
	private String description = "";
	private String travers = "";
	private int age, poids, pointCrea;
	private double pointRestant;

	private int force, dex, inte, volonte, pdv, pdf, perception, sante;
	private float vitesse, taille = 0;
	private ArrayList avantagesPerso = new ArrayList();
	private ArrayList desavantagesPerso = new ArrayList();
	private static ArrayList<Boolean> initchkA = new ArrayList<Boolean>();
	private static ArrayList<Boolean> initchkD = new ArrayList<Boolean>();
	private static ArrayList<Boolean> initchkC = new ArrayList<Boolean>();
	private static ArrayList<Boolean> initchkL = new ArrayList<Boolean>();
	private static ArrayList<Boolean> initchkM = new ArrayList<Boolean>();

	/*
	 * private static PersoDM perso = null;
	 * 
	 * public static PersoDM getInstance(){ if( perso == null){ perso = new
	 * PersoDM();
	 * 
	 * } return perso; }
	 */
	public PersoDM() {
		logger.debug("Perso ok ");
		force = dex = inte = sante = 10;

	}

	public void calcul() {
		setPdf(getSante());
		setPdv(getForce());
		setPerception(getInte());
		setVolonte(getInte());
		setVitesse((getForce() + getTaille()) / 4);

	}

	public static ArrayList<Boolean> getInitchkA() {
		return initchkA;
	}

	public static Boolean getInitchkA(int arg) {
		return initchkA.get(arg);
	}

	public static void setInitchkA(ArrayList<Boolean> initchkA) {
		PersoDM.initchkA = initchkA;
	}

	public void addInitchkA(boolean arg) {
		initchkA.add(arg);
	}

	public static ArrayList<Boolean> getInitchkD() {
		return initchkD;
	}

	public static Boolean getInitchkD(int arg) {
		return initchkD.get(arg);
	}

	public static void setInitchkD(ArrayList<Boolean> initchkD) {
		PersoDM.initchkD = initchkD;
	}

	public void addInitchkD(boolean arg) {
		initchkD.add(arg);
	}

	public static Boolean getInitchkC(int arg) {
		return initchkC.get(arg);
	}

	public static ArrayList<Boolean> getInitchkC() {
		return initchkC;
	}

	public static void setInitchkC(ArrayList<Boolean> initchkC) {
		PersoDM.initchkC = initchkC;
	}

	public void addInitchkC(boolean arg) {
		initchkC.add(arg);
	}

	public static Boolean getInitchkL(int arg) {
		return initchkL.get(arg);
	}

	public static ArrayList<Boolean> getInitchkL() {
		return initchkL;
	}

	public static void setInitchkL(ArrayList<Boolean> initchkL) {
		PersoDM.initchkL = initchkL;
	}

	public void addInitchkL(boolean arg) {
		initchkL.add(arg);
	}

	public static Boolean getInitchkM(int arg) {
		return initchkM.get(arg);
	}

	public static ArrayList<Boolean> getInitchkM() {
		return initchkM;
	}

	public static void setInitchkM(ArrayList<Boolean> initchkM) {
		PersoDM.initchkM = initchkM;
	}

	public void addInitchkM(boolean arg) {
		initchkM.add(arg);
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
		if (getSexe() == "Homme")
			out = 0;
		else
			out = 1;
		return out;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getProffession() {
		return proffession;
	}

	public void setProffession(String proffession) {
		this.proffession = proffession;
	}

	public String getApparence() {
		return apparence;
	}

	public void setApparence(String apparence) {
		this.apparence = apparence;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTravers() {
		return travers;
	}

	public void setTravers(String travers) {
		this.travers = travers;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getPt() {
		return pt;
	}

	public void setPt(String pt) {
		this.pt = pt;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public double getPointRestant() {
		return pointRestant;
	}

	public void setPointRestant(double pointRestant) {
		this.pointRestant = pointRestant;
	}

	public int getPointCrea() {
		return pointCrea;
	}

	public void setPointCrea(int pointCrea) {
		this.pointCrea = pointCrea;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public int getInte() {
		return inte;
	}

	public void setInte(int inte) {
		this.inte = inte;
	}

	public int getVolonte() {
		return volonte;
	}

	public void setVolonte(int volonte) {
		this.volonte = volonte;
	}

	public int getPdv() {
		return pdv;
	}

	public void setPdv(int pdv) {
		this.pdv = pdv;
	}

	public int getPdf() {
		return pdf;
	}

	public void setPdf(int pdf) {
		this.pdf = pdf;
	}

	public int getPerception() {
		return perception;
	}

	public void setPerception(int perception) {
		this.perception = perception;
	}

	public int getSante() {
		return sante;
	}

	public void setSante(int sante) {
		this.sante = sante;
	}

	public float getVitesse() {
		return vitesse;
	}

	public void setVitesse(float vitesse) {
		this.vitesse = vitesse;
	}

	public float getTaille() {
		return taille;
	}

	public void setTaille(float taille) {
		this.taille = taille;
	}

	public ArrayList getAvantagesPerso() {
		return avantagesPerso;
	}

	public void setAvantagesPerso(ArrayList avantagesPerso) {
		this.avantagesPerso = avantagesPerso;
	}

	public void addAvantagesPerso(String arg) {
		avantagesPerso.add(arg);
	}

	public ArrayList getDesavantagesPerso() {
		return desavantagesPerso;
	}

	public void setDesavantagesPerso(ArrayList desavantagesPerso) {
		this.desavantagesPerso = desavantagesPerso;
	}

	public void addDesavantagesPerso(String arg) {
		desavantagesPerso.add(arg);
	}

	public int getMetier() {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < choixMetier.length; i++) {
			if (proffession.equals(choixMetier[i]))
				out = i;
		}
		return out;
	}

	public int getNat() {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < choixNat.length; i++) {
			if (nationalite.equals(choixNat[i]))
				out = i;
		}
		return out;
	}

	public int getPoint() {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < choixPoint.length; i++) {
			if (pt.equals(choixPoint[i]))
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

	public int getApp() {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < choixApparence.length; i++) {
			if (apparence.equals(choixApparence[i]))
				out = i;
		}
		return out;
	}

	public void ReadPointCrea(String str) {

		if (str.equals(choixPoint[0]))
			pointCrea = 25;
		else if (str.equals(choixPoint[1]))
			pointCrea = 50;
		else if (str.equals(choixPoint[2]))
			pointCrea = 75;
		else if (str.equals(choixPoint[3]))
			pointCrea = 100;
		else if (str.equals(choixPoint[4]))
			pointCrea = 200;
		else if (str.equals(choixPoint[5]))
			pointCrea = 300;

	}

}

// pdv = fo, vol = qi, per = qi, pdf = sa, vit = fo+dx/4
// fo, dx, qi, sante ==> éditable.
