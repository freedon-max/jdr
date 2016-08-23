package vueChtullu;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controleChtullu.EdtitionChtullu;

public class FenetreChtullu4 extends JFrame implements DataChtullu{
	
	private ArrayList<String> caractPerso = new ArrayList<String>();
	private ArrayList compGPerso = new ArrayList();
	private ArrayList diversPerso = new ArrayList();
	
	private String lguEtr = "Aucun";
	private String armeCc = " ";
	private String amreF = " ";
	private String dsP = "Aucun";
	
	private String nomPerso, langueEtrOut, armeCaCOut, PsyOut, armeAFeuOut;
	
	private JPanel container = new JPanel(), 
				   containerLabel = new JPanel(),
				   containerDescrition = new JPanel(),
				   containerDescrition2 = new JPanel(),
				   containerDescrition3 = new JPanel(),
				   containerChoix = new JPanel(),
				   containerBT = new JPanel();
	
	private JButton suivant = new JButton("Editer");
	
	private JComboBox langueEtr = new JComboBox(langue),
						armeCaC = new JComboBox(armeCC),
						armeAFeu = new JComboBox(armeFeu),
						desordrePsy = new JComboBox(Psy);
	
	private JTextField 	residence = new JTextField(" "),
						famille = new JTextField(" "),
						revenu = new JTextField("$");
	
	private JTextArea description = new JTextArea(10, 15);
	
	private Font font = new Font("Times New Roman", Font.BOLD, 15);
	
	public FenetreChtullu4(ArrayList<String> caractPerso, ArrayList compGPerso) {
		this.caractPerso = caractPerso;
		this.compGPerso = compGPerso;
		this.nomPerso = caractPerso.get(0);
		this.setTitle("Création de personnage Chtullu : ");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		//initPerso();
		screen1();
		this.getContentPane().add(container);
		container.setBackground(Color.white);
		this.setVisible(true);
	}
	
	private void screen1(){
		
		JLabel labelNom = new JLabelP(nomPerso, font);
		
		JScrollPane scroll = new JScrollPane();
		JLabel etape = new JLabelP("Etape 4 : ", font),
				desc = new JLabelP(" Description : ", font);
		
		Font police = new Font("Times New Roman", Font.BOLD, 18);
		Font police2 = new Font("Times New Roman", Font.BOLD, 12);
		
		container.removeAll();
		
		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
		containerLabel.setLayout(new GridLayout(1, 2));
		containerLabel.setBackground(Color.white);
		etape.setFont(police);
		etape.setHorizontalAlignment(SwingConstants.LEFT);
		containerLabel.add(etape);
		desc.setFont(police2);
		containerLabel.add(desc);
		container.add(containerLabel);
		containerDescrition.setLayout(new BoxLayout(containerDescrition, BoxLayout.LINE_AXIS));
		containerDescrition2.setBackground(Color.white);
		containerDescrition3.setBackground(Color.white);
		containerDescrition2.setLayout(new GridLayout(6, 2));
		containerDescrition2.add(new JLabelP("Nom : ", font));
		containerDescrition2.add(labelNom);
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
		langueEtr.setSelectedIndex(0);
		containerChoix.add(new JLabelP("Choix Arme au CàC : ", font));
		armeCaC.setBackground(Color.white);
		containerChoix.add(armeCaC);
		armeCaC.setSelectedIndex(0);
		containerChoix.add(new JLabelP("Choix Arme à feu : ", font));
		armeAFeu.setBackground(Color.white);
		containerChoix.add(armeAFeu);
		armeAFeu.setSelectedIndex(0);
		containerChoix.add(new JLabelP("Choix Desordre Psychologique : ", font));
		desordrePsy.setBackground(Color.white);
		containerChoix.add(desordrePsy);
		desordrePsy.setSelectedIndex(0);
		container.add(containerChoix);
		langueEtr.addActionListener(new ItemLangueEtr());
		armeCaC.addActionListener(new ItemArmeCaC());
		armeAFeu.addActionListener(new ItemArmeAFeu());
		desordrePsy.addActionListener(new ItemPsy());
		containerBT.setBackground(Color.white);
		containerBT.add(suivant);
		container.add(containerBT);
		suivant.addActionListener(new next());
	}

	private void savePerso(){
		
		if(lguEtr.equals("Aucun"));
		else lguEtr = langueEtrOut;
		
		if(armeCc.equals(" "));
		else armeCc = armeCaCOut;
		
		if(amreF.equals(" "));
		else amreF = armeAFeuOut;
		
		if(dsP.equals("Aucun"));
		else dsP = PsyOut;
				
		diversPerso.clear();
		diversPerso.add(residence.getText());
		diversPerso.add(famille.getText());
		diversPerso.add(revenu.getText());
		diversPerso.add(description.getText());
		diversPerso.add(lguEtr);
		diversPerso.add(armeCc);
		diversPerso.add(amreF);
		diversPerso.add(dsP);
			}
	
		
	private class next implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// passer a l'edition de la fiche
			savePerso();
			EdtitionChtullu edit = new EdtitionChtullu(caractPerso, compGPerso, diversPerso);
			dispose();
		}    
	  }
	
	private class ItemLangueEtr implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			langueEtrOut = (String) langueEtr.getSelectedItem();
			}  
	  }
	
	private class ItemArmeCaC implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			armeCaCOut = (String) armeCaC.getSelectedItem();
			}  
	  }
	
	private class ItemArmeAFeu implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			armeAFeuOut = (String) armeAFeu.getSelectedItem();
			}    
	  }
	
	private class ItemPsy implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			PsyOut = (String) desordrePsy.getSelectedItem();
			}               
}
	

}
