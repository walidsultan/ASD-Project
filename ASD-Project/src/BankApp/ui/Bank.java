package BankApp.ui;

import BankApp.controllers.BankMainController;
import framework.BaseController;
import framework.ui.FinCo;

public class Bank extends FinCo {
	@Override
	public String getAppTitle() {
		return "Bank App";
	}

	public static void main(String[] args) {
		AppName="BankApp";
		launch(args);
	}

	@Override
	public BaseController getController()
	{
		return new BankMainController();
	}
}
