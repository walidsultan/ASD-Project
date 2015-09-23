package BankApp.ui;

import javafx.scene.Node;
import framework.ui.GUIFactory;

public class BankGUIFactory extends GUIFactory {
	@Override
	public Node getHeaderPane() {
		return new BankHeaderPane();
	}
	
	@Override
	public Node getContentPane() {
		return BankContentPane.getInstance();
	}
}
