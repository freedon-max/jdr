package modelBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class InsertBDD {
	
	private static final Logger logger = LogManager.getLogger(InsertBDD.class.getName());
	
	public InsertBDD(){
		
	}
	
	public void GetInsert(String query) {

		try {
			Connection conn = ConnexionBDD.getInstance();
			Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			PreparedStatement prepare = conn.prepareStatement(query);
			prepare.executeUpdate();
			prepare.close();
			state.close();

		} catch (Exception e) {
			logger.error(e);
		}

	}
	
	public void GetSaveOK() {
		JOptionPane jop1;
		jop1 = new JOptionPane();
		jop1.showMessageDialog(null, "Sauvegarde OK", "Information", JOptionPane.INFORMATION_MESSAGE);
	}

}
