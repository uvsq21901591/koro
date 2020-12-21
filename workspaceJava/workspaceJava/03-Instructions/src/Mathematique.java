
public class Mathematique {

	public static double mini( double a, double b ) {
		if ( a < b ) {
			return a;
		} else {
			return b;
		}
	}
	
	public static double mini2( double a, double b ) {
		return a < b ? a : b;
		//double result = (a < b ? a : b);
		//return result;
	}
	
	
	public static void main(String[] args) {
		System.out.println( mini2( 8.3, 5.7 ) );
	}

}
