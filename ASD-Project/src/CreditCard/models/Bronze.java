package CreditCard.models;

import framework.ICustomer;

public class Bronze extends CreditCardAccount {

	public Bronze(ICustomer customer) {
		super(customer);
	}

	@Override
	public double getMonthlyIntrestRate() {
		return 0.1;
	}

	@Override
	public double getMinimumPayment() {
		return 0.14;
	}

}
