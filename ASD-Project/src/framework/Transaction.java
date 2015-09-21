package framework;

import java.util.Date;

public abstract class Transaction implements IEntry{
	private Date date;
	private double amount;
	private String details;
}
