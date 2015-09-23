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
	public void onTransactionChange() {
		//Get last transaction
		IEntry entry= this.allEntries.get(this.allEntries.size()-1);
		if(entry.getAmount()>500 || entry.getAmount()<0){
			//Send email
			System.out.println("Send email to " + this.getName());
		}
	}
}
