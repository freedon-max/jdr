package modelJRTM;

import java.util.ArrayList;

public class CalculBonusRace implements DataJRTM{
	
	PersoJRTM persoTM = null;
	
	private int rforce, ragilite, rconstitution, rintelligence, rintuition, rpresence;
	private static ArrayList degres = new ArrayList();
	private static ArrayList degres2 = new ArrayList();
	private static ArrayList<Boolean> initchkL = new ArrayList<Boolean>();
	
	public CalculBonusRace(String arg, PersoJRTM arg2) {
		this.persoTM = arg2;
		degres = persoTM.getDegres5();
		initchkL = persoTM.getInitchkL();
		
		Object[] temp = degres.toArray();
		
		if (arg.equals("Dûnedain")) {
			rforce = 5;
			ragilite = rconstitution = rintelligence = rintuition = rpresence = 0;
		} else if (arg.equals("Nains")) {
			rforce = 5;
			ragilite = -5;
			rconstitution = 15;
			rintelligence = 0;
			rintuition = -5;
			rpresence = -5;
			addD5(0,1);
			addD5(2,1);
			addD5(3,3);
			addD5(5,4);
			addD5(7,1);
			addD5(10,1);
			addD5(15,1);
			addD5(16,1);
			addD5(19,3);
			addD5(20,2);
			initchkL.remove(1);
			initchkL.add(1, true);
		}
		
		
		for(int i = 0; i < choixCompetence.length; i++){			
			int t = (int) temp[i];			
			if ((int) degres.get(i) < t) {
				degres.remove(i);
				degres.add(i, t);
			}						
		}
		
	}
	
	
	
	public int getRforce() {
		return rforce;
	}

	public int getRagilite() {
		return ragilite;
	}

	public int getRconstitution() {
		return rconstitution;
	}

	public int getRintelligence() {
		return rintelligence;
	}

	public int getRintuition() {
		return rintuition;
	}

	public int getRpresence() {
		return rpresence;
	}

	public  ArrayList getDegres5() {
		return degres;
	}

	public static ArrayList getDegres2() {
		return degres2;
	}
	public static ArrayList getInitchkL() {
		return initchkL;
	}


	private void addD5(int arg, int arg2){
		degres.remove(arg);
		degres.add(arg, arg2);
	}

}
