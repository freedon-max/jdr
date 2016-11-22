package modelChtullu;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelBDD.ConnexionBDD;
import modelBDD.InsertBDD;
import vueChtullu.DataChtullu;

public class WriteBDDChtullu implements DataChtullu {

	private static final Logger logger = LogManager.getLogger(WriteBDDChtullu.class.getName());

	PersoChtullu persoCHT = null;
	InsertBDD insert = new InsertBDD();

	public WriteBDDChtullu(PersoChtullu obj) {
		this.persoCHT = obj;
		String str = "";
		String str2 = "";
		
		final Timestamp dateSQL = new Timestamp(new Date().getTime());

		String query = "INSERT INTO chtullu (nom, sexe, age, prof, nat, resisdence, dipl, force, dexterite, intelligence, constitution, apparence, pouvoir, taille, sante, education, famille, revenu, langue_etrangere, armeCC, armeFeu, desordre_Psy, description, comp, comp2, comp3, comp4 ,jeux, date) "
				+ "VALUES ('" + VerifString(persoCHT.getNom()) + "', ' " + persoCHT.getSexe() + "', " + persoCHT.getAge() + ", '"
				+ persoCHT.getProffession() + "', '" + persoCHT.getNationnalite() + "', '" + persoCHT.getResidence()
				+ "', '" + persoCHT.getDiplome() + "', " + persoCHT.getForce() + ", " + persoCHT.getDexterite() + ","
				+ persoCHT.getIntelligence() + ", " + persoCHT.getConstitution() + ", " + persoCHT.getApparance() + ", "
				+ persoCHT.getPouvoir() + ", " + persoCHT.getTaille() + ", " + persoCHT.getSante() + ", "
				+ persoCHT.getEducation() + ", '" + persoCHT.getFamille() + "', '" + persoCHT.getRevenu() + "', '"
				+ persoCHT.getLangueEtr() + "', '" + persoCHT.getArmeCc() + "', '" + persoCHT.getArmeF() + "', '"
				+ persoCHT.getDesordrePsy() + "', '" + VerifString(persoCHT.getDescription()) + "', "
				+ persoCHT.getComp() + ", " + persoCHT.getComp2() + ", " + persoCHT.getComp3() + ", " + persoCHT.getComp4() + ", 'Chtullu', '"+ dateSQL +"')";
		
		System.err.println("query : " + query);
		insert.GetInsert(query);

		int pos = InitIDComp();

		// pour recupérer les compétence metier stocké dans la table
		// competencechtulluMetier

		for (int i = 0; i < competence.length; i++) {
			str = str + ", " + persoCHT.getCompMetierPerso(i);
		}

		String queryCompM = "INSERT INTO competencechtulluMetier (ID, Anthropologie, Archeologie, Art, Art_Martiaux, Astronomie, Baratin, Bibliotheque, Camouflage, Chimie, Comptabilite, Conduire_Auto, "
				+ "Conduire_Engin_Lourd,Credit, Discretion, Dissimulation, Droit, Ecouter, Electricite, Esquiver, Geologie, Grimper, Histoire, "
				+ "Histoire_Naturel, Lancer, Langues_Etrangeres, Langue_Natale, Marchandage, Mecanique, Medecine, Monter_Cheval, Mythe_Chtullu, "
				+ "Nager, Navigation, Occultisme, Persuasion, Pharmacologie, Photographie, Physique, Piloter, Permiers_Soins, Psychanalyse, Psychologie, "
				+ "Sauter , Se_Cacher, Serrurerie, Suivre_Piste, Trouver_Objet_Cache, Arme_Poing, Fusil, Fusil_Chasse, Mitrailette, Mitrailleuse, "
				+ "Coup_Pied, Coup_Poing, Coup_Tete, Lutte, Eloquence, Dessiner_Carte, Chanter, Botanique, Pickpocket, Soigner_Empoisonnement, Soigner_Maladie)"
				+ " VALUES (" + pos + str + ")";

		insert.GetInsert(queryCompM);

		// pour recupérer les compétence personnel stocké dans la table
		// competencechtulluPerso
		for (int i = 0; i < competence.length; i++) {
			str2 = str2 + ", " + persoCHT.getCompPPerso(i);
		}

		String queryCompP = "INSERT INTO competencechtulluPerso (ID, Anthropologie, Archeologie, Art, Art_Martiaux, Astronomie, Baratin, Bibliotheque, Camouflage, Chimie, Comptabilite, Conduire_Auto, "
				+ "Conduire_Engin_Lourd,Credit, Discretion, Dissimulation, Droit, Ecouter, Electricite, Esquiver, Geologie, Grimper, Histoire, "
				+ "Histoire_Naturel, Lancer, Langues_Etrangeres, Langue_Natale, Marchandage, Mecanique, Medecine, Monter_Cheval, Mythe_Chtullu, "
				+ "Nager, Navigation, Occultisme, Persuasion, Pharmacologie, Photographie, Physique, Piloter, Permiers_Soins, Psychanalyse, Psychologie, "
				+ "Sauter , Se_Cacher, Serrurerie, Suivre_Piste, Trouver_Objet_Cache, Arme_Poing, Fusil, Fusil_Chasse, Mitrailette, Mitrailleuse, "
				+ "Coup_Pied, Coup_Poing, Coup_Tete, Lutte, Eloquence, Dessiner_Carte, Chanter, Botanique, Pickpocket, Soigner_Empoisonnement, Soigner_Maladie)"
				+ " VALUES (" + pos + str2 + ")";

		insert.GetInsert(queryCompP);

		logger.debug("Save ok");
		insert.GetSaveOK();

	}

	private int InitIDComp() {

		// recup de l'id de la derniere entré dans le tableau

		String requete = "SELECT * FROM Chtullu";
		int out = 0;

		try {
			Statement state = ConnexionBDD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet result = state.executeQuery(requete);
			
			while (result.next()) {
				if(result.getInt("id") > out) {out = result.getInt("id");}
			}
			result.close();
			state.close();
		} catch (Exception e) {
			logger.error(e);
		}
		System.out.println(" out : " + out);
		return out;
	}
	
	public String VerifString(String str) {
		String strOut = str.replace("'", "£");
		return strOut;
	}

}
