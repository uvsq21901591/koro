import java.util.ArrayList;

public class MyArrays {

	public static void main( String [] args ) {
		
//		int [] firstArray = new int[5];
//		firstArray[0] = 10;
//		firstArray[1] = 20;
//		firstArray[2] = 30;
//		firstArray[3] = 40;
//		firstArray[4] = 50;
//		
//		for( int value : firstArray ) {
//			System.out.println( value );
//		}
//		
//		int [] secondArray = { 100, 200, 300, 400, 500 };
//		//secondArray[5] = 0;
//		for (int value : secondArray) {
//			System.out.println( value );
//		}
//		
//		boolean [] thirdArray = new boolean[4];
//		thirdArray[1] = true;
//		for (boolean b : thirdArray) {
//			System.out.println( b );
//		}
//		
//		String [] values = { "azerty", "qwerty", "autre" };
//		System.out.println( values.length );
//		for (String string : values) {
//			System.out.println( string.toUpperCase() );
//		}
		
//		System.out.println( args.length );
//		for (String string : args) {
//			System.out.println( string );
//		}
		
		ArrayList<String> coll = new ArrayList<>();
		coll.add( "azerty" );
		coll.add( "qwerty" );
		System.out.println( coll.size() );
		for (String string : coll) {
			System.out.println( string );
		}
	}
}
