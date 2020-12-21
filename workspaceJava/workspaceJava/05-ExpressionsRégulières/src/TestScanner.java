import java.util.InputMismatchException;
import java.util.Scanner;


public class TestScanner {

	public static void main(String[] args) throws Exception {

//		try ( Scanner scanner = new Scanner( System.in ) ) {
//			System.out.print( "Veuillez saisir votre login: " );
//			String login = scanner.nextLine();
//			System.out.print( "Veuillez saisir votre mot de passe: " );
//			String password = scanner.nextLine();
//			if ( login.equalsIgnoreCase( "bond" ) && password.equals( "007" ) ) {
//				System.out.println( "Your are connected");
//			} else {
//				System.out.println( "Who are you?" );
//			}
//			
//			System.out.print( "How many spies are you killed: " );
//			int count = scanner.nextInt();
//			if ( count > 100 ) {
//				System.out.println( "You are a great spy!!!" );
//			}
//		}

		
//		ProcessBuilder processBuilder =new ProcessBuilder( "ifconfig" );
//		processBuilder.redirectErrorStream(true);
//		try ( Scanner scanner = new Scanner( processBuilder.start().getInputStream() ) ) {
//		    while( scanner.hasNext() ) {
//			    String line = scanner.nextLine();
//			    if ( line.length() > 0 && line.charAt( 0 ) != ' ' ) System.out.println( line );
//		    }
//		    System.out.println( "-------------------------------------\nBye bye" );
//		}


		try ( Scanner scanner = new Scanner( System.in ) ) {
			System.out.print( "Enter an IP address, a double value and an email: " );
			
			try {
				String ip = scanner.next( "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}" );
				System.out.println( "IP address == " + ip );
				
			} catch ( InputMismatchException e ) {
				System.out.println( "Bad input" );
				System.exit( -1 );
			}
			
			double value = scanner.nextDouble();
			System.out.println( "double == " + value );

			String email = scanner.next( "[\\w.-]+@[\\w.-]+\\.[a-z]{2,}" );
			System.out.println( "email == " + email );
		}
		
		
//		try ( Scanner scanner = new Scanner( System.in ) ) {
//			scanner.useDelimiter( "[,;]" );
//			while( scanner.hasNext() ) {
//				String part = scanner.next();
//				System.out.println( part );
//			}
//			System.out.println( "Bye bye" );
//		}
		
		
	}
		
}
