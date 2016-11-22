package vueDM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

import controleDM.ControleFenDM;
import modelDM.PersoDM;
import vueChtullu.JLabelP;

public class FenDM extends JFrame implements DataDM {

	private static final Logger logger = LogManager.getLogger(FenDM.class.getName());

	PersoDM persoDisque = null;
	ControleFenDM controle = null;
	
	
	private JPanel container = new JPanel();
	private Font font = new Font("Times New Roman", Font.BOLD, 15);

	private String[] sex = { "Homme", "Femme" };

	public JComboBox proffs = new JComboBox(choixMetier);
	public JComboBox national = new JComboBox(choixNat);
	public JComboBox pointPerso = new JComboBox(choixPoint);
	public JComboBox race = new JComboBox(choixRace);
	public JComboBox sexe = new JComboBox(sex);
	public JComboBox apparence = new JComboBox(choixApparence);

	JCheckBox[] chkA = new JCheckBox[choixAvantages.length];
	JCheckBox[] chkD = new JCheckBox[choixDesavantages.length];
	JCheckBox[] chkL = new JCheckBox[choixLangues.length];
	JCheckBox[] chkM = new JCheckBox[choixMagie.length];

	BoutonComp[] chkC = new BoutonComp[choixCompetences.length];

	private static ArrayList<Boolean> initchkA = new ArrayList<Boolean>();
	private static ArrayList<Boolean> initchkD = new ArrayList<Boolean>();
	private static ArrayList initComp = new ArrayList();
	private static ArrayList<Boolean> initchkL = new ArrayList<Boolean>();
	private static ArrayList<Boolean> initchkM = new ArrayList<Boolean>();

	public final JTextField nomPerso = new JTextField();
	public final JTextField agePerso = new JTextField();
	public final JTextField taille = new JTextField();
	public final JTextField poids = new JTextField();
	public final JTextField force = new JTextField();
	public final JTextField dexterite = new JTextField();
	public final JTextField intelligence = new JTextField();
	public final JTextField sante = new JTextField();
	public final JTextField description = new JTextField();
	public final JTextField travers = new JTextField();

	public FenDM(ControleFenDM ctrl, PersoDM pdm) {
		this.persoDisque = pdm;
		this.controle = ctrl;
		this.setTitle("Création de personnage Disque Monde : ");
		this.setSize(900, 800);
		this.setBackground(Color.white);
		this.setFont(font);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(container);
		container.setBackground(Color.white);

		initchkL = persoDisque.getInitchkL();
		initchkA = persoDisque.getInitchkA();
		initchkD = persoDisque.getInitchkD();
		initComp = persoDisque.getInitComp();
		initchkM = persoDisque.getInitchkM();

		screen1();
		this.setResizable(false);
		this.setVisible(true);
	}

	public void screen1() {

		logger.debug("Fenetre ok");

		JLabelP labelApp = new JLabelP("Votre apparence : ", font);
		JLabelP comp = new JLabelP("Compétences : ", font);
		JLabelP langue = new JLabelP("Langues : ", font);
		JLabelP magie = new JLabelP("Magie : ", font);

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
		JPanel containerLabel4 = new JPanel();
		JPanel containerCompetence = new JPanel();
		JPanel containerLangue = new JPanel();
		JPanel containerCompetence4 = new JPanel();
		JPanel containerMagie = new JPanel();
		JPanel containerDescrition = new JPanel();

		JButton appercu = new JButton("Actualiser");
		JButton suivant = new JButton("Suivant");
		JButton sauver = new JButton("Sauver");

		System.out.println("Perso : " + persoDisque.getNom());

		nomPerso.setText(persoDisque.getNom());
		agePerso.setText("" + persoDisque.getAge());
		taille.setText("" + persoDisque.getTaille());
		poids.setText("" + persoDisque.getPoids());
		force.setText("" + persoDisque.getForce());
		dexterite.setText("" + persoDisque.getDex());
		intelligence.setText("" + persoDisque.getInte());
		sante.setText("" + persoDisque.getSante());
		description.setText(persoDisque.getDescription());
		travers.setText(persoDisque.getTravers());

		JLabelP avantages = new JLabelP("Avantages (retire des Points)", font);
		JLabelP desavantages = new JLabelP("Desavantage (ajoute des Points)", font);
		// JLabelP travers = new JLabelP("Travers (ajoute des Pts)", font);
		JLabelP labelPoint = new JLabelP("Point de création restant : ", font);
		JLabelP labelPointR = new JLabelP("" + persoDisque.getPointRestant(), font);
		JLabelP PdV = new JLabelP("" + persoDisque.getPdv(), font);
		JLabelP volonte = new JLabelP("" + persoDisque.getVolonte(), font);
		JLabelP perception = new JLabelP("" + persoDisque.getPerception(), font);
		JLabelP Pdf = new JLabelP("" + persoDisque.getPdf(), font);
		JLabelP vitesse = new JLabelP("" + persoDisque.getVitesse(), font);

		JScrollPane scroll = new JScrollPane(containerAvantages);
		JScrollPane scroll2 = new JScrollPane(containerDesavantages);
		scroll.getVerticalScrollBar().setUnitIncrement(20);
		scroll2.getVerticalScrollBar().setUnitIncrement(20);
		JScrollPane scroll3 = new JScrollPane(containerMagie);
		scroll3.getVerticalScrollBar().setUnitIncrement(15);
		final JScrollPane scroll4 = new JScrollPane(containerCompetence);
		scroll4.getVerticalScrollBar().setUnitIncrement(30);
		JScrollPane scroll5 = new JScrollPane(containerLangue);
		scroll5.getVerticalScrollBar().setUnitIncrement(15);

		container.removeAll();

		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
		// affichage de l'id du perso

		Icon img = new ImageIcon(
				new ImageIcon("img/edit/bandeauDM.jpg").getImage().getScaledInstance(880, 90, Image.SCALE_DEFAULT));

		containerLabel.setIcon(img);
		containerLeft.setLayout(new FlowLayout(FlowLayout.LEFT));
		containerLeft.setBackground(Color.white);
		containerLeft.add(containerLabel);
		container.add(containerLeft);

		containerPerso.setLayout(new GridLayout(5, 5));
		containerPerso.setBackground(Color.white);

		containerPerso.add(new JLabelP(" Nom : ", font));
		containerPerso.add(nomPerso);
		containerPerso.add(new JLabelP(" Sexe : ", font));
		national.setPreferredSize(new Dimension(100, 20));
		national.setBackground(Color.white);

		containerPerso.add(sexe);
		sexe.setBackground(Color.white);
		sexe.setSelectedIndex(persoDisque.GetSexe2());
		sexe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.ItemSexe();
			}
		});

		containerPerso.add(new JLabelP(" Age : ", font));
		containerPerso.add(agePerso);
		containerPerso.add(new JLabelP(" Nationnalité : ", font));
		national.setPreferredSize(new Dimension(100, 20));
		national.setBackground(Color.white);

		containerPerso.add(national);
		national.setSelectedIndex(persoDisque.GetNat());
		national.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.ItemNat();
			}
		});
		containerPerso.add(new JLabelP(" Proffession : ", font));

		proffs.setBackground(Color.white);
		proffs.setPreferredSize(new Dimension(100, 20));
		containerPerso.add(proffs);
		proffs.setSelectedIndex(persoDisque.GetMetier());
		proffs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.ItemMetier();
			}
		});

		containerPerso.add(new JLabelP(" Race : ", font));
		race.setPreferredSize(new Dimension(100, 20));
		race.setBackground(Color.white);
		containerPerso.add(race);
		race.setSelectedIndex(persoDisque.GetRac());
		race.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.ItemRace();
			}
		});

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

		containerDescrition.setLayout(new BoxLayout(containerDescrition, BoxLayout.PAGE_AXIS));
		containerDescrition.setBackground(Color.white);
		containerDescrition.add(new JLabelP("Veuillez décrire votre personnage : ", font));
		containerDescrition.add(new JScrollPane(description));

		container.add(containerDescrition);

		containerTravers.setLayout(new BoxLayout(containerTravers, BoxLayout.PAGE_AXIS));
		containerTravers.setBackground(Color.white);
		containerTravers.add(
				new JLabelP("Veuillez indiquer les travers de votre avatar (séparés par une virgule, svp) : ", font));
		containerTravers.add(new JScrollPane(travers));
		container.add(containerTravers);

		containerPoints.setLayout(new FlowLayout());
		containerPoints.setBackground(Color.white);
		// pointPerso.setPreferredSize(new Dimension(400, 20));
		pointPerso.setBackground(Color.white);
		containerPoints.add(pointPerso);
		pointPerso.setSelectedIndex(persoDisque.GetPoint());
		pointPerso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.ItemPoint();
			}
		});

		containerPoints.add(labelPoint);
		containerPoints.add(labelPoint);
		containerPoints.add(labelPointR);
		container.add(containerPoints);

		containerLabel4.setLayout(new BoxLayout(containerLabel4, BoxLayout.LINE_AXIS));
		containerLabel4.setBackground(Color.white);
		containerLabel4.add(labelApp);

		apparence.setBackground(Color.white);
		apparence.setPreferredSize(new Dimension(500, 20));
		containerLabel4.add(apparence);
		apparence.setSelectedIndex(persoDisque.GetApp());
		apparence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.ItemApp();
			}
		});

		container.add(containerLabel4);

		container.add(containerAttention);
		containerComp.setLayout(new BoxLayout(containerComp, BoxLayout.LINE_AXIS));
		containerComp.setBackground(Color.white);
		containerComp.setPreferredSize(new Dimension(this.getWidth(), 200));

		containerAvantages.setLayout(new BoxLayout(containerAvantages, BoxLayout.PAGE_AXIS));
		containerAvantages.setBackground(Color.white);
		containerAvantages.add(avantages);
		for (int g = 0; g < choixAvantages.length; g++) {
			chkA[g] = new JCheckBox(choixAvantages[g], persoDisque.getInitchkA(g));
			containerAvantages.add(chkA[g]);
		}

		scroll.setBackground(Color.white);
		containerComp.add(scroll);

		containerDesavantages.setLayout(new BoxLayout(containerDesavantages, BoxLayout.PAGE_AXIS));
		containerDesavantages.setBackground(Color.white);
		containerDesavantages.add(desavantages);
		for (int h = 0; h < choixDesavantages.length; h++) {
			chkD[h] = new JCheckBox(choixDesavantages[h], persoDisque.getInitchkD(h));
			containerDesavantages.add(chkD[h]);
		}
		scroll2.setBackground(Color.white);
		containerComp.add(scroll2);

		containerLangue.setLayout(new BoxLayout(containerLangue, BoxLayout.PAGE_AXIS));
		containerLangue.setBackground(Color.white);
		containerLangue.add(langue);
		for (int h = 0; h < choixLangues.length; h++) {
			chkL[h] = new JCheckBox(choixLangues[h], persoDisque.getInitchkL(h));
			containerLangue.add(chkL[h]);
		}
		scroll5.setBackground(Color.white);
		containerComp.add(scroll5);

		container.add(containerComp);
		containerCompetence4.setLayout(new BoxLayout(containerCompetence4, BoxLayout.LINE_AXIS));
		containerCompetence4.setPreferredSize(new Dimension(this.getWidth(), 200));
		containerCompetence.setLayout(new BoxLayout(containerCompetence, BoxLayout.PAGE_AXIS));
		containerCompetence.setBackground(Color.white);
		containerCompetence.add(comp);
		for (int g = 0; g < choixCompetences.length; g++) {
			// chkC[g] = new JCheckBox(choixCompetences[g],
			// persoDisque.getInitchkC(g));

			chkC[g] = new BoutonComp(choixCompetences[g][0], choixCompetences[g][1],
					Integer.parseInt(choixCompetences[g][2]), (persoDisque.getInitComp(g)));
			containerCompetence.add(chkC[g]);
		}
		scroll4.setBackground(Color.white);
		containerCompetence4.add(scroll4);

		containerMagie.setLayout(new BoxLayout(containerMagie, BoxLayout.PAGE_AXIS));
		containerMagie.setBackground(Color.white);
		containerMagie.add(magie);
		for (int r = 0; r < choixMagie.length; r++) {
			chkM[r] = new JCheckBox(choixMagie[r], persoDisque.getInitchkM(r));
			containerMagie.add(chkM[r]);
		}
		scroll3.setBackground(Color.white);
		containerCompetence4.add(scroll3);

		container.add(containerCompetence4);

		containerAction.setLayout(new GridLayout(1, 2));
		containerAction.setBackground(Color.white);
		containerAction.add(appercu);
		containerAction.add(sauver);
		containerAction.add(suivant);
		appercu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.Reload();
			}
		});
		suivant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.Next();
			}
		});
		sauver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.Sauver();
			}
		});
		
		scroll4.addMouseListener(new MouseListener() {
			
			 
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
				scroll4.setToolTipText("<html>Nv1 : 1 Point d'exp<br> Nv2 : 2 Point d'exp<br> Nv3 : 4 Point d'exp<br>"
						+ "Nv4 : 8 Point d'exp<br> Nv5 : 12 Point d'exp<br> Nv6 : 16 Point d'exp </html>");
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				scroll4.setToolTipText(null);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});

		container.add(containerAction);

		repaint();
		revalidate();
	}

	public int etatAvantages() {
		int ptAvantages = 0;
		for (int jav = 0; jav < choixAvantages.length; jav++) {
			if (chkA[jav].isSelected() == true) {
				ptAvantages = ptAvantages + Integer.parseInt(chkA[jav].getText().substring(0, 2));
				initchkA.remove(jav);
				initchkA.add(jav, true);

			} else {
				initchkA.remove(jav);
				initchkA.add(jav, false);
			}
		}
		persoDisque.setInitchkA(initchkA);
		return ptAvantages;
	}

	public int etatDesavantages() {
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
		}
		persoDisque.setInitchkD(initchkD);
		return ptDesavantages;
	}

	public int etatCompetences() {

		int ptCompetence = 0;
		for (int jdc = 0; jdc < choixCompetences.length; jdc++) {

			persoDisque.addInitComp(jdc, chkC[jdc].getBoutonComp());

			switch ((chkC[jdc].getBoutonComp())) {

			case -1:
				ptCompetence = ptCompetence;
				break;
			case 0:
				ptCompetence = ptCompetence + 1;
				break;
			case 1:
				ptCompetence = ptCompetence + 2;
				break;
			case 2:
				ptCompetence = ptCompetence + 4;
				break;
			case 3:
				ptCompetence = ptCompetence + 8;
				break;
			case 4:
				ptCompetence = ptCompetence + 12;
				break;
			case 5:
				ptCompetence = ptCompetence + 16;
				break;

			}

		}
		return ptCompetence;

	}

	public int etatLangues() {
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
		persoDisque.setInitchkL(initchkL);
		return ptlangue;
	}

	public int etatMagie() {

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
		persoDisque.setInitchkM(initchkM);
		return ptMagie;
	}

	public double etatApp() {
		double appOut = Double.parseDouble(persoDisque.getApparence().substring(0, 3));
		return appOut;
	}

	public static ArrayList<Boolean> getInitchkA() {
		return initchkA;
	}

	public static ArrayList<Boolean> getInitchkD() {
		return initchkD;
	}

	public static ArrayList<Boolean> getInitComp() {
		return initComp;

	}

	public static ArrayList<Boolean> getInitchkL() {
		return initchkL;
	}

	public static ArrayList<Boolean> getInitchkM() {
		return initchkM;
	}
	
	
}
