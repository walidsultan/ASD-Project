package framework;

import framework.ui.ContentPane;
import framework.ui.GUIFactory;
import framework.ui.IGUIFactory;
import framework.ui.RightPane;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class MainController extends BaseController {
	@FXML
	private GridPane mainGrid;

	private IGUIFactory guiFactory;

	@FXML
	private void initialize() {
		mainGrid.add(guiFactory.getHeaderPane(), 1, 0);
		mainGrid.add(guiFactory.getRightPane(), 3, 1);
		mainGrid.add(guiFactory.getContentPane(), 1, 1);
	}

	public MainController() {
		this.guiFactory= getGUIFactory();
	}
	
	public IGUIFactory getGUIFactory()
	{
		return new GUIFactory();
	}
}
