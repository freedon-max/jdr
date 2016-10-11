package controleChtullu;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelChtullu.PersoChtullu;
import modelChtullu.ReadBDDChtullu;
import modelChtullu.WriteBDDChtullu;
import vueChtullu.DataChtullu;
import vueChtullu.FenCht;

public class ControleFenCht implements DataChtullu {

	PersoChtullu persoCht = null;
	static FenCht fenetre = null;

	private static final Logger logger = LogManager.getLogger(ControleFenCht.class.getName());

	public ControleFenCht(PersoChtullu persoCht) {
		this.persoCht = persoCht;
		this.fenetre = new FenCht(this, persoCht);
		logger.debug("Controle ok");

	}

	public ControleFenCht(PersoChtullu persoCht, boolean arg) {
		this.persoCht = persoCht;
		this.fenetre = new FenCht(this, persoCht);

		ChargementBDD();
		fenetre.Screen1();
		logger.debug("Controle ok");

	}

	public void ItemMetier() {
		persoCht.setProffession((String) fenetre.metier.getSelectedItem());
	}

	public void ItemSexe() {
		persoCht.setSexe((String) fenetre.sexe.getSelectedItem());
	}

	public void Reload() {

		persoCht.setNom(fenetre.nom.getText());
		persoCht.setAge(Integer.parseInt(fenetre.age.getText()));
		persoCht.setNationnalite(fenetre.nationalite.getText());
		persoCht.setDiplome(fenetre.diplome.getText());
		persoCht.setForce(Integer.parseInt(fenetre.force.getText()));
		persoCht.setIntelligence(Integer.parseInt(fenetre.intelligence.getText()));
		persoCht.setDexterite(Integer.parseInt(fenetre.dexterite.getText()));
		persoCht.setPouvoir(Integer.parseInt(fenetre.pouvoir.getText()));
		persoCht.setApparance(Integer.parseInt(fenetre.apparence.getText()));
		persoCht.setConstitution(Integer.parseInt(fenetre.constitution.getText()));
		persoCht.setEducation(Integer.parseInt(fenetre.education.getText()));
		persoCht.setTaille(Integer.parseInt(fenetre.taille.getText()));
		persoCht.setIdee(Integer.parseInt(fenetre.idee.getText()));
		persoCht.setSante(Integer.parseInt(fenetre.santer.getText()));
		persoCht.setChance(Integer.parseInt(fenetre.chance.getText()));
		persoCht.setConnaissance(Integer.parseInt(fenetre.connaissance.getText()));
		persoCht.setSanteMentale(Integer.parseInt(fenetre.santeMentale.getText()));
		persoCht.setPm(Integer.parseInt(fenetre.pointMagie.getText()));
		persoCht.setPv(Integer.parseInt(fenetre.pointVie.getText()));
		persoCht.setMytheC(Integer.parseInt(fenetre.mythe.getText()));

		persoCht.setSexe("" + fenetre.sexe.getSelectedItem());
		persoCht.setProffession("" + fenetre.metier.getSelectedItem());
		persoCht.setCompetenceBool(fenetre.GetCompetenceBool());
		persoCht.setCompetenceBool2(fenetre.GetCompetenceBool2());

		persoCht.setResidence(fenetre.residence.getText());
		persoCht.setFamille(fenetre.famille.getText());
		persoCht.setRevenu(fenetre.revenu.getText());
		persoCht.setDescription(fenetre.description.getText());
		persoCht.Calcul();
		Comp();
		Calculcomp();

		fenetre.Screen1();

	}

	private void Calculcomp() {
		int compT = 0;
		int cont2 = 0;

		for (int k = 0; k < competence.length; k++) {
			cont2 = persoCht.getCompetenceInit(k);
			compT = fenetre.GetCompetenceBT2(k) - cont2 + compT;
		}

		persoCht.setPointCompPerso(persoCht.getPointCompPerso() - compT);

		int compPT = 0;
		int contP2 = 0;
		for (int k = 0; k < competence.length; k++) {
			contP2 = persoCht.getCompetenceInit(k);
			compPT = fenetre.GetCompetenceBT(k) - contP2 + compPT;
		}

		persoCht.setPointCompMetier(persoCht.getPointCompMetier() - compPT);
		System.out.println(
				"CalculComp, cont2 : " + cont2 + " compT : " + compT + " total : " + persoCht.getPointCompMetier());
	}

	public void Auto() {
		persoCht.setNom(fenetre.nom.getText());
		persoCht.setSexe("" + fenetre.sexe.getSelectedItem());
		persoCht.setResidence(fenetre.residence.getText());
		persoCht.setFamille(fenetre.famille.getText());
		persoCht.setRevenu(fenetre.revenu.getText());
		persoCht.setDescription(fenetre.description.getText());

		persoCht.Random();

		Comp();
		Calculcomp();
		persoCht.Calcul();
		fenetre.Screen1();

	}

	public void ChargementBDD() {
		Comp();
		Calculcomp();
		persoCht.Calcul();

	}

	public void Edit() {

		JOptionPane jop1, jop2, jop3, jop4;
		if (persoCht.getPointCompMetier() > 0) {
			jop1 = new JOptionPane();
			jop1.showMessageDialog(null,
					"Il vous reste " + persoCht.getPointCompMetier() + " points de comptétence à distribuer.",
					"Attention", JOptionPane.INFORMATION_MESSAGE);
		} else if (persoCht.getPointCompMetier() < 0) {
			jop2 = new JOptionPane();
			jop2.showMessageDialog(null,
					"Vous utilisez " + persoCht.getPointCompMetier() + " points de compétence en trop.", "Attention",
					JOptionPane.INFORMATION_MESSAGE);
		} else {

			if ((persoCht.getPointCompPerso()) > 0) {
				jop3 = new JOptionPane();
				jop3.showMessageDialog(null,
						"Il vous reste " + persoCht.getPointCompPerso() + " point de comptétence à distribuer.",
						"Attention", JOptionPane.INFORMATION_MESSAGE);
			} else if (persoCht.getPointCompPerso() < 0) {
				jop4 = new JOptionPane();
				jop4.showMessageDialog(null,
						"Vous utilisez " + persoCht.getPointCompPerso() + " point de compétence en trop.", "Attention",
						JOptionPane.INFORMATION_MESSAGE);
			}

			else {
				persoCht.InitCompGeneral();
				EditCht edit = new EditCht(persoCht);
				logger.debug("Edit ok");
			}
		}

	}

	public void ItemLangueEtr() {

		persoCht.setLangueEtr("" + fenetre.langueEtr.getSelectedItem());

	}

	public void ItemArmeCaC() {

		persoCht.setArmeCc((String) fenetre.armeCaC.getSelectedItem());

	}

	public void ItemArmeAFeu() {

		persoCht.setArmeF((String) fenetre.armeAFeu.getSelectedItem());

	}

	public void ItemPsy() {

		persoCht.setDesordrePsy((String) fenetre.desordrePsy.getSelectedItem());

	}

	public void Comp() {

		for (int m = 0; m < competence.length; m++) {
			persoCht.addCompMetierPerso(fenetre.GetCompetenceBT(m));
		}
		for (int n = 0; n < competence.length; n++) {
			persoCht.addCompPPerso(fenetre.GetCompetenceBT2(n));
		}
		persoCht.InitSpec2();
	}

	
	public void Ecrire() {
		persoCht.InitCompGeneral();
		WriteBDDChtullu write = new WriteBDDChtullu(persoCht);
	}

}
