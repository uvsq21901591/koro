
public class Binary {

	public static void main(String[] args) {
		
		for( int i=0; i<16; i++ ) {
			String str = Integer.toBinaryString( i );
			while( str.length() < 4 ) str = "0" + str;
			System.out.println( str );
		}
		
		int value1 = 0b10101010;
		int value2 = 0b00001111;
		
		// & (AND)   | (OR)    ^ (XOR)    ~ (NOT)
		System.out.println( "NOT - " + Integer.toBinaryString( ~value1 ) );
		System.out.println( "AND - " + Integer.toBinaryString( value1 & value2 ) );
		System.out.println( "OR  - " + Integer.toBinaryString( value1 | value2 ) );
		System.out.println( "XOR - " + Integer.toBinaryString( value1 ^ value2 ) );
		
		// << (left shift)    >> (right shift)
		System.out.println( "<<  - " + Integer.toBinaryString( value2 << 2 ) + " [" + value2 + " -> " + (value2 << 2) + "]");
		System.out.println( ">>  - " + Integer.toBinaryString( value2 >> 2 ) + " [" + value2 + " -> " + (value2 >> 2) + "]");
			
		// &=    |=    ^=     >>=    <<=
		value1 <<= 2;				//   value1 = value1 << 2;
		System.out.println( "<<  - " + Integer.toBinaryString( value1 ) );
		
	}
	
}
