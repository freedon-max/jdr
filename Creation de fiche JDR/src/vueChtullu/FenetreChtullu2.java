package vueChtullu;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controleChtullu.CreationAutoCMetier;
import controleChtullu.GestionMetierCht;


public class FenetreChtullu2 extends JFrame implements DataChtullu{
	
	
	
	ArrayList<String> caractPerso = new ArrayList<String>();
	ArrayList compMetierPerso = new ArrayList();
	
	private int[] competenceInit = {0, 0, 5, 0 ,0 ,5 ,25, 0 ,0 ,10, 20, 0, 15, 10, 15, 5, 25, 10, 0, 0, 40, 20, 10, 25, 0, 0, 5, 20, 5, 5, 0, 25, 10, 5, 15, 0, 10, 0, 0, 30, 0, 5, 25, 10, 0, 10, 25, 20, 25, 30, 15, 15, 25, 50, 10, 25, 0, 0, 0, 0, 0, 0, 0};
	private ArrayList<Boolean> competenceBool = new ArrayList<Boolean>();
	
	private int i;
	private int comp, comp2;
	private int compT = 0;
	
	private JPanel container = new JPanel();
	private JPanel containerLabel = new JPanel();
	private BoutonComp[] competenceBT = new BoutonComp[competence.length];
	
	 
	
	private Font font = new Font("Times New Roman", Font.BOLD, 15);
	
	public FenetreChtullu2(ArrayList<String> caractPerso) {
		this.caractPerso = caractPerso;
		GestionMetierCht gestionM = new GestionMetierCht();
		this.setTitle("Choix de vos compétences métier : " + caractPerso.get(4).toString());
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.competenceInit = initSpec();
		comp = comp2 = (Integer.parseInt(caractPerso.get(16).toString()))*20;
		competenceBool = gestionM.GestionMCht(caractPerso.get(4).toString());
		screen1();
		this.getContentPane().add(container);
		container.setBackground(Color.white);
		this.setVisible(true);
	}
	
	private void screen1(){
		// affichage des competence metier
		
		JPanel containerCompetence = new JPanel();
		JPanel containerAction = new JPanel();
		
		JButton appercu = new JButton("Actualiser");
		JButton suivant = new JButton("Suivant");
		JButton auto = new JButton("Auto");
		
		JScrollPane scroll = new JScrollPane(containerCompetence);
		scroll.getVerticalScrollBar().setUnitIncrement(20);
		
		
		container.removeAll();
				
		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
		container.setBackground(Color.white);
		containerLabel.setBackground(Color.white);
		containerCompetence.setBackground(Color.white);
		scroll.setBackground(Color.white);
		
		
		containerLabel.add(new JLabelP("Vous avez " + comp + " point de comp�tence metier � distribuer.", font));
		containerCompetence.setLayout(new GridLayout(65, 1));
		
		for(i = 0; i < competence.length;  i++){
			competenceBT[i] = new BoutonComp(competence[i], competenceBool.get(i), competenceInit[i]);
			competenceBT[i].setBackground(Color.white);
			containerCompetence.add(competenceBT[i]);
		}
		
		container.add(scroll);
		
		containerAction.setLayout(new GridLayout(1, 2));
		containerAction.setBackground(Color.white);
		containerAction.add(auto);
		containerAction.add(appercu);
		containerAction.add(suivant);
		appercu.addActionListener(new reload());
		suivant.addActionListener(new next());
		auto.addActionListener(new auto());
		container.add(containerAction);
		container.add(containerLabel);
		
		repaint();
		revalidate();
		
	}
	
	private class auto implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// comptence metier calcul� automatiquement		
			CreationAutoCMetier autoComp =	new CreationAutoCMetier(caractPerso, competenceBool);
			compMetierPerso = autoComp.getMetierPerso();
			FenetreChtullu3 suiv = new FenetreChtullu3(caractPerso, competenceBool, compMetierPerso);
			dispose();
		}
		}
	
	private class reload implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// recharge l'ecran avec les donn�es � jour
			compT = 0;
			for(int k = 0; k < competence.length;  k++){
				comp2 = competenceBT[k].getInit();
				compT = competenceBT[k].getComp() - comp2 + compT;
			}
			containerLabel.removeAll();
			containerLabel.add(new JLabel("Vous avez " + (comp - compT) + " point de comp�tence metier � distribuer."));
			container.add(containerLabel);
			repaint();
			revalidate();
			}   
	  }
	
	private class next implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// pour passer a l'ecran suivant, message d'avertissement si il reste des points ou si trop d'utilis�s
			JOptionPane jop1, jop2;
			if((comp - compT) > 0) {
				jop1 = new JOptionPane();
					jop1.showMessageDialog(null, "Il vous reste " + (comp - compT) + " point de compt�tence � distrubuer.", "Attention", JOptionPane.INFORMATION_MESSAGE);
				}
			else if ((comp - compT) < 0){
				jop2 = new JOptionPane();
				jop2.showMessageDialog(null, "Vous utilisez " + (comp - compT) + " point de comp�tence en trop.", "Attention", JOptionPane.INFORMATION_MESSAGE);
				}
			else {
				for(int m = 0; m < competence.length;  m++){
					compMetierPerso.add(competenceBT[m].getComp());
					}
			FenetreChtullu3 suiv = new FenetreChtullu3(caractPerso, competenceBool, compMetierPerso);
			dispose();
		}
	}
	}
	
	private int[] initSpec() {
		// initialise les valeurs initiale des comp�tence esquiver (dex*2) et langue natale(edu*5)
		int temp1 = (Integer.parseInt(caractPerso.get(7).toString()))*2;
		int temp2 = (Integer.parseInt(caractPerso.get(16).toString()))*5;
		int[] competenceInit2 = {0, 0, 5, 0 ,0 ,5 ,25, 0 ,0 ,10, 20, 0, 15, 10, 15, 5, 25, 10, temp1, 0, 40, 20, 10, 25, 0, temp2, 5, 20, 5, 5, 0, 25, 10, 5, 15, 0, 10, 0, 0, 30, 0, 5, 25, 10, 0, 10, 25, 20, 25, 30, 15, 15, 25, 50, 10, 25, 0, 0, 0, 0, 0, 0, 0};
		return competenceInit2;		
	}
}
/* 
for, con, pou, dex app = 3d6 = 18max
tai, int = 2d6 + 8 = 20max
edu = 3d6 + 3 = 21max
san = pou * 5 = 25max

id�e = int * 5
chance = pou * 5
connaissance = edu*5

bonus degat = for + tai ==> voir tableau pages 19 du livre de regles

pv = con + tai / 2
pm = pou
sante mentale = san

comp metier = edu * 20
comp personnel = int * 10

liste metier : String[] choixMetier = {Aucun, Antiquaire, Artiste, Artiste de cabaret, Athlete, Avocat, Criminel, Detective prive, Dilettante, Ecrivain, Fantassin, Fermier, Guerrier tribal, Ingenieur, Inspecteur de police, Journaliste, Medecin, Missionnaire, Musicien, Officier, Parapsychologue, Pecheur, Policier, Pretre, Proffesseur, Revolutionnaire, Vagabond};
voir page 24 du livre de regles

nombre competence 56 et 56
*/

// https://openclassrooms.com/courses/apprenez-a-programmer-en-java/mieux-structurer-son-code-le-pattern-mvc
