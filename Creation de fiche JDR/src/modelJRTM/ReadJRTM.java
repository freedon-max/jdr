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

				persoTM.setNom(VerifString(result.getString("NOM")));

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

		String queryL = "SELECT * FROM languetm WHERE ID = " + arg;

		try {
			Statement state = ConnexionBDD.getInstance().createStatement();
			ResultSet result = state.executeQuery(queryL);
			ResultSetMetaData resultMeta = result.getMetaData();

			while (result.next()) {

				for (int j = 1; j < resultMeta.getColumnCount(); j++) {
					String str = "langue" + j;
					persoTM.addInitchkL(j - 1, result.getBoolean(str));
				}
			}
			result.close();
			state.close();
		} catch (Exception e) {
			logger.error(e);
			logger.error("erreur lecture langue");
		}

		String queryC = "SELECT * FROM competencetm WHERE ID = " + arg;


		try {
			Statement state = ConnexionBDD.getInstance().createStatement();
			ResultSet result = state.executeQuery(queryC);
			ResultSetMetaData resultMeta = result.getMetaData();

			while (result.next()) {

				for (int j = 1; j < resultMeta.getColumnCount(); j++) {
					String str = "competence" + j;
					persoTM.addDegres5(j - 1, result.getInt(str));
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
	
	public String VerifString(String str) {
		String strOut = str.replace("£", "'");
		return strOut;
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