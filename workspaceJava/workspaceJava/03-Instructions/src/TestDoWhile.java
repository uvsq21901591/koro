import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestDoWhile {

	private static BufferedReader keyboard = new BufferedReader(
			new InputStreamReader( System.in )
	);
	
	public static void main(String[] args) throws Exception {
		
		String command = "";
		do {
			System.out.print( "Veuillez saisir une commande : " );
			command = keyboard.readLine();
			System.out.println( "Traitement de la commande " + command );
		} while ( ! command.equals( "exit" ) );

		System.out.println( "Bye bye" );
		
	}

}
