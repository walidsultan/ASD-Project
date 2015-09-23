package BankApp.models;

import framework.ICustomer;

public class CheckingAccount extends BankAccount {

	public CheckingAccount(ICustomer customer,String accountNumber) {
		super(customer,accountNumber);
	}

}
