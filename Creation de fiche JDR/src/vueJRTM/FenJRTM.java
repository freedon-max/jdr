package vueJRTM;

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
import javax.swing.JTextField;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controleJRTM.ControleFenJRTM;
import modelJRTM.DataJRTM;
import modelJRTM.PersoJRTM;
import vueChtullu.JLabelP;

public class FenJRTM extends JFrame implements DataJRTM {

	PersoJRTM persoTM = null;
	ControleFenJRTM controle = null;

	private JPanel container = new JPanel();
	private Font font = new Font("Times New Roman", Font.BOLD, 15);

	public JComboBox proffs = new JComboBox(choixProfession);
	public JComboBox royaume = new JComboBox(choixRoyaume);
	public JComboBox cheveux = new JComboBox(choixCheveux);
	public JComboBox yeux = new JComboBox(choixYeux);
	public JComboBox race = new JComboBox(choixRace);
	public JComboBox sexe = new JComboBox(sex);
	public JComboBox attitude = new JComboBox(choixAttitude);
	public JComboBox alignement = new JComboBox(choixAlignement);

	public CompJRTM[] comp = new CompJRTM[choixCompetence.length];

	JCheckBox[] chkL = new JCheckBox[choixLangues.length];
	private static ArrayList<Boolean> initchkL = new ArrayList<Boolean>();

	public final JTextField nomPerso = new JTextField();
	public final JTextField agePerso = new JTextField();
	public final JTextField taille = new JTextField();
	public final JTextField poids = new JTextField();
	public final JTextField force = new JTextField();
	public final JTextField agilite = new JTextField();
	public final JTextField constitution = new JTextField();
	public final JTextField intelligence = new JTextField();
	public final JTextField intuition = new JTextField();
	public final JTextField presence = new JTextField();
	public final JTextField apparence = new JTextField();
	public final JTextField niveau = new JTextField();
	public final JTextField pointPou = new JTextField();
	public final JTextField pointEX = new JTextField();

	public FenJRTM(ControleFenJRTM controle, PersoJRTM persoTM) {

		this.persoTM = persoTM;
		this.controle = controle;

		this.setTitle("Création de personnage Jeux de rôle de la Terre du Milieu : ");
		this.setSize(800, 700);
		this.setBackground(Color.white);
		this.setFont(font);
		this.setLocationRelativeTo(null);
		this.getContentPane().add(container);
		container.setBackground(Color.white);
		InitVar();
		Screen1();
		this.setResizable(false);
		this.setVisible(true);

	}

	public void Screen1() {

		JLabelP langue = new JLabelP("Langues : ", font);
		langue.setBackground(Color.WHITE);

		JLabelP labelForce = new JLabelP(
				"   " + persoTM.getBnforce() + " +  " + persoTM.getRforce() + " : " + persoTM.getTforce(), font);
		JLabelP labelAgilite = new JLabelP(
				"   " + persoTM.getBnagilite() + " +  " + persoTM.getRagilite() + " : " + persoTM.getTagilite(), font);
		JLabelP labelConstitution = new JLabelP("   " + persoTM.getBnconstitution() + " +  "
				+ persoTM.getRconstitution() + " : " + persoTM.getTconstitution(), font);
		JLabelP labelIntelligence = new JLabelP("   " + persoTM.getBnintelligence() + " + " + persoTM.getRintelligence()
				+ " : " + persoTM.getTintelligence(), font);
		JLabelP labelIntuition = new JLabelP(
				"   " + persoTM.getBnintuition() + " +  " + persoTM.getRintuition() + " : " + persoTM.getTintuition(),
				font);
		JLabelP labelPresence = new JLabelP(
				"   " + persoTM.getBnpresence() + " +  " + persoTM.getRpresence() + " : " + persoTM.getTpresence(),
				font);
		JLabelP labelApparence = new JLabelP("   " + persoTM.getBnapparence() + "    : " + persoTM.getTapparence(),
				font);

		JLabel containerLabel = new JLabel();
		JPanel containerLeft = new JPanel();
		JPanel containerPerso = new JPanel();
		JPanel containerCaract = new JPanel();
		JPanel containerGen = new JPanel();
		JPanel containerForce = new JPanel();
		JPanel containerAgilite = new JPanel();
		JPanel containerConstitution = new JPanel();
		JPanel containerIntelligence = new JPanel();
		JPanel containerIntuition = new JPanel();
		JPanel containerPresence = new JPanel();
		JPanel containerApparence = new JPanel();
		JPanel containerAction = new JPanel();
		JPanel containerCar = new JPanel();
		JPanel containerLangue = new JPanel();
		JPanel containerComp = new JPanel();
		JPanel panel = new JPanel();

		containerPerso.setBackground(Color.white);
		containerLeft.setBackground(Color.white);
		containerGen.setBackground(Color.WHITE);
		containerForce.setBackground(Color.white);
		containerAgilite.setBackground(Color.WHITE);
		containerConstitution.setBackground(Color.WHITE);
		containerIntelligence.setBackground(Color.WHITE);
		containerIntuition.setBackground(Color.WHITE);
		containerPresence.setBackground(Color.WHITE);
		containerApparence.setBackground(Color.WHITE);
		containerComp.setBackground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		containerCaract.setBackground(Color.white);
		containerCar.setBackground(Color.white);
		containerLangue.setBackground(Color.white);
		containerAction.setBackground(Color.white);

		JButton random = new JButton("Caract. Auto");
		JButton sauver = new JButton("Sauver");
		JButton appercu = new JButton("Actualiser");
		JButton suivant = new JButton("Suivant");

		JScrollPane scroll = new JScrollPane(containerLangue);
		scroll.setPreferredSize(new Dimension(100, 20));
		scroll.getVerticalScrollBar().setUnitIncrement(15);
		scroll.setBackground(Color.white);
		JScrollPane scroll2 = new JScrollPane(containerComp);
		scroll2.setPreferredSize(new Dimension(100, 150));
		scroll2.getVerticalScrollBar().setUnitIncrement(15);
		scroll2.setBackground(Color.white);

		nomPerso.setText(persoTM.getNom());
		agePerso.setText("" + persoTM.getAge());
		taille.setText("" + persoTM.getTaille());
		poids.setText("" + persoTM.getPoids());
		force.setText("" + persoTM.getForce());
		agilite.setText("" + persoTM.getAgilite());
		constitution.setText("" + persoTM.getConstitution());
		intelligence.setText("" + persoTM.getIntelligence());
		intuition.setText("" + persoTM.getIntuition());
		presence.setText("" + persoTM.getPresence());
		apparence.setText("" + persoTM.getApparence());
		niveau.setText("" + persoTM.getNiveau());
		pointPou.setText("" + persoTM.getPointPouvoir());
		pointEX.setText("" + persoTM.getPointExp());

		container.removeAll();

		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
		// affichage de l'id du perso

		Icon img = new ImageIcon(
				new ImageIcon("img/edit/Gollum.jpg").getImage().getScaledInstance(880, 120, Image.SCALE_DEFAULT));

		containerLabel.setIcon(img);
		containerLeft.setLayout(new FlowLayout(FlowLayout.LEFT));
		containerLeft.add(containerLabel);
		container.add(containerLeft);

		containerPerso.setLayout(new GridLayout(5, 5));

		containerPerso.add(new JLabelP(" Nom : ", font));
		containerPerso.add(nomPerso);
		containerPerso.add(new JLabelP(" Sexe : ", font));
		containerPerso.add(sexe);
		sexe.setBackground(Color.white);
		sexe.setSelectedIndex(persoTM.GetSexe2());
		sexe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.ItemSexe();
			}
		});

		containerPerso.add(new JLabelP(" Taille : ", font));
		containerPerso.add(taille);
		containerPerso.add(new JLabelP(" Poids : ", font));
		containerPerso.add(poids);

		containerPerso.add(new JLabelP(" Age : ", font));
		containerPerso.add(agePerso);

		containerPerso.add(new JLabelP(" Race : ", font));
		race.setPreferredSize(new Dimension(100, 20));
		race.setBackground(Color.white);
		containerPerso.add(race);
		race.setSelectedIndex(persoTM.GetRac());
		race.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.ItemRace();
			}
		});

		containerPerso.add(new JLabelP(" Royaume : ", font));
		royaume.setPreferredSize(new Dimension(100, 20));
		royaume.setBackground(Color.white);
		containerPerso.add(royaume);
		royaume.setSelectedIndex(persoTM.GetRoy());
		royaume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.ItemRoy();
			}
		});

		containerPerso.add(new JLabelP(" Profession : ", font));
		proffs.setBackground(Color.white);
		proffs.setPreferredSize(new Dimension(100, 20));
		containerPerso.add(proffs);
		proffs.setSelectedIndex(persoTM.GetProffs());
		proffs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.ItemMetier();
			}
		});

		containerPerso.add(new JLabelP(" Cheveux : ", font));
		cheveux.setBackground(Color.white);
		cheveux.setPreferredSize(new Dimension(100, 20));
		containerPerso.add(cheveux);
		cheveux.setSelectedIndex(persoTM.GetChev());
		cheveux.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.ItemCheveux();
			}
		});

		containerPerso.add(new JLabelP(" Yeux : ", font));
		yeux.setBackground(Color.white);
		yeux.setPreferredSize(new Dimension(100, 20));
		containerPerso.add(yeux);
		yeux.setSelectedIndex(persoTM.GetOeil());
		yeux.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.ItemOeil();
			}
		});

		containerPerso.add(new JLabelP(" Attitude : ", font));
		attitude.setBackground(Color.white);
		attitude.setPreferredSize(new Dimension(100, 20));
		containerPerso.add(attitude);
		attitude.setSelectedIndex(persoTM.GetAttit());
		attitude.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.ItemAttitude();
			}
		});

		containerPerso.add(new JLabelP(" Alignement : ", font));
		alignement.setBackground(Color.white);
		alignement.setPreferredSize(new Dimension(100, 20));
		containerPerso.add(alignement);
		alignement.setSelectedIndex(persoTM.GetAl());
		alignement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.ItemSigne();
			}
		});

		containerPerso.add(new JLabelP(" Niveau : ", font));
		containerPerso.add(niveau);

		containerPerso.add(new JLabelP(" Points de pouvoir : ", font));
		containerPerso.add(pointPou);
		containerPerso.add(new JLabelP(" Points D'expérience : ", font));
		containerPerso.add(pointEX);
		container.add(containerPerso);

		containerGen.setLayout(new GridLayout(0, 3, 0, 0));
		containerGen.add(new JLabelP(" Caract : ", font));
		containerGen.add(new JLabelP(" Val : ", font));
		containerGen.add(new JLabelP(" norm  race  total", font));

		containerForce.setLayout(new GridLayout(0, 3, 0, 0));
		containerForce.add(new JLabelP(" Force :        ", font));
		containerForce.add(force);
		containerForce.add(labelForce);
		containerAgilite.setLayout(new GridLayout(0, 3, 0, 0));
		containerAgilite.add(new JLabelP(" Agilite :      ", font));
		containerAgilite.add(agilite);
		containerAgilite.add(labelAgilite);
		containerConstitution.setLayout(new GridLayout(0, 3, 0, 0));
		containerConstitution.add(new JLabelP(" Constitution : ", font));
		containerConstitution.add(constitution);
		containerConstitution.add(labelConstitution);
		containerIntelligence.setLayout(new GridLayout(0, 3, 0, 0));
		containerIntelligence.add(new JLabelP(" Intelligence : ", font));
		containerIntelligence.add(intelligence);
		containerIntelligence.add(labelIntelligence);
		containerIntuition.setLayout(new GridLayout(0, 3, 0, 0));
		containerIntuition.add(new JLabelP(" Intuition :   ", font));
		containerIntuition.add(intuition);
		containerIntuition.add(labelIntuition);
		containerPresence.setLayout(new GridLayout(0, 3, 0, 0));
		containerPresence.add(new JLabelP(" Présence :   ", font));
		containerPresence.add(presence);
		containerPresence.add(labelPresence);
		containerApparence.setLayout(new GridLayout(0, 3, 0, 0));
		containerApparence.add(new JLabelP(" Apparence : ", font));
		containerApparence.add(apparence);
		containerApparence.add(labelApparence);

		containerCaract.setLayout(new BoxLayout(containerCaract, BoxLayout.PAGE_AXIS));
		containerCaract.add(containerGen);
		containerCaract.add(containerForce);
		containerCaract.add(containerAgilite);
		containerCaract.add(containerConstitution);
		containerCaract.add(containerIntelligence);
		containerCaract.add(containerIntuition);
		containerCaract.add(containerPresence);
		containerCaract.add(containerApparence);

		containerLangue.setLayout(new BoxLayout(containerLangue, BoxLayout.PAGE_AXIS));
		containerLangue.add(langue);
		for (int h = 0; h < choixLangues.length; h++) {
			chkL[h] = new JCheckBox(choixLangues[h] + " au degré " + persoTM.get2DegLangue(h), persoTM.get2InitchkL(h));
			containerLangue.add(chkL[h]);
			chkL[h].setBackground(Color.WHITE);
		}

		containerCar.setLayout(new GridLayout(0, 2, 0, 0));

		containerCar.add(containerCaract);
		containerCar.add(scroll);

		container.add(containerCar);

		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		JLabelP labelP = new JLabelP("Point d'historique restant : " + persoTM.getPointHit() + "   ", font);
		labelP.setForeground(Color.BLACK);
		panel.add(labelP);
		JLabelP labelP_1 = new JLabelP("Resist. Essentiel : " + persoTM.getResistanceEss() + "   ", font);
		labelP_1.setForeground(Color.GRAY);
		panel.add(labelP_1);
		JLabelP labelP_2 = new JLabelP("Resist. Théurgie : " + persoTM.getResistanceThe() + "   ", font);
		labelP_2.setForeground(Color.GRAY);
		panel.add(labelP_2);
		JLabelP labelP_3 = new JLabelP("Resist. Poisson : " + persoTM.getResistancePoi() + "   ", font);
		labelP_3.setForeground(Color.GRAY);
		panel.add(labelP_3);
		JLabelP labelP_4 = new JLabelP("Resist. Maladie : " + persoTM.getResistanceMal(), font);
		labelP_4.setForeground(Color.GRAY);
		panel.add(labelP_4);
		container.add(panel);

		containerComp.setLayout(new BoxLayout(containerComp, BoxLayout.PAGE_AXIS));

		for (int y = 0; y < choixCompetence.length; y++) {
			JPanel containerComp1 = new JPanel();
			containerComp1.setLayout(new GridLayout(1, 0));
			containerComp1.setBackground(Color.white);
			comp[y] = new CompJRTM(controle, choixCompetence[y], intiComp[y], init5D[y], persoTM.get2Degres5(y),
					persoTM.get2Degres2(y), y);
			containerComp1.add(comp[y]);
			int aff = persoTM.get2BonusComp(y) + (persoTM.get2Degres5(y) * 5) + (persoTM.get2Degres2(y) * 2);
			containerComp1.add(new JLabelP("Total :" + aff, font));

			containerComp.add(containerComp1);
		}

		container.add(scroll2);
		containerAction.setLayout(new GridLayout(1, 2));

		containerAction.add(random);
		containerAction.add(appercu);
		containerAction.add(sauver);
		containerAction.add(suivant);
		appercu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.actualiser();
			}
		});
		suivant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.Edit();
			}
		});
		random.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.random();
			}
		});
		
		sauver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.ecrire();
			}
		});
		container.add(containerAction);

		repaint();
		revalidate();
	}

	public void InitVar() {
		initchkL.clear();
		for (int v = 0; v < choixLangues.length; v++) {
			initchkL.add(false);
		}
	}

	public static ArrayList<Boolean> getInitchkL() {
		return initchkL;
	}

	public static void setInitchkL(ArrayList<Boolean> initchkL) {
		FenJRTM.initchkL = initchkL;
	}

	public void EtatLangues() {

		for (int jdl = 0; jdl < choixLangues.length; jdl++) {
			if (chkL[jdl].isSelected() == true) {
				initchkL.remove(jdl);
				initchkL.add(jdl, true);

			} else {
				initchkL.remove(jdl);
				initchkL.add(jdl, false);
			}
		}
		persoTM.setInitchkL(initchkL);

	}

}
