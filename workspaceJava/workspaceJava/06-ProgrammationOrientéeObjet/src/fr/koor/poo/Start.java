package fr.koor.poo;


public class Start {

	public static void main(String[] args) {
		
		Rational r1 = new Rational( 1, 2);
		Rational r2 = new Rational( 3, 1 );
		Rational result = r1.add( r2 );
		System.out.println( r1 + "+" + r2 + " == " + result );
		System.out.println( r1 + "<" + r2 + " == " + r1.lessThan( r2 ) );
		
//		JButton button = new JButton();
//		button.setText( "toto" );

		Rational r = new Rational( 12, 28 );
		r.simplify();
		System.out.println( r );
		
	}

}
