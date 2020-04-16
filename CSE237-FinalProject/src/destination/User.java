package destination;

public class User {
	String firstName;
	String lastName;
	
	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getUser() {
		return (this.firstName + " " + this.lastName);
	}
}
