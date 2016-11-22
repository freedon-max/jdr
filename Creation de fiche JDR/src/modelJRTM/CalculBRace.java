package modelJRTM;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelBDD.ConnexionBDD;

public class CalculBRace implements DataJRTM {

	private static final Logger logger = LogManager.getLogger(CalculBRace.class.getName());

	PersoJRTM persoTM = null;

	private int rforce, ragilite, rconstitution, rintelligence, rintuition, rpresence, id;
	private static ArrayList degres = new ArrayList();
	private static ArrayList deg = new ArrayList();
	private static ArrayList degL = new ArrayList();
	private static ArrayList degres2 = new ArrayList();
	private static ArrayList<Boolean> initchkL = new ArrayList<Boolean>();
	private int hist;

	public CalculBRace(String arg, PersoJRTM arg2) {
		this.persoTM = arg2;
		degres = persoTM.getDegres5();
		initchkL = persoTM.getInitchkL();
		degL = persoTM.getDegLangue();
		Object[] temp = degres.toArray();

		for (int i = 0; i < choixCompetence.length; i++) {
			deg.add(0);

		}

		if (arg.equals(persoTM.getRaceTemp())) {
			hist = persoTM.getHistT();

		}

		else {

			String query = "SELECT * FROM raceJRTM WHERE nom = '" + arg + "'";

			System.err.println(" query : " + query);
			try {
				Statement state = ConnexionBDD.getInstance().createStatement();
				ResultSet result = state.executeQuery(query);
				ResultSetMetaData resultMeta = result.getMetaData();

				while (result.next()) {

					id = result.getInt("id");
					rforce = result.getInt("rforce");
					ragilite = result.getInt("ragilite");
					rconstitution = result.getInt("rconstitution");
					rintelligence = result.getInt("rintelligence");
					rintuition = result.getInt("rintuition");
					rpresence = result.getInt("rpresence");

					persoTM.setResistanceEss(result.getInt("ResistanceEss"));
					persoTM.setResistanceThe(result.getInt("ResistanceThe"));
					persoTM.setResistancePoi(result.getInt("ResistancePoi"));
					persoTM.setResistanceMal(result.getInt("ResistanceMal"));
					hist = result.getInt("hist");

				}
				result.close();
				state.close();

			} catch (Exception e) {
				logger.error(e);
				logger.error("erreur lecture raceJRTM");
			}

			String queryC = "SELECT * FROM raceCompJRTM WHERE id = " + id;

			try {
				Statement state = ConnexionBDD.getInstance().createStatement();
				ResultSet result = state.executeQuery(queryC);
				ResultSetMetaData resultMeta = result.getMetaData();

				while (result.next()) {
					for (int i = 0; i < choixCompetence.length; i++) {
						String str = "comp" + i;
						addD5(i, result.getInt(str));
					}

				}
				result.close();
				state.close();

			} catch (Exception e) {
				logger.error(e);
				logger.error("erreur lecture raceCompJRTM");
			}

			String queryL = "SELECT * FROM raceLangueJRTM WHERE id = " + id;

			try {
				Statement state = ConnexionBDD.getInstance().createStatement();
				ResultSet result = state.executeQuery(queryL);
				ResultSetMetaData resultMeta = result.getMetaData();

				while (result.next()) {
					for (int i = 0; i < choixLangues.length; i++) {
						String str = "langue" + i;
						if (result.getInt(str) > 0) {
							addDegL(i, true, result.getInt(str));
						} else {
							addDegL(i, false, result.getInt(str));
						}
					}

				}
				result.close();
				state.close();

			} catch (Exception e) {
				logger.error(e);
				logger.error("erreur lecture raceLangueJRTM");
			}

		}

		for (int i = 0; i < choixCompetence.length; i++) {
			int t = (int) temp[i];
			if ((int) degres.get(i) < t) {
				degres.remove(i);
				degres.add(i, t);
			}
		}

		persoTM.setRaceTemp(arg);
		persoTM.setHistT(hist);
		new CalculHistorique(persoTM, deg, hist);

	}

	public int getRforce() {
		return rforce;
	}

	public int getRagilite() {
		return ragilite;
	}

	public int getRconstitution() {
		return rconstitution;
	}

	public int getRintelligence() {
		return rintelligence;
	}

	public int getRintuition() {
		return rintuition;
	}

	public int getRpresence() {
		return rpresence;
	}

	public ArrayList getDegres5() {
		return degres;
	}

	public static ArrayList getDegres2() {
		return degres2;
	}

	public static ArrayList getInitchkL() {
		return initchkL;
	}

	public static ArrayList getDegL() {
		return degL;
	}

	private void addD5(int arg, int arg2) {
		degres.remove(arg);
		degres.add(arg, arg2);
		deg.remove(arg);
		deg.add(arg, arg2);
	}

	private void addDegL(int arg, boolean bool, int arg2) {
		initchkL.remove(arg);
		initchkL.add(arg, bool);
		degL.remove(arg);
		degL.add(arg, arg2);
	}

}
