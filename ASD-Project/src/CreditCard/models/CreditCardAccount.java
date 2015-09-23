package CreditCard.models;

import framework.Account;
import framework.ICustomer;
import framework.IEntry;

public abstract class CreditCardAccount extends Account {

	private String CCNumber;
	private String ExpDate;

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

	public String getCCNumber() {
		return CCNumber;
	}

	public void setCCNumber(String cCNumber) {
		CCNumber = cCNumber;
	}

	public String getExpDate() {
		return ExpDate;
	}

	public void setExpDate(String expDate) {
		ExpDate = expDate;
	}
}
