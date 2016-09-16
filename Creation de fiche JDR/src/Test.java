import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import vueJRTM.CompJRTM;

public class Test extends JFrame{
	
	private JPanel container = new JPanel();

	public static void main(String[] args) {
		
		Test test = new Test();
		

	}
	
	public Test() {
		
		CompJRTM bt = new CompJRTM("Contondantes 1 main", true, 10, 7, 5);
		System.out.println("test ok");
		this.setTitle("test : ");
		this.setSize(400, 200);
		this.setBackground(Color.white);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(container);
		container.setBackground(Color.white);
		
		container.add(bt);
		
		
		this.setResizable(false);
		this.setVisible(true);
		
	}

}
