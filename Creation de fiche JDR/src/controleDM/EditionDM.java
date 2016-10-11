package controleDM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import modelDM.PersoDM;
import vueDM.DataDM;

public class EditionDM extends JFrame implements DataDM {

	PersoDM persoDisque = null;

	String statOut;
	int var = 0;
	int mouv;
	private JButton bouton = new JButton("Enregistrer");

	private ArrayList traversAff = new ArrayList();
	private ArrayList comptAff = new ArrayList();
	private ArrayList comptAffType = new ArrayList();
	private ArrayList comptAffNv = new ArrayList();

	private ArrayList caractPerso = new ArrayList();
	private ArrayList<Boolean> initchkA = new ArrayList<Boolean>();
	private ArrayList<Boolean> initchkD = new ArrayList<Boolean>();
	private ArrayList<Boolean> initchkC = new ArrayList<Boolean>();
	private ArrayList<Boolean> initchkL = new ArrayList<Boolean>();
	private ArrayList<Boolean> initchkM = new ArrayList<Boolean>();

	private JPanel container = new JPanel(), container2 = new JPanel();

	JLabel img = new JLabel();
	JLabel img2 = new JLabel();
	JLabel img3 = new JLabel();

	public EditionDM(PersoDM persoDisque) {

		this.persoDisque = persoDisque;
		initchkA = persoDisque.getInitchkA();
		initchkD = persoDisque.getInitchkD();
		initchkL = persoDisque.getInitchkL();
		initchkC = persoDisque.getInitchkC();
		initchkM = persoDisque.getInitchkM();

		Statut();
		ReadTravers();
		ReadComp();
		Perso aff = new Perso();

		this.setTitle("Edition Disque Monde");
		this.setSize(600, 850);
		img.setSize(1100, 1500);
		img2.setSize(1100, 1500);
		aff.setSize(1100, 1500);
		container2.setSize(1100, 1500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		Icon icon = new ImageIcon(new ImageIcon("img/edit/discquemondebase.jpg").getImage()
				.getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_DEFAULT));

		this.getContentPane().add(container);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		aff.setOpaque(false);

		img.setIcon(icon);
		img.add(aff);
		container2.add(img);
		container.add(new JScrollPane(container2));
		container.add(bouton, BorderLayout.SOUTH);
		bouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Convert();
			}
		});

		this.setVisible(true);
		Convert();

	}

	public class Perso extends JPanel {

		public void paintComponent(Graphics g) {

			Font font = new Font("Times New Roman", Font.BOLD, 20);
			Font font2 = new Font("Times New Roman", Font.BOLD, 15);
			Font font3 = new Font("Times New Roman", Font.BOLD, 17);
			Font font4 = new Font("Times New Roman", Font.BOLD, 18);
			Font font5 = new Font("Times New Roman", Font.BOLD, 30);

			g.setFont(font);
			g.setColor(Color.black);

			// info perso :

			g.drawString("Nom : " + persoDisque.getNom(), 105, 215);
			g.drawString("Sexe : " + persoDisque.getSexe(), 370, 215);
			g.drawString("Race : " + persoDisque.getRace(), 530, 215);
			g.drawString("Profession : " + persoDisque.getProffession(), 760, 215);

			g.drawString("Age : " + persoDisque.getAge(), 105, 240);
			g.drawString("Taille : " + persoDisque.getTaille() + "m", 200, 240);
			g.drawString("Poids : " + persoDisque.getPoids() + "Kg", 370, 240);
			g.drawString("Origine : " + persoDisque.getNationalite(), 530, 240);

			g.drawString("Pt restant : " + persoDisque.getPointRestant(), 900, 240);

			g.drawString("Apparence : " + persoDisque.getDescription(), 105, 265);

			// caracteristique perso :
			g.setFont(font5);
			g.drawString("FO", 110, 350);
			g.drawString("DX", 110, 415);
			g.drawString("QI", 110, 480);
			g.drawString("SA", 110, 545);

			g.drawString("" + persoDisque.getForce(), 180, 350);
			g.drawString("" + persoDisque.getDex(), 180, 415);
			g.drawString("" + persoDisque.getInte(), 180, 480);
			g.drawString("" + persoDisque.getSante(), 180, 545);

			g.drawString("PdV", 310, 350);
			g.drawString("Vol", 310, 415);
			g.drawString("Per", 310, 480);
			g.drawString("PdF", 310, 545);

			g.drawString("" + persoDisque.getPdv(), 390, 350);
			g.drawString("" + persoDisque.getVolonte(), 390, 415);
			g.drawString("" + persoDisque.getPerception(), 390, 480);
			g.drawString("" + persoDisque.getPdf(), 390, 545);

			g.setFont(font2);
			g.drawString("Actuel", 440, 305);
			g.drawString("Actuel", 440, 495);

			// info divers 1
			g.setFont(font3);
			g.drawString("Poids soulevé :" + (persoDisque.getForce() + persoDisque.getForce()) / 4, 105, 600);
			g.drawString("Dommages Estoc/Taille :", 290, 600);

			g.drawString("Vitesse : " + persoDisque.getVitesse(), 105, 620);
			g.drawString("Mouvement : " + mouv, 290, 620);

			g.setFont(font);
			g.drawString("Encombrement", 105, 660);
			g.drawString("Mouvement", 290, 660);
			g.drawString("Esquive", 430, 660);

			g.setFont(font2);
			g.drawString("Null = PS", 105, 680);
			g.drawString("Faible = 2*PS", 105, 700);
			g.drawString("Moyen = 3*PS", 105, 720);
			g.drawString("Elevé = 6*PS", 105, 740);
			g.drawString("Trés Elevé = 10*PS", 105, 760);

			g.drawString("Mvt*1", 290, 680);
			g.drawString("Mvt*0.8", 290, 700);
			g.drawString("Mvt*0.6", 290, 720);
			g.drawString("Mvt*0.4", 290, 740);
			g.drawString("Mvt*0.2", 290, 760);

			g.drawString("Esquive", 430, 680);
			g.drawString("Esquive-1", 430, 700);
			g.drawString("Esquive-2", 430, 720);
			g.drawString("Esquive-3", 430, 740);
			g.drawString("Esquive-4", 430, 760);

			// language

			g.setFont(font3);
			g.drawString("Langages", 590, 330);
			g.drawString("Parlés", 750, 330);
			g.drawString("Ecrits", 900, 330);

			int tempL = choixLangues.length;
			int posXL = 590;
			int posYL = 350;
			int posL = 0;
			String strLangues;
			g.setFont(font2);
			for (int clangue = 0; clangue < tempL; clangue++) {

				if (initchkL.get(clangue) == true) {
					strLangues = choixLangues[clangue].substring(4);
					g.drawString("" + strLangues, posXL, posYL + (posL * 20));
					posL++;

				}
			}

			// diver 2

			g.setFont(font3);
			g.drawString("Parade", 590, 465);
			g.drawString("Blocage", 590, 565);
			g.drawString("Modificateur de Réaction", 670, 465);
			g.setFont(font2);
			g.drawString("Apparence " + persoDisque.getApparence().substring(4), 670, 485);
			g.drawString("Statut : " + statOut, 670, 505);
			g.drawString("Réputation", 670, 525);

			// avantage
			g.setFont(font);
			g.drawString("Avantages", 105, 790);

			int tempA = choixAvantages.length;
			int posXA = 105;
			int posYA = 810;
			int posA = 0;
			String strAvantages;
			g.setFont(font2);
			for (int cavantages = 0; cavantages < tempA; cavantages++) {

				if (initchkA.get(cavantages) == true) {
					strAvantages = choixAvantages[cavantages].substring(4);
					g.drawString("" + strAvantages, posXA, posYA + (posA * 20));
					posA++;
				}
			}

			// desavantage et travers

			g.setFont(font);
			g.drawString("Travers et Désavantages ", 105, 1100);

			int posXT = 105;
			int posYT = 1120;
			int posT = 0;
			g.setFont(font2);
			for (int ctravers = 0; ctravers < var; ctravers++) {
				g.drawString("" + traversAff.get(ctravers).toString(), posXT, posYT + (posT * 20));
				posT++;

			}

			int tempD = choixDesavantages.length;
			int posXD = 105;
			int posYD = posYT + 10 + (posT * 20);
			String strDesavantages;
			int posD = 0;
			g.setFont(font2);
			for (int cdesavantages = 0; cdesavantages < tempD; cdesavantages++) {

				if (initchkD.get(cdesavantages) == true) {
					strDesavantages = choixDesavantages[cdesavantages].substring(4);
					g.drawString("" + strDesavantages, posXD, posYD + (posD * 20));
					posD++;
				}
			}

			// comp�tences
			g.setFont(font);
			g.drawString("Compétences", 590, 665);
			g.setFont(font2);
			g.drawString("Nom", 590, 685);
			g.drawString("Type", 850, 685);
			g.drawString("Niveau", 950, 685);

			int tempC = choixCompetences.length;
			int posXC = 590;
			int posYC = 705;
			String strCompetences;
			int posC = 0;
			g.setFont(font2);
			for (int ccompetence = 0; ccompetence < tempC; ccompetence++) {

				if (initchkC.get(ccompetence) == true) {
					// strCompetences =
					// choixCompetences[ccompetence].substring(4);
					g.drawString("" + comptAff.get(ccompetence).toString(), 590, posYC + (posC * 20));
					g.drawString("" + comptAffType.get(ccompetence).toString(), 850, posYC + (posC * 20));
					g.drawString("" + comptAffNv.get(ccompetence).toString(), 950, posYC + (posC * 20));

					posC++;
				}
			}

			// Magie
			g.setFont(font);
			g.drawString("Magie", 590, 1100);

			int tempM = choixMagie.length;
			int posXM = 590;
			int posYM = 1120;
			int posM = 0;
			String strMagie;
			g.setFont(font2);
			for (int cmagie = 0; cmagie < tempM; cmagie++) {

				if (initchkM.get(cmagie) == true) {
					strMagie = choixMagie[cmagie].substring(4);
					g.drawString("" + strMagie, posXM, posYM + (posM * 20));
					posM++;
				}
			}
		}
	}

	public String SelecChemin() {
		// permet de choisir la destination et le nom de la fiche pour
		// l'enregistrement
		JOptionPane jop2 = new JOptionPane();
		String monFichier = "";
		JFileChooser cheminInt = new JFileChooser();

		cheminInt.setCurrentDirectory(new File("."));
		String approve = new String("ENREGISTRER");
		int resultatEnregistrer = cheminInt.showDialog(cheminInt, approve);
		if (resultatEnregistrer == JFileChooser.APPROVE_OPTION) {
			monFichier = new String(cheminInt.getSelectedFile().toString());
		}
		if (monFichier.endsWith(".jpg") || monFichier.endsWith(".JPG")) {
			;
		} else
			monFichier = monFichier + ".jpg";

		return monFichier;
	}

	public void Convert() {

		BufferedImage image = new BufferedImage(container2.getSize().width, container2.getSize().height,
				BufferedImage.TYPE_INT_ARGB);
		container2.paint(image.createGraphics());
		File imageFile = new File(SelecChemin());
		try {
			imageFile.createNewFile();
			ImageIO.write(image, "png", imageFile);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void Statut() {

		double stat = Double.parseDouble(persoDisque.getApparence().substring(0, 3));
		if (stat == -16)
			statOut = " -4 à vos jets de réaction.";
		else if (stat == -8)
			statOut = " -2 à vos jets de réaction.";
		else if (stat == -4)
			statOut = " -1 à vos jets de réaction.";
		else if (stat == 0)
			statOut = " Vous vous fondez dans la masse.";
		else if (stat == 4)
			statOut = "  +1 à vos jets de réaction.";
		else if (stat == 12)
			statOut = " +2 à vos jets de réaction, +4 au sexe opposée.";
		else if (stat == 16)
			statOut = " +2 à vos jets de réaction, +6 au sexe opposée.";

	}

	public void ReadTravers() {
		// decompose le string travers en une arraylist de string (mots s�par�
		// par les virgule)
		int z2 = 0;
		String traversOut;
		for (int z = 0; z < persoDisque.getTravers().length(); z++) {
			if (persoDisque.getTravers().charAt(z) == ',') {
				traversOut = persoDisque.getTravers().substring(z2, z);
				traversAff.add(traversOut);
				z2 = z + 2;
				var++;
			} else if (z == persoDisque.getTravers().length() - 1) {
				traversOut = persoDisque.getTravers().substring(z2);
				traversAff.add(traversOut);
				var++;
			}
		}
	}

	public void ReadComp() {
		String comptTemp = null;
		int xt = 0;
		for (int x = 0; x < choixCompetences.length; x++) {
			comptTemp = choixCompetences[x].toString();

			xt = comptTemp.indexOf("   ");
			comptAff.add(comptTemp.substring(5, xt));

			if (comptTemp.contains("Dextérité")) {
				comptAffType.add("Dextérité");
			}
			if (comptTemp.contains("QI")) {
				comptAffType.add("QI");
			}
			if (comptTemp.contains("Santé")) {
				comptAffType.add("Santé");
			}
			comptAffNv.add(comptTemp.substring(comptTemp.length() - 5));
		}
	}

}
