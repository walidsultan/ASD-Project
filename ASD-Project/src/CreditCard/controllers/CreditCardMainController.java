package CreditCard.controllers;

import CreditCard.ui.CreditCardGUIFactory;
import framework.MainController;
import framework.ui.IGUIFactory;

public class CreditCardMainController extends MainController {

	@Override
	public IGUIFactory getGUIFactory()
	{
		return new CreditCardGUIFactory();
	}
}
