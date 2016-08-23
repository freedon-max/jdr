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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import vueChtullu.JLabelP;

public class FenetreDM extends JFrame implements DataDM {

	private JPanel container = new JPanel();

	private String nom, sexe;
	private String prof = "Aucun";
	private String nat = "Morporkien";
	private String rac = "Humain";
	private String pt = "50 pts : moyen(gens normaux)";
	private int age, poid, pointRestant, pointCrea;
	private int forc, dex, inte, vol, pdv, pdf, per, san = 0;
	private float vit, tail = 0;
	private ArrayList caractPerso = new ArrayList();
	private ArrayList avantagesPerso = new ArrayList();
	private ArrayList desavantagesPerso = new ArrayList();

	private Font font = new Font("Times New Roman", Font.BOLD, 15);
	private Font font2 = new Font("Times New Roman", Font.BOLD, 14);

	JComboBox proffs = new JComboBox(choixMetier);
	JComboBox national = new JComboBox(choixNat);
	JComboBox pointPerso = new JComboBox(choixPoint);
	JComboBox race = new JComboBox(choixRace);

	JCheckBox[] chkA = new JCheckBox[choixAvantages.length];
	JCheckBox[] chkD = new JCheckBox[choixDesavantages.length];

	private ArrayList<Boolean> initchkT = new ArrayList<Boolean>();
	private ArrayList<Boolean> initchkA = new ArrayList<Boolean>();
	private ArrayList<Boolean> initchkD = new ArrayList<Boolean>();

	final JTextField nomPerso = new JTextField(nom);
	final JTextField agePerso = new JTextField(age);
	final JTextField taille = new JTextField("" + tail);
	final JTextField poids = new JTextField(poid);
	final JTextField force = new JTextField(forc);
	final JTextField dexterite = new JTextField(dex);
	final JTextField intelligence = new JTextField(inte);
	final JTextField sante = new JTextField(san);

	public FenetreDM() {
		this.setTitle("Création de personnage Disque Monde : ");
		this.setSize(700, 500);
		this.setBackground(Color.white);
		this.setFont(font);
		this.setLocationRelativeTo(null);
		nom = choixNom();
		sexe = choixSexe2();
		initPerso();
		initVar();

		this.getContentPane().add(container);
		container.setBackground(Color.white);
		screen1();
		this.setResizable(false);
		this.setVisible(true);
	}

	private void screen1() {

		JLabel containerLabel = new JLabel();
		JPanel containerLeft = new JPanel();
		JPanel containerPerso = new JPanel();
		JPanel containerComp = new JPanel();
		JPanel containerCarac1 = new JPanel();
		JPanel containerAction = new JPanel();
		JPanel containerAvantages = new JPanel();
		JPanel containerDesavantages = new JPanel();
		JPanel containerTravers = new JPanel();
		JPanel containerPoints = new JPanel();
		JPanel containerAttention = new JPanel();

		JButton random = new JButton("Caract. Auto");
		JButton tousAuto = new JButton("Perso Auto");
		JButton appercu = new JButton("Actualiser");
		JButton suivant = new JButton("Suivant");

		JLabelP avantages = new JLabelP("Avantages (retire des Points)", font);
		JLabelP desavantages = new JLabelP("Desavantage (ajoute des Points)", font);
		JLabelP travers = new JLabelP("Travers (ajoute des Pts)", font);
		JLabelP labelPoint = new JLabelP("Point de création restant : ", font);
		JLabelP labelPointR = new JLabelP("" + pointRestant, font);
		JLabelP PdV = new JLabelP("" + pdv, font);
		JLabelP volonte = new JLabelP("" + vol, font);
		JLabelP perception = new JLabelP("" + per, font);
		JLabelP Pdf = new JLabelP("" + pdf, font);
		JLabelP vitesse = new JLabelP("" + vit, font);

		JScrollPane scroll = new JScrollPane(containerAvantages);
		JScrollPane scroll2 = new JScrollPane(containerDesavantages);
		scroll.getVerticalScrollBar().setUnitIncrement(20);
		scroll2.getVerticalScrollBar().setUnitIncrement(20);

		nom = "" + caractPerso.get(0);
		sexe = "" + caractPerso.get(1);
		agePerso.setText("" + caractPerso.get(2));
		taille.setText("" + caractPerso.get(3));
		poids.setText("" + caractPerso.get(4));
		force.setText("" + caractPerso.get(5));
		dexterite.setText("" + caractPerso.get(6));
		intelligence.setText("" + caractPerso.get(7));
		sante.setText("" + caractPerso.get(8));
		PdV.setText("" + caractPerso.get(9));
		volonte.setText("" + caractPerso.get(10));
		perception.setText("" + caractPerso.get(11));
		Pdf.setText("" + caractPerso.get(12));
		prof = (String) caractPerso.get(13);
		nat = (String) caractPerso.get(14);
		rac = (String) caractPerso.get(15);
		pt = (String) caractPerso.get(16);
		pointCrea = (int) caractPerso.get(17);
		pointRestant = (int) caractPerso.get(18);
		vitesse.setText("" + caractPerso.get(19));

		container.removeAll();

		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
		// affichage de l'id du perso

		Icon img = new ImageIcon(
				new ImageIcon("img/edit/bandeauDM.jpg").getImage().getScaledInstance(680, 70, Image.SCALE_DEFAULT));

		containerLabel.setIcon(img);
		containerLeft.setLayout(new FlowLayout(FlowLayout.LEFT));
		containerLeft.setBackground(Color.white);
		containerLeft.add(containerLabel);
		container.add(containerLeft);

		containerPerso.setLayout(new GridLayout(4, 4));
		containerPerso.setBackground(Color.white);

		containerPerso.add(new JLabelP(" Nom : " + nom, font));
		containerPerso.add(new JLabelP(" Sexe : " + sexe, font));

		containerPerso.add(new JLabelP(" Age : ", font));
		containerPerso.add(agePerso);
		containerPerso.add(new JLabelP(" Nationnalité : ", font));
		national.setPreferredSize(new Dimension(100, 20));
		national.setBackground(Color.white);
		containerPerso.add(national);
		national.setSelectedIndex(choixNatOut(nat));
		national.addActionListener(new ItemNat());
		containerPerso.add(new JLabelP(" Proffession : ", font));

		proffs.setBackground(Color.white);
		proffs.setPreferredSize(new Dimension(100, 20));
		containerPerso.add(proffs);
		proffs.setSelectedIndex(choixMetierOut(prof));
		proffs.addActionListener(new ItemMetier());

		containerPerso.add(new JLabelP(" Race : ", font));
		race.setPreferredSize(new Dimension(100, 20));
		race.setBackground(Color.white);
		containerPerso.add(race);
		race.setSelectedIndex(choixRaceOut(rac));
		race.addActionListener(new ItemRace());

		containerPerso.add(new JLabelP(" Taille : ", font));
		containerPerso.add(taille);
		containerPerso.add(new JLabelP(" Poids : ", font));
		containerPerso.add(poids);
		containerPerso.add(new JLabelP(" Vitesse : ", font));
		containerPerso.add(vitesse);
		container.add(containerPerso);

		containerCarac1.setLayout(new GridLayout(2, 8));
		containerCarac1.setBackground(Color.white);
		containerCarac1.add(new JLabelP(" FO : ", font));
		containerCarac1.add(force);
		containerCarac1.add(new JLabelP(" DX : ", font));
		containerCarac1.add(dexterite);
		containerCarac1.add(new JLabelP(" QI : ", font));
		containerCarac1.add(intelligence);
		containerCarac1.add(new JLabelP(" SA : ", font));
		containerCarac1.add(sante);
		containerCarac1.add(new JLabelP(" PdV : ", font));
		containerCarac1.add(PdV);
		containerCarac1.add(new JLabelP(" Vol : ", font));
		containerCarac1.add(volonte);
		containerCarac1.add(new JLabelP(" Per : ", font));
		containerCarac1.add(perception);
		containerCarac1.add(new JLabelP(" PdF : ", font));
		containerCarac1.add(Pdf);
		container.add(containerCarac1);

		containerPoints.setLayout(new FlowLayout());
		containerPoints.setBackground(Color.white);
		pointPerso.setPreferredSize(new Dimension(400, 20));
		pointPerso.setBackground(Color.white);
		containerPoints.add(pointPerso);
		pointPerso.setSelectedIndex(choixPointOut(pt));
		pointPerso.addActionListener(new ItemPoint());

		containerPoints.add(labelPoint);
		containerPoints.add(labelPoint);
		containerPoints.add(labelPointR);
		container.add(containerPoints);
		containerAttention.setBackground(Color.white);
		containerAttention.setLayout(new FlowLayout(FlowLayout.LEFT));
		containerAttention.add(new JLabelP(
				"Attention : pensez à garder des points de création pour vos compétences (idéalement : votre age x 2).",
				font2));
		container.add(containerAttention);
		containerComp.setLayout(new BoxLayout(containerComp, BoxLayout.LINE_AXIS));
		containerComp.setBackground(Color.white);

		containerAvantages.setLayout(new BoxLayout(containerAvantages, BoxLayout.PAGE_AXIS));
		containerAvantages.setBackground(Color.white);
		containerAvantages.add(avantages);
		for (int g = 0; g < choixAvantages.length; g++) {
			chkA[g] = new JCheckBox(choixAvantages[g], initchkA.get(g));
			containerAvantages.add(chkA[g]);
		}

		scroll.setBackground(Color.white);
		containerComp.add(scroll);

		containerDesavantages.setLayout(new BoxLayout(containerDesavantages, BoxLayout.PAGE_AXIS));
		containerDesavantages.setBackground(Color.white);
		containerDesavantages.add(desavantages);
		for (int h = 0; h < choixDesavantages.length; h++) {
			chkD[h] = new JCheckBox(choixDesavantages[h], initchkD.get(h));
			containerDesavantages.add(chkD[h]);
		}
		scroll2.setBackground(Color.white);
		containerComp.add(scroll2);

		container.add(containerComp);

		containerAction.setLayout(new GridLayout(1, 2));
		containerAction.setBackground(Color.white);
		containerAction.add(random);
		containerAction.add(tousAuto);
		containerAction.add(appercu);
		containerAction.add(suivant);
		// tousAuto.addActionListener(new persoAuto());
		appercu.addActionListener(new reload());
		suivant.addActionListener(new next());
		// random.addActionListener(new auto());

		container.add(containerAction);

		repaint();
		revalidate();
	}

	private String choixNom() {
		// choix du non du perso
		JOptionPane jop = new JOptionPane();

		String nom = jop.showInputDialog(null, "Veuillez choisir le nom de votre perso : ", "Nom : ",
				JOptionPane.QUESTION_MESSAGE);

		return nom;
	}

	private String choixSexe2() {
		// choix du sexe du perso
		String[] sexeT = { "Homme", "Femme" };
		JOptionPane jop2 = new JOptionPane();

		String sexeO = (String) jop2.showInputDialog(null, "Veuillez choisir le sexe de votre perso :", "Sexe : ",
				JOptionPane.QUESTION_MESSAGE, null, sexeT, sexeT[0]);

		return sexeO;
	}

	private int choixMetierOut(String arg) {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < choixMetier.length; i++) {
			if (arg.equals(choixMetier[i]))
				out = i;
		}
		return out;
	}

	private class ItemMetier implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			prof = (String) proffs.getSelectedItem();
			System.out.println("ActionListener : action sur " + prof);
		}
	}

	private int choixNatOut(String arg1) {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < choixNat.length; i++) {
			if (arg1.equals(choixNat[i]))
				out = i;
		}
		return out;
	}

	private class ItemNat implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			nat = (String) national.getSelectedItem();
			System.out.println("ActionListener : action nat sur " + nat);
		}
	}

	private int choixPointOut(String arg2) {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < choixPoint.length; i++) {
			if (arg2.equals(choixPoint[i]))
				out = i;
		}
		return out;
	}

	private class ItemPoint implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pt = (String) pointPerso.getSelectedItem();
			System.out.println("ActionListener : action sur " + pt);
		}
	}

	private void ReadPointCrea(String str) {

		if (str.equals(choixPoint[0]))
			pointCrea = 25;
		else if (str.equals(choixPoint[1]))
			pointCrea = 50;
		else if (str.equals(choixPoint[2]))
			pointCrea = 75;
		else if (str.equals(choixPoint[3]))
			pointCrea = 100;
		else if (str.equals(choixPoint[4]))
			pointCrea = 200;
		else if (str.equals(choixPoint[5]))
			pointCrea = 300;

	}

	private int choixRaceOut(String arg3) {
		// actualise l'affichage du metier lors du reload
		int out = 0;
		for (int i = 0; i < choixRace.length; i++) {
			if (arg3.equals(choixRace[i]))
				out = i;
		}
		return out;
	}

	private class ItemRace implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			rac = (String) race.getSelectedItem();
			System.out.println("ActionListener : action sur " + rac);
		}
	}

	private class reload implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			ReadPointCrea((String) pointPerso.getSelectedItem());
			System.out.println("nombre point : " + pointCrea);
			// etatTravers();
			// etatAvantages();
			// etatDesavantages();

			// pointRestant = pointCrea - etatAvantages() + etatTravers() +
			// etatDesavantages();
			verifAll();
			savePerso();
			screen1();
		}
	}

	private void savePerso() {

		pdv = Integer.parseInt(force.getText());
		vol = Integer.parseInt(intelligence.getText());
		per = Integer.parseInt(intelligence.getText());
		pdf = Integer.parseInt(sante.getText());
		vit = (Integer.parseInt(force.getText()) + Integer.parseInt(dexterite.getText())) / 4;

		caractPerso.clear();
		caractPerso.add(nom); // 0
		caractPerso.add(sexe); // 1
		caractPerso.add(agePerso.getText()); // 2
		caractPerso.add(taille.getText()); // 3
		caractPerso.add(poids.getText()); // 4
		caractPerso.add(force.getText()); // 5
		caractPerso.add(dexterite.getText()); // 6
		caractPerso.add(intelligence.getText()); // 7
		caractPerso.add(sante.getText()); // 8
		caractPerso.add(pdv); // 9
		caractPerso.add(vol); // 10
		caractPerso.add(per); // 11
		caractPerso.add(pdf); // 12
		caractPerso.add(prof); // 13
		caractPerso.add(nat); // 14
		caractPerso.add(rac); // 15
		caractPerso.add(pt); // 16
		caractPerso.add(pointCrea); // 17
		caractPerso.add(pointRestant); // 18
		caractPerso.add(vit); // 19
		System.out.println("save : " + caractPerso.toString());

	}

	private void initPerso() {

		caractPerso.add(nom); // 0
		caractPerso.add(sexe); // 1
		caractPerso.add(0); // 2
		caractPerso.add(0); // 3
		caractPerso.add(0); // 4
		caractPerso.add(10); // 5
		caractPerso.add(10); // 6
		caractPerso.add(10); // 7
		caractPerso.add(10); // 8
		caractPerso.add(0); // 9
		caractPerso.add(0); // 10
		caractPerso.add(0); // 11
		caractPerso.add(0); // 12
		caractPerso.add(prof); // 13
		caractPerso.add(nat); // 14
		caractPerso.add(rac); // 15
		caractPerso.add(pt); // 16
		caractPerso.add(0); // 17
		caractPerso.add(0); // 18
		caractPerso.add(0); // 19
		System.out.println("init : " + caractPerso.toString());
	}

	private int etatAvantages() {
		int ptAvantages = 0;
		for (int jav = 0; jav < choixAvantages.length; jav++) {
			if (chkA[jav].isSelected() == true) {
				System.out.println("avantage : " + chkA[jav].getText());
				ptAvantages = ptAvantages + Integer.parseInt(chkA[jav].getText().substring(0, 2));
				initchkA.remove(jav);
				initchkA.add(jav, true);

			} else {
				initchkA.remove(jav);
				initchkA.add(jav, false);
			}
			System.out.println("Avantage : " + ptAvantages);
		}
		return ptAvantages;
	}

	private int etatDesavantages() {
		int ptDesavantages = 0;
		for (int jde = 0; jde < choixDesavantages.length; jde++) {
			if (chkD[jde].isSelected() == true) {

				ptDesavantages = ptDesavantages + Integer.parseInt(chkD[jde].getText().substring(0, 2));
				initchkD.remove(jde);
				initchkD.add(jde, true);

			} else {
				initchkD.remove(jde);
				initchkD.add(jde, false);
			}
			System.out.println("desavantage : " + ptDesavantages);
		}
		return ptDesavantages;
	}

	private void initVar() {

		for (int v = 0; v < choixAvantages.length; v++) {
			initchkA.add(false);
		}
		for (int w = 0; w < choixDesavantages.length; w++) {
			initchkD.add(false);
		}

	}

	private int verifCar(int carV) {
		// calcul des point de creation restant pour la force et la sant�
		int carOut = 0;
		System.out.println("carout2 : " + carOut + " et : " + carV);
		if (carV == 10)
			carOut = 0;
		else if (carV <= 9) {
			carOut = (10 - carV) * 10;
		} else if (carV >= 11) {
			carOut = -((carV - 10) * 10);
		}
		System.out.println("carout2 : " + carOut);
		return carOut;
	}

	private int verifCar2(int carV) {
		// calcul des point de creation restant pour le qi et la dexterit�
		int carOut = 0;
		System.out.println("carout2 : " + carOut + " et : " + carV);
		if (carV == 10)
			carOut = 0;
		else if (carV <= 9) {
			carOut = (10 - carV) * 20;
		} else if (carV >= 11) {
			carOut = -((carV - 10) * 20);
		}
		System.out.println("carout2 : " + carOut);
		return carOut;
	}

	private int verifAll() {
		// calcul des point de creation restant
		pointRestant = pointCrea - etatAvantages() + etatDesavantages() + verifCar(Integer.parseInt(force.getText()))
				+ verifCar2(Integer.parseInt(dexterite.getText())) + verifCar2(Integer.parseInt(intelligence.getText()))
				+ verifCar(Integer.parseInt(sante.getText()));

		return pointRestant;
	}

	private class next implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// passe a la fenetre suivante et envois les donn� contaneue dans
			// les List : caractPerso, avantagesPerso, desavantagesPerso,
			// traversPerso
			savePerso();
			FenetreDM2 suivant = new FenetreDM2(caractPerso, initchkA, initchkD);

			dispose();
		}
	}
}

/*
 * pdv = fo vol = qi per = qi pdf = sa vit = fo+dx/4
 * 
 */
