package framework;

public abstract class Account implements IAccount {
	private ICustomer customer;
	private double amount;

	public Account(ICustomer customer) {
		this.customer = customer;
	}

	public ICustomer getCustomer() {
		return customer;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
