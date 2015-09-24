package framework;

import java.util.ArrayList;
import java.util.List;

public class State implements IState {
	private List<IAccount> Accounts = new ArrayList<IAccount>();

	private List<ICustomer> Customers = new ArrayList<ICustomer>();
	private static IState _State;

	private State() {

	}

	public static IState getInstance() {
		if (_State == null) {
			_State = new State();
		}
		return _State;
	}

	
	@Override
	public List<IAccount> getAccounts() {
		return Accounts;
	}

	@Override
	public List<ICustomer> getCustomers() {
		return Customers;
	}

}
