import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import vueBDD.VueBDDGen;
import vueChtullu.BontonAccueil;

public class Accueil extends JFrame {

	private JPanel container = new JPanel(), containerTxt = new JPanel(), containerB = new JPanel(),
			containerB2 = new JPanel();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fichier = new JMenu("Fichier"), aPropos = new JMenu("A Propos..."), creer = new JMenu("Créer");

	private JMenuItem quitter = new JMenuItem("QUITTER"), aProposItem = new JMenuItem("?"),
			chtullu = new JMenuItem("Chtullu"), disque = new JMenuItem("Disque monde"),
			donjon = new JMenuItem("Donjon & Dragon"), rune = new JMenuItem("Runequest"),
			milieu = new JMenuItem("JRTM"), bdd = new JMenuItem("BDD");

	private BontonAccueil cht = new BontonAccueil("img/img1.jpg"), dm = new BontonAccueil("img/img2.jpg"),
			dd = new BontonAccueil("img/img3.jpg"), ru = new BontonAccueil("img/img4.jpg"),
			tdm = new BontonAccueil("img/img5.jpg");

	public Accueil() {
		this.setTitle("Créateur de personnage de Jeu de Rôle.");
		this.setSize(400, 450);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.initMenu();
		this.getContentPane().add(container);
		container.setBackground(Color.white);
		container.add(cht, BorderLayout.CENTER);
		container.setLayout(new BorderLayout());
		// container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
		container.add(new JLabel("Veuillez choisir votre Jeu : "), BorderLayout.NORTH);
		containerB.setLayout(new GridLayout(3, 1));
		containerB.add(cht);
		containerB.add(dm);
		//containerB.add(dd);
		//containerB.add(ru);
		containerB.add(tdm);
		container.add(containerB, BorderLayout.CENTER);

		cht.addActionListener(new ecranChtullu());
		dm.addActionListener(new ecranDM());
		tdm.addActionListener(new ecranJRTM());

		this.setVisible(true);
		// convert();
	}

	// intialisation des menus
	private void initMenu() {
		creer.add(chtullu);
		creer.add(disque);
		//creer.add(donjon);
		//creer.add(rune);
		creer.add(milieu);
		fichier.add(creer);
		fichier.add(bdd);
		fichier.setMnemonic('f');
		fichier.addSeparator();
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));
		fichier.add(quitter);
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		chtullu.addActionListener(new ecranChtullu());
		disque.addActionListener(new ecranDM());
		milieu.addActionListener(new ecranJRTM());
		// recommencer.addActionListener(ecranActif);
		bdd.addActionListener(new ecranBDD());
		menuBar.add(fichier);
		menuBar.add(aPropos);
		aProposItem.addActionListener(new propos());
		aPropos.add(aProposItem);

		this.setJMenuBar(menuBar);
	}

	class ecranChtullu implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			LanceurCht  fenCht = new LanceurCht();

		}
	}

	class ecranDM implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			LanceurDM fenDm = new LanceurDM();

		}
	}
	
	class ecranJRTM implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			LanceurJRTM fenTM = new LanceurJRTM();

		}
	}
	
	class ecranBDD implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			VueBDDGen bdd = new VueBDDGen();

		}
	}

	class propos implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("test");
			APropos fenAPropos = new APropos();

		}
	}

}
