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
				+ "VALUES ('" + persoTM.getNom() + "', '" + persoTM.getSexe() + "', " + persoTM.getAge() + ", '"
				+ persoTM.getProfession() + "', '" + persoTM.getRace() + "', " + persoTM.getForce() + ", "
				+ persoTM.getAgilite() + ", " + persoTM.getConstitution() + ", " + persoTM.getIntelligence() + ", "
				+ persoTM.getIntuition() + "," + persoTM.getPresence() + ", " + persoTM.getApparence() + ", "
				+ persoTM.getPointPouvoir() + ", " + persoTM.getPointExp() + ", '" + persoTM.getCheveux() + "', '"
				+ persoTM.getYeux() + "', '" + persoTM.getAttitude() + "', '" + persoTM.getAlignement() + "', '"
				+ persoTM.getRoyaume() + "', " + persoTM.getNiveau() + ", " + persoTM.getPoids() + ", 'JRTM', '"+ dateSQL +"')";

		insert.GetInsert(query);

		int pos = InitIDComp();

		String strL = "";

		for (int i = 0; i < choixLangues.length; i++) {
			strL = strL + ", " + persoTM.get2InitchkL(i);
		}

		String queryL = "INSERT INTO langueTM (id, langue1, langue2, langue3, langue4, langue5, langue6, langue7, langue8, langue9, langue10, langue11, langue12, langue13, langue14, langue15, langue16, langue17, langue18, langue19, langue20, langue21, langue22, langue23)"
				+ "VALUES (" + pos + strL + ")";

		insert.GetInsert(queryL);

		String strC = "";

		for (int i = 0; i < choixCompetence.length; i++) {
			strC = strC + ", " + persoTM.get2Degres5(i);
		}

		String queryC = "INSERT INTO competenceTM (id, competence1, competence2, competence3, competence4, competence5, competence6, competence7, competence8, competence9, competence10, competence11, competence12, competence13, competence14, competence15, competence16, competence17, competence18, competence19, competence20, competence21, competence22, competence23, competence24, competence25)"
				+ " VALUES (" + pos + strC + ")";

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
			ResultSetMetaData resultMeta = result.getMetaData();

			while (result.next()) {
				if (result.last())
					out = result.getInt("id");
			}
			result.close();
			state.close();
		} catch (Exception e) {
			logger.error(e);
		}
		System.out.println(" out : " + out);
		return out;
	}

}
