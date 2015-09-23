package framework;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;

public abstract class Account implements IAccount {
	private ICustomer customer;
	private double amount;

	private List<IEntry> _Entries;
	
	public Account(ICustomer customer) {
		this.customer = customer;
		this._Entries= new ArrayList<IEntry>();
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
	
	public void addEntry(IEntry entry)
	{
		this._Entries.add(entry);
		this.amount = entry.compute(this.amount);
		notifyCustomer();
	}

	public SimpleStringProperty getAmountProperty() {
		return new SimpleStringProperty(Double.toString(this.amount));
	}
	
	public abstract void notifyCustomer();
	
}
