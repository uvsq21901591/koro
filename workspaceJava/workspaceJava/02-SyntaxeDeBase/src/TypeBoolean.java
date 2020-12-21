
public class TypeBoolean {

	public static void main(String[] args) {
		
		boolean state1 = true;
		System.out.println( state1 );
		
		boolean state2 = false;
		System.out.println( state2 );

		// --- Attention : Java est différent de C -> un booléen n'est pas un entier !
//		//int state = 1;		// Associé à true (en C)
//		boolean state = true;
//		while( state ) {
//			System.out.println( "Boucle" );
//		}
	
		// --- Opérateurs booléens : && (and)	|| (or)		! (not)  ---
		
		if ( state1 && state2 ) {
			System.out.println( "Les deux variables sont initialisées à true" );
		}

		if ( state1 || state2 ) {
			System.out.println( "L'une des deux variables est initialisée à true" );
		}
		
		if ( state1 == false ) {			// if ( state1 == false ) {
			System.out.println( "state1 est initialisée à false");
		}

		if ( ! state2 ) {			// if ( state2 == false ) {
			System.out.println( "state2 est initialisée à false");
		}

	}

}
