package vueChtullu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoutonComp extends JPanel {

	private String name;
	private boolean arg = true;
	private int init, comp;

	private JPanel containerB = new JPanel();

	private BoutonComp2 plus = new BoutonComp2("+");
	private BoutonComp2 moins = new BoutonComp2("-");
	private BoutonComp2 plus10 = new BoutonComp2("++");
	private BoutonComp2 moins10 = new BoutonComp2("--");

	public BoutonComp(String str, boolean st, int init) {
		this.name = str;
		this.arg = st;
		this.init = init;
		comp = init;

		if (st == true)
			screen();
		else
			screen2();

	}

	private void screen() {

		containerB.removeAll();
		this.setPreferredSize(new Dimension(300, 25));
		containerB.setLayout(new FlowLayout(0, 1, 0));
		containerB.setBackground(Color.white);
		containerB.add(plus10);
		containerB.add(plus);
		containerB.add(moins);
		containerB.add(moins10);

		containerB.add(new JLabel("  " + name + "  "));
		containerB.add(new JLabel(" Init : " + init + "% ......... : " + comp + "%"));

		this.add(containerB);
		plus10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comp >= 100) {
					comp = comp;
				} else {
					comp = comp + 10;
				}
				containerB.removeAll();
				containerB.setBackground(Color.white);
				containerB.setLayout(new FlowLayout(0, 1, 0));
				containerB.add(plus10);
				containerB.add(plus);
				containerB.add(moins);
				containerB.add(moins10);
				containerB.add(new JLabel("  " + name + "  "));
				containerB.add(new JLabel(" Init : " + init + "% ......... : " + comp + "%"));

				repaint();
				revalidate();
			}
		});

		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comp >= 100) {
					comp = comp;
				} else {
					comp++;
				}
				containerB.removeAll();
				containerB.setBackground(Color.white);
				containerB.setLayout(new FlowLayout(0, 1, 0));
				containerB.add(plus10);
				containerB.add(plus);
				containerB.add(moins);
				containerB.add(moins10);
				containerB.add(new JLabel("  " + name + "  "));
				containerB.add(new JLabel(" Init : " + init + "% ......... : " + comp + "%"));
				repaint();
				revalidate();
			}
		});

		moins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comp <= init) {
					comp = comp;
				} else {
					comp--;
				}

				containerB.removeAll();
				containerB.setBackground(Color.white);
				containerB.setLayout(new FlowLayout(0, 1, 0));
				containerB.add(plus10);
				containerB.add(plus);
				containerB.add(moins);
				containerB.add(moins10);
				containerB.add(new JLabel("  " + name + "  "));
				containerB.add(new JLabel(" Init : " + init + "% ......... : " + comp + "%"));
				repaint();
				revalidate();
			}
		});
		moins10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comp <= init) {
					comp = comp;
				} else {
					comp = comp - 10;
				}

				containerB.removeAll();
				containerB.setBackground(Color.white);
				containerB.setLayout(new FlowLayout(0, 1, 0));
				containerB.add(plus10);
				containerB.add(plus);
				containerB.add(moins);
				containerB.add(moins10);
				containerB.add(new JLabel("  " + name + "  "));
				containerB.add(new JLabel(" Init : " + init + "% ......... : " + comp + "%"));
				repaint();
				revalidate();
			}
		});
		repaint();
		revalidate();
	}

	private void screen2() {

		JLabel label1 = new JLabel("  " + name + "  "),
				label2 = new JLabel(" Init : " + init + "% ......... : " + comp + "%");

		containerB.removeAll();
		containerB.setBackground(Color.white);
		this.setPreferredSize(new Dimension(300, 25));
		Font police = new Font("Arial", Font.BOLD, 9);
		label1.setFont(police);
		label1.setForeground(Color.gray);
		label2.setFont(police);
		label2.setForeground(Color.gray);
		containerB.setLayout(new FlowLayout(0, 1, 0));
		containerB.add(plus10);
		containerB.add(plus);
		containerB.add(moins);
		containerB.add(moins10);
		containerB.add(label1);
		containerB.add(label2);
		this.add(containerB);
		repaint();
		revalidate();
	}

	public int getComp() {
		return comp;

	}

	public int getInit() {
		return init;
	}

	public String getNom() {
		return name;
	}

}
