import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestFor {

	private static BufferedReader keyboard = new BufferedReader(
			new InputStreamReader( System.in )
	);

	public static void main(String[] args) throws Exception {

//		for (int index = 0; index < 10; index++) {
//			System.out.println( index );
//		}
		String command = "";
		
		for( boolean mustExit = false; mustExit == false; mustExit = command.equals( "exit" ) ) {
			System.out.print( "Veuillez saisir une commande : " );
			command = keyboard.readLine();
			System.out.println( "Traitement de la commande " + command );
		}

		System.out.println( "Bye bye" );
	}

}
