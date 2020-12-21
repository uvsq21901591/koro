
public class TestBreak {

	public static void main(String[] args) {
		
//		for (int i = 0; i < 10; i++) {
//			if ( i == 5 ) {
//				break;
//			}
//			System.out.println( i );
//		}

firstLoop: 
		for (int line = 0; line < 10; line++) {
			for (int column = 0; column < 10; column++) {
				if ( line == 5 && column == 5 ) {
					break firstLoop;
				}
				System.out.println( line + "x" + column );
			}
		}
		
		System.out.println( "Bye bye" );
	}

}
