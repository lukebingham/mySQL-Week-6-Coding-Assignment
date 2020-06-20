package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

	private final static String connectionString = "jdbc:mysql://localhost:3306/football";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "root1234";
	private static Connection connection;
	private static DBconnection instance;
	
	private DBconnection(Connection connection) {
		this.connection = connection;
	}
	
	public static Connection getConnection() {
		if (instance == null) {
			try {
				connection = DriverManager.getConnection(connectionString, USERNAME, PASSWORD);
				instance = new DBconnection(connection);
				//System.out.println("You are successfully connected!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return DBconnection.connection;
	}
}


