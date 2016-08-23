package vueChtullu;

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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controleChtullu.CreationAuto;
import controleChtullu.TousAuto;

public class FenetreChtullu extends JFrame implements DataChtullu {
	
	private static final Logger logger = LogManager.getLogger(FenetreChtullu.class.getName());
	private int forc, dex, inte, ide, con, app, pou, chanc, tai, san, edu, connais, sm, pm, pv = 0;

	ArrayList<String> caractPerso = new ArrayList<String>();
	boolean visible = true;

	JComboBox metier = new JComboBox(choixMetier);

	private int age;
	private int mytheC = 99;
	private String nom, sexe, nat, dipl, bd;
	private String prof = "Aucun";

	private JPanel container = new JPanel();

	private Font font = new Font("Times New Roman", Font.BOLD, 12);

	final JTextField nomPerso = new JTextField(nom);
	final JTextField agePerso = new JTextField(age);
	final JTextField nationalite = new JTextField(nat);
	final JTextField diplome = new JTextField(dipl);
	final JTextField force = new JTextField(forc);
	final JTextField dexterite = new JTextField(dex);
	final JTextField intelligence = new JTextField(inte);
	final JTextField idee = new JTextField(ide);
	final JTextField constitution = new JTextField(con);
	final JTextField apparence = new JTextField(app);
	final JTextField pouvoir = new JTextField(pou);
	final JTextField chance = new JTextField(chanc);
	final JTextField taille = new JTextField(tai);
	final JTextField santer = new JTextField(san);
	final JTextField education = new JTextField(edu);
	final JTextField connaissance = new JTextField(connais);
	final JTextField mythe = new JTextField(mytheC);
	final JTextField bonusDegat = new JTextField(bd);
	final JTextField santeMentale = new JTextField(sm);
	final JTextField pointMagie = new JTextField(pm);
	final JTextField pointVie = new JTextField(pv);

	public FenetreChtullu() {
		this.setTitle("Création de personnage Chtullu : ");
		this.setSize(600, 400);
		this.setBackground(Color.white);
		this.setFont(font);
		this.setLocationRelativeTo(null);
		initPerso();
		nom = choixNom();
		sexe = choixSexe2();
		screen1();
		this.getContentPane().add(container);
		container.setBackground(Color.white);

		this.setResizable(false);
		this.setVisible(visible);
	}

	private void screen1() {
		// affichage des caracteristqiue du perso, edition automatique ou
		// manuelle

		JLabel containerLabel = new JLabel();
		JPanel containerLeft = new JPanel();
		JPanel containerPerso = new JPanel();
		JPanel containerPoint = new JPanel();
		JPanel containerCarac1 = new JPanel();
		JPanel containerCarac2 = new JPanel();
		JPanel containerAction = new JPanel();

		JButton random = new JButton("Caract. Auto");
		JButton tousAuto = new JButton("Perso Auto");
		JButton appercu = new JButton("Actualiser");
		JButton suivant = new JButton("Suivant");

		nationalite.setText(nat);
		diplome.setText(dipl);
		force.setText(Integer.toString(forc));
		intelligence.setText(Integer.toString(inte));
		dexterite.setText(Integer.toString(dex));
		pouvoir.setText(Integer.toString(pou));
		apparence.setText(Integer.toString(app));
		constitution.setText(Integer.toString(con));
		education.setText(Integer.toString(edu));
		taille.setText(Integer.toString(tai));
		agePerso.setText(Integer.toString(age));
		idee.setText(Integer.toString(ide));
		santer.setText(Integer.toString(san));
		chance.setText(Integer.toString(chanc));
		connaissance.setText(Integer.toString(connais));
		santeMentale.setText(Integer.toString(sm));
		pointMagie.setText(Integer.toString(pm));
		pointVie.setText(Integer.toString(pv));
		mythe.setText(Integer.toString(mytheC));
		bonusDegat.setText(bd);

		container.removeAll();

		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
		// affichage de l'id du perso

		Icon img = new ImageIcon(
				new ImageIcon("img/edit/bandeaugauche.jpg").getImage().getScaledInstance(585, 70, Image.SCALE_DEFAULT));

		containerLabel.setIcon(img);
		containerLeft.setLayout(new FlowLayout(FlowLayout.LEFT));
		containerLeft.setBackground(Color.white);
		containerLeft.add(containerLabel);

		container.add(containerLeft);

		containerPerso.setLayout(new GridLayout(3, 4));
		containerPerso.setBackground(Color.white);

		containerPerso.add(new JLabelP(" Nom : " + nom, font));
		containerPerso.add(new JLabelP(" Sexe : " + sexe, font));

		containerPerso.add(new JLabelP(" Age : ", font));
		containerPerso.add(agePerso);
		containerPerso.add(new JLabelP(" Nationnalité : ", font));
		containerPerso.add(nationalite);
		containerPerso.add(new JLabelP(" Proffession : ", font));
		metier.setBackground(Color.white);
		metier.setPreferredSize(new Dimension(100, 20));
		containerPerso.add(metier);
		metier.setSelectedIndex(choixMetierOut(prof));
		metier.addActionListener(new ItemMetier());
		containerPerso.add(new JLabelP(" Diplôme : ", font));
		containerPerso.add(diplome);

		container.add(containerPerso);

		// affichage des caracteristique de perso

		containerCarac1.setLayout(new GridLayout(3, 8));
		containerCarac1.setBackground(Color.white);
		containerCarac1.add(new JLabelP(" FOR : ", font));
		containerCarac1.add(force);
		containerCarac1.add(new JLabelP(" DEX : ", font));
		containerCarac1.add(dexterite);
		containerCarac1.add(new JLabelP(" INT : ", font));
		containerCarac1.add(intelligence);
		containerCarac1.add(new JLabelP(" Idée : ", font));
		containerCarac1.add(idee);
		containerCarac1.add(new JLabelP(" CON : ", font));
		containerCarac1.add(constitution);
		containerCarac1.add(new JLabelP(" APP : ", font));
		containerCarac1.add(apparence);
		containerCarac1.add(new JLabelP(" POU : ", font));
		containerCarac1.add(pouvoir);
		containerCarac1.add(new JLabelP(" Chance : ", font));
		containerCarac1.add(chance);
		containerCarac1.add(new JLabelP(" TAI : ", font));
		containerCarac1.add(taille);
		containerCarac1.add(new JLabelP(" SAN : ", font));
		containerCarac1.add(santer);
		containerCarac1.add(new JLabelP(" EDU : ", font));
		containerCarac1.add(education);
		containerCarac1.add(new JLabelP(" Connais: ", font));
		containerCarac1.add(connaissance);
		container.add(containerCarac1);
		containerCarac2.setLayout(new GridLayout(1, 4));
		containerCarac2.setBackground(Color.white);
		containerCarac2.add(new JLabelP(" 99 - Mythe de Chtullu : ", font));
		containerCarac2.add(mythe);
		containerCarac2.add(new JLabelP(" Bonus de dégat : ", font));
		containerCarac2.add(bonusDegat);
		container.add(containerCarac2);
		containerPoint.setLayout(new GridLayout(1, 6));
		containerPoint.setBackground(Color.white);
		containerPoint.add(new JLabelP(" Santé mentale : ", font));
		containerPoint.add(santeMentale);
		containerPoint.add(new JLabelP(" Points de Magie : ", font));
		containerPoint.add(pointMagie);
		containerPoint.add(new JLabelP(" Points de vie : ", font));
		containerPoint.add(pointVie);

		container.add(containerPoint);

		containerAction.setLayout(new GridLayout(1, 2));
		containerAction.setBackground(Color.white);
		containerAction.add(random);
		containerAction.add(tousAuto);
		containerAction.add(appercu);
		containerAction.add(suivant);
		tousAuto.addActionListener(new persoAuto());
		appercu.addActionListener(new reload());
		suivant.addActionListener(new next());
		random.addActionListener(new auto());

		container.add(containerAction);

		repaint();
		revalidate();

	}

	private class persoAuto implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TousAuto auto2 = new TousAuto();
			auto2.TousAuto(nom, sexe);
			dispose();
		}
	}

	private class next implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			readPerso();
			logger.debug("Caractéristique perso : " + caractPerso.toString());
			FenetreChtullu2 suiv = new FenetreChtullu2(caractPerso);
			dispose();
		}
	}

	private class ItemMetier implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			prof = (String) metier.getSelectedItem();
		}
	}

	private void initPerso() {
		// intialisation du perso pour preremplis les champs vide
		caractPerso.clear();

		caractPerso.add(""); // 0
		caractPerso.add(null); // 1
		caractPerso.add("0"); // 2
		caractPerso.add(""); // 3
		caractPerso.add("Metier 1"); // 4
		caractPerso.add(""); // 5
		caractPerso.add("0"); // 6
		caractPerso.add("0"); // 7
		caractPerso.add("0"); // 8
		caractPerso.add("0"); // 9
		caractPerso.add("0"); // 10
		caractPerso.add("0"); // 11
		caractPerso.add("0"); // 12
		caractPerso.add("0"); // 13
		caractPerso.add("0"); // 14
		caractPerso.add("0"); // 15
		caractPerso.add("0"); // 16
		caractPerso.add("0"); // 17
		caractPerso.add("99"); // 18
		caractPerso.add("aucun"); // 19
		caractPerso.add("0"); // 20
		caractPerso.add("0"); // 21
		caractPerso.add("0"); // 22
	}

	public void readPerso() {
		// lecture la List caractPerso
		nom = caractPerso.get(0).toString(); // 0
		sexe = caractPerso.get(1).toString(); // 1
		age = Integer.parseInt(caractPerso.get(2).toString()); // 2
		nat = caractPerso.get(3).toString(); // 3
		prof = caractPerso.get(4).toString(); // 4
		dipl = caractPerso.get(5).toString(); // 5
		forc = Integer.parseInt(caractPerso.get(6).toString()); // 6
		dex = Integer.parseInt(caractPerso.get(7).toString()); // 7
		inte = Integer.parseInt(caractPerso.get(8).toString()); // 8
		ide = Integer.parseInt(caractPerso.get(9).toString()); // 9
		con = Integer.parseInt(caractPerso.get(10).toString()); // 10
		app = Integer.parseInt(caractPerso.get(11).toString()); // 11
		pou = Integer.parseInt(caractPerso.get(12).toString()); // 12
		chanc = Integer.parseInt(caractPerso.get(13).toString()); // 13
		tai = Integer.parseInt(caractPerso.get(14).toString()); // 14
		san = Integer.parseInt(caractPerso.get(15).toString()); // 15
		edu = Integer.parseInt(caractPerso.get(16).toString()); // 16
		connais = Integer.parseInt(caractPerso.get(17).toString()); // 17
		mytheC = Integer.parseInt(caractPerso.get(18).toString()); // 18
		bd = caractPerso.get(19).toString(); // 19
		sm = Integer.parseInt(caractPerso.get(20).toString()); // 20
		pm = Integer.parseInt(caractPerso.get(21).toString()); // 21
		pv = Integer.parseInt(caractPerso.get(22).toString()); // 22
	}

	private class reload implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// recharge la fenetre avec les donn�es � jour
			ide = Integer.parseInt(intelligence.getText()) * 5;
			san = Integer.parseInt(pouvoir.getText()) * 5;
			chanc = Integer.parseInt(pouvoir.getText()) * 5;
			connais = Integer.parseInt(education.getText()) * 5;
			pv = ((Integer.parseInt(constitution.getText())) + (Integer.parseInt(taille.getText()))) / 2;
			pm = Integer.parseInt(pouvoir.getText());
			sm = san;
			savePerso();
			readPerso();
			screen1();
			repaint();
			revalidate();
		}
	}

	private void savePerso() {
		// efface et rerenplis l'arraylist avec les caract du perso
		String ide2 = Integer.toString(ide);
		String san2 = Integer.toString(san);
		String chanc2 = Integer.toString(chanc);
		String connais2 = Integer.toString(connais);
		String pv2 = Integer.toString(pv);
		String pm2 = Integer.toString(pm);
		String sm2 = Integer.toString(sm);
		int bd2 = Integer.parseInt(force.getText()) + Integer.parseInt(taille.getText());
		bd = bonusDegats(bd2);

		caractPerso.clear();
		caractPerso.add(nomPerso.getText()); // 0
		caractPerso.add(sexe); // 1
		caractPerso.add(agePerso.getText()); // 2
		caractPerso.add(nationalite.getText()); // 3
		caractPerso.add(prof); // 4
		caractPerso.add(diplome.getText()); // 5
		caractPerso.add(force.getText()); // 6
		caractPerso.add(dexterite.getText()); // 7
		caractPerso.add(intelligence.getText()); // 8
		caractPerso.add(ide2); // 9
		caractPerso.add(constitution.getText()); // 10
		caractPerso.add(apparence.getText()); // 11
		caractPerso.add(pouvoir.getText()); // 12
		caractPerso.add(chanc2); // 13
		caractPerso.add(taille.getText()); // 14
		caractPerso.add(san2); // 15
		caractPerso.add(education.getText()); // 16
		caractPerso.add(connais2); // 17
		caractPerso.add("99"); // 18
		caractPerso.add(bd); // 19
		caractPerso.add(sm2); // 20
		caractPerso.add(pm2); // 21
		caractPerso.add(pv2); // 22
	}

	private String bonusDegats(int bonusD) {
		// calcul du bonus de d�gat
		String BonusOut = null;

		if (bonusD >= 2 && bonusD <= 12) {
			BonusOut = "-1D6";
		} else if (bonusD >= 13 && bonusD <= 16) {
			BonusOut = "-1D4";
		} else if (bonusD >= 17 && bonusD <= 24) {
			BonusOut = "aucun";
		} else if (bonusD >= 25 && bonusD <= 32) {
			BonusOut = "+1D4";
		} else if (bonusD >= 33 && bonusD <= 40) {
			BonusOut = "+1D6";
		} else if (bonusD >= 41 && bonusD <= 56) {
			BonusOut = "+2D6";
		} else if (bonusD >= 57 && bonusD <= 72) {
			BonusOut = "+3D6";
		} else if (bonusD >= 73 && bonusD <= 88) {
			BonusOut = "+4D6";
		} else if (bonusD >= 89 && bonusD <= 104) {
			BonusOut = "+5D4";
		} else if (bonusD >= 105 && bonusD <= 120) {
			BonusOut = "+6D4";
		} else if (bonusD >= 121 && bonusD <= 136) {
			BonusOut = "+7D4";
		} else if (bonusD >= 137 && bonusD <= 152) {
			BonusOut = "+8D4";
		} else if (bonusD >= 153 && bonusD <= 168) {
			BonusOut = "+9D4";
		} else if (bonusD >= 169 && bonusD <= 184) {
			BonusOut = "+10D4";
		}
		return BonusOut;
	}

	private class auto implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// permet de l'ancer la creation auto des caratceristique du perso
			// et actualise les donn�es a l'�cran
			CreationAuto auto = new CreationAuto(nom, sexe);
			caractPerso = auto.getRandom();
			readPerso();
			screen1();
			repaint();
			revalidate();
		}
	}

	private int choixMetierOut(String arg) {
		// actualise l'affichage du metier lors du reload
		int out = 1;
		for (int i = 0; i < choixMetier.length; i++) {
			if (arg.equals(choixMetier[i]))
				out = i;
		}
		return out;
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

}

/*
 * for, con, pou, dex app = 3d6 = 18max tai, int = 2d6 + 8 = 20max edu = 3d6 + 3
 * = 21max san = pou * 5 = 25max
 * 
 * id�e = int * 5 chance = pou * 5 connaissance = edu*5
 * 
 * bonus degat = for + tai ==> voir tableau pages 19 du livre de regles
 * 
 * pv = con + tai / 2 pm = pou sante mentale = san
 * 
 * comp metier = edu * 20 comp personnel = int * 10
 * 
 * liste metier : String[] choixMetier = {Aucun, Antiquaire, Artiste, Artiste de
 * cabaret, Athlete, Avocat, Criminel, Detective prive, Dilettante, Ecrivain,
 * Fantassin, Fermier, Guerrier tribal, Ingenieur, Inspecteur de police,
 * Journaliste, Medecin, Missionnaire, Musicien, Officier, Parapsychologue,
 * Pecheur, Policier, Pretre, Proffesseur, Revolutionnaire, Vagabond}; voir page
 * 24 du livre de regles
 */
