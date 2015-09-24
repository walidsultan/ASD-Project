package BankApp.models;

import framework.IAccount;
import framework.IEntry;
import framework.Organization;

public class Company extends Organization {
	
	@Override
	public void onTransactionChange(IAccount account, IEntry entry) {

		//Always send email to customer
		System.out.println("Send email to " + this.getName());

	}
}
