package BankApp.controllers;

import BankApp.ui.BankGUIFactory;
import framework.MainController;
import framework.ui.IGUIFactory;

public class BankMainController extends MainController {

	@Override
	public IGUIFactory getGUIFactory()
	{
		return new BankGUIFactory();
	}
}
