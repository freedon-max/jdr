package vueChtullu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Chtullu extends JPanel{
	
	public void paintComponent(Graphics g){
		System.out.println("test vue");
		//g.setColor(Color.white);
		//g.fillRect(0,  0,  this.getWidth(), this.getHeight());
		
		
		try {
			Image img = ImageIO.read(new File("img\\img1.jpg"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			//Pour une image de fond
			//g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			} catch (IOException e) {
			e.printStackTrace();
			}

	}

}
