package CreditCard.commands;

import java.util.Calendar;

import framework.IAccount;
import framework.ICommand;
import framework.IEntry;

public class TransactionCommand implements ICommand {

	private IAccount account;
	private IEntry entry;
	private Double amount;
	public TransactionCommand(IAccount account, IEntry entry, double amount){
		this.account=account;
		this.entry = entry;
		this.amount=amount;
	}
	
	@Override
	public void execute() {
		this.entry.setAmount(amount);
		this.entry.setDate(Calendar.getInstance().getTime());
		this.account.addEntry(this.entry);
	}

}
