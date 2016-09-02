package controleChtullu;

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

import modelChtullu.PersoChtullu;
import vueChtullu.DataChtullu;

public class EditCht extends JFrame implements DataChtullu {

	PersoChtullu persoCht = null;

	private JPanel container = new JPanel(), container2 = new JPanel();
	private JButton bouton = new JButton("Enregistrer");
	JLabel img = new JLabel();
	JLabel img2 = new JLabel();
	JLabel img3 = new JLabel();

	private ArrayList psm = new ArrayList();
	private ArrayList pVie = new ArrayList();
	private ArrayList pMagie = new ArrayList();

	public EditCht(PersoChtullu persoCht) {

		this.persoCht = persoCht;

		Perso aff = new Perso();

		this.setTitle("Edition perso");
		this.setSize(600, 850);
		img.setSize(1100, 1500);
		img2.setSize(1100, 1500);
		aff.setSize(1100, 1500);
		container2.setSize(1100, 1500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		Icon icon = new ImageIcon(new ImageIcon("img/edit/chtulhu-1920.jpg").getImage()
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
				convert();
			}
		});
		this.setVisible(true);
		convert();
	}

	public class Perso extends JPanel {

		public void paintComponent(Graphics g) {

			Font font = new Font("Times New Roman", Font.BOLD, 20);
			Font font2 = new Font("Times New Roman", Font.BOLD, 15);
			Font font3 = new Font("Times New Roman", Font.PLAIN, 17);
			Font font4 = new Font("Times New Roman", Font.BOLD, 18);

			g.setFont(font);
			g.setColor(Color.black);

			// info perso :
			// ligne 1
			g.drawString("Nom : " + persoCht.getNom(), 210, 105);

			// ligne 2
			g.drawString("Profession : " + persoCht.getProffession(), 210, 130);

			g.drawString("Age : " + persoCht.getAge(), 580, 130);

			// ligne 3
			g.drawString("Nationalité : " + persoCht.getNationnalite(), 210, 155);
			g.drawString("Résidence : " + persoCht.getResidence(), 470, 155);

			// ligne 4
			g.drawString("Diplômes : " + persoCht.getDiplome(), 210, 180);
			g.drawString("Sexe : " + persoCht.getSexe(), 470, 180);
			// ligne 5
			g.drawString("Folies : " + persoCht.getDesordrePsy(), 210, 205);
			// caracteristique perso :
			// ligne 6
			g.drawString("FOR : " + persoCht.getForce(), 210, 270);
			g.drawString("DEX : " + persoCht.getDexterite(), 315, 270);
			g.drawString("INT : " + persoCht.getIntelligence(), 425, 270);
			g.drawString("Idée : " + persoCht.getIdee(), 535, 270);
			// ligne 7
			g.drawString("CON : " + persoCht.getConstitution(), 210, 295);
			g.drawString("APP : " + persoCht.getApparance(), 315, 295);
			g.drawString("POU : " + persoCht.getPouvoir(), 425, 295);
			g.drawString("Chance : " + persoCht.getChance(), 535, 295);
			// ligne 8
			g.drawString("TAI : " + persoCht.getTaille(), 210, 320);
			g.drawString("SAN : " + persoCht.getSante(), 315, 320);
			g.drawString("EDU : " + persoCht.getEducation(), 425, 320);
			g.drawString("Connais : " + persoCht.getConnaissance(), 535, 320);
			// ligne 9
			g.drawString("Mythe de Chtulhu : " + persoCht.getMytheC(), 210, 345);
			g.drawString("Bonus de dégat : " + persoCht.getBonusDegat(), 425, 345);

			// competence perso :
			// ligne 10
			g.drawString("Compétences de l'Investigateur", 450, 600);
			g.setFont(font2);
			// ligne 11

			g.drawString("Anthropologie ................. " + persoCht.getCompGPerso(0), 210, 622);
			g.drawString("Esquiver (DEX x 2%) .......... " + persoCht.getCompGPerso(18), 430, 622);
			g.drawString("Premiers Soins .................... " + persoCht.getCompGPerso(39), 750, 622);
			// ligne 12
			g.drawString("Archéologie .................... " + persoCht.getCompGPerso(1), 210, 644);
			g.drawString("Géologie ............................... " + persoCht.getCompGPerso(19), 430, 644);
			g.drawString("Psychanalyse ....................... " + persoCht.getCompGPerso(40), 750, 644);
			// ligne 13
			g.drawString("Art ................................... " + persoCht.getCompGPerso(2), 210, 666);
			g.drawString("Grimper ................................ " + persoCht.getCompGPerso(20), 430, 666);
			g.drawString("Psychologie ......................... " + persoCht.getCompGPerso(41), 750, 666);
			// ligne 14
			g.drawString("Astronomie ..................... " + persoCht.getCompGPerso(4), 210, 688);
			g.drawString("Histoire ................................ " + persoCht.getCompGPerso(21), 430, 688);
			g.drawString("Sauter .................................. " + persoCht.getCompGPerso(42), 750, 688);
			// ligne 15
			g.drawString("Baratin ............................ " + persoCht.getCompGPerso(5), 210, 710);
			g.drawString("Lancer .................................. " + persoCht.getCompGPerso(23), 430, 710);
			g.drawString("Se Cacher ............................ " + persoCht.getCompGPerso(43), 750, 710);
			// ligne 16
			g.drawString("Bibliothéque ................... " + persoCht.getCompGPerso(6), 210, 732);
			g.drawString("Piloter Avion ........................ " + persoCht.getCompGPerso(38), 430, 732);
			g.drawString("Soigner Empoisonnement ... " + persoCht.getCompGPerso(61), 750, 732);
			// ligne 17
			g.drawString("Botanique ....................... " + persoCht.getCompGPerso(59), 210, 754);
			g.drawString("Langue Natale (EDU x 5%) .. " + persoCht.getCompGPerso(25), 430, 754);
			g.drawString("Soigner Maladie ................... " + persoCht.getCompGPerso(62), 750, 754);
			// ligne 18
			g.drawString("Camouflage ..................... " + persoCht.getCompGPerso(7), 210, 778);
			g.drawString("Histoire Naturel .................... " + persoCht.getCompGPerso(22), 430, 778);
			g.drawString("Suivre une Piste ................... " + persoCht.getCompGPerso(45), 750, 778);
			// ligne 19
			g.drawString("Chanter ........................... " + persoCht.getCompGPerso(58), 210, 800);
			g.drawString("Marchandage ........................ " + persoCht.getCompGPerso(26), 430, 800);
			g.drawString("Trouver Objet Caché ........... " + persoCht.getCompGPerso(46), 750, 800);
			// ligne 20
			g.drawString("Chimie ............................ " + persoCht.getCompGPerso(8), 210, 822);
			g.drawString("Mécanique ............................ " + persoCht.getCompGPerso(27), 430, 822);
			g.drawString("Médecine ................................ " + persoCht.getCompGPerso(28), 750, 822);
			// ligne 21
			g.drawString("Comptabilité .................. " + persoCht.getCompGPerso(9), 210, 844);
			g.drawString("Monter à Cheval ................... " + persoCht.getCompGPerso(29), 430, 844);
			g.drawString("Serrureries ........................... " + persoCht.getCompGPerso(44), 750, 844);
			// ligne 22
			g.drawString("Conduire Automobile .... " + persoCht.getCompGPerso(10), 210, 866);
			g.drawString("Mythe de Cthulhu ................. " + persoCht.getCompGPerso(30), 430, 866);
			g.drawString("Art Martiaux ........................ " + persoCht.getCompGPerso(3), 750, 866);
			// ligne 23
			g.drawString("Conduire Engin Lourd ... " + persoCht.getCompGPerso(11), 210, 888);
			g.drawString("Nager ..................................... " + persoCht.getCompGPerso(31), 430, 888);
			g.drawString("Coup de Pied ........................ " + persoCht.getCompGPerso(52), 750, 888);
			// ligne 24
			g.drawString("Crédit ............................. " + persoCht.getCompGPerso(12), 210, 910);
			g.drawString("Occultisme ............................. " + persoCht.getCompGPerso(33), 430, 910);
			g.drawString("Coup de Poing ...................... " + persoCht.getCompGPerso(53), 750, 910);
			// ligne 25
			g.drawString("Dessiner une Carte ........ " + persoCht.getCompGPerso(57), 210, 932);
			g.drawString("Pharmacologie ....................... " + persoCht.getCompGPerso(35), 430, 932);
			g.drawString("Coup de Téte ........................ " + persoCht.getCompGPerso(54), 750, 932);
			// ligne 26
			g.drawString("Discrétion ....................... " + persoCht.getCompGPerso(13), 210, 954);
			g.drawString("Photographie .......................... " + persoCht.getCompGPerso(36), 430, 954);
			g.drawString("Lutte ..................................... " + persoCht.getCompGPerso(55), 750, 954);
			// ligne 27
			g.drawString("Dissimulation .................. " + persoCht.getCompGPerso(14), 210, 976);
			g.drawString("Pickpocket ............................. " + persoCht.getCompGPerso(60), 430, 976);
			g.drawString("Arme de Poing ....................... " + persoCht.getCompGPerso(47), 750, 976);

			// ligne 28
			g.drawString("Droit................................ " + persoCht.getCompGPerso(15), 210, 998);
			g.drawString("Langues étr (" + persoCht.getLangueEtr() + ")....." + persoCht.getCompGPerso(24), 430, 998);
			g.drawString("Fusil de Chasse ...................... " + persoCht.getCompGPerso(49), 750, 998);

			// ligne 29
			g.drawString("Ecouter ........................... " + persoCht.getCompGPerso(16), 210, 1020);
			g.drawString("Navigation .............................. " + persoCht.getCompGPerso(32), 430, 1020);
			g.drawString("Fusil ....................................... " + persoCht.getCompGPerso(48), 750, 1020);

			// ligne 30
			g.drawString("Electricité ....................... " + persoCht.getCompGPerso(17), 210, 1042);
			g.drawString("Persuasion ............................. " + persoCht.getCompGPerso(34), 430, 1042);
			g.drawString("Mitraillette............................. " + persoCht.getCompGPerso(50), 750, 1042);

			// ligne 31
			g.drawString("Eloquence ....................... " + persoCht.getCompGPerso(56), 210, 1064);
			g.drawString("Physique ................................ " + persoCht.getCompGPerso(37), 430, 1064);
			g.drawString("Mitrailleuse ............................ " + persoCht.getCompGPerso(51), 750, 1064);

			// affichage des armes
			// ligne 32
			g.setFont(font);
			g.drawString("Armes ", 300, 1140);
			g.drawString("Sorts, compétences spéciales, notes", 670, 1140);

			// ligne 33
			g.setFont(font2);
			g.drawString("Arme                   %Att       Dom.      Portée      Munit.        PDV", 120, 1170);
			g.drawString("" + persoCht.getArmeCc(), 120, 1200);
			g.drawString("" + persoCht.getArmeF(), 120, 1230);

			// affichage point de sant� mentale

			g.setFont(font);
			g.drawString("Point de santé mentale", 325, 405);

			g.setFont(font3);
			int hauteur = 430;
			int largeur = 190;
			int ld = 0;
			int le = 0;
			int lf = 0;
			int lg = 0;
			int lh = 0;
			for (int c = 1; c < 100; c++) {
				psm.add(c);
			}
			for (int f = 0; f < 99; f++) {
				if (psm.get(f).equals(persoCht.getSanteMentale())) {
					g.setFont(font4);
				} else
					g.setFont(font3);

				if (f < 19) {
					hauteur = 430;
					g.drawString(" " + psm.get(f).toString(), largeur + (ld * 25), hauteur);
					ld++;
				} else if (f >= 19 && f < 39) {
					hauteur = 455;
					g.drawString(" " + psm.get(f).toString(), largeur + (le * 25), hauteur);
					le++;
				} else if (f >= 39 && f < 59) {
					hauteur = 480;
					g.drawString(" " + psm.get(f).toString(), largeur + (lf * 25), hauteur);
					lf++;
				} else if (f >= 59 && f < 79) {
					hauteur = 505;
					g.drawString(" " + psm.get(f).toString(), largeur + (lg * 25), hauteur);
					lg++;
				} else if (f >= 79 && f < 99) {
					hauteur = 530;
					g.drawString(" " + psm.get(f).toString(), largeur + (lh * 25), hauteur);
					lh++;
				}
			}

			// affichage des points de vie
			g.setFont(font);
			g.drawString("Point de vie", 740, 405);

			g.setFont(font);
			int hauteurPV = 430;
			int largeurPV = 727;
			int ldPV = 0;
			int lePV = 0;
			int lfPV = 0;
			int lgPV = 0;
			int lhPV = 0;
			for (int vie = 1; vie < 24; vie++) {
				pVie.add(vie);
			}
			for (int fPV = 0; fPV < 23; fPV++) {
				if (psm.get(fPV).equals(persoCht.getPv())) {
					g.setFont(font4);
				} else
					g.setFont(font3);

				if (fPV <= 4) {
					hauteurPV = 430;
					g.drawString(" " + psm.get(fPV).toString(), largeurPV + (ldPV * 25), hauteurPV);
					ldPV++;
				} else if (fPV >= 5 && fPV < 10) {
					hauteurPV = 455;
					g.drawString(" " + psm.get(fPV).toString(), largeurPV + (lePV * 25), hauteurPV);
					lePV++;
				} else if (fPV >= 10 && fPV < 15) {
					hauteurPV = 480;
					g.drawString(" " + psm.get(fPV).toString(), largeurPV + (lfPV * 25), hauteurPV);
					lfPV++;
				} else if (fPV >= 15 && fPV < 20) {
					hauteurPV = 505;
					g.drawString(" " + psm.get(fPV).toString(), largeurPV + (lgPV * 25), hauteurPV);
					lgPV++;
				} else if (fPV >= 20 && fPV < 22) {
					hauteurPV = 530;
					g.drawString(" " + psm.get(fPV).toString(), largeurPV + (lhPV * 25), hauteurPV);
					lhPV++;
				}
			}

			// affichage des points de Magie
			g.setFont(font);
			g.drawString("Point de Magie", 870, 405);

			g.setFont(font3);
			int hauteurPM = 430;
			int largeurPM = 870;
			int ldPM = 0;
			int lePM = 0;
			int lfPM = 0;
			int lgPM = 0;
			int lhPM = 0;
			for (int magie = 1; magie < 24; magie++) {
				pVie.add(magie);
			}
			for (int fPM = 0; fPM < 23; fPM++) {
				if (psm.get(fPM).equals(persoCht.getPm())) {
					g.setFont(font4);
				} else
					g.setFont(font3);

				if (fPM <= 4) {
					hauteurPM = 430;
					g.drawString(" " + psm.get(fPM).toString(), largeurPM + (ldPM * 25), hauteurPM);
					ldPM++;
				} else if (fPM >= 5 && fPM < 10) {
					hauteurPM = 455;
					g.drawString(" " + psm.get(fPM).toString(), largeurPM + (lePM * 25), hauteurPM);
					lePM++;
				} else if (fPM >= 10 && fPM < 15) {
					hauteurPM = 480;
					g.drawString(" " + psm.get(fPM).toString(), largeurPM + (lfPM * 25), hauteurPM);
					lfPM++;
				} else if (fPM >= 15 && fPM < 20) {
					hauteurPM = 505;
					g.drawString(" " + psm.get(fPM).toString(), largeurPM + (lgPM * 25), hauteurPM);
					lgPM++;
				} else if (fPM >= 20 && fPM < 22) {
					hauteurPM = 530;
					g.drawString(" " + psm.get(fPM).toString(), largeurPM + (lhPM * 25), hauteurPM);
					lhPM++;
				}
			}
			// affichage divers
			g.setFont(font);
			g.drawString("Statut M. : " + persoCht.getFamille(), 740, 105);
			g.drawString("Revenu : " + persoCht.getRevenu(), 740, 130);
			g.drawString("Description : ", 740, 155);
			g.setFont(font2);
			ArrayList<Character> tabMot = new ArrayList<Character>();
			char[] tabMot2 = persoCht.getDescription().toCharArray();
			int longueur = tabMot2.length;
			for (int z = 0; z < longueur; z++) {
				tabMot.add(tabMot2[z]);
			}

			int ligne = 30;
			int posX = 740;
			int posY = 180;
			String str, str2, str3, str4, str5, str6, str7;
			str = str2 = str3 = str4 = str5 = str6 = str7 = "";
			for (int u = 0; u < longueur; u++) {

				if (u <= ligne) {
					str = str + tabMot.get(u);
					g.drawString("" + str, posX, posY);
				} else if (u > ligne && u <= ligne * 2) {
					str2 = str2 + tabMot.get(u);
					g.drawString("" + str2, posX, posY + 25);
				} else if (u > ligne * 2 && u <= ligne * 3) {
					str3 = str3 + tabMot.get(u);
					g.drawString("" + str3, posX, posY + 50);
				} else if (u > ligne * 3 && u <= ligne * 4) {
					str4 = str4 + tabMot.get(u);
					g.drawString("" + str4, posX, posY + 75);
				} else if (u > ligne * 4 && u <= ligne * 5) {
					str5 = str5 + tabMot.get(u);
					g.drawString("" + str5, posX, posY + 100);
				} else if (u > ligne * 5 && u <= ligne * 6) {
					str6 = str + tabMot.get(u);
					g.drawString("" + str6, posX, posY + 125);
				} else if (u > ligne * 6 && u <= ligne * 7) {
					str7 = str7 + tabMot.get(u);
					g.drawString("" + str7, posX, posY + 150);
				}
			}
		}
	}

	public String selecChemin() {
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

	public void convert() {

		BufferedImage image = new BufferedImage(container2.getSize().width, container2.getSize().height,
				BufferedImage.TYPE_INT_ARGB);
		container2.paint(image.createGraphics());
		File imageFile = new File(selecChemin());
		try {
			imageFile.createNewFile();
			ImageIO.write(image, "png", imageFile);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
