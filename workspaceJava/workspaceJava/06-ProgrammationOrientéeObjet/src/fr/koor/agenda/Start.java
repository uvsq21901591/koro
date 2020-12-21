package fr.koor.agenda;

import java.util.ArrayList;

public class Start {

	public static void main(String[] args) {
		
//		Person james = new Person( "James", "Bond", "007@mi6.uk" );
//		System.out.println( james );
//		
//		Object emp = new Employee( "jason", "bourne", "jb@cia.com", 10_000 );
//		System.out.println( emp.toString() );
//		
//		Client whiteHouse = new Client( "White", "House", "whitehouse@gov.com", 1 );
//		System.out.println( whiteHouse );
		
		// ------------------------------------------------------
		
//		Person [] persons = new Person[3];
//		persons[0] = new Person();
//		persons[1] = new Employee( "jason", "bourne", "jb@cia.com", 10_000 );
//		persons[2] = new Client( "James", "Bond", "007@mi6.uk", 152 );

		ArrayList<Person> persons = new ArrayList<>();
		persons.add( new Person() );
		persons.add( new Employee( "jason", "bourne", "jb@cia.com", 10_000 ) );
		persons.add( new Client( "James", "Bond", "007@mi6.uk", 152 ) );
		
		// Je traite toutes les personnes 
		for (Person person : persons) {
			System.out.println( person );
		}
		
		System.out.println( "--------------------------" );
		
		// Je traite que les employés
		for (Person person : persons) {
			if ( person instanceof Employee ) {
				System.out.println( person );
			}
		}
	}
	
}
