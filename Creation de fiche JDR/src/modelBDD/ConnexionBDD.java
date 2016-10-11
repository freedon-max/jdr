package modelBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnexionBDD {
	

	// permet de faire une seule connexion au serveur.

	private static final Logger logger = LogManager.getLogger(ConnexionBDD.class.getName());
	private static String url = "jdbc:derby:db//BaseJDR;user=APP";
	
	private static Connection connect;

	public static Connection getInstance() {

		if (connect == null) {
			try {
				Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
				connect = DriverManager.getConnection(url);
			} catch (SQLException e) {
				logger.error(e);
			} catch (ClassNotFoundException e) {
				logger.error(e);
			}
		}
		logger.debug("Connexion ok");
		return connect;
	}

}
