package BankApp.models;

import framework.Account;
import framework.ICustomer;

public abstract class BankAccount extends Account {
	private String accountNumber;

	public BankAccount(ICustomer customer,String accountNumber) {
		super(customer);
		this.setAccountNumber(accountNumber);
	}

	public void AddInterest() {

	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
