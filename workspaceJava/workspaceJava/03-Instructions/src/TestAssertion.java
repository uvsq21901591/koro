
public class TestAssertion {

	public static int fact( int value ) {
		//if ( value < 0 ) throw new IllegalArgumentException( "value must be positive" );
		assert value >= 0 : "value must be positive";
		if ( value <= 1 ) return 1;
		return value * fact( value - 1 );
	}
	
	public static void main( String[] args ) {
		
		//assert args.length == 2;
		//assert args.length == 2 : "Two parameters are required";
		
		long begin = System.currentTimeMillis();
		
		System.out.println( "6! == " + fact( 6 ) );
		for (int i = 0; i < 1_000_000_000; i++) {
			fact( 6 );
		}
		
		long end = System.currentTimeMillis();
		System.out.println( "Duration = " + (end-begin) + " ms" );

	}
	
}
