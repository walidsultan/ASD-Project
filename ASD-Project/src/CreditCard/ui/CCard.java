package CreditCard.ui;

import CreditCard.controllers.CreditCardMainController;
import framework.BaseController;
import framework.ui.FinCo;

public class CCard extends FinCo {
	@Override
	public String getAppTitle() {
		return "Credit Card App";
	}

	public static void main(String[] args) {
		AppName="CreditCard";
		launch(args);
	}

	@Override
	public BaseController getController()
	{
		return new CreditCardMainController();
	}
}
