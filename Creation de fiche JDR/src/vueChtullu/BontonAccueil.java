package vueChtullu;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class BontonAccueil extends JButton {

	private String file;

	public BontonAccueil(String file) {
		this.file = file;

	}

	public void paintComponent(Graphics g) {

		try {
			Image img = ImageIO.read(new File(file));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
