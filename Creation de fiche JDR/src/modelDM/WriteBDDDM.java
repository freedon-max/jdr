package modelDM;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelBDD.ConnexionBDD;
import modelBDD.InsertBDD;
import vueDM.DataDM;

public class WriteBDDDM implements DataDM {

	PersoDM persoDm = null;

	InsertBDD insert = new InsertBDD();
	private static final Logger logger = LogManager.getLogger(WriteBDDDM.class.getName());

	public WriteBDDDM(PersoDM obj) {
		this.persoDm = obj;
		final Timestamp dateSQL = new Timestamp(new Date().getTime());

		String query = "INSERT INTO disquemonde (nom, sexe, age, prof, nat, race, force, dexterite, qi, sante, apparence, pointcrea, pointcrearestant, taille, poids, travers, description, jeux, date) "
				+ "VALUES ('" + VerifString(persoDm.getNom()) + "', '" + persoDm.getSexe() + "', " + persoDm.getAge() + ", '"
				+ persoDm.getProffession() + "', '" + persoDm.getNationalite() + "', '" + persoDm.getRace() + "', "
				+ persoDm.getForce() + ", " + persoDm.getDex() + ", " + persoDm.getInte() + ", " + persoDm.getSante()
				+ ", '" + persoDm.getApparence() + "', '" + VerifString(persoDm.getPt()) + "', " + persoDm.getPointRestant() + ", "
				+ persoDm.getTaille() + ", " + persoDm.getPoids() + ", '" + VerifString(persoDm.getTravers()) + "', '"
				+ VerifString(persoDm.getDescription()) + "', 'Discworld', '"+ dateSQL +"')";

		insert.GetInsert(query);

		int pos = InitIDComp();

		String strL = "";

		for (int i = 0; i < choixLangues.length; i++) {
			strL = strL + ", " + persoDm.getInitchkL(i);
		}

		String queryL = "INSERT INTO langueDM (id, Morporkien ,Langrien ,Agateen ,Klachien ,Nain ,Troll ,Gobelin ,Nac_Mac_Feegles ,Xixixixien ,Krullien ,Uberwaldien ,Ephebien ,Tsorien)"
				+ "VALUES (" + pos + strL + ")";

		insert.GetInsert(queryL);

		String strA = "";
		String strA1 = "";

		for (int i = 0; i < choixAvantages.length; i++) {
			strA = strA + ", " + persoDm.getInitchkA(i);
			strA1 = strA1 + ", avantage" + (i+1);
		}

		String queryA = "INSERT INTO avantageDM (id " + strA1 + ") VALUES (" + pos + strA + ")";

		insert.GetInsert(queryA);

		String strD = "";
		String strD1 = "";

		for (int i = 0; i < choixDesavantages.length; i++) {
			strD = strD + ", " + persoDm.getInitchkD(i);
			strD1 = strD1 + ", desavantage" + (i+1);
		}

		String queryD = "INSERT INTO DesavantageDM (id " + strD1 + ") VALUES (" + pos + strD + ")";

		insert.GetInsert(queryD);

		String strC = "";
		String strC1 = "";

		for (int i = 0; i < choixCompetences.length; i++) {
			strC = strC + ", " + persoDm.getInitComp(i);
			strC1 = strC1 + ", comp" + i;
		}
		

		String queryC = "INSERT INTO CompetencesPersoDM (id " + strC1 + ") VALUES (" + pos + strC + ")";

		insert.GetInsert(queryC);

		String strM = "";
		String strM1 = "";

		for (int i = 0; i < choixMagie.length; i++) {
			strM = strM + ", " + persoDm.getInitchkM(i);
			strM1 = strM1 + ", magie" + (i+1);
		}
		

		String queryM = "INSERT INTO magieDM (id " + strM1 +  ") VALUES (" + pos + strM + ")";

		insert.GetInsert(queryM);

		logger.debug("Save ok");
		insert.GetSaveOK();

	}

	private int InitIDComp() {

		// recup de l'id de la derniere entré dans le tableau

		String requete = "SELECT * FROM disquemonde";
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

