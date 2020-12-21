import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class IntroductionGenerics {

	
	public static void main(String[] args) {
		
		ArrayList<String> collection = new ArrayList<>();
		collection.add( "toto" );
		collection.add( "titi" );
		collection.add( "tutu" );
		collection.add( "tata" );
		//collection.add( new Date() );
		
		for( String object : collection ) {
			System.out.println( object.toUpperCase() );
		}
		
		ArrayList<Date> dates = new ArrayList<>();
		dates.add( new Date() );
		for( Date date : dates ) {
			System.out.println( date );
		}
		
		HashMap<String, Person> agenda = new HashMap<>();
		agenda.put( "007", new Person( 7, "James", "Bond", "bond@mi6.uk" ) );
		agenda.put( "000", new Person( 0, "Johnny", "English", "zero@mi6.uk" ) );
		
		Person p = agenda.get( "007" );
		System.out.println( p );
	}
	
}
