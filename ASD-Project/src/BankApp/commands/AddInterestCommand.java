package BankApp.commands;

import framework.IAccount;
import framework.ICommand;
import framework.State;

public class AddInterestCommand implements ICommand {

	@Override
	public void execute() {

		for(IAccount account: State.getInstance().getAccounts()){
			account.setAmount( Math.round(account.getAmount()*10+account.getAmount())*.1);
		}
	}

}
