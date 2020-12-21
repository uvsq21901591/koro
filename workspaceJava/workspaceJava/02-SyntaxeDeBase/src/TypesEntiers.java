
public class TypesEntiers {

	public static void main(String[] args) {
		
		int counter = 10;			// int = integer
		counter ++;
		System.out.println( counter );
		counter --;
		System.out.println( counter );
		
		// Règles pour les nom de variables :  caractères autorisés = lettres + chiffres + _ + $
		int var2 = 100;
		int nom_complexe = 200;		// Déconseillé
		int nom$complexe = 300;		// Déconseillé
		int nomélémentaire = 400;	// Déconseillé
		//int 2essai = 0; 		// On ne peut pas commencer par un chiffre
		int nomComplexe = 500;
		System.out.println( var2 + " - " + nom_complexe + " - " + nom$complexe + " - " + nomélémentaire + " - " + nomComplexe );		
		
		// Les 4 types entiers
		// byte 	- 1 octet		-> -128 .. 127
		byte monOctet = 127;
		System.out.println( monOctet );
		// short 	- 2 octets		-> -32768 .. 32767
		short monShort = 32767;
		System.out.println( monShort );
		// int		- 4 octets
		int monInt = 1_000_000_000;
		System.out.println( monInt );
		// long 	- 8 octets		
		long monLong = 10_000_000_000L;			// L ou l => constant est typée long 
		System.out.println( monLong );
		
		// 4 bases en numérique
		int decimalValue = 10;				// 								10 digits 0 à 9
		System.out.println( decimalValue );
		int binaryValue = 0b101;			// 5 exprimée en binaire 		2 digits 0 et 1
		System.out.println( binaryValue );
		int octalValue = 010;				// 8							8 digits 0 à 7
		System.out.println( octalValue );
		int hexadecimalValue = 0xFF;		// 255							16 digits 0 .. 9 A .. F
		System.out.println( hexadecimalValue );
		
		// Les opérateurs sur valeurs entières :   ++ --        + - * / %            += -= *= /= %=
		int a = 5;
		int b = 3;
		int result = a % b;
		System.out.println( result );
		
		byte b1 = 100;
		byte b2 = 100;
		int sum = b1 + b2;
		System.out.println( sum );
		
		int currentValue = 1;
		currentValue *= 5;				//  currentValue = currentValue * 5
		currentValue *= 5;				//  currentValue = currentValue * 5
		System.out.println( currentValue );		
		
		int value2 = 3;
		int test = value2 / 0;
		System.out.println( test );
		
	}

}
