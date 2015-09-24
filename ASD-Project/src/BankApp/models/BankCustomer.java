package BankApp.models;

import framework.IAccount;
import framework.IEntry;
import framework.Person;

public class BankCustomer extends Person {
	@Override
	public void onTransactionChange(IAccount account, IEntry entry) {
			if(entry.getAmount()>500 || account.getAmount()<0){
			//Send email
			System.out.println("Send email to " + this.getName());
		}
	}
}
