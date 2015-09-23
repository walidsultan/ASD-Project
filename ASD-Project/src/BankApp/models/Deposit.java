package BankApp.models;

import framework.Credit;

public class Deposit extends Credit {

	@Override
	public double compute(double totalAmount) {
		return totalAmount+ this.getAmount();
	}

}
