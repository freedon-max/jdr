package modelDM;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelBDD.ConnexionBDD;


public class ChargementDataDM {

	private static final Logger logger = LogManager.getLogger(ChargementDataDM.class.getName());

	public ChargementDataDM() {

	}

	public String[][] ChargementComp() {

		String[][] tempOut = null;
		String query = "SELECT * FROM ListeCompetencesDM";

		try {
			Statement state = ConnexionBDD.getInstance().createStatement();
			ResultSet result = state.executeQuery(query);

			ArrayList<String[]> temp = new ArrayList<String[]>();

			while (result.next()) {

				String[] temp3 = { VerifString(result.getString("nom")), result.getString("type"),
						"" + result.getInt("niveaumax") };
				temp.add(temp3);

			}
			result.close();
			state.close();
			tempOut = new String[temp.size()][];
			tempOut = (String[][]) temp.toArray(tempOut);

		} catch (Exception e) {
			logger.error(e + " erreur Chargement metier");
		}
		logger.debug("chargement metier ok");

		return tempOut;
	}

	private static String VerifString(String str) {
		String strOut = str.replace("£", "'");
		return strOut;
	}

	public String[] ChargementMagie() {

		String[] tempOut = null;
		String query = "SELECT * FROM ListemagieDM";

		try {
			Statement state = ConnexionBDD.getInstance().createStatement();
			ResultSet result = state.executeQuery(query);

			ArrayList<String> temp = new ArrayList<String>();

			while (result.next()) {

				String temp3 = "01 : " + VerifString(result.getString("nom")) + " : "
						+ result.getString("description");
				temp.add(temp3);

			}
			result.close();
			state.close();
			tempOut = new String[temp.size()];
			tempOut = (String[]) temp.toArray(tempOut);

		} catch (Exception e) {
			logger.error(e + " erreur Chargement magie");
		}
		logger.debug("chargement magie ok");

		return tempOut;

	}

}
