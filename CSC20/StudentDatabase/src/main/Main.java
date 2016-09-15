package main;

public class Main {
    public static void main(String[] args) {
    	// Create an instance of the DB handler to manage the student database
        Database db = new Database("test.sqlite");

		// First, insert the new list from the text file
		// if their ids are not already in the db
		db.execute(
			"INSERT INTO COMPANY (ID, NAME, AGE, ADDRESS, SALARY)"
		);
    }
}