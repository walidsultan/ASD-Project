package framework;

public interface IAccount {
	ICustomer getCustomer();

	double getAmount();

	void setAmount(double amount);

	void addEntry(IEntry entry);
}
