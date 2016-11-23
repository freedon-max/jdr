package vueBDD;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableColumn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controleChtullu.ControleFenCht;
import controleDM.ControleFenDM;
import controleJRTM.ControleFenJRTM;
import modelBDD.ConnexionBDD;
import modelChtullu.ReadBDDChtullu;
import modelDM.ReadBDDDM;
import modelJRTM.ReadJRTM;

public class VueBdd extends JFrame {

	private static final Logger logger = LogManager.getLogger(VueBdd.class.getName());

	private static String data = "";
	private static ArrayList<String> dataTittle = new ArrayList<String>();
	static private ArrayList<ArrayList<String>> dataOut = new ArrayList<ArrayList<String>>();

	private static String req = null;
	

	private static JPanel container = new JPanel();

	private static int var;
	private static int var4;

	public VueBdd() {

		this.setLocationRelativeTo(null);
		this.setTitle("Gestion BDD");
		this.setSize(700, 400);
		this.getContentPane().add(container);
		Screen();

		this.setVisible(true);
	}

	public void Screen() {

		Cnx(req);
		final String[] title = new String[var + 1];
		final String[][] datajT = new String[var4 + 1][var + 1];

		JPanel container3 = new JPanel();
		container3.setBackground(Color.WHITE);
		JPanel containerBouton = new JPanel();
		JButton bouton = new JButton("Actualiser");
		bouton.setBackground(Color.WHITE);
		JButton chtullu = new JButton("Chtullu");
		chtullu.setBackground(Color.WHITE);
		JButton dM = new JButton("Disque Monde");
		dM.setBackground(Color.WHITE);
		JButton jRTM = new JButton("Terre du milieu");
		jRTM.setBackground(Color.WHITE);

		for (int h = 0; h <= var4; h++) {
			ArrayList<String> temp2 = new ArrayList<String>();
			temp2.addAll((Collection<? extends String>) dataOut.get(h));

			for (int j = 0; j <= var; j++) {
				datajT[h][j] = temp2.get(j);
			}
		}

		// Les titres des colonnes

		for (int g = 0; g <= var; g++) {
			title[g] = dataTittle.get(g).toString();
		}
		final JTable tableau = new JTable(datajT, title);

		tableau.setBackground(UIManager.getColor("Button.background"));
		tableau.setFillsViewportHeight(true);

		TableColumn col = tableau.getColumnModel().getColumn(0);
		col.setPreferredWidth(15);

		TableColumn col3 = tableau.getColumnModel().getColumn(3);
		col3.setPreferredWidth(25);

		container.removeAll();
		container.setBackground(Color.WHITE);

		// affichage
		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));

		container3.setLayout(new BoxLayout(container3, BoxLayout.X_AXIS));
		container3.add(chtullu);
		container3.add(dM);
		container3.add(jRTM);
		container.add(container3);
		container.add(new JScrollPane(tableau));
		containerBouton.setLayout(new BoxLayout(containerBouton, BoxLayout.LINE_AXIS));
		containerBouton.add(bouton);
		container.add(containerBouton);

		bouton.addActionListener(new Reload());

		chtullu.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				req = "SELECT id, jeux, nom, sexe, prof, nat, date FROM chtullu WHERE date IS NOT NULL";
				dataOut.clear();
				Run();
			}
		}));

		dM.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				req = "SELECT id, jeux, nom, sexe, prof, race, date FROM disquemonde WHERE date IS NOT NULL";
				dataOut.clear();
				Run();
			}
		}));
		jRTM.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				req = "SELECT id, jeux, nom, sexe, prof, race, date FROM terremilieu WHERE date IS NOT NULL";
				dataOut.clear();
				Run();
			}
		}));

		tableau.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
				String str2 = datajT[tableau.getSelectedRow()][0];
				String strJeux = datajT[tableau.getSelectedRow()][1];
				Lanceur(strJeux, str2);

			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}
		});
		repaint();
		revalidate();

	}

	public void Run() {
		Cnx(req);
		Screen();

	}

	private class Reload implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dataOut.clear();
			setRequete(
					"SELECT id, jeux, nom, sexe, prof, date FROM chtullu WHERE date IS NOT NULL UNION SELECT id, jeux, nom, sexe, prof, date FROM disquemonde WHERE date IS NOT NULL UNION SELECT id, jeux, nom, sexe, prof, date FROM terremilieu WHERE date IS NOT NULL");
			Run();

		}
	}

	private static void Cnx(String arg4) {
		// Interroge la base de donn�es avec la requete en arg4, charge les
		// donn�es + titres dans 2 list
		ArrayList<String> tempT = new ArrayList<String>();
		int vartemp = 0;

		if (arg4 == null) {
			arg4 = "SELECT id, jeux, nom, sexe, prof, date FROM chtullu WHERE date IS NOT NULL UNION SELECT id, jeux, nom, sexe, prof, date FROM disquemonde WHERE date IS NOT NULL UNION SELECT id, jeux, nom, sexe, prof, date FROM terremilieu WHERE date IS NOT NULL";

		}

		try {
			Statement state = ConnexionBDD.getInstance().createStatement();
			ResultSet result = state.executeQuery(arg4);
			ResultSetMetaData resultMeta = result.getMetaData();

			for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
				tempT.add(resultMeta.getColumnName(i).toUpperCase());
			}
			dataTittle = tempT;
			setCol(resultMeta.getColumnCount());

			while (result.next()) {
				ArrayList<String> temp = new ArrayList<String>();
				for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
					if (result.getObject(i) == null) {
						data = "NULL";
					} else
						data = result.getObject(i).toString();
					temp.add(data);
				}
				dataOut.add(temp);
				vartemp++;
				setLigne(vartemp);

			}
			result.close();
			state.close();
		} catch (Exception e) {
			logger.error(e);
		}
		setRequete(arg4);
	}

	public static void setCol(int arg1) {
		var = arg1 - 1;
	}

	public static void setLigne(int arg2) {
		var4 = arg2 - 1;
	}

	public static void setRequete(String arg3) {
		req = arg3;

	}

	public static void insertion(String ins) {
		// execute la requetes INSERT/UPDATE ou DELETE ins
		try {
			Connection conn = ConnexionBDD.getInstance();
			Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			PreparedStatement prepare = conn.prepareStatement(ins);
			prepare.executeUpdate();
			prepare.close();
			state.close();

		} catch (Exception e) {
			logger.error(e);
		}
	}

	private void Lanceur(String arg, String str) {

		if (arg.equals("Chtullu")) {
			ReadBDDChtullu readCht = new ReadBDDChtullu(str);
			new ControleFenCht(readCht.getPersoCht(), true);
		} else if (arg.equals("Discworld")) {
			ReadBDDDM readDM = new ReadBDDDM(str);
			new ControleFenDM(readDM.getPersoDM(), true);
		} else if (arg.equals("JRTM")) {
			ReadJRTM readJRTM = new ReadJRTM(str);
			new ControleFenJRTM(readJRTM.getPersoJRTM(), true);
		}
	}

}
