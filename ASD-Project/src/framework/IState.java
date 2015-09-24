package framework;

import java.util.List;

public interface IState {

	public abstract List<IAccount> getAccounts();

	public abstract List<ICustomer> getCustomers();

}