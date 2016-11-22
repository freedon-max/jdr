package vueDM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class BoutonComp extends JPanel {

	private JPanel container = new JPanel();
	private JPanel containerRadio = new JPanel();

	private ButtonGroup bg = new ButtonGroup();
	JRadioButton[] btRadio;

	String nom;
	String type;
	int nbr, pos;

	public BoutonComp(String arg, String arg3, int arg2, int arg4) {
		this.nom = arg;
		this.type = arg3;
		this.nbr = arg2;
		this.pos = arg4;

		String str = "";
		String tp = "";
		btRadio = new JRadioButton[nbr];
		
		

		switch (arg3) {
		case "Force":
			tp = "Fo";
			break;
		case "Dextérité":
			tp = "Dx";
			break;
		case "QI":
			tp = "Qi";
			break;
		case "Santé":
			tp = "Sa";
			break;
		}

		switch (arg2) {
		case 1:
			str = tp;
			break;
		case 2:
			str = tp + " à " + tp + "+1";
			break;
		case 3:
			str = tp + " à " + tp + "+2";
			break;
		case 4:
			str = tp + " à " + tp + "+3";
			break;
		case 5:
			str = tp + "-1 à " + tp + "+3";
			break;
		case 6:
			str = tp + "-2 à " + tp + "+3";
			break;
		}

		container.removeAll();
		setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		this.setPreferredSize(new Dimension(410, 30));
		container.setBackground(Color.white);
		container.add(new JLabel(nom));

		containerRadio.setLayout(new BoxLayout(containerRadio, BoxLayout.X_AXIS));
		containerRadio.setBackground(Color.white);
		for (int i = 0; i < nbr; i++) {
			btRadio[i] = new JRadioButton();
			btRadio[i].setBackground(Color.white);
			bg.add(btRadio[i]);

			if (pos == i) {
				btRadio[i].setSelected(true);
			}

			containerRadio.add(btRadio[i]);
			btRadio[i].addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					if (arg0.getClickCount()==2) {
						bg.clearSelection();
					}
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
			});
		}
		container.add(containerRadio);
		container.add(new JLabel("  " + str));
		
		
		this.add(container);

		repaint();
		revalidate();

	}

	public int getBoutonComp() {
		int out = -1;

		for (int i = 0; i < nbr; i++) {
			if (btRadio[i].isSelected() == true) {
				out = i;
			}

		}
		return out;
	}

}
