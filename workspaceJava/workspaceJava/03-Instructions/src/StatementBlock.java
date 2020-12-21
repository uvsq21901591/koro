
public class StatementBlock {

	@SuppressWarnings( "unused" )
	public static void main(String[] args) {
		
		int a = 10;
		System.out.println( a );
		
		{
			int b = 20;
			a++;
			System.out.println( a + " - " + b );
		}
		
		System.out.println( a );
		
		
		for (String string : args) {
			int c = 30;
			System.out.println( string + " - " + c );
		}
		
		boolean condition = true;
		if (condition) {
			int d = 40;
			System.out.println( d );
		} else {
			int e = 50;
		}
		//System.out.println( d + " - " + e );
	}
	
}
