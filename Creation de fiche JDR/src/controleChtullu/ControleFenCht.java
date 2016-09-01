package controleChtullu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelChtullu.PersoChtullu;
import vueChtullu.DataChtullu;
import vueChtullu.FenCht;
import vueChtullu.FenetreChtullu2;
import vueDM.FenDM;

public class ControleFenCht implements DataChtullu{
	
	PersoChtullu persoCht = null;
	static FenCht fenetre = null;
	
	private static final Logger logger = LogManager.getLogger(ControleFenCht.class.getName());

	
	public ControleFenCht(PersoChtullu persoCht) {
		this.persoCht = persoCht;
		this.fenetre = new FenCht(this, persoCht);
		logger.debug("Controle ok");
		
	}
	
	public void ItemMetier() {
		persoCht.setProffession((String) fenetre.metier.getSelectedItem());
	}
	public void ItemSexe() {
		persoCht.setSexe((String) fenetre.sexe.getSelectedItem());
	}
	
	public void reload(){
		
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
		
		persoCht.setSexe(""+fenetre.sexe.getSelectedItem());
		persoCht.setProffession(""+fenetre.metier.getSelectedItem());
		persoCht.setCompetenceBool(fenetre.getCompetenceBool());
		persoCht.setCompetenceBool2(fenetre.getCompetenceBool2());
		
		persoCht.setResidence(fenetre.residence.getText());
		persoCht.setFamille(fenetre.famille.getText());
		persoCht.setRevenu(fenetre.revenu.getText());
		persoCht.setDescription(fenetre.description.getText());
		
		persoCht.Calcul();
		comp();
		Calculcomp();
		
		
		fenetre.screen1();
			
		
	}
	
	private void Calculcomp(){
		int compT = 0;
		int cont2 = 0;
		
		
		for (int k = 0; k < competence.length; k++) {
			cont2 = persoCht.getCompetenceInit(k);
			compT = fenetre.getCompetenceBT2(k) - cont2 + compT;
		}
		
		persoCht.setPointCompPerso(persoCht.getPointCompPerso() - compT);
		
		
		int compPT = 0;
		int contP2 = 0;
		for (int k = 0; k < competence.length; k++) {
			contP2 = persoCht.getCompetenceInit(k);
			compPT = fenetre.getCompetenceBT(k) - contP2 + compPT;
		}
		
		persoCht.setPointCompMetier(persoCht.getPointCompMetier() - compPT);
		System.out.println("CalculComp, cont2 : " + cont2 + " compT : " + compT + " total : " + persoCht.getPointCompMetier());
	}
	
	public void auto() {
			persoCht.setNom(fenetre.nom.getText());
			persoCht.setSexe(""+fenetre.sexe.getSelectedItem());
			persoCht.setResidence(fenetre.residence.getText());
			persoCht.setFamille(fenetre.famille.getText());
			persoCht.setRevenu(fenetre.revenu.getText());
			persoCht.setDescription(fenetre.description.getText());
		
			persoCht.Random();
			persoCht.Calcul();
			comp();
			Calculcomp();
			
			
			fenetre.screen1();
						
			fenetre.screen1();
			
		
	}
	
	public void next() {
			logger.debug("Caractéristique perso : ");
			
			
		
	}
	
	public void persoAuto() {
		
			TousAuto auto2 = new TousAuto();
			auto2.TousAuto(fenetre.nom.getText(), fenetre.sexe.getSelectedItem().toString());
			
		
	}
	
	public void ItemLangueEtr() {
		
		persoCht.setLangueEtr(""+fenetre.langueEtr.getSelectedItem());
		
	}

	public void ItemArmeCaC(){
		
		persoCht.setArmeCc((String) fenetre.armeCaC.getSelectedItem());
		
	}

	public void ItemArmeAFeu() {
		
		persoCht.setArmeF((String) fenetre.armeAFeu.getSelectedItem());
		
	}

	public void ItemPsy() {
		
		persoCht.setDesordrePsy((String) fenetre.desordrePsy.getSelectedItem());
		
	}
	
	public void comp(){
		
		for (int m = 0; m < competence.length; m++) {
			persoCht.addCompMetierPerso(fenetre.getCompetenceBT(m));
		}
		for (int n = 0; n < competence.length; n++) {
			persoCht.addCompPPerso(fenetre.getCompetenceBT2(n));
		}
		persoCht.initSpec2();
	}
	
	
}
