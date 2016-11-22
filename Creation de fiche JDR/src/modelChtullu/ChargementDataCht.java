package modelChtullu;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelBDD.ConnexionBDD;

public class ChargementDataCht {
	
	
	private static final Logger logger = LogManager.getLogger(ChargementDataCht.class.getName());
	
	public ChargementDataCht() {
		
	}
	
	public String[] ChargementMetier() {
		
		String[] tempOut = null;
		String query = "SELECT * FROM metierChtullu";
	
	try {
		Statement state = ConnexionBDD.getInstance().createStatement();
		ResultSet result = state.executeQuery(query);
		
		ArrayList<String> temp = new ArrayList<String>();

		while (result.next()) {

			temp.add(VerifString(result.getString("metier")));

		}
		result.close();
		state.close();
		tempOut = new String[temp.size()];
		tempOut = (String[]) temp.toArray(tempOut);
		
	}	catch (Exception e) {
		logger.error(e + " erreur Chargement metier");
	}
	logger.debug("chargement metier ok");
	
	
	return tempOut;
	}
	
	private static String VerifString(String str) {
		String strOut = str.replace("£", "'");
		return strOut;
	}
	
}
