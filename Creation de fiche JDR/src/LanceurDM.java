import controleDM.ControleFenDM;
import modelDM.PersoDM;
import vueDM.FenDM;

public class LanceurDM {

	public LanceurDM() {

		PersoDM persoDisque = new PersoDM();
		ControleFenDM controle = new ControleFenDM(persoDisque);

	}

}
