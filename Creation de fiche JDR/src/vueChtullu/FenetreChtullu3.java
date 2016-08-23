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

import controleChtullu.CreationAutoCPerso;


public class FenetreChtullu3 extends JFrame implements DataChtullu{

	ArrayList<String> caractPerso = new ArrayList<String>();
	ArrayList competenceInit = new ArrayList();
	ArrayList compMetierPerso = new ArrayList();
	
	private ArrayList<Boolean> competenceBool = new ArrayList<Boolean>();
	private ArrayList compPPerso = new ArrayList();
	private ArrayList compGPerso = new ArrayList();
	int i;
	private int comp, comp2;
	private int compT = 0;
	
	private JPanel container = new JPanel();
	JPanel containerLabel = new JPanel();
	private BoutonComp[] competenceBT = new BoutonComp[competence.length];
	
	private Font font = new Font("Times New Roman", Font.BOLD, 15);
	
	
	public FenetreChtullu3 (ArrayList<String> caractPerso, ArrayList<Boolean> competenceBool, ArrayList compMetierPerso) {
		this.competenceBool = competenceBool;
		this.competenceInit = compMetierPerso;
		this.caractPerso = caractPerso;
		this.setTitle("Choix de vos compétences personnelle : ");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		comp = comp2 = (Integer.parseInt(caractPerso.get(8).toString()))*10;
		this.competenceBool = initBool(competenceBool);
		screen1();
		this.getContentPane().add(container);
		container.setBackground(Color.white);
		this.setVisible(true);
	}
	
	private void screen1(){
		
		JPanel containerCompetence = new JPanel();
		JPanel containerAction = new JPanel();
		
		JButton appercu = new JButton("Actualiser");
		JButton suivant = new JButton("Suivant");
		JButton auto = new JButton("Auto");
		
		JScrollPane scroll = new JScrollPane(containerCompetence);
		scroll.getVerticalScrollBar().setUnitIncrement(30);
		
		container.removeAll();
				
		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
		containerLabel.setBackground(Color.white);
		containerLabel.add(new JLabelP("Vous avez " + comp + " point de comp�tence personnelle � distribuer.", font));
		
		containerCompetence.setLayout(new GridLayout(65, 1));
		for(i = 0; i < competence.length;  i++){
			competenceBT[i] = new BoutonComp(competence[i], competenceBool.get(i), Integer.parseInt(competenceInit.get(i).toString())); //Integer.parseInt(caractPerso.get(8).toString())
			competenceBT[i].setBackground(Color.white);
			containerCompetence.add(competenceBT[i]);
		}
		container.add(scroll);
		containerAction.setLayout(new GridLayout(1, 2));
		containerAction.add(auto);
		containerAction.add(appercu);
		containerAction.add(suivant);
		appercu.addActionListener(new reload());
		auto.addActionListener(new auto());
		suivant.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// passer a l'�cran suivant
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
						compPPerso.add(competenceBT[m].getComp());
						}
				initCompGeneral();
				FenetreChtullu4 suiv = new FenetreChtullu4(caractPerso, compGPerso);
				dispose();
			}
		}
		});
		container.add(containerAction);
		container.add(containerLabel);
		repaint();
		revalidate();
		}
	
	private class auto implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//  cacul automatique des comptences personnelles
			CreationAutoCPerso autoP = new CreationAutoCPerso(caractPerso, competenceBool, competenceInit);
			compGPerso = autoP.getPPerso();
			FenetreChtullu4 suiv = new FenetreChtullu4(caractPerso, compGPerso);
			dispose();
		}
		}
	
	private class reload implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// recharge l'�cran avec les donn�es actualis�
			compT = 0;
			for(int k = 0; k < competence.length;  k++){
				comp2 = competenceBT[k].getInit();
				compT = competenceBT[k].getComp() - comp2 + compT;
			}
			System.out.println("total init : " + comp2);
			System.out.println("total comp : " + compT);
			containerLabel.removeAll();
			containerLabel.add(new JLabel("Vous avez " + (comp - compT) + " point de comp�tence metier � distribuer."));
			container.add(containerLabel);
			repaint();
			revalidate();
			}  
	  }
	
	private ArrayList<Boolean> initBool(ArrayList<Boolean> competenceBool) {
		// inverse la List competence bool
		int n;
		for(n = 0; n < competence.length; n++){
			if((competenceBool.get(n)).equals(true)) {
				competenceBool.remove(n);
				competenceBool.add(n, false);
				}
			else if ((competenceBool.get(n)).equals(false)){
				competenceBool.remove(n);
				competenceBool.add(n, true);
				}
		}
		return competenceBool;
	}
	
	private void initCompGeneral() {
		// initialise la List comp�tence g�n�rale
		final ArrayList<Boolean> competenceBoolIn = new ArrayList<Boolean>(competenceBool);
		final ArrayList<Boolean> competenceBoolOut = new ArrayList<Boolean>(initBool(competenceBool));
		int w;
		for(w = 0; w < competence.length; w++){
			if(competenceBoolOut.get(w).equals(true)){
				compGPerso.add(competenceInit.get(w));
			}
			else if(competenceBoolIn.get(w).equals(true)){
				compGPerso.add(compPPerso.get(w));
			}
		}
	}
}
