package fr.koor.poo;

public class Rational {

	// Des attributs de la classe Rational
	private int numerator /*= 0*/;
	private int denominator /*= 1*/;
	
	
	public Rational() {
		this( 0, 1 );
		//this.setNumerator( 0 );
		//this.setDenominator( 1 );
	}
		
	public Rational( int numerator, int denominator ) {
		this.setNumerator( numerator );
		this.setDenominator( denominator );
	}
	

	public int getNumerator() {
		return this.numerator;
	}
	
	public void setNumerator(int numerator) {
		// contraintes
		this.numerator = numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	public void setDenominator(int denominator) {
		if ( denominator == 0 ) {
			throw new RuntimeException( "denominator cannot be null" );
		}
		this.denominator = denominator;
	}

	public Rational add( Rational r2 ) {
		return new Rational(
				this.numerator * r2.denominator + this.denominator * r2.numerator,
				this.denominator * r2.denominator
		);
	}
	
	// TODO : sub mult div
	
	public boolean lessThan( Rational r2 ) {
		return this.numerator*r2.denominator < this.denominator * r2.numerator;
	}
	
	// TODO : le gt ge eq ne
	
	public void simplify() {
		int divisor = pgcd( Math.max(this.numerator, this.denominator), Math.min(this.numerator, this.denominator) );
		this.numerator /= divisor;
		this.denominator /= divisor;
	}
	
	@Override
	public String toString() {
		return String.format( "[%d/%d]", this.numerator, this.denominator );
	}
	
	
	private static int pgcd( int first, int second ) {
		while( second != 0 ) {
			int rest = first % second;
			first = second;
			second = rest;
		}
		return first;
	}

}
