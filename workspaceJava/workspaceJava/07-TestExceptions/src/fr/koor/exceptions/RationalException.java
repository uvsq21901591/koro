package fr.koor.exceptions;

public class RationalException extends Exception {

	private static final long serialVersionUID = 6677487610288558193L;

	public RationalException() {
		this( "Denominator cannot be nul" );
	}

	public RationalException(String message) {
		super( message );
	}
	
	// Other methods
	
}
