import java.util.regex.Pattern;

public class RegExpPerf {
	
	private static Pattern emailPattern = Pattern.compile( "^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$" ); 
	private static Pattern datePattern = Pattern.compile( "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)?([0-9]{2})" ); 
	

	public static boolean isValidDateOld( String date ) {				// jj/mm/aaaa    jj/mm/aa
		String regExp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)?([0-9]{2})";
		return date.matches( regExp );
	}
	
	public static boolean isValidDate( String date ) {				// jj/mm/aaaa    jj/mm/aa
		return datePattern.matcher( date ).matches();
	}

	
	public static boolean isValidEmailOld( String email ) {
		String regExp = "^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$";
		return email.matches( regExp );
	}
	
	public static boolean isValidEmail( String email ) {
		return emailPattern.matcher( email ).matches();
	}
	
	public static void main(String[] args) {
		
		long begin = System.currentTimeMillis();
		
		for( int i=0; i<1_000_000; i++ ) {
			isValidEmail( "dominique@societe.com" );
		}
		
		long end = System.currentTimeMillis();
		System.out.println( "Duration : " + (end-begin) + "ms" );
	}
	
}
