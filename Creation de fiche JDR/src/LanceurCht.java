import controleChtullu.ControleFenCht;
import modelChtullu.PersoChtullu;

public class LanceurCht {
	
	public LanceurCht(){
		
		PersoChtullu persoCht = new PersoChtullu();
		ControleFenCht controle = new ControleFenCht(persoCht);
	}

}
