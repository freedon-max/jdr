package controleAdmin;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelBDD.ConnexionBDD;
import modelBDD.InsertBDD;
import vueAdmin.FenAdmin;
import vueChtullu.DataChtullu;

public class ControleFenAdmin implements DataChtullu {

	private static final Logger logger = LogManager.getLogger(ControleFenAdmin.class.getName());

	FenAdmin fenetre = null;
	private static boolean[] comp = new boolean[competence.length];
	private static String nomMetier, nomCompetence, typeCompetence, nomMagie, descriptionMagie;
	private static int compPerso, maxNiveauCompetence;
	private int validCht, validDM, validMDM;

	public ControleFenAdmin() {

		this.fenetre = new FenAdmin(this);
	}

	public void SaveCHT() {

		comp = fenetre.getComp();
		nomMetier = fenetre.metier.getText();
		compPerso = fenetre.comboComp.getSelectedIndex();
		validCht = ValidationCHT();
		if (validCht == 0) {
			RunCht();
		}

	}

	public void SaveDM() {

		nomCompetence = fenetre.text.getText();
		typeCompetence = (String) fenetre.typeComp.getSelectedItem();
		maxNiveauCompetence = fenetre.nbreNiveaux.getSelectedIndex() + 1;

		validDM = ValidationDM();
		if (validDM == 0) {
			RunDM();
		}

	}

	public void SaveMagieDM() {
		nomMagie = fenetre.nomMagie.getText();
		descriptionMagie = fenetre.descriptionMagie.getText();
		validMDM = ValidationMagierDm();
		if (validMDM == 0) {
			RunMDM();
		}
	}

	private int ValidationCHT() {

		JOptionPane jop = new JOptionPane();
		String validComp = "";

		for (int i = 0; i < competence.length; i++) {
			if (comp[i] == true) {
				validComp = validComp + " \n" + competence[i];
			}
		}

		int rep = jop.showConfirmDialog(null,
				" Votre nouveau métier : " + nomMetier + "\n\n avec les compétences suivantes : " + validComp
						+ "\n\n et " + compPerso + " compétences personnelles.",
				"Validation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		return rep;
	}

	private int ValidationDM() {

		JOptionPane jop = new JOptionPane();

		int rep = jop.showConfirmDialog(null,
				" Votre nouvelle compétence : " + nomCompetence + "\n\n de type : " + typeCompetence + "\n\n avec "
						+ maxNiveauCompetence + " de niveau maximum.",
				"Validation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		return rep;
	}

	private int ValidationMagierDm() {

		JOptionPane jop = new JOptionPane();

		int rep = jop.showConfirmDialog(null,
				" Votre nouveau sort : " + nomMagie + "\n\n Description : " + descriptionMagie, "Validation",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		return rep;
	}

	public static void RunCht() {

		InsertBDD insert = new InsertBDD();

		String query = "INSERT INTO metierChtullu (metier, CompEtr) VALUES ('" + VerifString(nomMetier) + "', "
				+ compPerso + ")";

		insert.GetInsert(query);

		String str = "";
		String str1 = "";

		for (int i = 0; i < competence.length; i++) {
			str = str + ", " + comp[i];
			str1 = str + ", comp" + (i+1);
		}
		int pos = InitIDComp();
		
		String query2 = "INSERT INTO CompetenceBaseCht (id +" + str1 + ") VALUES (" + pos + str + ")";

		insert.GetInsert(query2);

		logger.debug("save ok");
		JOptionPane jop1 = new JOptionPane();
		jop1.showMessageDialog(null, "Save OK", "Save ok !", JOptionPane.INFORMATION_MESSAGE);

	}

	public static void RunDM() {

		if (nomCompetence.equals("")) {
			JOptionPane jop1 = new JOptionPane();
			jop1.showMessageDialog(null, "Veuillez saisir un nom pour la compétence", "Erreur !",
					JOptionPane.ERROR_MESSAGE);
		} else {
			String query = "INSERT INTO ListeCompetencesDM (nom, type, niveaumax) VALUES ('"
					+ VerifString(nomCompetence) + "', '" + typeCompetence + "', " + maxNiveauCompetence + ")";

			InsertBDD insert = new InsertBDD();
			insert.GetInsert(query);
			int pos = ConteurComp();

			String query2 = "ALTER TABLE CompetencesPersoDM ADD COLUMN comp" + (pos + 1) + " SMALLINT";

			insert.GetInsert(query2);
			logger.debug("save ok");
		}
	}

	public static void RunMDM() {

		if (nomMagie.equals("")) {
			JOptionPane jop1 = new JOptionPane();
			jop1.showMessageDialog(null, "Veuillez saisir un nom pour le sort", "Erreur !", JOptionPane.ERROR_MESSAGE);
		} else if (descriptionMagie.equals("")) {
			JOptionPane jop1 = new JOptionPane();
			jop1.showMessageDialog(null, "Pas de description", "Erreur !", JOptionPane.ERROR_MESSAGE);
		} else {
			String query = "INSERT INTO ListemagieDM (nom, description) VALUES ('" + VerifString(nomMagie) + "', '"
					+ VerifString(descriptionMagie) + "')";

			InsertBDD insert = new InsertBDD();
			insert.GetInsert(query);
			logger.debug("save ok");
		}

	}

	private static int InitIDComp() {
		String requete = "SELECT * FROM metierChtullu";
		// recup de l'id de la derniere entré dans le tableau

		int out = 0;

		try {
			Statement state = ConnexionBDD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet result = state.executeQuery(requete);

			while (result.next()) {
				if (result.getInt("id") > out) {
					out = result.getInt("id");
				}
			}
			result.close();
			state.close();
		} catch (Exception e) {
			logger.error(e);
		}

		return out;
	}

	private static int ConteurComp() {

		int out = 0;

		try {
			Statement state = ConnexionBDD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet result = state.executeQuery("SELECT * FROM CompetencesPersoDM");
			ResultSetMetaData resultMeta = result.getMetaData();

			for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
				out++;
			}

			result.close();
			state.close();
		} catch (Exception e) {
			logger.error(e);
		}

		return out - 2;

	}

	private static String VerifString(String str) {
		String strOut = str.replace("'", "£");
		return strOut;
	}

}
