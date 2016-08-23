package vueChtullu;

import java.awt.Font;

import javax.swing.JLabel;

public class JLabelP extends JLabel {
	String text;
	Font font;

	public JLabelP(String text, Font font) {
		super.setText(text);

		this.font = font;
		super.setFont(font);
	}

}
