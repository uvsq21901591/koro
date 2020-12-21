
public class TypeString {

	public static void main(String[] args) {
		
		String message = "This is a String with Unicode characters (\u03c0)";
		System.out.println( message );
		
		// --- Des opérateurs permettent de manipuler vos chaînes de caractères ----------------------------------------------------
		String start = "Start";
		start = start + " After";			// Attention la concaténation de String peut couter chère.
		start += " End";					// Les classes StringBuffer et StringBuilder peuvent être plus efficaces (prochain tuto).
		System.out.println( start );
		
		
		// --- La classe String (son nom commence par une majuscule) propose un certain nombre de méthodes -------------------------
		// ATTENTION : une chaîne de caractères est immutable. Il est impossible de changer son contenu.
		//			   Mais on peut produire une nouvelle chaîne de caractères à partir d'une autre
		String upper = message.toUpperCase();
		System.out.println( upper );
		String lower = message.toLowerCase();
		System.out.println( lower );
		System.out.println( message );
		
		String subPart = message.substring( 22, 29 );
		System.out.println( subPart + "!" );
		
		String [] parts = message.split( " " );
		for (String str : parts) {
			System.out.print( str + " - " );
		}
		System.out.println();
		
		String replacement = message.replace( "String", "Truc" );
		System.out.println( replacement );
		
		
		// --- Pour transformer des chaînes de caractères en nombres et des nombres en chaînes : ------------------------------------
		String strValue = "123";
		int value = Integer.parseInt( strValue );
		strValue = "3.141592654";
		double value2 = Double.parseDouble( strValue );
		System.out.println( value + " - " + value2 );
		
		String finalString = value + "";
		finalString += " ";							
		finalString += Double.toString( value2 );						// Encore une fois attention aux concaténations
		System.out.println( finalString );
		
		String strFinal2 = String.format( "%05d [%05.2f]", value, value2 );		// Les différents formats seront vus dans un prochain tuto
		System.out.println( strFinal2 );
		
		// --- Attention aux comparaisons de chaînes de caractères -------------------------------------------------------------------
		String str1 = "toto";
		String str2 = "tata";
		String str3 = "toto";
		System.out.println( str1 == str2 );		// Comme çà on pourrait croire que çà marche, mais il y a une optimisation sur les constantes.
		System.out.println( str1 == str3 );		// Ce qui est comparé se sont les adresses des deux objets en mémoire.
		
		String half = "To";
		String str4 = half + half;
		System.out.println( str1 + " - " + str4 + " => " + (str1 == str4) );	// Les pointeurs en mémoire sont des adresses différentes.
		System.out.println( str1.equals( str4 ) );								// Les deux chaines ont un contenu identique.
		System.out.println( str1.equalsIgnoreCase( str4 ) );
		
	}	
}
