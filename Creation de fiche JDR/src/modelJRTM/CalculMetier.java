package modelJRTM;

import java.util.ArrayList;

public class CalculMetier implements DataJRTM{
	
	PersoJRTM persoTM = null;
	
	private static ArrayList bonus = new ArrayList();
	
	//{"Guerrier (FO)", "Scout (AG)", "Mage (IN)", "Animiste (IT)", "Ranger (CO)", "Barde (PR)"}
	//{"Sans armures" 0, "Cuir souple"1, "Cuir rigide"2, "Cotte de mailles"3, "Plates"4, "Tranchantes 1 main"5, "Contondantes 1 main"6, 
	//"2 mains" 7, "Armes de lancé"8, "Projectiles"9, "Armes d’Hast"10 , "Escalade"11, "Equitation"12, "Natation"13, "Pistage"14, "Embuscades"15, 
	//"Filat/dissim."16, "Crochetage"17, "Désarmement pièges"18, "Lecture des Runes"19, "Utilisation d’objets"20, "Direction de sorts"21, 
	//"Dévelop. corporel"22 "Perception"23, "Sorts de base"24};                  

	
	public CalculMetier(String str, PersoJRTM obj){
		this.persoTM = obj;
		
		bonus = persoTM.getBonusComp();
				
		if(str.equals("Guerrier (FO)")) {
			addBonus(11, 1);
			addBonus(12, 1);
			addBonus(13, 1);
			addBonus(14, 1);
			addBonus(22, 2);
			addBonus(5, 3);
			addBonus(6, 3);
			addBonus(7, 3);
			addBonus(8, 3);
			addBonus(9, 3);
			addBonus(10, 3);
			if(persoTM.getRoyaume().equals("Ëssenliel")) {
				persoTM.setPointPouvoir(CalculPP(persoTM.getIntelligence()));
			}
			else persoTM.setPointPouvoir(CalculPP(persoTM.getIntuition()));
		}
		
		else if (str.equals("Scout (AG)")) {
			addBonus(5, 1);
			addBonus(6, 1);
			addBonus(7, 1);
			addBonus(8, 1);
			addBonus(9, 1);
			addBonus(10, 1);
			addBonus(11, 1);
			addBonus(12, 1);
			addBonus(13, 1);
			addBonus(14, 1);
			addBonus(15, 2);
			addBonus(16, 2);
			addBonus(17, 2);
			addBonus(18, 2);
			addBonus(23, 3);
			
			if(persoTM.getRoyaume().equals("Ëssenliel")) {
				persoTM.setPointPouvoir(CalculPP(persoTM.getIntelligence()));
			}
			else persoTM.setPointPouvoir(CalculPP(persoTM.getIntuition()));
		}
		
		else if (str.equals("Mage (IN)")) {
			addBonus(19, 2);
			addBonus(20, 2);
			addBonus(24, 2);
			addBonus(21, 2);
			addBonus(24, 2);
			persoTM.setRoyaume("Ëssenliel");
			persoTM.setPointPouvoir(CalculPP(persoTM.getIntelligence()));
			
		}
		
		else if (str.equals("Animiste (IT)")) {
			addBonus(19, 1);
			addBonus(20, 1);
			addBonus(11, 1);
			addBonus(12, 1);
			addBonus(13, 1);
			addBonus(14, 1);
			addBonus(23, 1);
			addBonus(21, 2);
			persoTM.setRoyaume("Théurgie");
			persoTM.setPointPouvoir(CalculPP(persoTM.getIntuition()));
		}
		else if (str.equals("Ranger (CO)")) {
			addBonus(5, 2);
			addBonus(6, 2);
			addBonus(7, 2);
			addBonus(8, 2);
			addBonus(9, 2);
			addBonus(10, 2);
			addBonus(23, 2);
			addBonus(16, 2);
			addBonus(11, 3);
			addBonus(12, 3);
			addBonus(13, 3);
			addBonus(14, 3);
			
			persoTM.setRoyaume("Théurgie");
			persoTM.setPointPouvoir(CalculPP(persoTM.getIntuition()));
		}
		else if (str.equals("Barde (PR)")) {
			addBonus(5, 1);
			addBonus(6, 1);
			addBonus(7, 1);
			addBonus(8, 1);
			addBonus(9, 1);
			addBonus(10, 1);
			addBonus(11, 1);
			addBonus(12, 1);
			addBonus(13, 1);
			addBonus(14, 1);
			addBonus(15, 1);
			addBonus(16, 1);
			addBonus(17, 1);
			addBonus(18, 1);
			addBonus(23, 1);
			addBonus(24, 1);
			persoTM.setRoyaume("Ëssenliel");
			persoTM.setPointPouvoir(CalculPP(persoTM.getIntelligence()));
		}
		
		persoTM.setBonusComp(bonus);
		

	}
	
	private void addBonus(int arg, int arg2){
		bonus.remove(arg);
		bonus.add(arg, arg2);
		persoTM.addBonusAff(arg, arg2);
	}
	
	private int CalculPP(int arg) {
		int out = 0;		
		if(arg < 75 ) {out = 0;}
		else if (arg >=75 && arg < 95) {out = 1;}
		else if (arg >=95 && arg < 100) {out = 2;}
		else if (arg ==100 || arg == 101) {out = 3;}	
		else out = 4;		
		return out;
	}
	
	
}
