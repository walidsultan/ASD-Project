package BankApp.models;

import framework.Debit;

public class Withdraw extends Debit {

	@Override
	public double compute(double totalAmount) {
		return totalAmount - this.getAmount();
	}

}
