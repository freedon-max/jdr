import controleJRTM.ControleFenJRTM;
import modelJRTM.PersoJRTM;

public class LanceurJRTM {
	
	LanceurJRTM() {
		
		PersoJRTM perso = new PersoJRTM();
		ControleFenJRTM controle = new ControleFenJRTM(perso);
	}

}
