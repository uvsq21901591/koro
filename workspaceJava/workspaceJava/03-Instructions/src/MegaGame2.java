import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MegaGame2 {

	private static BufferedReader keyboard = new BufferedReader(
			new InputStreamReader( System.in )
	);

	public static void main(String[] args) throws Exception {
		System.out.println( "Welcome to MegaGame V1.0 - 2017" );
		
		while( true ) {
			int value = 1 + (int) (Math.random() * 100);		//  1 <= value <= 100
			System.out.println( "Random value == " + value );
			
			int score = 0;
			
			while ( true ) {
				
				System.out.print( "Veuillez saisir une valeur (1 .. 100 ) : " );
				int editedValue = Integer.parseInt( keyboard.readLine() );
				score ++;
				
				if ( editedValue == value ) {
					break;
				} else if ( editedValue < value ) {
					System.out.println( "La valeur à trouver est plus grande que " + editedValue );
				} else if ( editedValue > value ) {
					System.out.println( "La valeur à trouver est plus petite que " + editedValue );
				}
				
			}
	
			System.out.println( "Bravo, vous avez trouvé en " + score + " coup(s)." );
			System.out.print( "Voulez-vous recommencer (oui/non) : " );
			String retry = keyboard.readLine();
			if ( retry.equalsIgnoreCase( "non" ) ) {
				break;
			}
		}
		
		System.out.println( "Bye bye" );
	}

}
