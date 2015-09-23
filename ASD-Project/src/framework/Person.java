package framework;

public class Person extends Customer implements ICustomer {
	private String birthDate;

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public void onTransactionChange(IAccount account, IEntry entry) {
			if(entry.getAmount()>500 || account.getAmount()<0){
			//Send email
			System.out.println("Send email to " + this.getName());
		}
	}
}
