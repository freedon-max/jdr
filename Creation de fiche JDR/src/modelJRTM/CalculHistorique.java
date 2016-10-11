package modelJRTM;

import java.util.ArrayList;

public class CalculHistorique implements DataJRTM {

	PersoJRTM persoTM = null;

	private ArrayList deg = new ArrayList();
	private Object[] temp;
	private int hist;

	public CalculHistorique(PersoJRTM obj, ArrayList arg, int arg2) {
		this.persoTM = obj;
		deg = persoTM.getDegres5();
		temp = arg.toArray();
		hist = arg2;

		if (persoTM.getRace() == persoTM.getRaceTemp()) {
			int tempH = 0;
			for (int i = 0; i < choixCompetence.length; i++) {
				if ((int) temp[i] < (int) deg.get(i)) {
					tempH = tempH + ((int) deg.get(i) - (int) temp[i]);
				}
			}
			hist = hist - tempH;
		}
		persoTM.setPointHit(hist);
		persoTM.setTemph(deg.toArray());

	}

}
