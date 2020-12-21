import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestSwitch {

	static BufferedReader keyboard = new BufferedReader( new InputStreamReader( System.in ) );

	public static void main(String[] args) throws Exception {
		
		int value = (int) (Math.random() * 10); // 0 ≤ value ≤ 9
		
		switch( value ) {
			case 0:
				System.out.println( "Zéro" );
				break;
			case 1:
				System.out.println( "Un" );
				break;
			case 2:
				System.out.println( "Deux" );
				break;
			default:
				System.out.println( "Autre" );
				break;
		}

		
		System.out.println( "Veuillez saisir une commande : " );
		String cmd = keyboard.readLine();
		switch( cmd ) {
			case "ls":
				System.out.println( "On image un ls" );
				break;
			case "clear":
				System.out.println( "On image un clear" );
				break;
			default:
				System.out.println( "Commande inconnue" );	
		}
	}

}
