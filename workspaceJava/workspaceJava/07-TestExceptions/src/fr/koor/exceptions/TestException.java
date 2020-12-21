package fr.koor.exceptions;

import java.io.FileOutputStream;
import java.util.Scanner;

public class TestException {

	public static void method3() {
		System.out.println( "BEGIN method3" );

		while( true ) {
			try {
				FileOutputStream fos = new FileOutputStream( "save.data" );
				fos.write( "Ok\n".getBytes() );
				fos.close();
				break;
			} catch( Exception exception ) {
				System.out.println( "Problème d'écriture. Voulez-vous recommencer : " );
				Scanner scanner = new Scanner( System.in );
				String response = scanner.nextLine().trim();
				if ( response.equalsIgnoreCase( "non" ) ) {
					break;
				}
				scanner.close();
			}
		}
		System.out.println( "END method3" );
	}

	public static void method2() {
		System.out.println( "BEGIN method2" );
		method3();
		System.out.println( "END method2" );
	}
	
	public static void method1() {
		System.out.println( "BEGIN method1" );
		method2();
		System.out.println( "END method1" );
	}

	public static void main(String[] args) {
		System.out.println( "BEGIN main" );
		method1();
		System.out.println( "END main" );
	}

}
