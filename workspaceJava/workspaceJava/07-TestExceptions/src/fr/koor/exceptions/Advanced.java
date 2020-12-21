package fr.koor.exceptions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Advanced {
	
	
	public static void exportData() throws SQLException, IOException {
		try ( Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost/WebStore", "login", "pass" ) ;
			  FileOutputStream fos = new FileOutputStream( "save.xml" ) ) {

		} catch( SQLException | IOException exception ) {
			System.out.println( "Partial handling - in my catch block" );
			throw exception;
		}
	}
	
	
	public static void main(String[] args) {
		try {
			exportData();
		} catch (SQLException | IOException e) {
			System.out.println( "End handling" );
		}
	}

}
