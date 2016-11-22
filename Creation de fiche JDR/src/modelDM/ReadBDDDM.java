package modelDM;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelBDD.ConnexionBDD;

public class ReadBDDDM {
	
	private static final Logger logger = LogManager.getLogger(ReadBDDDM.class.getName());
	
	PersoDM persoDm = new PersoDM();

	private static String data = "";
	
	
	
	public ReadBDDDM(String arg) {
		
		String requete = "SELECT * FROM disquemonde WHERE ID = " + arg;

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
				
				persoDm.setNom(VerifString(result.getString("nom")));
				persoDm.setSexe(result.getString("sexe"));
				persoDm.setAge(result.getInt("age"));
				persoDm.setProffession(result.getString("prof"));
				persoDm.setNationalite(result.getString("nat"));
				
				persoDm.setRace(result.getString("race"));
				persoDm.setForce(result.getInt("force"));
				persoDm.setDex(result.getInt("dexterite"));
				persoDm.setInte(result.getInt("qi"));
				persoDm.setSante(result.getInt("sante"));
								
				persoDm.setApparence(result.getString("apparence"));
				persoDm.setPt(VerifString(result.getString("pointcrea")));
				persoDm.setPointRestant(result.getInt("pointcrearestant"));
				persoDm.setTaille(result.getFloat("taille"));
				persoDm.setPoids(result.getInt("poids"));
				persoDm.setDescription(VerifString(result.getString("description")));
				persoDm.setTravers(VerifString(result.getString("travers")));
			}
			result.close();
			state.close();
		} catch (Exception e) {
			logger.error(e);
		}
		
		String queryL = "SELECT Morporkien ,Langrien ,Agateen ,Klachien ,Nain ,Troll ,Gobelin ,Nac_Mac_Feegles ,Xixixixien ,Krullien ,Uberwaldien ,Ephebien ,Tsorien FROM languedm WHERE id = " + arg;
		
		
		try {
			Statement state = ConnexionBDD.getInstance().createStatement();
			ResultSet result = state.executeQuery(queryL);
			ResultSetMetaData resultMeta = result.getMetaData();

			while (result.next()) {

				for (int j = 1; j < resultMeta.getColumnCount(); j++) {
					persoDm.addInitchkL(j - 1, result.getBoolean(j));
				}
			}
			result.close();
			state.close();
		} catch (Exception e) {
			logger.error(e);
		}
		
				
		String queryA = "SELECT * FROM avantagedm WHERE id = " + arg;
		
		try {
			Statement state = ConnexionBDD.getInstance().createStatement();
			ResultSet result = state.executeQuery(queryA);
			ResultSetMetaData resultMeta = result.getMetaData();

			while (result.next()) {

				for (int j = 1; j < resultMeta.getColumnCount(); j++) {
					String str = "avantage" + j;
					persoDm.addInitchkA(j - 1, result.getBoolean(str));
				}
			}
			result.close();
			state.close();
		} catch (Exception e) {
			logger.error(e);
		}
		
				
		String queryD = "SELECT * FROM DesavantageDM WHERE id =" + arg;
		
		try {
			Statement state = ConnexionBDD.getInstance().createStatement();
			ResultSet result = state.executeQuery(queryD);
			ResultSetMetaData resultMeta = result.getMetaData();

			while (result.next()) {

				for (int j = 1; j < resultMeta.getColumnCount(); j++) {
					String str = "desavantage" + j;
					persoDm.addInitchkD(j - 1, result.getBoolean(str));
				}
			}
			result.close();
			state.close();
		} catch (Exception e) {
			logger.error(e);
		}
		
		String queryC = "SELECT * FROM CompetencesPersoDM WHERE id = " + arg; 
		
		try {
			Statement state = ConnexionBDD.getInstance().createStatement();
			ResultSet result = state.executeQuery(queryC);
			ResultSetMetaData resultMeta = result.getMetaData();

			while (result.next()) {

				for (int j = 1; j < resultMeta.getColumnCount(); j++) {
					String str = "comp" + (j-1);
					persoDm.addInitComp(j - 1, result.getInt(str));
				}
			}
			result.close();
			state.close();
		} catch (Exception e) {
			logger.error(e);
		}
		
		
		String queryM = "SELECT * FROM magieDM WHERE id = " + arg;
		
		try {
			Statement state = ConnexionBDD.getInstance().createStatement();
			ResultSet result = state.executeQuery(queryM);
			ResultSetMetaData resultMeta = result.getMetaData();

			while (result.next()) {

				for (int j = 1; j < resultMeta.getColumnCount(); j++) {
					String str = "magie" + j;
					persoDm.addInitchkM(j - 1, result.getBoolean(str));
				}
			}
			result.close();
			state.close();
		} catch (Exception e) {
			logger.error(e);
		}
		
	}
	
	public PersoDM getPersoDM() {
		return persoDm;
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
 * CONNECT 'jdbc:derby:BaseJDR;create=true';
 
 
 */
