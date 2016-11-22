package vueDM;

import modelDM.ChargementDataDM;

public interface DataDM {
	
	ChargementDataDM chargement = new ChargementDataDM();

	String[] choixAvantages = { "05 : Alliés Nv1", "10 : Alliés Nv2", "15 : Alliés Nv3", "20 : Alliés Nv4",
			"05 : Alphabétisation Nv1", "10 : Alphabétisation Nv2", "15 : Alphabétisation Nv3", "05 : Ambidextre",
			"10 : Bon sens", "05 : Bonne réputation Nv1", "10 : Bonne réputation Nv2", "15 : Bonne réputation Nv3",
			"20 : Bonne réputation Nv4", "15 : Chanceux Nv1", "30 : Chanceux Nv2", "60 : Chanceux Nv3",
			"05 : Charisme Nv1", "10 : Charisme Nv2", "15 : Charisme Nv3", "05 : Défense améliorée Nv1",
			"15 : Défense améliorée Nv2", "25 : Défense améliorée Nv3", "15 : Don de la magie Nv1",
			"25 : Don de la magie Nv2", "35 : Don de la magie Nv3", "02 : Don des langues Nv1",
			"04 : Don des langues Nv2", "06 : Don des langues Nv3", "08 : Don des langues Nv4", "15 : Empathie",
			"05 : Empathie animale", "05 : grade Militaire Nv1", "10 : grade Militaire Nv2", "15 : grade Militaire Nv3",
			"20 : grade Militaire Nv4", "25 : grade Militaire Nv5", "30 : grade Militaire Nv6",
			"35 : grade Militaire Nv7", "40 : grade Militaire Nv8", "05 : Contact faible", "10 : Contact moyen",
			"15 : Contact fort", "20 : Contact puissant", "05 : Guérison rapide", "15 : Guérison trés rapide",
			"02 : Intrépide Nv1", "04 : Intrépide Nv2", "06 : Intrépide Nv3", "08 : Intrépide Nv4",
			"05 : Membre des forces de l'Ordre Nv1", "10 : Membre des forces de l'Ordre Nv2",
			"15 : Membre des forces de l'Ordre Nv3", "01 : Musicien né Nv1", "02 : Musicien né Nv2",
			"03 : Musicien né Nv3", "04 : Musicien né Nv4", "05 : Musicien né Nv5", "01 : Nyctalope Nv1",
			"02 : Nyctalope Nv2", "03 : Nyctalope Nv3", "04 : Nyctalope Nv4", "05 : Nyctalope Nv5",
			"05 : Protecteur faible", "10 : Protecteur normale", "15 : Protecteur puissant", "05 : Ordination Nv1",
			"10 : Ordination Nv2", "15 : Ordination Nv3", "10 : Origine inhabituelle", "15 : réflexe aiguisé",
			"10 : résistance à la douleur", "02 : résistance à la magies Nv1", "04 : résistance à la magies Nv2",
			"06 : résistance à la magies Nv3", "08 : résistance à la magies Nv4", "10 : résistance à la magies Nv5",
			"05 : résistance aux poisons", "05 : résistance aux maladies Nv1", "10 : résistance aux maladies Nv2",
			"10 : Richesse Nv1", "20 : Richesse Nv2", "30 : Richesse Nv3", "40 : Richesse Nv4", "50 : Richesse Nv5",
			"10 : Robuste Nv1", "25 : Robuste Nv2", "02 : Sens aiguisés Nv1", "04 : Sens aiguisés Nv2",
			"06 : Sens aiguisés Nv3", "08 : Sens aiguisés Nv4", "10 : Sens aiguisés Nv5", "05 : Sens de l'orientation",
			"15 : Sens du danger", "05 : Souple", "05 : Statut Nv1", "10 : Statut Nv2", "15 : Statut Nv3",
			"20 : Statut Nv4", "25 : Statut Nv5", "15 : Téméraire", "05 : tenace", "05 : Vigilant Nv1",
			"10 : Vigilant Nv2", "15 : Vigilant Nv3", "10 : Voix", "04 : Volonté de fer Nv1", "08 : Volonté de fer Nv2",
			"12 : Volonté de fer Nv3", "16 : Volonté de fer Nv4", };

	String[] choixDesavantages = { "15 : Alcoolique Nv1", "25 : Alcoolique Nv1", "10 : Assoiffé de sang", "10 : Avare",
			"15 : Boiteux", "15 : Borgne", "05 : Code de l'honneur Nv1", "10 : Code de l'honneur Nv2",
			"15 : Code de l'honneur Nv3", "35 : Cul-de-jatte", "15 : Cupide", "05 : Curieux", "05 : Délirant Nv1",
			"10 : Délirant Nv2", "15 : Délirant Nv3", "05 : Dépendant Nv1", "10 : Dépendant Nv2", "15 : Dépendant Nv3",
			"20 : Dépendant Nv4", "10 : Dur d'oreille", "05 : Ennemie faible", "10 : Ennemie moyen",
			"15 : Ennemie fort", "30 : Ennemie puissant", "40 : Ennemie trés puissant...", "08 : Faible volonté Nv1",
			"16 : Faible volonté Nv2", "24 : Faible volonté Nv3", "02 : Fidéle Nv1", "05 : Fidéle Nv2",
			"10 : Fidéle Nv3", "15 : Fidéle Nv4", "20 : Fidéle Nv5", "05 : Franc", "05 : Goinfre", "05 : Gros Nv1",
			"10 : Gros Nv2", "20 : Gros Nv3", "10 : Honnête", "10 : Implusif", "05 : Infériorité sociale Nv1",
			"10 : Infériorité sociale Nv2", "15 : Infériorité sociale Nv3", "20 : Infériorité sociale Nv4",
			"10 : Irritable", "10 : Jaloux", "10 : Lâche", "05 : Maigre", "05 : Manie exaspérante Nv1",
			"10 : Manie exaspérante Nv2", "15 : Manie exaspérante Nv3", "10 : Malchanceux", "20 : Manchot",
			"05 : Mauvaise réputation Nv1", "10 : Mauvaise réputation Nv2", "15 : Mauvaise réputation Nv3",
			"20 : Mauvaise réputation Nv4", "25 : Mauvaise vue", "05 : Obsession Nv1", "10 : Obsession Nv2",
			"15 : Obsession Nv2", "15 : Pacifiste", "10 : Paresseux", "05 : Phobie Nv1", "10 : Phobie Nv2",
			"15 : Phobie Nv3", "05 : Présomptueux", "15 : Primitif", "05 : Protégé Nv1", "10 : Protégé Nv2",
			"15 : Protégé Nv3", "02 : Responsabilité Nv1", "05 : Responsabilité Nv2", "10 : Responsabilité Nv3",
			"15 : Responsabilité Nv4", "05 : Richesse Nv-1", "10 : Richesse Nv-2", "15 : Richesse Nv-3",
			"15 : Séducteur impénitent", "05 : Serment mineur", "10 : Serment important", "15 : Serment majeur",
			"05 : Statut Nv-1", "10 : Statut Nv-2", "15 : Statut Nv-3", "05 : Têtu", "10 : Tyrant", "25 : Unijambiste",

	};

	String choixCompetences[][] = chargement.ChargementComp();
	
	String choixLangues[] = { "10 : Morporkien", "10 : Langrien", "10 : Agateen", "10 : Klachien", "10 : Nain",
			"10 : Troll", "10 : Gobelin", "15 : Nac Mac Feegles", "10 : Xixixixien", "10 : Krullien",
			"10 : Uberwaldien", "10 : Ephebien", "10 : Tsorien" };

	String[] choixPoint = { "25 pts : faible(Zombies, Petit enfants...)", "50 pts : moyen(gens normaux)",
			"75 pts : compétents(Policiers, Athlètes, Nobles...", "100 pts : Exceptionelle(Vétérans, Dirigeants...)",
			"200 pts : Heros(Genies, Millionnaires, Guerriers d'élites..)",
			"300 pts : Légende(Héros barbares, Dieux)" };

	String[] choixMetier = { "Aucun", "Acteur", "Agent du guet", "Alchimistes", "Assassin", "Avocat", "Boulanger",
			"Commerçant", "Contrebandier", "Couturière", "Diplomate", "Fermier", "Fou", "Jardinier", "Journaliste",
			"Mage", "Majordome", "Mendiant", "Militaire", "Mime des rues", "Mineur", "Musicien", "Ouvrier", "Prêtre",
			"Sorcière", "Usurier", "Voleur" };

	String[] choixNat = { "Ankh-Morpork", "Quirm", "Le Village paumé, là-bas", "Langre", "Ephèbe", "Klach", "Agateen",
			"Iksiksiksiks", "Krull", "Gilnéas", "Uberwald", "Omnia", "Jolhimôme", "Pseudopolis" };

	String[] choixRace = { "Humain", "Nain", "Troll", "Gobelin", "Nac Mac Feegle", "Mort-vivant", "Vampire",
			"Loup-garou", "Zombie", "Gnome", "Igor" };

	String[] choixApparence = { "-16 : Monstrueux comme un igor", "-08 : Laid comme un gobelin",
			"-04 : Peu Attirant comme un nain", "00 : Moyen, banal comme la plupart des gens",
			"+04 : Séduisant comme une couturière", "+12 : Beau comme un éphèbe", "+16 : Superbe comme un dieux" };

	String[] choixMagie = chargement.ChargementMagie();
	
	

}


