package fr.koor.agenda;

public class Person /*extends Object*/ {

	private String firstName;
	private String lastName;
	private String email;
	
	public Person() {
		this( "john", "doe", "john.doe@unknown.fr" );
	}
	
	
	public Person( String firstName, String lastName, String email ) {
		//super();
		this.setFirstName( firstName );
		this.setLastName( lastName );
		this.setEmail( email );
	}
	

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		if ( firstName == null || firstName.trim().equals( "" ) ) {
			throw new RuntimeException( "first name cannot be null" );
		}
		this.firstName = firstName.trim().toLowerCase();
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		if ( lastName == null || lastName.trim().equals( "" ) ) {
			throw new RuntimeException( "last name cannot be null" );
		}
		this.lastName = lastName.trim().toUpperCase();
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		if ( email == null || ! email.matches( "^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$" ) ) {
			throw new RuntimeException( "bad email string" );
		}
		this.email = email;
	}


	@Override
	public String toString() {
		return firstName + " " + lastName + ": email=" + email;
	}

	
}
