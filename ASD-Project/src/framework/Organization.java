package framework;

public class Organization extends Customer implements IOrganization {
	private String numberOfEmployees;

	public String getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(String numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public void onTransactionChange() {

		//Always send email to customer
		System.out.println("Send email to " + this.getName());

	}
}
