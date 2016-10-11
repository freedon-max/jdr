package modelJRTM;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelBDD.ConnexionBDD;

public class ReadJRTM {

	private static final Logger logger = LogManager.getLogger(ReadJRTM.class.getName());
	PersoJRTM persoTM = new PersoJRTM();

	private static String data = "";

	public ReadJRTM(String arg) {

		String requete = "SELECT * FROM terremilieu WHERE ID = " + arg;

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

				persoTM.setNom(result.getString("NOM"));

				persoTM.setSexe(result.getString("sexe"));
				persoTM.setAge(result.getInt("age"));
				persoTM.setProfession(result.getString("prof"));
				persoTM.setRace(result.getString("race"));
				persoTM.setForce(result.getInt("force"));
				persoTM.setAgilite(result.getInt("agilite"));
				persoTM.setConstitution(result.getInt("constitution"));
				persoTM.setIntelligence(result.getInt("intelligence"));
				persoTM.setIntuition(result.getInt("intuition"));
				persoTM.setApparence(result.getInt("apparence"));
				persoTM.setCheveux(result.getString("cheveux"));
				persoTM.setYeux(result.getString("yeux"));
				persoTM.setAttitude(result.getString("attitude"));
				persoTM.setAlignement(result.getString("alignement"));
				persoTM.setRoyaume(result.getString("royaume"));
				persoTM.setNiveau(result.getInt("niveau"));
				persoTM.setPoids(result.getInt("poids"));
				persoTM.setPointPouvoir(result.getInt("pointpouvoir"));
				persoTM.setPointExp(result.getInt("pointexp"));

			}
			result.close();
			state.close();
		} catch (Exception e) {
			logger.error(e);
			logger.error("erreur lecture Perso");
		}

		String queryL = "SELECT langue1, langue2, langue3, langue4, langue5, langue6, langue7, langue8, langue9, langue10, langue11, langue12, langue13, langue14, langue15, langue16, langue17, langue18, langue19, langue20, langue21, langue22, langue23 "
				+ "FROM languetm WHERE ID = " + arg;

		try {
			Statement state = ConnexionBDD.getInstance().createStatement();
			ResultSet result = state.executeQuery(queryL);
			ResultSetMetaData resultMeta = result.getMetaData();

			while (result.next()) {

				for (int j = 1; j < resultMeta.getColumnCount(); j++) {
					persoTM.addInitchkL(j - 1, result.getBoolean(j));
				}
			}
			result.close();
			state.close();
		} catch (Exception e) {
			logger.error(e);
			logger.error("erreur lecture langue");
		}

		String queryC = "SELECT competence1, competence2, competence3, competence4, competence5, competence6, competence7, competence8, competence9, competence10, competence11, competence12, competence13, competence14, competence15, competence16, competence17, competence18, competence19, competence20, competence21, competence22, competence23, competence24, competence25"
				+ " FROM competencetm WHERE ID = " + arg;


		try {
			Statement state = ConnexionBDD.getInstance().createStatement();
			ResultSet result = state.executeQuery(queryC);
			ResultSetMetaData resultMeta = result.getMetaData();

			while (result.next()) {

				for (int j = 1; j < resultMeta.getColumnCount(); j++) {
					persoTM.addDegres5(j - 1, result.getInt(j));
				}
			}
			result.close();
			state.close();
		} catch (Exception e) {
			logger.error(e);
			logger.error("erreur lecture compétence");
		}

	}

	public PersoJRTM getPersoJRTM() {
		return persoTM;
	}
}

/*
 * 
 * java -jar lib\derbyrun.jar ij
 * 
 * CONNECT 'jdbc:derby:BaseJDR';
 * 
 * 
 * CREATE TABLE terremilieu (ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS
 * IDENTITY (START WITH 1, INCREMENT BY 1), NOM VARCHAR(50), SEXE VARCHAR(10),
 * AGE SMALLINT, PROF VARCHAR(20), RACE VARCHAR(20), FORCE SMALLINT, AGILITE
 * SMALLINT, CONSTITUTION SMALLINT, INTELLIGENCE SMALLINT, INTUITION SMALLINT,
 * PRESENCE SMALLINT, APPARENCE SMALLINT, CHEVEUX VARCHAR(15), YEUX VARCHAR(15),
 * ATTITUDE VARCHAR(15), ALIGNEMENT VARCHAR(10), ROYAUME VARCHAR(15), NIVEAU
 * SMALLINT, POIDS SMALLINT, POINTPOUVOIR SMALLINT, POINTEXP INT, JEUX
 * VARCHAR(15));
 * 
 * 
 */