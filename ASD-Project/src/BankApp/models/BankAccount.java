package BankApp.models;

import framework.Account;
import framework.ICustomer;
import framework.IEntry;

public abstract class BankAccount extends Account {
	private String accountNumber;

	public BankAccount(ICustomer customer,String accountNumber) {
		super(customer);
		this.setAccountNumber(accountNumber);
	}


	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	@Override
	public void notifyCustomer() {
		//Get last entry
		IEntry entry = this.getAllEntries().get(this.getAllEntries().size()-1);
		this.getCustomer().onTransactionChange(this,entry);
	}
}
