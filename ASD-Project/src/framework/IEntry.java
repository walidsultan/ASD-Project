package framework;

import java.util.Date;

public interface IEntry {
	Date getDate();

	void setDate(Date date);

	double getAmount();

	void setAmount(double amount);

	String getDetails();

	void setDetails(String details);

	double compute(double totalAmount);
}
