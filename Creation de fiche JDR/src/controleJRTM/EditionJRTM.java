package controleJRTM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

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

import modelJRTM.DataJRTM;
import modelJRTM.PersoJRTM;

public class EditionJRTM extends JFrame implements DataJRTM{

	PersoJRTM persoTM = null;

	private JPanel container = new JPanel(), container2 = new JPanel();
	private JButton bouton = new JButton("Enregistrer");
	
	JLabel img = new JLabel();
	JLabel img2 = new JLabel();
	JLabel img3 = new JLabel();

	public EditionJRTM(PersoJRTM obj){
		this.persoTM = obj;
		

		Perso aff = new Perso();

		this.setTitle("Edition perso");
		this.setSize(600, 850);
		img.setSize(1100, 1500);
		img2.setSize(1100, 1500);
		aff.setSize(1100, 1500);
		container2.setSize(1100, 1500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		Icon icon = new ImageIcon(new ImageIcon("img/edit/JRTMEdit.png").getImage()
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

			Font font2 = new Font("Times New Roman", Font.BOLD, 16);
			Font font4 = new Font("Times New Roman", Font.BOLD, 18);

			g.setFont(font4);
			g.setColor(Color.black);

			// info perso :
	
			int Xgauche = 50;
			int XDroite = 700;
			int y = 60;
			int espaceY = 25;
			
			g.drawString("Nom : " + persoTM.getNom(), Xgauche, y);
			g.drawString("Race : " + persoTM.getRace(), Xgauche, y + espaceY);
			
			g.drawString("Taille : " + persoTM.getAge(), Xgauche, y + (2*espaceY));
			g.drawString("Age : " + persoTM.getAge(), Xgauche + 250, y + (2*espaceY));
				
			g.drawString("Poids : " + persoTM.getPoids(), Xgauche, y + (3*espaceY));
			g.drawString("Sexe : "  + persoTM.getSexe(), Xgauche + 250, y + (3*espaceY));			

			g.drawString("Cheveux : " + persoTM.getCheveux(), Xgauche, y + (4*espaceY));		
			g.drawString("Yeux : " + persoTM.getYeux(), Xgauche + 250, y + (4*espaceY));
			
			g.drawString("Attitude : " + persoTM.getAttitude(), Xgauche, y + (5*espaceY));
			g.drawString("Alignement : " + persoTM.getAlignement(), Xgauche, y + (6*espaceY));
			g.drawString("Profession : " + persoTM.getProfession(), Xgauche, y + (7*espaceY));
			
			g.drawString("Niveau : " + persoTM.getNiveau(), Xgauche, y + (8*espaceY));
			g.drawString("Royaume : " + persoTM.getRoyaume(), XDroite, y + (4*espaceY));
			
			g.drawString("Point de pouvoir : " + persoTM.getPointPouvoir(), XDroite, y + (5*espaceY));
			g.drawString("Point d'Exp : " + persoTM.getPointExp(), XDroite, y + (6*espaceY));		
			g.drawString("Pénalité d'encombrement : " , XDroite, y + (7*espaceY));
			
			
			g.setFont(font2);
			int Ycar = 312;
			int YcarEsp = 23;
			
		// caractéritique
			g.drawString("Caractéristique : " , Xgauche + 20, Ycar);
			g.drawString("VAL     NORM      RACE      TOTAL " , Xgauche+150, Ycar + YcarEsp);
			
			g.drawString("Force (FO) : " , Xgauche, Ycar + (2*YcarEsp));
			g.drawString("" + persoTM.getForce() , Xgauche+157, Ycar + (2*YcarEsp));
			g.drawString("" + persoTM.getBnforce() , Xgauche+220, Ycar + (2*YcarEsp));
			g.drawString("" + persoTM.getRforce() , Xgauche+290, Ycar + (2*YcarEsp));
			g.drawString("" + persoTM.getTforce() , Xgauche+360, Ycar + (2*YcarEsp));
			
			g.drawString("Agilité (AG) : " , Xgauche , Ycar + (3*YcarEsp));
			g.drawString("" + persoTM.getAgilite() , Xgauche+157, Ycar + (3*YcarEsp));
			g.drawString("" + persoTM.getBnagilite() , Xgauche+220, Ycar + (3*YcarEsp));
			g.drawString("" + persoTM.getRagilite() , Xgauche+290, Ycar + (3*YcarEsp));
			g.drawString("" + persoTM.getTagilite() , Xgauche+360, Ycar + (3*YcarEsp));
			
			g.drawString("Constitution (CO) : " , Xgauche , Ycar + (4*YcarEsp));
			g.drawString("" + persoTM.getConstitution() , Xgauche+157, Ycar + (4*YcarEsp));
			g.drawString("" + persoTM.getBnconstitution() , Xgauche+220, Ycar + (4*YcarEsp));
			g.drawString("" + persoTM.getRconstitution() , Xgauche+290, Ycar + (4*YcarEsp));
			g.drawString("" + persoTM.getTconstitution() , Xgauche+360, Ycar + (4*YcarEsp));
			
			g.drawString("Intelligence (IG) : " , Xgauche , Ycar + (5*YcarEsp));
			g.drawString("" + persoTM.getIntelligence() , Xgauche+157, Ycar + (5*YcarEsp));
			g.drawString("" + persoTM.getBnintelligence() , Xgauche+220, Ycar + (5*YcarEsp));
			g.drawString("" + persoTM.getRintelligence() , Xgauche+290, Ycar + (5*YcarEsp));
			g.drawString("" + persoTM.getTintelligence() , Xgauche+360, Ycar + (5*YcarEsp));
			
			g.drawString("Intuition (IN) : " , Xgauche , Ycar + (6*YcarEsp));
			g.drawString("" + persoTM.getIntuition() , Xgauche+157, Ycar + (6*YcarEsp));
			g.drawString("" + persoTM.getBnintuition() , Xgauche+220, Ycar + (6*YcarEsp));
			g.drawString("" + persoTM.getRintuition() , Xgauche+290, Ycar + (6*YcarEsp));
			g.drawString("" + persoTM.getTintuition() , Xgauche+360, Ycar + (6*YcarEsp));
			
			g.drawString("Présence (PR) : " , Xgauche , Ycar + (7*YcarEsp));
			g.drawString("" + persoTM.getPresence() , Xgauche+157, Ycar + (7*YcarEsp));
			g.drawString("" + persoTM.getBnpresence() , Xgauche+220, Ycar + (7*YcarEsp));
			g.drawString("" + persoTM.getRpresence() , Xgauche+290, Ycar + (7*YcarEsp));
			g.drawString("" + persoTM.getTpresence() , Xgauche+360, Ycar + (7*YcarEsp));
			
			g.drawString("Apparence (AP) : " , Xgauche , Ycar + (8*YcarEsp));
			g.drawString("" + persoTM.getApparence() , Xgauche+157, Ycar + (8*YcarEsp));
			g.drawString("" + persoTM.getBnapparence() , Xgauche+220, Ycar + (8*YcarEsp));
			g.drawString("" + persoTM.getTapparence() , Xgauche+360, Ycar + (8*YcarEsp));
		
		// langages
			
			int Xlangage = 500;
			int yl = 2;
			g.drawString("Langages" , Xlangage +20, Ycar);
			g.drawString("Degré" , Xlangage +150, Ycar);
			
			for(int  i = 0; i < choixLangues.length; i++){
				if (persoTM.get2InitchkL(i) == true){
					g.drawString("" + choixLangues[i], Xlangage +20, Ycar + (YcarEsp*yl));
					g.drawString("" + persoTM.get2DegLangue(i), Xlangage +160, Ycar + (YcarEsp*yl));
					yl++;
				}
			}
			
			g.drawString("Armes et protections" , 820, Ycar);
		//compétence	
			int YinfoComp = 530;
			
			int XD5 = 180;
			int XD2 = 290;
			int XD = 400;
			int XCarac = 490;
			int XProf = 565;
			int XOb = 660;
			int XS1 = 730;
			int XS2 = 820;
			int XT = 930;
			
			g.drawString("Degrés 5%", XD5, YinfoComp);
			g.drawString("Degrés 2%", XD2, YinfoComp);
			g.drawString("Degré ", XD, YinfoComp);
			g.drawString("Carac.", XCarac, YinfoComp);
			g.drawString("Profession", XProf, YinfoComp);
			g.drawString("Objet", XOb, YinfoComp);
			g.drawString("Special", XS1, YinfoComp);
			g.drawString("Special", XS2, YinfoComp);
			g.drawString("TOTAL", XT, YinfoComp);
			
			
			
			int yIComp = 20;
			int YComp = 600;
			int k = 0;
			for (int j = 0; j < choixCompetence.length-1; j++) {
				if(j <= 4){
					YComp = 590;
					k = (-(15*j));
					g.drawString("" + k, XS2+30, YComp + yIComp*j);
					
				}
				else if(j >= 5 && j<10) {
					YComp = 630;
					
				}
				else if(j >= 11 & j<13) {
					YComp = 670;
					
				}
				else if(j >= 14 && j<18) {
					YComp = 700;
					
				}
				else if(j >= 19 && j<21) {
					YComp = 720;
					
				}
				else if(j >= 22 && j<=23) {
					YComp = 890;
					
				}
				
				String[] caract = {"AG : ", "AG : ", "AG : ", "FO : ", "FO : ", "FO : ","FO : ","FO : ", "AG : ", "AG : ", "FO : ", "AG : ", "IT : ", "AG : ", "IG : ", "XX", "PR : ", "IG : ", "IT : ", "IG : ", "IT : ", "AG : ", "IT : ", "CO : ", ""};			
				g.drawString(choixCompetence[j], Xgauche, YComp + yIComp*j);
				int D5 = persoTM.get2Degres5(j);
				int D2 = persoTM.get2Degres2(j);
				g.drawString("" + D5, XD5+30, YComp + yIComp*j);
				g.drawString("" + D2, XD2+30, YComp + yIComp*j);
				int D;
				if (persoTM.get2Degres5(j) == 0) {D = -25;}
				else D = D5;
				
				g.drawString("" + D + "%", XD+20, YComp + yIComp*j);
				g.drawString(caract[j] + persoTM.get2BonusCaract(j), XCarac+10, YComp + yIComp*j);
				g.drawString("" + persoTM.get2BonusAff(j), XProf+30, YComp + yIComp*j);
				
				if (j <= 4){
				g.drawString("" + ((D + D2*2 + persoTM.get2BonusComp(j)) + persoTM.get2BonusAff(j) + persoTM.get2BonusCaract(j)+k) + "% + ", XT+30, YComp + yIComp*j);
				}
				else {
					g.drawString("" + ((D + D2*2 + persoTM.get2BonusComp(j)) + persoTM.get2BonusAff(j) + persoTM.get2BonusCaract(j)) + "% + ", XT+30, YComp + yIComp*j);
					}
			}
			
		// resistance 	
			
			int XR = 170;
			int YR = 1175;
			g.drawString("Sorts de base", XR, YR);
			g.drawString("XXXX", XD, YR); 
			g.drawString("XXXX", XCarac+10, YR); 
			g.drawString("" + persoTM.get2Degres5(24)*5, XProf+30, YR); 
			g.drawString("" + persoTM.get2Degres5(24)*5 + "%", XT+30, YR); 
			
			
			g.drawString("Command. & infl.", XR, YR +20);
			g.drawString("XXXX", XD, YR+20); 
			g.drawString("PR : " + persoTM.getTpresence(), XCarac+10, YR + 20); 
			g.drawString("XXXX", XProf, YR + 20);
			g.drawString("" + persoTM.getTpresence() + "%", XT+30, YR + 20); 
			
			
			g.drawString("Bonus défensif", XR, YR + 40);
			g.drawString("XXXX", XD, YR+40); 
			g.drawString("AG : " + persoTM.getTagilite(), XCarac+10, YR + 40);
			g.drawString("XXXX", XProf, YR + 40);
			g.drawString("" + persoTM.getTagilite() + "%", XT+30, YR + 40); 
			
			g.drawString("JR Essence", XR, YR + 60);
			g.drawString("XXXX", XD, YR+60); 
			g.drawString("IG : " + persoTM.getResistanceEss(), XCarac+10, YR + 60); 
			g.drawString("XXXX", XProf, YR + 60);
			g.drawString("" + persoTM.getResistanceEss() + "%", XT+30, YR + 60); 
			
			g.drawString("JR Théurgie", XR, YR + 80);
			g.drawString("XXXX", XD, YR+80); 
			g.drawString("IN : " + persoTM.getResistanceThe(), XCarac+10, YR + 80); 
			g.drawString("XXXX", XProf, YR + 80);
			g.drawString("" + persoTM.getResistanceThe() + "%", XT+30, YR + 80);
			
			g.drawString("JR Poison", XR, YR + 100);
			g.drawString("XXXX", XD, YR+100); 
			g.drawString("CO : " + persoTM.getResistancePoi(), XCarac+10, YR + 100); 
			g.drawString("XXXX", XProf, YR + 100);
			g.drawString("" + persoTM.getResistancePoi() + "%", XT+30, YR + 100);
			
			g.drawString("JR Maladie", XR, YR + 120);
			g.drawString("XXXX", XD, YR+120); 
			g.drawString("CO : " + persoTM.getResistanceMal(), XCarac+10, YR + 120); 
			g.drawString("XXXX", XProf, YR + 120);
			g.drawString("" + persoTM.getResistanceMal() + "%", XT+30, YR + 120);
		}
	}
	
	
	
	public String SelecChemin() {
		// permet de choisir la destination et le nom de la fiche pour
		// l'enregistrement
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

}
