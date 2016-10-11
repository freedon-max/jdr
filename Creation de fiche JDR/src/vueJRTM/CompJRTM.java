package vueJRTM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controleJRTM.ControleFenJRTM;
import modelJRTM.DataJRTM;
import vueChtullu.JLabelP;

public class CompJRTM extends JPanel implements DataJRTM {

	private ControleFenJRTM controle = null;
	private String name;
	private int select, select2 = 0;
	private int selectOut, select2Out;
	private int longueur;
	private int pos;

	private JPanel container = new JPanel();
	private Font font = new Font("Times New Roman", Font.BOLD, 15);

	static String[] niveaux = {"0 niveau", "1 niveau", "2 niveau", "3 niveau", "4 niveau", "5 niveau", "6 niveau", "7 niveau",
			"8 niveau", "9 niveau", "10 niveau" };
	String[] niveau2 = { "0 niveau", "1 niveau", "2 niveau", "3 niveau", "4 niveau", "5 niveau" };

	JComboBox nv = new JComboBox();

	public JComboBox nv2 = new JComboBox(niveau2);

	public CompJRTM(ControleFenJRTM obj, String arg, boolean arg2, int arg3, int arg4, int arg5, int arg6) {
		this.controle = obj;
		this.pos = arg6;

		this.name = arg;
		this.select = arg4;
		this.select2 = arg5;

		if (arg3 == 2) {
			String niv[] = { "0 niveau", "1 niveau", "2 niveau" };
			this.nv = new JComboBox(niv);
			longueur = 3;
		} else if (arg3 == 3) {
			String niv[] = {"0 niveau",  "1 niveau", "2 niveau", "3 niveau" };
			this.nv = new JComboBox(niv);
			longueur = 4;
		} else if (arg3 == 5) {
			String niv[] = {"0 niveau",  "1 niveau", "2 niveau", "3 niveau", "4 niveau", "5 niveau" };
			this.nv = new JComboBox(niv);
			longueur = 6;
		} else if (arg3 == 7) {
			String niv[] = { "0 niveau", "1 niveau", "2 niveau", "3 niveau", "4 niveau", "5 niveau", "6 niveau", "7 niveau" };
			this.nv = new JComboBox(niv);
			longueur = 8;
		} else if (arg3 == 9) {
			String niv[] = { "0 niveau", "1 niveau", "2 niveau", "3 niveau", "4 niveau", "5 niveau", "6 niveau", "7 niveau",
					"8 niveau", "9 niveau" };
			this.nv = new JComboBox(niv);
			longueur = 10;
		} else if (arg3 == 10) {
			String niv[] = { "0 niveau", "1 niveau", "2 niveau", "3 niveau", "4 niveau", "5 niveau", "6 niveau", "7 niveau",
					"8 niveau", "9 niveau", "10 niveau" };
			this.nv = new JComboBox(niv);
			longueur = 11;
		}
		if (arg2 == false)
			Screen();
		else
			Screen2();

	}

	public void Screen() {

		container.removeAll();
		setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		this.setPreferredSize(new Dimension(300, 25));
		container.setLayout(new BoxLayout(container, BoxLayout.LINE_AXIS));
		container.setBackground(Color.white);
		container.add(new JLabelP(name + "  ", font));
		nv.setPreferredSize(new Dimension(100, 20));
		nv.setSelectedIndex(select);
		nv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ItemNV();
			}
		});
		container.add(nv);
		this.add(container);
		repaint();
		revalidate();

	}

	public void Screen2() {

		container.removeAll();
		setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		this.setPreferredSize(new Dimension(300, 25));
		container.setLayout(new BoxLayout(container, BoxLayout.LINE_AXIS));
		container.setBackground(Color.white);
		container.add(new JLabelP(name + "  ", font));
		nv.setPreferredSize(new Dimension(100, 20));
		nv2.setPreferredSize(new Dimension(100, 20));
		nv.setSelectedIndex(select);
		nv2.setSelectedIndex(select2);
		container.add(nv);
		container.add(nv2);

		nv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ItemNV();
			}
		});

		nv2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ItemNV2();
			}
		});
		this.add(container);
		repaint();
		revalidate();

	}

	private void ItemNV() {
		selectOut = GetD5();
		controle.ItemDegres5(pos);
	}

	private void ItemNV2() {
		select2Out = GetD2();
		controle.ItemDegres2(pos);
	}

	public void setSelect(int select) {
		this.select = select;
	}

	public void setSelect2(int select2) {
		this.select2 = select2;
	}

	public int getSelectOut() {
		return selectOut;
	}

	public int getSelect2Out() {
		return select2Out;
	}

	public int GetD5() {
		int out = 0;
		for (int i = 0; i < longueur; i++) {
			if (nv.getSelectedItem().equals(niveau[i]))
				out = i;
		}
		return out;
	}

	public int GetD2() {
		int out = 0;
		for (int i = 0; i < 4; i++) {
			if (nv2.getSelectedItem().equals(niveau[i]))
				out = i;
		}
		return out;
	}

}
