
public class TypeCharacter {

	public static void main(String[] args) {
		
		// Attention entre chaîne de caractères (") et caractère (')
		String theStr = "Une chaine de caractères \u03a0";		// Un ensemble de caractères	
		char theChar = 'a';								// Un unique caractère
		System.out.println( theStr + " vs " + theChar );
		
		// La syntaxe est héritée de C => on retrouve les mêmes séquences pour certains caractères spéciaux.
		char retourALaLigne = '\n';
		char tabulation = '\t';			// '\0'
		System.out.println( "BEGIN" + retourALaLigne + "MIDDLE" + tabulation + "END" );

		// En Java, on utilise UNICODE et non ASCII (American Standard Coding for Information Interchange).
		// En ASCII (ou dérivé : ISO-8859-1), 1 caractère = 1 octet en mémoire => 256 caractères au maximum
		// En UNICODE, 1 caractère = 2 octets en mémoire => On peut utiliser des milliers de caractères.
		// Pour info, regardez ce site : https://unicode-table.com/fr		
		char piMaj = '\u03a0';
		//char piMin = '\u03c0';			// Codification en hexadécimal
		char piMin = 960;					// Codification en décimal
		System.out.println( piMaj + " - " + piMin );

		// Des méthodes statiques vous sont proposées pour tester vos caractères.
		boolean isDigit = Character.isDigit( theChar );
		System.out.println( isDigit );
		boolean isLetter = Character.isLetter( piMaj );
		System.out.println( isLetter );
		boolean isUpperCaseLetter = Character.isUpperCase( piMin );
		System.out.println( isUpperCaseLetter );

	}
	
}
