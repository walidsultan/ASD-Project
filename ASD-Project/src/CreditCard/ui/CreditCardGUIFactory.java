package CreditCard.ui;

import javafx.scene.Node;
import framework.ui.GUIFactory;

public class CreditCardGUIFactory extends GUIFactory {
	@Override
	public Node getHeaderPane() {
		return new CreditCardHeaderPane();
	}
	
	@Override
	public Node getContentPane() {
		return CreditCardContentPane.getInstance();
	}
	
	@Override
	public Node getRightPane() {
		return new CreditCardRightPane();
	}
}
