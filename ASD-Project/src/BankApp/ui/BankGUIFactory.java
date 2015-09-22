package BankApp.ui;

import javafx.scene.layout.Pane;
import framework.ui.GUIFactory;

public class BankGUIFactory extends GUIFactory {
	@Override
	public Pane getHeaderPane() {
		return new BankHeaderPane();
	}
}
