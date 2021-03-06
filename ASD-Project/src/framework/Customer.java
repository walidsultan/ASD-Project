package framework;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Customer implements ICustomer {
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;
	public List<IAccount> allAccounts;

	public Customer() {
		this.allAccounts = new ArrayList<IAccount>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void addAccount(IAccount account) {
		this.allAccounts.add(account);
	}

	public StringProperty getNameProperty() {
		return new SimpleStringProperty(this.name);
	}

	public StringProperty getCityProperty() {
		return new SimpleStringProperty(this.city);
	}
}
