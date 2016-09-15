package main;

import java.sql.*;

/**
 * Database handler class used to simplify connect to a database and sent query commands
 * @author	Christopher Simon
 * @version	1.0
 */
public class Database {
	// The connection handler
	Connection c = null;
	// The statement query
	Statement query;
	// The sql to execute
	String sql = "";
	// The parameters to bind to the sql
	String sqlParams = "";

	/**
	 * Establish a connection to the db given a file path
	 *
	 * @param dbPath	The database file path
	 */
	public Database(String dbPath) {
		try {
			// Initialize the driver class
			Class.forName("org.sqlite.JDBC");
			// Establish a connection to the db
			c = DriverManager.getConnection("jdbc:sqlite:" + dbPath);

			// Create and prepare the statement
			query = c.createStatement();
			sql = (
				"CREATE TABLE COMPANY ("								+
					"ID		INT	    PRIMARY KEY			NOT NULL,	"	+
					"NAME					TEXT		NOT NULL,	"	+
					"AGE					INT		    NOT NULL,	"	+
					"ADDRESS                CHAR(50),				"	+
					"SALARY					REAL					"	+
				")"
			);
			// Execute the statement
			query.executeUpdate(sql);
			query.close();
			//c.close();
		} catch(ClassNotFoundException | java.sql.SQLException e) {
			// Error. Print the class name and error message
			String className = e.getClass().getName();
			String message = e.getMessage();
			System.err.printf("%s: %s", className, message);
		}
	}


	public void execute(String sql) {
		if(c != null) {
			try {
				c.createStatement();
			} catch(Exception e) {

			}
		}
	}
}