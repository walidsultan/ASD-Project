package CreditCard.models;

import framework.Account;
import framework.ICustomer;
import framework.IEntry;

public abstract class CreditCardAccount extends Account {


	public CreditCardAccount(ICustomer customer) {
		super(customer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void notifyCustomer() {
		//Get last entry
		IEntry entry = this.getAllEntries().get(this.getAllEntries().size()-1);
		this.getCustomer().onTransactionChange(this,entry);
	}
}
