
class Rational {
	int numerator;
	int denominator;
}


public class Mathematiques {
	
	public static int mini( final int a, final int b ) {
		return a<b ? a : b;
	}

	public static int maxi( final int a, final int b ) {
		return a>b ? a : b;
	}

	public static int power( final int value, final int pow ) {
		int accumulator = 1;
		
		for (int i = 0; i < pow; i++) {
			accumulator *= value;
		}
		
		return accumulator;
	}
	
	public static int pgcd( int first, int second ) {
		while( second != 0 ) {
			int rest = first % second;
			first = second;
			second = rest;
		}
		return first;
	}
	
	public static void simplify( final Rational r ) {
		int divisor = pgcd( maxi(r.numerator, r.denominator), mini(r.numerator, r.denominator) );
		r.numerator /= divisor;
		r.denominator /= divisor;
	}
	
	
	public static void main( String [] args ) {
		
		System.out.println( "mini( 3, 5 ) == " + mini( 3, 5 ) );
		System.out.println( "mini( 11, 5 ) == " + Mathematiques.mini( 11, 5 ) );
		System.out.println( "maxi( 3, 5 ) == " + maxi( 3, 5 ) );
		
		System.out.println( "power( 2, 0 ) == " + power( 2, 0 ) );		// 1
		System.out.println( "power( 2, 1 ) == " + power( 2, 1 ) );		// 2
		System.out.println( "power( 2, 2 ) == " + power( 2, 2 ) );		// 4
		System.out.println( "power( 2, 3 ) == " + power( 2, 3 ) );		// 8

		//System.out.println( 3*7*11 );
		System.out.println( "pgcd( 3*7*11*13, 2*3*7*11 ) == " + pgcd( 3*7*11*13, 2*3*7*11 ) );
		int first = 3*7*11*13;
		int second = 2*3*7*11;
		System.out.println( "pgcd( 3*7*11*13, 2*3*7*11 ) == " + pgcd( first, second ) );
		System.out.println( first + " - " + second );
		
		Rational r = new Rational();
		r.numerator = 3*7*11*13;
		r.denominator = 2*3*7*11;
		Mathematiques.simplify( r );
		System.out.printf( "[%d/%d]\n", r.numerator, r.denominator );		// [13/2]
		
		return;
	}

}
