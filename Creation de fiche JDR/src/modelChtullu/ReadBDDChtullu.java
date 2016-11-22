package modelChtullu;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelBDD.ConnexionBDD;
import vueBDD.VueBDDGen;

public class ReadBDDChtullu {

	private static final Logger logger = LogManager.getLogger(ReadBDDChtullu.class.getName());

	PersoChtullu persoCHT = new PersoChtullu(true);

	private static String data = "";


	public ReadBDDChtullu(String arg) {

		String requete = "SELECT * FROM Chtullu WHERE ID = " + arg;
	

		try {
			Statement state = ConnexionBDD.getInstance().createStatement();
			ResultSet result = state.executeQuery(requete);
			ResultSetMetaData resultMeta = result.getMetaData();

			while (result.next()) {

				for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
					if (result.getObject(i) == null) {
						data = "NULL";
					} else
						data = result.getObject(i).toString();
				}
				
				persoCHT.setId(result.getInt("id"));
				persoCHT.setNom(VerifString(result.getString("nom")));
				persoCHT.setSexe(result.getString("sexe"));
				persoCHT.setAge(result.getInt("age"));
				persoCHT.setProffession(result.getString("prof"));
				persoCHT.setNationnalite(result.getString("nat"));
				persoCHT.setResidence(result.getString("resisdence"));
				persoCHT.setDiplome(result.getString("dipl"));
				persoCHT.setForce(result.getInt("force"));
				persoCHT.setDexterite(result.getInt("dexterite"));
				persoCHT.setIntelligence(result.getInt("intelligence"));
				persoCHT.setConstitution(result.getInt("constitution"));
				persoCHT.setApparance(result.getInt("apparence"));
				persoCHT.setPouvoir(result.getInt("pouvoir"));
				persoCHT.setTaille(result.getInt("taille"));
				persoCHT.setSante(result.getInt("sante"));
				persoCHT.setEducation(result.getInt("education"));
				persoCHT.setFamille(result.getString("famille"));
				persoCHT.setRevenu(result.getString("revenu"));
				persoCHT.setLangueEtr(result.getString("langue_etrangere"));
				persoCHT.setArmeCc(result.getString("armeCC"));
				persoCHT.setArmeF(result.getString("armeFeu"));
				persoCHT.setDesordrePsy(result.getString("desordre_Psy"));
				persoCHT.setDescription(VerifString(result.getString("description")));
				persoCHT.setComp(result.getInt("comp"));
				persoCHT.setComp2(result.getInt("comp2"));
				persoCHT.setComp3(result.getInt("comp3"));
				persoCHT.setComp4(result.getInt("comp4"));

			}
			result.close();
			state.close();
		} catch (Exception e) {
			logger.error(e);
		}

		String queryM = "SELECT Anthropologie, Archeologie, Art, Art_Martiaux, Astronomie, Baratin, Bibliotheque, Camouflage, Chimie, Comptabilite, Conduire_Auto, "
				+ "Conduire_Engin_Lourd,Credit, Discretion, Dissimulation, Droit, Ecouter, Electricite, Esquiver, Geologie, Grimper, Histoire, "
				+ "Histoire_Naturel, Lancer, Langues_Etrangeres, Langue_Natale, Marchandage, Mecanique, Medecine, Monter_Cheval, Mythe_Chtullu, "
				+ "Nager, Navigation, Occultisme, Persuasion, Pharmacologie, Photographie, Physique, Piloter, Permiers_Soins, Psychanalyse, Psychologie, "
				+ "Sauter , Se_Cacher, Serrurerie, Suivre_Piste, Trouver_Objet_Cache, Arme_Poing, Fusil, Fusil_Chasse, Mitrailette, Mitrailleuse, "
				+ "Coup_Pied, Coup_Poing, Coup_Tete, Lutte, Eloquence, Dessiner_Carte, Chanter, Botanique, Pickpocket, Soigner_Empoisonnement, Soigner_Maladie FROM competencechtulluMetier WHERE ID = "
				+ arg;
		try {
			Statement stateCompM = ConnexionBDD.getInstance().createStatement();
			ResultSet resultCompM = stateCompM.executeQuery(queryM);
			ResultSetMetaData resultMetaCompM = resultCompM.getMetaData();
			
			int[] temp1 = new int[resultMetaCompM.getColumnCount()];
			
			while (resultCompM.next()) {

				for (int j = 1; j <= resultMetaCompM.getColumnCount(); j++) {
					//persoCHT.addCompMetierPerso(j - 1, resultCompM.getInt(j));
					temp1[j-1] = resultCompM.getInt(j);
				}
			}
			resultCompM.close();
			stateCompM.close();
			
			for (int j = 1; j <= resultMetaCompM.getColumnCount(); j++) {
				persoCHT.addCompMetierPerso(temp1[j-1]);
			}
			
		} catch (Exception e) {
			logger.error(e + " erreur CompMetierPerso");
		}

		String queryP = "SELECT Anthropologie, Archeologie, Art, Art_Martiaux, Astronomie, Baratin, Bibliotheque, Camouflage, Chimie, Comptabilite, Conduire_Auto, "
				+ "Conduire_Engin_Lourd,Credit, Discretion, Dissimulation, Droit, Ecouter, Electricite, Esquiver, Geologie, Grimper, Histoire, "
				+ "Histoire_Naturel, Lancer, Langues_Etrangeres, Langue_Natale, Marchandage, Mecanique, Medecine, Monter_Cheval, Mythe_Chtullu, "
				+ "Nager, Navigation, Occultisme, Persuasion, Pharmacologie, Photographie, Physique, Piloter, Permiers_Soins, Psychanalyse, Psychologie, "
				+ "Sauter , Se_Cacher, Serrurerie, Suivre_Piste, Trouver_Objet_Cache, Arme_Poing, Fusil, Fusil_Chasse, Mitrailette, Mitrailleuse, "
				+ "Coup_Pied, Coup_Poing, Coup_Tete, Lutte, Eloquence, Dessiner_Carte, Chanter, Botanique, Pickpocket, Soigner_Empoisonnement, Soigner_Maladie FROM competencechtulluPerso WHERE ID = "
				+ arg;

		try {
			Statement stateCompP = ConnexionBDD.getInstance().createStatement();
			ResultSet resultCompP = stateCompP.executeQuery(queryP);
			ResultSetMetaData resultMetaCompP = resultCompP.getMetaData();
			
			int[] temp2 = new int[resultMetaCompP.getColumnCount()];

			while (resultCompP.next()) {

				for (int j = 1; j <= resultMetaCompP.getColumnCount(); j++) {
					//persoCHT.addCompPPerso(j - 1, resultCompP.getInt(j));
					temp2[j-1] = resultCompP.getInt(j);
				}
			}
			resultCompP.close();
			stateCompP.close();
			
			for (int j = 1; j <= resultMetaCompP.getColumnCount(); j++) {
				persoCHT.addCompPPerso(temp2[j-1]);
			}
		} catch (Exception e) {
			logger.error(e + " erreur CompPPerso");
		}
		
		
	}

	public PersoChtullu getPersoCht() {
		return persoCHT;
	}
	
	public String VerifString(String str) {
		String strOut = str.replace("£", "'");
		return strOut;
	}

}

/*
 * 
 * 
 * java -jar lib\derbyrun.jar ij
 * 
 * CONNECT 'jdbc:derby:BaseJDR';
 * 
 * CONNECT 'jdbc:derby:BaseJDR;create=true';
 * 
 * 
 * CREATE TABLE CHTULLU (ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS
 * IDENTITY (START WITH 1, INCREMENT BY 1), NOM VARCHAR(50), SEXE VARCHAR(10),
 * AGE SMALLINT, PROF VARCHAR(20), NAT VARCHAR(20), RESISDENCE VARCHAR(20), DIPL
 * VARCHAR(20), FORCE SMALLINT, DEXTERITE SMALLINT, INTELLIGENCE SMALLINT,
 * CONSTITUTION SMALLINT, APPARENCE SMALLINT, POUVOIR SMALLINT, TAILLE SMALLINT,
 * SANTE SMALLINT, EDUCATION SMALLINT);
 * 
 * ALTER TABLE nom_table ADD nom_colonne type autre;
 * 
 * CREATE TABLE competencechtulluMetier (ID INT PRIMARY KEY, Anthropologie
 * SMALLINT, Archeologie SMALLINT, Art SMALLINT, Art_Martiaux SMALLINT,
 * Astronomie SMALLINT, Baratin SMALLINT, Bibliotheque SMALLINT, Camouflage
 * SMALLINT, Chimie SMALLINT, Comptabilite SMALLINT, Conduire_Auto SMALLINT,
 * Conduire_Engin_Lourd SMALLINT, Credit SMALLINT, Discretion SMALLINT,
 * Dissimulation SMALLINT, Droit SMALLINT, Ecouter SMALLINT, Electricite
 * SMALLINT, Esquiver SMALLINT, Geologie SMALLINT, Grimper SMALLINT, Histoire
 * SMALLINT, Histoire_Naturel SMALLINT, Lancer SMALLINT, Langues_Etrangeres
 * SMALLINT, Langue_Natale SMALLINT, Marchandage SMALLINT, Mecanique SMALLINT,
 * Medecine SMALLINT, Monter_Cheval SMALLINT, Mythe_Chtullu SMALLINT, Nager
 * SMALLINT, Navigation SMALLINT, Occultisme SMALLINT, Persuasion SMALLINT,
 * Pharmacologie SMALLINT, Photographie SMALLINT, Physique SMALLINT, Piloter
 * SMALLINT, Permiers_Soins SMALLINT, Psychanalyse SMALLINT, Psychologie
 * SMALLINT, Sauter SMALLINT, Se_Cacher SMALLINT, Serrurerie SMALLINT,
 * Suivre_Piste SMALLINT, Trouver_Objet_Cache SMALLINT, Arme_Poing SMALLINT,
 * Fusil SMALLINT, Fusil_Chasse SMALLINT, Mitrailette SMALLINT, Mitrailleuse
 * SMALLINT, Coup_Pied SMALLINT, Coup_Poing SMALLINT, Coup_Tete SMALLINT, Lutte
 * SMALLINT, Eloquence SMALLINT, Dessiner_Carte SMALLINT, Chanter SMALLINT,
 * Botanique SMALLINT, Pickpocket SMALLINT, Soigner_Empoisonnement SMALLINT,
 * Soigner_Maladie SMALLINT);
 * 
 * CREATE TABLE competencechtulluPerso (ID INT PRIMARY KEY, Anthropologie
 * SMALLINT, Archeologie SMALLINT, Art SMALLINT, Art_Martiaux SMALLINT,
 * Astronomie SMALLINT, Baratin SMALLINT, Bibliotheque SMALLINT, Camouflage
 * SMALLINT, Chimie SMALLINT, Comptabilite SMALLINT, Conduire_Auto SMALLINT,
 * Conduire_Engin_Lourd SMALLINT, Credit SMALLINT, Discretion SMALLINT,
 * Dissimulation SMALLINT, Droit SMALLINT, Ecouter SMALLINT, Electricite
 * SMALLINT, Esquiver SMALLINT, Geologie SMALLINT, Grimper SMALLINT, Histoire
 * SMALLINT, Histoire_Naturel SMALLINT, Lancer SMALLINT, Langues_Etrangeres
 * SMALLINT, Langue_Natale SMALLINT, Marchandage SMALLINT, Mecanique SMALLINT,
 * Medecine SMALLINT, Monter_Cheval SMALLINT, Mythe_Chtullu SMALLINT, Nager
 * SMALLINT, Navigation SMALLINT, Occultisme SMALLINT, Persuasion SMALLINT,
 * Pharmacologie SMALLINT, Photographie SMALLINT, Physique SMALLINT, Piloter
 * SMALLINT, Permiers_Soins SMALLINT, Psychanalyse SMALLINT, Psychologie
 * SMALLINT, Sauter SMALLINT, Se_Cacher SMALLINT, Serrurerie SMALLINT,
 * Suivre_Piste SMALLINT, Trouver_Objet_Cache SMALLINT, Arme_Poing SMALLINT,
 * Fusil SMALLINT, Fusil_Chasse SMALLINT, Mitrailette SMALLINT, Mitrailleuse
 * SMALLINT, Coup_Pied SMALLINT, Coup_Poing SMALLINT, Coup_Tete SMALLINT, Lutte
 * SMALLINT, Eloquence SMALLINT, Dessiner_Carte SMALLINT, Chanter SMALLINT,
 * Botanique SMALLINT, Pickpocket SMALLINT, Soigner_Empoisonnement SMALLINT,
 * Soigner_Maladie SMALLINT);
 * 
 * 
 * 
 */
