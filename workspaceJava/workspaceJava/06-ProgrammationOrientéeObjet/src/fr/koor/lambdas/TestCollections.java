package fr.koor.lambdas;

import java.util.ArrayList;
import java.util.List;

public class TestCollections {

	public static void main(String[] args) throws Exception {
		
		List<String> languages = new ArrayList<>();
		languages.add( "Visual basic" );
		languages.add( "c" );
		languages.add( "python" );
		languages.add( "Java" );
		languages.add( "c++" );
		
		//Predicate<String> pred = (s) -> s.length() <= 4;
		//languages.stream().filter( pred ).forEach( System.out::println );
		languages.stream().filter( (s) -> s.length() > 4 ).forEach( System.out::println );
		
		/*Collections.sort( languages, new Comparator<String>() {
			@Override
			public int compare(String l1, String l2) {
				return l1.compareToIgnoreCase( l2 );
			}
		} );*/
		languages.sort( (l1, l2) -> l1.compareToIgnoreCase( l2 ) );
		//languages.sort( (l1, l2) -> { return l1.compareToIgnoreCase( l2 ); } );
		
		
		/*for (String string : languages) {
			System.out.println( string );
		}*/
		//languages.forEach( System.out::println );
		
	}
	
}
