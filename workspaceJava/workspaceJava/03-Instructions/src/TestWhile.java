import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestWhile {

	private static BufferedReader keyboard = new BufferedReader(
			new InputStreamReader( System.in )
	);
	
	public static void main(String[] args) throws Exception {

		boolean mustExit = false;
		while( mustExit == false ) {
			System.out.print( "Veuillez saisir une commande : " );
			String command = keyboard.readLine();
			System.out.println( "Traitement de la commande " + command );
			if ( command.equals( "exit" ) ) mustExit = true;
		}

		System.out.println( "Bye bye" );

//		int i = 0;
//		while ( i < 10 ) {
//			System.out.println( i );
//			i += 2;
//		}
		
	}

}
