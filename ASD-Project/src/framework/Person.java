package framework;

public abstract class Person extends Customer implements ICustomer {
	private String birthDate;

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	
}
