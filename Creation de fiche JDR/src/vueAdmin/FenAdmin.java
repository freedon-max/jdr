package vueAdmin;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controleAdmin.ControleFenAdmin;
import vueChtullu.DataChtullu;

public class FenAdmin extends JFrame implements DataChtullu{
	
	private JPanel containerCht = new JPanel();
	ControleFenAdmin controle = null;
	
	String[] nombreCompetence = {" Aucune compétence personnelle", " 1 compétence personnelle", " 2 compétences personnelles", " 3 compétences personnelles", " 4 compétences personnelles"};
	public JTextField metier = new JTextField();
	public final JCheckBox[] compMetier = new JCheckBox[competence.length];
	public JComboBox comboComp = new JComboBox(nombreCompetence);
	boolean[] comp = new boolean[competence.length];
	
	String[] type = {"Force", "Dextérité", "QI", "Santé"};
	String[] niveaux = {"1 niveau", "2 niveaux", "3 niveaux", "4 niveaux", "5 niveaux", "6 niveaux"};
	public final JComboBox typeComp = new JComboBox(type);
	public JTextField text = new JTextField("");
	public final JComboBox nbreNiveaux = new JComboBox(niveaux);
	public JTextField nomMagie = new JTextField("");
	public JTextField descriptionMagie = new JTextField("");
	
	public FenAdmin(ControleFenAdmin obj) {
		getContentPane().setBackground(Color.WHITE);
		this.controle = obj;
		
		JPanel container = new JPanel();
		container.setBackground(Color.WHITE);
	
		JPanel containerMetier = new JPanel();
		containerMetier.setBackground(Color.WHITE);
		JPanel containerCMetier = new JPanel();
		containerCMetier.setBackground(Color.WHITE);
		JPanel containerT = new JPanel();
		containerT.setBackground(Color.WHITE);
		JPanel containerN = new JPanel();
		containerN.setBackground(Color.WHITE);
		JPanel containerBouton = new JPanel();
		containerBouton.setBackground(Color.WHITE);
		JPanel containerInfo = new JPanel();
		containerInfo.setBackground(Color.WHITE);
		JPanel container2 = new JPanel();
		container2.setBackground(Color.WHITE);
		JPanel container3 = new JPanel();
		container3.setBackground(Color.WHITE);
		JPanel container4 = new JPanel();
		container4.setBackground(Color.WHITE);
		
		JButton bouton = new JButton("Save Métier");
		JButton bouton2 = new JButton("Save Compétence");
		bouton2.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton bouton3 = new JButton("Save Magie");
		bouton3.setAlignmentX(Component.CENTER_ALIGNMENT);
		comboComp.setBackground(Color.WHITE);
		
		comboComp.setPreferredSize(new Dimension(50, 30));
		
		JScrollPane scroll = new JScrollPane(containerCMetier);
		scroll.getVerticalScrollBar().setUnitIncrement(20);
		scroll.setPreferredSize(new Dimension(300, 280));
		
	
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Interface Admin");
		this.setSize(500, 400);

		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		getContentPane().add(tabbedPane);
		tabbedPane.addTab("Edit Chtullu", null, containerCht, null);
		containerCht.setLayout(new GridLayout(0, 2, 0, 0));
		containerCht.add(container);
		
		containerMetier.setLayout(new BoxLayout(containerMetier, BoxLayout.X_AXIS));
		JLabel label_5 = new JLabel("Metier : ");
		label_5.setBackground(Color.WHITE);
		containerMetier.add(label_5);
		containerMetier.add(metier);
		
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.add(containerMetier);
	
		containerCMetier.setLayout(new BoxLayout(containerCMetier, BoxLayout.Y_AXIS));
		for (int i = 0; i < competence.length; i++) {
			compMetier[i] = new JCheckBox(competence[i], false);
			
			containerCMetier.add(compMetier[i]);
			compMetier[i].setBackground(Color.WHITE);
			
		}
		container.add(scroll);
		containerBouton.add(bouton);
		container.add(containerBouton);
		
		
		containerCht.add(containerInfo);
		containerInfo.setLayout(new BoxLayout(containerInfo, BoxLayout.Y_AXIS));
		
		containerInfo.add(new JLabel("  "));
		JLabel label_1 = new JLabel(" Créer un nouveau métier : ");
		label_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		containerInfo.add(label_1);
		containerInfo.add(new JLabel(" "));
		JLabel label = new JLabel(" Pour cela, il vous suffit de saisir le nom ");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		containerInfo.add(label);
		JLabel label_2 = new JLabel(" de votre nouveau métier et de cocher les ");
		label_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		containerInfo.add(label_2);
		JLabel label_3 = new JLabel(" différentes compétences qui lui seront ");
		label_3.setAlignmentX(Component.CENTER_ALIGNMENT);
		containerInfo.add(label_3);
		JLabel label_4 = new JLabel(" associées.");
		label_4.setAlignmentX(Component.CENTER_ALIGNMENT);
		containerInfo.add(label_4);
		
		containerInfo.add(new JLabel("  "));
		
		JLabel label_6 = new JLabel(" Nombre de compétences personnelles");
		label_6.setAlignmentX(Component.CENTER_ALIGNMENT);
		containerInfo.add(label_6);
		JLabel label_7 = new JLabel(" pour ce métier : ");
		label_7.setAlignmentX(Component.CENTER_ALIGNMENT);
		containerInfo.add(label_7);
		containerInfo.add(new JLabel("  "));
		
		containerInfo.add(comboComp);
		containerInfo.add(new JLabel("  "));
		containerInfo.add(new JLabel("  "));
		containerInfo.add(new JLabel(" "));
		
		
		
		
		containerInfo.add(new JLabel(" "));
		
		bouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				recup();
				controle.SaveCHT();
			}
		});
		
//		
		JPanel containerDM = new JPanel();
		containerDM.setBackground(Color.WHITE);
		tabbedPane.addTab("Edit Disque Monde", null, containerDM, null);
		containerDM.setLayout(new BoxLayout(containerDM, BoxLayout.Y_AXIS));
		JLabel label_8 = new JLabel("Création compétences : ");
		label_8.setAlignmentX(Component.CENTER_ALIGNMENT);
		containerDM.add(label_8);
		containerDM.add(new JLabel(" "));
		
		container2.setLayout(new BoxLayout(container2, BoxLayout.X_AXIS));
		container2.add(new JLabel("Nom de la compétence :  "));
		container2.add(text);
		containerDM.add(container2);
		containerT.setLayout(new BoxLayout(containerT, BoxLayout.X_AXIS));
		containerT.add(new JLabel("Type de la compétence :  "));
		containerT.add(typeComp);
		typeComp.setBackground(Color.WHITE);
		containerDM.add(containerT);
		containerN.setLayout(new BoxLayout(containerN, BoxLayout.X_AXIS));
		containerN.add(new JLabel("Niveau max de la compétences :  "));
		containerN.add(nbreNiveaux);
		nbreNiveaux.setBackground(Color.WHITE);
		containerDM.add(containerN);
		containerDM.add(new JLabel(" "));
		containerDM.add(bouton2);
		containerDM.add(new JLabel(" "));
		containerDM.add(new JLabel(" "));
		
		JLabel label_9 = new JLabel("Création Sort :  ");
		label_9.setAlignmentX(Component.CENTER_ALIGNMENT);
		containerDM.add(label_9);
		containerDM.add(new JLabel(" "));
		container3.setLayout(new BoxLayout(container3, BoxLayout.X_AXIS));
		container3.add(new JLabel("Nom du sort :  "));
		container3.add(nomMagie);
		containerDM.add(container3);		
		container4.setLayout(new BoxLayout(container4, BoxLayout.X_AXIS));
		container4.add(new JLabel("Description du sort : "));
		container4.add(descriptionMagie);
		containerDM.add(container4);
		containerDM.add(new JLabel(" "));
		containerDM.add(bouton3);
		
		bouton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				controle.SaveDM();
			}
		});
		bouton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				controle.SaveMagieDM();
			}
		});
		
				
		//JPanel containerJRTM = new JPanel();
		//tabbedPane.addTab("Edit JRTM", null, containerJRTM, null);
	
		this.setVisible(true);
	}
	
	public void recup(){
				
		for (int i = 0; i < competence.length; i++) {
			comp[i] = compMetier[i].isSelected();			
		}
		
				
	}
	


	public boolean[] getComp() {
		return comp;
	}
	
	private static String VerifString(String str) {
		String strOut = str.replace("'", "£");
		return strOut;
	}
	

}
