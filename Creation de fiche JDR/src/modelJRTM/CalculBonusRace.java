package modelJRTM;

import java.util.ArrayList;

public class CalculBonusRace implements DataJRTM {

	PersoJRTM persoTM = null;

	private int rforce, ragilite, rconstitution, rintelligence, rintuition, rpresence;
	private static ArrayList degres = new ArrayList();
	private static ArrayList deg = new ArrayList();
	private static ArrayList degL = new ArrayList();
	private static ArrayList degres2 = new ArrayList();
	private static ArrayList<Boolean> initchkL = new ArrayList<Boolean>();
	private int hist;

	public CalculBonusRace(String arg, PersoJRTM arg2) {
		this.persoTM = arg2;
		degres = persoTM.getDegres5();
		initchkL = persoTM.getInitchkL();
		degL = persoTM.getDegLangue();
		Object[] temp = degres.toArray();

		for (int i = 0; i < choixCompetence.length; i++) {
			deg.add(0);

		}

		if (arg.equals(persoTM.getRaceTemp())) {
			hist = persoTM.getHistT();

		}

		else if (arg.equals("Nains")) {
			rforce = 5;
			ragilite = -5;
			rconstitution = 15;
			rintelligence = 0;
			rintuition = -5;
			rpresence = -5;
			addD5(0, 1);
			addD5(2, 1);
			addD5(3, 3);
			addD5(5, 4);
			addD5(7, 1);
			addD5(10, 1);
			addD5(15, 1);
			addD5(16, 1);
			addD5(19, 3);
			addD5(20, 2);
			addDegL(6, true, 5);
			addDegL(17, true, 3);
			addDegL(22, true, 5);
			persoTM.setResistanceEss(40);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(10);
			persoTM.setResistanceMal(10);
			hist = 4;

		} else if (arg.equals("Umli")) {
			rforce = 5;
			ragilite = 0;
			rconstitution = 1;
			rintelligence = 0;
			rintuition = -5;
			rpresence = -5;
			addD5(0, 1);
			addD5(2, 1);
			addD5(3, 3);
			addD5(6, 4);
			addD5(8, 1);
			addD5(11, 1);
			addD5(17, 1);
			addD5(18, 1);
			addD5(22, 3);
			addD5(23, 2);
			addDegL(6, true, 1);
			addDegL(8, true, 2);
			addDegL(19, true, 5);
			addDegL(22, true, 2);
			persoTM.setResistanceEss(20);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(5);
			persoTM.setResistanceMal(5);
			hist = 4;

		} else if (arg.equals("Elfes Noldor")) {
			rforce = 0;
			ragilite = 15;
			rconstitution = 10;
			rintelligence = 5;
			rintuition = 5;
			rpresence = 15;
			addD5(0, 1);
			addD5(5, 1);
			addD5(9, 1);
			addD5(12, 1);
			addD5(13, 2);
			addD5(16, 2);
			addD5(19, 2);
			addD5(20, 1);
			addD5(22, 1);
			addD5(23, 3);
			addDegL(0, true, 3);
			addDegL(15, true, 5);
			addDegL(17, true, 5);
			addDegL(22, true, 5);
			persoTM.setResistanceEss(0);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(10);
			persoTM.setResistanceMal(100);
			hist = 2;

		} else if (arg.equals("Elfes Sindar")) {
			rforce = 0;
			ragilite = 10;
			rconstitution = 5;
			rintelligence = 0;
			rintuition = 5;
			rpresence = 10;
			addD5(0, 1);
			addD5(5, 1);
			addD5(9, 2);
			addD5(11, 1);
			addD5(12, 1);
			addD5(13, 2);
			addD5(14, 2);
			addD5(16, 3);
			addD5(19, 1);
			addD5(20, 1);
			addD5(22, 1);
			addD5(23, 3);
			addDegL(15, true, 5);
			addDegL(17, true, 5);
			addDegL(18, true, 4);
			addDegL(22, true, 5);
			persoTM.setResistanceEss(0);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(10);
			persoTM.setResistanceMal(100);
			hist = 3;

		} else if (arg.equals("Elfes Sylvains")) {
			rforce = 0;
			ragilite = 10;
			rconstitution = 0;
			rintelligence = 0;
			rintuition = 5;
			rpresence = 5;
			addD5(0, 1);
			addD5(5, 1);
			addD5(9, 3);
			addD5(11, 2);
			addD5(12, 1);
			addD5(13, 3);
			addD5(14, 3);
			addD5(16, 4);
			addD5(19, 1);
			addD5(22, 1);
			addD5(23, 3);
			addDegL(15, true, 5);
			addDegL(17, true, 5);
			addDegL(18, true, 5);
			addDegL(22, true, 5);
			persoTM.setResistanceEss(0);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(10);
			persoTM.setResistanceMal(100);
			hist = 4;

		} else if (arg.equals("Semi-Elfes")) {
			rforce = 5;
			ragilite = 5;
			rconstitution = 5;
			rintelligence = 0;
			rintuition = 0;
			rpresence = 5;
			addD5(0, 1);
			addD5(2, 1);
			addD5(3, 1);
			addD5(5, 1);
			addD5(9, 2);
			addD5(11, 1);
			addD5(12, 1);
			addD5(13, 1);
			addD5(14, 1);
			addD5(16, 2);
			addD5(19, 1);
			addD5(22, 1);
			addD5(23, 1);
			addDegL(17, true, 5);
			addDegL(22, true, 5);
			persoTM.setResistanceEss(0);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(5);
			persoTM.setResistanceMal(50);
			hist = 3;

		} else if (arg.equals("Hobbits")) {
			rforce = -20;
			ragilite = 15;
			rconstitution = 15;
			rintelligence = 0;
			rintuition = -5;
			rpresence = -5;
			addD5(0, 1);
			addD5(8, 2);
			addD5(9, 2);
			addD5(11, 2);
			addD5(14, 2);
			addD5(16, 5);
			addD5(17, 1);
			addD5(18, 1);
			addD5(22, 2);
			addD5(23, 4);
			addDegL(7, true, 5);
			addDegL(22, true, 5);
			persoTM.setResistanceEss(50);
			persoTM.setResistanceThe(20);
			persoTM.setResistancePoi(30);
			persoTM.setResistanceMal(15);
			hist = 5;

		} else if (arg.equals("Béornides")) {
			rforce = 5;
			ragilite = 0;
			rconstitution = 0;
			rintelligence = 0;
			rintuition = 0;
			rpresence = 0;
			addD5(0, 1);
			addD5(7, 1);
			addD5(8, 1);
			addD5(10, 2);
			addD5(11, 2);
			addD5(13, 2);
			addD5(14, 3);
			addD5(16, 4);
			addD5(22, 3);
			addD5(23, 1);
			addDegL(2, true, 5);
			addDegL(10, true, 5);
			addDegL(21, true, 5);
			addDegL(22, true, 5);
			persoTM.setResistanceEss(0);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(0);
			persoTM.setResistanceMal(0);
			hist = 5;

		} else if (arg.equals("Nûménoréens. Noirs")) {
			rforce = 5;
			ragilite = 0;
			rconstitution = 10;
			rintelligence = 0;
			rintuition = 0;
			rpresence = 5;
			addD5(0, 1);
			addD5(3, 2);
			addD5(5, 1);
			addD5(8, 1);
			addD5(9, 1);
			addD5(12, 1);
			addD5(13, 3);
			addD5(19, 1);
			addD5(20, 1);
			addD5(22, 2);
			addDegL(0, true, 5);
			addDegL(4, true, 5);
			addDegL(22, true, 5);
			persoTM.setResistanceEss(0);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(0);
			persoTM.setResistanceMal(0);
			hist = 3;

		} else if (arg.equals("Corsaires")) {
			rforce = 5;
			ragilite = 0;
			rconstitution = 0;
			rintelligence = 0;
			rintuition = 0;
			rpresence = 0;
			addD5(0, 1);
			addD5(2, 2);
			addD5(5, 2);
			addD5(8, 1);
			addD5(9, 1);
			addD5(13, 5);
			addD5(22, 2);
			addDegL(0, true, 5);
			addDegL(4, true, 4);
			addDegL(22, true, 5);
			persoTM.setResistanceEss(0);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(0);
			persoTM.setResistanceMal(0);
			hist = 5;

		} else if (arg.equals("Dorwinrim")) {
			rforce = 5;
			ragilite = 0;
			rconstitution = 0;
			rintelligence = 0;
			rintuition = 0;
			rpresence = 0;
			addD5(0, 1);
			addD5(2, 1);
			addD5(6, 1);
			addD5(8, 1);
			addD5(9, 1);
			addD5(10, 1);
			addD5(12, 2);
			addD5(13, 1);
			addD5(22, 1);
			addDegL(9, true, 5);
			addDegL(22, true, 5);
			persoTM.setResistanceEss(0);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(0);
			persoTM.setResistanceMal(0);
			hist = 5;

		} else if (arg.equals("Dûnedain")) {
			rforce = 5;
			ragilite = 0;
			rconstitution = 10;
			rintelligence = 0;
			rintuition = 0;
			rpresence = 5;
			addD5(0, 1);
			addD5(2, 1);
			addD5(3, 2);
			addD5(5, 2);
			addD5(7, 1);
			addD5(9, 1);
			addD5(10, 1);
			addD5(12, 1);
			addD5(13, 1);
			addD5(19, 1);
			addD5(20, 1);
			addD5(22, 3);
			addDegL(0, true, 4);
			addDegL(15, true, 4);
			addDegL(17, true, 4);
			addDegL(22, true, 5);
			persoTM.setResistanceEss(0);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(5);
			persoTM.setResistanceMal(5);
			hist = 3;

		} else if (arg.equals("Dunlendings")) {
			rforce = 5;
			ragilite = 0;
			rconstitution = 0;
			rintelligence = 0;
			rintuition = 0;
			rpresence = 0;
			addD5(0, 1);
			addD5(2, 1);
			addD5(6, 1);
			addD5(8, 2);
			addD5(9, 1);
			addD5(10, 2);
			addD5(11, 5);
			addD5(13, 1);
			addD5(14, 1);
			addD5(16, 2);
			addD5(22, 3);
			addD5(23, 1);
			addDegL(3, true, 5);
			addDegL(22, true, 4);
			persoTM.setResistanceEss(0);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(0);
			persoTM.setResistanceMal(0);
			hist = 4;

		} else if (arg.equals("Easlerlings")) {
			rforce = 5;
			ragilite = 0;
			rconstitution = 0;
			rintelligence = 0;
			rintuition = 0;
			rpresence = 0;
			addD5(0, 1);
			addD5(5, 1);
			addD5(8, 1);
			addD5(9, 2);
			addD5(10, 2);
			addD5(12, 5);
			addD5(22, 2);
			addD5(23, 1);
			addDegL(9, true, 5);
			addDegL(22, true, 2);
			persoTM.setResistanceEss(0);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(0);
			persoTM.setResistanceMal(0);
			hist = 4;

		} else if (arg.equals("Haradrim")) {
			rforce = 5;
			ragilite = 0;
			rconstitution = 0;
			rintelligence = 0;
			rintuition = 0;
			rpresence = 0;
			addD5(0, 1);
			addD5(1, 1);
			addD5(5, 1);
			addD5(8, 1);
			addD5(10, 2);
			addD5(12, 7);
			addD5(22, 2);
			addD5(23, 1);
			addDegL(1, true, 5);
			addDegL(4, true, 5);
			addDegL(22, true, 4);
			persoTM.setResistanceEss(0);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(0);
			persoTM.setResistanceMal(0);
			hist = 5;

		} else if (arg.equals("Lossoth")) {
			rforce = 5;
			ragilite = 0;
			rconstitution = 0;
			rintelligence = 0;
			rintuition = 0;
			rpresence = 0;
			addD5(0, 1);
			addD5(1, 3);
			addD5(8, 3);
			addD5(10, 2);
			addD5(13, 2);
			addD5(14, 3);
			addD5(16, 4);
			addD5(22, 3);
			addD5(23, 1);
			addDegL(8, true, 5);
			addDegL(17, true, 2);
			addDegL(22, true, 2);
			persoTM.setResistanceEss(0);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(0);
			persoTM.setResistanceMal(0);
			hist = 4;

		} else if (arg.equals("Rohirrim")) {
			rforce = 5;
			ragilite = 0;
			rconstitution = 0;
			rintelligence = 0;
			rintuition = 0;
			rpresence = 0;
			addD5(0, 1);
			addD5(2, 1);
			addD5(3, 2);
			addD5(5, 2);
			addD5(9, 1);
			addD5(10, 1);
			addD5(12, 8);
			addD5(13, 1);
			addD5(22, 2);
			addD5(23, 1);
			addDegL(3, true, 1);
			addDegL(16, true, 5);
			addDegL(22, true, 5);
			persoTM.setResistanceEss(0);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(0);
			persoTM.setResistanceMal(0);
			hist = 5;

		} else if (arg.equals("Ruraux")) {
			rforce = 5;
			ragilite = 0;
			rconstitution = 0;
			rintelligence = 0;
			rintuition = 0;
			rpresence = 0;
			addD5(0, 1);
			addD5(1, 1);
			addD5(2, 1);
			addD5(3, 1);
			addD5(4, 1);
			addD5(5, 1);
			addD5(8, 1);
			addD5(9, 1);
			addD5(10, 1);
			addD5(12, 1);
			addD5(13, 1);
			addD5(14, 1);
			addD5(16, 1);
			addD5(22, 2);
			addD5(23, 1);
			addDegL(22, true, 5);
			persoTM.setResistanceEss(0);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(0);
			persoTM.setResistanceMal(0);
			hist = 5;

		} else if (arg.equals("Urbains")) {
			rforce = 5;
			ragilite = 0;
			rconstitution = 0;
			rintelligence = 0;
			rintuition = 0;
			rpresence = 0;
			addD5(0, 1);
			addD5(5, 1);
			addD5(9, 1);
			addD5(10, 1);
			addD5(13, 1);
			addD5(19, 1);
			addD5(20, 1);
			addD5(22, 1);
			addD5(23, 1);
			addDegL(22, true, 5);
			persoTM.setResistanceEss(0);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(0);
			persoTM.setResistanceMal(0);
			hist = 5;

		} else if (arg.equals("Variags")) {
			rforce = 5;
			ragilite = 0;
			rconstitution = 0;
			rintelligence = 0;
			rintuition = 0;
			rpresence = 0;
			addD5(0, 1);
			addD5(1, 1);
			addD5(5, 2);
			addD5(8, 1);
			addD5(9, 1);
			addD5(10, 1);
			addD5(12, 4);
			addD5(14, 1);
			addD5(16, 1);
			addD5(22, 2);
			addD5(23, 1);
			addDegL(4, true, 3);
			addDegL(20, true, 5);
			addDegL(22, true, 2);
			persoTM.setResistanceEss(0);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(0);
			persoTM.setResistanceMal(0);
			hist = 4;

		} else if (arg.equals("Hommes des Bois")) {
			rforce = 5;
			ragilite = 0;
			rconstitution = 0;
			rintelligence = 0;
			rintuition = 0;
			rpresence = 0;
			addD5(0, 1);
			addD5(1, 1);
			addD5(5, 1);
			addD5(8, 1);
			addD5(9, 1);
			addD5(10, 1);
			addD5(11, 3);
			addD5(14, 4);
			addD5(16, 4);
			addD5(22, 2);
			addD5(23, 1);
			addDegL(10, true, 5);
			addDegL(17, true, 2);
			addDegL(22, true, 2);
			persoTM.setResistanceEss(0);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(0);
			persoTM.setResistanceMal(0);
			hist = 5;

		} else if (arg.equals("Woses")) {
			rforce = 0;
			ragilite = 0;
			rconstitution = 5;
			rintelligence = 0;
			rintuition = 0;
			rpresence = -5;
			addD5(0, 1);
			addD5(1, 3);
			addD5(5, 2);
			addD5(8, 4);
			addD5(10, 1);
			addD5(11, 3);
			addD5(13, 2);
			addD5(14, 4);
			addD5(15, 2);
			addD5(16, 4);
			addD5(22, 3);
			addD5(23, 1);
			addDegL(3, true, 2);
			addDegL(14, true, 5);
			addDegL(22, true, 2);
			persoTM.setResistanceEss(20);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(0);
			persoTM.setResistanceMal(0);
			hist = 5;

		} else if (arg.equals("Orques")) {
			rforce = 5;
			ragilite = -5;
			rconstitution = 15;
			rintelligence = -10;
			rintuition = -10;
			rpresence = -10;
			addD5(0, 1);
			addD5(1, 1);
			addD5(2, 3);
			addD5(3, 2);
			addD5(4, 1);
			addD5(6, 3);
			addD5(8, 1);
			addD5(10, 1);
			addD5(11, 1);
			addD5(13, 2);
			addD5(15, 1);
			addD5(22, 2);
			addDegL(13, true, 5);
			addDegL(22, true, 3);
			persoTM.setResistanceEss(0);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(20);
			persoTM.setResistanceMal(5);
			hist = 2;

		} else if (arg.equals("Uruk-Hai")) {
			rforce = 10;
			ragilite = 0;
			rconstitution = 20;
			rintelligence = 0;
			rintuition = -5;
			rpresence = -10;
			addD5(0, 1);
			addD5(1, 1);
			addD5(2, 3);
			addD5(3, 3);
			addD5(4, 3);
			addD5(5, 4);
			addD5(6, 1);
			addD5(7, 1);
			addD5(8, 1);
			addD5(9, 1);
			addD5(10, 1);
			addD5(11, 1);
			addD5(12, 1);
			addD5(15, 1);
			addD5(22, 3);
			addD5(23, 1);
			addDegL(11, true, 5);
			addDegL(13, true, 4);
			addDegL(22, true, 4);
			persoTM.setResistanceEss(0);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(20);
			persoTM.setResistanceMal(5);
			hist = 2;

		} else if (arg.equals("Semi-Orques")) {
			rforce = 5;
			ragilite = 0;
			rconstitution = 5;
			rintelligence = 0;
			rintuition = 0;
			rpresence = -5;
			addD5(0, 1);
			addD5(1, 1);
			addD5(2, 3);
			addD5(3, 1);
			addD5(4, 1);
			addD5(6, 3);
			addD5(8, 1);
			addD5(9, 1);
			addD5(11, 1);
			addD5(15, 1);
			addD5(22, 2);
			addDegL(11, true, 2);
			addDegL(13, true, 3);
			addDegL(22, true, 5);
			persoTM.setResistanceEss(0);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(10);
			persoTM.setResistanceMal(5);
			hist = 3;

		} else if (arg.equals("Trolls")) {
			rforce = 15;
			ragilite = -10;
			rconstitution = 15;
			rintelligence = -15;
			rintuition = -15;
			rpresence = -10;
			addD5(0, 1);
			addD5(7, 3);
			addD5(8, 1);
			addD5(11, 1);
			addD5(22, 5);
			addDegL(22, true, 4);
			persoTM.setResistanceEss(0);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(30);
			persoTM.setResistanceMal(10);
			hist = 1;

		} else if (arg.equals("Olog-Hai")) {
			rforce = 20;
			ragilite = -5;
			rconstitution = 15;
			rintelligence = -5;
			rintuition = -10;
			rpresence = -10;
			addD5(0, 1);
			addD5(7, 5);
			addD5(8, 2);
			addD5(11, 1);
			addD5(22, 5);
			addD5(23, 1);
			addDegL(11, true, 5);
			addDegL(22, true, 3);
			persoTM.setResistanceEss(0);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(20);
			persoTM.setResistanceMal(10);
			hist = 1;

		} else if (arg.equals("Semi-Trolls")) {
			rforce = 10;
			ragilite = -5;
			rconstitution = 10;
			rintelligence = -5;
			rintuition = -5;
			rpresence = -5;
			addD5(0, 1);
			addD5(1, 1);
			addD5(2, 2);
			addD5(3, 3);
			addD5(4, 4);
			addD5(7, 4);
			addD5(8, 2);
			addD5(11, 1);
			addD5(22, 4);
			addDegL(11, true, 5);
			addDegL(22, true, 3);
			persoTM.setResistanceEss(0);
			persoTM.setResistanceThe(0);
			persoTM.setResistancePoi(15);
			persoTM.setResistanceMal(5);
			hist = 2;

		}

		for (int i = 0; i < choixCompetence.length; i++) {
			int t = (int) temp[i];
			if ((int) degres.get(i) < t) {
				degres.remove(i);
				degres.add(i, t);
			}
		}

		persoTM.setRaceTemp(arg);
		persoTM.setHistT(hist);
		CalculHistorique cal = new CalculHistorique(persoTM, deg, hist);

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

	public ArrayList getDegres5() {
		return degres;
	}

	public static ArrayList getDegres2() {
		return degres2;
	}

	public static ArrayList getInitchkL() {
		return initchkL;
	}

	public static ArrayList getDegL() {
		return degL;
	}

	private void addD5(int arg, int arg2) {
		degres.remove(arg);
		degres.add(arg, arg2);
		deg.remove(arg);
		deg.add(arg, arg2);
	}

	private void addDegL(int arg, boolean bool, int arg2) {
		initchkL.remove(arg);
		initchkL.add(arg, bool);
		degL.remove(arg);
		degL.add(arg, arg2);
	}

}
