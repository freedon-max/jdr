package vueChtullu;

public interface DataChtullu {
	

	String[] choixMetier = {"Aucun", "Antiquaire", "Artiste", "Artiste de cabaret", "Athlete", "Avocat", "Criminel", "Detective prive", "Dilettante", "Ecrivain", "Fantassin", "Fermier", "Guerrier tribal", "Ingenieur", "Inspecteur de police", "Journaliste", "Medecin", "Missionnaire", "Musicien", "Officier", "Parapsychologue", "Pecheur", "Policier", "Pretre", "Proffesseur", "Revolutionnaire", "Vagabond"};
	String[] competence = {"Anthropologie", "Archéologie", "Art", "Art Martiaux", "Astronomie", "Baratin", "Bibliothéque", "Camouflage", "Chimie", "Comptabilité", "Conduire Auto", "Conduire Engin Lourd", "Crédit", "Discrétion", "Dissimulation", "Droit", "Ecouter", "Electricité", "Esquiver (DEX*2%)", "Géologie", "Grimper", "Histoire", "Histoire Naturel", "Lancer", "Langues Etrangéres", "Langue Natale (EDU*5%)", "Marchandage", "Mecanique", "Médecine", "Monter à Cheval", "Mythe de Chtullu", "Nager", "Navigation", "Occultisme", "Persuasion", "Pharmacoogie", "Photographie", "Physique", "Piloter", "Permiers Soins", "Psychanalyse", "Psychologie", "Sauter", "Se Cacher", "Serrurerie", "Suivre une Piste", "Trouver Objet Caché", "Arme de Poing", "Fusil", "Fusil de Chasse", "Mitrailette", "Mitrailleuse", "Coup de Pied", "Coup de Poing", "Coup de Tête", "Lutte", "Eloquence", "DessinerCarte", "Chanter", "Botanique", "Pickpocket", "SoignerEmpoisonnement", "SoignerMaladie"};
	
	String[] langue = {"Aucun", "Français", "Anglais", "Allemand", "Latin", "Espagnole", "Japonnais", "Chinoix", "Russe"};
	String[] armeCC = {" ", "Petit couteau             25%        1D4 + BD    -            -            9", 
									"Couteau de boucher        25%        1D6 + BD    -            -            12",
									"Poignard                  25%        1D4+2+BD    -            -            15",
									"Petit gourdin             25%        1D6 + BD    -            -            15",
									"Grand Gourdin             25%        1D8 + BD    -            -            20",
									"Hache de bucheron         20%        1D8+2+BD    -            -            15",
									"Hachette/Faucille         20%        1D6+1+BD    -            -            12",
									"Canne épee                20%        1D6 + BD    -            -            10",
									"Rapière/Epée lourde       10%        1D6+1+BD    -            -            15",
									"Sabre de cavalerie        15%        1D8+1+BD    -            -            20",
									"Nerf de boeuf             40%        1D8 + BD    -            -            4",
									"Garrot/Corde de piano     15%        �tranglement-            -            1",
									"Fouet                      5%        1D3         3            -            4",
									"Lance de cavalerie        10%        1D8+1+BD    3            -            15",
									};
	
	
	String[] armeFeu = {" ","Pistolet Auto cal 22   20%        1D6        10            6            6",
									"Derringer cal 25       20%        1D6         3            5            5",
									"Revolver cal 32        20%        1D8        15            6            10",
									"Pistolet Auto cal 32   20%        1D8        15            8            8",
									"Revolver cal38 ou 9mm  20%        1D10       15            6            10",
									"Pistolet Auto cal 38   20%        1D10       15            6            8",
									"Luger P08              20%        1D10       20            8            9",
									"Revolver cal 45        20%        1D10+2     15            6            10",
									"Pistolet Auto cal 45   20%        1D10+2     15            7            8",
									"Fusil cal 22           25%        1D6+2      30            6            9",
									"Carabine cal 30        25%        2D6        50            6            8",
									"Fusil à Eléphant(2C)   15%        3D6+4     100            2            12",
									"Calibre 12 (pompe)     30%     4D6/1D6/1D4  10/20/50       5            10",
									"Thompson       		15%        1D10+2     20           33             8",
									"Fusil auto Browning    15%        2D6+4      90          200            11",
									};
		
	String[] Psy = {"Aucun", "Arachnophobe", "Agoraphobe", "Claustrophobe", "Pyrophobie","Scotophobie", "Clinophobe", "Acrophobe", "Ailurophobe"};  //page 52
	
	final int[] competenceInitt = { 0, 0, 5, 0, 0, 5, 25, 0, 0, 10, 20, 0, 15, 10, 15, 5, 25, 10, 0, 0, 40, 20, 10, 25,
			0, 0, 5, 20, 5, 5, 0, 25, 10, 5, 15, 0, 10, 0, 0, 30, 0, 5, 25, 10, 0, 10, 25, 20, 25, 30, 15, 15, 25, 50,
			10, 25, 0, 0, 0, 0, 0, 0, 0 };
	
	String[] diplomeP = { "Aucun", "Certificat d'étude", "Brevet", "Bac", "Ingenieur", "Master", "maitre de conf" };
	
	String[] nationnaliteP = { "Français", "Allemand", "Anglais", "Irlandais", "italien", "Espagnole", "Hollandais",
			"Belge", "Portugais", "Suisse", "Autrichien", "Polonais", "Russe", "Suédois", "Finlandais", "Norvégiens",
			"Hongrois", "Roumain", "Techquoslovaque", "Egyptien", "Ethiopien", "Congolain", "Sud affricain",
			"Sénégalain", "Arabe", "Syrien", "Turque", "Iraquien", "Iranien", "Afgan", "Grecque", "Indonésien",
			"Chinois", "Coréen", "Japonais", "Indou", "Mongolien", "Tibetien", "Americain", "Canadien", "Mexicain",
			"Colombien", "Argentien", "Brezilien", "Vénézuelien", "Australien", "Neozélandais", "Haïtien", "Iselandais",
			"Cubain", "Arménien", "Bolivien", "Bulgare", "Chilien", "Danois", "Georgien", "Luxembourgeois", "Panamien",
			"Péruvien", "Ukrainien", "Yemenien", "Tripolitien", "Palatien", "Koubanais", "Rhonan" };
	
}
