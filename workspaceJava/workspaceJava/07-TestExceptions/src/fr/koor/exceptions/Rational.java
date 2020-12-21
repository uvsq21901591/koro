package fr.koor.exceptions;

public class Rational {

	private int numerator;
	private int denominator;
	
	
	public Rational()  {
		this.numerator = 0;
		this.denominator = 1;
	}
		
	public Rational( int numerator, int denominator ) throws RationalException {
		this.setNumerator( numerator );
		this.setDenominator( denominator );
	}
	

	public int getNumerator() {
		return this.numerator;
	}
	
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	public void setDenominator(int denominator) throws RationalException {
		if ( denominator == 0 ) {
			throw new RationalException( "Denominator cannot be nul !!!!!" );
		}
		this.denominator = denominator;
	}

	public Rational add( Rational r2 ) throws RationalException {
		return new Rational(
				this.numerator * r2.denominator + this.denominator * r2.numerator,
				this.denominator * r2.denominator
		);
	}
	
	public boolean lessThan( Rational r2 ) {
		return this.numerator*r2.denominator < this.denominator * r2.numerator;
	}
	
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
