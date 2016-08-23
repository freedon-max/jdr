package vueDM;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class JCheckBoxP extends JCheckBox {

	private String name, text;
	private boolean selected = false;

	public JCheckBoxP(String text, boolean st) {

		this.name = text;
		this.selected = st;

		this.setBackground(Color.white);
		this.add(new JLabel("      " + text));

	}

}
