package controleDM;

import vueDM.FenDM;

public abstract class DMVue {
	
	private FenDM fenetre = null;
	
	public DMVue(FenDM fen){
		this.fenetre = fen;
		
	}
	
	public final FenDM getFenDM() {
		return fenetre;
	}

}
