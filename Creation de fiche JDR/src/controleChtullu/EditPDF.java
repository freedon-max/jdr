package controleChtullu;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfWriter;


/*
 
 Permet de convertir l'image au format BufferedImage en pdf sur un format A4 avec l'API Itext
    
 */
public class EditPDF {
	
	java.awt.Image img;
	private int x, y;


	public EditPDF(BufferedImage img, int x, int y) {
		this.img = img;
		this.x = x;
		this.y = y;
				
		Document document = new Document();
		try {
		      
			PdfWriter.getInstance(document, new FileOutputStream("Perso.pdf"));
			document.open();
		    		    
			Image image;
			try {
				image = Image.getInstance(img, null);
				image.setAbsolutePosition(0, 0); //possition en partant d'en bas a gauche (largeur, hauteur)
				image.scaleAbsoluteWidth(620); //largeur en pixel
				image.scaleAbsoluteHeight(850); // hauteur en pixel
				document.add(image);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch(Exception e) {
		    
		    System.err.println(e);
		}
		finally {
		    document.close();
		}
	    }
	
	
	
	
	
	
}
