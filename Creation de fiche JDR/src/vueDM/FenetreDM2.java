package vueDM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import vueChtullu.JLabelP;

public class FenetreDM2 extends JFrame implements DataDM {

	private static final Logger logger = LogManager.getLogger(FenetreDM2.class.getName());

	private JPanel container = new JPanel();
	private String metier;
	private String app = "00 : Moyen";

	private int pointRestant, pointFinal;

	private ArrayList caractPerso = new ArrayList();
	private ArrayList<Boolean> initchkA = new ArrayList<Boolean>();
	private ArrayList<Boolean> initchkD = new ArrayList<Boolean>();

	private ArrayList<Boolean> initchkC = new ArrayList<Boolean>();
	JCheckBox[] chkC = new JCheckBox[choixCompetences.length];

	private ArrayList<Boolean> initchkL = new ArrayList<Boolean>();
	JCheckBox[] chkL = new JCheckBox[choixCompetences.length];

	private ArrayList<Boolean> initchkM = new ArrayList<Boolean>();
	JCheckBox[] chkM = new JCheckBox[choixMagie.length];

	private Font font = new Font("Times New Roman", Font.BOLD, 15);

	JComboBox apparence = new JComboBox(choixApparence);

	public FenetreDM2(ArrayList caractPerso, ArrayList<Boolean> initchkA, ArrayList<Boolean> initchkD) {
		this.caractPerso = caractPerso;
		this.initchkA = initchkA;
		this.initchkD = initchkD;

		pointRestant = pointFinal = (int) caractPerso.get(18);
		metier = (String) caractPerso.get(13);
		this.setTitle("Création de personnage Disque Monde : ");
		this.setSize(700, 500);
		this.setBackground(Color.white);
		this.setFont(font);
		this.setLocationRelativeTo(null);

		this.getContentPane().add(container);
		container.setBackground(Color.white);

		initVar();
		screen();
		this.setResizable(false);
		this.setVisible(true);

	}

	private void screen() {

		JLabelP comp = new JLabelP("Compétences : ", font);
		JLabelP langue = new JLabelP("Langues : ", font);
		JLabelP magie = new JLabelP("Magie : ", font);
		JLabelP labelExp = new JLabelP("Veulliez choisir vos compétences. Votre métier est : " + metier, font);
		JLabelP labelPoint = new JLabelP("Point de création restant : " + pointFinal, font);
		JLabelP labelApp = new JLabelP("Votre apparence : ", font);

		JLabel containerLabel = new JLabel();
		JPanel containerLeft = new JPanel();
		JPanel containerCompetence = new JPanel();
		JPanel containerCompetence2 = new JPanel();
		JPanel containerCompetence3 = new JPanel();
		JPanel containerCompetence4 = new JPanel();
		JPanel containerMagie = new JPanel();
		JPanel containerMagie2 = new JPanel();
		JPanel containerLabel2 = new JPanel();
		JPanel containerLabel3 = new JPanel();
		JPanel containerLabel4 = new JPanel();
		JPanel containerAction = new JPanel();
		JLabel containerApp = new JLabel();

		JScrollPane scroll = new JScrollPane(containerCompetence);
		scroll.getVerticalScrollBar().setUnitIncrement(30);
		scroll.setPreferredSize(new Dimension(400, 200));
		JScrollPane scroll2 = new JScrollPane(containerCompetence3);
		scroll2.getVerticalScrollBar().setUnitIncrement(15);
		JScrollPane scroll3 = new JScrollPane(containerMagie);
		scroll3.getVerticalScrollBar().setUnitIncrement(15);
		scroll3.setPreferredSize(new Dimension(400, 200));

		JButton random = new JButton("Caract. Auto");
		JButton tousAuto = new JButton("Perso Auto");
		JButton appercu = new JButton("Actualiser");
		JButton suivant = new JButton("Suivant");

		container.removeAll();
		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));

		Icon img = new ImageIcon(
				new ImageIcon("img/edit/bandeauDM.jpg").getImage().getScaledInstance(680, 70, Image.SCALE_DEFAULT));

		containerLabel.setIcon(img);
		containerLeft.setLayout(new FlowLayout(FlowLayout.LEFT));
		containerLeft.setBackground(Color.white);
		containerLeft.add(containerLabel);
		container.add(containerLeft);

		containerLabel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		containerLabel2.setBackground(Color.white);
		containerLabel2.add(labelPoint);
		container.add(containerLabel2);

		containerLabel4.setLayout(new FlowLayout(FlowLayout.LEFT));
		containerLabel4.setBackground(Color.white);
		containerLabel4.add(labelApp);
		container.add(containerLabel4);

		apparence.setBackground(Color.white);
		apparence.setPreferredSize(new Dimension(100, 20));
		container.add(apparence);
		apparence.setSelectedIndex(choixAppOut(app));
		apparence.addActionListener(new ItemApp());

		containerLabel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		containerLabel3.setBackground(Color.white);
		containerLabel3.add(labelExp);
		container.add(containerLabel3);

		containerCompetence.setLayout(new BoxLayout(containerCompetence, BoxLayout.PAGE_AXIS));
		containerCompetence.setBackground(Color.white);
		containerCompetence.add(comp);
		for (int g = 0; g < choixCompetences.length; g++) {
			chkC[g] = new JCheckBox(choixCompetences[g], initchkC.get(g));
			containerCompetence.add(chkC[g]);
		}
		containerCompetence4.setLayout(new BoxLayout(containerCompetence4, BoxLayout.PAGE_AXIS));

		containerMagie.setLayout(new BoxLayout(containerMagie, BoxLayout.PAGE_AXIS));
		containerMagie.setBackground(Color.white);
		containerMagie.add(magie);
		for (int r = 0; r < choixMagie.length; r++) {
			chkM[r] = new JCheckBox(choixMagie[r], initchkM.get(r));
			containerMagie.add(chkM[r]);
		}

		containerCompetence4.add(scroll);
		containerCompetence4.add(scroll3);
		containerCompetence2.setLayout(new BoxLayout(containerCompetence2, BoxLayout.LINE_AXIS));

		containerCompetence2.add(containerCompetence4);

		containerCompetence3.setLayout(new BoxLayout(containerCompetence3, BoxLayout.PAGE_AXIS));
		containerCompetence3.setBackground(Color.white);
		containerCompetence3.add(langue);
		for (int h = 0; h < choixLangues.length; h++) {
			chkL[h] = new JCheckBox(choixLangues[h], initchkL.get(h));
			containerCompetence3.add(chkL[h]);
		}

		containerCompetence2.setLayout(new BoxLayout(containerCompetence2, BoxLayout.LINE_AXIS));

		containerCompetence2.add(scroll2);
		container.add(containerCompetence2);

		container.add(containerCompetence2);

		containerAction.setLayout(new GridLayout(1, 2));
		containerAction.setBackground(Color.white);
		containerAction.add(random);
		containerAction.add(tousAuto);
		containerAction.add(appercu);
		containerAction.add(suivant);

		appercu.addActionListener(new reload());
		suivant.addActionListener(new next());
		container.add(containerAction);

		repaint();
		revalidate();

	}

	private void initVar() {
		for (int t = 0; t < choixCompetences.length; t++) {
			initchkC.add(false);
		}
		for (int v = 0; v < choixLangues.length; v++) {
			initchkL.add(false);
		}
		for (int w = 0; w < choixMagie.length; w++) {
			initchkM.add(false);
		}

	}

	private int etatCompetences() {
		int ptCompetence = 0;
		for (int jde = 0; jde < choixCompetences.length; jde++) {
			if (chkC[jde].isSelected() == true) {

				ptCompetence = ptCompetence + Integer.parseInt(chkC[jde].getText().substring(0, 2));
				initchkC.remove(jde);
				initchkC.add(jde, true);

			} else {
				initchkC.remove(jde);
				initchkC.add(jde, false);
			}

		}
		return ptCompetence;
	}

	private int etatLangues() {
		int ptlangue = 0;
		for (int jdl = 0; jdl < choixLangues.length; jdl++) {
			if (chkL[jdl].isSelected() == true) {

				ptlangue = ptlangue + Integer.parseInt(chkL[jdl].getText().substring(0, 2));
				initchkL.remove(jdl);
				initchkL.add(jdl, true);

			} else {
				initchkL.remove(jdl);
				initchkL.add(jdl, false);
			}

		}
		return ptlangue;
	}

	private int etatMagie() {

		int ptMagie = 0;
		for (int jdm = 0; jdm < choixMagie.length; jdm++) {
			if (chkM[jdm].isSelected() == true) {
				ptMagie = ptMagie + Integer.parseInt(chkM[jdm].getText().substring(0, 2));
				initchkM.remove(jdm);
				initchkM.add(jdm, true);

			} else {
				initchkM.remove(jdm);
				initchkM.add(jdm, false);
			}
		}
		return ptMagie;
	}

	private double verifAll() {
		// calcul des point de creation restant
		pointFinal = (int) (pointRestant - (etatCompetences() + etatLangues() + etatMagie() + etatApp()));
		return pointFinal;
	}

	private class reload implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			verifAll();
			screen();
		}
	}

	private class next implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// passe a la fenetre suivante et envois les donn� contenues dans
			// les List : caractPerso, avantagesPerso, desavantagesPerso,
			// traversPerso
			caractPerso.remove(18);
			caractPerso.add(18, pointFinal);
			caractPerso.add(app); // 20
			FenetreDM3 suivant = new FenetreDM3(caractPerso, initchkA, initchkD, initchkC, initchkL, initchkM);

			dispose();
		}
	}

	private int choixAppOut(String arg3) {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < choixApparence.length; i++) {
			if (arg3.equals(choixApparence[i]))
				out = i;
		}
		return out;
	}

	private class ItemApp implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			app = (String) apparence.getSelectedItem();
		}
	}

	private double etatApp() {
		double appOut = Double.parseDouble(app.substring(0, 3));
		return appOut;
	}

}
