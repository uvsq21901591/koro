
public class RegExpMatching {
	

	public static boolean isValidDate( String date ) {				// jj/mm/aaaa    jj/mm/aa
		//String regExp = "^\\d\\d/\\d\\d/\\d\\d(\\d\\d)?$";
		//String regExp = "^[0-9]{2}/[0-9]{2}/[0-9]{2}([0-9]{2})?$";
		String regExp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)?([0-9]{2})";
		return date.matches( regExp );
	}
	
	public static boolean isValidEmail( String email ) {
		//String regExp = "^.+@.+\\..+$";
		//String regExp = "^[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.[a-z][a-z]+$";
		//String regExp = "^[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.[a-z]{2,}$";
		String regExp = "^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$";
		return email.matches( regExp );
	}
	
	
	public static void main(String[] args) {
		
//		// --- Good Emails ---
//		System.out.println( isValidEmail( "dominique.liard_06@infini-software.com" ) );
//		System.out.println( isValidEmail( "martin@societe.com" ) );
//		System.out.println( isValidEmail( "martin@societe.fr" ) );
//		
//		System.out.println( "-----------------------------" );
//		
//		// --- Bad Emails ---
//		System.out.println( isValidEmail( "martin@societe.f" ) );
//		System.out.println( isValidEmail( "martin.societe.com" ) );
//		System.out.println( isValidEmail( "martin@societe" ) );
//		System.out.println( isValidEmail( "@@@.@" ) );
//		
//		System.out.println( "-----------------------------" );
		
		// --- Good Dates ---
		System.out.println( isValidDate( "30/05/2017" ) );
		System.out.println( isValidDate( "30/05/17" ) );
		
		// --- Bad Dates ---
		System.out.println( isValidDate( "00/10/1999" ) );
		System.out.println( isValidDate( "36/10/1999" ) );
		System.out.println( isValidDate( "26/00/1999" ) );
		System.out.println( isValidDate( "26/13/1999" ) );
		System.out.println( isValidDate( "30/05/017" ) );
		System.out.println( isValidDate( "30/5/17" ) );
		System.out.println( isValidDate( "3/05/17" ) );
		System.out.println( isValidDate( "martin@societe.com" ) );
		System.out.println( isValidDate( "jj/mm/aaaa" ) );


		
		
	}
	
}
