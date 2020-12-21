package fr.koor.exceptions;

public class RationalStart {

	public static void main(String[] args) throws RationalException {
		
		//try {
			
			Rational r1 = new Rational( 1, 3 );
			Rational r2 = new Rational( 2, 0 );
			
			System.out.println( r1.add( r2 ) );
			
//		} catch( RationalException exception ) {
//			
//			System.out.println( "Problème rencontré" );
//			
//		}
	}
	
}
