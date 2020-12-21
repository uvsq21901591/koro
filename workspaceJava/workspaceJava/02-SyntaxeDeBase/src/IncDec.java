
public class IncDec {

	public static void main(String[] args) {
		
		int a = 10;
		System.out.println( ++a );		// préfixé => incrément est effectué avant utilisation de la variable
		
		a = 10;
		System.out.println( a++ );		// postfixé => incrément est effectué après utilisation de la variable
		System.out.println( a );
		
		int part1 = 10;
		int part2 = 20;
		int result = ++part1 + ++part2;
		System.out.println( result + " - " + part1 + " - " + part2 );
		
	}

}
