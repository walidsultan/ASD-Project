package CreditCard.models;

import framework.ICustomer;

public class Gold extends CreditCardAccount {

	public Gold(ICustomer customer) {
		super(customer);
	}

	@Override
	public double getMonthlyIntrestRate() {
		return 0.06;
	}

	@Override
	public double getMinimumPayment() {
		return 0.1;
	}

}
