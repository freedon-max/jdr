import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


import vueChtullu.BontonAccueil;
import vueChtullu.Chtullu;
import vueChtullu.FenetreChtullu;
import vueDM.FenetreDM;

public class Accueil extends JFrame{
		
	private JPanel container = new JPanel(),
			containerTxt = new JPanel(),
			containerB = new JPanel(),
			containerB2 = new JPanel();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fichier = new JMenu("Fichier"),
			aPropos = new JMenu("A Propos..."),
			creer = new JMenu("Créer");
	
	
	private JMenuItem quitter = new JMenuItem("QUITTER"),
			aProposItem = new JMenuItem("?"),
			chtullu = new JMenuItem("Chtullu"),
			disque = new JMenuItem("Disque monde"),
			donjon = new JMenuItem("Donjon & Dragon"),
			rune = new JMenuItem("Runequest"),
			milieu = new JMenuItem("JRD de la terre du milieu");
	
	
	private BontonAccueil   cht = new BontonAccueil("img/img1.jpg"),
							dm = new BontonAccueil("img/img2.jpg"),
							dd = new BontonAccueil("img/img3.jpg"),
							ru = new BontonAccueil("img/img4.jpg"),
							tdm = new BontonAccueil("img/img5.jpg");
			
			
	
	public Accueil() {
		this.setTitle("Créateur de personnage de Jeu de Rôle.");
		this.setSize(400, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.initMenu();
		this.getContentPane().add(container);
		container.setBackground(Color.white);
		container.add(cht, BorderLayout.CENTER);
		container.setLayout(new BorderLayout());
		//container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
		container.add(new JLabel("Veuillez choisir votre Jeu : "), BorderLayout.NORTH);
		containerB.setLayout(new GridLayout(5, 1));
		containerB.add(cht);
		containerB.add(dm);
		containerB.add(dd);
		containerB.add(ru);
		containerB.add(tdm);
		container.add(containerB, BorderLayout.CENTER);
		
		cht.addActionListener(new ecranChtullu());
		dm.addActionListener(new ecranDM());
		
		this.setVisible(true);
		//convert();
	}
	// intialisation des menus
	private void initMenu() {
		creer.add(chtullu);
		creer.add(disque);
		creer.add(donjon);
		creer.add(rune);
		creer.add(milieu);
		fichier.add(creer);
		fichier.setMnemonic('f');
		fichier.addSeparator();
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));
		fichier.add(quitter);	
		quitter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			});
		chtullu.addActionListener(new ecranChtullu());
		disque.addActionListener(new ecranDM());
		//recommencer.addActionListener(ecranActif);
		menuBar.add(fichier);
		menuBar.add(aPropos);
		aProposItem.addActionListener(new propos());
		aPropos.add(aProposItem);
		
		this.setJMenuBar(menuBar);
	}
	
	class ecranChtullu implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			FenetreChtullu fen = new FenetreChtullu();
			
	}
	}	
	
		class ecranDM implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				FenetreDM fenDm = new FenetreDM();
				
		}
	}
		
		class propos implements ActionListener{
			public void actionPerformed(ActionEvent e) {
			System.out.println("test");
			APropos fenAPropos = new APropos();
				
		}
	}
	
	
	

}