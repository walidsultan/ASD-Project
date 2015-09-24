package framework;

import java.util.List;

public interface IAccount {
	ICustomer getCustomer();

	double getAmount();

	void setAmount(double amount);

	void addEntry(IEntry entry);
	
	public List<IEntry> getAllEntries();
}
