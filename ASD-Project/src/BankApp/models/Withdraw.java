package BankApp.models;

import framework.Transaction;

public class Withdraw extends Transaction {

	@Override
	public double compute(double totalAmount) {
		return totalAmount - this.getAmount();
	}

}
