package framework;

import java.util.List;

public interface ICustomer {
	public String getName();

	public void setName(String name);

	public String getStreet();

	public void setStreet(String street);

	public String getCity();

	public void setCity(String city);

	public String getState();

	public void setState(String state);

	public String getZip();

	public void setZip(String zip);
	
	public void onTransactionChange(IAccount account, IEntry entry);
	
	
}
