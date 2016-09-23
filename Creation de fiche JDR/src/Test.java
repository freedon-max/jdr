import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import vueJRTM.CompJRTM;

public class Test extends JFrame{
	
	private JPanel container = new JPanel();

	public static void main(String[] args) {
		
		int srt = calculPP(108);
		System.out.println(" out : " + srt);
		

	}
	
	public static int calculPP(int arg) {
		
		
			int out = 0;
			
			if(arg < 75 ) {out = 0;}
			else if (arg >=75 && arg < 95) {out = 1;}
			else if (arg >=95 && arg < 100) {out = 2;}
			else if (arg ==100 || arg == 101) {out = 3;}
			
			else out = 4;
			
			return out;
		
		
	}

}
