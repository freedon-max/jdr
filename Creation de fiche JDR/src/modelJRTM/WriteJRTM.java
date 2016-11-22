package modelJRTM;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelBDD.ConnexionBDD;
import modelBDD.InsertBDD;
import modelDM.WriteBDDDM;

public class WriteJRTM implements DataJRTM {

	PersoJRTM persoTM = null;

	InsertBDD insert = new InsertBDD();
	private static final Logger logger = LogManager.getLogger(WriteJRTM.class.getName());

	public WriteJRTM(PersoJRTM obj) {
		this.persoTM = obj;
		final Timestamp dateSQL = new Timestamp(new Date().getTime());

		String query = "INSERT INTO terremilieu (nom, sexe, age, prof, race, force, agilite, constitution, intelligence, intuition, presence, apparence, "
				+ "pointpouvoir, pointexp, cheveux, yeux, attitude, alignement, royaume, niveau, poids, jeux, date) "
				+ "VALUES ('" + VerifString(persoTM.getNom()) + "', '" + persoTM.getSexe() + "', " + persoTM.getAge() + ", '"
				+ persoTM.getProfession() + "', '" + persoTM.getRace() + "', " + persoTM.getForce() + ", "
				+ persoTM.getAgilite() + ", " + persoTM.getConstitution() + ", " + persoTM.getIntelligence() + ", "
				+ persoTM.getIntuition() + "," + persoTM.getPresence() + ", " + persoTM.getApparence() + ", "
				+ persoTM.getPointPouvoir() + ", " + persoTM.getPointExp() + ", '" + persoTM.getCheveux() + "', '"
				+ persoTM.getYeux() + "', '" + persoTM.getAttitude() + "', '" + persoTM.getAlignement() + "', '"
				+ persoTM.getRoyaume() + "', " + persoTM.getNiveau() + ", " + persoTM.getPoids() + ", 'JRTM', '"+ dateSQL +"')";

		insert.GetInsert(query);

		int pos = InitIDComp();

		String strL = "";
		String strL1 = "";

		for (int i = 0; i < choixLangues.length; i++) {
			strL = strL + ", " + persoTM.get2InitchkL(i);
			strL1 = strL1 + ", langue" + (i+1);
		}

		String queryL = "INSERT INTO langueTM (id " + strL1 + ") VALUES (" + pos + strL + ")";

		insert.GetInsert(queryL);

		String strC = "";
		String strC1 = "";

		for (int i = 0; i < choixCompetence.length; i++) {
			strC = strC + ", " + persoTM.get2Degres5(i);
			strC1 = strC1 + ", competence" + (i+1);
		}

		String queryC = "INSERT INTO competenceTM (id " + strC1 + " ) VALUES (" + pos + strC + ")";

		insert.GetInsert(queryC);

		System.out.println("Save ok");

		insert.GetSaveOK();

	}

	private int InitIDComp() {

		// recup de l'id de la derniere entré dans le tableau

		String requete = "SELECT * FROM terremilieu";
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
