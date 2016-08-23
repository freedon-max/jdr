import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vueChtullu.JLabelP;

public class APropos extends JFrame{
	private JPanel container = new JPanel();
	private JPanel containerT = new JPanel();
	JLabel containerLabel = new JLabel();
	JPanel containerRight = new JPanel();
	
	private Font font = new Font("Times New Roman", Font.BOLD, 15);
	private Font font2 = new Font("Times New Roman", Font.BOLD, 12);
	
	
	
	public APropos() {
		System.out.println("test2");
	this.setTitle("A Propos... ");
	this.setSize(600, 500);
	this.setBackground(Color.white);
	this.setFont(font);
	this.setLocationRelativeTo(null);
		
	this.getContentPane().add(containerT);
	containerT.setLayout(new BoxLayout(containerT, BoxLayout.LINE_AXIS));
	containerT.setBackground(Color.white);
	
	container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
	container.setBackground(Color.white);
	
	
	container.add(new JLabelP(" ", font));container.add(new JLabelP("", font));
	container.add(new JLabelP("	  Bienvenue dans ce logiciel de création  assisté ou ", font));
	container.add(new JLabelP("  automatique de personnage de jeu de rôle.", font));
	container.add(new JLabelP(" ", font));
	container.add(new JLabelP(" ", font));
	container.add(new JLabelP("	  L'utilisation est très simple :", font));
	container.add(new JLabelP("	  Soit vous lancez vos dés manuellement et vous ", font));
	container.add(new JLabelP("  complétez les sections, sinon vous pouvez générer les ", font));
	container.add(new JLabelP("	  caractéristiques ou fiches complètes automatiquements.", font));
	container.add(new JLabelP("  ", font));
	container.add(new JLabelP(" ", font));
	container.add(new JLabelP("	  Une fois terminé, une fiche de perso est générée à ", font));
	container.add(new JLabelP("   l'emplacement de votre choix au format .jpg", font));
	container.add(new JLabelP(" ", font));
	container.add(new JLabelP("   Important : les livres de rêgles restent indispensables", font));
	container.add(new JLabelP("    à la bonne création de vos personnages.", font));
	container.add(new JLabelP(" ", font));
	container.add(new JLabelP("    Voici ceux que j'ai utilisés : ", font));
	container.add(new JLabelP("   Chtullu : Edition Choasum, version 5", font));
	container.add(new JLabelP("   Disque monde : Edtition Edge", font));
	container.add(new JLabelP("   Dongeon & Dragon : En développement.", font));
	container.add(new JLabelP("   RuneQuest : En développement.", font));
	container.add(new JLabelP("   Terre du milieu : En développement.", font));
	container.add(new JLabelP(" ", font));
	container.add(new JLabelP(" ", font));
	container.add(new JLabelP("Version 1.0 ", font2));
	containerT.add(container);
	
	Icon img = new ImageIcon(new ImageIcon("img/edit/mort.jpg").getImage().getScaledInstance(270, 500, Image.SCALE_DEFAULT));
	
	containerLabel.setIcon(img);
	containerRight.setLayout(new FlowLayout(FlowLayout.RIGHT));
	containerRight.setBackground(Color.white);
	containerRight.add(containerLabel);
	containerT.add(containerRight);
	
	
	
	this.setResizable(false);
	this.setVisible(true);
	}
}
