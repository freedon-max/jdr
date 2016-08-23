package vueChtullu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

public class BoutonComp2 extends JButton {
	// bouton plus et moins dans BoutonComp
	private String name;

	public BoutonComp2(String str) {
		super(str);
		this.name = str;
		this.setPreferredSize(new Dimension(18, 18));

	}

	public void paintComponent(Graphics g) {

		g.setColor(Color.white);
		g.fillRect(0, 0, 18, 18);
		g.setColor(Color.black);
		g.drawString(this.name, 5, 12);

	}

}
