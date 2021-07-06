package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDao {

	
	private static final String DRIVER = "org.postgresql.Driver";

	private static final String URL = "jdbc:postgresql:postgres";
	
	private static final String USER = "postgres";

	private static final String PASSWORD = "postgres";

	protected Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
		return con;
	}

}
