package vueDM;

import java.awt.Color;

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
import javax.swing.JTextField;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import controleDM.EditDM;
import vueChtullu.JLabelP;

public class FenetreDM3 extends JFrame implements DataDM {
	
	private static final Logger logger = LogManager.getLogger(FenetreDM3.class.getName());

	private JPanel container = new JPanel();

	private ArrayList caractPerso = new ArrayList();

	private ArrayList<Boolean> initchkA = new ArrayList<Boolean>();
	private ArrayList<Boolean> initchkD = new ArrayList<Boolean>();
	private ArrayList<Boolean> initchkC = new ArrayList<Boolean>();
	private ArrayList<Boolean> initchkL = new ArrayList<Boolean>();
	private ArrayList<Boolean> initchkM = new ArrayList<Boolean>();

	private JTextField description = new JTextField();
	private JTextField travers = new JTextField();

	private Font font = new Font("Times New Roman", Font.BOLD, 15);

	private String nomPerso, prof, sexe, nat;

	public FenetreDM3(ArrayList caractPerso, ArrayList<Boolean> initchkA, ArrayList<Boolean> initchkD,
			ArrayList<Boolean> initchkC, ArrayList<Boolean> initchkL, ArrayList<Boolean> initchkM) {

		// public FenetreDM3() {

		this.caractPerso = caractPerso;
		this.initchkA = initchkA;
		this.initchkD = initchkD;
		this.initchkC = initchkC;
		this.initchkL = initchkL;
		this.initchkM = initchkM;

		nomPerso = (String) caractPerso.get(0);
		prof = (String) caractPerso.get(13);
		sexe = (String) caractPerso.get(1);
		nat = (String) caractPerso.get(14);

		this.setTitle("Création de personnage Disque Monde : ");
		this.setSize(700, 300);
		this.setBackground(Color.white);
		this.setFont(font);
		this.setLocationRelativeTo(null);

		this.getContentPane().add(container);
		container.setBackground(Color.white);

		screen3();
		this.setResizable(false);
		this.setVisible(true);

	}

	private void screen3() {

		JPanel containerDescrition3 = new JPanel(), containerDescrition2 = new JPanel(), containerBT = new JPanel(),
				containerArmes = new JPanel(), containerTravers = new JPanel(), containerDescrition = new JPanel();

		JLabel containerLabel = new JLabel();
		JLabel containerLabel2 = new JLabel();
		JPanel containerLeft = new JPanel();
		JPanel containerCentre = new JPanel();

		JLabel labelNom = new JLabelP(nomPerso, font);
		JLabel labelProf = new JLabelP(prof, font);
		JLabel labelSexe = new JLabelP(sexe, font);
		JLabel labelNat = new JLabelP(nat, font);

		JButton suivant = new JButton("Editer");

		container.removeAll();

		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));

		Icon img = new ImageIcon(
				new ImageIcon("img/edit/bandeauDM.jpg").getImage().getScaledInstance(680, 70, Image.SCALE_DEFAULT));

		containerLabel.setIcon(img);
		containerLeft.setLayout(new FlowLayout(FlowLayout.LEFT));
		containerLeft.setBackground(Color.white);
		containerLeft.add(containerLabel);
		container.add(containerLeft);

		containerDescrition.setLayout(new BoxLayout(containerDescrition, BoxLayout.LINE_AXIS));
		containerDescrition2.setBackground(Color.white);
		containerDescrition3.setBackground(Color.white);
		containerDescrition2.setLayout(new GridLayout(4, 2));
		containerDescrition2.add(new JLabelP("Nom : ", font));
		containerDescrition2.add(labelNom);
		containerDescrition2.add(new JLabelP("Sexe : ", font));
		containerDescrition2.add(labelSexe);
		containerDescrition2.add(new JLabelP("Proffession : ", font));
		containerDescrition2.add(labelProf);
		containerDescrition2.add(new JLabelP("Nationnalité : ", font));
		containerDescrition2.add(labelNat);

		containerDescrition.add(containerDescrition2);

		containerDescrition3.setLayout(new GridLayout(2, 1));
		containerDescrition3.setBackground(Color.white);
		containerDescrition3.add(new JLabelP("Veuillez décrire votre personnage : ", font));
		containerDescrition3.add(new JScrollPane(description));
		containerDescrition.add(containerDescrition3);
		container.add(containerDescrition);

		containerTravers.setLayout(new GridLayout(2, 1));
		containerTravers.setBackground(Color.white);
		containerTravers.add(
				new JLabelP("Veuillez indiquer les travers de votre avatar (séparés par une virgule, svp) : ", font));
		containerTravers.add(new JScrollPane(travers));
		container.add(containerTravers);

		containerBT.setBackground(Color.white);
		containerBT.add(suivant);
		container.add(containerBT);
		suivant.addActionListener(new next());

	}

	private class next implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// passe a la fenetre suivante et envois les donn� contenues dans
			// les List : caractPerso, avantagesPerso, desavantagesPerso,
			// traversPerso
			caractPerso.add(description.getText()); // 20
			caractPerso.add(travers.getText());
			logger.debug("Caractéristique perso final : " + caractPerso.toString());
			EditDM suivant = new EditDM(caractPerso, initchkA, initchkD, initchkC, initchkL, initchkM);

			dispose();
		}
	}

}
