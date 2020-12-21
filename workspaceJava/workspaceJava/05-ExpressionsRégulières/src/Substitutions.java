import java.util.regex.Pattern;

public class Substitutions {

	public static void main(String[] args) {
		
		// --- Scrambling personal number --- 
		String myPhone = "01 02 03 04 05";
		System.out.println( myPhone.replaceAll( "\\d", "x" ) );
		System.out.println( myPhone.replaceFirst( "\\d\\d", "xx" ) );
		
		// --- Replace multiple separators by only one space ---
		String str = "This    is    \t   	a string  with\tmultiple 	\n		separators";
		System.out.println( str.replaceAll( "\\s{2,}", " " ) );
		
		Pattern separatorsPattern = Pattern.compile( "\\s+" );
		System.out.println( separatorsPattern.matcher( str ).replaceAll( " " ) );
		
		
		// --- Avoid XSS (Cross Site Scripting) attacks on a Java EE server ---
		String requestParameter 
				= "Begin\n"
				+ "<Script type='text/javascript'>document.location.href='http://koor.fr'</Script>\n"
				+ "<script type='text/javascript'>\n"
				+ "    window.alert( 'ok' );\n"
				+ "</script>\n"
				+ "End\n";
		
	    Pattern xssPattern = Pattern.compile("<script[^>]*>(.*?)</script>", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
	    String safeParam = xssPattern.matcher( requestParameter ).replaceAll( "" );
	    safeParam = separatorsPattern.matcher( safeParam ).replaceAll( " " );
	    System.out.println( safeParam );
		
	    // --- Bold some words in an HTML stream ---
	    String message = "This is an HTML content injected in a html tag";
	    Pattern boldPattern = Pattern.compile( "(html)", Pattern.CASE_INSENSITIVE );		// CAUTION : ()
		System.out.println( boldPattern.matcher( message ).replaceAll( "<b>$1</b>" ) );
		
	}
	
}
