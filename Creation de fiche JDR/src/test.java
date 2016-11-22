import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelBDD.ConnexionBDD;
import modelBDD.InsertBDD;
import modelJRTM.DataJRTM;


public class test extends JFrame implements DataJRTM{
	
	private static final Logger logger = LogManager.getLogger(test.class.getName());
	
	JTextField textNom = new JTextField();
	JTextField rforce  = new JTextField();
	JTextField ragilite  = new JTextField();
	JTextField rconstitution  = new JTextField();
	JTextField rintelligence  = new JTextField();
	JTextField rintuition  = new JTextField();
	JTextField rpresence   = new JTextField();
	JTextField ResistanceEss   = new JTextField();
	JTextField ResistanceThe   = new JTextField();
	JTextField ResistancePoi   = new JTextField();
	JTextField ResistanceMal    = new JTextField();
	JTextField hist     = new JTextField();
	
	JTextField[] comp = new JTextField[choixCompetence.length];
	JTextField[] lang = new JTextField[choixLangues.length];
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new test();
		//CreationBase();
	}
	
	public test() {
		
		JPanel container = new JPanel();
		JPanel containerNom = new JPanel();
		JPanel containerComp = new JPanel();
		JPanel containerLangue = new JPanel();
		JPanel containerGen = new JPanel();
		
		
		
		JButton bouton = new JButton("save");
		
		JScrollPane scroll = new JScrollPane(containerComp);
		scroll.getVerticalScrollBar().setUnitIncrement(20);
		scroll.setPreferredSize(new Dimension(300, 280));
		
		JScrollPane scroll2 = new JScrollPane(containerLangue);
		scroll2.getVerticalScrollBar().setUnitIncrement(20);
		scroll2.setPreferredSize(new Dimension(300, 280));
	
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(" test");
		this.setSize(500, 600);
		this.getContentPane().add(container);
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		containerNom.setLayout(new GridLayout(4, 4));
		containerNom.add(new JLabel("Nom de la race : "));
		containerNom.add(textNom);
		containerNom.add(new JLabel("rforce : "));
		containerNom.add(rforce);
		containerNom.add(new JLabel("ragilite : "));
		containerNom.add(ragilite);
		containerNom.add(new JLabel("rconstitution : "));
		containerNom.add(rconstitution);
		containerNom.add(new JLabel("rintelligence : "));
		containerNom.add(rintelligence);
		containerNom.add(new JLabel("rintuition : "));
		containerNom.add(rintuition);
		containerNom.add(new JLabel("rpresence : "));
		containerNom.add(rpresence);
		containerNom.add(new JLabel("ResEss : "));
		containerNom.add(ResistanceEss);
		containerNom.add(new JLabel("ResThe : "));
		containerNom.add(ResistanceThe);
		containerNom.add(new JLabel("ResPoi : "));
		containerNom.add(ResistancePoi);
		containerNom.add(new JLabel("ResMal : "));
		containerNom.add(ResistanceMal);
		containerNom.add(new JLabel("hist : "));
		containerNom.add(hist);			
		container.add(containerNom);
		container.add(new JLabel(" "));
		
		containerComp.setLayout(new BoxLayout(containerComp, BoxLayout.Y_AXIS));
		
		for(int i = 0; i < choixCompetence.length; i++){
			JPanel containerC = new JPanel();
			
			containerC.setLayout(new BoxLayout(containerC, BoxLayout.X_AXIS));
			containerC.add(new JLabel(" " + i + " : " + choixCompetence[i]));
			comp[i] = new JTextField("0");
			containerC.add(comp[i]);
			containerComp.add(containerC);
		}
		
		containerLangue.setLayout(new BoxLayout(containerLangue, BoxLayout.Y_AXIS));
		for(int i = 0; i < choixLangues.length; i++){
			JPanel containerL = new JPanel();
			
			containerL.setLayout(new BoxLayout(containerL, BoxLayout.X_AXIS));
			containerL.add(new JLabel(" " + i + " : " + choixLangues[i]));
			lang[i] = new JTextField("0");
			containerL.add(lang[i]);
			containerLangue.add(containerL);
		}
		
		containerGen.setLayout(new BoxLayout(containerGen, BoxLayout.X_AXIS));
		containerGen.add(scroll);
		containerGen.add(scroll2);
		container.add(containerGen);
		
		container.add(bouton);
		
		bouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Run();
			}
		});
		
		// affichage à faire	
		this.setVisible(true);
	}
	
	public void Run(){
		
		InsertBDD insert = new InsertBDD();
		
		String query = " INSERT INTO raceJRTM (nom, rforce, ragilite, rconstitution, rintelligence, "
				+ "rintuition, rpresence, ResistanceEss, ResistanceThe, ResistancePoi,  ResistanceMal, hist) "
				+ "VALUES ('" + textNom.getText() + "', " + rforce.getText() + ", " + ragilite.getText() + ", "
				+ rconstitution.getText() + ", " + rintelligence.getText() + ", " + rintuition.getText() + ", "
				+ rpresence.getText() + ", " + ResistanceEss.getText() + ", " + ResistanceThe.getText() + ", " 
				+ ResistancePoi.getText() + ", " + ResistanceMal.getText() + ", " + hist.getText() + ")";
		
		insert.GetInsert(query);
		String strC = "";
		String strC1 = "";
		for(int i = 0; i < choixCompetence.length; i++){
			strC1 = strC1 + ", comp" + i;
			strC = strC + ", " + comp[i].getText();
		}
		
		int pos = InitIDComp();
		String query2 = " INSERT INTO raceCompJRTM (id" + strC1 + ") VALUES (" + pos + strC + ")";		
		
		insert.GetInsert(query2);
		
		String strL = "";
		String strL1 = "";	
		for(int i = 0; i < choixLangues.length; i++){
			strL1 = strL1 + ", langue" + i;
			strL = strL + ", " + lang[i].getText();		
		}
		
		String query3 = " INSERT INTO raceLangueJRTM (id" + strL1 + ") VALUES (" + pos + strL + ")";
		
		insert.GetInsert(query3);
		
		
		System.out.println(" Save ok !");
	}
	
	private int InitIDComp() {

		// recup de l'id de la derniere entré dans le tableau

		String requete = "SELECT * FROM raceJRTM";
		int out = 0;

		try {
			Statement state = ConnexionBDD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet result = state.executeQuery(requete);
			
			while (result.next()) {
				if(result.getInt("id") > out) {out = result.getInt("id");}
			}
			result.close();
			state.close();
		} catch (Exception e) {
			logger.error(e);
		}
		System.out.println(" out : " + out);
		return out;
	}
	
	public static void CreationBase() {
		
		InsertBDD insert = new InsertBDD();
		
		//String requete = "CREATE TABLE raceJRTM (ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), nom VARCHAR(20), rforce SMALLINT, ragilite SMALLINT, rconstitution SMALLINT, rintelligence SMALLINT, rintuition SMALLINT, rpresence SMALLINT, ResistanceEss SMALLINT, ResistanceThe SMALLINT, ResistancePoi SMALLINT,  ResistanceMal SMALLINT, hist SMALLINT)";
		String requete = "DELETE FROM raceJRTM WHERE id = 1";
		
		insert.GetInsert(requete);
		System.out.println("ok");
		
	}

	

}

/*
  
 CREATE TABLE raceJRTM (ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), nom VARCHAR(20), rforce SMALLINT, 
ragilite SMALLINT, rconstitution SMALLINT, rintelligence SMALLINT, rintuition SMALLINT, rpresence SMALLINT, ResistanceEss SMALLINT, 
ResistanceThe SMALLINT, ResistancePoi SMALLINT,  ResistanceMal SMALLINT, hist SMALLINT)

CREATE TABLE raceCompJRTM (ID INT PRIMARY KEY NOT NULL, comp0 SMALLINT, comp1 SMALLINT, comp2 SMALLINT
, comp3 SMALLINT, comp4 SMALLINT, comp5 SMALLINT, comp6 SMALLINT, comp7 SMALLINT, comp8 SMALLINT, comp9 SMALLINT, comp10 SMALLINT
, comp11 SMALLINT, comp12 SMALLINT, comp13 SMALLINT, comp14 SMALLINT, comp15 SMALLINT, comp16 SMALLINT, comp17 SMALLINT, comp18 SMALLINT
, comp19 SMALLINT, comp20 SMALLINT, comp21 SMALLINT, comp22 SMALLINT, comp23 SMALLINT, comp24 SMALLINT)

CREATE TABLE raceLangueJRTM (ID INT PRIMARY KEY NOT NULL, langue0 SMALLINT, langue1 SMALLINT, langue2 SMALLINT, langue3 SMALLINT, 
langue4 SMALLINT, langue5 SMALLINT, langue6 SMALLINT, langue7 SMALLINT, langue8 SMALLINT, langue9 SMALLINT, langue10 SMALLINT, 
langue11 SMALLINT, langue12 SMALLINT, langue13 SMALLINT, langue14 SMALLINT, langue15 SMALLINT, langue16 SMALLINT, langue17 SMALLINT, 
langue18 SMALLINT, langue19 SMALLINT, langue20 SMALLINT, langue21 SMALLINT, langue22 SMALLINT)  


  
  
  */
 
