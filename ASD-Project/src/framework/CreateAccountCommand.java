package framework;

public class CreateAccountCommand implements ICommand {
	private IAccount _Account;

	public CreateAccountCommand(IAccount account) {
		_Account = account;
	}

	@Override
	public void execute() {
		State.getInstance().getAccounts().add(_Account);
	}

}
