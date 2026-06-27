package UTILS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


		 private static final String DB_URL =  "jdbc:sqlserver://DESKTOP-B2QE1JB;databaseName=practicefyp;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
		 
		 public static Connection getConnection() throws SQLException {
		    	Connection conn = null;
		        try {
		            // Load the JDBC driver
		            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            // Create a connection to the database
		            conn = DriverManager.getConnection(DB_URL);
		        } catch (ClassNotFoundException e) {
		            e.printStackTrace();
		        }
		        return conn;

	}

}
