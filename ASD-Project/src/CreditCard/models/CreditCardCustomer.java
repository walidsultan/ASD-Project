package CreditCard.models;

import framework.IAccount;
import framework.IEntry;
import framework.Person;

public class CreditCardCustomer extends Person {
	@Override
	public void onTransactionChange(IAccount account, IEntry entry) {
			if(entry.getAmount()>400 || account.getAmount()<0){
			//Send email
			System.out.println("Send email to " + this.getName());
		}
	}
}
