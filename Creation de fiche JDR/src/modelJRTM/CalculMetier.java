package modelJRTM;

import java.util.ArrayList;

public class CalculMetier implements DataJRTM{
	
	PersoJRTM persoTM = null;
	
	private static ArrayList degres = new ArrayList();
	
	//{"Guerrier (FO)", "Scout (AG)", "Mage (IN)", "Animiste (IT)", "Ranger (CO)", "Barde (PR)"}
	//{"Sans armures" 0, "Cuir souple"1, "Cuir rigide"2, "Cotte de mailles"3, "Plates"4, "Tranchantes 1 main"5, "Contondantes 1 main"6, 
	//"Armes de lancé"7, "Projectiles"8, "Armes d’Hast"9 , "Escalade"10, "Equitation"11, "Natation"12, "Pistage"13, "Embuscades"14, 
	//"Filat/dissim."15, "Crochetage"16, "Désarmement pièges"17, "Lecture des Runes"18, "Utilisation d’objets"19, "Direction de sorts"20, 
	//"Dévelop. corporel"21, "Perception"22, "Sorts de base"23};                  

	
	public CalculMetier(String str, PersoJRTM obj){
		this.persoTM = obj;
		
		degres = persoTM.getDegres5();
		
		if(str.equals("Guerrier (FO)")) {
			addD(10, ((int) degres.get(10)+1));
			addD(11, ((int) degres.get(11)+1));
			addD(12, ((int) degres.get(12)+1));
			addD(13, ((int) degres.get(13)+1));
			addD(21, ((int) degres.get(21)+2));
			addD(5, ((int) degres.get(5)+3));
			addD(6, ((int) degres.get(6)+3));
			addD(7, ((int) degres.get(7)+3));
			addD(8, ((int) degres.get(8)+3));
			addD(9, ((int) degres.get(9)+3));
		}
		
		else if (str.equals("Scout (AG)")) {
			addD(10, ((int) degres.get(10)+1));
			addD(11, ((int) degres.get(11)+1));
			addD(12, ((int) degres.get(12)+1));
			addD(13, ((int) degres.get(13)+1));
			addD(5, ((int) degres.get(5)+1));
			addD(6, ((int) degres.get(6)+1));
			addD(7, ((int) degres.get(7)+1));
			addD(8, ((int) degres.get(8)+1));
			addD(9, ((int) degres.get(9)+1));			
			addD(14, ((int) degres.get(14)+2));
			addD(15, ((int) degres.get(15)+2));
			addD(16, ((int) degres.get(16)+2));
			addD(17, ((int) degres.get(17)+2));			
			addD(22, ((int) degres.get(22)+3));			
		}
		
		else if (str.equals("Mage (IN)")) {
			addD(18, ((int) degres.get(18)+2));	
			addD(19, ((int) degres.get(19)+2));	
			addD(23, ((int) degres.get(23)+2));	
			addD(20, ((int) degres.get(20)+3));	
			persoTM.setRoyaume("Ëssenliel");
		}
		
		else if (str.equals("Animiste (IT)")) {
			addD(18, ((int) degres.get(18)+1));	
			addD(19, ((int) degres.get(19)+1));	
			addD(10, ((int) degres.get(10)+1));
			addD(11, ((int) degres.get(11)+1));
			addD(12, ((int) degres.get(12)+1));
			addD(13, ((int) degres.get(13)+1));
			addD(22, ((int) degres.get(22)+1));
			addD(20, ((int) degres.get(20)+2));
			addD(23, ((int) degres.get(23)+2));	
			persoTM.setRoyaume("Théurgie");
		}
		else if (str.equals("Ranger (CO)")) {
			addD(5, ((int) degres.get(5)+2));
			addD(6, ((int) degres.get(6)+2));
			addD(7, ((int) degres.get(7)+2));
			addD(8, ((int) degres.get(8)+2));
			addD(9, ((int) degres.get(9)+2));	
			addD(22, ((int) degres.get(22)+2));
			addD(15, ((int) degres.get(15)+2));
			addD(10, ((int) degres.get(10)+3));
			addD(11, ((int) degres.get(11)+3));
			addD(12, ((int) degres.get(12)+3));
			addD(13, ((int) degres.get(13)+3));
			persoTM.setRoyaume("Théurgie");
		}
		else if (str.equals("Barde (PR)")) {
			addD(5, ((int) degres.get(5)+1));
			addD(6, ((int) degres.get(6)+1));
			addD(7, ((int) degres.get(7)+1));
			addD(8, ((int) degres.get(8)+1));
			addD(9, ((int) degres.get(9)+1));
			addD(10, ((int) degres.get(10)+1));
			addD(11, ((int) degres.get(11)+1));
			addD(12, ((int) degres.get(12)+1));
			addD(13, ((int) degres.get(13)+1));
			addD(22, ((int) degres.get(22)+1));
			addD(23, ((int) degres.get(23)+1));
			addD(14, ((int) degres.get(14)+1));
			addD(15, ((int) degres.get(15)+1));
			addD(16, ((int) degres.get(16)+1));
			addD(17, ((int) degres.get(17)+1));
			addD(18, ((int) degres.get(18)+1));
			addD(19, ((int) degres.get(19)+1));
			addD(20, ((int) degres.get(20)+1));
			persoTM.setRoyaume("Ëssenliel");
		}

	}
	
	private void addD(int arg, int arg2){
		degres.remove(arg);
		degres.add(arg, arg2);
	}
	public  ArrayList getD() {
		return degres;
	}

}
