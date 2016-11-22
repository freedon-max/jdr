package controleJRTM;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelJRTM.DataJRTM;
import modelJRTM.PersoJRTM;
import modelJRTM.WriteJRTM;
import vueJRTM.FenJRTM;

public class ControleFenJRTM implements DataJRTM {
	static FenJRTM fenetre = null;
	PersoJRTM persoTM = null;

	private static final Logger logger = LogManager.getLogger(ControleFenJRTM.class.getName());

	public ControleFenJRTM(PersoJRTM obj) {
		this.persoTM = obj;

		this.fenetre = new FenJRTM(this, persoTM);

	}

	public ControleFenJRTM(PersoJRTM obj, boolean arg) {
		this.persoTM = obj;
		persoTM.Calcul();
		this.fenetre = new FenJRTM(this, persoTM);

	}

	public void actualiser() {

		persoTM.setInitchkL(fenetre.getInitchkL());
		persoTM.setNom(fenetre.nomPerso.getText());
		persoTM.setAge(Integer.parseInt(fenetre.agePerso.getText()));
		persoTM.setTaille(Double.parseDouble(fenetre.taille.getText()));
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
		fenetre.EtatLangues();
		persoTM.Calcul();
		fenetre.Screen1();
		logger.debug("Chargement ok");

	}

	public void random() {
		persoTM.ClearList();
		persoTM.Random();
		persoTM.Calcul();
		fenetre.Screen1();

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
		persoTM.setAlignement((String) fenetre.alignement.getSelectedItem());
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

	public void ItemDegres5(int arg) {
		persoTM.addDegres5(arg, fenetre.comp[arg].getSelectOut());

	}

	public void ItemDegres2(int arg) {
		persoTM.addDegres2(arg, fenetre.comp[arg].getSelect2Out());
	}

	public void Edit() {
		JOptionPane jop1, jop2;
		if (persoTM.getPointHit() < 0) {

			jop1 = new JOptionPane();
			jop1.showMessageDialog(null,
					"Vous utilisez " + Math.abs(persoTM.getPointHit()) + " points d'historique en trop.", "Attention",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (persoTM.getPointHit() > 0) {
			jop2 = new JOptionPane();
			jop2.showMessageDialog(null,
					"Il vous reste " + Math.abs(persoTM.getPointHit()) + " points d'historique à distribuer.",
					"Attention", JOptionPane.INFORMATION_MESSAGE);
		} else {
			System.out.println("Edition OK !");
			new EditionJRTM(persoTM);
		}
	}

	public void ecrire() {
		new WriteJRTM(persoTM);

	}

}
