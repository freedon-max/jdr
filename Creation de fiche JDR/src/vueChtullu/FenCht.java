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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controleChtullu.ControleFenCht;
import modelChtullu.PersoChtullu;

public class FenCht extends JFrame implements DataChtullu {

	PersoChtullu persoCht = null;
	ControleFenCht controle = null;
	
	private JPanel container = new JPanel();
	private String[] sex = { "Homme", "Femme" };

	private ArrayList<Boolean> competenceBool = new ArrayList<Boolean>();
	private ArrayList<Boolean> competenceBool2 = new ArrayList<Boolean>();

	private Font font = new Font("Times New Roman", Font.BOLD, 12);
	private Font font2 = new Font("Times New Roman", Font.BOLD, 14);

	public JComboBox metier = new JComboBox(choixMetier), sexe = new JComboBox(sex), langueEtr = new JComboBox(langue), armeCaC = new JComboBox(armeCC),
			armeAFeu = new JComboBox(armeFeu), desordrePsy = new JComboBox(Psy);

	public BoutonComp[] competenceBT = new BoutonComp[competence.length];
	public BoutonComp[] competenceBT2 = new BoutonComp[competence.length];

	public final JTextField nom = new JTextField();
	public final JTextField age = new JTextField();
	public final JTextField nationalite = new JTextField();
	public final JTextField diplome = new JTextField();
	public final JTextField force = new JTextField();
	public final JTextField dexterite = new JTextField();
	public final JTextField intelligence = new JTextField();
	public final JTextField idee = new JTextField();
	public final JTextField constitution = new JTextField();
	public final JTextField apparence = new JTextField();
	public final JTextField pouvoir = new JTextField();
	public final JTextField chance = new JTextField();
	public final JTextField taille = new JTextField();
	public final JTextField santer = new JTextField();
	public final JTextField education = new JTextField();
	public final JTextField connaissance = new JTextField();
	public final JTextField mythe = new JTextField();
	public final JTextField bonusDegat = new JTextField();
	public final JTextField santeMentale = new JTextField();
	public final JTextField pointMagie = new JTextField();
	public final JTextField pointVie = new JTextField();

	public final JTextField residence = new JTextField();
	public final JTextField famille = new JTextField();
	public final JTextField revenu = new JTextField();
	public final JTextArea description = new JTextArea(10, 15);

	public FenCht(ControleFenCht controle, PersoChtullu persoCht) {
		this.persoCht = persoCht;
		this.controle = controle;
		this.setTitle("Création de personnage Chtullu : ");
		this.setSize(800, 900);
		this.setBackground(Color.white);
		this.setFont(font);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		competenceBool = persoCht.getCompetenceBool();
		competenceBool2 = persoCht.getCompetenceBool2();
		Screen1();
		this.getContentPane().add(container);
		container.setBackground(Color.white);

		this.setResizable(false);
		this.setVisible(true);
	}

	public void Screen1() {
		// affichage des caracteristqiue du perso, edition automatique ou
		// manuelle

		JLabel containerLabel = new JLabel();
		JPanel containerLeft = new JPanel();
		JPanel containerPerso = new JPanel();
		JPanel containerPoint = new JPanel();
		JPanel containerCarac1 = new JPanel();
		JPanel containerCarac2 = new JPanel();
		JPanel containerAction = new JPanel();
		JPanel containerToutCompetence = new JPanel();
		JPanel containerToutCompetence1 = new JPanel();
		JPanel containerToutCompetence12 = new JPanel();
		JPanel containerToutCompetence2 = new JPanel();
		JPanel containerToutCompetence22 = new JPanel();
		JPanel containerDescrition = new JPanel(), containerDescrition2 = new JPanel(),
				containerDescrition3 = new JPanel(), containerChoix = new JPanel();

		JScrollPane scroll = new JScrollPane(containerToutCompetence12);
		scroll.getVerticalScrollBar().setUnitIncrement(20);
		JScrollPane scroll2 = new JScrollPane(containerToutCompetence22);
		scroll2.getVerticalScrollBar().setUnitIncrement(30);

		JButton random = new JButton("Caract. Auto");
		JButton appercu = new JButton("Actualiser");
		JButton suivant = new JButton("Editer");
		JButton ecrire = new JButton("Sauver");
		

		nom.setText(persoCht.getNom());
		nationalite.setText(persoCht.getNationnalite());
		diplome.setText(persoCht.getDiplome());
		force.setText(Integer.toString(persoCht.getForce()));
		intelligence.setText(Integer.toString(persoCht.getIntelligence()));
		dexterite.setText(Integer.toString(persoCht.getDexterite()));
		pouvoir.setText(Integer.toString(persoCht.getPouvoir()));
		apparence.setText(Integer.toString(persoCht.getApparance()));
		constitution.setText(Integer.toString(persoCht.getConstitution()));
		education.setText(Integer.toString(persoCht.getEducation()));
		taille.setText(Integer.toString(persoCht.getTaille()));
		age.setText(Integer.toString(persoCht.getAge()));
		idee.setText(Integer.toString(persoCht.getIdee()));
		santer.setText(Integer.toString(persoCht.getSante()));
		chance.setText(Integer.toString(persoCht.getChance()));
		connaissance.setText(Integer.toString(persoCht.getConnaissance()));
		santeMentale.setText(Integer.toString(persoCht.getSanteMentale()));
		pointMagie.setText(Integer.toString(persoCht.getPm()));
		pointVie.setText(Integer.toString(persoCht.getPv()));
		mythe.setText(Integer.toString(persoCht.getMytheC()));
		bonusDegat.setText(persoCht.getBonusDegat());
		description.setText(persoCht.getDescription());
		famille.setText(persoCht.getFamille());
		residence.setText(persoCht.getResidence());
		revenu.setText(persoCht.getRevenu());
		description.setText(persoCht.getDescription());
		
		container.removeAll();

		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
		// affichage de l'id du perso

		Icon img = new ImageIcon(new ImageIcon("img/edit/bandeaugauche.jpg").getImage().getScaledInstance(780, 120,
				Image.SCALE_DEFAULT));

		containerLabel.setIcon(img);
		containerLeft.setLayout(new FlowLayout(FlowLayout.LEFT));
		containerLeft.setBackground(Color.white);
		containerLeft.add(containerLabel);

		container.add(containerLeft);

		containerPerso.setLayout(new GridLayout(3, 4));
		containerPerso.setBackground(Color.white);

		containerPerso.add(new JLabelP(" Nom : ", font));
		containerPerso.add(nom);
		containerPerso.add(new JLabelP(" Sexe : ", font));
		containerPerso.add(sexe);
		sexe.setBackground(Color.white);
		sexe.setSelectedIndex(persoCht.getSexe2());
		sexe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.ItemSexe();
			}
		});

		containerPerso.add(new JLabelP(" Age : ", font));
		containerPerso.add(age);
		containerPerso.add(new JLabelP(" Nationnalité : ", font));
		containerPerso.add(nationalite);
		containerPerso.add(new JLabelP(" Proffession : ", font));
		metier.setBackground(Color.white);
		metier.setPreferredSize(new Dimension(100, 20));
		containerPerso.add(metier);
		metier.setSelectedIndex(persoCht.GetMetier());
		metier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.ItemMetier();
			}
		});

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

		containerDescrition.setLayout(new BoxLayout(containerDescrition, BoxLayout.LINE_AXIS));
		containerDescrition2.setBackground(Color.white);
		containerDescrition3.setBackground(Color.white);
		containerDescrition2.setLayout(new GridLayout(4, 2));
		containerDescrition2.add(new JLabelP("Residence : ", font));
		containerDescrition2.add(residence);
		containerDescrition2.add(new JLabelP("Famille : ", font));
		containerDescrition2.add(famille);
		containerDescrition2.add(new JLabelP("Revenu : ", font));
		containerDescrition2.add(revenu);
		containerDescrition.add(containerDescrition2);
		containerDescrition3.setLayout(new GridLayout(2, 1));
		containerDescrition3.setBackground(Color.white);
		containerDescrition3.add(new JScrollPane(description));
		containerDescrition.add(containerDescrition3);
		container.add(containerDescrition);

		containerChoix.setLayout(new GridLayout(4, 2));
		containerChoix.setBackground(Color.white);
		containerChoix.add(new JLabelP("Choix de la langue étrangére : ", font));
		langueEtr.setBackground(Color.white);
		containerChoix.add(langueEtr);
		langueEtr.setSelectedIndex(persoCht.GetLangueEtrangere());
		containerChoix.add(new JLabelP("Choix Arme au CàC : ", font));
		armeCaC.setBackground(Color.white);
		containerChoix.add(armeCaC);
		armeCaC.setSelectedIndex(persoCht.GetArmeCaC());
		containerChoix.add(new JLabelP("Choix Arme à feu : ", font));
		armeAFeu.setBackground(Color.white);
		containerChoix.add(armeAFeu);
		armeAFeu.setSelectedIndex(persoCht.GetArmeAFeu());
		containerChoix.add(new JLabelP("Choix Desordre Psychologique : ", font));
		desordrePsy.setBackground(Color.white);
		containerChoix.add(desordrePsy);
		desordrePsy.setSelectedIndex(persoCht.GetPsy());
		container.add(containerChoix);
		langueEtr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.ItemLangueEtr();
			}
		});
		armeCaC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.ItemArmeCaC();
			}
		});
		armeAFeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.ItemArmeAFeu();
			}
		});
		desordrePsy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.ItemPsy();
			}
		});

		containerToutCompetence.setLayout(new BoxLayout(containerToutCompetence, BoxLayout.LINE_AXIS));
		containerToutCompetence1.setLayout(new BoxLayout(containerToutCompetence1, BoxLayout.PAGE_AXIS));
		containerToutCompetence1.setBackground(Color.white);
		containerToutCompetence1
				.add(new JLabelP("Vous avez " + persoCht.getPointCompMetier() + " points de compétence métier", font2));
		containerToutCompetence12.setBackground(Color.white);
		scroll.setBackground(Color.white);

		containerToutCompetence12.setLayout(new GridLayout(65, 1));

		for (int i = 0; i < competence.length; i++) {
			competenceBT[i] = new BoutonComp(competence[i], competenceBool.get(i), persoCht.getCompetenceInit(i),
					persoCht.getCompMetierPerso(i));
			competenceBT[i].setBackground(Color.white);
			containerToutCompetence12.add(competenceBT[i]);
		}

		containerToutCompetence1.add(scroll);
		containerToutCompetence.add(containerToutCompetence1);

		containerToutCompetence2.setLayout(new BoxLayout(containerToutCompetence2, BoxLayout.PAGE_AXIS));
		containerToutCompetence2.setBackground(Color.white);
		containerToutCompetence2
				.add(new JLabelP("Vous avez " + persoCht.getPointCompPerso() + " points de compétence perso.", font2));
		scroll2.setBackground(Color.white);

		containerToutCompetence22.setBackground(Color.white);
		containerToutCompetence22.setLayout(new GridLayout(65, 1));
		for (int i = 0; i < competence.length; i++) {
			competenceBT2[i] = new BoutonComp(competence[i], competenceBool2.get(i), persoCht.getCompetenceInit(i),
					persoCht.getCompPPerso(i));
			competenceBT2[i].setBackground(Color.white);
			containerToutCompetence22.add(competenceBT2[i]);
		}
		containerToutCompetence2.add(scroll2);
		containerToutCompetence.add(containerToutCompetence2);

		container.add(containerToutCompetence);
		containerAction.setLayout(new GridLayout(1, 2));
		containerAction.setBackground(Color.white);
		containerAction.add(random);
		containerAction.add(appercu);
		containerAction.add(ecrire);
		containerAction.add(suivant);
		appercu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.Reload();
			}
		});
		suivant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.Edit();
			}
		});
		random.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.Auto();
			}
		});
		ecrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.Ecrire();
			}
		});

		container.add(containerAction);

		repaint();
		revalidate();

	}

	public ArrayList<Boolean> GetCompetenceBool() {
		return competenceBool;
	}

	public ArrayList<Boolean> GetCompetenceBool2() {
		return competenceBool2;
	}

	public void SetCompetenceBool(ArrayList<Boolean> competenceBool) {
		this.competenceBool = competenceBool;
	}

	public void SetCompetenceBool2(ArrayList<Boolean> competenceBool) {
		this.competenceBool2 = competenceBool2;
	}

	public int GetCompetenceBT(int arg) {
		return competenceBT[arg].getComp();
	}

	public int GetCompetenceBTI(int arg) {
		return competenceBT[arg].getInit();
	}

	public void SetCompetenceBT(BoutonComp[] competenceBT) {
		this.competenceBT = competenceBT;
	}

	public int GetCompetenceBT2(int arg) {
		return competenceBT2[arg].getComp();
	}

	public void SetCompetenceBT2(BoutonComp[] competenceBT2) {
		this.competenceBT2 = competenceBT2;
	}
}
