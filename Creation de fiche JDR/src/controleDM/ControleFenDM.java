package controleDM;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelDM.PersoDM;
import vueDM.DataDM;
import vueDM.FenDM;

public class ControleFenDM implements DataDM {

	private static final Logger logger = LogManager.getLogger(ControleFenDM.class.getName());
	static FenDM fenetre = null;
	PersoDM persoDisque = null;

	public ControleFenDM(PersoDM obj) {
		this.persoDisque = obj;
		logger.debug("controle ok");
		this.fenetre = new FenDM(this, persoDisque);
	}

	public void ItemNat() {
		persoDisque.setNationalite((String) fenetre.national.getSelectedItem());
	}

	public void ItemPoint() {
		persoDisque.setPt((String) fenetre.pointPerso.getSelectedItem());

	}

	public void ItemRace() {
		persoDisque.setRace((String) fenetre.race.getSelectedItem());
	}

	public void ItemMetier() {
		persoDisque.setProffession((String) fenetre.proffs.getSelectedItem());

	}

	public void ItemSexe() {
		persoDisque.setSexe((String) fenetre.sexe.getSelectedItem());
	}

	public void ItemApp() {

		persoDisque.setApparence((String) fenetre.apparence.getSelectedItem());

	}

	public void reload() {
		persoDisque.ReadPointCrea(persoDisque.getPt());
		persoDisque.setInitchkA(fenetre.getInitchkA());
		persoDisque.setInitchkD(fenetre.getInitchkD());
		persoDisque.setInitchkC(fenetre.getInitchkC());
		persoDisque.setInitchkL(fenetre.getInitchkL());
		persoDisque.setInitchkM(fenetre.getInitchkM());
		persoDisque.setNom(fenetre.nomPerso.getText());
		persoDisque.setAge(Integer.parseInt(fenetre.agePerso.getText()));
		persoDisque.setTaille(Float.parseFloat(fenetre.taille.getText()));
		persoDisque.setPoids(Integer.parseInt(fenetre.poids.getText()));
		persoDisque.setForce(Integer.parseInt(fenetre.force.getText()));
		persoDisque.setDex(Integer.parseInt(fenetre.dexterite.getText()));
		persoDisque.setInte(Integer.parseInt(fenetre.intelligence.getText()));
		persoDisque.setSante(Integer.parseInt(fenetre.sante.getText()));
		persoDisque.setDescription(fenetre.description.getText());
		persoDisque.setTravers(fenetre.travers.getText());
		persoDisque.setProffession((String) fenetre.proffs.getSelectedItem());
		persoDisque.setNationalite((String) fenetre.national.getSelectedItem());
		persoDisque.setPt((String) fenetre.pointPerso.getSelectedItem());
		persoDisque.setRace((String) fenetre.race.getSelectedItem());
		persoDisque.setApparence((String) fenetre.apparence.getSelectedItem());
		persoDisque.calcul();
		verifAll();
		logger.debug("Pt : " + persoDisque.getPt());
		fenetre.screen1();
	}

	public void next() {
		verifAll();
		EditionDM ed = new EditionDM(persoDisque);
		logger.debug("Caractéritique perso next ");

	}

	private int verifCar(int carV) {
		// calcul des point de creation restant pour la force et la sant�
		int carOut = 0;
		if (carV == 10)
			carOut = 0;
		else if (carV <= 9) {
			carOut = (10 - carV) * 10;
		} else if (carV >= 11) {
			carOut = -((carV - 10) * 10);
		}
		logger.debug(" carOut : " + carOut);
		return carOut;
	}

	private int verifCar2(int carV) {
		// calcul des point de creation restant pour le qi et la dexterit�
		int carOut = 0;
		if (carV == 10)
			carOut = 0;
		else if (carV <= 9) {
			carOut = (10 - carV) * 20;
		} else if (carV >= 11) {
			carOut = -((carV - 10) * 20);
		}
		logger.debug(" carOut2 : " + carOut);
		return carOut;
	}

	public void verifAll() {
		// calcul des point de creation restant
		persoDisque.setPointRestant(persoDisque.getPointCrea() - fenetre.etatAvantages() + fenetre.etatDesavantages()
				+ verifCar(persoDisque.getForce()) + verifCar2(persoDisque.getDex()) + verifCar2(persoDisque.getInte())
				+ verifCar(persoDisque.getSante()) - fenetre.etatCompetences() - fenetre.etatLangues()
				- fenetre.etatMagie() - fenetre.etatApp());

		logger.debug(" PointRestant : " + persoDisque.getPointRestant());

	}

}
