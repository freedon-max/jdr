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

public class EdtitionChtullu extends JFrame {

	// creation de la fiche perso imprimable en jpg

	private ArrayList<String> caractPerso = new ArrayList<String>();
	private ArrayList compGPerso = new ArrayList();
	private ArrayList diversPerso = new ArrayList();
	private ArrayList psm = new ArrayList();
	private ArrayList pVie = new ArrayList();
	private ArrayList pMagie = new ArrayList();

	private JPanel container = new JPanel(), container2 = new JPanel();
	private JButton bouton = new JButton("Enregistrer");
	JLabel img = new JLabel();
	JLabel img2 = new JLabel();
	JLabel img3 = new JLabel();

	private int forc, dex, inte, ide, con, app, pou, chanc, tai, san, edu, connais, sm, pm, pv = 0;
	private int age;
	private int mytheC = 99;
	private String nom, sexe, nat, dipl, bd, prof;
	private String residence, famille, description, langueEtr, armeCAC, armeAFeu, psy, revenu;

	private int anthropologie, archeologie, art, artMartiaux, astronomie, baratin, bibliotheque, camouflage, chimie,
			comptabilite, conduireAuto, conduireEnginLourd, credit, discretion, dissimulation, droit, ecouter,
			electricitee, esquiver, geologie, grimper, histoire, histoireNaturel, lancer, languesEtrangeres,
			langueNatale, marchandage, mecanique, medecine, monterCheval, mytheChtullu, nager, navigation, occultisme,
			persuasion, pharmacologi, photographie, physique, piloter, permiersSoins, psychanalyse, psychologie,
			sauters, seCacher, serrureries, suivrePistes, trouverObjetCache, armePoing, fusil, fusilChasse, mitrailette,
			mitrailleuse, coupPied, coupPoing, coupcTete, lutte, eloquence, dessinerCarte, chanter, botanique,
			pickpocket, soignerEmpoisonnement, soignerMaladie;

	public EdtitionChtullu(ArrayList<String> caractPerso, ArrayList compGPerso, ArrayList diversPerso) {

		this.caractPerso = caractPerso;
		this.compGPerso = compGPerso;
		this.diversPerso = diversPerso;
		System.out.println("compGperso final :  " + compGPerso.toString());
		readPerso();
		readComp();
		readDiver();
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
		bouton.addActionListener(new ActionListener(){
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
			g.drawString("Nom : " + nom, 210, 105);

			// ligne 2
			g.drawString("Profession : " + prof, 210, 130);

			g.drawString("Age : " + age, 580, 130);

			// ligne 3
			g.drawString("Nationalité : " + nat, 210, 155);
			g.drawString("Résidence : " + residence, 470, 155);

			// ligne 4
			g.drawString("Diplômes : " + dipl, 210, 180);
			g.drawString("Sexe : " + sexe, 470, 180);
			// ligne 5
			g.drawString("Folies : " + psy, 210, 205);
			// caracteristique perso :
			// ligne 6
			g.drawString("FOR : " + forc, 210, 270);
			g.drawString("DEX : " + dex, 315, 270);
			g.drawString("INT : " + inte, 425, 270);
			g.drawString("Idée : " + ide, 535, 270);
			// ligne 7
			g.drawString("CON : " + con, 210, 295);
			g.drawString("APP : " + app, 315, 295);
			g.drawString("POU : " + pou, 425, 295);
			g.drawString("Chance : " + chanc, 535, 295);
			// ligne 8
			g.drawString("TAI : " + tai, 210, 320);
			g.drawString("SAN : " + san, 315, 320);
			g.drawString("EDU : " + edu, 425, 320);
			g.drawString("Connais : " + connais, 535, 320);
			// ligne 9
			g.drawString("Mythe de Chtulhu : " + mytheC, 210, 345);
			g.drawString("Bonus de dégat : " + bd, 425, 345);

			// competence perso :
			// ligne 10
			g.drawString("Compétences de l'Investigateur", 450, 600);
			g.setFont(font2);
			// ligne 11

			g.drawString("Anthropologie ................. " + anthropologie, 210, 622);
			g.drawString("Esquiver (DEX x 2%) .......... " + esquiver, 430, 622);
			g.drawString("Premiers Soins .................... " + permiersSoins, 750, 622);
			// ligne 12
			g.drawString("Archéologie .................... " + archeologie, 210, 644);
			g.drawString("Géologie ............................... " + geologie, 430, 644);
			g.drawString("Psychanalyse ....................... " + psychanalyse, 750, 644);
			// ligne 13
			g.drawString("Art ................................... " + art, 210, 666);
			g.drawString("Grimper ................................ " + grimper, 430, 666);
			g.drawString("Psychologie ......................... " + psychologie, 750, 666);
			// ligne 14
			g.drawString("Astronomie ..................... " + astronomie, 210, 688);
			g.drawString("Histoire ................................ " + histoire, 430, 688);
			g.drawString("Sauter .................................. " + sauters, 750, 688);
			// ligne 15
			g.drawString("Baratin ............................ " + baratin, 210, 710);
			g.drawString("Lancer .................................. " + lancer, 430, 710);
			g.drawString("Se Cacher ............................ " + seCacher, 750, 710);
			// ligne 16
			g.drawString("Bibliothéque ................... " + bibliotheque, 210, 732);
			g.drawString("Piloter Avion ........................ " + piloter, 430, 732);
			g.drawString("Soigner Empoisonnement ... " + soignerEmpoisonnement, 750, 732);
			// ligne 17
			g.drawString("Botanique ....................... " + botanique, 210, 754);
			g.drawString("Langue Natale (EDU x 5%) .. " + langueNatale, 430, 754);
			g.drawString("Soigner Maladie ................... " + soignerMaladie, 750, 754);
			// ligne 18
			g.drawString("Camouflage ..................... " + camouflage, 210, 778);
			g.drawString("Histoire Naturel .................... " + histoireNaturel, 430, 778);
			g.drawString("Suivre une Piste ................... " + suivrePistes, 750, 778);
			// ligne 19
			g.drawString("Chanter ........................... " + chanter, 210, 800);
			g.drawString("Marchandage ........................ " + marchandage, 430, 800);
			g.drawString("Trouver Objet Caché ........... " + trouverObjetCache, 750, 800);
			// ligne 20
			g.drawString("Chimie ............................ " + chimie, 210, 822);
			g.drawString("Mécanique ............................ " + mecanique, 430, 822);
			g.drawString("Médecine ................................ " + medecine, 750, 822);
			// ligne 21
			g.drawString("Comptabilité .................. " + comptabilite, 210, 844);
			g.drawString("Monter à Cheval ................... " + monterCheval, 430, 844);
			g.drawString("Serrureries ........................... " + serrureries, 750, 844);
			// ligne 22
			g.drawString("Conduire Automobile .... " + conduireAuto, 210, 866);
			g.drawString("Mythe de Cthulhu ................. " + mytheChtullu, 430, 866);
			g.drawString("Art Martiaux ........................ " + artMartiaux, 750, 866);
			// ligne 23
			g.drawString("Conduire Engin Lourd ... " + conduireEnginLourd, 210, 888);
			g.drawString("Nager ..................................... " + nager, 430, 888);
			g.drawString("Coup de Pied ........................ " + coupPied, 750, 888);
			// ligne 24
			g.drawString("Crédit ............................. " + credit, 210, 910);
			g.drawString("Occultisme ............................. " + occultisme, 430, 910);
			g.drawString("Coup de Poing ...................... " + coupPoing, 750, 910);
			// ligne 25
			g.drawString("Dessiner une Carte ........ " + dessinerCarte, 210, 932);
			g.drawString("Pharmacologie ....................... " + pharmacologi, 430, 932);
			g.drawString("Coup de Téte ........................ " + coupcTete, 750, 932);
			// ligne 26
			g.drawString("Discrétion ....................... " + discretion, 210, 954);
			g.drawString("Photographie .......................... " + photographie, 430, 954);
			g.drawString("Lutte ..................................... " + lutte, 750, 954);
			// ligne 27
			g.drawString("Dissimulation .................. " + dissimulation, 210, 976);
			g.drawString("Pickpocket ............................. " + pickpocket, 430, 976);
			g.drawString("Arme de Poing ....................... " + armePoing, 750, 976);

			// ligne 28
			g.drawString("Droit................................ " + droit, 210, 998);
			g.drawString("Langues étr (" + langueEtr + ")....." + languesEtrangeres, 430, 998);
			g.drawString("Fusil de Chasse ...................... " + fusilChasse, 750, 998);

			// ligne 29
			g.drawString("Ecouter ........................... " + ecouter, 210, 1020);
			g.drawString("Navigation .............................. " + navigation, 430, 1020);
			g.drawString("Fusil ....................................... " + fusil, 750, 1020);

			// ligne 30
			g.drawString("Electricité ....................... " + electricitee, 210, 1042);
			g.drawString("Persuasion ............................. " + persuasion, 430, 1042);
			g.drawString("Mitraillette............................. " + mitrailette, 750, 1042);

			// ligne 31
			g.drawString("Eloquence ....................... " + eloquence, 210, 1064);
			g.drawString("Physique ................................ " + physique, 430, 1064);
			g.drawString("Mitrailleuse ............................ " + mitrailleuse, 750, 1064);

			// affichage des armes
			// ligne 32
			g.setFont(font);
			g.drawString("Armes ", 300, 1140);
			g.drawString("Sorts, comp�tences spéciales, notes", 670, 1140);

			// ligne 33
			g.setFont(font2);
			g.drawString("Arme                   %Att       Dom.      Port�e      Munit.        PDV", 120, 1170);
			g.drawString("" + armeCAC, 120, 1200);
			g.drawString("" + armeAFeu, 120, 1230);

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
				if (psm.get(f).equals(sm)) {
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
				if (psm.get(fPV).equals(pv)) {
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
				if (psm.get(fPM).equals(pm)) {
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
			g.drawString("Statut M. : " + famille, 740, 105);
			g.drawString("Revenu : " + revenu, 740, 130);
			g.drawString("Description : ", 740, 155);
			g.setFont(font2);
			ArrayList<Character> tabMot = new ArrayList<Character>();
			char[] tabMot2 = description.toCharArray();
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

	public void readPerso() {

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

	public void readComp() {

		anthropologie = Integer.parseInt(compGPerso.get(0).toString());
		archeologie = Integer.parseInt(compGPerso.get(1).toString());
		art = Integer.parseInt(compGPerso.get(2).toString());
		artMartiaux = Integer.parseInt(compGPerso.get(3).toString());
		astronomie = Integer.parseInt(compGPerso.get(4).toString());
		baratin = Integer.parseInt(compGPerso.get(5).toString());
		bibliotheque = Integer.parseInt(compGPerso.get(6).toString());
		camouflage = Integer.parseInt(compGPerso.get(7).toString());
		chimie = Integer.parseInt(compGPerso.get(8).toString());
		comptabilite = Integer.parseInt(compGPerso.get(9).toString());
		conduireAuto = Integer.parseInt(compGPerso.get(10).toString());
		conduireEnginLourd = Integer.parseInt(compGPerso.get(11).toString());
		credit = Integer.parseInt(compGPerso.get(12).toString());
		discretion = Integer.parseInt(compGPerso.get(13).toString());
		dissimulation = Integer.parseInt(compGPerso.get(14).toString());
		droit = Integer.parseInt(compGPerso.get(15).toString());
		ecouter = Integer.parseInt(compGPerso.get(16).toString());
		electricitee = Integer.parseInt(compGPerso.get(17).toString());
		esquiver = Integer.parseInt(compGPerso.get(18).toString());
		geologie = Integer.parseInt(compGPerso.get(19).toString());
		grimper = Integer.parseInt(compGPerso.get(20).toString());
		histoire = Integer.parseInt(compGPerso.get(21).toString());
		histoireNaturel = Integer.parseInt(compGPerso.get(22).toString());
		lancer = Integer.parseInt(compGPerso.get(23).toString());
		languesEtrangeres = Integer.parseInt(compGPerso.get(24).toString());
		langueNatale = Integer.parseInt(compGPerso.get(25).toString());
		marchandage = Integer.parseInt(compGPerso.get(26).toString());
		mecanique = Integer.parseInt(compGPerso.get(27).toString());
		medecine = Integer.parseInt(compGPerso.get(28).toString());
		monterCheval = Integer.parseInt(compGPerso.get(29).toString());
		mytheChtullu = Integer.parseInt(compGPerso.get(30).toString());
		nager = Integer.parseInt(compGPerso.get(31).toString());
		navigation = Integer.parseInt(compGPerso.get(32).toString());
		occultisme = Integer.parseInt(compGPerso.get(33).toString());
		persuasion = Integer.parseInt(compGPerso.get(34).toString());
		pharmacologi = Integer.parseInt(compGPerso.get(35).toString());
		photographie = Integer.parseInt(compGPerso.get(36).toString());
		physique = Integer.parseInt(compGPerso.get(37).toString());
		piloter = Integer.parseInt(compGPerso.get(38).toString());
		permiersSoins = Integer.parseInt(compGPerso.get(39).toString());
		psychanalyse = Integer.parseInt(compGPerso.get(40).toString());
		psychologie = Integer.parseInt(compGPerso.get(41).toString());
		sauters = Integer.parseInt(compGPerso.get(42).toString());
		seCacher = Integer.parseInt(compGPerso.get(43).toString());
		serrureries = Integer.parseInt(compGPerso.get(44).toString());
		suivrePistes = Integer.parseInt(compGPerso.get(45).toString());
		trouverObjetCache = Integer.parseInt(compGPerso.get(46).toString());
		armePoing = Integer.parseInt(compGPerso.get(47).toString());
		fusil = Integer.parseInt(compGPerso.get(48).toString());
		fusilChasse = Integer.parseInt(compGPerso.get(49).toString());
		mitrailette = Integer.parseInt(compGPerso.get(50).toString());
		mitrailleuse = Integer.parseInt(compGPerso.get(51).toString());
		coupPied = Integer.parseInt(compGPerso.get(52).toString());
		coupPoing = Integer.parseInt(compGPerso.get(53).toString());
		coupcTete = Integer.parseInt(compGPerso.get(54).toString());
		lutte = Integer.parseInt(compGPerso.get(55).toString());
		eloquence = Integer.parseInt(compGPerso.get(56).toString());
		dessinerCarte = Integer.parseInt(compGPerso.get(57).toString());
		chanter = Integer.parseInt(compGPerso.get(58).toString());
		botanique = Integer.parseInt(compGPerso.get(59).toString());
		pickpocket = Integer.parseInt(compGPerso.get(60).toString());
		soignerEmpoisonnement = Integer.parseInt(compGPerso.get(61).toString());
		soignerMaladie = Integer.parseInt(compGPerso.get(62).toString());

	}

	public void readDiver() {
		System.out.println(" langue : " + diversPerso.get(4).toString());

		residence = diversPerso.get(0).toString();
		famille = diversPerso.get(1).toString();
		revenu = diversPerso.get(2).toString();
		description = diversPerso.get(3).toString();
		langueEtr = diversPerso.get(4).toString();
		armeCAC = diversPerso.get(5).toString();
		armeAFeu = diversPerso.get(6).toString();
		psy = diversPerso.get(7).toString();

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
