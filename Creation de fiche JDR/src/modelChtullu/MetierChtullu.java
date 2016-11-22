package modelChtullu;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelBDD.ConnexionBDD;
import vueChtullu.DataChtullu;

public class MetierChtullu implements DataChtullu{
	
	private static final Logger logger = LogManager.getLogger(MetierChtullu.class.getName());
	PersoChtullu persoCht = null;
	
	String metier, nom;

	ArrayList<Boolean> competenceBool = new ArrayList<Boolean>();
	int comp, comp2, comp3, comp4, nombreCompPerso;
	
	public MetierChtullu() {
		
	}
	
	
	public void GestionMCht(PersoChtullu obj) {
		this.persoCht = obj;
		
		metier = persoCht.getProffession();
		
		comp = persoCht.getComp(); 
		comp2 = persoCht.getComp2(); 
		comp3 = persoCht.getComp3();
		comp4 = persoCht.getComp4();
		
		persoCht.ClearCompetenceBool();
		
		
		String query = "SELECT comp1, comp2, comp3, comp4, comp5, comp6, comp7, comp8, comp9, comp10, comp11, comp12, comp13, comp14, "
				+ "comp15, comp16, comp17, comp18, comp19, comp20, comp21, comp22, comp23, comp24, comp25, comp26, comp27, comp28, comp29, comp30, comp31, "
				+ "comp32, comp33, comp34, comp35, comp36, comp37, comp38, comp39, comp40, comp41, comp42, comp43, comp44, comp45, comp46, comp47, comp48, "
				+ "comp49, comp50, comp51, comp52, comp53, comp54, comp55, comp56, comp57, comp58, comp59, comp60, comp61, comp62, comp63 FROM CompetenceBaseCht INNER JOIN metierChtullu ON CompetenceBaseCht.id = metierChtullu.id WHERE metierChtullu.metier = '" + metier + "'";
		
		
		try {
			Statement state = ConnexionBDD.getInstance().createStatement();
			ResultSet result = state.executeQuery(query);
			ResultSetMetaData resultMeta = result.getMetaData();

			
			while (result.next()) {
				
				for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
					persoCht.addCompetenceBool(result.getBoolean(i));
				}
				
			}

			result.close();
			state.close();
		} catch (Exception e) {
			logger.error(e);
		}
		
		String query2 = "SELECT CompEtr FROM metierChtullu WHERE metier = '" + metier + "'";
		try {
			Statement state = ConnexionBDD.getInstance().createStatement();
			ResultSet result = state.executeQuery(query2);
						
			while (result.next()) {
				
				nombreCompPerso = result.getInt("CompEtr");
				
			}

			result.close();
			state.close();
		} catch (Exception e) {
			logger.error(e);
		}
				
		switch (nombreCompPerso){
		case 0 : 
			break;
			
		case 1 : 
			comp = CompPerso("1ère", comp);
			persoCht.addCompetenceBool(comp, true);
			break;
		case 2 : 
			comp = CompPerso("1ère", comp);
			comp2 = CompPerso("2ème", comp2); 
			persoCht.addCompetenceBool(comp, true);
			persoCht.addCompetenceBool(comp2, true);
			break;
		case 3 : 
			comp = CompPerso("1ère", comp);
			comp2 = CompPerso("2ème", comp2);  
			comp3 = CompPerso("3ème", comp3); 
			persoCht.addCompetenceBool(comp, true);
			persoCht.addCompetenceBool(comp2, true);
			persoCht.addCompetenceBool(comp3, true);
			break;
		case 4 : 
			comp = CompPerso("1ère", comp);
			comp2 = CompPerso("2ème", comp2);  
			comp3 = CompPerso("3ème", comp3); 
			comp4 = CompPerso("4ème", comp4); 
			persoCht.addCompetenceBool(comp, true);
			persoCht.addCompetenceBool(comp2, true);
			persoCht.addCompetenceBool(comp3, true);
			persoCht.addCompetenceBool(comp4, true);
			break;
		 
		}
		
		logger.debug("Chargement ok");
		
		persoCht.setComp(comp); 
		persoCht.setComp2(comp2); 
		persoCht.setComp3(comp3);
		persoCht.setComp4(comp4);

		
	}
	
	private int CompPerso(String arg, int arg2) {
		int compOut = 0;
		if(arg2 == 100){
		
		JOptionPane jop = new JOptionPane();
		

		nom = (String) jop.showInputDialog(null, "Veuillez Choisir votre " + arg + " competence personnelle!",
				"Compétence personnel du metier : " + metier, JOptionPane.QUESTION_MESSAGE, null, competence,
				competence[0]);

		for (int f = 0; f < competence.length; f++) {
			if (competence[f].equals(nom)) {
				compOut = f;
			}
		}
		}
		else {
			compOut = arg2;
			}
		return compOut;

	}

}
