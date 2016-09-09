package controleJRTM;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelJRTM.PersoJRTM;
import vueJRTM.FenJRTM;

public class ControleFenJRTM {
	static FenJRTM fenetre = null;
	PersoJRTM persoTM = null;
	
	private static final Logger logger = LogManager.getLogger(ControleFenJRTM.class.getName());
	
	public ControleFenJRTM(PersoJRTM obj) {
		this.persoTM = obj;
		
		this.fenetre =  new FenJRTM(this, persoTM);
		
	}
	
	public void actualiser(){
		
		
		persoTM.setInitchkL(fenetre.getInitchkL());	
		persoTM.setNom(fenetre.nomPerso.getText());
		persoTM.setAge(Integer.parseInt(fenetre.agePerso.getText()));
		persoTM.setTaille(Integer.parseInt(fenetre.taille.getText()));
		persoTM.setPoids(Integer.parseInt(fenetre.poids.getText()));
		persoTM.setForce(Integer.parseInt(fenetre.force.getText()));
		persoTM.setAgilite(Integer.parseInt(fenetre.agilite.getText()));
		persoTM.setIntelligence(Integer.parseInt(fenetre.intelligence.getText()));
		persoTM.setIntuition(Integer.parseInt(fenetre.intuition.getText()));
		persoTM.setPresence(Integer.parseInt(fenetre.presence.getText()));
		persoTM.setApparence(Integer.parseInt(fenetre.apparence.getText()));
		persoTM.setNiveau(Integer.parseInt(fenetre.niveau.getText()));
		persoTM.setPointPouvoir(Integer.parseInt(fenetre.pointPou.getText()));
		persoTM.setPointExp(Integer.parseInt(fenetre.pointEX.getText()));
		fenetre.etatLangues();
		persoTM.calcul();
		fenetre.screen1();
		logger.debug("Chargement ok");
		
	}
	
	public void ItemRoy() {
		persoTM.setRoyaume((String) fenetre.royaume.getSelectedItem());
	}
	public void ItemSexe() {
		persoTM.setSexe((String) fenetre.sexe.getSelectedItem());
	}
	public void ItemRace() {
		persoTM.setRace((String) fenetre.race.getSelectedItem());
	}
	public void ItemMetier() {
		persoTM.setProfession((String) fenetre.proffs.getSelectedItem());
	}
	public void ItemSigne() {
		persoTM.setSigneParticulier((String) fenetre.signe.getSelectedItem());
	}
	public void ItemCheveux() {
		persoTM.setCheveux((String) fenetre.cheveux.getSelectedItem());
	}
	public void ItemOeil() {
		persoTM.setYeux((String) fenetre.yeux.getSelectedItem());
	}
	public void ItemAttitude() {
		persoTM.setAttitude((String) fenetre.attitude.getSelectedItem());
	}
	

}
