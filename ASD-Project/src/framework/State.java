package framework;

import java.util.ArrayList;
import java.util.List;

public class State {
	private List<IAccount> Accounts = new ArrayList<IAccount>();
	private static State _State;

	private State() {

	}

	public static State getInstance() {
		if (_State == null) {
			_State = new State();
		}
		return _State;
	}

	public List<IAccount> getAccounts() {
		return Accounts;
	}

}
