package jp.start;

public class Str {
	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLAST_NAME(String lastName) {
		this.lastName = lastName;
	}

	public Str(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
