package framework;

public class Organization extends Customer implements IOrganization {
	private String numberOfEmployees;

	public String getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(String numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}
}
