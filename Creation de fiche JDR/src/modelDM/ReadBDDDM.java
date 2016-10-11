package modelDM;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelBDD.ConnexionBDD;
import modelChtullu.PersoChtullu;
import modelChtullu.ReadBDDChtullu;

public class ReadBDDDM {
	
	private static final Logger logger = LogManager.getLogger(ReadBDDDM.class.getName());
	
	PersoDM persoDm = new PersoDM();

	private static String data = "";
	private static ArrayList<String> dataTittle = new ArrayList<String>();
	
	
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
				
				persoDm.setNom(result.getString("nom"));
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
				persoDm.setPt(result.getString("pointcrea"));
				persoDm.setPointRestant(result.getInt("pointcrearestant"));
				persoDm.setTaille(result.getFloat("taille"));
				persoDm.setPoids(result.getInt("poids"));
				persoDm.setDescription(result.getString("description"));
				persoDm.setTravers(result.getString("travers"));
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
		
		String queryA = "SELECT avantage1, avantage2, avantage3, avantage4, avantage5, avantage6, avantage7, avantage8, avantage9, avantage10, avantage11, avantage12, "
				+ "avantage13, avantage14, avantage15, avantage16, avantage17, avantage18, avantage19, avantage20, avantage21, avantage22, avantage23, avantage24, avantage25, "
				+ "avantage26, avantage27, avantage28, avantage29, avantage30, avantage31, avantage32, avantage33, avantage34, avantage35, avantage36, avantage37, avantage38, "
				+ "avantage39, avantage40, avantage41, avantage42, avantage43, avantage44, avantage45, avantage46, avantage47, avantage48, avantage49, avantage50, avantage51, "
				+ "avantage52, avantage53, avantage54, avantage55, avantage56, avantage57, avantage58, avantage59, avantage60, avantage61, avantage62, avantage63, avantage64, "
				+ "avantage65, avantage66, avantage67, avantage68, avantage69, avantage70, avantage71, avantage72, avantage73, avantage74, avantage75, avantage76, avantage77, "
				+ "avantage78, avantage79, avantage80, avantage81, avantage82, avantage83, avantage84, avantage85, avantage86, avantage87, avantage88, avantage89, avantage90, "
				+ "avantage91, avantage92, avantage93, avantage94, avantage95, avantage96, avantage97, avantage98, avantage99, avantage100, avantage101, avantage102, avantage103, "
				+ "avantage104, avantage105, avantage106, avantage107, avantage108, avantage109 " 
				+ " FROM avantagedm WHERE id = " + arg;
		
		
		try {
			Statement state = ConnexionBDD.getInstance().createStatement();
			ResultSet result = state.executeQuery(queryA);
			ResultSetMetaData resultMeta = result.getMetaData();

			while (result.next()) {

				for (int j = 1; j < resultMeta.getColumnCount(); j++) {
					persoDm.addInitchkA(j - 1, result.getBoolean(j));
				}
			}
			result.close();
			state.close();
		} catch (Exception e) {
			logger.error(e);
		}
		
		
		String queryD = "SELECT desavantage1, desavantage2, desavantage3, desavantage4, desavantage5, desavantage6, desavantage7, desavantage8, desavantage9, desavantage10, desavantage11, desavantage12, desavantage13, desavantage14, desavantage15, desavantage16, desavantage17, desavantage18, desavantage19, desavantage20, desavantage21, desavantage22, desavantage23, desavantage24, desavantage25, desavantage26, desavantage27, desavantage28, desavantage29, desavantage30, desavantage31, desavantage32, desavantage33, desavantage34, desavantage35, desavantage36, desavantage37, desavantage38, desavantage39, desavantage40, desavantage41, desavantage42, desavantage43, desavantage44, desavantage45, desavantage46, desavantage47, desavantage48, desavantage49, desavantage50, desavantage51, desavantage52, desavantage53, desavantage54, desavantage55, desavantage56, desavantage57, desavantage58, desavantage59, desavantage60, desavantage61, desavantage62, desavantage63, desavantage64, desavantage65, desavantage66, desavantage67, desavantage68, desavantage69, desavantage70, desavantage71, desavantage72, desavantage73, desavantage74, desavantage75, desavantage76, desavantage77, desavantage78, desavantage79, desavantage80, desavantage81, desavantage82, desavantage83, desavantage84, desavantage85, desavantage86, desavantage87, desavantage88 "
				+ "FROM DesavantageDM WHERE id =" + arg;
		
		try {
			Statement state = ConnexionBDD.getInstance().createStatement();
			ResultSet result = state.executeQuery(queryD);
			ResultSetMetaData resultMeta = result.getMetaData();

			while (result.next()) {

				for (int j = 1; j < resultMeta.getColumnCount(); j++) {
					persoDm.addInitchkD(j - 1, result.getBoolean(j));
				}
			}
			result.close();
			state.close();
		} catch (Exception e) {
			logger.error(e);
		}
		
		String queryC = "SELECT competence1, competence2, competence3, competence4, competence5, competence6, competence7, competence8, competence9, competence10, competence11, competence12, competence13, competence14, competence15, competence16, competence17, competence18, competence19, competence20, competence21, competence22, competence23, competence24, competence25, competence26, competence27, competence28, competence29, competence30, competence31, competence32, competence33, competence34, competence35, competence36, competence37, competence38, competence39, competence40, competence41, competence42, competence43, competence44, competence45, competence46, competence47, competence48, competence49, competence50, competence51, competence52, competence53, competence54, competence55, competence56, competence57, competence58, competence59, competence60, competence61, competence62, competence63, competence64, competence65, competence66, competence67, competence68, competence69, competence70, competence71, competence72, competence73, competence74, competence75, competence76, competence77, competence78, competence79, competence80, competence81, competence82, competence83, competence84, competence85, competence86, competence87, competence88, competence89, competence90, competence91, competence92, competence93, competence94, competence95, competence96, competence97, competence98, competence99, competence100, competence101, competence102, competence103, competence104, competence105, competence106, competence107, competence108, competence109, competence110, competence111, competence112, competence113, competence114, competence115, competence116, competence117, competence118, competence119, competence120, competence121, competence122, competence123, competence124, competence125, competence126, competence127, competence128, competence129, competence130, competence131, competence132, competence133, competence134, competence135, competence136, competence137, competence138, competence139, competence140, competence141, competence142, competence143, competence144, competence145, competence146, competence147, competence148, competence149, competence150, competence151, competence152, competence153, competence154, competence155, competence156, competence157, competence158, competence159, competence160, competence161, competence162, competence163, competence164, competence165, competence166, competence167, competence168, competence169, competence170, competence171, competence172, competence173, competence174, competence175, competence176, competence177, competence178, competence179, competence180, competence181, competence182, competence183, competence184, competence185, competence186, competence187, competence188, competence189, competence190, competence191, competence192, competence193, competence194, competence195, competence196, competence197, competence198, competence199, competence200, competence201, competence202, competence203, competence204, competence205, competence206, competence207, competence208, competence209, competence210, competence211, competence212, competence213, competence214, competence215, competence216, competence217, competence218, competence219, competence220, competence221, competence222, competence223, competence224, competence225, competence226, competence227, competence228, competence229, competence230, competence231, competence232, competence233, competence234, competence235, competence236, competence237, competence238, competence239, competence240, competence241, competence242, competence243, competence244, competence245, competence246, competence247, competence248, competence249, competence250, competence251, competence252, competence253, competence254, competence255, competence256, competence257, competence258, competence259, competence260, competence261, competence262, competence263, competence264, competence265, competence266, competence267, competence268, competence269, competence270, competence271, competence272, competence273, competence274, competence275, competence276, competence277, competence278, competence279, competence280, competence281, competence282, competence283, competence284, competence285, competence286, competence287, competence288, competence289, competence290, competence291, competence292, competence293, competence294, competence295, competence296, competence297, competence298, competence299, competence300, competence301, competence302, competence303, competence304, competence305, competence306, competence307, competence308, competence309, competence310, competence311, competence312, competence313, competence314, competence315, competence316, competence317, competence318, competence319, competence320, competence321, competence322, competence323, competence324, competence325, competence326, competence327, competence328, competence329, competence330, competence331, competence332, competence333, competence334, competence335, competence336, competence337, competence338, competence339, competence340, competence341, competence342, competence343, competence344, competence345, competence346, competence347, competence348, competence349, competence350, competence351, competence352, competence353, competence354, competence355, competence356, competence357, competence358, competence359, competence360, competence361, competence362, competence363, competence364, competence365, competence366, competence367, competence368, competence369, competence370, competence371, competence372, competence373, competence374, competence375, competence376, competence377, competence378, competence379, competence380, competence381, competence382, competence383, competence384, competence385, competence386, competence387, competence388, competence389, competence390, competence391, competence392, competence393, competence394, competence395, competence396, competence397, competence398, competence399, competence400, competence401, competence402, competence403, competence404, competence405, competence406, competence407, competence408, competence409, competence410, competence411, competence412, competence413, competence414, competence415, competence416"
				+" FROM competenceDM WHERE id = " + arg;
		
		try {
			Statement state = ConnexionBDD.getInstance().createStatement();
			ResultSet result = state.executeQuery(queryC);
			ResultSetMetaData resultMeta = result.getMetaData();

			while (result.next()) {

				for (int j = 1; j < resultMeta.getColumnCount(); j++) {
					persoDm.addInitchkC(j - 1, result.getBoolean(j));
				}
			}
			result.close();
			state.close();
		} catch (Exception e) {
			logger.error(e);
		}
		
		String queryM = "SELECT magie1, magie2, magie3, magie4, magie5, magie6, magie7, magie8, magie9, magie10, magie11, magie12, magie13, magie14, magie15, magie16, magie17, magie18, magie19, magie20, magie21, magie22, magie23, magie24, magie25, magie26, magie27, magie28, magie29, magie30, magie31, magie32, magie33, magie34, magie35, magie36, magie37, magie38, magie39, magie40, magie41, magie42, magie43, magie44, magie45, magie46"
				+" FROM magieDM WHERE id = " + arg;
		
		try {
			Statement state = ConnexionBDD.getInstance().createStatement();
			ResultSet result = state.executeQuery(queryM);
			ResultSetMetaData resultMeta = result.getMetaData();

			while (result.next()) {

				for (int j = 1; j < resultMeta.getColumnCount(); j++) {
					persoDm.addInitchkM(j - 1, result.getBoolean(j));
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

}

/*
 * 
 * java -jar lib\derbyrun.jar ij
 * 
 * CONNECT 'jdbc:derby:BaseJDR';
 * 
 * CONNECT 'jdbc:derby:BaseJDR;create=true';
 
 CREATE TABLE disquemonde (ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), NOM VARCHAR(50), SEXE VARCHAR(10),
 AGE SMALLINT, PROF VARCHAR(20), NAT VARCHAR(30), RACE VARCHAR(20), FORCE SMALLINT, DEXTERITE SMALLINT, QI SMALLINT, SANTE SMALLINT, 
APPARENCE VARCHAR(50), POINTCREA VARCHAR(80), POINTCREARESTANT SMALLINT, TAILLE DOUBLE, POIDS INT, DESCRIPTION VARCHAR(200), TRAVERS VARCHAR(200), JEUX VARCHAR(15));
 
 
 */
