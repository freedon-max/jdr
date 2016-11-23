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

import controleAdmin.ControleFenAdmin;
import vueBDD.VueBdd;
import vueChtullu.BontonAccueil;

public class Accueil extends JFrame {

	private JPanel container = new JPanel(), containerTxt = new JPanel(), containerB = new JPanel(),
			containerB2 = new JPanel();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fichier = new JMenu("Fichier"), aPropos = new JMenu("A Propos..."), creer = new JMenu("Créer");

	private JMenuItem quitter = new JMenuItem("QUITTER"), aProposItem = new JMenuItem("?"),
			chtullu = new JMenuItem("Chtullu"), disque = new JMenuItem("Disque monde"),
			donjon = new JMenuItem("Donjon & Dragon"), rune = new JMenuItem("Runequest"),
			milieu = new JMenuItem("JRTM"), bdd = new JMenuItem("BDD"), edition = new JMenuItem("Edition MJ");

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

		cht.addActionListener(new EcranChtullu());
		dm.addActionListener(new EcranDM());
		tdm.addActionListener(new EcranJRTM());

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
		fichier.add(edition);
		fichier.setMnemonic('f');
		fichier.addSeparator();
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));
		fichier.add(quitter);
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		chtullu.addActionListener(new EcranChtullu());
		disque.addActionListener(new EcranDM());
		milieu.addActionListener(new EcranJRTM());
		// recommencer.addActionListener(ecranActif);
		bdd.addActionListener(new EcranBDD());
		edition.addActionListener(new EcranEdition());
		menuBar.add(fichier);
		menuBar.add(aPropos);
		aProposItem.addActionListener(new Propos());
		aPropos.add(aProposItem);

		this.setJMenuBar(menuBar);
	}

	class EcranChtullu implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new LanceurCht();

		}
	}

	class EcranDM implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new LanceurDM();

		}
	}
	
	class EcranJRTM implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new LanceurJRTM();

		}
	}
	
	class EcranBDD implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new VueBdd();

		}
	}

	class EcranEdition implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new ControleFenAdmin();

		}
	}
	
	class Propos implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new APropos();

		}
	}

}
