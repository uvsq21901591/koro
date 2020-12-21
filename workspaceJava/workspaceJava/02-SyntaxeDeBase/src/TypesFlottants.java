public class TypesFlottants {

	public static void main(String[] args) {
		
		float f1 = 3.6f;
		double f2 = 3.141592654;
		
		System.out.println( f1 + " - " + f2 );
		
		// - 2 formes de représentations de flottants 
		double first = 1.234;			// Syntaxe classique
		double second = 1234e-3;		// Notation exponentielle ( mantisse - exposant)
		System.out.println( first + " - " + second );
		
		// Attention petit piège : division entière calcule un entier
		double result = 1.0 / 3;			// + - * /
		System.out.println( result );
		
		// Valeurs possibles
		double essai1 = 3.1415;
		double essai2 = Double.POSITIVE_INFINITY; // 3 / 0.0;
		double essai3 = Double.NaN; 			  // 0.0 / 0.0;
		
		System.out.println( essai1 + " - " + essai2 + " - " + essai3 );
		
		float fl1 = 3.6f;
		float fl2 = Float.NaN;
		float fl3 = Float.NEGATIVE_INFINITY;
		
		System.out.println( Float.isFinite( fl1 ) );
		System.out.println( Float.isFinite( fl2 ) );
		System.out.println( Float.isFinite( fl2 ) );

		System.out.println( Float.isInfinite( fl1 ) );
		System.out.println( Float.isInfinite( fl2 ) );
		System.out.println( Float.isInfinite( fl3 ) );
		
		System.out.println( Float.isNaN( fl1 ) );
		System.out.println( Float.isNaN( fl2 ) );
		System.out.println( Float.isNaN( fl3 ) );
	
	}
	
}
