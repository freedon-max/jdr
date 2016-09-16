package modelJRTM;

public interface DataJRTM {
	
	public String[] choixRace = {"Béornides", "Corsaires", "Dorwinrim", "Dûnedain", "Dunlendings", "Easlerlings", "Haradrim", "Hommes des Bois", "Lossoth", "Nûménoréens Noirs", "Rohirrim", "Ruraux", "Urbains", "Variags", "Woses", "Nains", "Umli", "Semi-Elfes", "Elfes Noldor", "Elfes Sindar", "Elfes Sylvains", "Hobbits", "Orques Communs", "Uruk-Hai", "Semi-Orques", "Trolls Normaux", "Olog-Hai", "Semi-Trolls"};
	public String[] choixCheveux = {"Brun", "Blond"};
	public String[] choixYeux = {"Marron", "Bleu"};
	public String[] choixProfession = {"Guerrier (FO)", "Scout (AG)", "Mage (IN)", "Animiste (IT)", "Ranger (CO)", "Barde (PR)"};
	public String[] choixRoyaume = {"Ëssenliel", "Théurgie"};
	public String[] choixAttitude = {"Att 1", "Att 2"};
	public String[] choixSigne = {"Signe 1", "Signe 2"};
	public String[] choixLangues = {"Adûnaic", "Apysaic", "Atliduk", "Dunael", "Haradaic", "Nûmenoréens", "Khuzdul", "Kuduk", "Labba", "Logathig", "Nahaiduk", "Noir parler", "Uruk-hai", "Orque", "Ptkael", "Quenya", "Rohirric", "Sindarin", "Sylvain", "Umitic", "Varadiâ", "Waildyth", "Wêstron" };
	public String[] choixCompetence = {"Sans armures", "Cuir souple", "Cuir rigide", "Cotte de mailles", "Plates", "Tranchantes 1 main", "Contondantes 1 main", "Armes de lancé", "Projectiles", "Armes d’Hast" , "Escalade", "Equitation", "Natation", "Pistage", "Embuscades", "Filat/dissim.", "Crochetage", "Désarmement pièges", "Lecture des Runes", "Utilisation d’objets", "Direction de sorts", "Dévelop. corporel", "Perception", "Sorts de base"};                  
	public boolean[] intiComp = {false, false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
	public int[] init5D = {2, 3, 5, 7, 9, 10, 10, 10, 10, 10 ,10 ,10, 10, 10 ,10 ,10 ,10 ,10 ,10 ,10 ,10 ,10, 10, 10};
	static String[] niveau = {"1 niveau", "2 niveau", "3 niveau", "4 niveau", "5 niveau", "6 niveau", "7 niveau", "8 niveau", "9 niveau", "10 niveau"};

}
