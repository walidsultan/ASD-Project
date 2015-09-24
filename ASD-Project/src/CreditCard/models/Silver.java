package CreditCard.models;

import framework.ICustomer;

public class Silver extends CreditCardAccount{

	public Silver(ICustomer customer) {
		super(customer);
	}

	@Override
	public double getMonthlyIntrestRate() {
		// TODO Auto-generated method stub
		return 0.08;
	}

	@Override
	public double getMinimumPayment() {
		// TODO Auto-generated method stub
		return 0.12;
	}

}
