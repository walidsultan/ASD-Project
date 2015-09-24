package CreditCard.models;

import framework.Transaction;

public class Deposit extends Transaction {

	@Override
	public double compute(double totalAmount) {
		return totalAmount+ this.getAmount();
	}

}
