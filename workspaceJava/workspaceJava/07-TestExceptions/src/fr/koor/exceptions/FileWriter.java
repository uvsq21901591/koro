package fr.koor.exceptions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//class Demo implements AutoCloseable {
//	
//	public Demo() {
//		System.out.println( "Ressource instanciée" );
//	}
//	
//	@Override
//	public void close() throws Exception {
//		System.out.println( "Ressource libérée" );	
//	}
//	
//}

public class FileWriter {

	public static void saveDataTryWithResources() {
		
		try ( FileOutputStream fos = new FileOutputStream( "save.data" )  ) {
			
			fos.write( "Ok 3".getBytes() );
			
		} catch( Exception e ) {
			e.printStackTrace();
		}
		
		System.out.println( "Ecriture terminée (TWR)" );
	}
	
	
	public static void saveDataFinally() {
		
		FileOutputStream fos = null;
		try {
		
			fos = new FileOutputStream( "save.data" );
			fos.write( "Ok 2".getBytes() );
			
		} catch ( IOException exception ) {
			
			exception.printStackTrace();
			
		} finally {
			
			//System.out.println( "In the finally bloc" );
			if ( fos != null ) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
			
		}
		
		System.out.println( "Ecriture terminée" );
	}
	
	
	public void connectToDatabase() {
		try ( Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost/WebStore", "login", "pass" ) ) {
			String sql = "Select * from T_Users where login=?";
			try ( PreparedStatement statement = connection.prepareStatement( sql ) ) {
				statement.setString( 1, "bond" );
				try ( ResultSet resulSet = statement.executeQuery() ) {
					// TODO
				}
			}
		} catch( SQLException exception ) {
			exception.printStackTrace();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		//saveDataFinally();
		saveDataTryWithResources();
	}

}
